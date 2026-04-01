package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GraniteBlock extends ChiselBlock {
    public GraniteBlock(BlockBehaviour.Properties props) {
        family = builder("granite")
                .addVariant(Blocks.GRANITE)
                .addVariant("granite_array", props)
                .addVariant("granite_braid", props)
                .addVariant("granite_chaotic_bricks", props)
                .addVariant("granite_chaotic_medium", props)
                .addVariant("granite_chaotic_small", props)
                .addVariant("granite_circular", props)
                .addVariant("granite_cracked", props)
                .addVariant("granite_cracked_bricks", props)
                .addVariant("granite_cuts", props)
                .addVariant("granite_dent", props)
                .addVariant("granite_encased_bricks", props)
                .addVariant("granite_french_1", props)
                .addVariant("granite_french_2", props)
                .addVariant("granite_jellybean", props)
                .addVariant("granite_layers", props)
                .addVariant("granite_mosaic", props)
                .addVariant("granite_ornate", props)
                .addVariant("granite_panel", props)
                .addVariant("granite_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("granite_prism", props)
                .addVariant("granite_raw", props)
                .addVariant("granite_road", props)
                .addVariant("granite_slanted", props)
                .addVariant("granite_small_bricks", props)
                .addVariant("granite_soft_bricks", props)
                .addVariant("granite_solid_bricks", props)
                .addVariant("granite_tiles_large", props)
                .addVariant("granite_tiles_medium", props)
                .addVariant("granite_tiles_small", props)
                .addVariant("granite_triple_bricks", props)
                .addVariant("granite_twisted", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("granite_weaver", props)
                .addVariant("granite_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("granite_array"), "Granite", "Array");
        lang.addBlock(getVariant("granite_braid"), "Granite", "Braid");
        lang.addBlock(getVariant("granite_chaotic_bricks"), "Granite", "Chaotic Bricks");
        lang.addBlock(getVariant("granite_chaotic_medium"), "Granite", "Medium Chaotic");
        lang.addBlock(getVariant("granite_chaotic_small"), "Granite", "Small Chaotic");
        lang.addBlock(getVariant("granite_circular"), "Granite", "Circular");
        lang.addBlock(getVariant("granite_cracked"), "Granite", "Cracked");
        lang.addBlock(getVariant("granite_cracked_bricks"), "Granite", "Cracked Bricks");
        lang.addBlock(getVariant("granite_cuts"), "Granite", "Cuts");
        lang.addBlock(getVariant("granite_dent"), "Granite", "Dent");
        lang.addBlock(getVariant("granite_encased_bricks"), "Granite", "Encased Bricks");
        lang.addBlock(getVariant("granite_french_1"), "Granite", "French 1");
        lang.addBlock(getVariant("granite_french_2"), "Granite", "French 2");
        lang.addBlock(getVariant("granite_jellybean"), "Granite", "Jellybean");
        lang.addBlock(getVariant("granite_layers"), "Granite", "Layers");
        lang.addBlock(getVariant("granite_mosaic"), "Granite", "Mosaic");
        lang.addBlock(getVariant("granite_ornate"), "Granite", "Ornate");
        lang.addBlock(getVariant("granite_panel"), "Granite", "Panel");
        lang.addBlock(getVariant("granite_pillar"), "Granite", "Pillar");
        lang.addBlock(getVariant("granite_prism"), "Granite", "Prism");
        lang.addBlock(getVariant("granite_raw"), "Granite", "Raw");
        lang.addBlock(getVariant("granite_road"), "Granite", "Road");
        lang.addBlock(getVariant("granite_slanted"), "Granite", "Slanted");
        lang.addBlock(getVariant("granite_small_bricks"), "Granite", "Small Bricks");
        lang.addBlock(getVariant("granite_soft_bricks"), "Granite", "Soft Bricks");
        lang.addBlock(getVariant("granite_solid_bricks"), "Granite", "Solid Bricks");
        lang.addBlock(getVariant("granite_tiles_large"), "Granite", "Large Tiles");
        lang.addBlock(getVariant("granite_tiles_medium"), "Granite", "Medium Tiles");
        lang.addBlock(getVariant("granite_tiles_small"), "Granite", "Small Tiles");
        lang.addBlock(getVariant("granite_triple_bricks"), "Granite", "Triple Bricks");
        lang.addBlock(getVariant("granite_twisted"), "Granite", "Twisted");
        lang.addBlock(getVariant("granite_weaver"), "Granite", "Weaver");
        lang.addBlock(getVariant("granite_zag"), "Granite", "Zag");
    }
}

