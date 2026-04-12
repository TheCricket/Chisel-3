package chisel.client.model.ctm;

import chisel.client.ChiselModelTemplates;
import chisel.client.ChiselTextureSlots;
import chisel.client.ctm.ConnectedTextureBlockStateModelBuilder;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import chisel.datagen.model.ConnectedTextureBlockStateDefinitionGenerator;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import org.joml.Vector3f;

public class CTMHModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.ALL, variant.getMaterial())
                .put(TextureSlot.TOP, variant.getMaterial("top"))
                .put(TextureSlot.BOTTOM, variant.getMaterial("bottom"))
                .put(TextureSlot.SIDE, variant.getMaterial("side"))
                .put(ChiselTextureSlots.CTM_OVERLAY, variant.getMaterial())
                .put(ChiselTextureSlots.CTM_OVERLAY_TOP, variant.getMaterial("top"))
                .put(ChiselTextureSlots.CTM_OVERLAY_BOTTOM, variant.getMaterial("bottom"))
                .put(ChiselTextureSlots.CTM_OVERLAY_SIDE, variant.getMaterial("side"))
                .put(ChiselTextureSlots.CTM_OVERLAY_SIDE_CONNECTED, variant.getMaterial("side-ctm"))
                .put(ChiselTextureSlots.CTM_OVERLAY_BOTTOM_CONNECTED, variant.getMaterial("bottom-ctm"))
                .put(ChiselTextureSlots.CTM_OVERLAY_TOP_CONNECTED, variant.getMaterial("top-ctm"))
                .put(ChiselTextureSlots.CTM_OVERLAY_CONNECTED, variant.getMaterial("ctmv"));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        Identifier modelLocation = ChiselModelTemplates.CTM.create(getBlock(), getTextureMapping(), blockModels.modelOutput);
        blockModels.registerSimpleItemModel(getBlock(), modelLocation);
        blockModels.blockStateOutput.accept(ConnectedTextureBlockStateDefinitionGenerator.dispatch(variant.getBlock(), new ConnectedTextureBlockStateModelBuilder()
                .modelLocation(modelLocation)
                .renderOverlayOnAllFaces(true)
                .variant(variant)
                .connectedFace(Direction.NORTH)
                .connectedFace(Direction.SOUTH)
                .connectedFace(Direction.EAST)
                .connectedFace(Direction.WEST)
                .element(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16))
        ));
    }
}
