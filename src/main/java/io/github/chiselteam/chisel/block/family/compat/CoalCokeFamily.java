package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CoalCokeFamily extends ChiselFamily {
    public CoalCokeFamily(BlockBehaviour.Properties props) {
        family = builder("coal_coke")
                .addVariant("coal_coke_array", props, MULTIBLOCK_2X2)
                .addVariant("coal_coke_braid", props)
                .addVariant("coal_coke_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("coal_coke_chaotic_medium", props)
                .addVariant("coal_coke_chaotic_small", props)
                .addVariant("coal_coke_circular", props, CONNECTED)
                .addVariant("coal_coke_cracked", props)
                .addVariant("coal_coke_cracked_bricks", props)
                .addVariant("coal_coke_cuts", props, MULTIBLOCK_4X4)
                .addVariant("coal_coke_dent", props, CONNECTED)
                .addVariant("coal_coke_encased_bricks", props, CONNECTED)
                .addVariant("coal_coke_french_1", props)
                .addVariant("coal_coke_french_2", props)
                .addVariant("coal_coke_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("coal_coke_layers", props)
                .addVariant("coal_coke_mosaic", props, CONNECTED)
                .addVariant("coal_coke_ornate", props)
                .addVariant("coal_coke_panel", props)
                .addVariant("coal_coke_pillar", props, TBS)
                .addVariant("coal_coke_prism", props)
                .addVariant("coal_coke_raw", props)
                .addVariant("coal_coke_road", props)
                .addVariant("coal_coke_slanted", props, MULTIBLOCK_2X2)
                .addVariant("coal_coke_small_bricks", props)
                .addVariant("coal_coke_soft_bricks", props)
                .addVariant("coal_coke_solid_bricks", props)
                .addVariant("coal_coke_tiles_large", props, CONNECTED)
                .addVariant("coal_coke_tiles_medium", props)
                .addVariant("coal_coke_tiles_small", props)
                .addVariant("coal_coke_triple_bricks", props)
                .addVariant("coal_coke_twisted", props, TBS)
                .addVariant("coal_coke_weaver", props, CONNECTED)
                .addVariant("coal_coke_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("coal_coke_array"), "Coal Coke", "Coal Coke Pillar");
        lang.addBlock(getVariant("coal_coke_braid"), "Coal Coke", "Braid");
        lang.addBlock(getVariant("coal_coke_chaotic_bricks"), "Coal Coke", "Chaotic Bricks");
        lang.addBlock(getVariant("coal_coke_chaotic_medium"), "Coal Coke", "Coal Coke Bricks");
        lang.addBlock(getVariant("coal_coke_chaotic_small"), "Coal Coke", "Coal Coke Small Tiles");
        lang.addBlock(getVariant("coal_coke_circular"), "Coal Coke", "Circular");
        lang.addBlock(getVariant("coal_coke_cracked"), "Coal Coke", "Cracked");
        lang.addBlock(getVariant("coal_coke_cracked_bricks"), "Coal Coke", "Cracked Bricks");
        lang.addBlock(getVariant("coal_coke_cuts"), "Coal Coke", "Cuts");
        lang.addBlock(getVariant("coal_coke_dent"), "Coal Coke", "Dent");
        lang.addBlock(getVariant("coal_coke_encased_bricks"), "Coal Coke", "Encased Bricks");
        lang.addBlock(getVariant("coal_coke_french_1"), "Coal Coke", "French 1");
        lang.addBlock(getVariant("coal_coke_french_2"), "Coal Coke", "French 2");
        lang.addBlock(getVariant("coal_coke_jellybean"), "Coal Coke", "Jellybean");
        lang.addBlock(getVariant("coal_coke_layers"), "Coal Coke", "Layers");
        lang.addBlock(getVariant("coal_coke_mosaic"), "Coal Coke", "Mosaic");
        lang.addBlock(getVariant("coal_coke_ornate"), "Coal Coke", "Ornate Coal Coke");
        lang.addBlock(getVariant("coal_coke_panel"), "Coal Coke", "Panel");
        lang.addBlock(getVariant("coal_coke_pillar"), "Coal Coke", "Pillar");
        lang.addBlock(getVariant("coal_coke_prism"), "Coal Coke", "Prismatic Coal Coke");
        lang.addBlock(getVariant("coal_coke_raw"), "Coal Coke", "Raw");
        lang.addBlock(getVariant("coal_coke_road"), "Coal Coke", "Road");
        lang.addBlock(getVariant("coal_coke_slanted"), "Coal Coke", "Slanted");
        lang.addBlock(getVariant("coal_coke_small_bricks"), "Coal Coke", "Small Bricks");
        lang.addBlock(getVariant("coal_coke_soft_bricks"), "Coal Coke", "Soft Bricks");
        lang.addBlock(getVariant("coal_coke_solid_bricks"), "Coal Coke", "Solid Bricks");
        lang.addBlock(getVariant("coal_coke_tiles_large"), "Coal Coke", "Large Tiles");
        lang.addBlock(getVariant("coal_coke_tiles_medium"), "Coal Coke", "Medium Tiles");
        lang.addBlock(getVariant("coal_coke_tiles_small"), "Coal Coke", "Small Tiles");
        lang.addBlock(getVariant("coal_coke_triple_bricks"), "Coal Coke", "Triple Bricks");
        lang.addBlock(getVariant("coal_coke_twisted"), "Coal Coke", "Twisted");
        lang.addBlock(getVariant("coal_coke_weaver"), "Coal Coke", "Weaver");
        lang.addBlock(getVariant("coal_coke_zag"), "Coal Coke", "Zag");
    }
}
