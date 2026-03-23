package chisel.core.model;

import chisel.core.Variant;
import chisel.core.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;

public class PillarModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return TextureMapping.column(getBlock());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        blockModels.createTrivialBlock(
                variant.getBlock(),
                TexturedModel.COLUMN.updateTexture(
                        map -> map.put(TextureSlot.SIDE, variant.getMaterial("side")).put(TextureSlot.END, variant.getMaterial("end"))
                ));
    }
}
