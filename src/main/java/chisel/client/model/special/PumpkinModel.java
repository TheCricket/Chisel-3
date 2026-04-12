package chisel.client.model.special;

import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;

import static net.minecraft.client.data.models.BlockModelGenerators.ROTATION_HORIZONTAL_FACING;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class PumpkinModel extends VariantModel {

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.FRONT, variant.getMaterial())
                .put(TextureSlot.SIDE, new Material(Identifier.withDefaultNamespace("block/pumpkin_side")))
                .put(TextureSlot.END, new Material(Identifier.withDefaultNamespace("block/pumpkin_top")));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        MultiVariant model = plainVariant(ModelTemplates.CUBE_ORIENTABLE.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(getBlock(), model).with(ROTATION_HORIZONTAL_FACING));
    }
}
