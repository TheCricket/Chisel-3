package chisel.events;

import chisel.Chisel;
import chisel.registry.ChiselBlocks;
import net.minecraft.client.Minecraft;
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

                            if(Minecraft.getInstance().isOfflineDeveloperMode()) {

                                List<Block> blocks = new ArrayList<>();
                                ChiselBlocks.getBlocks().forEach(block -> block.getFamily().getVariants().forEach(variant -> blocks.add(variant.getBlock())));

                                int blocksPerRow = (int) Math.ceil(Math.sqrt(blocks.size()));
                                int x = 0, z = 0;

                                for (Block block : blocks) {
                                    BlockState state = block.defaultBlockState();

                                    int baseX = pos.getX() + (x * 4);
                                    int baseZ = pos.getZ() + (z * 4);
                                    int baseY = pos.getY();

                                    for (int ox = 0; ox < 3; ox++) {
                                        for (int oy = 0; oy < 3; oy++) {
                                            for (int oz = 0; oz < 3; oz++) {
                                                level.setBlock(new BlockPos(baseX + ox, baseY + oy, baseZ + oz), state, Block.UPDATE_ALL);
                                            }
                                        }
                                    }

                                    x++;
                                    if (x >= blocksPerRow) {
                                        x = 0;
                                        z++;
                                    }
                                }

                                source.sendSuccess(() -> Component.literal(String.format("Placed %s different variants", blocks.size())), true);
                            } else {
                                source.sendFailure(Component.literal("You must be in developer mode to use this command!"));
                            }
                            return 1;
                        })
        );
    }
}
