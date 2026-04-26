package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MossyTempleFamily extends ChiselFamily {
        public MossyTempleFamily(BlockBehaviour.Properties props) {
            family = builder("mossy_temple")
                    .addVariant("mossy_temple_bricks", props)
                    .addVariant("mossy_temple_bricks_disarray", props)
                    .addVariant("mossy_temple_bricks_large", props)
                    .addVariant("mossy_temple_bricks_worn", props)
                    .addVariant("mossy_temple_cobble", props)
                    .addVariant("mossy_temple_column", props, VariantModelType.TBS)
                    .addVariant("mossy_temple_ornate", props)
                    .addVariant("mossy_temple_plate", props)
                    .addVariant("mossy_temple_plate_cracked", props)
                    .addVariant("mossy_temple_stand", props, VariantModelType.TBS)
                    .addVariant("mossy_temple_stand_creeper", props, VariantModelType.TBS)
                    .addVariant("mossy_temple_stand_mosaic", props, VariantModelType.TBS)
                    .addVariant("mossy_temple_tiles", props)
                    .addVariant("mossy_temple_tiles_light", props)
                    .addVariant("mossy_temple_tiles_small", props)
                    .addVariant("mossy_temple_tiles_small_light", props)
                    .family();
        }

        @Override
        public void addTranslations(LangHelper lang) {
            lang.addBlock(getVariant("mossy_temple_bricks"), "Mossy Temple Block", "Mossy Temple Bricks");
            lang.addBlock(getVariant("mossy_temple_bricks_disarray"), "Mossy Temple Block", "Mossy Temple Bricks in disarray");
            lang.addBlock(getVariant("mossy_temple_bricks_large"), "Mossy Temple Block", "Large Mossy Temple Bricks");
            lang.addBlock(getVariant("mossy_temple_bricks_worn"), "Mossy Temple Block", "Worn Mossy Temple Bricks");
            lang.addBlock(getVariant("mossy_temple_cobble"), "Mossy Temple Block", "Mossy Temple Cobblestone");
            lang.addBlock(getVariant("mossy_temple_column"), "Mossy Temple Block", "Mossy Temple Column");
            lang.addBlock(getVariant("mossy_temple_ornate"), "Mossy Temple Block", "Ornate Mossy Temple Block");
            lang.addBlock(getVariant("mossy_temple_plate"), "Mossy Temple Block", "Mossy Temple Plate");
            lang.addBlock(getVariant("mossy_temple_plate_cracked"), "Mossy Temple Block", "Cracked Mossy Temple Plate");
            lang.addBlock(getVariant("mossy_temple_stand"), "Mossy Temple Block", "Mossy Temple Stand");
            lang.addBlock(getVariant("mossy_temple_stand_creeper"), "Mossy Temple Block", "Mossy Temple Creeper Stand");
            lang.addBlock(getVariant("mossy_temple_stand_mosaic"), "Mossy Temple Block", "Mossy Temple Mosaic Stand");
            lang.addBlock(getVariant("mossy_temple_tiles"), "Mossy Temple Block", "Mossy Temple Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_light"), "Mossy Temple Block", "Light Mossy Temple Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_small"), "Mossy Temple Block", "Small Mossy Temple Tiles");
            lang.addBlock(getVariant("mossy_temple_tiles_small_light"), "Mossy Temple Block", "Small Light Mossy Temple Tiles");
        }
    }