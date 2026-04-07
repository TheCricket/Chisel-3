package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MarbleFamily extends ChiselBlock {
    public MarbleFamily(BlockBehaviour.Properties props) {
        family = builder("marble")
                .addVariant("marble_raw", props)
                .addVariant("marble_array", props)
                .addVariant("marble_braid", props)
                .addVariant("marble_chaotic_bricks", props)
                .addVariant("marble_chaotic_medium", props)
                .addVariant("marble_chaotic_small", props)
                .addVariant("marble_circular", props)
                .addVariant("marble_cracked", props)
                .addVariant("marble_cracked_bricks", props)
                .addVariant("marble_cuts", props)
                .addVariant("marble_dent", props)
                .addVariant("marble_encased_bricks", props)
                .addVariant("marble_french_1", props)
                .addVariant("marble_french_2", props)
                .addVariant("marble_jellybean", props)
                .addVariant("marble_layers", props)
                .addVariant("marble_mosaic", props)
                .addVariant("marble_ornate", props)
                .addVariant("marble_panel", props)
                .addVariant("marble_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("marble_prism", props)
                .addVariant("marble_road", props)
                .addVariant("marble_slanted", props)
                .addVariant("marble_small_bricks", props)
                .addVariant("marble_soft_bricks", props)
                .addVariant("marble_solid_bricks", props)
                .addVariant("marble_tiles_large", props)
                .addVariant("marble_tiles_medium", props)
                .addVariant("marble_tiles_small", props)
                .addVariant("marble_triple_bricks", props)
                .addVariant("marble_twisted", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("marble_weaver", props)
                .addVariant("marble_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("marble_raw"), "Marble", "Raw");
        lang.addBlock(getVariant("marble_array"), "Marble", "Array");
        lang.addBlock(getVariant("marble_braid"), "Marble", "Braid");
        lang.addBlock(getVariant("marble_chaotic_bricks"), "Marble", "Chaotic Bricks");
        lang.addBlock(getVariant("marble_chaotic_medium"), "Marble", "Medium Chaotic");
        lang.addBlock(getVariant("marble_chaotic_small"), "Marble", "Small Chaotic");
        lang.addBlock(getVariant("marble_circular"), "Marble", "Circular");
        lang.addBlock(getVariant("marble_cracked"), "Marble", "Cracked");
        lang.addBlock(getVariant("marble_cracked_bricks"), "Marble", "Cracked Bricks");
        lang.addBlock(getVariant("marble_cuts"), "Marble", "Cuts");
        lang.addBlock(getVariant("marble_dent"), "Marble", "Dent");
        lang.addBlock(getVariant("marble_encased_bricks"), "Marble", "Encased Bricks");
        lang.addBlock(getVariant("marble_french_1"), "Marble", "French 1");
        lang.addBlock(getVariant("marble_french_2"), "Marble", "French 2");
        lang.addBlock(getVariant("marble_jellybean"), "Marble", "Jellybean");
        lang.addBlock(getVariant("marble_layers"), "Marble", "Layers");
        lang.addBlock(getVariant("marble_mosaic"), "Marble", "Mosaic");
        lang.addBlock(getVariant("marble_ornate"), "Marble", "Ornate");
        lang.addBlock(getVariant("marble_panel"), "Marble", "Panel");
        lang.addBlock(getVariant("marble_pillar"), "Marble", "Pillar");
        lang.addBlock(getVariant("marble_prism"), "Marble", "Prism");
        lang.addBlock(getVariant("marble_road"), "Marble", "Road");
        lang.addBlock(getVariant("marble_slanted"), "Marble", "Slanted");
        lang.addBlock(getVariant("marble_small_bricks"), "Marble", "Small Bricks");
        lang.addBlock(getVariant("marble_soft_bricks"), "Marble", "Soft Bricks");
        lang.addBlock(getVariant("marble_solid_bricks"), "Marble", "Solid Bricks");
        lang.addBlock(getVariant("marble_tiles_large"), "Marble", "Large Tiles");
        lang.addBlock(getVariant("marble_tiles_medium"), "Marble", "Medium Tiles");
        lang.addBlock(getVariant("marble_tiles_small"), "Marble", "Small Tiles");
        lang.addBlock(getVariant("marble_triple_bricks"), "Marble", "Triple Bricks");
        lang.addBlock(getVariant("marble_twisted"), "Marble", "Twisted");
        lang.addBlock(getVariant("marble_weaver"), "Marble", "Weaver");
        lang.addBlock(getVariant("marble_zag"), "Marble", "Zag");
    }


}

