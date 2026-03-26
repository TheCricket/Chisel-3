package chisel.block;

import chisel.client.ctm.CTMData;
import chisel.client.ctm.CTMLogic;
import chisel.registry.ChiselBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.model.data.ModelData;
import org.jspecify.annotations.NonNull;

import java.util.Set;

public class ConnectedTextureBlockEntity extends BlockEntity {

    public ConnectedTextureBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(ChiselBlockEntities.CONNECTED_TEXTURE_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

    @Override
    public @NonNull ModelData getModelData() {
        ModelData data = super.getModelData();
        CTMData ctm = data.get(CTMData.DATA);
        if(ctm == null) ctm = new CTMData();
        if(level == null) return data;

        for(Direction face : Direction.values()) {
            Direction[] directions = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];
            boolean[] sideStates = new boolean[4];
            int faceIndex;

            for(faceIndex = 0; faceIndex < directions.length; faceIndex++) {
                sideStates[faceIndex] = shouldConnectSide(level, getBlockPos(), face, directions[faceIndex], ctm.unculledFaces);
            }

            faceIndex = face.get3DDataValue();

            for(int c = 0; c < directions.length; c++) {
                int cornerOffset = (c + 1) % directions.length;
                boolean side1 = sideStates[c];
                boolean side2 = sideStates[cornerOffset];
                boolean corner = side1 && side2 && isCornerBlockPresent(level, getBlockPos(), face, directions[c], directions[cornerOffset], ctm.unculledFaces);
                ctm.logic[faceIndex][c] = c % 2 == 0 ? CTMLogic.of(side1, side2, corner) : CTMLogic.of(side2, side1, corner);
            }
        }
        return data.derive().with(CTMData.DATA, ctm).build();
    }

    private boolean shouldConnectSide(Level level, BlockPos pos, Direction face, Direction side, Set<Direction> unculledFaces) {
        BlockState neighborState = level.getBlockState(pos.relative(side));
        if (unculledFaces.contains(face)) return  neighborState.is(getBlockState().getBlock());
        return  neighborState.is(getBlockState().getBlock()) && Block.shouldRenderFace(level, pos.relative(face), neighborState, level.getBlockState(pos.relative(face)), face);
    }

    private boolean isCornerBlockPresent(Level level, BlockPos pos, Direction face, Direction side1, Direction side2, Set<Direction> unculledFaces) {
        BlockState neighborState = level.getBlockState(pos.relative(side1).relative(side2));
        if (unculledFaces.contains(face)) return neighborState.is(getBlockState().getBlock());
        return neighborState.is(getBlockState().getBlock()) && Block.shouldRenderFace(level, pos.relative(face), neighborState, level.getBlockState(pos.relative(face)), face);
    }

}
