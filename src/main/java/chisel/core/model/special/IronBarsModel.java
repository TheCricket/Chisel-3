package chisel.core.model.special;

import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;

public class IronBarsModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping()).put(TextureSlot.BARS, variant.getMaterial()).put(TextureSlot.EDGE, variant.getMaterial());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        blockModels.createBars(
                variant.getBlock(),
                ModelTemplates.BARS_POST_ENDS.create(variant.getBlock(), getTextureMapping(), blockModels.modelOutput),
                ModelTemplates.BARS_POST.create(variant.getBlock(), getTextureMapping(), blockModels.modelOutput),
                ModelTemplates.BARS_CAP.create(variant.getBlock(), getTextureMapping(), blockModels.modelOutput),
                ModelTemplates.BARS_CAP_ALT.create(variant.getBlock(), getTextureMapping(), blockModels.modelOutput),
                ModelTemplates.BARS_POST_SIDE.create(variant.getBlock(), getTextureMapping(), blockModels.modelOutput),
                ModelTemplates.BARS_POST_SIDE_ALT.create(variant.getBlock(), getTextureMapping(), blockModels.modelOutput)
        );

        blockModels.registerSimpleItemModel(variant.getBlock(), ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(variant.getBlock().asItem()), TextureMapping.layer0(variant.getMaterial()), blockModels.modelOutput));
    }
}
