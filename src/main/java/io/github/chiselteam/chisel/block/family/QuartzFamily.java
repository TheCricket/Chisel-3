package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class QuartzFamily extends ChiselFamily {
    public QuartzFamily(BlockBehaviour.Properties props) {
        family = builder("quartz")
                .addVariant(Blocks.QUARTZ_BLOCK)
                .addVariant("quartz_array", props, MULTIBLOCK_2X2)
                .addVariant("quartz_braid", props)
                .addVariant("quartz_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("quartz_chaotic_medium", props)
                .addVariant("quartz_chaotic_small", props)
                .addVariant("quartz_circular", props, CONNECTED)
                .addVariant("quartz_cracked", props)
                .addVariant("quartz_cracked_bricks", props)
                .addVariant("quartz_cuts", props, MULTIBLOCK_4X4)
                .addVariant("quartz_dent", props, CONNECTED)
                .addVariant("quartz_encased_bricks", props, CONNECTED)
                .addVariant("quartz_french_1", props)
                .addVariant("quartz_french_2", props)
                .addVariant("quartz_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("quartz_layers", props)
                .addVariant("quartz_mosaic", props, CONNECTED)
                .addVariant("quartz_ornate", props)
                .addVariant("quartz_panel", props)
                .addVariant("quartz_pillar", props, TBS)
                .addVariant("quartz_prism", props)
                .addVariant("quartz_raw", props)
                .addVariant("quartz_road", props)
                .addVariant("quartz_slanted", props, MULTIBLOCK_2X2)
                .addVariant("quartz_small_bricks", props)
                .addVariant("quartz_soft_bricks", props)
                .addVariant("quartz_solid_bricks", props)
                .addVariant("quartz_tiles_large", props, CONNECTED)
                .addVariant("quartz_tiles_medium", props)
                .addVariant("quartz_tiles_small", props)
                .addVariant("quartz_triple_bricks", props)
                .addVariant("quartz_twisted", props, TBS)
                .addVariant("quartz_weaver", props, CONNECTED)
                .addVariant("quartz_zag", props, AR)
                .addVariant("quartz_square_border", props, CONNECTED)
                .addVariant("quartz_indent", props, CONNECTED)
                .addVariant("quartz_checker", props)
                .addVariant("quartz_bricks_indent", props)
                .addVariant("quartz_bricks_large", props, MULTIBLOCK_2X2)
                .addVariant("quartz_checker_small", props)
                .addVariant("quartz_polished", props)
                .addVariant("quartz_bricks_vertical", props)
                .addVariant("quartz_line_horizontal", props)
                .addVariant("quartz_line_vertical", props)
                .addVariant("quartz_meander_horizontal", props, CTMH)

                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("quartz_array"), "Quartz", "Array");
        lang.addBlock(getVariant("quartz_braid"), "Quartz", "Braid");
        lang.addBlock(getVariant("quartz_chaotic"), "Quartz", "Chaotic");
        lang.addBlock(getVariant("quartz_chaotic_medium"), "Quartz", "Quartz Bricks");
        lang.addBlock(getVariant("quartz_chaotic_small"), "Quartz", "Quartz Small Tiles");
        lang.addBlock(getVariant("quartz_circular"), "Quartz", "Circular");
        lang.addBlock(getVariant("quartz_cracked"), "Quartz", "Cracked");
        lang.addBlock(getVariant("quartz_cracked_bricks"), "Quartz", "Cracked Bricks");
        lang.addBlock(getVariant("quartz_cuts"), "Quartz", "Cuts");
        lang.addBlock(getVariant("quartz_dent"), "Quartz", "Dent");
        lang.addBlock(getVariant("quartz_encased_bricks"), "Quartz", "Encased Bricks");
        lang.addBlock(getVariant("quartz_french_1"), "Quartz", "French 1");
        lang.addBlock(getVariant("quartz_french_2"), "Quartz", "French 2");
        lang.addBlock(getVariant("quartz_jellybean"), "Quartz", "Jellybean");
        lang.addBlock(getVariant("quartz_layers"), "Quartz", "Layers");
        lang.addBlock(getVariant("quartz_mosaic"), "Quartz", "Mosaic");
        lang.addBlock(getVariant("quartz_ornate"), "Quartz", "Ornate");
        lang.addBlock(getVariant("quartz_panel"), "Quartz", "Panel");
        lang.addBlock(getVariant("quartz_pillar"), "Quartz", "Pillar");
        lang.addBlock(getVariant("quartz_prism"), "Quartz", "Prismatic");
        lang.addBlock(getVariant("quartz_raw"), "Quartz", "Raw");
        lang.addBlock(getVariant("quartz_road"), "Quartz", "Road");
        lang.addBlock(getVariant("quartz_slanted"), "Quartz", "Slanted");
        lang.addBlock(getVariant("quartz_small_bricks"), "Quartz", "Small Bricks");
        lang.addBlock(getVariant("quartz_soft_bricks"), "Quartz", "Soft Bricks");
        lang.addBlock(getVariant("quartz_solid_bricks"), "Quartz", "Solid Bricks");
        lang.addBlock(getVariant("quartz_tiles_large"), "Quartz", "Large Tiles");
        lang.addBlock(getVariant("quartz_tiles_medium"), "Quartz", "Medium Tiles");
        lang.addBlock(getVariant("quartz_tiles_small"), "Quartz", "Small Tiles");
        lang.addBlock(getVariant("quartz_triple_bricks"), "Quartz", "Triple Bricks");
        lang.addBlock(getVariant("quartz_twisted"), "Quartz", "Twisted");
        lang.addBlock(getVariant("quartz_weaver"), "Quartz", "Weaver");
        lang.addBlock(getVariant("quartz_zag"), "Quartz", "Zag");
        lang.addBlock(getVariant("quartz_square_border"), "Quartz", "Square Border");
        lang.addBlock(getVariant("quartz_indent"), "Quartz", "Indent");
        lang.addBlock(getVariant("quartz_checker"), "Quartz", "Checker");
        lang.addBlock(getVariant("quartz_bricks_indent"), "Quartz", "Bricks Indent");
        lang.addBlock(getVariant("quartz_bricks_large"), "Quartz", "Large Bricks");
        lang.addBlock(getVariant("quartz_checker_small"), "Quartz", "Small Checker");
        lang.addBlock(getVariant("quartz_polished"), "Quartz", "Polished");
        lang.addBlock(getVariant("quartz_bricks_vertical"), "Quartz", "Vertical Bricks");
        lang.addBlock(getVariant("quartz_line_horizontal"), "Quartz", "Horizontal Line");
        lang.addBlock(getVariant("quartz_line_vertical"), "Quartz", "Vertical Line");
        lang.addBlock(getVariant("quartz_meander_horizontal"), "Quartz", "Horizontal Meander");
        
    }
}

