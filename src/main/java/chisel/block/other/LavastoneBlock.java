package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class LavastoneBlock extends ChiselBlock {
    public LavastoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("lavastone")
                .addVariant("lavastone_raw", props)
                .addVariant("lavastone_bricks", props)
                .addVariant("lavastone_bricks_disordered", props)
                .addVariant("lavastone_chiseled", props)
                .addVariant("lavastone_construction", props)
                .addVariant("lavastone_dent", props)
                .addVariant("lavastone_layers", props)
                .addVariant("lavastone_ornate", props)
                .addVariant("lavastone_panel", props)
                .addVariant("lavastone_plate", props)
                .addVariant("lavastone_plate_smooth", props)
                .addVariant("lavastone_shale", props)
                .addVariant("lavastone_smooth", props)
                .addVariant("lavastone_symbol", props)
                .addVariant("lavastone_tiles", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("lavastone_raw"), "Lavastone", "Raw");
        lang.addBlock(getVariant("lavastone_bricks"), "Lavastone", "Bricks");
        lang.addBlock(getVariant("lavastone_bricks_disordered"), "Lavastone", "Disordered Bricks");
        lang.addBlock(getVariant("lavastone_chiseled"), "Lavastone", "Chiseled");
        lang.addBlock(getVariant("lavastone_construction"), "Lavastone", "Construction");
        lang.addBlock(getVariant("lavastone_dent"), "Lavastone", "Dent");
        lang.addBlock(getVariant("lavastone_layers"), "Lavastone", "Layers");
        lang.addBlock(getVariant("lavastone_ornate"), "Lavastone", "Ornate");
        lang.addBlock(getVariant("lavastone_panel"), "Lavastone", "Panel");
        lang.addBlock(getVariant("lavastone_plate"), "Lavastone", "Plate");
        lang.addBlock(getVariant("lavastone_plate_smooth"), "Lavastone", "Smooth Plate");
        lang.addBlock(getVariant("lavastone_shale"), "Lavastone", "Shale");
        lang.addBlock(getVariant("lavastone_smooth"), "Lavastone", "Smooth");
        lang.addBlock(getVariant("lavastone_symbol"), "Lavastone", "Symbol");
        lang.addBlock(getVariant("lavastone_tiles"), "Lavastone", "Tiles");
    }
}

