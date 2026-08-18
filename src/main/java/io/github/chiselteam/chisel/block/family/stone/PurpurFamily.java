package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class PurpurFamily extends ChiselFamily {
    public PurpurFamily(BlockBehaviour.Properties props) {
        family = builder("purpur")
                .addVariant(Blocks.PURPUR_BLOCK)
                .addVariant("purpur_array", props, MULTIBLOCK_2X2)
                .addVariant("purpur_braid", props)
                .addVariant("purpur_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("purpur_chaotic_medium", props)
                .addVariant("purpur_chaotic_small", props)
                .addVariant("purpur_circular", props, CONNECTED)
                .addVariant("purpur_cracked", props)
                .addVariant("purpur_cracked_bricks", props)
                .addVariant("purpur_cuts", props, MULTIBLOCK_4X4)
                .addVariant("purpur_dent", props, CONNECTED)
                .addVariant("purpur_encased_bricks", props, CONNECTED)
                .addVariant("purpur_french_1", props)
                .addVariant("purpur_french_2", props)
                .addVariant("purpur_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("purpur_layers", props)
                .addVariant("purpur_mosaic", props, CONNECTED)
                .addVariant("purpur_ornate", props)
                .addVariant("purpur_panel", props)
                .addVariant("purpur_pillar", props, TBS)
                .addVariant("purpur_prism", props)
                .addVariant("purpur_road", props)
                .addVariant("purpur_slanted", props, MULTIBLOCK_2X2)
                .addVariant("purpur_small_bricks", props)
                .addVariant("purpur_soft_bricks", props)
                .addVariant("purpur_solid_bricks", props)
                .addVariant("purpur_tiles_large", props, CONNECTED)
                .addVariant("purpur_tiles_medium", props)
                .addVariant("purpur_tiles_small", props)
                .addVariant("purpur_triple_bricks", props)
                .addVariant("purpur_twisted", props, TBS)
                .addVariant("purpur_weaver", props, CONNECTED)
                .addVariant("purpur_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("purpur_array"), "Purpur", "Purpur Pillar");
        lang.addBlock(getVariant("purpur_braid"), "Purpur", "Braid");
        lang.addBlock(getVariant("purpur_chaotic_bricks"), "Purpur", "Chaotic Bricks");
        lang.addBlock(getVariant("purpur_chaotic_medium"), "Purpur", "Purpur Bricks");
        lang.addBlock(getVariant("purpur_chaotic_small"), "Purpur", "Purpur Small Tiles");
        lang.addBlock(getVariant("purpur_circular"), "Purpur", "Circular");
        lang.addBlock(getVariant("purpur_cracked"), "Purpur", "Cracked");
        lang.addBlock(getVariant("purpur_cracked_bricks"), "Purpur", "Cracked Bricks");
        lang.addBlock(getVariant("purpur_cuts"), "Purpur", "Cuts");
        lang.addBlock(getVariant("purpur_dent"), "Purpur", "Dent");
        lang.addBlock(getVariant("purpur_encased_bricks"), "Purpur", "Encased Bricks");
        lang.addBlock(getVariant("purpur_french_1"), "Purpur", "French 1");
        lang.addBlock(getVariant("purpur_french_2"), "Purpur", "French 2");
        lang.addBlock(getVariant("purpur_jellybean"), "Purpur", "Jellybean");
        lang.addBlock(getVariant("purpur_layers"), "Purpur", "Layers");
        lang.addBlock(getVariant("purpur_mosaic"), "Purpur", "Mosaic");
        lang.addBlock(getVariant("purpur_ornate"), "Purpur", "Ornate Purpur");
        lang.addBlock(getVariant("purpur_panel"), "Purpur", "Panel");
        lang.addBlock(getVariant("purpur_pillar"), "Purpur", "Pillar");
        lang.addBlock(getVariant("purpur_prism"), "Purpur", "Prismatic Purpur");
        lang.addBlock(getVariant("purpur_road"), "Purpur", "Road");
        lang.addBlock(getVariant("purpur_slanted"), "Purpur", "Slanted");
        lang.addBlock(getVariant("purpur_small_bricks"), "Purpur", "Small Bricks");
        lang.addBlock(getVariant("purpur_soft_bricks"), "Purpur", "Soft Bricks");
        lang.addBlock(getVariant("purpur_solid_bricks"), "Purpur", "Solid Bricks");
        lang.addBlock(getVariant("purpur_tiles_large"), "Purpur", "Large Tiles");
        lang.addBlock(getVariant("purpur_tiles_medium"), "Purpur", "Medium Tiles");
        lang.addBlock(getVariant("purpur_tiles_small"), "Purpur", "Small Tiles");
        lang.addBlock(getVariant("purpur_triple_bricks"), "Purpur", "Triple Bricks");
        lang.addBlock(getVariant("purpur_twisted"), "Purpur", "Twisted");
        lang.addBlock(getVariant("purpur_weaver"), "Purpur", "Weaver");
        lang.addBlock(getVariant("purpur_zag"), "Purpur", "Zag");
    }
}
