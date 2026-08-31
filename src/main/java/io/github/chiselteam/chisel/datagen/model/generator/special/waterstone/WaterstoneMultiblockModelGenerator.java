package io.github.chiselteam.chisel.datagen.model.generator.special.waterstone;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.ChiselModelTemplates;
import io.github.chiselteam.chisel.datagen.model.ChiselTextureSlots;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockStateDefinitionGenerator;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockStateModelBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import org.joml.Vector3f;

public class WaterstoneMultiblockModelGenerator extends VariantModelGenerator {

    private final int size;

    public WaterstoneMultiblockModelGenerator(int size) {
        this.size = size;
    }

    @Override
    public TextureMapping getTextureMapping() {
        TextureSlot overlaySlot = size == 2 ? ChiselTextureSlots.CTM_OVERLAY_2X2 : (size == 3 ? ChiselTextureSlots.CTM_OVERLAY_3X3 : ChiselTextureSlots.CTM_OVERLAY_4X4);

        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, VariantTextures.get(variant))
                .put(TextureSlot.ALL, VariantTextures.get(variant))
                .put(TextureSlot.LAYER0, new Material(Chisel.prefix("block/%s/water_still".formatted(variant.getFamily().getFamilyName()))))
                .put(TextureSlot.LAYER1, VariantTextures.get(variant))
                .put(overlaySlot, VariantTextures.get(variant, size + "x" + size));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        ModelTemplate template = size == 2 ? ChiselModelTemplates.CTM_MULTIBLOCK_2x2_WATER : (size == 3 ? ChiselModelTemplates.CTM_MULTIBLOCK_3x3_WATER : ChiselModelTemplates.CTM_MULTIBLOCK_4x4_WATER);
        Identifier modelLocation = template.create(getBlock(), getTextureMapping(), blockModels.modelOutput);
        blockModels.registerSimpleItemModel(getBlock(), modelLocation);
        blockModels.blockStateOutput.accept(ConnectedTextureBlockStateDefinitionGenerator.dispatch(variant.getBlock(), new ConnectedTextureBlockStateModelBuilder()
                .modelLocation(modelLocation)
                .renderOverlayOnAllFaces(true)
                .variant(variant)
                .baseTintIndex(0)
                .connectedFace(Direction.UP)
                .connectedFace(Direction.DOWN)
                .connectedFace(Direction.NORTH)
                .connectedFace(Direction.WEST)
                .connectedFace(Direction.EAST)
                .connectedFace(Direction.SOUTH)
                .element(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16))
        ));
    }
}
