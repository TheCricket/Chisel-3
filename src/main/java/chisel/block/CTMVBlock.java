package chisel.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class CTMVBlock extends Block {

    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    public CTMVBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(UP, false).setValue(DOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@NonNull BlockPlaceContext context) {
        if(context.canPlace()) {
            return getConnectableSides(context.getLevel(), context.getClickedPos());
        }
        return super.getStateForPlacement(context);
    }

    @Override
    protected void neighborChanged(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Block block, @Nullable Orientation orientation, boolean movedByPiston) {
        super.neighborChanged(state, level, pos, block, orientation, movedByPiston);
        level.setBlock(pos, getConnectableSides(level, pos), Block.UPDATE_ALL);
    }

    @Override
    protected boolean skipRendering(@NonNull BlockState state, BlockState neighborState, @NonNull Direction direction) {
        return neighborState.is(this) || super.skipRendering(state, neighborState, direction);
    }

    private BlockState getConnectableSides(Level level, BlockPos pos) {
        return defaultBlockState()
                .setValue(DOWN, level.getBlockState(pos.below()).is(this))
                .setValue(UP, level.getBlockState(pos.above()).is(this));
    }
}
