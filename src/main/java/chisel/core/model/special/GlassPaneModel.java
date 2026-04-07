package chisel.core.model.special;

import chisel.core.variant.Variant;
import chisel.core.variant.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class GlassPaneModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping()).put(TextureSlot.PANE, variant.getMaterial()).put(TextureSlot.EDGE, variant.getMaterial("top")).forceAllTranslucent();
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);

        MultiVariant post = plainVariant(ModelTemplates.STAINED_GLASS_PANE_POST.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant side = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant sideAlt = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant noSide = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant noSideAlt = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(getBlock(), getTextureMapping(), blockModels.modelOutput));

        blockModels.registerSimpleItemModel(getBlock().asItem(), ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(getBlock().asItem()), TextureMapping.layer0(variant.getMaterial()), blockModels.modelOutput));

        blockModels.blockStateOutput.accept(
                MultiPartGenerator.multiPart(getBlock())
                        .with(post)
                        .with(condition().term(BlockStateProperties.NORTH, true), side)
                        .with(condition().term(BlockStateProperties.EAST, true), side.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.SOUTH, true), sideAlt)
                        .with(condition().term(BlockStateProperties.WEST, true), sideAlt.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, false), noSide)
                        .with(condition().term(BlockStateProperties.EAST, false), noSideAlt)
                        .with(condition().term(BlockStateProperties.SOUTH, false), noSideAlt.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.WEST, false), noSide.with(Y_ROT_90))
        );
    }
}
