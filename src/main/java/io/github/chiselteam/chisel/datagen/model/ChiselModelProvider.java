package io.github.chiselteam.chisel.datagen.model;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.datagen.ChiselVariants;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import io.github.chiselteam.chisel.registry.ChiselItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ChiselModelProvider extends ModelProvider {

    public ChiselModelProvider(PackOutput output) {
        super(output, Chisel.MODID);
    }

    @Override
    protected void registerModels(@NonNull BlockModelGenerators blockModels, @NonNull ItemModelGenerators itemModels) {
        ChiselBlocks.getBlocks().forEach(ChiselFamily::getFamily);
        Set<String> processedFamilies = new HashSet<>();
        ChiselVariants.getVariantFamilies().forEach(family -> registerFamilyModels(family, blockModels, processedFamilies));

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(ChiselBlocks.AUTO_CHISEL.get(), BlockModelGenerators.variant(new Variant(Chisel.prefix("block/auto_chisel")))));
        blockModels.registerSimpleItemModel(ChiselBlocks.AUTO_CHISEL.get(), Chisel.prefix("block/auto_chisel"));

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(
                        ChiselBlocks.BUILDERS_GUIDE.get(),
                        BlockModelGenerators.plainVariant(
                                ModelTemplates.CUBE_BOTTOM_TOP.create(
                                        ChiselBlocks.BUILDERS_GUIDE.get(),
                                        new TextureMapping()
                                                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(ChiselBlocks.BUILDERS_GUIDE.get(), "_top"))
                                                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ChiselBlocks.BUILDERS_GUIDE.get(), "_top"))
                                                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ChiselBlocks.BUILDERS_GUIDE.get(), "_bottom"))
                                                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ChiselBlocks.BUILDERS_GUIDE.get(), "_side")),
                                        blockModels.modelOutput
                                )
                        )
                )
        );
        blockModels.registerSimpleItemModel(ChiselBlocks.BUILDERS_GUIDE.get(), Chisel.prefix("block/builders_guide"));

        itemModels.generateFlatItem(ChiselItems.CHISEL_IRON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ChiselItems.CHISEL_DIAMOND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ChiselItems.CHISEL_OBSIDIAN.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ChiselItems.OFFSET_TOOL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ChiselItems.UPGRADE_STACK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.UPGRADE_SPEED.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.UPGRADE_REVERSION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.UPGRADE_AUTOMATION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.BALL_O_MOSS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.CLOUD_IN_A_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.SMASHING_ROCK.get(), ModelTemplates.FLAT_ITEM);
    }

    private void registerFamilyModels(VariantFamily family, BlockModelGenerators blockModels, Set<String> processedFamilies) {
        if (!processedFamilies.add(family.getFamilyName())) {
            return;
        }
        family.getVariants().forEach(variant -> {
            if (variant.shouldGenerateModel()) {
                variant.registerModel(blockModels);
            }
        });
        family.getHiddenVariants().forEach(variant -> {
            if (variant.shouldGenerateModel()) {
                variant.registerModel(blockModels);
            }
        });
        if (family.getWaxedFamily() != null) {
            registerFamilyModels(family.getWaxedFamily(), blockModels, processedFamilies);
        }
    }

    @Override
    protected @NonNull Stream<? extends Holder<Block>> getKnownBlocks() {
        return ChiselBlocks.BLOCKS.getEntries().stream();
    }
}
