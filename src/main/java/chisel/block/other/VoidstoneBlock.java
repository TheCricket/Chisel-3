package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class VoidstoneBlock extends ChiselBlock {
    public VoidstoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("voidstone")
                .addVariant("voidstone_raw", props)
                .addVariant("voidstone_bricks", props)
                .addVariant("voidstone_bricks_disordered", props)
                .addVariant("voidstone_chiseled", props)
                .addVariant("voidstone_construction", props)
                .addVariant("voidstone_dent", props)
                .addVariant("voidstone_layers", props)
                .addVariant("voidstone_ornate", props)
                .addVariant("voidstone_panel", props)
                .addVariant("voidstone_plate", props)
                .addVariant("voidstone_plate_smooth", props)
                .addVariant("voidstone_shale", props)
                .addVariant("voidstone_smooth", props)
                .addVariant("voidstone_symbol", props)
                .addVariant("voidstone_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("voidstone_raw"), "Voidstone", "Raw");
        lang.addBlock(getVariant("voidstone_bricks"), "Voidstone", "Bricks");
        lang.addBlock(getVariant("voidstone_bricks_disordered"), "Voidstone", "Disordered Bricks");
        lang.addBlock(getVariant("voidstone_chiseled"), "Voidstone", "Chiseled");
        lang.addBlock(getVariant("voidstone_construction"), "Voidstone", "Construction");
        lang.addBlock(getVariant("voidstone_dent"), "Voidstone", "Dent");
        lang.addBlock(getVariant("voidstone_layers"), "Voidstone", "Layers");
        lang.addBlock(getVariant("voidstone_ornate"), "Voidstone", "Ornate");
        lang.addBlock(getVariant("voidstone_panel"), "Voidstone", "Panel");
        lang.addBlock(getVariant("voidstone_plate"), "Voidstone", "Plate");
        lang.addBlock(getVariant("voidstone_plate_smooth"), "Voidstone", "Smooth Plate");
        lang.addBlock(getVariant("voidstone_shale"), "Voidstone", "Shale");
        lang.addBlock(getVariant("voidstone_smooth"), "Voidstone", "Smooth");
        lang.addBlock(getVariant("voidstone_symbol"), "Voidstone", "Symbol");
        lang.addBlock(getVariant("voidstone_tiles"), "Voidstone", "Tiles");
    }
}

