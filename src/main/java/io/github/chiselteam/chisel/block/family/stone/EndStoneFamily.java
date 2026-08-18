package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class EndStoneFamily extends ChiselFamily {
    public EndStoneFamily(BlockBehaviour.Properties props) {
        family = builder("end_stone")
                .addVariant(Blocks.END_STONE)
                .addVariant(Blocks.END_STONE_BRICKS)
                .addVariant("end_stone_array", props, MULTIBLOCK_2X2)
                .addVariant("end_stone_braid", props)
                .addVariant("end_stone_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("end_stone_chaotic_medium", props)
                .addVariant("end_stone_chaotic_small", props)
                .addVariant("end_stone_circular", props, CONNECTED)
                .addVariant("end_stone_cracked", props)
                .addVariant("end_stone_cracked_bricks", props)
                .addVariant("end_stone_cuts", props, MULTIBLOCK_4X4)
                .addVariant("end_stone_dent", props, CONNECTED)
                .addVariant("end_stone_encased_bricks", props, CONNECTED)
                .addVariant("end_stone_french_1", props)
                .addVariant("end_stone_french_2", props)
                .addVariant("end_stone_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("end_stone_layers", props)
                .addVariant("end_stone_mosaic", props, CONNECTED)
                .addVariant("end_stone_ornate", props)
                .addVariant("end_stone_panel", props)
                .addVariant("end_stone_pillar", props, TBS)
                .addVariant("end_stone_prism", props)
                .addVariant("end_stone_raw", props)
                .addVariant("end_stone_road", props)
                .addVariant("end_stone_slanted", props, MULTIBLOCK_2X2)
                .addVariant("end_stone_small_bricks", props)
                .addVariant("end_stone_soft_bricks", props)
                .addVariant("end_stone_solid_bricks", props)
                .addVariant("end_stone_tiles_large", props, CONNECTED)
                .addVariant("end_stone_tiles_medium", props)
                .addVariant("end_stone_tiles_small", props)
                .addVariant("end_stone_triple_bricks", props)
                .addVariant("end_stone_twisted", props, TBS)
                .addVariant("end_stone_weaver", props, CONNECTED)
                .addVariant("end_stone_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("end_stone_array"), "End Stone", "End Stone Pillar");
        lang.addBlock(getVariant("end_stone_braid"), "End Stone", "Braid");
        lang.addBlock(getVariant("end_stone_chaotic_bricks"), "End Stone", "Chaotic Bricks");
        lang.addBlock(getVariant("end_stone_chaotic_medium"), "End Stone", "End Stone Bricks");
        lang.addBlock(getVariant("end_stone_chaotic_small"), "End Stone", "End Stone Small Tiles");
        lang.addBlock(getVariant("end_stone_circular"), "End Stone", "Circular");
        lang.addBlock(getVariant("end_stone_cracked"), "End Stone", "Cracked");
        lang.addBlock(getVariant("end_stone_cracked_bricks"), "End Stone", "Cracked Bricks");
        lang.addBlock(getVariant("end_stone_cuts"), "End Stone", "Cuts");
        lang.addBlock(getVariant("end_stone_dent"), "End Stone", "Dent");
        lang.addBlock(getVariant("end_stone_encased_bricks"), "End Stone", "Encased Bricks");
        lang.addBlock(getVariant("end_stone_french_1"), "End Stone", "French 1");
        lang.addBlock(getVariant("end_stone_french_2"), "End Stone", "French 2");
        lang.addBlock(getVariant("end_stone_jellybean"), "End Stone", "Jellybean");
        lang.addBlock(getVariant("end_stone_layers"), "End Stone", "Layers");
        lang.addBlock(getVariant("end_stone_mosaic"), "End Stone", "Mosaic");
        lang.addBlock(getVariant("end_stone_ornate"), "End Stone", "Ornate End Stone");
        lang.addBlock(getVariant("end_stone_panel"), "End Stone", "Panel");
        lang.addBlock(getVariant("end_stone_pillar"), "End Stone", "Pillar");
        lang.addBlock(getVariant("end_stone_prism"), "End Stone", "Prismatic End Stone");
        lang.addBlock(getVariant("end_stone_raw"), "End Stone", "Raw");
        lang.addBlock(getVariant("end_stone_road"), "End Stone", "Road");
        lang.addBlock(getVariant("end_stone_slanted"), "End Stone", "Slanted");
        lang.addBlock(getVariant("end_stone_small_bricks"), "End Stone", "Small Bricks");
        lang.addBlock(getVariant("end_stone_soft_bricks"), "End Stone", "Soft Bricks");
        lang.addBlock(getVariant("end_stone_solid_bricks"), "End Stone", "Solid Bricks");
        lang.addBlock(getVariant("end_stone_tiles_large"), "End Stone", "Large Tiles");
        lang.addBlock(getVariant("end_stone_tiles_medium"), "End Stone", "Medium Tiles");
        lang.addBlock(getVariant("end_stone_tiles_small"), "End Stone", "Small Tiles");
        lang.addBlock(getVariant("end_stone_triple_bricks"), "End Stone", "Triple Bricks");
        lang.addBlock(getVariant("end_stone_twisted"), "End Stone", "Twisted");
        lang.addBlock(getVariant("end_stone_weaver"), "End Stone", "Weaver");
        lang.addBlock(getVariant("end_stone_zag"), "End Stone", "Zag");
    }
}
