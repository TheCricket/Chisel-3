package chisel.core.model.special;

import chisel.Chisel;
import chisel.core.Variant;
import chisel.core.VariantModel;
import chisel.core.model.ChiselModelTemplates;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;

import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class MossyTBSModel extends VariantModel {

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.TOP, variant.getMaterial("top"))
                .put(TextureSlot.BOTTOM, variant.getMaterial("bottom"))
                .put(TextureSlot.SIDE, variant.getMaterial("side"))
                .put(TextureSlot.LAYER1, new Material(Chisel.prefix("block/mossy_cobblestone/mossy")));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        MultiVariant model = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_TOP_BOTTOM_SIDE_NO_GLOW.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(getBlock(), model));
    }
}
