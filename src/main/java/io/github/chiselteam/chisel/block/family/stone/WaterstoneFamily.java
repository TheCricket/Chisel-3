package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class WaterstoneFamily extends ChiselFamily {
    public WaterstoneFamily(BlockBehaviour.Properties props) {
        family = builder("waterstone")
                .addVariant("waterstone_array", props, MULTI_LAYER_WATER_2X2)
                .addVariant("waterstone_braid", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_chaotic_bricks", props, MULTI_LAYER_WATER_3X3)
                .addVariant("waterstone_chaotic_medium", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_chaotic_small", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_circular", props, MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_cracked", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_cracked_bricks", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_cuts", props, MULTI_LAYER_WATER_4X4)
                .addVariant("waterstone_dent", props, MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_encased_bricks", props, MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_french_1", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_french_2", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_jellybean", props, MULTI_LAYER_WATER_2X2)
                .addVariant("waterstone_layers", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_mosaic", props, MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_ornate", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_panel", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_pillar", props, MULTI_LAYER_TBS_TINTED)
                .addVariant("waterstone_prism", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_raw", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_road", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_slanted", props, MULTI_LAYER_WATER_2X2)
                .addVariant("waterstone_small_bricks", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_soft_bricks", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_tiles_large", props, MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_tiles_medium", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_triple_bricks", props, MULTI_LAYER_WATER)
                .addVariant("waterstone_twisted", props, MULTI_LAYER_TBS_TINTED)
                .addVariant("waterstone_weaver", props, MULTI_LAYER_CONNECTED_TINTED)
                .addVariant("waterstone_zag", props, MULTI_LAYER_WATER_AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("waterstone_array"), "Waterstone", "Array");
        lang.addBlock(getVariant("waterstone_braid"), "Waterstone", "Braid");
        lang.addBlock(getVariant("waterstone_chaotic_bricks"), "Waterstone", "Chaotic Waterstone Bricks");
        lang.addBlock(getVariant("waterstone_chaotic_medium"), "Waterstone", "Waterstone Bricks");
        lang.addBlock(getVariant("waterstone_chaotic_small"), "Waterstone", "Waterstone Tiles");
        lang.addBlock(getVariant("waterstone_circular"), "Waterstone", "Circular");
        lang.addBlock(getVariant("waterstone_cracked"), "Waterstone", "Cracked");
        lang.addBlock(getVariant("waterstone_cracked_bricks"), "Waterstone", "Cracked Bricks");
        lang.addBlock(getVariant("waterstone_cuts"), "Waterstone", "Cuts");
        lang.addBlock(getVariant("waterstone_dent"), "Waterstone", "Dent");
        lang.addBlock(getVariant("waterstone_encased_bricks"), "Waterstone", "Encased Bricks");
        lang.addBlock(getVariant("waterstone_french_1"), "Waterstone", "French 1");
        lang.addBlock(getVariant("waterstone_french_2"), "Waterstone", "French 2");
        lang.addBlock(getVariant("waterstone_jellybean"), "Waterstone", "Jellybean");
        lang.addBlock(getVariant("waterstone_layers"), "Waterstone", "Layers");
        lang.addBlock(getVariant("waterstone_mosaic"), "Waterstone", "Water Creeper in Tiles");
        lang.addBlock(getVariant("waterstone_ornate"), "Waterstone", "Ornate Water Panel");
        lang.addBlock(getVariant("waterstone_panel"), "Waterstone", "Water Panel");
        lang.addBlock(getVariant("waterstone_pillar"), "Waterstone", "Pillar");
        lang.addBlock(getVariant("waterstone_prism"), "Waterstone", "Prism");
        lang.addBlock(getVariant("waterstone_raw"), "Waterstone", "Black Waterstone");
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

