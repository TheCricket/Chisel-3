package io.github.chiselteam.chisel.datagen.model.generator;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import io.github.chiselteam.chisel.datagen.model.blockstate.EldritchBlockStateModelBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.Identifier;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class CubeAllModelGenerator extends VariantModelGenerator {
    @Override
    public TextureMapping getTextureMapping() {
        return TextureMapping.cube(getBlock());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        TexturedModel texturedModel = TexturedModel.CUBE.updateTexture(
                map -> map.put(TextureSlot.ALL, VariantTextures.get(variant))
        ).get(getBlock());
        Identifier modelLocation = texturedModel.create(getBlock(), blockModels.modelOutput);
        if (variant.isEldritch()) {
            MultiVariant inner = plainVariant(modelLocation);
            EldritchBlockStateModelBuilder eldritchBuilder = new EldritchBlockStateModelBuilder().inner(inner.toUnbaked());
            blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(getBlock(), MultiVariant.of(eldritchBuilder)));
        } else {
            blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(getBlock(), plainVariant(modelLocation)));
        }
    }
}
