package io.github.chiselteam.chisel.datagen.model.generator;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class ShadelessModelGenerator extends VariantModelGenerator {
    private static final TexturedModel.Provider SHADELESS =
            TexturedModel.createDefault(
                    TextureMapping::cube,
                    new ModelTemplate(
                            Optional.of(Identifier.fromNamespaceAndPath("chisel", "block/shadeless")),
                            Optional.empty(),
                            TextureSlot.ALL));

    @Override
    public TextureMapping getTextureMapping() {
        return TextureMapping.cube(getBlock());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        blockModels.createTrivialBlock(variant.getBlock(), SHADELESS.updateTexture(map -> map.put(TextureSlot.ALL, VariantTextures.get(variant))));
    }
}