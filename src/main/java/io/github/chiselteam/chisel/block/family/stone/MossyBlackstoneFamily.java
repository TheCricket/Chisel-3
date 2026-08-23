package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class MossyBlackstoneFamily extends ChiselFamily {
    public MossyBlackstoneFamily(BlockBehaviour.Properties props) {
        family = builder("mossy_blackstone")
                .addVariant("mossy_blackstone", props)
                // .addVariant("mossy_blackstone_array", props, MULTIBLOCK_2X2)
                // .addVariant("mossy_blackstone_braid", props)
                // .addVariant("mossy_blackstone_bricks_indent", props)
                // .addVariant("mossy_blackstone_bricks_inlayed", props)
                // .addVariant("mossy_blackstone_bricks_large", props, MULTIBLOCK_2X2)
                // .addVariant("mossy_blackstone_bricks_vertical", props)
                // .addVariant("mossy_blackstone_chaotic", props, MULTIBLOCK_3X3)
                // .addVariant("mossy_blackstone_chaotic_medium", props)
                // .addVariant("mossy_blackstone_chaotic_small", props)
                // .addVariant("mossy_blackstone_checker", props)
                // .addVariant("mossy_blackstone_checker_small", props)
                // .addVariant("mossy_blackstone_circular", props, CONNECTED)
                // .addVariant("mossy_blackstone_cobble", props)
                // .addVariant("mossy_blackstone_bricks_cracked", props)
                // .addVariant("mossy_blackstone_cuts", props, MULTIBLOCK_4X4)
                // .addVariant("mossy_blackstone_dent", props, CONNECTED)
                // .addVariant("mossy_blackstone_bricks_encased", props, CONNECTED)
                // .addVariant("mossy_blackstone_french_1", props)
                // .addVariant("mossy_blackstone_french_2", props)
                // .addVariant("mossy_blackstone_indent", props, CONNECTED)
                // .addVariant("mossy_blackstone_jellybean", props, MULTIBLOCK_2X2)
                // .addVariant("mossy_blackstone_layers", props)
                // .addVariant("mossy_blackstone_line_horizontal", props)
                // .addVariant("mossy_blackstone_line_vertical", props)
                // .addVariant("mossy_blackstone_meander_horizontal", props, CTMH)
                // .addVariant("mossy_blackstone_meander_vertical", props, CTMV)
                // .addVariant("mossy_blackstone_mosaic", props, CONNECTED)
                // .addVariant("mossy_blackstone_ornate_small", props)
                // .addVariant("mossy_blackstone_panel", props)
                // .addVariant("mossy_blackstone_pillar", props, TBS)
                // .addVariant("mossy_blackstone_pillar_basic", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_basic_dent", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_basic_plain", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_basic_round", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_basic_spiral", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_classic", props, TBS)
                // .addVariant("mossy_blackstone_pillar_classic_large", props, TBS)
                // .addVariant("mossy_blackstone_pillar_ionic", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_ionic_dent", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_ionic_plain", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_ionic_round", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_ionic_spiral", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_large_basic_triple", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_large_ionic_triple", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_meander", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_meander_dent", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_meander_plain", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_meander_round", props, CTMV)
                // .addVariant("mossy_blackstone_pillar_meander_spiral", props, CTMV)
                // .addVariant("mossy_blackstone_plate", props, CONNECTED)
                // .addVariant("mossy_blackstone_polished", props)
                // .addVariant("mossy_blackstone_prism", props)
                // .addVariant("mossy_blackstone_raw", props)
                // .addVariant("mossy_blackstone_road", props)
                // .addVariant("mossy_blackstone_slanted", props, MULTIBLOCK_2X2)
                // .addVariant("mossy_blackstone_bricks_small", props)
                // .addVariant("mossy_blackstone_bricks_soft", props)
                // .addVariant("mossy_blackstone_bricks_solid", props)
                // .addVariant("mossy_blackstone_border_square", props, CONNECTED)
                // .addVariant("mossy_blackstone_tiles_large", props, CONNECTED)
                // .addVariant("mossy_blackstone_tiles", props)
                // .addVariant("mossy_blackstone_tiles_small", props)
                // .addVariant("mossy_blackstone_bricks_triple", props)
                // .addVariant("mossy_blackstone_twisted", props, TBS)
                // .addVariant("mossy_blackstone_weaver", props, CONNECTED)
                // .addVariant("mossy_blackstone_zag", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("mossy_blackstone"), "Mossy Blackstone", "Mossy Blackstone");
        // lang.addBlock(getVariant("mossy_blackstone_array"), "Mossy Blackstone", "Array");
        // lang.addBlock(getVariant("mossy_blackstone_border_square"), "Mossy Blackstone", "Square Border");
        // lang.addBlock(getVariant("mossy_blackstone_braid"), "Mossy Blackstone", "Braid");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_cracked"), "Mossy Blackstone", "Cracked Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_encased"), "Mossy Blackstone", "Encased Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_indent"), "Mossy Blackstone", "Indent Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_inlayed"), "Mossy Blackstone", "Inlayed Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_large"), "Mossy Blackstone", "Large Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_small"), "Mossy Blackstone", "Small Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_soft"), "Mossy Blackstone", "Soft Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_solid"), "Mossy Blackstone", "Solid Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_triple"), "Mossy Blackstone", "Triple Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_bricks_vertical"), "Mossy Blackstone", "Vertical Bricks");
        // lang.addBlock(getVariant("mossy_blackstone_chaotic"), "Mossy Blackstone", "Chaotic");
        // lang.addBlock(getVariant("mossy_blackstone_chaotic_medium"), "Mossy Blackstone", "Chaotic Medium");
        // lang.addBlock(getVariant("mossy_blackstone_chaotic_small"), "Mossy Blackstone", "Chaotic Small");
        // lang.addBlock(getVariant("mossy_blackstone_checker"), "Mossy Blackstone", "Checker");
        // lang.addBlock(getVariant("mossy_blackstone_checker_small"), "Mossy Blackstone", "Small Checker");
        // lang.addBlock(getVariant("mossy_blackstone_circular"), "Mossy Blackstone", "Circular");
        // lang.addBlock(getVariant("mossy_blackstone_cobble"), "Mossy Blackstone", "Cobble");
        // lang.addBlock(getVariant("mossy_blackstone_cuts"), "Mossy Blackstone", "Cuts");
        // lang.addBlock(getVariant("mossy_blackstone_dent"), "Mossy Blackstone", "Dent");
        // lang.addBlock(getVariant("mossy_blackstone_french_1"), "Mossy Blackstone", "French 1");
        // lang.addBlock(getVariant("mossy_blackstone_french_2"), "Mossy Blackstone", "French 2");
        // lang.addBlock(getVariant("mossy_blackstone_indent"), "Mossy Blackstone", "Indent");
        // lang.addBlock(getVariant("mossy_blackstone_jellybean"), "Mossy Blackstone", "Jellybean");
        // lang.addBlock(getVariant("mossy_blackstone_layers"), "Mossy Blackstone", "Layers");
        // lang.addBlock(getVariant("mossy_blackstone_line_horizontal"), "Mossy Blackstone", "Horizontal Line");
        // lang.addBlock(getVariant("mossy_blackstone_line_vertical"), "Mossy Blackstone", "Vertical Line");
        // lang.addBlock(getVariant("mossy_blackstone_meander_horizontal"), "Mossy Blackstone", "Horizontal Meander");
        // lang.addBlock(getVariant("mossy_blackstone_meander_vertical"), "Mossy Blackstone", "Vertical Meander");
        // lang.addBlock(getVariant("mossy_blackstone_mosaic"), "Mossy Blackstone", "Mosaic");
        // lang.addBlock(getVariant("mossy_blackstone_ornate_small"), "Mossy Blackstone", "Small Ornate");
        // lang.addBlock(getVariant("mossy_blackstone_panel"), "Mossy Blackstone", "Panel");
        // lang.addBlock(getVariant("mossy_blackstone_pillar"), "Mossy Blackstone", "Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_basic"), "Mossy Blackstone", "Basic Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_basic_dent"), "Mossy Blackstone", "Basic Dent Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_basic_plain"), "Mossy Blackstone", "Basic Plain Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_basic_round"), "Mossy Blackstone", "Basic Round Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_basic_spiral"), "Mossy Blackstone", "Basic Spiral Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_classic"), "Mossy Blackstone", "Classic Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_classic_large"), "Mossy Blackstone", "Large Classic Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_ionic"), "Mossy Blackstone", "Ionic Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_ionic_dent"), "Mossy Blackstone", "Ionic Dent Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_ionic_plain"), "Mossy Blackstone", "Ionic Plain Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_ionic_round"), "Mossy Blackstone", "Ionic Round Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_ionic_spiral"), "Mossy Blackstone", "Ionic Spiral Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_large_basic_triple"), "Mossy Blackstone", "Large Basic Triple Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_large_ionic_triple"), "Mossy Blackstone", "Large Ionic Triple Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_meander"), "Mossy Blackstone", "Meander Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_meander_dent"), "Mossy Blackstone", "Meander Dent Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_meander_plain"), "Mossy Blackstone", "Meander Plain Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_meander_round"), "Mossy Blackstone", "Meander Round Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_pillar_meander_spiral"), "Mossy Blackstone", "Meander Spiral Pillar");
        // lang.addBlock(getVariant("mossy_blackstone_plate"), "Mossy Blackstone", "Plate");
        // lang.addBlock(getVariant("mossy_blackstone_polished"), "Mossy Blackstone", "Polished");
        // lang.addBlock(getVariant("mossy_blackstone_prism"), "Mossy Blackstone", "Prismatic");
        // lang.addBlock(getVariant("mossy_blackstone_raw"), "Mossy Blackstone", "Raw");
        // lang.addBlock(getVariant("mossy_blackstone_road"), "Mossy Blackstone", "Road");
        // lang.addBlock(getVariant("mossy_blackstone_slanted"), "Mossy Blackstone", "Slanted");
        // lang.addBlock(getVariant("mossy_blackstone_tiles"), "Mossy Blackstone", "Tiles");
        // lang.addBlock(getVariant("mossy_blackstone_tiles_large"), "Mossy Blackstone", "Large Tiles");
        // lang.addBlock(getVariant("mossy_blackstone_tiles_small"), "Mossy Blackstone", "Small Tiles");
        // lang.addBlock(getVariant("mossy_blackstone_twisted"), "Mossy Blackstone", "Twisted");
        // lang.addBlock(getVariant("mossy_blackstone_weaver"), "Mossy Blackstone", "Weaver");
        // lang.addBlock(getVariant("mossy_blackstone_zag"), "Mossy Blackstone", "Zag");
    }
}

