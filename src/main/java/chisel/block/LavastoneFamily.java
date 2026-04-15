package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LavastoneFamily extends ChiselBlock {
    public LavastoneFamily(BlockBehaviour.Properties props) {
        family = builder("lavastone")
                .addVariant("lavastone_array", props, VariantModelType.LAVA_2x2)
                .addVariant("lavastone_braid", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_chaotic_bricks", props, VariantModelType.LAVA_3x3)
                .addVariant("lavastone_chaotic_medium", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_chaotic_small", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_circular", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_cracked", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_cracked_bricks", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_cuts", props, VariantModelType.LAVA_4x4)
                .addVariant("lavastone_dent", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_encased_bricks", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_french_1", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_french_2", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_jellybean", props, VariantModelType.LAVA_2x2)
                .addVariant("lavastone_layers", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_mosaic", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_ornate", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_panel", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_pillar", props, VariantModelType.MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE)
                .addVariant("lavastone_prism", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_raw", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_road", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_slanted", props, VariantModelType.LAVA_2x2)
                .addVariant("lavastone_small_bricks", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_soft_bricks", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_tiles_large", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_tiles_medium", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_triple_bricks", props, VariantModelType.MULTI_LAYER_LAVA)
                .addVariant("lavastone_twisted", props, VariantModelType.MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE)
                .addVariant("lavastone_weaver", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_zag", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("lavastone_array"), "Lavastone", "Array");
        lang.addBlock(getVariant("lavastone_braid"), "Lavastone", "Braid");
        lang.addBlock(getVariant("lavastone_chaotic_bricks"), "Lavastone", "Chaotic Bricks");
        lang.addBlock(getVariant("lavastone_chaotic_medium"), "Lavastone", "Medium Chaotic");
        lang.addBlock(getVariant("lavastone_chaotic_small"), "Lavastone", "Small Chaotic");
        lang.addBlock(getVariant("lavastone_circular"), "Lavastone", "Circular");
        lang.addBlock(getVariant("lavastone_cracked"), "Lavastone", "Cracked");
        lang.addBlock(getVariant("lavastone_cracked_bricks"), "Lavastone", "Cracked Bricks");
        lang.addBlock(getVariant("lavastone_cuts"), "Lavastone", "Cuts");
        lang.addBlock(getVariant("lavastone_dent"), "Lavastone", "Dent");
        lang.addBlock(getVariant("lavastone_encased_bricks"), "Lavastone", "Encased Bricks");
        lang.addBlock(getVariant("lavastone_french_1"), "Lavastone", "French 1");
        lang.addBlock(getVariant("lavastone_french_2"), "Lavastone", "French 2");
        lang.addBlock(getVariant("lavastone_jellybean"), "Lavastone", "Jellybean");
        lang.addBlock(getVariant("lavastone_layers"), "Lavastone", "Layers");
        lang.addBlock(getVariant("lavastone_mosaic"), "Lavastone", "Mosaic");
        lang.addBlock(getVariant("lavastone_ornate"), "Lavastone", "Ornate");
        lang.addBlock(getVariant("lavastone_panel"), "Lavastone", "Panel");
        lang.addBlock(getVariant("lavastone_pillar"), "Lavastone", "Pillar");
        lang.addBlock(getVariant("lavastone_prism"), "Lavastone", "Prism");
        lang.addBlock(getVariant("lavastone_raw"), "Lavastone", "Raw");
        lang.addBlock(getVariant("lavastone_road"), "Lavastone", "Road");
        lang.addBlock(getVariant("lavastone_slanted"), "Lavastone", "Slanted");
        lang.addBlock(getVariant("lavastone_small_bricks"), "Lavastone", "Small Bricks");
        lang.addBlock(getVariant("lavastone_soft_bricks"), "Lavastone", "Soft Bricks");
        lang.addBlock(getVariant("lavastone_tiles_large"), "Lavastone", "Large Tiles");
        lang.addBlock(getVariant("lavastone_tiles_medium"), "Lavastone", "Medium Tiles");
        lang.addBlock(getVariant("lavastone_triple_bricks"), "Lavastone", "Triple Bricks");
        lang.addBlock(getVariant("lavastone_twisted"), "Lavastone", "Twisted");
        lang.addBlock(getVariant("lavastone_weaver"), "Lavastone", "Weaver");
        lang.addBlock(getVariant("lavastone_zag"), "Lavastone", "Zag");
    }
}

