package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WaterstoneBlock extends ChiselBlock {
    public WaterstoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("waterstone")
                .addVariant("waterstone_raw", props)
                .addVariant("waterstone_bricks", props)
                .addVariant("waterstone_bricks_disordered", props)
                .addVariant("waterstone_chiseled", props)
                .addVariant("waterstone_construction", props)
                .addVariant("waterstone_dent", props)
                .addVariant("waterstone_layers", props)
                .addVariant("waterstone_ornate", props)
                .addVariant("waterstone_panel", props)
                .addVariant("waterstone_plate", props)
                .addVariant("waterstone_plate_smooth", props)
                .addVariant("waterstone_shale", props)
                .addVariant("waterstone_smooth", props)
                .addVariant("waterstone_symbol", props)
                .addVariant("waterstone_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("waterstone_raw"), "Waterstone", "Raw");
        lang.addBlock(getVariant("waterstone_bricks"), "Waterstone", "Bricks");
        lang.addBlock(getVariant("waterstone_bricks_disordered"), "Waterstone", "Disordered Bricks");
        lang.addBlock(getVariant("waterstone_chiseled"), "Waterstone", "Chiseled");
        lang.addBlock(getVariant("waterstone_construction"), "Waterstone", "Construction");
        lang.addBlock(getVariant("waterstone_dent"), "Waterstone", "Dent");
        lang.addBlock(getVariant("waterstone_layers"), "Waterstone", "Layers");
        lang.addBlock(getVariant("waterstone_ornate"), "Waterstone", "Ornate");
        lang.addBlock(getVariant("waterstone_panel"), "Waterstone", "Panel");
        lang.addBlock(getVariant("waterstone_plate"), "Waterstone", "Plate");
        lang.addBlock(getVariant("waterstone_plate_smooth"), "Waterstone", "Smooth Plate");
        lang.addBlock(getVariant("waterstone_shale"), "Waterstone", "Shale");
        lang.addBlock(getVariant("waterstone_smooth"), "Waterstone", "Smooth");
        lang.addBlock(getVariant("waterstone_symbol"), "Waterstone", "Symbol");
        lang.addBlock(getVariant("waterstone_tiles"), "Waterstone", "Tiles");
    }
}

