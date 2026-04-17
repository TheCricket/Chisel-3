package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TempleFamily extends ChiselBlock {
    public TempleFamily(BlockBehaviour.Properties props) {
        family = builder("temple")
                .addVariant("temple_cobble", props, VariantModelType.CONNECTED)
                .addVariant("temple_bricks", props)
                .addVariant("temple_bricks_disarray", props)
                .addVariant("temple_bricks_large", props)
                .addVariant("temple_bricks_worn", props)
                .addVariant("temple_column", props, VariantModelType.TBS)
                .addVariant("temple_ornate", props)
                .addVariant("temple_plate", props)
                .addVariant("temple_plate_cracked", props)
                .addVariant("temple_stand", props, VariantModelType.TBS)
                .addVariant("temple_stand_creeper", props, VariantModelType.TBS)
                .addVariant("temple_stand_mosaic", props, VariantModelType.TBS)
                .addVariant("temple_tiles", props)
                .addVariant("temple_tiles_light", props)
                .addVariant("temple_tiles_small", props)
                .addVariant("temple_tiles_small_light", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("temple_bricks"), "Temple Block", "Temple Bricks");
        lang.addBlock(getVariant("temple_bricks_disarray"), "Temple Block", "Temple Bricks in disarray");
        lang.addBlock(getVariant("temple_bricks_large"), "Temple Block", "Large Temple Bricks");
        lang.addBlock(getVariant("temple_bricks_worn"), "Temple Block", "Worn Temple Bricks");
        lang.addBlock(getVariant("temple_cobble"), "Temple Block", "Temple Cobblestone");
        lang.addBlock(getVariant("temple_column"), "Temple Block", "Temple Column");
        lang.addBlock(getVariant("temple_ornate"), "Temple Block", "Ornate Temple Block");
        lang.addBlock(getVariant("temple_plate"), "Temple Block", "Temple Plate");
        lang.addBlock(getVariant("temple_plate_cracked"), "Temple Block", "Cracked Temple Plate");
        lang.addBlock(getVariant("temple_stand"), "Temple Block", "Temple Stand");
        lang.addBlock(getVariant("temple_stand_creeper"), "Temple Block", "Temple Creeper Stand");
        lang.addBlock(getVariant("temple_stand_mosaic"), "Temple Block", "Temple Mosaic Stand");
        lang.addBlock(getVariant("temple_tiles"), "Temple Block", "Temple Tiles");
        lang.addBlock(getVariant("temple_tiles_light"), "Temple Block", "Light Temple Tiles");
        lang.addBlock(getVariant("temple_tiles_small"), "Temple Block", "Small Temple Tiles");
        lang.addBlock(getVariant("temple_tiles_small_light"), "Temple Block", "Small Light Temple Tiles");
    }
}

