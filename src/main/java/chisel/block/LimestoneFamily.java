package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LimestoneFamily extends ChiselBlock {
    public LimestoneFamily(BlockBehaviour.Properties props) {
        family = builder("limestone")
                .addVariant("limestone_raw", props)
                .addVariant("limestone_array", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("limestone_braid", props)
                .addVariant("limestone_chaotic_bricks", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("limestone_chaotic_medium", props)
                .addVariant("limestone_chaotic_small", props)
                .addVariant("limestone_circular", props, VariantModelType.CONNECTED)
                .addVariant("limestone_cracked", props)
                .addVariant("limestone_cracked_bricks", props)
                .addVariant("limestone_cuts", props, VariantModelType.MULTIBLOCK_4X4)
                .addVariant("limestone_dent", props, VariantModelType.CONNECTED)
                .addVariant("limestone_encased_bricks", props, VariantModelType.CONNECTED)
                .addVariant("limestone_french_1", props)
                .addVariant("limestone_french_2", props)
                .addVariant("limestone_jellybean", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("limestone_layers", props)
                .addVariant("limestone_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("limestone_ornate", props)
                .addVariant("limestone_panel", props)
                .addVariant("limestone_pillar", props, VariantModelType.TBS)
                .addVariant("limestone_prism", props)
                .addVariant("limestone_road", props)
                .addVariant("limestone_slanted", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("limestone_small_bricks", props)
                .addVariant("limestone_soft_bricks", props)
                .addVariant("limestone_solid_bricks", props)
                .addVariant("limestone_tiles_large", props, VariantModelType.CONNECTED)
                .addVariant("limestone_tiles_medium", props)
                .addVariant("limestone_tiles_small", props)
                .addVariant("limestone_triple_bricks", props)
                .addVariant("limestone_twisted", props, VariantModelType.TBS)
                .addVariant("limestone_weaver", props, VariantModelType.CONNECTED)
                .addVariant("limestone_zag", props, VariantModelType.CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("limestone_raw"), "Limestone", "Limestone");
        lang.addBlock(getVariant("limestone_array"), "Limestone", "Large Limestone Tiles");
        lang.addBlock(getVariant("limestone_braid"), "Limestone", "Braid");
        lang.addBlock(getVariant("limestone_chaotic_bricks"), "Limestone", "Chaotic Bricks");
        lang.addBlock(getVariant("limestone_chaotic_medium"), "Limestone", "Small Limestone Bricks");
        lang.addBlock(getVariant("limestone_chaotic_small"), "Limestone", "Small Limestone Tiles");
        lang.addBlock(getVariant("limestone_circular"), "Limestone", "Circular");
        lang.addBlock(getVariant("limestone_cracked"), "Limestone", "Damaged Limestone Tiles");
        lang.addBlock(getVariant("limestone_cracked_bricks"), "Limestone", "Cracked Bricks");
        lang.addBlock(getVariant("limestone_cuts"), "Limestone", "Cuts");
        lang.addBlock(getVariant("limestone_dent"), "Limestone", "Limestone with Dent");
        lang.addBlock(getVariant("limestone_encased_bricks"), "Limestone", "Encased Bricks");
        lang.addBlock(getVariant("limestone_french_1"), "Limestone", "French Limestone Tiles");
        lang.addBlock(getVariant("limestone_french_2"), "Limestone", "French Limestone Tiles");
        lang.addBlock(getVariant("limestone_jellybean"), "Limestone", "Jellybean");
        lang.addBlock(getVariant("limestone_layers"), "Limestone", "Layers");
        lang.addBlock(getVariant("limestone_mosaic"), "Limestone", "Mosaic");
        lang.addBlock(getVariant("limestone_ornate"), "Limestone", "Limestone with Ornate Panel");
        lang.addBlock(getVariant("limestone_panel"), "Limestone", "Limestone with Panel");
        lang.addBlock(getVariant("limestone_pillar"), "Limestone", "Pillar");
        lang.addBlock(getVariant("limestone_prism"), "Limestone", "Prism");
        lang.addBlock(getVariant("limestone_road"), "Limestone", "Road");
        lang.addBlock(getVariant("limestone_slanted"), "Limestone", "Slanted");
        lang.addBlock(getVariant("limestone_small_bricks"), "Limestone", "Small Bricks");
        lang.addBlock(getVariant("limestone_soft_bricks"), "Limestone", "Limestone with Light Panel");
        lang.addBlock(getVariant("limestone_solid_bricks"), "Limestone", "Limestone with Dark Panel");
        lang.addBlock(getVariant("limestone_tiles_large"), "Limestone", "Large Tiles");
        lang.addBlock(getVariant("limestone_tiles_medium"), "Limestone", "Medium Tiles");
        lang.addBlock(getVariant("limestone_tiles_small"), "Limestone", "Small Tiles");
        lang.addBlock(getVariant("limestone_triple_bricks"), "Limestone", "Triple Bricks");
        lang.addBlock(getVariant("limestone_twisted"), "Limestone", "Twisted");
        lang.addBlock(getVariant("limestone_weaver"), "Limestone", "Weaver");
        lang.addBlock(getVariant("limestone_zag"), "Limestone", "Zag");
    }
}

