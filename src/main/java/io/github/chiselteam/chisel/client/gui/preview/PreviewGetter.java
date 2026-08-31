package io.github.chiselteam.chisel.client.gui.preview;

import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PreviewGetter implements BlockAndTintGetter {

    private final BlockState state;
    private final Set<BlockPos> positions;

    public PreviewGetter(BlockState state, int[][] positions) {
        this.state = state;
        this.positions = new HashSet<>();
        Arrays.stream(positions).map(position -> new BlockPos(position[0], position[1], position[2])).forEach(this.positions::add);
    }

    public BlockState getState() {
        return state;
    }

    @Override
    public @NonNull CardinalLighting cardinalLighting() {
        return CardinalLighting.DEFAULT;
    }

    @Override
    public int getBlockTint(@NonNull BlockPos pos, @NonNull ColorResolver color) {
        return 0x7CBD6B;
    }

    @Override
    public @NonNull LevelLightEngine getLightEngine() {
        return LevelLightEngine.EMPTY;
    }

    @Override
    public @Nullable BlockEntity getBlockEntity(@NonNull BlockPos pos) {
        return null;
    }

    @Override
    public @NonNull BlockState getBlockState(@NonNull BlockPos pos) {
        return positions.contains(pos) ? state : Blocks.AIR.defaultBlockState();
    }

    @Override
    public @NonNull FluidState getFluidState(@NonNull BlockPos pos) {
        return Fluids.EMPTY.defaultFluidState();
    }

    @Override
    public int getHeight() {
        return 256;
    }

    @Override
    public int getMinY() {
        return 0;
    }
}
