package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WaterstoneBlock extends ChiselBlock {
    public WaterstoneBlock(BlockBehaviour.Properties props) {
        family = builder("waterstone")
                .addVariant("waterstone_array", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_braid", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_chaotic_bricks", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_chaotic_medium", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_chaotic_small", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_circular", props, VariantModelType.MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_cracked", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_cracked_bricks", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_cuts", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_dent", props, VariantModelType.MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_encased_bricks", props, VariantModelType.MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_french_1", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_french_2", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_layers", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_mosaic", props, VariantModelType.MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_ornate", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_panel", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_pillar", props, VariantModelType.MULTI_LAYER_TBS_TINTED)
                .addVariant("waterstone_prism", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_raw", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_road", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_slanted", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_small_bricks", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_soft_bricks", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_tiles_large", props, VariantModelType.MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_tiles_medium", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_triple_bricks", props, VariantModelType.MULTI_LAYER_WATER)
                .addVariant("waterstone_twisted", props, VariantModelType.MULTI_LAYER_TBS_TINTED)
                .addVariant("waterstone_weaver", props, VariantModelType.MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_zag", props, VariantModelType.MULTI_LAYER_CONNECTED_TINTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("waterstone_array"), "Waterstone", "Array");
        lang.addBlock(getVariant("waterstone_braid"), "Waterstone", "Braid");
        lang.addBlock(getVariant("waterstone_chaotic_bricks"), "Waterstone", "Chaotic Bricks");
        lang.addBlock(getVariant("waterstone_chaotic_medium"), "Waterstone", "Medium Chaotic");
        lang.addBlock(getVariant("waterstone_chaotic_small"), "Waterstone", "Small Chaotic");
        lang.addBlock(getVariant("waterstone_circular"), "Waterstone", "Circular");
        lang.addBlock(getVariant("waterstone_cracked"), "Waterstone", "Cracked");
        lang.addBlock(getVariant("waterstone_cracked_bricks"), "Waterstone", "Cracked Bricks");
        lang.addBlock(getVariant("waterstone_cuts"), "Waterstone", "Cuts");
        lang.addBlock(getVariant("waterstone_dent"), "Waterstone", "Dent");
        lang.addBlock(getVariant("waterstone_encased_bricks"), "Waterstone", "Encased Bricks");
        lang.addBlock(getVariant("waterstone_french_1"), "Waterstone", "French 1");
        lang.addBlock(getVariant("waterstone_french_2"), "Waterstone", "French 2");
        lang.addBlock(getVariant("waterstone_layers"), "Waterstone", "Layers");
        lang.addBlock(getVariant("waterstone_mosaic"), "Waterstone", "Mosaic");
        lang.addBlock(getVariant("waterstone_ornate"), "Waterstone", "Ornate");
        lang.addBlock(getVariant("waterstone_panel"), "Waterstone", "Panel");
        lang.addBlock(getVariant("waterstone_pillar"), "Waterstone", "Pillar");
        lang.addBlock(getVariant("waterstone_prism"), "Waterstone", "Prism");
        lang.addBlock(getVariant("waterstone_raw"), "Waterstone", "Raw");
        lang.addBlock(getVariant("waterstone_road"), "Waterstone", "Road");
        lang.addBlock(getVariant("waterstone_slanted"), "Waterstone", "Slanted");
        lang.addBlock(getVariant("waterstone_small_bricks"), "Waterstone", "Small Bricks");
        lang.addBlock(getVariant("waterstone_soft_bricks"), "Waterstone", "Soft Bricks");
        lang.addBlock(getVariant("waterstone_tiles_large"), "Waterstone", "Large Tiles");
        lang.addBlock(getVariant("waterstone_tiles_medium"), "Waterstone", "Medium Tiles");
        lang.addBlock(getVariant("waterstone_triple_bricks"), "Waterstone", "Triple Bricks");
        lang.addBlock(getVariant("waterstone_twisted"), "Waterstone", "Twisted");
        lang.addBlock(getVariant("waterstone_weaver"), "Waterstone", "Weaver");
        lang.addBlock(getVariant("waterstone_zag"), "Waterstone", "Zag");
    }
}

