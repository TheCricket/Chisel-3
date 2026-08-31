package io.github.chiselteam.chisel.datagen.model.generator.special;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.ChiselModelTemplates;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;

public class RoadLineModelGenerator extends VariantModelGenerator {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.TEXTURE, VariantTextures.get(variant))
                .put(TextureSlot.PARTICLE, VariantTextures.get(variant));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        blockModels.createHorizontallyRotatedBlock(getBlock(), TexturedModel.createDefault((_) -> getTextureMapping(), ChiselModelTemplates.ROAD_LINES));
    }
}
