package io.github.chiselteam.chisel.datagen.model.generator.special;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.ChiselModelTemplates;
import io.github.chiselteam.chisel.datagen.model.ChiselTextureSlots;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockStateDefinitionGenerator;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockStateModelBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import org.joml.Vector3f;

public class GlassModelGenerator extends VariantModelGenerator {

    @Override
    public TextureMapping getTextureMapping() {
        return new TextureMapping()
                .put(TextureSlot.PARTICLE, VariantTextures.get(variant))
                .put(ChiselTextureSlots.CTM_OVERLAY, VariantTextures.get(variant))
                .put(ChiselTextureSlots.CTM_OVERLAY_CONNECTED, VariantTextures.get(variant, "ctm"));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        Identifier modelLocation = ChiselModelTemplates.CTM_OVERLAY_ONLY.create(getBlock(), getTextureMapping(), blockModels.modelOutput);
        Identifier itemModelLocation = ModelTemplates.CUBE_ALL.create(
                ModelLocationUtils.getModelLocation(getBlock().asItem()),
                new TextureMapping().put(TextureSlot.ALL, VariantTextures.get(variant)),
                blockModels.modelOutput
        );
        blockModels.registerSimpleItemModel(getBlock(), itemModelLocation);
        blockModels.blockStateOutput.accept(ConnectedTextureBlockStateDefinitionGenerator.dispatch(getBlock(),
                new ConnectedTextureBlockStateModelBuilder()
                        .modelLocation(modelLocation)
                        .variant(variant)
                        .connectedFace(Direction.UP)
                        .connectedFace(Direction.DOWN)
                        .connectedFace(Direction.NORTH)
                        .connectedFace(Direction.WEST)
                        .connectedFace(Direction.EAST)
                        .connectedFace(Direction.SOUTH)
                        .element(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16))));
    }
}
