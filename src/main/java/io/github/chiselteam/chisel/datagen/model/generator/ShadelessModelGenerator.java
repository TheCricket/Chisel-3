package io.github.chiselteam.chisel.datagen.model.generator;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.ChiselModelTemplates;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ShadelessModelGenerator extends VariantModelGenerator {
    @Override
    public TextureMapping getTextureMapping() {
        return new TextureMapping().put(TextureSlot.ALL, VariantTextures.get(variant));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        generateSimpleBlockState(plainVariant(ChiselModelTemplates.SHADELESS.create(getBlock(), getTextureMapping(), blockModels.modelOutput)));
    }
}
