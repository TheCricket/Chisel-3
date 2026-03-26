package chisel.block.stone;

import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ObsidianBlock extends ChiselBlock {
    public ObsidianBlock(BlockBehaviour.Properties props) {
        

        family = builder("obsidian")
                .addVariant(Blocks.OBSIDIAN)
                .addVariant("obsidian_blocks", props)
                .addVariant("obsidian_chiseled", props)
                .addVariant("obsidian_crate", props)
                .addVariant("obsidian_crystal", props)
                .addVariant("obsidian_greek", props)
                .addVariant("obsidian_japanese", props)
                .addVariant("obsidian_layers", props)
                .addVariant("obsidian_ornate", props)
                .addVariant("obsidian_panel", props)
                .addVariant("obsidian_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("obsidian_plates", props)
                .addVariant("obsidian_road", props)
                .addVariant("obsidian_shale", props)
                .addVariant("obsidian_snakes", props)
                .addVariant("obsidian_soft", props)
                .addVariant("obsidian_sunken", props)
                .addVariant("obsidian_tiles", props)
                .addVariant("obsidian_weaver", props)
                .addVariant("obsidian_zigzag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("obsidian_blocks"), "Obsidian", "Blocks");
        lang.addBlock(getVariant("obsidian_chiseled"), "Obsidian", "Chiseled");
        lang.addBlock(getVariant("obsidian_crate"), "Obsidian", "Crate");
        lang.addBlock(getVariant("obsidian_crystal"), "Obsidian", "Crystal");
        lang.addBlock(getVariant("obsidian_greek"), "Obsidian", "Greek");
        lang.addBlock(getVariant("obsidian_japanese"), "Obsidian", "Japanese");
        lang.addBlock(getVariant("obsidian_layers"), "Obsidian", "Layers");
        lang.addBlock(getVariant("obsidian_ornate"), "Obsidian", "Ornate");
        lang.addBlock(getVariant("obsidian_panel"), "Obsidian", "Panel");
        lang.addBlock(getVariant("obsidian_pillar"), "Obsidian", "Pillar");
        lang.addBlock(getVariant("obsidian_plates"), "Obsidian", "Plates");
        lang.addBlock(getVariant("obsidian_road"), "Obsidian", "Road");
        lang.addBlock(getVariant("obsidian_shale"), "Obsidian", "Shale");
        lang.addBlock(getVariant("obsidian_snakes"), "Obsidian", "Snakes");
        lang.addBlock(getVariant("obsidian_soft"), "Obsidian", "Soft");
        lang.addBlock(getVariant("obsidian_sunken"), "Obsidian", "Sunken");
        lang.addBlock(getVariant("obsidian_tiles"), "Obsidian", "Tiles");
        lang.addBlock(getVariant("obsidian_weaver"), "Obsidian", "Weaver");
        lang.addBlock(getVariant("obsidian_zigzag"), "Obsidian", "Zigzag");
    }
}

