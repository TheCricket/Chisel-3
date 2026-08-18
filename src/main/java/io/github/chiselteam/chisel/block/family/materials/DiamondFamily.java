package io.github.chiselteam.chisel.block.family.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class DiamondFamily extends ChiselFamily {
    public DiamondFamily(BlockBehaviour.Properties props) {
        family = builder("diamond")
                .addVariant(Blocks.DIAMOND_BLOCK)
                .addVariant("diamond_bismuth", props)
                .addVariant("diamond_cells", props)
                .addVariant("diamond_crushed", props)
                .addVariant("diamond_embossed", props, TBS)
                .addVariant("diamond_obsidian", props)
                .addVariant("diamond_obsidian_purple", props)
                .addVariant("diamond_ornate", props)
                .addVariant("diamond_panel", props, TBS)
                .addVariant("diamond_simple", props, TBS)
                .addVariant("diamond_small_blocks", props)
                .addVariant("diamond_small_blocks_ornate", props)
                .addVariant("diamond_zelda", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("diamond_bismuth"), "Block of Diamond", "Bismuth Diamond Block");
        lang.addBlock(getVariant("diamond_cells"), "Block of Diamond", "Diamond Cells");
        lang.addBlock(getVariant("diamond_crushed"), "Block of Diamond", "Crushed Diamond");
        lang.addBlock(getVariant("diamond_embossed"), "Block of Diamond", "Embossed Diamond Block");
        lang.addBlock(getVariant("diamond_obsidian"), "Block of Diamond", "Diamonds in Obsidian");
        lang.addBlock(getVariant("diamond_obsidian_purple"), "Block of Diamond", "Diamonds in Purple Obsidian");
        lang.addBlock(getVariant("diamond_ornate"), "Block of Diamond", "Diamond Block with Ornate Layer");
        lang.addBlock(getVariant("diamond_panel"), "Block of Diamond", "Diamond Block with Panel");
        lang.addBlock(getVariant("diamond_simple"), "Block of Diamond", "Simple Diamond Block");
        lang.addBlock(getVariant("diamond_small_blocks"), "Block of Diamond", "Small Diamond Blocks");
        lang.addBlock(getVariant("diamond_small_blocks_ornate"), "Block of Diamond", "Small Ornate Diamond Blocks");
        lang.addBlock(getVariant("diamond_zelda"), "Block of Diamond", "Zelda Diamond Block");
    }
}

