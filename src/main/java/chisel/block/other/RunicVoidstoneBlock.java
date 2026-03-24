package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class RunicVoidstoneBlock extends ChiselBlock {
    public RunicVoidstoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("runic_voidstone")
                .addVariant("runic_voidstone_raw", props)
                .addVariant("runic_voidstone_bricks", props)
                .addVariant("runic_voidstone_bricks_disordered", props)
                .addVariant("runic_voidstone_chiseled", props)
                .addVariant("runic_voidstone_construction", props)
                .addVariant("runic_voidstone_dent", props)
                .addVariant("runic_voidstone_layers", props)
                .addVariant("runic_voidstone_ornate", props)
                .addVariant("runic_voidstone_panel", props)
                .addVariant("runic_voidstone_plate", props)
                .addVariant("runic_voidstone_plate_smooth", props)
                .addVariant("runic_voidstone_shale", props)
                .addVariant("runic_voidstone_smooth", props)
                .addVariant("runic_voidstone_symbol", props)
                .addVariant("runic_voidstone_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("runic_voidstone_raw"), "Runic Voidstone", "Raw");
        lang.addBlock(getVariant("runic_voidstone_bricks"), "Runic Voidstone", "Bricks");
        lang.addBlock(getVariant("runic_voidstone_bricks_disordered"), "Runic Voidstone", "Disordered Bricks");
        lang.addBlock(getVariant("runic_voidstone_chiseled"), "Runic Voidstone", "Chiseled");
        lang.addBlock(getVariant("runic_voidstone_construction"), "Runic Voidstone", "Construction");
        lang.addBlock(getVariant("runic_voidstone_dent"), "Runic Voidstone", "Dent");
        lang.addBlock(getVariant("runic_voidstone_layers"), "Runic Voidstone", "Layers");
        lang.addBlock(getVariant("runic_voidstone_ornate"), "Runic Voidstone", "Ornate");
        lang.addBlock(getVariant("runic_voidstone_panel"), "Runic Voidstone", "Panel");
        lang.addBlock(getVariant("runic_voidstone_plate"), "Runic Voidstone", "Plate");
        lang.addBlock(getVariant("runic_voidstone_plate_smooth"), "Runic Voidstone", "Smooth Plate");
        lang.addBlock(getVariant("runic_voidstone_shale"), "Runic Voidstone", "Shale");
        lang.addBlock(getVariant("runic_voidstone_smooth"), "Runic Voidstone", "Smooth");
        lang.addBlock(getVariant("runic_voidstone_symbol"), "Runic Voidstone", "Symbol");
        lang.addBlock(getVariant("runic_voidstone_tiles"), "Runic Voidstone", "Tiles");
    }
}

