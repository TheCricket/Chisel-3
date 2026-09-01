package io.github.chiselteam.chisel.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ChiselPoweredPillarBlock extends ChiselRotatedPillarBlock {
    public ChiselPoweredPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isSignalSource(@NonNull BlockState state) {
        return true;
    }

    @Override
    protected int getSignal(@NonNull BlockState state, @NonNull BlockGetter level, net.minecraft.core.@NonNull BlockPos pos, @NonNull Direction direction) {
        return 15;
    }
}
