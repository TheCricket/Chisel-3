package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CharcoalFamily extends ChiselFamily {
    public CharcoalFamily(BlockBehaviour.Properties props) {
        family = builder("charcoal")
                .addVariant("charcoal_array", props, MULTIBLOCK_2X2)
                .addVariant("charcoal_braid", props)
                .addVariant("charcoal_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("charcoal_chaotic_medium", props)
                .addVariant("charcoal_chaotic_small", props)
                .addVariant("charcoal_circular", props, CONNECTED)
                .addVariant("charcoal_cracked", props)
                .addVariant("charcoal_cracked_bricks", props)
                .addVariant("charcoal_cuts", props, MULTIBLOCK_4X4)
                .addVariant("charcoal_dent", props, CONNECTED)
                .addVariant("charcoal_encased_bricks", props, CONNECTED)
                .addVariant("charcoal_french_1", props)
                .addVariant("charcoal_french_2", props)
                .addVariant("charcoal_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("charcoal_layers", props)
                .addVariant("charcoal_mosaic", props, CONNECTED)
                .addVariant("charcoal_ornate", props)
                .addVariant("charcoal_panel", props)
                .addVariant("charcoal_pillar", props, TBS)
                .addVariant("charcoal_prism", props)
                .addVariant("charcoal_raw", props)
                .addVariant("charcoal_road", props)
                .addVariant("charcoal_slanted", props, MULTIBLOCK_2X2)
                .addVariant("charcoal_small_bricks", props)
                .addVariant("charcoal_soft_bricks", props)
                .addVariant("charcoal_solid_bricks", props)
                .addVariant("charcoal_tiles_large", props, CONNECTED)
                .addVariant("charcoal_tiles_medium", props)
                .addVariant("charcoal_tiles_small", props)
                .addVariant("charcoal_triple_bricks", props)
                .addVariant("charcoal_twisted", props, TBS)
                .addVariant("charcoal_weaver", props, CONNECTED)
                .addVariant("charcoal_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("charcoal_array"), "Charcoal", "Charcoal Pillar");
        lang.addBlock(getVariant("charcoal_braid"), "Charcoal", "Braid");
        lang.addBlock(getVariant("charcoal_chaotic_bricks"), "Charcoal", "Chaotic Bricks");
        lang.addBlock(getVariant("charcoal_chaotic_medium"), "Charcoal", "Charcoal Bricks");
        lang.addBlock(getVariant("charcoal_chaotic_small"), "Charcoal", "Charcoal Small Tiles");
        lang.addBlock(getVariant("charcoal_circular"), "Charcoal", "Circular");
        lang.addBlock(getVariant("charcoal_cracked"), "Charcoal", "Cracked");
        lang.addBlock(getVariant("charcoal_cracked_bricks"), "Charcoal", "Cracked Bricks");
        lang.addBlock(getVariant("charcoal_cuts"), "Charcoal", "Cuts");
        lang.addBlock(getVariant("charcoal_dent"), "Charcoal", "Dent");
        lang.addBlock(getVariant("charcoal_encased_bricks"), "Charcoal", "Encased Bricks");
        lang.addBlock(getVariant("charcoal_french_1"), "Charcoal", "French 1");
        lang.addBlock(getVariant("charcoal_french_2"), "Charcoal", "French 2");
        lang.addBlock(getVariant("charcoal_jellybean"), "Charcoal", "Jellybean");
        lang.addBlock(getVariant("charcoal_layers"), "Charcoal", "Layers");
        lang.addBlock(getVariant("charcoal_mosaic"), "Charcoal", "Mosaic");
        lang.addBlock(getVariant("charcoal_ornate"), "Charcoal", "Ornate Charcoal");
        lang.addBlock(getVariant("charcoal_panel"), "Charcoal", "Panel");
        lang.addBlock(getVariant("charcoal_pillar"), "Charcoal", "Pillar");
        lang.addBlock(getVariant("charcoal_prism"), "Charcoal", "Prismatic Charcoal");
        lang.addBlock(getVariant("charcoal_raw"), "Charcoal", "Raw");
        lang.addBlock(getVariant("charcoal_road"), "Charcoal", "Road");
        lang.addBlock(getVariant("charcoal_slanted"), "Charcoal", "Slanted");
        lang.addBlock(getVariant("charcoal_small_bricks"), "Charcoal", "Small Bricks");
        lang.addBlock(getVariant("charcoal_soft_bricks"), "Charcoal", "Soft Bricks");
        lang.addBlock(getVariant("charcoal_solid_bricks"), "Charcoal", "Solid Bricks");
        lang.addBlock(getVariant("charcoal_tiles_large"), "Charcoal", "Large Tiles");
        lang.addBlock(getVariant("charcoal_tiles_medium"), "Charcoal", "Medium Tiles");
        lang.addBlock(getVariant("charcoal_tiles_small"), "Charcoal", "Small Tiles");
        lang.addBlock(getVariant("charcoal_triple_bricks"), "Charcoal", "Triple Bricks");
        lang.addBlock(getVariant("charcoal_twisted"), "Charcoal", "Twisted");
        lang.addBlock(getVariant("charcoal_weaver"), "Charcoal", "Weaver");
        lang.addBlock(getVariant("charcoal_zag"), "Charcoal", "Zag");
    }
}
