package chisel.client.ctm;

import chisel.core.Variant;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.DynamicBlockStateModel;
import net.neoforged.neoforge.model.data.ModelData;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedTextureBlockStateModel implements DynamicBlockStateModel {

    private final Set<Direction> connectedFaces;
    private final Set<Direction> unculledFaces;
    private final boolean renderOverlayOnAllFaces;
    private final Map<Direction, BakedQuad[]> baseQuads;
    private final Map<Direction, BakedQuad[][]> connectedQuads;
    private final TextureAtlasSprite particle;
    private final Variant variant;

    public ConnectedTextureBlockStateModel(Set<Direction> connectedFaces, Set<Direction> unculledFaces, boolean renderOverlayOnAllFaces, Map<Direction, BakedQuad[]> baseQuads, Map<Direction, BakedQuad[][]> connectedQuads, TextureAtlasSprite particle, Variant variant) {

        this.connectedFaces = connectedFaces;
        this.unculledFaces = unculledFaces;
        this.renderOverlayOnAllFaces = renderOverlayOnAllFaces;
        this.baseQuads = baseQuads;
        this.connectedQuads = connectedQuads;
        this.particle = particle;
        this.variant = variant;
    }

    @Override
    public void collectParts(BlockAndTintGetter level, BlockPos pos, BlockState state, RandomSource random, List<BlockStateModelPart> parts) {
        ModelData modelData = level.getModelData(pos);
        CTMData ctm = modelData.get(CTMData.DATA);

        if (ctm == null) {
            ctm = new CTMData();
        } else {
            // Copy CTMData to avoid modifying a shared instance if it's cached somewhere
            ctm = new CTMData(List.copyOf(ctm.unculledFaces), java.util.Arrays.stream(ctm.logic).flatMap(java.util.Arrays::stream).toList());
        }

        // Ensure static unculled faces from the model are included
        ctm.unculledFaces.addAll(this.unculledFaces);

        for (Direction face : Direction.values()) {
            Direction[] directions = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];
            boolean[] sideStates = new boolean[4];

            for (int i = 0; i < directions.length; i++) {
                sideStates[i] = shouldConnectSide(level, pos, face, directions[i]);
            }

            int faceIndex = face.get3DDataValue();
            for (int dir = 0; dir < directions.length; dir++) {
                int cornerOffset = (dir + 1) % directions.length;
                boolean side1 = sideStates[dir];
                boolean side2 = sideStates[cornerOffset];
                boolean corner = side1 && side2 && this.isCornerBlockPresent(level, pos, face, directions[dir], directions[cornerOffset]);

                ctm.logic[faceIndex][dir] = dir % 2 == 0 ? CTMLogic.of(side1, side2, corner) : CTMLogic.of(side2, side1, corner);
            }
        }

        ModelData finalData = modelData.derive().with(CTMData.DATA, ctm).build();
        parts.add(new ConnectedTextureBlockModelPart(finalData, connectedFaces, unculledFaces, baseQuads, connectedQuads, renderOverlayOnAllFaces, false, particle));
    }

    private boolean shouldConnectSide(BlockAndTintGetter getter, BlockPos pos, Direction face, Direction side) {
        BlockState neighborState = getter.getBlockState(pos.relative(side));
        if (this.unculledFaces.contains(face)) return neighborState.is(variant.getBlock());
        return neighborState.is(variant.getBlock()) && Block.shouldRenderFace(getter, pos.relative(face), neighborState, getter.getBlockState(pos.relative(face)), face);
    }

    private boolean isCornerBlockPresent(BlockAndTintGetter getter, BlockPos pos, Direction face, Direction side1, Direction side2) {
        BlockState neighborState = getter.getBlockState(pos.relative(side1).relative(side2));
        if (this.unculledFaces.contains(face)) return neighborState.is(variant.getBlock());
        return neighborState.is(variant.getBlock()) && Block.shouldRenderFace(getter, pos.relative(face), neighborState, getter.getBlockState(pos.relative(face)), face);
    }

    @Override
    public Material.@NonNull Baked particleMaterial() {
        return new Material.Baked(particle, false);
    }

    @Override
    public @BakedQuad.MaterialFlags int materialFlags() {
        return 0;
    }
}
