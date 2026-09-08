package io.github.chiselteam.chisel.datagen.model.generator.special;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.datagen.model.ChiselModelTemplates;
import io.github.chiselteam.chisel.datagen.model.VariantModelGenerator;
import io.github.chiselteam.chisel.datagen.model.VariantTextures;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.world.item.Item;

public class TorchModelGenerator extends VariantModelGenerator {

    private final boolean isWallTorch;

    public TorchModelGenerator(boolean wallTorch) {
        isWallTorch = wallTorch;
    }

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping()).put(TextureSlot.TORCH, isWallTorch ? new Material(Chisel.prefix("block/torch/torch_%s".formatted(variant.getName().substring(11)))) : VariantTextures.get(variant));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);
        if (isWallTorch) {
            blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.dispatch(
                            getBlock(),
                            BlockModelGenerators.plainVariant(
                                    ChiselModelTemplates.WALL_TORCH.create(
                                            getBlock(),
                                            getTextureMapping(),
                                            blockModels.modelOutput
                                    )
                            )
                    ).with(BlockModelGenerators.ROTATION_TORCH));
        } else {
            blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(getBlock(), BlockModelGenerators.plainVariant(ChiselModelTemplates.TORCH.create(getBlock(), getTextureMapping(), blockModels.modelOutput))));
            Item item = getBlock().asItem();
            blockModels.registerSimpleItemModel(item, ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(VariantTextures.get(variant)), blockModels.modelOutput));
        }
    }
}
