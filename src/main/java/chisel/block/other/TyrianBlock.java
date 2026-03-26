package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TyrianBlock extends ChiselBlock {
    public TyrianBlock(BlockBehaviour.Properties props) {
        

        family = builder("tyrian")
                .addVariant("tyrian_raw", props)
                .addVariant("tyrian_bricks", props)
                .addVariant("tyrian_bricks_disordered", props)
                .addVariant("tyrian_chiseled", props)
                .addVariant("tyrian_construction", props)
                .addVariant("tyrian_dent", props)
                .addVariant("tyrian_layers", props)
                .addVariant("tyrian_ornate", props)
                .addVariant("tyrian_panel", props)
                .addVariant("tyrian_plate", props)
                .addVariant("tyrian_plate_smooth", props)
                .addVariant("tyrian_shale", props)
                .addVariant("tyrian_smooth", props)
                .addVariant("tyrian_symbol", props)
                .addVariant("tyrian_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("tyrian_raw"), "Tyrian", "Raw");
        lang.addBlock(getVariant("tyrian_bricks"), "Tyrian", "Bricks");
        lang.addBlock(getVariant("tyrian_bricks_disordered"), "Tyrian", "Disordered Bricks");
        lang.addBlock(getVariant("tyrian_chiseled"), "Tyrian", "Chiseled");
        lang.addBlock(getVariant("tyrian_construction"), "Tyrian", "Construction");
        lang.addBlock(getVariant("tyrian_dent"), "Tyrian", "Dent");
        lang.addBlock(getVariant("tyrian_layers"), "Tyrian", "Layers");
        lang.addBlock(getVariant("tyrian_ornate"), "Tyrian", "Ornate");
        lang.addBlock(getVariant("tyrian_panel"), "Tyrian", "Panel");
        lang.addBlock(getVariant("tyrian_plate"), "Tyrian", "Plate");
        lang.addBlock(getVariant("tyrian_plate_smooth"), "Tyrian", "Smooth Plate");
        lang.addBlock(getVariant("tyrian_shale"), "Tyrian", "Shale");
        lang.addBlock(getVariant("tyrian_smooth"), "Tyrian", "Smooth");
        lang.addBlock(getVariant("tyrian_symbol"), "Tyrian", "Symbol");
        lang.addBlock(getVariant("tyrian_tiles"), "Tyrian", "Tiles");
    }
}

