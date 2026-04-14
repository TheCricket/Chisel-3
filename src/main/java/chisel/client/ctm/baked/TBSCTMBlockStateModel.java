package chisel.client.ctm.baked;

import chisel.client.ctm.AbstractConnectedTextureBlockStateModel;
import chisel.client.ctm.ConnectedTextureBlockModelPart;
import chisel.client.ctm.logic.CTMData;
import chisel.client.ctm.logic.CTMLogic;
import chisel.core.variant.Variant;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.*;

public class TBSCTMBlockStateModel extends AbstractConnectedTextureBlockStateModel {

    protected final Map<Direction, BakedQuad[][]> connectedQuads;

    public TBSCTMBlockStateModel(Set<Direction> connectedFaces, Set<Direction> unculledFaces, boolean renderOverlayOnAllFaces, Map<Direction, BakedQuad[]> baseQuads, Map<Direction, BakedQuad[][]> connectedQuads, TextureAtlasSprite particle, Variant variant) {
        super(connectedFaces, unculledFaces, renderOverlayOnAllFaces, baseQuads, particle, variant);
        this.connectedQuads = connectedQuads;
    }

    @Override
    protected CTMData computeCTMData(BlockAndTintGetter level, BlockPos pos, RandomSource random) {
        CTMLogic[][] logic = new CTMLogic[6][4];

        for (Direction face : Direction.values()) {
            int faceIndex = face.get3DDataValue();
            Direction[] planeDirections = CTMLogic.AXIS_PLANE_DIRECTIONS[face.getAxis().ordinal()];

            for (int i = 0; i < 4; i++) {
                Direction s1 = planeDirections[i];
                Direction s2 = planeDirections[(i + 1) % 4];

                boolean horizontal = shouldConnectSide(level, pos, face, s1);
                boolean vertical = shouldConnectSide(level, pos, face, s2);
                boolean corner = horizontal && vertical && isCornerBlockPresent(level, pos, face, s1, s2);

                logic[faceIndex][i] = (i % 2 == 0)
                        ? CTMLogic.of(horizontal, vertical, corner)
                        : CTMLogic.of(vertical, horizontal, corner);
            }
        }

        return new CTMData(variant, logic);
    }

    @Override
    protected ConnectedTextureBlockModelPart createPart(CTMData data) {
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
}
