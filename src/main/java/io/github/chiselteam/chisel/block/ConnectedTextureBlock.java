package io.github.chiselteam.chisel.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ConnectedTextureBlock extends Block {
    public ConnectedTextureBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean skipRendering(@NonNull BlockState state, BlockState neighborState, @NonNull Direction direction) {
        return neighborState.is(this) || super.skipRendering(state, neighborState, direction);
    }
}
