package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MossyTempleFamily extends ChiselBlock {
        public MossyTempleFamily(BlockBehaviour.Properties props) {
            family = builder("mossy_temple")
                    .addVariant("mossy_temple_bricks", props)
                    .addVariant("mossy_temple_bricks_disarray", props)
                    .addVariant("mossy_temple_bricks_large", props)
                    .addVariant("mossy_temple_bricks_weared", props)
                    .addVariant("mossy_temple_bricks_worn", props)
                    .addVariant("mossy_temple_cobble", props)
                    .addVariant("mossy_temple_column", props, VariantModelType.TOP_BOTTOM_SIDE)
                    .addVariant("mossy_temple_ornate", props)
                    .addVariant("mossy_temple_plate", props)
                    .addVariant("mossy_temple_plate_cracked", props)
                    .addVariant("mossy_temple_stand", props, VariantModelType.TOP_BOTTOM_SIDE)
                    .addVariant("mossy_temple_stand_creeper", props, VariantModelType.TOP_BOTTOM_SIDE)
                    .addVariant("mossy_temple_stand_mosaic", props, VariantModelType.TOP_BOTTOM_SIDE)
                    .addVariant("mossy_temple_tiles", props)
                    .addVariant("mossy_temple_tiles_light", props)
                    .addVariant("mossy_temple_tiles_small", props)
                    .addVariant("mossy_temple_tiles_small_light", props)
                    .family();
        }

        @Override
        public void addTranslations(LangHelper lang) {
            lang.addBlock(getVariant("mossy_temple_bricks"), "Mossy Temple Block", "Bricks");
            lang.addBlock(getVariant("mossy_temple_bricks_disarray"), "Mossy Temple Block", "Disarray Bricks");
            lang.addBlock(getVariant("mossy_temple_bricks_large"), "Mossy Temple Block", "Large Bricks");
            lang.addBlock(getVariant("mossy_temple_bricks_weared"), "Mossy Temple Block", "Weared Bricks");
            lang.addBlock(getVariant("mossy_temple_bricks_worn"), "Mossy Temple Block", "Worn Bricks");
            lang.addBlock(getVariant("mossy_temple_cobble"), "Mossy Temple Block", "Cobblestone");
            lang.addBlock(getVariant("mossy_temple_column"), "Mossy Temple Block", "Column");
            lang.addBlock(getVariant("mossy_temple_ornate"), "Mossy Temple Block", "Ornate");
            lang.addBlock(getVariant("mossy_temple_plate"), "Mossy Temple Block", "Plate");
            lang.addBlock(getVariant("mossy_temple_plate_cracked"), "Mossy Temple Block", "Cracked Plate");
            lang.addBlock(getVariant("mossy_temple_stand"), "Mossy Temple Block", "Stand");
            lang.addBlock(getVariant("mossy_temple_stand_creeper"), "Mossy Temple Block", "Creeper Stand");
            lang.addBlock(getVariant("mossy_temple_stand_mosaic"), "Mossy Temple Block", "Mosaic Stand");
            lang.addBlock(getVariant("mossy_temple_tiles"), "Mossy Temple Block", "Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_light"), "Mossy Temple Block", "Light Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_small"), "Mossy Temple Block", "Small Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_small_light"), "Mossy Temple Block", "Small Light Tiles");
        }
    }