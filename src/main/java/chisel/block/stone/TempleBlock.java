package chisel.block.stone;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TempleBlock extends ChiselBlock {
    public TempleBlock(BlockBehaviour.Properties props) {
        

        family = builder("temple")
                .addVariant("temple_cobble", props)
                .addVariant("temple_bricks", props)
                .addVariant("temple_bricks_disarray", props)
                .addVariant("temple_bricks_large", props)
                .addVariant("temple_bricks_worn", props)
                .addVariant("temple_column", props)
                .addVariant("temple_ornate", props)
                .addVariant("temple_plate", props)
                .addVariant("temple_plate_cracked", props)
                .addVariant("temple_stand", props)
                .addVariant("temple_stand_creeper", props)
                .addVariant("temple_stand_mosaic", props)
                .addVariant("temple_tiles", props)
                .addVariant("temple_tiles_light", props)
                .addVariant("temple_tiles_small", props)
                .addVariant("temple_tiles_small_light", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("temple_cobble"), "Temple Block", "Cobblestone");
        lang.addBlock(getVariant("temple_bricks"), "Temple Block", "Bricks");
        lang.addBlock(getVariant("temple_bricks_disarray"), "Temple Block", "Disarray Bricks");
        lang.addBlock(getVariant("temple_bricks_large"), "Temple Block", "Large Bricks");
        lang.addBlock(getVariant("temple_bricks_worn"), "Temple Block", "Worn Bricks");
        lang.addBlock(getVariant("temple_column"), "Temple Block", "Column");
        lang.addBlock(getVariant("temple_ornate"), "Temple Block", "Ornate");
        lang.addBlock(getVariant("temple_plate"), "Temple Block", "Plate");
        lang.addBlock(getVariant("temple_plate_cracked"), "Temple Block", "Cracked Plate");
        lang.addBlock(getVariant("temple_stand"), "Temple Block", "Stand");
        lang.addBlock(getVariant("temple_stand_creeper"), "Temple Block", "Creeper Stand");
        lang.addBlock(getVariant("temple_stand_mosaic"), "Temple Block", "Mosaic Stand");
        lang.addBlock(getVariant("temple_tiles"), "Temple Block", "Tiles");
        lang.addBlock(getVariant("temple_tiles_light"), "Temple Block", "Light Tiles");
        lang.addBlock(getVariant("temple_tiles_small"), "Temple Block", "Small Tiles");
        lang.addBlock(getVariant("temple_tiles_small_light"), "Temple Block", "Small Light Tiles");
    }
}

