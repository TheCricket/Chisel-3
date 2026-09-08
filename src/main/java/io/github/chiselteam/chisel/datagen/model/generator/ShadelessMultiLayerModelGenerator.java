package io.github.chiselteam.chisel.datagen.model.generator;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.ChiselModelTemplates;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ShadelessMultiLayerModelGenerator extends VariantModelGenerator {
    @Override
    public TextureMapping getTextureMapping() {
        return new TextureMapping()
                .put(TextureSlot.PARTICLE, VariantTextures.get(variant))
                .put(TextureSlot.LAYER0, VariantTextures.get(variant, "bg"))
                .put(TextureSlot.LAYER1, VariantTextures.get(variant).withForceTranslucent(true));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        generateSimpleBlockState(plainVariant(ChiselModelTemplates.SHADELESS_MULTI_LAYER.create(getBlock(), getTextureMapping(), blockModels.modelOutput)));
    }
}
