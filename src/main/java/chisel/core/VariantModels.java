package chisel.core;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Block;

public class VariantModels {

    protected void registerBlockModel(Variant variant, BlockModelGenerators blockModels) {
        blockModels.createTrivialBlock(
                variant.getBlock().get(),
                TexturedModel.CUBE.updateTexture(
                        map -> map.put(TextureSlot.ALL, variant.getMaterial())
                ));
    }

    protected void registerBookshelf(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();
        TextureMapping textures = TextureMapping.column(variant.getMaterial(), variant.getMaterial("top"));
        MultiVariant model = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_COLUMN.create(block, textures, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, model));
    }

    protected void registerBTSModel(Variant variant, BlockModelGenerators blockModels) {
        Block block = variant.getBlock().get();
        TextureMapping textures = (new TextureMapping())
                .put(TextureSlot.TOP, variant.getMaterial("top"))
                .put(TextureSlot.BOTTOM, variant.getMaterial("bottom"))
                .put(TextureSlot.SIDE, variant.getMaterial("side"));
        MultiVariant model = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_BOTTOM_TOP_INNER_FACES.create(block, textures, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, model));
    }
}
