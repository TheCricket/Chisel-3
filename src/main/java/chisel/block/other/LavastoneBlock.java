package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LavastoneBlock extends ChiselBlock {
    public LavastoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("lavastone")
                .addVariant("lavastone_raw", props)
                .addVariant("lavastone_bricks", props)
                .addVariant("lavastone_bricks_disordered", props)
                .addVariant("lavastone_chiseled", props)
                .addVariant("lavastone_construction", props)
                .addVariant("lavastone_dent", props)
                .addVariant("lavastone_layers", props)
                .addVariant("lavastone_ornate", props)
                .addVariant("lavastone_panel", props)
                .addVariant("lavastone_plate", props)
                .addVariant("lavastone_plate_smooth", props)
                .addVariant("lavastone_shale", props)
                .addVariant("lavastone_smooth", props)
                .addVariant("lavastone_symbol", props)
                .addVariant("lavastone_tiles", props)
                .addVariant("lavastone_array", props)
                .addVariant("lavastone_braid", props)
                .addVariant("lavastone_chaotic_bricks", props)
                .addVariant("lavastone_chaotic_medium", props)
                .addVariant("lavastone_chaotic_small", props)
                .addVariant("lavastone_circular", props)
                .addVariant("lavastone_cracked", props)
                .addVariant("lavastone_cracked_bricks", props)
                .addVariant("lavastone_cuts", props)
                .addVariant("lavastone_encased_bricks", props)
                .addVariant("lavastone_french_1", props)
                .addVariant("lavastone_french_2", props)
                .addVariant("lavastone_jellybean", props)
                .addVariant("lavastone_mosaic", props)
                .addVariant("lavastone_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("lavastone_prism", props)
                .addVariant("lavastone_road", props)
                .addVariant("lavastone_slanted", props)
                .addVariant("lavastone_small_bricks", props)
                .addVariant("lavastone_soft_bricks", props)
                .addVariant("lavastone_solid_bricks", props)
                .addVariant("lavastone_tiles_large", props)
                .addVariant("lavastone_tiles_medium", props)
                .addVariant("lavastone_tiles_small", props)
                .addVariant("lavastone_triple_bricks", props)
                .addVariant("lavastone_twisted", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("lavastone_weaver", props)
                .addVariant("lavastone_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("lavastone_raw"), "Lavastone", "Raw");
        lang.addBlock(getVariant("lavastone_bricks"), "Lavastone", "Bricks");
        lang.addBlock(getVariant("lavastone_bricks_disordered"), "Lavastone", "Disordered Bricks");
        lang.addBlock(getVariant("lavastone_chiseled"), "Lavastone", "Chiseled");
        lang.addBlock(getVariant("lavastone_construction"), "Lavastone", "Construction");
        lang.addBlock(getVariant("lavastone_dent"), "Lavastone", "Dent");
        lang.addBlock(getVariant("lavastone_layers"), "Lavastone", "Layers");
        lang.addBlock(getVariant("lavastone_ornate"), "Lavastone", "Ornate");
        lang.addBlock(getVariant("lavastone_panel"), "Lavastone", "Panel");
        lang.addBlock(getVariant("lavastone_plate"), "Lavastone", "Plate");
        lang.addBlock(getVariant("lavastone_plate_smooth"), "Lavastone", "Smooth Plate");
        lang.addBlock(getVariant("lavastone_shale"), "Lavastone", "Shale");
        lang.addBlock(getVariant("lavastone_smooth"), "Lavastone", "Smooth");
        lang.addBlock(getVariant("lavastone_symbol"), "Lavastone", "Symbol");
        lang.addBlock(getVariant("lavastone_tiles"), "Lavastone", "Tiles");
        lang.addBlock(getVariant("lavastone_array"), "Lavastone", "Array");
        lang.addBlock(getVariant("lavastone_braid"), "Lavastone", "Braid");
        lang.addBlock(getVariant("lavastone_chaotic_bricks"), "Lavastone", "Chaotic Bricks");
        lang.addBlock(getVariant("lavastone_chaotic_medium"), "Lavastone", "Medium Chaotic");
        lang.addBlock(getVariant("lavastone_chaotic_small"), "Lavastone", "Small Chaotic");
        lang.addBlock(getVariant("lavastone_circular"), "Lavastone", "Circular");
        lang.addBlock(getVariant("lavastone_cracked"), "Lavastone", "Cracked");
        lang.addBlock(getVariant("lavastone_cracked_bricks"), "Lavastone", "Cracked Bricks");
        lang.addBlock(getVariant("lavastone_cuts"), "Lavastone", "Cuts");
        lang.addBlock(getVariant("lavastone_encased_bricks"), "Lavastone", "Encased Bricks");
        lang.addBlock(getVariant("lavastone_french_1"), "Lavastone", "French 1");
        lang.addBlock(getVariant("lavastone_french_2"), "Lavastone", "French 2");
        lang.addBlock(getVariant("lavastone_jellybean"), "Lavastone", "Jellybean");
        lang.addBlock(getVariant("lavastone_mosaic"), "Lavastone", "Mosaic");
        lang.addBlock(getVariant("lavastone_pillar"), "Lavastone", "Pillar");
        lang.addBlock(getVariant("lavastone_prism"), "Lavastone", "Prism");
        lang.addBlock(getVariant("lavastone_road"), "Lavastone", "Road");
        lang.addBlock(getVariant("lavastone_slanted"), "Lavastone", "Slanted");
        lang.addBlock(getVariant("lavastone_small_bricks"), "Lavastone", "Small Bricks");
        lang.addBlock(getVariant("lavastone_soft_bricks"), "Lavastone", "Soft Bricks");
        lang.addBlock(getVariant("lavastone_solid_bricks"), "Lavastone", "Solid Bricks");
        lang.addBlock(getVariant("lavastone_tiles_large"), "Lavastone", "Large Tiles");
        lang.addBlock(getVariant("lavastone_tiles_medium"), "Lavastone", "Medium Tiles");
        lang.addBlock(getVariant("lavastone_tiles_small"), "Lavastone", "Small Tiles");
        lang.addBlock(getVariant("lavastone_triple_bricks"), "Lavastone", "Triple Bricks");
        lang.addBlock(getVariant("lavastone_twisted"), "Lavastone", "Twisted");
        lang.addBlock(getVariant("lavastone_weaver"), "Lavastone", "Weaver");
        lang.addBlock(getVariant("lavastone_zag"), "Lavastone", "Zag");
    }
}

