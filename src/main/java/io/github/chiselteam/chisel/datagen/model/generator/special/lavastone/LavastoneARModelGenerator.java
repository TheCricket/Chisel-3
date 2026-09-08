package io.github.chiselteam.chisel.datagen.model.generator.special.lavastone;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.ChiselModelTemplates;
import io.github.chiselteam.chisel.datagen.model.ChiselTextureSlots;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockStateDefinitionGenerator;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockStateModelBuilder;
import io.github.chiselteam.chisel.datagen.model.generator.ctm.ARModelGenerator;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluids;
import org.joml.Vector3f;

public class LavastoneARModelGenerator extends ARModelGenerator {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, VariantTextures.get(variant))
                .put(TextureSlot.ALL, VariantTextures.get(variant))
                .put(ChiselTextureSlots.CTM_OVERLAY_2X2, VariantTextures.get(variant, "ctm"))
                .put(TextureSlot.LAYER0, new Material(BuiltInRegistries.FLUID.getKey(Fluids.LAVA.getSource()).withPrefix("block/").withSuffix("_still")))
                .put(TextureSlot.LAYER1, VariantTextures.get(variant));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        this.variant = variant;
        this.blockModels = blockModels;
        
        Identifier modelLocation = ChiselModelTemplates.CTM_MULTIBLOCK_2x2_LAVA.create(getBlock(), getTextureMapping(), blockModels.modelOutput);
        blockModels.registerSimpleItemModel(getBlock(), modelLocation);
        blockModels.blockStateOutput.accept(ConnectedTextureBlockStateDefinitionGenerator.dispatch(variant.getBlock(), new ConnectedTextureBlockStateModelBuilder()
                .modelLocation(modelLocation)
                .renderOverlayOnAllFaces(true)
                .variant(variant)
                .baseTintIndex(-1)
                .baseEmissivity(15)
                .emissivity(0)
                .connectedFace(Direction.NORTH)
                .connectedFace(Direction.SOUTH)
                .connectedFace(Direction.EAST)
                .connectedFace(Direction.WEST)
                .connectedFace(Direction.UP)
                .connectedFace(Direction.DOWN)
                .element(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16))
        ));
    }
}
