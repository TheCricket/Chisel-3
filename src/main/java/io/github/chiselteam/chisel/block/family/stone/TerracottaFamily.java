package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class TerracottaFamily extends ChiselFamily {
    public TerracottaFamily(BlockBehaviour.Properties props) {
        family = builder("terracotta")
                .addVariant(Blocks.TERRACOTTA)
                .addVariant("terracotta_array", props, MULTIBLOCK_2X2)
                .addVariant("terracotta_braid", props)
                .addVariant("terracotta_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("terracotta_chaotic_medium", props)
                .addVariant("terracotta_chaotic_small", props)
                .addVariant("terracotta_circular", props, CONNECTED)
                .addVariant("terracotta_cracked", props)
                .addVariant("terracotta_cracked_bricks", props)
                .addVariant("terracotta_cuts", props, MULTIBLOCK_4X4)
                .addVariant("terracotta_dent", props, CONNECTED)
                .addVariant("terracotta_encased_bricks", props, CONNECTED)
                .addVariant("terracotta_french_1", props)
                .addVariant("terracotta_french_2", props)
                .addVariant("terracotta_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("terracotta_layers", props)
                .addVariant("terracotta_mosaic", props, CONNECTED)
                .addVariant("terracotta_ornate", props)
                .addVariant("terracotta_panel", props)
                .addVariant("terracotta_pillar", props, TBS)
                .addVariant("terracotta_prism", props)
                .addVariant("terracotta_road", props)
                .addVariant("terracotta_slanted", props, MULTIBLOCK_2X2)
                .addVariant("terracotta_small_bricks", props)
                .addVariant("terracotta_soft_bricks", props)
                .addVariant("terracotta_solid_bricks", props)
                .addVariant("terracotta_tiles_large", props, CONNECTED)
                .addVariant("terracotta_tiles_medium", props)
                .addVariant("terracotta_tiles_small", props)
                .addVariant("terracotta_triple_bricks", props)
                .addVariant("terracotta_twisted", props, TBS)
                .addVariant("terracotta_weaver", props, CONNECTED)
                .addVariant("terracotta_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("terracotta_array"), "Terracotta", "Terracotta Pillar");
        lang.addBlock(getVariant("terracotta_braid"), "Terracotta", "Braid");
        lang.addBlock(getVariant("terracotta_chaotic_bricks"), "Terracotta", "Chaotic Bricks");
        lang.addBlock(getVariant("terracotta_chaotic_medium"), "Terracotta", "Terracotta Bricks");
        lang.addBlock(getVariant("terracotta_chaotic_small"), "Terracotta", "Terracotta Small Tiles");
        lang.addBlock(getVariant("terracotta_circular"), "Terracotta", "Circular");
        lang.addBlock(getVariant("terracotta_cracked"), "Terracotta", "Cracked");
        lang.addBlock(getVariant("terracotta_cracked_bricks"), "Terracotta", "Cracked Bricks");
        lang.addBlock(getVariant("terracotta_cuts"), "Terracotta", "Cuts");
        lang.addBlock(getVariant("terracotta_dent"), "Terracotta", "Dent");
        lang.addBlock(getVariant("terracotta_encased_bricks"), "Terracotta", "Encased Bricks");
        lang.addBlock(getVariant("terracotta_french_1"), "Terracotta", "French 1");
        lang.addBlock(getVariant("terracotta_french_2"), "Terracotta", "French 2");
        lang.addBlock(getVariant("terracotta_jellybean"), "Terracotta", "Jellybean");
        lang.addBlock(getVariant("terracotta_layers"), "Terracotta", "Layers");
        lang.addBlock(getVariant("terracotta_mosaic"), "Terracotta", "Mosaic");
        lang.addBlock(getVariant("terracotta_ornate"), "Terracotta", "Ornate Terracotta");
        lang.addBlock(getVariant("terracotta_panel"), "Terracotta", "Panel");
        lang.addBlock(getVariant("terracotta_pillar"), "Terracotta", "Pillar");
        lang.addBlock(getVariant("terracotta_prism"), "Terracotta", "Prismatic Terracotta");
        lang.addBlock(getVariant("terracotta_road"), "Terracotta", "Road");
        lang.addBlock(getVariant("terracotta_slanted"), "Terracotta", "Slanted");
        lang.addBlock(getVariant("terracotta_small_bricks"), "Terracotta", "Small Bricks");
        lang.addBlock(getVariant("terracotta_soft_bricks"), "Terracotta", "Soft Bricks");
        lang.addBlock(getVariant("terracotta_solid_bricks"), "Terracotta", "Solid Bricks");
        lang.addBlock(getVariant("terracotta_tiles_large"), "Terracotta", "Large Tiles");
        lang.addBlock(getVariant("terracotta_tiles_medium"), "Terracotta", "Medium Tiles");
        lang.addBlock(getVariant("terracotta_tiles_small"), "Terracotta", "Small Tiles");
        lang.addBlock(getVariant("terracotta_triple_bricks"), "Terracotta", "Triple Bricks");
        lang.addBlock(getVariant("terracotta_twisted"), "Terracotta", "Twisted");
        lang.addBlock(getVariant("terracotta_weaver"), "Terracotta", "Weaver");
        lang.addBlock(getVariant("terracotta_zag"), "Terracotta", "Zag");
    }
}
