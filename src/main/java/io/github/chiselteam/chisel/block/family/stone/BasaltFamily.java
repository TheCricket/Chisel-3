package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class BasaltFamily extends ChiselFamily {
    public BasaltFamily(BlockBehaviour.Properties props) {
        family = builder("basalt")
                .addVariant(Blocks.BASALT)
                .addVariant(Blocks.SMOOTH_BASALT)
                .addVariant(Blocks.POLISHED_BASALT)
                .addVariant("basalt_array", props, MULTIBLOCK_2X2)
                .addVariant("basalt_braid", props)
                .addVariant("basalt_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("basalt_chaotic_medium", props)
                .addVariant("basalt_chaotic_small", props)
                .addVariant("basalt_circular", props, CONNECTED)
                .addVariant("basalt_cracked", props)
                .addVariant("basalt_cracked_bricks", props)
                .addVariant("basalt_cuts", props, MULTIBLOCK_4X4)
                .addVariant("basalt_dent", props, CONNECTED)
                .addVariant("basalt_encased_bricks", props, CONNECTED)
                .addVariant("basalt_french_1", props)
                .addVariant("basalt_french_2", props)
                .addVariant("basalt_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("basalt_layers", props)
                .addVariant("basalt_mosaic", props, CONNECTED)
                .addVariant("basalt_ornate", props)
                .addVariant("basalt_panel", props)
                .addVariant("basalt_pillar", props, TBS)
                .addVariant("basalt_prism", props)
                .addVariant("basalt_raw", props)
                .addVariant("basalt_road", props)
                .addVariant("basalt_slanted", props, MULTIBLOCK_2X2)
                .addVariant("basalt_small_bricks", props)
                .addVariant("basalt_soft_bricks", props)
                .addVariant("basalt_solid_bricks", props)
                .addVariant("basalt_tiles_large", props, CONNECTED)
                .addVariant("basalt_tiles_medium", props)
                .addVariant("basalt_tiles_small", props)
                .addVariant("basalt_triple_bricks", props)
                .addVariant("basalt_twisted", props, TBS)
                .addVariant("basalt_weaver", props, CONNECTED)
                .addVariant("basalt_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("basalt_array"), "Basalt", "Basalt Pillar");
        lang.addBlock(getVariant("basalt_braid"), "Basalt", "Braid");
        lang.addBlock(getVariant("basalt_chaotic_bricks"), "Basalt", "Chaotic Bricks");
        lang.addBlock(getVariant("basalt_chaotic_medium"), "Basalt", "Basalt Bricks");
        lang.addBlock(getVariant("basalt_chaotic_small"), "Basalt", "Basalt Small Tiles");
        lang.addBlock(getVariant("basalt_circular"), "Basalt", "Circular");
        lang.addBlock(getVariant("basalt_cracked"), "Basalt", "Cracked");
        lang.addBlock(getVariant("basalt_cracked_bricks"), "Basalt", "Cracked Bricks");
        lang.addBlock(getVariant("basalt_cuts"), "Basalt", "Cuts");
        lang.addBlock(getVariant("basalt_dent"), "Basalt", "Dent");
        lang.addBlock(getVariant("basalt_encased_bricks"), "Basalt", "Encased Bricks");
        lang.addBlock(getVariant("basalt_french_1"), "Basalt", "French 1");
        lang.addBlock(getVariant("basalt_french_2"), "Basalt", "French 2");
        lang.addBlock(getVariant("basalt_jellybean"), "Basalt", "Jellybean");
        lang.addBlock(getVariant("basalt_layers"), "Basalt", "Layers");
        lang.addBlock(getVariant("basalt_mosaic"), "Basalt", "Mosaic");
        lang.addBlock(getVariant("basalt_ornate"), "Basalt", "Ornate Basalt");
        lang.addBlock(getVariant("basalt_panel"), "Basalt", "Panel");
        lang.addBlock(getVariant("basalt_pillar"), "Basalt", "Pillar");
        lang.addBlock(getVariant("basalt_prism"), "Basalt", "Prismatic Basalt");
        lang.addBlock(getVariant("basalt_raw"), "Basalt", "Raw");
        lang.addBlock(getVariant("basalt_road"), "Basalt", "Road");
        lang.addBlock(getVariant("basalt_slanted"), "Basalt", "Slanted");
        lang.addBlock(getVariant("basalt_small_bricks"), "Basalt", "Small Bricks");
        lang.addBlock(getVariant("basalt_soft_bricks"), "Basalt", "Soft Bricks");
        lang.addBlock(getVariant("basalt_solid_bricks"), "Basalt", "Solid Bricks");
        lang.addBlock(getVariant("basalt_tiles_large"), "Basalt", "Large Tiles");
        lang.addBlock(getVariant("basalt_tiles_medium"), "Basalt", "Medium Tiles");
        lang.addBlock(getVariant("basalt_tiles_small"), "Basalt", "Small Tiles");
        lang.addBlock(getVariant("basalt_triple_bricks"), "Basalt", "Triple Bricks");
        lang.addBlock(getVariant("basalt_twisted"), "Basalt", "Twisted");
        lang.addBlock(getVariant("basalt_weaver"), "Basalt", "Weaver");
        lang.addBlock(getVariant("basalt_zag"), "Basalt", "Zag");
    }
}
