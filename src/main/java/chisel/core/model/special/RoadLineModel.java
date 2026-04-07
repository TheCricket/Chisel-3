package chisel.core.model.special;

import chisel.client.ChiselModelTemplates;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;

public class RoadLineModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.TEXTURE, variant.getMaterial())
                .put(TextureSlot.PARTICLE, variant.getMaterial());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        blockModels.createHorizontallyRotatedBlock(getBlock(), TexturedModel.createDefault((_) -> getTextureMapping(), ChiselModelTemplates.ROAD_LINES));
    }
}
