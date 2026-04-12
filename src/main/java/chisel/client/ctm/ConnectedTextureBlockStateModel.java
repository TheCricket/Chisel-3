package chisel.client.ctm;

import chisel.client.ctm.logic.*;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModelType;
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
    private final Map<Direction, BakedQuad[]> multiblock2x2Quads;
    private final Map<Direction, BakedQuad[]> multiblock3x3Quads;
    private final Map<Direction, BakedQuad[]> multiblock4x4Quads;
    private final Map<Direction, BakedQuad[]> horizontalQuads;
    private final TextureAtlasSprite particle;
    private final Variant variant;

    private final Map<CTMData, ConnectedTextureBlockModelPart> cache = new ConcurrentHashMap<>();

    public ConnectedTextureBlockStateModel(
            Set<Direction> connectedFaces,
            Set<Direction> unculledFaces,
            boolean renderOverlayOnAllFaces,
            Map<Direction, BakedQuad[]> baseQuads,
            Map<Direction, BakedQuad[][]> connectedQuads,
            Map<Direction, BakedQuad[]> multiblock2x2Quads,
            Map<Direction, BakedQuad[]> multiblock3x3Quads,
            Map<Direction, BakedQuad[]> multiblock4x4Quads,
            Map<Direction, BakedQuad[]> horizontalQuads,
            TextureAtlasSprite particle,
            Variant variant
    ) {
        this.connectedFaces = connectedFaces;
        this.unculledFaces = unculledFaces;
        this.renderOverlayOnAllFaces = renderOverlayOnAllFaces;
        this.baseQuads = baseQuads;
        this.connectedQuads = connectedQuads;
        this.multiblock2x2Quads = multiblock2x2Quads;
        this.multiblock3x3Quads = multiblock3x3Quads;
        this.multiblock4x4Quads = multiblock4x4Quads;
        this.horizontalQuads = horizontalQuads;
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
        if (variant.getModelType() == VariantModelType.MULTIBLOCK_2X2) {
            CTMLogic2x2[] logic2x2 = new CTMLogic2x2[6];
            for (Direction face : Direction.values()) {
                logic2x2[face.get3DDataValue()] = CTMLogic2x2.get(pos, face);
            }
            return new CTMData(variant, null, logic2x2, null, null);
        }
        if (variant.getModelType() == VariantModelType.MULTIBLOCK_3X3) {
            CTMLogic3x3[] logic3x3 = new CTMLogic3x3[6];
            for (Direction face : Direction.values()) {
                logic3x3[face.get3DDataValue()] = CTMLogic3x3.get(pos, face);
            }
            return new CTMData(variant, null, null, logic3x3, null);
        }
        if (variant.getModelType() == VariantModelType.MULTIBLOCK_4X4) {
            CTMLogic4x4[] logic4x4 = new CTMLogic4x4[6];
            for (Direction face : Direction.values()) {
                logic4x4[face.get3DDataValue()] = CTMLogic4x4.get(pos, face);
            }
            return new CTMData(variant, null, null, null, logic4x4);
        }

        if (variant.getModelType() == VariantModelType.CONNECTED_HORIZONTALLY || variant.getModelType() == VariantModelType.BOOKSHELF) {
            CTMLogicHorizontal[] logicHorizontal = new CTMLogicHorizontal[6];
            for (Direction face : Direction.values()) {
                if (face.getAxis().isVertical()) {
                    logicHorizontal[face.get3DDataValue()] = CTMLogicHorizontal.NONE;
                    continue;
                }
                Direction left = face.getCounterClockWise();
                Direction right = face.getClockWise();
                boolean connectLeft = shouldConnectSide(level, pos, face, left);
                boolean connectRight = shouldConnectSide(level, pos, face, right);
                logicHorizontal[face.get3DDataValue()] = CTMLogicHorizontal.get(connectLeft, connectRight);
            }
            return new CTMData(variant, null, null, null, null, logicHorizontal);
        }

        if (variant.getModelType() == VariantModelType.CONNECTED_VERTICALLY) {
            CTMLogicHorizontal[] logicVertical = new CTMLogicHorizontal[6];
            for (Direction face : Direction.values()) {
                if (face.getAxis().isVertical()) {
                    logicVertical[face.get3DDataValue()] = CTMLogicHorizontal.NONE;
                    continue;
                }
                boolean connectUp = shouldConnectSide(level, pos, face, Direction.UP);
                boolean connectDown = shouldConnectSide(level, pos, face, Direction.DOWN);
                logicVertical[face.get3DDataValue()] = CTMLogicHorizontal.get(connectUp, connectDown);
            }
            return new CTMData(variant, null, null, null, null, logicVertical);
        }

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
                if (variant.getModelType() == VariantModelType.MULTIBLOCK_2X2) {
                    CTMLogic2x2 logic = data.get2x2(side);
                    BakedQuad[] quads = multiblock2x2Quads.get(side);
                    if (quads != null && logic != null) {
                        BakedQuad quad = quads[logic.ordinal()];
                        if (quad != null) {
                            faceQuads.add(quad);
                        }
                    }
                } else if (variant.getModelType() == VariantModelType.MULTIBLOCK_3X3) {
                    CTMLogic3x3 logic = data.get3x3(side);
                    BakedQuad[] quads = multiblock3x3Quads.get(side);
                    if (quads != null && logic != null) {
                        BakedQuad quad = quads[logic.ordinal()];
                        if (quad != null) {
                            faceQuads.add(quad);
                        }
                    }
                } else if (variant.getModelType() == VariantModelType.MULTIBLOCK_4X4) {
                    CTMLogic4x4 logic = data.get4x4(side);
                    BakedQuad[] quads = multiblock4x4Quads.get(side);
                    if (quads != null && logic != null) {
                        BakedQuad quad = quads[logic.ordinal()];
                        if (quad != null) {
                            faceQuads.add(quad);
                        }
                    }
                } else if (variant.getModelType() == VariantModelType.CONNECTED_HORIZONTALLY || variant.getModelType() == VariantModelType.CONNECTED_VERTICALLY || variant.getModelType() == VariantModelType.BOOKSHELF) {
                    CTMLogicHorizontal logic = data.getHorizontal(side);
                    BakedQuad[] quads = horizontalQuads.get(side);
                    if (quads != null && logic != null) {
                        BakedQuad quad = quads[logic.ordinal()];
                        if (quad != null) {
                            faceQuads.add(quad);
                        }
                    }
                } else {
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