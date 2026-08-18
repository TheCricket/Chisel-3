package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class LavastoneFamily extends ChiselFamily {
    public LavastoneFamily(BlockBehaviour.Properties props) {
        family = builder("lavastone")
                .addVariant("lavastone_array", props, LAVA_2x2)
                .addVariant("lavastone_braid", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_chaotic_bricks", props, LAVA_3x3)
                .addVariant("lavastone_chaotic_medium", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_chaotic_small", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_circular", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_cracked", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_cracked_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_cuts", props, LAVA_4x4)
                .addVariant("lavastone_dent", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_encased_bricks", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_french_1", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_french_2", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_jellybean", props, LAVA_2x2)
                .addVariant("lavastone_layers", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_mosaic", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_ornate", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_panel", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_pillar", props, MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE)
                .addVariant("lavastone_prism", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_raw", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_road", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_slanted", props, LAVA_2x2)
                .addVariant("lavastone_small_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_soft_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_tiles_large", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_tiles_medium", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_triple_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("lavastone_twisted", props, MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE)
                .addVariant("lavastone_weaver", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("lavastone_zag", props, MULTI_LAYER_LAVA_AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("lavastone_array"), "Lavastone", "Array");
        lang.addBlock(getVariant("lavastone_braid"), "Lavastone", "Braid");
        lang.addBlock(getVariant("lavastone_chaotic_bricks"), "Lavastone", "Chaotic Lavastone Bricks");
        lang.addBlock(getVariant("lavastone_chaotic_medium"), "Lavastone", "Lavastone Bricks");
        lang.addBlock(getVariant("lavastone_chaotic_small"), "Lavastone", "Lavastone Tiles");
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
        lang.addBlock(getVariant("lavastone_mosaic"), "Lavastone", "Lava Creeper in Tiles");
        lang.addBlock(getVariant("lavastone_ornate"), "Lavastone", "Ornate Lava Panel");
        lang.addBlock(getVariant("lavastone_panel"), "Lavastone", "Lava Panel");
        lang.addBlock(getVariant("lavastone_pillar"), "Lavastone", "Pillar");
        lang.addBlock(getVariant("lavastone_prism"), "Lavastone", "Prism");
        lang.addBlock(getVariant("lavastone_raw"), "Lavastone", "Black Lavastone");
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

