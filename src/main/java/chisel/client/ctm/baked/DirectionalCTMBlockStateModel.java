package chisel.client.ctm.baked;

import chisel.client.ctm.AbstractConnectedTextureBlockStateModel;
import chisel.client.ctm.ConnectedTextureBlockModelPart;
import chisel.client.ctm.logic.CTMData;
import chisel.client.ctm.logic.CTMLogicHorizontal;
import chisel.client.ctm.logic.CTMLogicVertical;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModelType;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.*;

public class DirectionalCTMBlockStateModel extends AbstractConnectedTextureBlockStateModel {

    protected final Map<Direction, BakedQuad[]> horizontalQuads;
    protected final Map<Direction, BakedQuad[]> verticalQuads;

    public DirectionalCTMBlockStateModel(Set<Direction> connectedFaces, Set<Direction> unculledFaces, boolean renderOverlayOnAllFaces, Map<Direction, BakedQuad[]> baseQuads,
                                         Map<Direction, BakedQuad[]> horizontalQuads,
                                         Map<Direction, BakedQuad[]> verticalQuads,
                                         TextureAtlasSprite particle, Variant variant) {
        super(connectedFaces, unculledFaces, renderOverlayOnAllFaces, baseQuads, particle, variant);
        this.horizontalQuads = horizontalQuads;
        this.verticalQuads = verticalQuads;
    }

    @Override
    protected CTMData computeCTMData(BlockAndTintGetter level, BlockPos pos, RandomSource random) {
        CTMLogicHorizontal[] logicHorizontal = new CTMLogicHorizontal[6];
        CTMLogicVertical[] logicVertical = new CTMLogicVertical[6];

        for (Direction face : Direction.values()) {
            int i = face.get3DDataValue();
            Direction.Axis axis = face.getAxis();
            
            if (axis == Direction.Axis.Y) {
                // For UP/DOWN, horizontal logic connects on X and Z
                logicHorizontal[i] = CTMLogicHorizontal.get(shouldConnectSide(level, pos, face, Direction.WEST), shouldConnectSide(level, pos, face, Direction.EAST));
                logicVertical[i] = CTMLogicVertical.get(shouldConnectSide(level, pos, face, Direction.NORTH), shouldConnectSide(level, pos, face, Direction.SOUTH));
            } else {
                // For side faces, horizontal logic connects on the horizontal axis orthogonal to the face
                Direction horizontalDir = face.getClockWise();
                logicHorizontal[i] = CTMLogicHorizontal.get(shouldConnectSide(level, pos, face, horizontalDir.getOpposite()), shouldConnectSide(level, pos, face, horizontalDir));
                logicVertical[i] = CTMLogicVertical.get(shouldConnectSide(level, pos, face, Direction.UP), shouldConnectSide(level, pos, face, Direction.DOWN));
            }

            if (variant.getModelType() == VariantModelType.BOOKSHELF && axis.isHorizontal()) {
                logicVertical[i] = CTMLogicVertical.NONE;
            }
        }

        return new CTMData(variant, null, null, null, null, logicHorizontal, logicVertical);
    }

    @Override
    protected ConnectedTextureBlockModelPart createPart(CTMData data) {
        Map<Direction, List<BakedQuad>> quadsMap = new EnumMap<>(Direction.class);
        List<BakedQuad> unculled = new ArrayList<>();
        int flags = 0;

        for (Direction side : Direction.values()) {
            List<BakedQuad> faceQuads = new ArrayList<>(2);

            BakedQuad[] base = baseQuads.get(side);
            if (base != null) {
                for (BakedQuad quad : base) {
                    if (quad != null) {
                        faceQuads.add(quad);
                    }
                }
            }

            if (connectedFaces.contains(side) || renderOverlayOnAllFaces) {
                switch (variant.getModelType()) {
                    case CTMH, BOOKSHELF -> {
                        CTMLogicHorizontal logic = data.getHorizontal(side);
                        BakedQuad[] quads = horizontalQuads.get(side);
                        if (quads != null && logic != null) {
                            BakedQuad quad = quads[logic.ordinal()];
                            if (quad != null) faceQuads.add(quad);
                        }
                    }
                    case CTMV -> {
                        CTMLogicVertical logic = data.getVertical(side);
                        BakedQuad[] quads = verticalQuads.get(side);
                        if (quads != null && logic != null) {
                            BakedQuad quad = quads[logic.ordinal()];
                            if (quad != null) faceQuads.add(quad);
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
}
