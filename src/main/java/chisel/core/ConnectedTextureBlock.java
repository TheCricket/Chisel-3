package chisel.core;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Map;

public class ConnectedTextureBlock extends Block {

    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf(Maps.newEnumMap(Map.of(Direction.NORTH, NORTH, Direction.EAST, EAST, Direction.SOUTH, SOUTH, Direction.WEST, WEST, Direction.UP, UP, Direction.DOWN, DOWN)));

    public ConnectedTextureBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(UP, false).setValue(DOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@NonNull BlockPlaceContext context) {
        if(context.canPlace()) {
            return getConnectableSides(context.getLevel(), context.getClickedPos());
        }
        return super.getStateForPlacement(context);
    }

    @Override
    protected boolean skipRendering(@NonNull BlockState state, BlockState neighborState, @NonNull Direction direction) {
        return neighborState.is(this) || super.skipRendering(state, neighborState, direction);
    }

    private BlockState getConnectableSides(Level level, BlockPos pos) {
        return defaultBlockState()
                .setValue(DOWN, level.getBlockState(pos.below()).is(this))
                .setValue(UP, level.getBlockState(pos.above()).is(this))
                .setValue(NORTH, level.getBlockState(pos.north()).is(this))
                .setValue(SOUTH, level.getBlockState(pos.south()).is(this))
                .setValue(WEST, level.getBlockState(pos.west()).is(this))
                .setValue(EAST, level.getBlockState(pos.east()).is(this));
    }
}
