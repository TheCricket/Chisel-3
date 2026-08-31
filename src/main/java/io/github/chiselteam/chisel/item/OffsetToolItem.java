package io.github.chiselteam.chisel.item;

import io.github.chiselteam.chisel.family.VariantFamilyLookup;
import io.github.chiselteam.ctm.api.texture.CTMOffsetDataManager;
import io.github.chiselteam.ctm.network.CTMOffsetSyncPacket;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jspecify.annotations.NonNull;

import java.awt.geom.Line2D;
import java.util.*;
import java.util.function.Consumer;

public class OffsetToolItem extends Item {
    public OffsetToolItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        BlockState state = context.getLevel().getBlockState(pos);
        if (VariantFamilyLookup.getFamilyForBlock(state.getBlock(), context.getLevel().registryAccess()) != null) {
            if (context.getLevel().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                Direction facing = context.getClickedFace();
                Vec3 hit = context.getClickLocation();
                Direction moveDir = getMoveDir(facing, hit.x - pos.getX(), hit.y - pos.getY(), hit.z - pos.getZ());

                ChunkPos chunkPos = new ChunkPos(pos.getX() >> 4, pos.getZ() >> 4);
                BlockPos currentOffset = CTMOffsetDataManager.getOffset(chunkPos);
                BlockPos newOffset = wrap(currentOffset.relative(moveDir.getOpposite()));
                
                CTMOffsetDataManager.setOffset(chunkPos, newOffset);
                PacketDistributor.sendToPlayer((ServerPlayer) context.getPlayer(), new CTMOffsetSyncPacket(chunkPos, newOffset));
                
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(context);
    }

    public Direction getMoveDir(Direction face, double x, double y, double z) {
        Map<Double, Direction> map = new HashMap<>();
        if (face.getStepX() != 0) {
            fillMap(map, z, y, Direction.DOWN, Direction.UP, Direction.NORTH, Direction.SOUTH);
        } else if (face.getStepY() != 0) {
            fillMap(map, x, z, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST);
        } else if (face.getStepZ() != 0) {
            fillMap(map, x, y, Direction.DOWN, Direction.UP, Direction.WEST, Direction.EAST);
        }
        if (map.isEmpty()) return Direction.NORTH;
        List<Double> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        return map.get(keys.getFirst());
    }

    private void fillMap(Map<Double, Direction> map, double x, double y, Direction... dirs) {
        map.put(Line2D.ptLineDistSq(0, 0, 1, 0, x, y), dirs[0]);
        map.put(Line2D.ptLineDistSq(0, 1, 1, 1, x, y), dirs[1]);
        map.put(Line2D.ptLineDistSq(0, 0, 0, 1, x, y), dirs[2]);
        map.put(Line2D.ptLineDistSq(1, 0, 1, 1, x, y), dirs[3]);
    }

    private BlockPos wrap(BlockPos pos) {
        return new BlockPos(positiveModulo(pos.getX()), positiveModulo(pos.getY()), positiveModulo(pos.getZ()));
    }

    private int positiveModulo(int num) {
        return (num % 16 + 16) % 16;
    }

    @Override
    public void appendHoverText(@NonNull ItemStack stack, @NonNull TooltipContext context, @NonNull TooltipDisplay display, @NonNull Consumer<Component> builder, @NonNull TooltipFlag flag) {
        builder.accept(Component.translatable("item.chisel.offset_tool.desc").withStyle(ChatFormatting.GRAY));
        builder.accept(Component.translatable("item.chisel.offset_tool.desc2").withStyle(ChatFormatting.GRAY));
    }
}
