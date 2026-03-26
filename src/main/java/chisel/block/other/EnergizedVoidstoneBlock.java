package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EnergizedVoidstoneBlock extends ChiselBlock {
    public EnergizedVoidstoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("energized_voidstone")
                .addVariant("energized_voidstone_raw", props)
                .addVariant("energized_voidstone_bricks", props)
                .addVariant("energized_voidstone_bricks_disordered", props)
                .addVariant("energized_voidstone_chiseled", props)
                .addVariant("energized_voidstone_construction", props)
                .addVariant("energized_voidstone_dent", props)
                .addVariant("energized_voidstone_layers", props)
                .addVariant("energized_voidstone_ornate", props)
                .addVariant("energized_voidstone_panel", props)
                .addVariant("energized_voidstone_plate", props)
                .addVariant("energized_voidstone_plate_smooth", props)
                .addVariant("energized_voidstone_shale", props)
                .addVariant("energized_voidstone_smooth", props)
                .addVariant("energized_voidstone_symbol", props)
                .addVariant("energized_voidstone_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("energized_voidstone_raw"), "Energized Voidstone", "Raw");
        lang.addBlock(getVariant("energized_voidstone_bricks"), "Energized Voidstone", "Bricks");
        lang.addBlock(getVariant("energized_voidstone_bricks_disordered"), "Energized Voidstone", "Disordered Bricks");
        lang.addBlock(getVariant("energized_voidstone_chiseled"), "Energized Voidstone", "Chiseled");
        lang.addBlock(getVariant("energized_voidstone_construction"), "Energized Voidstone", "Construction");
        lang.addBlock(getVariant("energized_voidstone_dent"), "Energized Voidstone", "Dent");
        lang.addBlock(getVariant("energized_voidstone_layers"), "Energized Voidstone", "Layers");
        lang.addBlock(getVariant("energized_voidstone_ornate"), "Energized Voidstone", "Ornate");
        lang.addBlock(getVariant("energized_voidstone_panel"), "Energized Voidstone", "Panel");
        lang.addBlock(getVariant("energized_voidstone_plate"), "Energized Voidstone", "Plate");
        lang.addBlock(getVariant("energized_voidstone_plate_smooth"), "Energized Voidstone", "Smooth Plate");
        lang.addBlock(getVariant("energized_voidstone_shale"), "Energized Voidstone", "Shale");
        lang.addBlock(getVariant("energized_voidstone_smooth"), "Energized Voidstone", "Smooth");
        lang.addBlock(getVariant("energized_voidstone_symbol"), "Energized Voidstone", "Symbol");
        lang.addBlock(getVariant("energized_voidstone_tiles"), "Energized Voidstone", "Tiles");
    }
}

