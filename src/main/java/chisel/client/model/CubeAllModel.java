package chisel.client.model;

import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;

public class CubeAllModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return TextureMapping.cube(getBlock());
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        blockModels.createTrivialBlock(
                getBlock(),
                TexturedModel.CUBE.updateTexture(
                        map -> map.put(TextureSlot.ALL, variant.getMaterial())
                ));
    }
}
