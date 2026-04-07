package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DiamondFamily extends ChiselBlock {
    public DiamondFamily(BlockBehaviour.Properties props) {
        family = builder("diamond")
                .addVariant(Blocks.DIAMOND_BLOCK)
                .addVariant("diamond_bismuth", props)
                .addVariant("diamond_cells", props)
                .addVariant("diamond_crushed", props)
                .addVariant("diamond_embossed", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("diamond_obsidian", props)
                .addVariant("diamond_obsidian_purple", props)
                .addVariant("diamond_ornate", props)
                .addVariant("diamond_panel", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("diamond_simple", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("diamond_small_blocks", props)
                .addVariant("diamond_small_blocks_ornate", props)
                .addVariant("diamond_zelda", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("diamond_bismuth"), "Diamond", "Bismuth");
        lang.addBlock(getVariant("diamond_cells"), "Diamond", "Cells");
        lang.addBlock(getVariant("diamond_crushed"), "Diamond", "Crushed");
        lang.addBlock(getVariant("diamond_embossed"), "Diamond", "Embossed");
        lang.addBlock(getVariant("diamond_obsidian"), "Diamond", "Obsidian");
        lang.addBlock(getVariant("diamond_obsidian_purple"), "Diamond", "Obsidian Purple");
        lang.addBlock(getVariant("diamond_ornate"), "Diamond", "Ornate");
        lang.addBlock(getVariant("diamond_panel"), "Diamond", "Panel");
        lang.addBlock(getVariant("diamond_simple"), "Diamond", "Simple");
        lang.addBlock(getVariant("diamond_small_blocks"), "Diamond", "Small Blocks");
        lang.addBlock(getVariant("diamond_small_blocks_ornate"), "Diamond", "Small Blocks Ornate");
        lang.addBlock(getVariant("diamond_zelda"), "Diamond", "Zelda");
    }
}

