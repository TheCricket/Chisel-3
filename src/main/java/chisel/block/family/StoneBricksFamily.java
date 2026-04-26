package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class StoneBricksFamily extends ChiselFamily {
    public StoneBricksFamily(BlockBehaviour.Properties props) {
        family = builder("stone_bricks")
                .addVariant(Blocks.STONE_BRICKS)
                .addVariant("stone_bricks_chaotic_small", props)
                .addVariant("stone_bricks_disordered", props)
                .addVariant("stone_bricks_disordered_panel", props)
                .addVariant("stone_bricks_disordered_small", props)
                .addVariant("stone_bricks_fancy", props)
                .addVariant("stone_bricks_felsic", props)
                .addVariant("stone_bricks_large", props)
                .addVariant("stone_bricks_mason_bricks_felsic", props)
                .addVariant("stone_bricks_mason_bricks_felsic_2", props)
                .addVariant("stone_bricks_mason_bricks_mafic", props)
                .addVariant("stone_bricks_mason_bricks_mixed", props)
                .addVariant("stone_bricks_mason_bricks_mixed_2", props)
                .addVariant("stone_bricks_mason_bricks_plain", props)
                .addVariant("stone_bricks_masonry_felsic", props)
                .addVariant("stone_bricks_masonry_mafic", props)
                .addVariant("stone_bricks_masonry_mixed", props)
                .addVariant("stone_bricks_masonry_plain", props)
                .addVariant("stone_bricks_ornate", props)
                .addVariant("stone_bricks_ornate_large", props)
                .addVariant("stone_bricks_panel_hard", props, VariantModelType.CONNECTED)
                .addVariant("stone_bricks_panel_ornate", props)
                .addVariant("stone_bricks_panel_sunken", props, VariantModelType.CONNECTED)
                .addVariant("stone_bricks_poison", props)
                .addVariant("stone_bricks_rough", props)
                .addVariant("stone_bricks_small", props)
                .addVariant("stone_bricks_smooth", props)
                .addVariant("stone_bricks_wide", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("stone_bricks_chaotic_small"), "Stone Bricks", "Small Disordered Stone Bricks");
        lang.addBlock(getVariant("stone_bricks_disordered"), "Stone Bricks", "Disordered Stone Bricks");
        lang.addBlock(getVariant("stone_bricks_disordered_panel"), "Stone Bricks", "Disordered Stone Panels");
        lang.addBlock(getVariant("stone_bricks_disordered_small"), "Stone Bricks", "Small Disordered Stone Bricks");
        lang.addBlock(getVariant("stone_bricks_fancy"), "Stone Bricks", "Stone Bricks in a Fancy Arrangement");
        lang.addBlock(getVariant("stone_bricks_felsic"), "Stone Bricks", "Modern Felsic Masonry");
        lang.addBlock(getVariant("stone_bricks_large"), "Stone Bricks", "Large Bricks");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_felsic"), "Stone Bricks", "Modern Felsic Masonry");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_felsic_2"), "Stone Bricks", "Modern Felsic Masonry");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_mafic"), "Stone Bricks", "Modern Mafic Masonry");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_mixed"), "Stone Bricks", "Modern Mixed Masonry");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_mixed_2"), "Stone Bricks", "Modern Mixed Masonry");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_plain"), "Stone Bricks", "Modern Neutral Masonry");
        lang.addBlock(getVariant("stone_bricks_masonry_felsic"), "Stone Bricks", "Modern Felsic Masonry");
        lang.addBlock(getVariant("stone_bricks_masonry_mafic"), "Stone Bricks", "Modern Mafic Masonry");
        lang.addBlock(getVariant("stone_bricks_masonry_mixed"), "Stone Bricks", "Modern Mixed Masonry");
        lang.addBlock(getVariant("stone_bricks_masonry_plain"), "Stone Bricks", "Modern Neutral Masonry");
        lang.addBlock(getVariant("stone_bricks_ornate"), "Stone Bricks", "Ornate Stone Brick tiles");
        lang.addBlock(getVariant("stone_bricks_ornate_large"), "Stone Bricks", "Large Ornate Stone Brick Tiles");
        lang.addBlock(getVariant("stone_bricks_panel_hard"), "Stone Bricks", "Stone Panel");
        lang.addBlock(getVariant("stone_bricks_panel_ornate"), "Stone Bricks", "Ornate Stone Panel");
        lang.addBlock(getVariant("stone_bricks_panel_sunken"), "Stone Bricks", "Sunken Stone Panel");
        lang.addBlock(getVariant("stone_bricks_poison"), "Stone Bricks", "Poison Stone Brick");
        lang.addBlock(getVariant("stone_bricks_rough"), "Stone Bricks", "Rough Bricks");
        lang.addBlock(getVariant("stone_bricks_small"), "Stone Bricks", "Small Stone Bricks");
        lang.addBlock(getVariant("stone_bricks_smooth"), "Stone Bricks", "Smooth");
        lang.addBlock(getVariant("stone_bricks_wide"), "Stone Bricks", "Wide Stone Bricks");
    }
}

