package io.github.chiselteam.chisel.block.family.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class NetheriteFamily extends ChiselFamily {
    public NetheriteFamily(BlockBehaviour.Properties props) {
        family = builder("netherite")
                .addVariant(Blocks.NETHERITE_BLOCK)
                // .addVariant("netherite_array", props, MULTIBLOCK_2X2)
                // .addVariant("netherite_braid", props)
                // .addVariant("netherite_bricks_indent", props)
                // .addVariant("netherite_bricks_inlayed", props)
                // .addVariant("netherite_bricks_large", props, MULTIBLOCK_2X2)
                // .addVariant("netherite_bricks_vertical", props)
                // .addVariant("netherite_chaotic", props, MULTIBLOCK_3X3)
                // .addVariant("netherite_chaotic_medium", props)
                // .addVariant("netherite_chaotic_small", props)
                // .addVariant("netherite_checker", props)
                // .addVariant("netherite_checker_small", props)
                // .addVariant("netherite_circular", props, CONNECTED)
                // .addVariant("netherite_cracked", props)
                // .addVariant("netherite_cracked_bricks", props)
                // .addVariant("netherite_cuts", props, MULTIBLOCK_4X4)
                // .addVariant("netherite_dent", props, CONNECTED)
                // .addVariant("netherite_encased_bricks", props, CONNECTED)
                // .addVariant("netherite_french_1", props)
                // .addVariant("netherite_french_2", props)
                // .addVariant("netherite_indent", props, CONNECTED)
                // .addVariant("netherite_jellybean", props, MULTIBLOCK_2X2)
                // .addVariant("netherite_layers", props)
                // .addVariant("netherite_line_horizontal", props)
                // .addVariant("netherite_line_vertical", props)
                // .addVariant("netherite_meander_horizontal", props, CTMH)
                // .addVariant("netherite_meander_vertical", props, CTMV)
                // .addVariant("netherite_mosaic", props, CONNECTED)
                // .addVariant("netherite_ornate", props)
                // .addVariant("netherite_panel", props)
                // .addVariant("netherite_pillar", props, TBS)
                // .addVariant("netherite_pillar_basic", props, CTMV)
                // .addVariant("netherite_pillar_basic_dent", props, CTMV)
                // .addVariant("netherite_pillar_basic_plain", props, CTMV)
                // .addVariant("netherite_pillar_basic_round", props, CTMV)
                // .addVariant("netherite_pillar_basic_spiral", props, CTMV)
                // .addVariant("netherite_pillar_classic", props, TBS)
                // .addVariant("netherite_pillar_classic_large", props, TBS)
                // .addVariant("netherite_pillar_ionic", props, CTMV)
                // .addVariant("netherite_pillar_ionic_dent", props, CTMV)
                // .addVariant("netherite_pillar_ionic_plain", props, CTMV)
                // .addVariant("netherite_pillar_ionic_round", props, CTMV)
                // .addVariant("netherite_pillar_ionic_spiral", props, CTMV)
                // .addVariant("netherite_pillar_large_basic_triple", props, CTMV)
                // .addVariant("netherite_pillar_large_ionic_triple", props, CTMV)
                // .addVariant("netherite_pillar_meander", props, CTMV)
                // .addVariant("netherite_pillar_meander_dent", props, CTMV)
                // .addVariant("netherite_pillar_meander_plain", props, CTMV)
                // .addVariant("netherite_pillar_meander_round", props, CTMV)
                // .addVariant("netherite_pillar_meander_spiral", props, CTMV)
                // .addVariant("netherite_plate", props, CONNECTED)
                // .addVariant("netherite_polished", props)
                // .addVariant("netherite_prism", props)
                // .addVariant("netherite_raw", props)
                // .addVariant("netherite_road", props)
                // .addVariant("netherite_slanted", props, MULTIBLOCK_2X2)
                // .addVariant("netherite_small_bricks", props)
                // .addVariant("netherite_soft_bricks", props)
                // .addVariant("netherite_solid_bricks", props)
                // .addVariant("netherite_square_border", props, CONNECTED)
                // .addVariant("netherite_tiles_large", props, CONNECTED)
                // .addVariant("netherite_tiles_medium", props)
                // .addVariant("netherite_tiles_small", props)
                // .addVariant("netherite_triple_bricks", props)
                // .addVariant("netherite_twisted", props, TBS)
                // .addVariant("netherite_weaver", props, CONNECTED)
                // .addVariant("netherite_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        // lang.addBlock(getVariant("netherite_array"), "netherite", "Array");
        // lang.addBlock(getVariant("netherite_braid"), "netherite", "Braid");
        // lang.addBlock(getVariant("netherite_chaotic"), "netherite", "Chaotic");
        // lang.addBlock(getVariant("netherite_chaotic_medium"), "netherite", "netherite Bricks");
        // lang.addBlock(getVariant("netherite_chaotic_small"), "netherite", "netherite Small Tiles");
        // lang.addBlock(getVariant("netherite_circular"), "netherite", "Circular");
        // lang.addBlock(getVariant("netherite_cracked"), "netherite", "Cracked");
        // lang.addBlock(getVariant("netherite_cracked_bricks"), "netherite", "Cracked Bricks");
        // lang.addBlock(getVariant("netherite_cuts"), "netherite", "Cuts");
        // lang.addBlock(getVariant("netherite_dent"), "netherite", "Dent");
        // lang.addBlock(getVariant("netherite_encased_bricks"), "netherite", "Encased Bricks");
        // lang.addBlock(getVariant("netherite_french_1"), "netherite", "French 1");
        // lang.addBlock(getVariant("netherite_french_2"), "netherite", "French 2");
        // lang.addBlock(getVariant("netherite_jellybean"), "netherite", "Jellybean");
        // lang.addBlock(getVariant("netherite_layers"), "netherite", "Layers");
        // lang.addBlock(getVariant("netherite_mosaic"), "netherite", "Mosaic");
        // lang.addBlock(getVariant("netherite_ornate"), "netherite", "Ornate");
        // lang.addBlock(getVariant("netherite_panel"), "netherite", "Panel");
        // lang.addBlock(getVariant("netherite_pillar"), "netherite", "Pillar");
        // lang.addBlock(getVariant("netherite_prism"), "netherite", "Prismatic");
        // lang.addBlock(getVariant("netherite_raw"), "netherite", "Raw");
        // lang.addBlock(getVariant("netherite_road"), "netherite", "Road");
        // lang.addBlock(getVariant("netherite_slanted"), "netherite", "Slanted");
        // lang.addBlock(getVariant("netherite_small_bricks"), "netherite", "Small Bricks");
        // lang.addBlock(getVariant("netherite_soft_bricks"), "netherite", "Soft Bricks");
        // lang.addBlock(getVariant("netherite_solid_bricks"), "netherite", "Solid Bricks");
        // lang.addBlock(getVariant("netherite_tiles_large"), "netherite", "Large Tiles");
        // lang.addBlock(getVariant("netherite_tiles_medium"), "netherite", "Medium Tiles");
        // lang.addBlock(getVariant("netherite_tiles_small"), "netherite", "Small Tiles");
        // lang.addBlock(getVariant("netherite_triple_bricks"), "netherite", "Triple Bricks");
        // lang.addBlock(getVariant("netherite_twisted"), "netherite", "Twisted");
        // lang.addBlock(getVariant("netherite_weaver"), "netherite", "Weaver");
        // lang.addBlock(getVariant("netherite_zag"), "netherite", "Zag");
        // lang.addBlock(getVariant("netherite_square_border"), "netherite", "Square Border");
        // lang.addBlock(getVariant("netherite_indent"), "netherite", "Indent");
        // lang.addBlock(getVariant("netherite_checker"), "netherite", "Checker");
        // lang.addBlock(getVariant("netherite_bricks_indent"), "netherite", "Bricks Indent");
        // lang.addBlock(getVariant("netherite_bricks_large"), "netherite", "Large Bricks");
        // lang.addBlock(getVariant("netherite_checker_small"), "netherite", "Small Checker");
        // lang.addBlock(getVariant("netherite_polished"), "netherite", "Polished");
        // lang.addBlock(getVariant("netherite_bricks_vertical"), "netherite", "Vertical Bricks");
        // lang.addBlock(getVariant("netherite_line_horizontal"), "netherite", "Horizontal Line");
        // lang.addBlock(getVariant("netherite_line_vertical"), "netherite", "Vertical Line");
        // lang.addBlock(getVariant("netherite_meander_horizontal"), "netherite", "Horizontal Meander");
        // lang.addBlock(getVariant("netherite_meander_vertical"), "netherite", "Vertical Meander");
        // lang.addBlock(getVariant("netherite_pillar_basic"), "netherite", "Basic Pillar");
        // lang.addBlock(getVariant("netherite_pillar_classic"), "netherite", "Classic Pillar");
        // lang.addBlock(getVariant("netherite_pillar_basic_dent"), "netherite", "Basic Dent Pillar");
        // lang.addBlock(getVariant("netherite_pillar_classic_large"), "netherite", "Large Classic Pillar");
        // lang.addBlock(getVariant("netherite_bricks_inlayed"), "netherite", "Inlayed Bricks");
        // lang.addBlock(getVariant("netherite_pillar_basic_round"), "netherite", "Basic Round Pillar");
        // lang.addBlock(getVariant("netherite_plate"), "netherite", "Plate");
        // lang.addBlock(getVariant("netherite_pillar_ionic"), "netherite", "Ionic Pillar");
        // lang.addBlock(getVariant("netherite_pillar_ionic_dent"), "netherite", "Ionic Dent Pillar");
        // lang.addBlock(getVariant("netherite_pillar_ionic_round"), "netherite", "Ionic Round Pillar");
        // lang.addBlock(getVariant("netherite_pillar_basic_spiral"), "netherite", "Basic Spiral Pillar");
        // lang.addBlock(getVariant("netherite_pillar_ionic_spiral"), "netherite", "Ionic Spiral Pillar");
        // lang.addBlock(getVariant("netherite_pillar_large_ionic_triple"), "netherite", "Large Ionic Triple Pillar");
        // lang.addBlock(getVariant("netherite_pillar_meander"), "netherite", "Meander Pillar");
        // lang.addBlock(getVariant("netherite_pillar_meander_dent"), "netherite", "Meander Dent Pillar");
        // lang.addBlock(getVariant("netherite_pillar_meander_plain"), "netherite", "Meander Plain Pillar");
        // lang.addBlock(getVariant("netherite_pillar_meander_round"), "netherite", "Meander Round Pillar");
        // lang.addBlock(getVariant("netherite_pillar_meander_spiral"), "netherite", "Meander Spiral Pillar");
        // lang.addBlock(getVariant("netherite_pillar_basic_plain"), "netherite", "Basic Plain Pillar");
        // lang.addBlock(getVariant("netherite_pillar_ionic_plain"), "netherite", "Ionic Plain Pillar");
        // lang.addBlock(getVariant("netherite_pillar_large_basic_triple"), "netherite", "Large Basic Triple Pillar");
    }
}

