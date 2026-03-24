package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class HolystoneBlock extends ChiselBlock {
    public HolystoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("holystone")
                .addVariant("holystone_raw", props)
                .addVariant("holystone_bricks", props)
                .addVariant("holystone_bricks_disordered", props)
                .addVariant("holystone_chiseled", props)
                .addVariant("holystone_construction", props)
                .addVariant("holystone_dent", props)
                .addVariant("holystone_layers", props)
                .addVariant("holystone_ornate", props)
                .addVariant("holystone_panel", props)
                .addVariant("holystone_plate", props)
                .addVariant("holystone_plate_smooth", props)
                .addVariant("holystone_shale", props)
                .addVariant("holystone_smooth", props)
                .addVariant("holystone_symbol", props)
                .addVariant("holystone_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("holystone_raw"), "Holystone", "Raw");
        lang.addBlock(getVariant("holystone_bricks"), "Holystone", "Bricks");
        lang.addBlock(getVariant("holystone_bricks_disordered"), "Holystone", "Disordered Bricks");
        lang.addBlock(getVariant("holystone_chiseled"), "Holystone", "Chiseled");
        lang.addBlock(getVariant("holystone_construction"), "Holystone", "Construction");
        lang.addBlock(getVariant("holystone_dent"), "Holystone", "Dent");
        lang.addBlock(getVariant("holystone_layers"), "Holystone", "Layers");
        lang.addBlock(getVariant("holystone_ornate"), "Holystone", "Ornate");
        lang.addBlock(getVariant("holystone_panel"), "Holystone", "Panel");
        lang.addBlock(getVariant("holystone_plate"), "Holystone", "Plate");
        lang.addBlock(getVariant("holystone_plate_smooth"), "Holystone", "Smooth Plate");
        lang.addBlock(getVariant("holystone_shale"), "Holystone", "Shale");
        lang.addBlock(getVariant("holystone_smooth"), "Holystone", "Smooth");
        lang.addBlock(getVariant("holystone_symbol"), "Holystone", "Symbol");
        lang.addBlock(getVariant("holystone_tiles"), "Holystone", "Tiles");
    }
}

