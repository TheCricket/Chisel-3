package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ObsidianFamily extends ChiselBlock {
    public ObsidianFamily(BlockBehaviour.Properties props) {
        family = builder("obsidian")
                .addVariant(Blocks.OBSIDIAN)
                .addVariant("obsidian_blocks", props)
                .addVariant("obsidian_chiseled", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("obsidian_crate", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("obsidian_crate_unboxed", props)
                .addVariant("obsidian_crystal", props)
                .addVariant("obsidian_greek", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("obsidian_organic_chunks", props)
                .addVariant("obsidian_organic_growth", props)
                .addVariant("obsidian_panel", props)
                .addVariant("obsidian_panel_bright", props)
                .addVariant("obsidian_panel_map", props)
                .addVariant("obsidian_panel_region", props)
                .addVariant("obsidian_panel_shiny", props)
                .addVariant("obsidian_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("obsidian_pillar_quartz", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("obsidian_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("obsidian_blocks"), "Obsidian", "Blocks");
        lang.addBlock(getVariant("obsidian_chiseled"), "Obsidian", "Chiseled");
        lang.addBlock(getVariant("obsidian_crate"), "Obsidian", "Crate");
        lang.addBlock(getVariant("obsidian_crate_unboxed"), "Obsidian", "Unboxed Crate");
        lang.addBlock(getVariant("obsidian_crystal"), "Obsidian", "Crystal");
        lang.addBlock(getVariant("obsidian_greek"), "Obsidian", "Greek");
        lang.addBlock(getVariant("obsidian_organic_chunks"), "Obsidian", "Organic Chunks");
        lang.addBlock(getVariant("obsidian_organic_growth"), "Obsidian", "Organic Growth");
        lang.addBlock(getVariant("obsidian_panel"), "Obsidian", "Panel");
        lang.addBlock(getVariant("obsidian_panel_bright"), "Obsidian", "Bright Panel");
        lang.addBlock(getVariant("obsidian_panel_map"), "Obsidian", "Map Panel");
        lang.addBlock(getVariant("obsidian_panel_region"), "Obsidian", "Region Panel");
        lang.addBlock(getVariant("obsidian_panel_shiny"), "Obsidian", "Shiny Panel");
        lang.addBlock(getVariant("obsidian_pillar"), "Obsidian", "Pillar");
        lang.addBlock(getVariant("obsidian_pillar_quartz"), "Obsidian", "Quartz Pillar");
        lang.addBlock(getVariant("obsidian_tiles"), "Obsidian", "Tiles");
    }
}

