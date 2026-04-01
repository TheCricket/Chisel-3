package chisel.events;

import chisel.Chisel;
import chisel.registry.ChiselBlocks;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterCommandsEventHandler {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("chisel")
                        .executes(command -> {
                            CommandSourceStack source = command.getSource();
                            ServerLevel level = source.getLevel();
                            ServerPlayer player = source.getPlayerOrException();
                            BlockPos pos = player.blockPosition();

                            List<Block> blocks = new ArrayList<>();
                            ChiselBlocks.getBlocks().forEach(block -> block.getFamily().getVariants().forEach(variant -> blocks.add(variant.getBlock())));

                            int blocksPerRow = (int) Math.ceil(Math.sqrt(blocks.size()));
                            int x = 0, z = 0;

                            for(int c = 0; c < blocks.size(); c++) {
                                Block block = blocks.get(c);
                                BlockState state = block.defaultBlockState();

                                int baseX = pos.getX() + (x * 2);
                                int baseZ = pos.getZ() + (z * 2);
                                int y = pos.getY();

                                BlockPos place = new BlockPos(baseX, y, baseZ);

                                level.setBlock(place, state, Block.UPDATE_ALL);
                                level.setBlock(place.east(), state, Block.UPDATE_ALL);
                                level.setBlock(place.south(), state, Block.UPDATE_ALL);
                                level.setBlock(place.east().south(), state, Block.UPDATE_ALL);

                                x++;
                                if(x >= blocksPerRow) {
                                    x = 0;
                                    z++;
                                }
                            }

                            source.sendSuccess(() -> Component.literal(String.format("Placed %s different variants", blocks.size())), true);

                            return 1;
                        })
        );
    }
}
