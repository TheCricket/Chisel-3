package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class RedSandstoneFamily extends ChiselFamily {
    public RedSandstoneFamily(BlockBehaviour.Properties props) {
        family = builder("red_sandstone")
                .addVariant(Blocks.RED_SANDSTONE)
                .addVariant(Blocks.CHISELED_RED_SANDSTONE)
                .addVariant(Blocks.SMOOTH_RED_SANDSTONE)
                .addVariant(Blocks.CUT_RED_SANDSTONE)
                .addVariant("red_sandstone_array", props, MULTIBLOCK_2X2)
                .addVariant("red_sandstone_braid", props)
                .addVariant("red_sandstone_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("red_sandstone_chaotic_medium", props)
                .addVariant("red_sandstone_chaotic_small", props)
                .addVariant("red_sandstone_circular", props, CONNECTED)
                .addVariant("red_sandstone_cracked", props)
                .addVariant("red_sandstone_cracked_bricks", props)
                .addVariant("red_sandstone_cuts", props, MULTIBLOCK_4X4)
                .addVariant("red_sandstone_dent", props, CONNECTED)
                .addVariant("red_sandstone_encased_bricks", props, CONNECTED)
                .addVariant("red_sandstone_french_1", props)
                .addVariant("red_sandstone_french_2", props)
                .addVariant("red_sandstone_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("red_sandstone_layers", props)
                .addVariant("red_sandstone_mosaic", props, CONNECTED)
                .addVariant("red_sandstone_ornate", props)
                .addVariant("red_sandstone_panel", props)
                .addVariant("red_sandstone_pillar", props, TBS)
                .addVariant("red_sandstone_prism", props)
                .addVariant("red_sandstone_road", props)
                .addVariant("red_sandstone_scribbles_0", props, TBS)
                .addVariant("red_sandstone_scribbles_1", props, TBS)
                .addVariant("red_sandstone_scribbles_2", props, TBS)
                .addVariant("red_sandstone_scribbles_3", props, TBS)
                .addVariant("red_sandstone_scribbles_4", props, TBS)
                .addVariant("red_sandstone_scribbles_5", props, TBS)
                .addVariant("red_sandstone_scribbles_6", props, TBS)
                .addVariant("red_sandstone_scribbles_7", props, TBS)
                .addVariant("red_sandstone_scribbles_8", props, TBS)
                .addVariant("red_sandstone_scribbles_9", props, TBS)
                .addVariant("red_sandstone_scribbles_10", props, TBS)
                .addVariant("red_sandstone_scribbles_11", props, TBS)
                .addVariant("red_sandstone_scribbles_12", props, TBS)
                .addVariant("red_sandstone_scribbles_13", props, TBS)
                .addVariant("red_sandstone_scribbles_14", props, TBS)
                .addVariant("red_sandstone_scribbles_15", props, TBS)
                .addVariant("red_sandstone_slanted", props, MULTIBLOCK_2X2)
                .addVariant("red_sandstone_small_bricks", props)
                .addVariant("red_sandstone_soft_bricks", props)
                .addVariant("red_sandstone_solid_bricks", props)
                .addVariant("red_sandstone_tiles_large", props, CONNECTED)
                .addVariant("red_sandstone_tiles_medium", props)
                .addVariant("red_sandstone_tiles_small", props)
                .addVariant("red_sandstone_triple_bricks", props)
                .addVariant("red_sandstone_twisted", props, TBS)
                .addVariant("red_sandstone_weaver", props, CONNECTED)
                .addVariant("red_sandstone_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("red_sandstone_array"), "Red Sandstone", "Red Sandstone Pillar");
        lang.addBlock(getVariant("red_sandstone_braid"), "Red Sandstone", "Braid");
        lang.addBlock(getVariant("red_sandstone_chaotic_bricks"), "Red Sandstone", "Chaotic Bricks");
        lang.addBlock(getVariant("red_sandstone_chaotic_medium"), "Red Sandstone", "Red Sandstone Bricks");
        lang.addBlock(getVariant("red_sandstone_chaotic_small"), "Red Sandstone", "Red Sandstone Small Tiles");
        lang.addBlock(getVariant("red_sandstone_circular"), "Red Sandstone", "Circular");
        lang.addBlock(getVariant("red_sandstone_cracked"), "Red Sandstone", "Cracked");
        lang.addBlock(getVariant("red_sandstone_cracked_bricks"), "Red Sandstone", "Cracked Bricks");
        lang.addBlock(getVariant("red_sandstone_cuts"), "Red Sandstone", "Cuts");
        lang.addBlock(getVariant("red_sandstone_dent"), "Red Sandstone", "Dent");
        lang.addBlock(getVariant("red_sandstone_encased_bricks"), "Red Sandstone", "Encased Bricks");
        lang.addBlock(getVariant("red_sandstone_french_1"), "Red Sandstone", "French 1");
        lang.addBlock(getVariant("red_sandstone_french_2"), "Red Sandstone", "French 2");
        lang.addBlock(getVariant("red_sandstone_jellybean"), "Red Sandstone", "Jellybean");
        lang.addBlock(getVariant("red_sandstone_layers"), "Red Sandstone", "Layers");
        lang.addBlock(getVariant("red_sandstone_mosaic"), "Red Sandstone", "Mosaic");
        lang.addBlock(getVariant("red_sandstone_ornate"), "Red Sandstone", "Ornate Red Sandstone");
        lang.addBlock(getVariant("red_sandstone_panel"), "Red Sandstone", "Panel");
        lang.addBlock(getVariant("red_sandstone_pillar"), "Red Sandstone", "Pillar");
        lang.addBlock(getVariant("red_sandstone_prism"), "Red Sandstone", "Prismatic Red Sandstone");
        lang.addBlock(getVariant("red_sandstone_road"), "Red Sandstone", "Road");
        lang.addBlock(getVariant("red_sandstone_scribbles_0"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_1"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_2"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_3"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_4"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_5"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_6"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_7"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_8"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_9"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_10"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_11"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_12"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_13"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_14"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_scribbles_15"), "Red Sandstone", "Scribbles");
        lang.addBlock(getVariant("red_sandstone_slanted"), "Red Sandstone", "Slanted");
        lang.addBlock(getVariant("red_sandstone_small_bricks"), "Red Sandstone", "Small Bricks");
        lang.addBlock(getVariant("red_sandstone_soft_bricks"), "Red Sandstone", "Soft Bricks");
        lang.addBlock(getVariant("red_sandstone_solid_bricks"), "Red Sandstone", "Solid Bricks");
        lang.addBlock(getVariant("red_sandstone_tiles_large"), "Red Sandstone", "Large Tiles");
        lang.addBlock(getVariant("red_sandstone_tiles_medium"), "Red Sandstone", "Medium Tiles");
        lang.addBlock(getVariant("red_sandstone_tiles_small"), "Red Sandstone", "Small Tiles");
        lang.addBlock(getVariant("red_sandstone_triple_bricks"), "Red Sandstone", "Triple Bricks");
        lang.addBlock(getVariant("red_sandstone_twisted"), "Red Sandstone", "Twisted");
        lang.addBlock(getVariant("red_sandstone_weaver"), "Red Sandstone", "Weaver");
        lang.addBlock(getVariant("red_sandstone_zag"), "Red Sandstone", "Zag");
    }
}
