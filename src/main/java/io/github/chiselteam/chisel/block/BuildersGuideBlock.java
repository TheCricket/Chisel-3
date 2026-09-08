package io.github.chiselteam.chisel.block;

import com.mojang.serialization.MapCodec;
import io.github.chiselteam.chisel.block.entity.BuildersGuideBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class BuildersGuideBlock extends BaseEntityBlock {

    public static final MapCodec<BuildersGuideBlock> CODEC = simpleCodec(BuildersGuideBlock::new);

    public BuildersGuideBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NonNull BlockPos pos, @NonNull BlockState state) {
        return new BuildersGuideBlockEntity(pos, state);
    }

    @Override
    protected @NonNull InteractionResult useItemOn(@NonNull ItemStack stack, @NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull InteractionHand hand, @NonNull BlockHitResult hitResult) {
        var guide = (BuildersGuideBlockEntity) level.getBlockEntity(pos);
        if(guide == null) return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        if(guide.getGhostBlocks().isEmpty()) return super.useItemOn(stack, state, level, pos, player, hand, hitResult);

        if(stack.getItem() instanceof DyeItem) {
            var dye = stack.get(DataComponents.DYE);
            guide.setColor(dye);
            if(!player.isCreative()) stack.shrink(1);
            player.swing(hand);
            return InteractionResult.CONSUME;
        }

        if(stack.getItem() instanceof BlockItem blockItem) {
            var block = blockItem.getBlock();
            guide.placeBlock(block);
            if(!player.isCreative()) stack.shrink(1);
            player.swing(hand);
            return InteractionResult.CONSUME;
        }

        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        var entity = level.getBlockEntity(pos);
        if(entity == null) return super.useWithoutItem(state, level, pos, player, hitResult);

        if(entity instanceof BuildersGuideBlockEntity guide) {
            if(player.isShiftKeyDown()) {
                guide.cycleBuildingMode();
                player.sendOverlayMessage(Component.translatable("chisel.builders_guide.mode_changed").append(" ").append(guide.getBuildingMode().getDescription()));
            } else {
                switch(hitResult.getDirection()) {
                    case NORTH -> guide.increaseLength();
                    case SOUTH -> guide.decreaseLength();
                    case EAST -> guide.increaseWidth();
                    case WEST -> guide.decreaseWidth();
                    case DOWN -> guide.decreaseHeight();
                    case UP -> guide.increaseHeight();
                }
                player.sendOverlayMessage(Component.translatable("chisel.builders_guide.size_changed")
                        .append(" ")
                        .append("%d".formatted(guide.getLength()))
                        .append("x")
                        .append("%d".formatted(guide.getWidth()))
                        .append("x")
                        .append("%d".formatted(guide.getHeight()))
                );
            }
        }

        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
}
