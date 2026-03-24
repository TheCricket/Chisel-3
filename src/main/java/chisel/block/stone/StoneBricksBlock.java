package chisel.block.stone;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class StoneBricksBlock extends ChiselBlock {
    public StoneBricksBlock(BlockBehaviour.Properties props) {
        

        family = builder("stone_bricks")
                .addVariant(Blocks.STONE_BRICKS)
                .addVariant("stone_bricks_disordered", props)
                .addVariant("stone_bricks_disordered_panel", props)
                .addVariant("stone_bricks_disordered_small", props)
                .addVariant("stone_bricks_fancy", props)
                .addVariant("stone_bricks_felsic", props)
                .addVariant("stone_bricks_mafic", props)
                .addVariant("stone_bricks_neutral", props)
                .addVariant("stone_bricks_ornate", props)
                .addVariant("stone_bricks_ornate_large", props)
                .addVariant("stone_bricks_panel", props)
                .addVariant("stone_bricks_panel_ornate", props)
                .addVariant("stone_bricks_panel_sunken", props)
                .addVariant("stone_bricks_poison", props)
                .addVariant("stone_bricks_small", props)
                .addVariant("stone_bricks_wide", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("stone_bricks_disordered"), "Stone Bricks", "Disordered");
        lang.addBlock(getVariant("stone_bricks_disordered_panel"), "Stone Bricks", "Disordered Panel");
        lang.addBlock(getVariant("stone_bricks_disordered_small"), "Stone Bricks", "Small Disordered Bricks");
        lang.addBlock(getVariant("stone_bricks_fancy"), "Stone Bricks", "Fancy");
        lang.addBlock(getVariant("stone_bricks_felsic"), "Stone Bricks", "Felsic");
        lang.addBlock(getVariant("stone_bricks_mafic"), "Stone Bricks", "Mafic");
        lang.addBlock(getVariant("stone_bricks_neutral"), "Stone Bricks", "Neutral");
        lang.addBlock(getVariant("stone_bricks_ornate"), "Stone Bricks", "Ornate");
        lang.addBlock(getVariant("stone_bricks_ornate_large"), "Stone Bricks", "Large Ornate");
        lang.addBlock(getVariant("stone_bricks_panel"), "Stone Bricks", "Panel");
        lang.addBlock(getVariant("stone_bricks_panel_ornate"), "Stone Bricks", "Ornate Panel");
        lang.addBlock(getVariant("stone_bricks_panel_sunken"), "Stone Bricks", "Sunken Panel");
        lang.addBlock(getVariant("stone_bricks_poison"), "Stone Bricks", "Poison");
        lang.addBlock(getVariant("stone_bricks_small"), "Stone Bricks", "Small Bricks");
        lang.addBlock(getVariant("stone_bricks_wide"), "Stone Bricks", "Wide");
    }
}

