package chisel.client.ctm;

import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.model.data.ModelData;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record ConnectedTextureBlockModelPart(ModelData modelData, Set<Direction> connectedFaces,
                                             Set<Direction> unculledFaces, Map<Direction, BakedQuad[]> baseQuads,
                                             Map<Direction, BakedQuad[][]> connectedQuads,
                                             boolean renderOverlayOnAllFaces, boolean useAmbientOcclusion,
                                             Material.Baked particleMaterial) implements BlockStateModelPart {

    public ConnectedTextureBlockModelPart(ModelData modelData, Set<Direction> connectedFaces, Set<Direction> unculledFaces, Map<Direction, BakedQuad[]> baseQuads, Map<Direction, BakedQuad[][]> connectedQuads, boolean renderOverlayOnAllFaces, boolean useAmbientOcclusion, TextureAtlasSprite particleMaterial) {
        this(modelData, connectedFaces, unculledFaces, baseQuads, connectedQuads, renderOverlayOnAllFaces, useAmbientOcclusion, new Material.Baked(particleMaterial, false));
    }

    @Override
    public @NonNull List<BakedQuad> getQuads(@Nullable Direction side) {
        if (side == null) {
            List<BakedQuad> quadList = new ArrayList<>();
            for (Direction direction : unculledFaces) quadList.addAll(getQuadsForFace(direction));
            return quadList;
        } else return getQuadsForFace(side);
    }

    public List<BakedQuad> getQuadsForFace(Direction side) {
        BakedQuad[] baseQuads = this.baseQuads.get(side);
        CTMData data = modelData.get(CTMData.DATA);
        ArrayList<BakedQuad> quads = new ArrayList<>(4 + (baseQuads != null ? 4 : 0));
        if (baseQuads != null) quads.addAll(List.of(baseQuads));

        if (connectedFaces.contains(side) || this.renderOverlayOnAllFaces) {
            for (int quad = 0; quad < 4; ++quad) {
                CTMLogic connectionType = data != null && this.connectedFaces.contains(side) ? data.logic[side.get3DDataValue()][quad] : CTMLogic.NONE;
                if (connectionType == null) connectionType = CTMLogic.NONE;
                BakedQuad[][] faceQuads = connectedQuads.get(side);
                if (faceQuads != null && faceQuads[quad] != null) {
                    quads.add(faceQuads[quad][connectionType.ordinal()]);
                }
            }
        }

        return quads;
    }

    @Override
    public @BakedQuad.MaterialFlags int materialFlags() {
        return 0;
    }
}
