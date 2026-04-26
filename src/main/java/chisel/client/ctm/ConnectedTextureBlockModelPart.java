package chisel.client.ctm;

import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public record ConnectedTextureBlockModelPart(
        Map<Direction, List<BakedQuad>> quads,
        List<BakedQuad> unculledQuads,
        @BakedQuad.MaterialFlags int materialFlags,
        Material.Baked particleMaterial
) implements BlockStateModelPart {

    @Override
    public @NonNull List<BakedQuad> getQuads(@Nullable Direction side) {
        return side == null ? unculledQuads : quads.get(side);
    }

    @Override
    public @BakedQuad.MaterialFlags int materialFlags() {
        return materialFlags;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }
}