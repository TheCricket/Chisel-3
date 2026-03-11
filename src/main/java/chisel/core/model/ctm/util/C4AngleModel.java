package chisel.core.model.ctm.util;

import chisel.core.Variant;
import chisel.core.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class C4AngleModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial("news"))
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("news"))
                .put(TextureSlot.SOUTH, variant.getMaterial("nws"))
                .put(TextureSlot.WEST, variant.getMaterial("news"))
                .put(TextureSlot.EAST, variant.getMaterial("nes"));
    }

    public MultiVariant getModel(Variant variant, BlockModelGenerators blockModels) {
        return getModel(variant, getTextureMapping(), blockModels);
    }

    public MultiVariant getModel(Variant variant, TextureMapping mapping, BlockModelGenerators blockModels) {
        this.variant = variant;
        this.blockModels = blockModels;

        return plainVariant(
                ModelTemplates.CUBE.createWithSuffix(
                        getBlock(),
                        "_c4angle",
                        mapping,
                        blockModels.modelOutput
                )
        );
    }
}
