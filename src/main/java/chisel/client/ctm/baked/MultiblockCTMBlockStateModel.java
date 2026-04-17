package chisel.client.ctm.baked;

import chisel.client.ctm.AbstractConnectedTextureBlockStateModel;
import chisel.client.ctm.ConnectedTextureBlockModelPart;
import chisel.client.ctm.logic.*;
import chisel.core.variant.Variant;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

import java.util.*;

public class MultiblockCTMBlockStateModel extends AbstractConnectedTextureBlockStateModel {

    protected final Map<Direction, BakedQuad[]> multiblock2x2Quads;
    protected final Map<Direction, BakedQuad[]> multiblock3x3Quads;
    protected final Map<Direction, BakedQuad[]> multiblock4x4Quads;

    public MultiblockCTMBlockStateModel(Set<Direction> connectedFaces, Set<Direction> unculledFaces, boolean renderOverlayOnAllFaces, Map<Direction, BakedQuad[]> baseQuads,
                                        Map<Direction, BakedQuad[]> multiblock2x2Quads,
                                        Map<Direction, BakedQuad[]> multiblock3x3Quads,
                                        Map<Direction, BakedQuad[]> multiblock4x4Quads,
                                        TextureAtlasSprite particle, Variant variant) {
        super(connectedFaces, unculledFaces, renderOverlayOnAllFaces, baseQuads, particle, variant);
        this.multiblock2x2Quads = multiblock2x2Quads;
        this.multiblock3x3Quads = multiblock3x3Quads;
        this.multiblock4x4Quads = multiblock4x4Quads;
    }

    @Override
    protected CTMData computeCTMData(BlockAndTintGetter level, BlockPos pos, RandomSource random) {
        CTMLogic2x2[] logic2x2 = new CTMLogic2x2[6];
        CTMLogic3x3[] logic3x3 = new CTMLogic3x3[6];
        CTMLogic4x4[] logic4x4 = new CTMLogic4x4[6];
        CTMLogicV4[] logicV4 = new CTMLogicV4[6];

        for (Direction face : Direction.values()) {
            int i = face.get3DDataValue();
            logic2x2[i] = CTMLogic2x2.get(pos, face);
            logic3x3[i] = CTMLogic3x3.get(pos, face);
            logic4x4[i] = CTMLogic4x4.get(pos, face);
            logicV4[i] = CTMLogicV4.get(random);
        }

        return new CTMData(variant, null, logic2x2, logic3x3, logic4x4, null, null, logicV4);
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
                    case MULTIBLOCK_2X2, MULTI_LAYER_WATER_2X2 -> {
                        CTMLogic2x2 logic = data.get2x2(side);
                        BakedQuad[] quads = multiblock2x2Quads.get(side);
                        if (quads != null && logic != null) {
                            BakedQuad quad = quads[logic.ordinal()];
                            if (quad != null) faceQuads.add(quad);
                        }
                    }
                    case MULTIBLOCK_3X3, MULTI_LAYER_WATER_3X3 -> {
                        CTMLogic3x3 logic = data.get3x3(side);
                        BakedQuad[] quads = multiblock3x3Quads.get(side);
                        if (quads != null && logic != null) {
                            BakedQuad quad = quads[logic.ordinal()];
                            if (quad != null) faceQuads.add(quad);
                        }
                    }
                    case MULTIBLOCK_4X4, MULTI_LAYER_WATER_4X4 -> {
                        CTMLogic4x4 logic = data.get4x4(side);
                        BakedQuad[] quads = multiblock4x4Quads.get(side);
                        if (quads != null && logic != null) {
                            BakedQuad quad = quads[logic.ordinal()];
                            if (quad != null) faceQuads.add(quad);
                        }
                    }
                    case V4 -> {
                        CTMLogicV4 logic = data.getV4(side);
                        BakedQuad[] quads = multiblock2x2Quads.get(side);
                        if (quads != null && logic != null) {
                            // V4 uses 2x2 logic under the hood
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
