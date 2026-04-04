package chisel.core.model.special;

import chisel.Chisel;
import chisel.client.ChiselModelTemplates;
import chisel.core.Variant;
import chisel.core.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.world.item.Item;

public class TorchModel extends VariantModel {

    private final boolean isWallTorch;

    public TorchModel(boolean wallTorch) {
        isWallTorch = wallTorch;
    }

    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping()).put(TextureSlot.TORCH, isWallTorch ? new Material(Chisel.prefix("block/torch/torch_%s".formatted(variant.getName().substring(11)))) : variant.getMaterial());
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
            blockModels.registerSimpleItemModel(item, ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(variant.getMaterial()), blockModels.modelOutput));
        }
    }
}
