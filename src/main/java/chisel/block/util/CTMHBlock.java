package chisel.block.util;

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

public class CTMHBlock extends Block {

    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty EW = BooleanProperty.create("EW");
    public static final BooleanProperty NS = BooleanProperty.create("NS");

    public CTMHBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST);
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
        boolean isNorth = level.getBlockState(pos.north()).is(this);
        boolean isSouth = level.getBlockState(pos.south()).is(this);
        boolean isWest = level.getBlockState(pos.west()).is(this);
        boolean isEast = level.getBlockState(pos.east()).is(this);

        BlockState state = defaultBlockState();

        if(isNorth && isSouth) {
            return state
                    .setValue(NORTH, true)
                    .setValue(SOUTH, true)
                    .setValue(NS, true);
        } else if(isWest && isEast) {
            return state
                    .setValue(WEST, true)
                    .setValue(EAST, true)
                    .setValue(EW, true);
        }

        if(isNorth) state.setValue(NORTH, true);
        if(isSouth) state.setValue(SOUTH, true);
        if(isWest) state.setValue(WEST, true);
        if(isEast) state.setValue(EAST, true);

        return state;
    }
}
