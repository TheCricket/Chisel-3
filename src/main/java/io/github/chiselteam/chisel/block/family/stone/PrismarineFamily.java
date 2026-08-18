package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class PrismarineFamily extends ChiselFamily {
    public PrismarineFamily(BlockBehaviour.Properties props) {
        family = builder("prismarine")
                .addVariant(Blocks.PRISMARINE)
                .addVariant(Blocks.PRISMARINE_BRICKS)
                .addVariant(Blocks.DARK_PRISMARINE)
                .addVariant("prismarine_array", props, MULTIBLOCK_2X2)
                .addVariant("prismarine_braid", props)
                .addVariant("prismarine_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("prismarine_chaotic_medium", props)
                .addVariant("prismarine_chaotic_small", props)
                .addVariant("prismarine_circular", props, CONNECTED)
                .addVariant("prismarine_cracked", props)
                .addVariant("prismarine_cracked_bricks", props)
                .addVariant("prismarine_cuts", props, MULTIBLOCK_4X4)
                .addVariant("prismarine_dent", props, CONNECTED)
                .addVariant("prismarine_encased_bricks", props, CONNECTED)
                .addVariant("prismarine_french_1", props)
                .addVariant("prismarine_french_2", props)
                .addVariant("prismarine_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("prismarine_layers", props)
                .addVariant("prismarine_mosaic", props, CONNECTED)
                .addVariant("prismarine_ornate", props)
                .addVariant("prismarine_panel", props)
                .addVariant("prismarine_pillar", props, TBS)
                .addVariant("prismarine_prism", props)
                .addVariant("prismarine_road", props)
                .addVariant("prismarine_slanted", props, MULTIBLOCK_2X2)
                .addVariant("prismarine_small_bricks", props)
                .addVariant("prismarine_soft_bricks", props)
                .addVariant("prismarine_solid_bricks", props)
                .addVariant("prismarine_tiles_large", props, CONNECTED)
                .addVariant("prismarine_tiles_medium", props)
                .addVariant("prismarine_tiles_small", props)
                .addVariant("prismarine_triple_bricks", props)
                .addVariant("prismarine_twisted", props, TBS)
                .addVariant("prismarine_weaver", props, CONNECTED)
                .addVariant("prismarine_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("prismarine_array"), "Prismarine", "Prismarine Pillar");
        lang.addBlock(getVariant("prismarine_braid"), "Prismarine", "Braid");
        lang.addBlock(getVariant("prismarine_chaotic_bricks"), "Prismarine", "Chaotic Bricks");
        lang.addBlock(getVariant("prismarine_chaotic_medium"), "Prismarine", "Prismarine Bricks");
        lang.addBlock(getVariant("prismarine_chaotic_small"), "Prismarine", "Prismarine Small Tiles");
        lang.addBlock(getVariant("prismarine_circular"), "Prismarine", "Circular");
        lang.addBlock(getVariant("prismarine_cracked"), "Prismarine", "Cracked");
        lang.addBlock(getVariant("prismarine_cracked_bricks"), "Prismarine", "Cracked Bricks");
        lang.addBlock(getVariant("prismarine_cuts"), "Prismarine", "Cuts");
        lang.addBlock(getVariant("prismarine_dent"), "Prismarine", "Dent");
        lang.addBlock(getVariant("prismarine_encased_bricks"), "Prismarine", "Encased Bricks");
        lang.addBlock(getVariant("prismarine_french_1"), "Prismarine", "French 1");
        lang.addBlock(getVariant("prismarine_french_2"), "Prismarine", "French 2");
        lang.addBlock(getVariant("prismarine_jellybean"), "Prismarine", "Jellybean");
        lang.addBlock(getVariant("prismarine_layers"), "Prismarine", "Layers");
        lang.addBlock(getVariant("prismarine_mosaic"), "Prismarine", "Mosaic");
        lang.addBlock(getVariant("prismarine_ornate"), "Prismarine", "Ornate Prismarine");
        lang.addBlock(getVariant("prismarine_panel"), "Prismarine", "Panel");
        lang.addBlock(getVariant("prismarine_pillar"), "Prismarine", "Pillar");
        lang.addBlock(getVariant("prismarine_prism"), "Prismarine", "Prismatic Prismarine");
        lang.addBlock(getVariant("prismarine_road"), "Prismarine", "Road");
        lang.addBlock(getVariant("prismarine_slanted"), "Prismarine", "Slanted");
        lang.addBlock(getVariant("prismarine_small_bricks"), "Prismarine", "Small Bricks");
        lang.addBlock(getVariant("prismarine_soft_bricks"), "Prismarine", "Soft Bricks");
        lang.addBlock(getVariant("prismarine_solid_bricks"), "Prismarine", "Solid Bricks");
        lang.addBlock(getVariant("prismarine_tiles_large"), "Prismarine", "Large Tiles");
        lang.addBlock(getVariant("prismarine_tiles_medium"), "Prismarine", "Medium Tiles");
        lang.addBlock(getVariant("prismarine_tiles_small"), "Prismarine", "Small Tiles");
        lang.addBlock(getVariant("prismarine_triple_bricks"), "Prismarine", "Triple Bricks");
        lang.addBlock(getVariant("prismarine_twisted"), "Prismarine", "Twisted");
        lang.addBlock(getVariant("prismarine_weaver"), "Prismarine", "Weaver");
        lang.addBlock(getVariant("prismarine_zag"), "Prismarine", "Zag");
    }
}
