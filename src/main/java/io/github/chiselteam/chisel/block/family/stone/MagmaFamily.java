package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class MagmaFamily extends ChiselFamily {
    public MagmaFamily(BlockBehaviour.Properties props) {
        family = builder("magma")
                .addVariant(Blocks.MAGMA_BLOCK)
                .addVariant("magma_array", props, LAVA_2x2)
                .addVariant("magma_braid", props, MULTI_LAYER_LAVA)
                .addVariant("magma_chaotic_bricks", props, LAVA_3x3)
                .addVariant("magma_chaotic_medium", props, MULTI_LAYER_LAVA)
                .addVariant("magma_chaotic_small", props, MULTI_LAYER_LAVA)
                .addVariant("magma_circular", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("magma_cracked", props, MULTI_LAYER_LAVA)
                .addVariant("magma_cracked_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("magma_cuts", props, LAVA_4x4)
                .addVariant("magma_dent", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("magma_encased_bricks", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("magma_french_1", props, MULTI_LAYER_LAVA)
                .addVariant("magma_french_2", props, MULTI_LAYER_LAVA)
                .addVariant("magma_jellybean", props, LAVA_2x2)
                .addVariant("magma_layers", props, MULTI_LAYER_LAVA)
                .addVariant("magma_mosaic", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("magma_ornate", props, MULTI_LAYER_LAVA)
                .addVariant("magma_panel", props, MULTI_LAYER_LAVA)
                .addVariant("magma_pillar", props, MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE)
                .addVariant("magma_prism", props, MULTI_LAYER_LAVA)
                .addVariant("magma_raw", props, MULTI_LAYER_LAVA)
                .addVariant("magma_road", props, MULTI_LAYER_LAVA)
                .addVariant("magma_slanted", props, LAVA_2x2)
                .addVariant("magma_small_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("magma_soft_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("magma_solid_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("magma_tiles_large", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("magma_tiles_medium", props, MULTI_LAYER_LAVA)
                .addVariant("magma_tiles_small", props, MULTI_LAYER_LAVA)
                .addVariant("magma_triple_bricks", props, MULTI_LAYER_LAVA)
                .addVariant("magma_twisted", props, MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE)
                .addVariant("magma_weaver", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("magma_zag", props, MULTI_LAYER_LAVA_AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("magma_array"), "Magma", "Magma Pillar");
        lang.addBlock(getVariant("magma_braid"), "Magma", "Braid");
        lang.addBlock(getVariant("magma_chaotic_bricks"), "Magma", "Chaotic Bricks");
        lang.addBlock(getVariant("magma_chaotic_medium"), "Magma", "Magma Bricks");
        lang.addBlock(getVariant("magma_chaotic_small"), "Magma", "Magma Small Tiles");
        lang.addBlock(getVariant("magma_circular"), "Magma", "Circular");
        lang.addBlock(getVariant("magma_cracked"), "Magma", "Cracked");
        lang.addBlock(getVariant("magma_cracked_bricks"), "Magma", "Cracked Bricks");
        lang.addBlock(getVariant("magma_cuts"), "Magma", "Cuts");
        lang.addBlock(getVariant("magma_dent"), "Magma", "Dent");
        lang.addBlock(getVariant("magma_encased_bricks"), "Magma", "Encased Bricks");
        lang.addBlock(getVariant("magma_french_1"), "Magma", "French 1");
        lang.addBlock(getVariant("magma_french_2"), "Magma", "French 2");
        lang.addBlock(getVariant("magma_jellybean"), "Magma", "Jellybean");
        lang.addBlock(getVariant("magma_layers"), "Magma", "Layers");
        lang.addBlock(getVariant("magma_mosaic"), "Magma", "Mosaic");
        lang.addBlock(getVariant("magma_ornate"), "Magma", "Ornate Magma");
        lang.addBlock(getVariant("magma_panel"), "Magma", "Panel");
        lang.addBlock(getVariant("magma_pillar"), "Magma", "Pillar");
        lang.addBlock(getVariant("magma_prism"), "Magma", "Prismatic Magma");
        lang.addBlock(getVariant("magma_raw"), "Magma", "Raw");
        lang.addBlock(getVariant("magma_road"), "Magma", "Road");
        lang.addBlock(getVariant("magma_slanted"), "Magma", "Slanted");
        lang.addBlock(getVariant("magma_small_bricks"), "Magma", "Small Bricks");
        lang.addBlock(getVariant("magma_soft_bricks"), "Magma", "Soft Bricks");
        lang.addBlock(getVariant("magma_solid_bricks"), "Magma", "Solid Bricks");
        lang.addBlock(getVariant("magma_tiles_large"), "Magma", "Large Tiles");
        lang.addBlock(getVariant("magma_tiles_medium"), "Magma", "Medium Tiles");
        lang.addBlock(getVariant("magma_tiles_small"), "Magma", "Small Tiles");
        lang.addBlock(getVariant("magma_triple_bricks"), "Magma", "Triple Bricks");
        lang.addBlock(getVariant("magma_twisted"), "Magma", "Twisted");
        lang.addBlock(getVariant("magma_weaver"), "Magma", "Weaver");
        lang.addBlock(getVariant("magma_zag"), "Magma", "Zag");
    }
}
