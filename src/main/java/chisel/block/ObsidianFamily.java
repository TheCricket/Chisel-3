package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ObsidianFamily extends ChiselBlock {
    public ObsidianFamily(BlockBehaviour.Properties props) {
        family = builder("obsidian")
                .addVariant(Blocks.OBSIDIAN)
                .addVariant("obsidian_blocks", props)
                .addVariant("obsidian_chiseled", props, VariantModelType.TBS)
                .addVariant("obsidian_crate", props, VariantModelType.TBS)
                .addVariant("obsidian_crate_unboxed", props)
                .addVariant("obsidian_crystal", props)
                .addVariant("obsidian_greek", props, VariantModelType.TBS)
                .addVariant("obsidian_organic_chunks", props)
                .addVariant("obsidian_organic_growth", props)
                .addVariant("obsidian_panel", props)
                .addVariant("obsidian_panel_bright", props)
                .addVariant("obsidian_panel_map", props)
                .addVariant("obsidian_panel_region", props)
                .addVariant("obsidian_panel_shiny", props)
                .addVariant("obsidian_pillar", props, VariantModelType.TBS)
                .addVariant("obsidian_pillar_quartz", props, VariantModelType.TBS)
                .addVariant("obsidian_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("obsidian_blocks"), "Obsidian", "Obsidian Blocks");
        lang.addBlock(getVariant("obsidian_chiseled"), "Obsidian", "Chiseled Obsidian");
        lang.addBlock(getVariant("obsidian_crate"), "Obsidian", "Small Obsidian Blocks inside an Oak Wood Crate");
        lang.addBlock(getVariant("obsidian_crate_unboxed"), "Obsidian", "Unboxed Crate");
        lang.addBlock(getVariant("obsidian_crystal"), "Obsidian", "Obsidian Crystal");
        lang.addBlock(getVariant("obsidian_greek"), "Obsidian", "Light Obsidian Blocks with Greek Decor");
        lang.addBlock(getVariant("obsidian_organic_chunks"), "Obsidian", "Organic-Looking Obsidian Chunks");
        lang.addBlock(getVariant("obsidian_organic_growth"), "Obsidian", "Organic-Looking Obsidian Growth");
        lang.addBlock(getVariant("obsidian_panel"), "Obsidian", "Obsidian Panel");
        lang.addBlock(getVariant("obsidian_panel_bright"), "Obsidian", "Bright Obsidian Panel");
        lang.addBlock(getVariant("obsidian_panel_map"), "Obsidian", "Obsidian Panel with Map");
        lang.addBlock(getVariant("obsidian_panel_region"), "Obsidian", "Obsidian Panel with Region Map");
        lang.addBlock(getVariant("obsidian_panel_shiny"), "Obsidian", "Shiny Obsidian Panel");
        lang.addBlock(getVariant("obsidian_pillar"), "Obsidian", "Obsidian Pillar");
        lang.addBlock(getVariant("obsidian_pillar_quartz"), "Obsidian", "Large Obsidian Pillar");
        lang.addBlock(getVariant("obsidian_tiles"), "Obsidian", "Obsidian Tiles");
    }
}

