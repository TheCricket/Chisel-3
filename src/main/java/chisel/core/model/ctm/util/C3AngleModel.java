package chisel.core.model.ctm.util;

import chisel.core.Variant;
import chisel.core.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class C3AngleModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.DOWN, variant.getMaterial("ne"))
                .put(TextureSlot.UP, variant.getMaterial("news"))
                .put(TextureSlot.NORTH, variant.getMaterial("nw"))
                .put(TextureSlot.SOUTH, variant.getMaterial("news"))
                .put(TextureSlot.WEST, variant.getMaterial("ne"))
                .put(TextureSlot.EAST, variant.getMaterial("news"));
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
                        "_c3",
                        mapping,
                        blockModels.modelOutput
                )
        );
    }
}
