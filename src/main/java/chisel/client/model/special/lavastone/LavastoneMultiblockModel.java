package chisel.client.model.special.lavastone;

import chisel.client.ChiselModelTemplates;
import chisel.client.ChiselTextureSlots;
import chisel.client.ctm.ConnectedTextureBlockStateModelBuilder;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import chisel.datagen.model.ConnectedTextureBlockStateDefinitionGenerator;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluids;
import org.joml.Vector3f;

public class LavastoneMultiblockModel extends VariantModel {

    private final int size;

    public LavastoneMultiblockModel(int size) {
        this.size = size;
    }

    @Override
    public TextureMapping getTextureMapping() {
        TextureSlot overlaySlot = size == 2 ? ChiselTextureSlots.CTM_OVERLAY_2X2 : (size == 3 ? ChiselTextureSlots.CTM_OVERLAY_3X3 : ChiselTextureSlots.CTM_OVERLAY_4X4);
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.ALL, variant.getMaterial())
                .put(TextureSlot.LAYER0, new Material(BuiltInRegistries.FLUID.getKey(Fluids.LAVA.getSource()).withPrefix("block/").withSuffix("_still")))
                .put(TextureSlot.LAYER1, variant.getMaterial())
                .put(overlaySlot, variant.getMaterial(size + "x" + size));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        ModelTemplate template = size == 2 ? ChiselModelTemplates.CTM_MULTI_PASS_MULTIBLOCK_2x2 : (size == 3 ? ChiselModelTemplates.CTM_MULTI_PASS_MULTIBLOCK_3x3 : ChiselModelTemplates.CTM_MULTI_PASS_MULTIBLOCK_4x4);
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
