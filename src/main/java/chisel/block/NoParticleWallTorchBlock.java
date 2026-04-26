package chisel.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

import java.util.Map;

public class NoParticleWallTorchBlock extends NoParticleTorchBlock{

    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    private static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(Block.boxZ(5.0F, 3.0F, 13.0F, 11.0F, 16.0F));

    public NoParticleWallTorchBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return getShape(state);
    }

    public static VoxelShape getShape(BlockState state) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    protected boolean canSurvive(BlockState state, @NonNull LevelReader level, @NonNull BlockPos pos) {
        return canSurvive(level, pos, state.getValue(FACING));
    }

    public static boolean canSurvive(LevelReader level, BlockPos pos, Direction facing) {
        BlockPos relativePos = pos.relative(facing.getOpposite());
        BlockState relativeState = level.getBlockState(relativePos);
        return relativeState.isFaceSturdy(level, relativePos, facing);
    }

    @Override
    protected @NonNull BlockState updateShape(BlockState state, @NonNull LevelReader level, @NonNull ScheduledTickAccess ticks, @NonNull BlockPos pos, Direction directionToNeighbour, @NonNull BlockPos neighbourPos, @NonNull BlockState neighbourState, @NonNull RandomSource random) {
        return directionToNeighbour.getOpposite() == state.getValue(FACING) && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : state;
    }

    @Override
    protected @NonNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected @NonNull BlockState mirror(@NonNull BlockState state, @NonNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}
