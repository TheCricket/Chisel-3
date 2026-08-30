package io.github.chiselteam.chisel.datagen.model.generator;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import io.github.chiselteam.chisel.datagen.model.blockstate.EldritchBlockStateModelBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class TopBottomSideModelGenerator extends VariantModelGenerator {

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.TOP, VariantTextures.get(variant, "top"))
                .put(TextureSlot.BOTTOM, VariantTextures.get(variant, "bottom"))
                .put(TextureSlot.SIDE, VariantTextures.get(variant, "side"));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        Identifier modelLocation = ModelTemplates.CUBE_BOTTOM_TOP.create(getBlock(), getTextureMapping(), blockModels.modelOutput);
        if (variant.isEldritch()) {
            MultiVariant inner = plainVariant(modelLocation);
            EldritchBlockStateModelBuilder builder = new EldritchBlockStateModelBuilder().inner(inner.toUnbaked());
            blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(getBlock(), MultiVariant.of(builder)));
        } else {
            blockModels.blockStateOutput.accept(createSimpleBlock(getBlock(), plainVariant(modelLocation)));
        }
    }
}
