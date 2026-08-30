package io.github.chiselteam.chisel.datagen.model.generator;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;

public class PillarModelGenerator extends VariantModelGenerator {
    @Override
    public TextureMapping getTextureMapping() {
        return TextureMapping.column(getBlock());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        blockModels.createTrivialBlock(
                variant.getBlock(),
                TexturedModel.COLUMN.updateTexture(
                        map -> map.put(TextureSlot.SIDE, VariantTextures.get(variant, "side")).put(TextureSlot.END, VariantTextures.get(variant, "end"))
                ));
    }
}
