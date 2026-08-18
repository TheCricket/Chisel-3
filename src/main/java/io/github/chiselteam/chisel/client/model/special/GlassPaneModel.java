package io.github.chiselteam.chisel.client.model.special;

import io.github.chiselteam.chisel.core.variant.Variant;
import io.github.chiselteam.chisel.core.variant.VariantModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.dispatch.multipart.CombinedCondition;
import net.minecraft.client.renderer.block.dispatch.multipart.Condition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.List;

import static net.minecraft.client.data.models.BlockModelGenerators.*;
import static io.github.chiselteam.chisel.client.ChiselModelTemplates.GLASS_PANE_END;
import static io.github.chiselteam.chisel.client.ChiselModelTemplates.GLASS_PANE_END_ALT;
import static io.github.chiselteam.chisel.client.ChiselModelTemplates.GLASS_PANE_SIDE;
import static io.github.chiselteam.chisel.client.ChiselModelTemplates.GLASS_PANE_SIDE_ALT;
import static net.minecraft.client.renderer.block.dispatch.multipart.CombinedCondition.Operation.AND;
import static net.minecraft.client.renderer.block.dispatch.multipart.CombinedCondition.Operation.OR;

public class GlassPaneModel extends VariantModel {
    @Override
    public TextureMapping getTextureMapping() {
        return (new TextureMapping()).put(TextureSlot.PANE, variant.getMaterial()).put(TextureSlot.EDGE, variant.getMaterial("top"));
    }

    @Override
    public void generate(Variant variant, BlockModelGenerators blockModels) {
        super.generate(variant, blockModels);

        MultiVariant post = plainVariant(ModelTemplates.STAINED_GLASS_PANE_POST.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant side = plainVariant(GLASS_PANE_SIDE.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant sideAlt = plainVariant(GLASS_PANE_SIDE_ALT.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant noSide = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant noSideAlt = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant end = plainVariant(GLASS_PANE_END.create(getBlock(), getTextureMapping(), blockModels.modelOutput));
        MultiVariant endAlt = plainVariant(GLASS_PANE_END_ALT.create(getBlock(), getTextureMapping(), blockModels.modelOutput));

        blockModels.registerSimpleItemModel(getBlock().asItem(), ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(getBlock().asItem()), TextureMapping.layer0(variant.getMaterial()), blockModels.modelOutput));

        blockModels.blockStateOutput.accept(
                MultiPartGenerator.multiPart(getBlock())
                        .with(post)
                        .with(condition().term(BlockStateProperties.NORTH, true), side)
                        .with(condition().term(BlockStateProperties.EAST, true), side.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.SOUTH, true), sideAlt)
                        .with(condition().term(BlockStateProperties.WEST, true), sideAlt.with(Y_ROT_90))
                        .with(centerCondition(BlockStateProperties.NORTH, BlockStateProperties.SOUTH, BlockStateProperties.EAST, BlockStateProperties.WEST), noSide)
                        .with(centerCondition(BlockStateProperties.EAST, BlockStateProperties.WEST, BlockStateProperties.NORTH, BlockStateProperties.SOUTH), noSideAlt)
                        .with(centerCondition(BlockStateProperties.SOUTH, BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.WEST), noSideAlt.with(Y_ROT_90))
                        .with(centerCondition(BlockStateProperties.WEST, BlockStateProperties.EAST, BlockStateProperties.NORTH, BlockStateProperties.SOUTH), noSide.with(Y_ROT_270))
                        .with(endCondition(BlockStateProperties.NORTH, BlockStateProperties.SOUTH, BlockStateProperties.EAST, BlockStateProperties.WEST), end)
                        .with(endCondition(BlockStateProperties.EAST, BlockStateProperties.WEST, BlockStateProperties.NORTH, BlockStateProperties.SOUTH), endAlt)
                        .with(endCondition(BlockStateProperties.SOUTH, BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.WEST), endAlt.with(Y_ROT_90))
                        .with(endCondition(BlockStateProperties.WEST, BlockStateProperties.EAST, BlockStateProperties.NORTH, BlockStateProperties.SOUTH), end.with(Y_ROT_270))
        );
    }

    private static Condition centerCondition(Property<Boolean> direction, Property<Boolean> opposite, Property<Boolean> perpendicularA, Property<Boolean> perpendicularB) {
        return new CombinedCondition(AND, List.of(
                condition().term(direction, false).build(),
                new CombinedCondition(OR, List.of(
                        condition().term(opposite, false).build(),
                        condition().term(perpendicularA, true).build(),
                        condition().term(perpendicularB, true).build()
                ))
        ));
    }

    private static Condition endCondition(Property<Boolean> direction, Property<Boolean> opposite, Property<Boolean> perpendicularA, Property<Boolean> perpendicularB) {
        return condition()
                .term(direction, false)
                .term(opposite, true)
                .term(perpendicularA, false)
                .term(perpendicularB, false)
                .build();
    }
}
