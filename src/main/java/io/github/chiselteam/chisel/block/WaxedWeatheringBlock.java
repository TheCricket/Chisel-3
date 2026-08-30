package io.github.chiselteam.chisel.block;

import io.github.chiselteam.chisel.weathering.WeatheringChains;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ItemAbilities;
import org.jspecify.annotations.NonNull;

public class WaxedWeatheringBlock extends ConnectedTextureBlock {
    public WaxedWeatheringBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull InteractionResult useItemOn(@NonNull ItemStack stack, @NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull InteractionHand hand, @NonNull BlockHitResult hitResult) {
        if (stack.canPerformAction(ItemAbilities.AXE_SCRAPE)) {
            Block unwaxedBlock = WeatheringChains.getUnwaxed(state.getBlock()).orElse(null);
            if (unwaxedBlock != null) {
                level.setBlockAndUpdate(pos, WeatheringBlock.copySharedProperties(state, unwaxedBlock.defaultBlockState()));
                level.levelEvent(player, LevelEvent.PARTICLES_WAX_OFF, pos, 0);
                stack.hurtAndBreak(1, player, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    public boolean isRandomlyTicking(@NonNull BlockState state) {
        return false;
    }
}
