package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class DripstoneFamily extends ChiselFamily {
    public DripstoneFamily(BlockBehaviour.Properties props) {
        family = builder("dripstone")
                .addVariant(Blocks.DRIPSTONE_BLOCK)
                .addVariant("dripstone_array", props, MULTIBLOCK_2X2)
                .addVariant("dripstone_braid", props)
                .addVariant("dripstone_bricks_indent", props)
                .addVariant("dripstone_bricks_inlayed", props)
                .addVariant("dripstone_bricks_large", props, MULTIBLOCK_2X2)
                .addVariant("dripstone_bricks_vertical", props)
                .addVariant("dripstone_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("dripstone_chaotic_medium", props)
                .addVariant("dripstone_chaotic_small", props)
                .addVariant("dripstone_checker", props)
                .addVariant("dripstone_checker_small", props)
                .addVariant("dripstone_circular", props, CONNECTED)
                .addVariant("dripstone_cobble", props)
                .addVariant("dripstone_bricks_cracked", props)
                .addVariant("dripstone_cuts", props, MULTIBLOCK_4X4)
                .addVariant("dripstone_dent", props, CONNECTED)
                .addVariant("dripstone_bricks_encased", props, CONNECTED)
                .addVariant("dripstone_french_1", props)
                .addVariant("dripstone_french_2", props)
                .addVariant("dripstone_indent", props, CONNECTED)
                .addVariant("dripstone_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("dripstone_layers", props)
                .addVariant("dripstone_line_horizontal", props)
                .addVariant("dripstone_line_vertical", props)
                .addVariant("dripstone_meander_horizontal", props, CTMH)
                .addVariant("dripstone_meander_vertical", props, CTMV)
                .addVariant("dripstone_mosaic", props, CONNECTED)
                .addVariant("dripstone_ornate_small", props)
                .addVariant("dripstone_panel", props)
                .addVariant("dripstone_pillar", props, TBS)
                .addVariant("dripstone_pillar_basic", props, CTMV)
                .addVariant("dripstone_pillar_basic_dent", props, CTMV)
                .addVariant("dripstone_pillar_basic_plain", props, CTMV)
                .addVariant("dripstone_pillar_basic_round", props, CTMV)
                .addVariant("dripstone_pillar_basic_spiral", props, CTMV)
                .addVariant("dripstone_pillar_classic", props, TBS)
                .addVariant("dripstone_pillar_classic_large", props, TBS)
                .addVariant("dripstone_pillar_ionic", props, CTMV)
                .addVariant("dripstone_pillar_ionic_dent", props, CTMV)
                .addVariant("dripstone_pillar_ionic_plain", props, CTMV)
                .addVariant("dripstone_pillar_ionic_round", props, CTMV)
                .addVariant("dripstone_pillar_ionic_spiral", props, CTMV)
                .addVariant("dripstone_pillar_large_basic_triple", props, CTMV)
                .addVariant("dripstone_pillar_large_ionic_triple", props, CTMV)
                .addVariant("dripstone_pillar_meander", props, CTMV)
                .addVariant("dripstone_pillar_meander_dent", props, CTMV)
                .addVariant("dripstone_pillar_meander_plain", props, CTMV)
                .addVariant("dripstone_pillar_meander_round", props, CTMV)
                .addVariant("dripstone_pillar_meander_spiral", props, CTMV)
                .addVariant("dripstone_plate", props, CONNECTED)
                .addVariant("dripstone_polished", props)
                .addVariant("dripstone_prism", props)
                .addVariant("dripstone_raw", props)
                .addVariant("dripstone_road", props)
                .addVariant("dripstone_slanted", props, MULTIBLOCK_2X2)
                .addVariant("dripstone_bricks_small", props)
                .addVariant("dripstone_bricks_soft", props)
                .addVariant("dripstone_bricks_solid", props)
                .addVariant("dripstone_border_square", props, CONNECTED)
                .addVariant("dripstone_tiles_large", props, CONNECTED)
                .addVariant("dripstone_tiles", props)
                .addVariant("dripstone_tiles_small", props)
                .addVariant("dripstone_bricks_triple", props)
                .addVariant("dripstone_twisted", props, TBS)
                .addVariant("dripstone_weaver", props, CONNECTED)
                .addVariant("dripstone_zag", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("dripstone_array"), "Dripstone", "Array");
        lang.addBlock(getVariant("dripstone_border_square"), "Dripstone", "Square Border");
        lang.addBlock(getVariant("dripstone_braid"), "Dripstone", "Braid");
        lang.addBlock(getVariant("dripstone_bricks_cracked"), "Dripstone", "Cracked Bricks");
        lang.addBlock(getVariant("dripstone_bricks_encased"), "Dripstone", "Encased Bricks");
        lang.addBlock(getVariant("dripstone_bricks_indent"), "Dripstone", "Indent Bricks");
        lang.addBlock(getVariant("dripstone_bricks_inlayed"), "Dripstone", "Inlayed Bricks");
        lang.addBlock(getVariant("dripstone_bricks_large"), "Dripstone", "Large Bricks");
        lang.addBlock(getVariant("dripstone_bricks_small"), "Dripstone", "Small Bricks");
        lang.addBlock(getVariant("dripstone_bricks_soft"), "Dripstone", "Soft Bricks");
        lang.addBlock(getVariant("dripstone_bricks_solid"), "Dripstone", "Solid Bricks");
        lang.addBlock(getVariant("dripstone_bricks_triple"), "Dripstone", "Triple Bricks");
        lang.addBlock(getVariant("dripstone_bricks_vertical"), "Dripstone", "Vertical Bricks");
        lang.addBlock(getVariant("dripstone_chaotic"), "Dripstone", "Chaotic");
        lang.addBlock(getVariant("dripstone_chaotic_medium"), "Dripstone", "Chaotic Medium");
        lang.addBlock(getVariant("dripstone_chaotic_small"), "Dripstone", "Chaotic Small");
        lang.addBlock(getVariant("dripstone_checker"), "Dripstone", "Checker");
        lang.addBlock(getVariant("dripstone_checker_small"), "Dripstone", "Small Checker");
        lang.addBlock(getVariant("dripstone_circular"), "Dripstone", "Circular");
        lang.addBlock(getVariant("dripstone_cobble"), "Dripstone", "Cobble");
        lang.addBlock(getVariant("dripstone_cuts"), "Dripstone", "Cuts");
        lang.addBlock(getVariant("dripstone_dent"), "Dripstone", "Dent");
        lang.addBlock(getVariant("dripstone_french_1"), "Dripstone", "French 1");
        lang.addBlock(getVariant("dripstone_french_2"), "Dripstone", "French 2");
        lang.addBlock(getVariant("dripstone_indent"), "Dripstone", "Indent");
        lang.addBlock(getVariant("dripstone_jellybean"), "Dripstone", "Jellybean");
        lang.addBlock(getVariant("dripstone_layers"), "Dripstone", "Layers");
        lang.addBlock(getVariant("dripstone_line_horizontal"), "Dripstone", "Horizontal Line");
        lang.addBlock(getVariant("dripstone_line_vertical"), "Dripstone", "Vertical Line");
        lang.addBlock(getVariant("dripstone_meander_horizontal"), "Dripstone", "Horizontal Meander");
        lang.addBlock(getVariant("dripstone_meander_vertical"), "Dripstone", "Vertical Meander");
        lang.addBlock(getVariant("dripstone_mosaic"), "Dripstone", "Mosaic");
        lang.addBlock(getVariant("dripstone_ornate_small"), "Dripstone", "Small Ornate");
        lang.addBlock(getVariant("dripstone_panel"), "Dripstone", "Panel");
        lang.addBlock(getVariant("dripstone_pillar"), "Dripstone", "Pillar");
        lang.addBlock(getVariant("dripstone_pillar_basic"), "Dripstone", "Basic Pillar");
        lang.addBlock(getVariant("dripstone_pillar_basic_dent"), "Dripstone", "Basic Dent Pillar");
        lang.addBlock(getVariant("dripstone_pillar_basic_plain"), "Dripstone", "Basic Plain Pillar");
        lang.addBlock(getVariant("dripstone_pillar_basic_round"), "Dripstone", "Basic Round Pillar");
        lang.addBlock(getVariant("dripstone_pillar_basic_spiral"), "Dripstone", "Basic Spiral Pillar");
        lang.addBlock(getVariant("dripstone_pillar_classic"), "Dripstone", "Classic Pillar");
        lang.addBlock(getVariant("dripstone_pillar_classic_large"), "Dripstone", "Large Classic Pillar");
        lang.addBlock(getVariant("dripstone_pillar_ionic"), "Dripstone", "Ionic Pillar");
        lang.addBlock(getVariant("dripstone_pillar_ionic_dent"), "Dripstone", "Ionic Dent Pillar");
        lang.addBlock(getVariant("dripstone_pillar_ionic_plain"), "Dripstone", "Ionic Plain Pillar");
        lang.addBlock(getVariant("dripstone_pillar_ionic_round"), "Dripstone", "Ionic Round Pillar");
        lang.addBlock(getVariant("dripstone_pillar_ionic_spiral"), "Dripstone", "Ionic Spiral Pillar");
        lang.addBlock(getVariant("dripstone_pillar_large_basic_triple"), "Dripstone", "Large Basic Triple Pillar");
        lang.addBlock(getVariant("dripstone_pillar_large_ionic_triple"), "Dripstone", "Large Ionic Triple Pillar");
        lang.addBlock(getVariant("dripstone_pillar_meander"), "Dripstone", "Meander Pillar");
        lang.addBlock(getVariant("dripstone_pillar_meander_dent"), "Dripstone", "Meander Dent Pillar");
        lang.addBlock(getVariant("dripstone_pillar_meander_plain"), "Dripstone", "Meander Plain Pillar");
        lang.addBlock(getVariant("dripstone_pillar_meander_round"), "Dripstone", "Meander Round Pillar");
        lang.addBlock(getVariant("dripstone_pillar_meander_spiral"), "Dripstone", "Meander Spiral Pillar");
        lang.addBlock(getVariant("dripstone_plate"), "Dripstone", "Plate");
        lang.addBlock(getVariant("dripstone_polished"), "Dripstone", "Polished");
        lang.addBlock(getVariant("dripstone_prism"), "Dripstone", "Prismatic");
        lang.addBlock(getVariant("dripstone_raw"), "Dripstone", "Raw");
        lang.addBlock(getVariant("dripstone_road"), "Dripstone", "Road");
        lang.addBlock(getVariant("dripstone_slanted"), "Dripstone", "Slanted");
        lang.addBlock(getVariant("dripstone_tiles"), "Dripstone", "Tiles");
        lang.addBlock(getVariant("dripstone_tiles_large"), "Dripstone", "Large Tiles");
        lang.addBlock(getVariant("dripstone_tiles_small"), "Dripstone", "Small Tiles");
        lang.addBlock(getVariant("dripstone_twisted"), "Dripstone", "Twisted");
        lang.addBlock(getVariant("dripstone_weaver"), "Dripstone", "Weaver");
        lang.addBlock(getVariant("dripstone_zag"), "Dripstone", "Zag");
    }
}
