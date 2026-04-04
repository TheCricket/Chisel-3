package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TempleBlock extends ChiselBlock {
    public TempleBlock(BlockBehaviour.Properties props) {
        family = builder("temple")
                .addVariant("temple_cobble", props, VariantModelType.CONNECTED)
                .addVariant("temple_bricks", props)
                .addVariant("temple_bricks_disarray", props)
                .addVariant("temple_bricks_large", props)
                .addVariant("temple_bricks_worn", props)
                .addVariant("temple_column", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("temple_ornate", props)
                .addVariant("temple_plate", props)
                .addVariant("temple_plate_cracked_0", props)
                .addVariant("temple_plate_cracked_1", props)
                .addVariant("temple_plate_cracked_2", props)
                .addVariant("temple_plate_cracked_3", props)
                .addVariant("temple_plate_cracked_4", props)
                .addVariant("temple_plate_cracked_5", props)
                .addVariant("temple_plate_cracked_6", props)
                .addVariant("temple_plate_cracked_7", props)
                .addVariant("temple_plate_cracked_8", props)
                .addVariant("temple_stand", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("temple_stand_creeper", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("temple_stand_mosaic", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("temple_tiles", props)
                .addVariant("temple_tiles_light", props)
                .addVariant("temple_tiles_small", props)
                .addVariant("temple_tiles_small_light", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("temple_bricks"), "Temple Block", "Bricks");
        lang.addBlock(getVariant("temple_bricks_disarray"), "Temple Block", "Disarray Bricks");
        lang.addBlock(getVariant("temple_bricks_large"), "Temple Block", "Large Bricks");
        lang.addBlock(getVariant("temple_bricks_worn"), "Temple Block", "Worn Bricks");
        lang.addBlock(getVariant("temple_cobble"), "Temple Block", "Cobblestone");
        lang.addBlock(getVariant("temple_column"), "Temple Block", "Column");
        lang.addBlock(getVariant("temple_ornate"), "Temple Block", "Ornate");
        lang.addBlock(getVariant("temple_plate"), "Temple Block", "Plate");
        lang.addBlock(getVariant("temple_plate_cracked_0"), "Temple Block", "Cracked Plate 1");
        lang.addBlock(getVariant("temple_plate_cracked_1"), "Temple Block", "Cracked Plate 2");
        lang.addBlock(getVariant("temple_plate_cracked_2"), "Temple Block", "Cracked Plate 3");
        lang.addBlock(getVariant("temple_plate_cracked_3"), "Temple Block", "Cracked Plate 4");
        lang.addBlock(getVariant("temple_plate_cracked_4"), "Temple Block", "Cracked Plate 5");
        lang.addBlock(getVariant("temple_plate_cracked_5"), "Temple Block", "Cracked Plate 6");
        lang.addBlock(getVariant("temple_plate_cracked_6"), "Temple Block", "Cracked Plate 7");
        lang.addBlock(getVariant("temple_plate_cracked_7"), "Temple Block", "Cracked Plate 8");
        lang.addBlock(getVariant("temple_plate_cracked_8"), "Temple Block", "Cracked Plate 9");
        lang.addBlock(getVariant("temple_stand"), "Temple Block", "Stand");
        lang.addBlock(getVariant("temple_stand_creeper"), "Temple Block", "Creeper Stand");
        lang.addBlock(getVariant("temple_stand_mosaic"), "Temple Block", "Mosaic Stand");
        lang.addBlock(getVariant("temple_tiles"), "Temple Block", "Tiles");
        lang.addBlock(getVariant("temple_tiles_light"), "Temple Block", "Light Tiles");
        lang.addBlock(getVariant("temple_tiles_small"), "Temple Block", "Small Tiles");
        lang.addBlock(getVariant("temple_tiles_small_light"), "Temple Block", "Small Light Tiles");
    }
}

