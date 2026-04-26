package chisel.datagen.model;

import chisel.Chisel;
import chisel.block.util.ChiselFamily;
import chisel.datagen.ChiselVariants;
import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.stream.Stream;

public class ChiselModelProvider extends ModelProvider {

    public ChiselModelProvider(PackOutput output) {
        super(output, Chisel.MODID);
    }

    @Override
    protected void registerModels(@NonNull BlockModelGenerators blockModels, @NonNull ItemModelGenerators itemModels) {
        ChiselBlocks.getBlocks().forEach(ChiselFamily::getFamily);
        ChiselVariants.getVariantFamilies().forEach(family -> family.getVariants().forEach(variant -> {
            if(variant.shouldGenerateModel())
                variant.registerModel(blockModels);
        }));

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(ChiselBlocks.AUTO_CHISEL.get(), BlockModelGenerators.variant(new Variant(Chisel.prefix("block/auto_chisel")))));
        blockModels.registerSimpleItemModel(ChiselBlocks.AUTO_CHISEL.get(), Chisel.prefix("block/auto_chisel"));

        itemModels.generateFlatItem(ChiselItems.CHISEL_IRON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ChiselItems.CHISEL_DIAMOND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ChiselItems.CHISEL_OBSIDIAN.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ChiselItems.UPGRADE_STACK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.UPGRADE_SPEED.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.UPGRADE_REVERSION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.UPGRADE_AUTOMATION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.BALL_O_MOSS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.CLOUD_IN_A_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ChiselItems.SMASHING_ROCK.get(), ModelTemplates.FLAT_ITEM);
    }

    @Override
    protected @NonNull Stream<? extends Holder<Block>> getKnownBlocks() {
        return ChiselBlocks.BLOCKS.getEntries().stream();
    }
}
