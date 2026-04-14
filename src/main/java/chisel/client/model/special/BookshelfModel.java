package chisel.client.model.special;

import chisel.Chisel;
import chisel.client.ChiselModelTemplates;
import chisel.client.ChiselTextureSlots;
import chisel.client.ctm.ConnectedTextureBlockStateModelBuilder;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import chisel.datagen.model.ConnectedTextureBlockStateDefinitionGenerator;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import org.joml.Vector3f;

public class BookshelfModel extends VariantModel {
    private final String[] woods = {"_dark_oak", "_pale_oak", "_mangrove", "_spruce", "_jungle", "_acacia", "_cherry", "_bamboo", "_crimson", "_warped", "_birch", "_oak"};

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getBlockMaterial())
                .put(TextureSlot.TOP, getBlockMaterial())
                .put(TextureSlot.BOTTOM, getBlockMaterial())
                .put(TextureSlot.SIDE, getMaterial())
                .put(TextureSlot.LAYER0, getBlockMaterial())
                .put(TextureSlot.LAYER1, getBlockMaterial())
                .put(ChiselTextureSlots.CTM_BASE, getBlockMaterial())
                .put(ChiselTextureSlots.CTM_OVERLAY_HORIZONTAL, getMaterialCTM());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        Identifier modelLocation = ChiselModelTemplates.CTM_HORIZONTAL_MULTI_PASS.create(getBlock(), getTextureMapping(), blockModels.modelOutput);
        blockModels.registerSimpleItemModel(getBlock(), modelLocation);
        blockModels.blockStateOutput.accept(ConnectedTextureBlockStateDefinitionGenerator.dispatch(variant.getBlock(), new ConnectedTextureBlockStateModelBuilder()
                .modelLocation(modelLocation)
                .renderOverlayOnAllFaces(false)
                .variant(variant)
                .connectedFace(Direction.NORTH)
                .connectedFace(Direction.SOUTH)
                .connectedFace(Direction.EAST)
                .connectedFace(Direction.WEST)
                .element(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16))
        ));
    }

    private Material getBlockMaterial() {
        String path = variant.getMaterial().sprite().getPath();
        for(String wood : woods) {
            if(path.contains(wood)) {
                return new Material(Identifier.withDefaultNamespace("block/%s_planks".formatted(wood.substring(1))));
            }
        }

        return new Material(Identifier.withDefaultNamespace("missingno"));
    }

    private Material getMaterial() {
        return new Material(Chisel.prefix(cleanId(variant.getMaterial().sprite().getPath())));
    }

    private Material getMaterialCTM() {
        return new Material(Chisel.prefix(cleanId(variant.getMaterial("ctm").sprite().getPath())));
    }

    private String cleanId(String path) {
        String ret = path;
        for(String wood : woods) {
            ret = ret.replace(wood, "");
        }
        return ret;
    }
}
