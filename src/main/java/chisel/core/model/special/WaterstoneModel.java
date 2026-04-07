package chisel.core.model.special;

import chisel.Chisel;
import chisel.client.ChiselModelTemplates;
import chisel.core.Variant;
import chisel.core.VariantModel;
import chisel.core.model.MultiLayerModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluids;

import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class WaterstoneModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, variant.getMaterial())
                .put(TextureSlot.LAYER1, new Material(Chisel.prefix("block/%s/water_still".formatted(variant.getFamily().getFamilyName()))))
                .put(TextureSlot.LAYER0, variant.getMaterial());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        MultiVariant model = plainVariant(ChiselModelTemplates.CUBE_MULTI_PASS_TINTED.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(getBlock(), model));
    }
}
