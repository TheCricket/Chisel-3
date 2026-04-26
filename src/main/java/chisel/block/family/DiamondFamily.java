package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DiamondFamily extends ChiselFamily {
    public DiamondFamily(BlockBehaviour.Properties props) {
        family = builder("diamond")
                .addVariant(Blocks.DIAMOND_BLOCK)
                .addVariant("diamond_bismuth", props)
                .addVariant("diamond_cells", props)
                .addVariant("diamond_crushed", props)
                .addVariant("diamond_embossed", props, VariantModelType.TBS)
                .addVariant("diamond_obsidian", props)
                .addVariant("diamond_obsidian_purple", props)
                .addVariant("diamond_ornate", props)
                .addVariant("diamond_panel", props, VariantModelType.TBS)
                .addVariant("diamond_simple", props, VariantModelType.TBS)
                .addVariant("diamond_small_blocks", props)
                .addVariant("diamond_small_blocks_ornate", props)
                .addVariant("diamond_zelda", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("diamond_bismuth"), "Diamond", "Bismuth Diamond Block");
        lang.addBlock(getVariant("diamond_cells"), "Diamond", "Diamond Cells");
        lang.addBlock(getVariant("diamond_crushed"), "Diamond", "Crushed Diamond");
        lang.addBlock(getVariant("diamond_embossed"), "Diamond", "Embossed Diamond Block");
        lang.addBlock(getVariant("diamond_obsidian"), "Diamond", "Diamonds in Obsidian");
        lang.addBlock(getVariant("diamond_obsidian_purple"), "Diamond", "Diamonds in Purple Obsidian");
        lang.addBlock(getVariant("diamond_ornate"), "Diamond", "Diamond Block with Ornate Layer");
        lang.addBlock(getVariant("diamond_panel"), "Diamond", "Diamond Block with Panel");
        lang.addBlock(getVariant("diamond_simple"), "Diamond", "Simple Diamond Block");
        lang.addBlock(getVariant("diamond_small_blocks"), "Diamond", "Small Diamond Blocks");
        lang.addBlock(getVariant("diamond_small_blocks_ornate"), "Diamond", "Small Ornate Diamond Blocks");
        lang.addBlock(getVariant("diamond_zelda"), "Diamond", "Zelda Diamond Block");
    }
}

