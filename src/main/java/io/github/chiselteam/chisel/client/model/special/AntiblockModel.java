package io.github.chiselteam.chisel.client.model.special;

import io.github.chiselteam.chisel.client.ChiselModelTemplates;
import io.github.chiselteam.chisel.client.ChiselTextureSlots;
import io.github.chiselteam.chisel.core.variant.Variant;
import io.github.chiselteam.chisel.core.variant.VariantModel;
import io.github.chiselteam.chisel.datagen.model.ConnectedTextureBlockStateDefinitionGenerator;
import io.github.chiselteam.chisel.datagen.model.ConnectedTextureBlockStateModelBuilder;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import org.joml.Vector3f;

public class AntiblockModel extends VariantModel {

    public AntiblockModel() {
    }

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.ALL, variant.getMaterial())
                .put(TextureSlot.LAYER1, variant.getMaterial())
                .put(TextureSlot.LAYER0, variant.getMaterial("bg"))
                .put(ChiselTextureSlots.CTM_BASE, variant.getMaterial("bg"))
                .put(ChiselTextureSlots.CTM_OVERLAY, variant.getMaterial())
                .put(ChiselTextureSlots.CTM_OVERLAY_CONNECTED, variant.getMaterial("ctm"));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        ModelTemplate template = ChiselModelTemplates.CTM_MULTI_PASS_NO_SHADE;
        Identifier modelLocation = template.create(getBlock(), getTextureMapping(), blockModels.modelOutput);
        blockModels.registerSimpleItemModel(getBlock(), modelLocation);
        ConnectedTextureBlockStateModelBuilder builder = new ConnectedTextureBlockStateModelBuilder()
                .modelLocation(modelLocation)
                .renderOverlayOnAllFaces(true)
                .variant(variant)
                .connectedFace(Direction.UP)
                .connectedFace(Direction.DOWN)
                .connectedFace(Direction.NORTH)
                .connectedFace(Direction.WEST)
                .connectedFace(Direction.EAST)
                .connectedFace(Direction.SOUTH)
                .baseEmissivity(15)
                .emissivity(15)
                .shade(false)
                .ambientOcclusion(false)
                .element(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16));

        blockModels.blockStateOutput.accept(ConnectedTextureBlockStateDefinitionGenerator.dispatch(variant.getBlock(), builder));
    }
}
