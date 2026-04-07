package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class StoneBricksFamily extends ChiselBlock {
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
        lang.addBlock(getVariant("stone_bricks_chaotic_small"), "Stone Bricks", "Small Chaotic Bricks");
        lang.addBlock(getVariant("stone_bricks_disordered"), "Stone Bricks", "Disordered");
        lang.addBlock(getVariant("stone_bricks_disordered_panel"), "Stone Bricks", "Disordered Panel");
        lang.addBlock(getVariant("stone_bricks_disordered_small"), "Stone Bricks", "Small Disordered Bricks");
        lang.addBlock(getVariant("stone_bricks_fancy"), "Stone Bricks", "Fancy");
        lang.addBlock(getVariant("stone_bricks_felsic"), "Stone Bricks", "Felsic");
        lang.addBlock(getVariant("stone_bricks_large"), "Stone Bricks", "Large Bricks");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_felsic"), "Stone Bricks", "Mason Bricks Felsic");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_felsic_2"), "Stone Bricks", "Mason Bricks Felsic 2");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_mafic"), "Stone Bricks", "Mason Bricks Mafic");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_mixed"), "Stone Bricks", "Mason Bricks Mixed");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_mixed_2"), "Stone Bricks", "Mason Bricks Mixed 2");
        lang.addBlock(getVariant("stone_bricks_mason_bricks_plain"), "Stone Bricks", "Mason Bricks Plain");
        lang.addBlock(getVariant("stone_bricks_masonry_felsic"), "Stone Bricks", "Masonry Felsic");
        lang.addBlock(getVariant("stone_bricks_masonry_mafic"), "Stone Bricks", "Masonry Mafic");
        lang.addBlock(getVariant("stone_bricks_masonry_mixed"), "Stone Bricks", "Masonry Mixed");
        lang.addBlock(getVariant("stone_bricks_masonry_plain"), "Stone Bricks", "Masonry Plain");
        lang.addBlock(getVariant("stone_bricks_ornate"), "Stone Bricks", "Ornate");
        lang.addBlock(getVariant("stone_bricks_ornate_large"), "Stone Bricks", "Large Ornate");
        lang.addBlock(getVariant("stone_bricks_panel_hard"), "Stone Bricks", "Hard Panel");
        lang.addBlock(getVariant("stone_bricks_panel_ornate"), "Stone Bricks", "Ornate Panel");
        lang.addBlock(getVariant("stone_bricks_panel_sunken"), "Stone Bricks", "Sunken Panel");
        lang.addBlock(getVariant("stone_bricks_poison"), "Stone Bricks", "Poison");
        lang.addBlock(getVariant("stone_bricks_rough"), "Stone Bricks", "Rough Bricks");
        lang.addBlock(getVariant("stone_bricks_small"), "Stone Bricks", "Small Bricks");
        lang.addBlock(getVariant("stone_bricks_smooth"), "Stone Bricks", "Smooth");
        lang.addBlock(getVariant("stone_bricks_wide"), "Stone Bricks", "Wide");
    }
}

