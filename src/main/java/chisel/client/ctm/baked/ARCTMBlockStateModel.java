package chisel.client.ctm.baked;

import chisel.client.ctm.AbstractConnectedTextureBlockStateModel;
import chisel.client.ctm.ConnectedTextureBlockModelPart;
import chisel.client.ctm.logic.CTMData;
import chisel.client.ctm.logic.CTMLogic;
import chisel.client.ctm.logic.CTMLogicAR;
import chisel.core.variant.Variant;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.*;

public class ARCTMBlockStateModel extends AbstractConnectedTextureBlockStateModel {

    protected final Map<Direction, BakedQuad[][]> connectedQuads;

    public ARCTMBlockStateModel(Set<Direction> connectedFaces, Set<Direction> unculledFaces, boolean renderOverlayOnAllFaces, Map<Direction, BakedQuad[]> baseQuads, Map<Direction, BakedQuad[][]> connectedQuads, TextureAtlasSprite particle, Variant variant) {
        super(connectedFaces, unculledFaces, renderOverlayOnAllFaces, baseQuads, particle, variant);
        this.connectedQuads = connectedQuads;
    }

    @Override
    protected CTMData computeCTMData(BlockAndTintGetter level, BlockPos pos, RandomSource random) {
        CTMLogic[][] logic = new CTMLogic[6][4];
        CTMLogicAR ar = CTMLogicAR.get(pos);

        for (Direction face : Direction.values()) {
            for (int i = 0; i < 4; i++) {
                // We use the AR ordinal to pick a texture from the 4 available in the multiblock array
                // CTMLogic doesn't exactly fit but we can repurpose the mechanism
                // Actually, the StandardUnbakedCTMModel for AR would have baked 4 textures.
                logic[face.get3DDataValue()][i] = CTMLogic.values()[ar.ordinal()];
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

            // For AR, we always render the overlay if it exists
            for (int i = 0; i < 4; i++) {
                CTMLogic logic = data.get(side, i);
                BakedQuad[][] conn = connectedQuads.get(side);
                if (conn != null && conn[i] != null) {
                    // logic.ordinal() will be 0-3 for AR
                    BakedQuad quad = conn[i][logic.ordinal()];
                    if (quad != null) {
                        faceQuads.add(quad);
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
