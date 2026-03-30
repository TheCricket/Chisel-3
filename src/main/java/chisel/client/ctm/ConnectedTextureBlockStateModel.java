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
import org.jspecify.annotations.NonNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectedTextureBlockStateModel implements DynamicBlockStateModel {

    private final Set<Direction> connectedFaces;
    private final Set<Direction> unculledFaces;
    private final boolean renderOverlayOnAllFaces;
    private final Map<Direction, BakedQuad[]> baseQuads;
    private final Map<Direction, BakedQuad[][]> connectedQuads;
    private final TextureAtlasSprite particle;
    private final Variant variant;

    private final Map<CTMData, ConnectedTextureBlockModelPart> cache = new ConcurrentHashMap<>();

    public ConnectedTextureBlockStateModel(
            Set<Direction> connectedFaces,
            Set<Direction> unculledFaces,
            boolean renderOverlayOnAllFaces,
            Map<Direction, BakedQuad[]> baseQuads,
            Map<Direction, BakedQuad[][]> connectedQuads,
            TextureAtlasSprite particle,
            Variant variant
    ) {
        this.connectedFaces = connectedFaces;
        this.unculledFaces = unculledFaces;
        this.renderOverlayOnAllFaces = renderOverlayOnAllFaces;
        this.baseQuads = baseQuads;
        this.connectedQuads = connectedQuads;
        this.particle = particle;
        this.variant = variant;
    }

    @Override
    public Object createGeometryKey(@NonNull BlockAndTintGetter level, @NonNull BlockPos pos, @NonNull BlockState state, @NonNull RandomSource random) {
        return computeCTMData(level, pos);
    }

    @Override
    public void collectParts(@NonNull BlockAndTintGetter level, @NonNull BlockPos pos,
                             @NonNull BlockState state, @NonNull RandomSource random,
                             List<BlockStateModelPart> parts) {

        CTMData data = computeCTMData(level, pos);
        parts.add(cache.computeIfAbsent(data, this::createPart));
    }

    private CTMData computeCTMData(BlockAndTintGetter level, BlockPos pos) {
        CTMLogic[][] logic = new CTMLogic[6][4];

        for (Direction face : Direction.values()) {
            Direction[] dirs = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];
            boolean[] sideStates = new boolean[4];

            for (int i = 0; i < 4; i++) {
                sideStates[i] = shouldConnectSide(level, pos, face, dirs[i]);
            }

            int faceIndex = face.get3DDataValue();

            for (int i = 0; i < 4; i++) {
                int next = (i + 1) % 4;

                boolean s1 = sideStates[i];
                boolean s2 = sideStates[next];
                boolean corner = s1 && s2 && isCornerBlockPresent(level, pos, face, dirs[i], dirs[next]);

                logic[faceIndex][i] = (i % 2 == 0)
                        ? CTMLogic.of(s1, s2, corner)
                        : CTMLogic.of(s2, s1, corner);
            }
        }

        return new CTMData(variant, logic);
    }

    private ConnectedTextureBlockModelPart createPart(CTMData data) {
        Map<Direction, List<BakedQuad>> quadsMap = new EnumMap<>(Direction.class);
        List<BakedQuad> unculled = new ArrayList<>();
        int flags = 0;

        for (Direction side : Direction.values()) {
            List<BakedQuad> faceQuads = new ArrayList<>(8);

            BakedQuad[] base = baseQuads.get(side);
            if (base != null) {
                for (BakedQuad quad : base) {
                    if (quad != null) {
                        faceQuads.add(quad);
                    }
                }
            }

            if (connectedFaces.contains(side) || renderOverlayOnAllFaces) {
                for (int i = 0; i < 4; i++) {
                    CTMLogic logic = connectedFaces.contains(side)
                            ? data.get(side, i)
                            : CTMLogic.NONE;

                    BakedQuad[][] conn = connectedQuads.get(side);
                    if (conn != null && conn[i] != null) {
                        BakedQuad quad = conn[i][logic.ordinal()];
                        if (quad != null) {
                            faceQuads.add(quad);
                        }
                    }
                }
            }

            for (BakedQuad q : faceQuads) {
                if (q != null) {
                    flags |= q.materialInfo().flags();
                }
            }

            quadsMap.put(side, List.copyOf(faceQuads));

            if (unculledFaces.contains(side)) {
                unculled.addAll(faceQuads);
            }
        }

        return new ConnectedTextureBlockModelPart(
                quadsMap,
                List.copyOf(unculled),
                flags,
                new Material.Baked(particle, false)
        );
    }

    private boolean shouldConnectSide(BlockAndTintGetter level, BlockPos pos, Direction face, Direction side) {
        BlockState neighbor = level.getBlockState(pos.relative(side));
        if (unculledFaces.contains(face)) {
            return neighbor.is(variant.getBlock());
        }
        return neighbor.is(variant.getBlock()) &&
                Block.shouldRenderFace(level, pos.relative(face), neighbor,
                        level.getBlockState(pos.relative(face)), face);
    }

    private boolean isCornerBlockPresent(BlockAndTintGetter level, BlockPos pos,
                                         Direction face, Direction side1, Direction side2) {

        BlockState neighbor = level.getBlockState(pos.relative(side1).relative(side2));

        if (unculledFaces.contains(face)) {
            return neighbor.is(variant.getBlock());
        }

        return neighbor.is(variant.getBlock()) &&
                Block.shouldRenderFace(level, pos.relative(face), neighbor,
                        level.getBlockState(pos.relative(face)), face);
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