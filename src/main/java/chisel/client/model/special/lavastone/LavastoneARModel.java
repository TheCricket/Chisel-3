package chisel.client.model.special.lavastone;

import chisel.client.ChiselModelTemplates;
import chisel.client.ChiselTextureSlots;
import chisel.client.ctm.ConnectedTextureBlockStateModelBuilder;
import chisel.client.model.ctm.ARModel;
import chisel.core.variant.Variant;
import chisel.datagen.model.ConnectedTextureBlockStateDefinitionGenerator;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluids;
import org.joml.Vector3f;

public class LavastoneARModel extends ARModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.ALL, variant.getMaterial())
                .put(ChiselTextureSlots.CTM_OVERLAY_2X2, variant.getMaterial("ctm"))
                .put(TextureSlot.LAYER0, new Material(BuiltInRegistries.FLUID.getKey(Fluids.LAVA.getSource()).withPrefix("block/").withSuffix("_still")))
                .put(TextureSlot.LAYER1, variant.getMaterial());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        setVariant(variant);
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
