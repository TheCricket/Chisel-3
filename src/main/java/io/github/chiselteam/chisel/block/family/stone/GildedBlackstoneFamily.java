package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class GildedBlackstoneFamily extends ChiselFamily {
    public GildedBlackstoneFamily(BlockBehaviour.Properties props) {
        family = builder("gilded_blackstone")
                .addVariant(Blocks.GILDED_BLACKSTONE)
                .addVariant("gilded_blackstone_array", props, MULTIBLOCK_2X2)
                .addVariant("gilded_blackstone_braid", props)
                .addVariant("gilded_blackstone_bricks_indent", props)
                .addVariant("gilded_blackstone_bricks_inlayed", props)
                .addVariant("gilded_blackstone_bricks_large", props, MULTIBLOCK_2X2)
                .addVariant("gilded_blackstone_bricks_vertical", props)
                .addVariant("gilded_blackstone_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("gilded_blackstone_chaotic_medium", props)
                .addVariant("gilded_blackstone_chaotic_small", props)
                .addVariant("gilded_blackstone_checker", props)
                .addVariant("gilded_blackstone_checker_small", props)
                .addVariant("gilded_blackstone_circular", props, CONNECTED)
                .addVariant("gilded_blackstone_cobble", props)
                .addVariant("gilded_blackstone_bricks_cracked", props)
                .addVariant("gilded_blackstone_cuts", props, MULTIBLOCK_4X4)
                .addVariant("gilded_blackstone_dent", props, CONNECTED)
                .addVariant("gilded_blackstone_bricks_encased", props, CONNECTED)
                .addVariant("gilded_blackstone_french_1", props)
                .addVariant("gilded_blackstone_french_2", props)
                .addVariant("gilded_blackstone_indent", props, CONNECTED)
                .addVariant("gilded_blackstone_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("gilded_blackstone_layers", props)
                .addVariant("gilded_blackstone_line_horizontal", props)
                .addVariant("gilded_blackstone_line_vertical", props)
                .addVariant("gilded_blackstone_meander_horizontal", props, CTMH)
                .addVariant("gilded_blackstone_meander_vertical", props, CTMV)
                .addVariant("gilded_blackstone_mosaic", props, CONNECTED)
                .addVariant("gilded_blackstone_ornate_small", props)
                .addVariant("gilded_blackstone_panel", props)
                .addVariant("gilded_blackstone_pillar", props, TBS)
                .addVariant("gilded_blackstone_pillar_basic", props, CTMV)
                .addVariant("gilded_blackstone_pillar_basic_dent", props, CTMV)
                .addVariant("gilded_blackstone_pillar_basic_plain", props, CTMV)
                .addVariant("gilded_blackstone_pillar_basic_round", props, CTMV)
                .addVariant("gilded_blackstone_pillar_basic_spiral", props, CTMV)
                .addVariant("gilded_blackstone_pillar_classic", props, TBS)
                .addVariant("gilded_blackstone_pillar_classic_large", props, TBS)
                .addVariant("gilded_blackstone_pillar_ionic", props, CTMV)
                .addVariant("gilded_blackstone_pillar_ionic_dent", props, CTMV)
                .addVariant("gilded_blackstone_pillar_ionic_plain", props, CTMV)
                .addVariant("gilded_blackstone_pillar_ionic_round", props, CTMV)
                .addVariant("gilded_blackstone_pillar_ionic_spiral", props, CTMV)
                .addVariant("gilded_blackstone_pillar_large_basic_triple", props, CTMV)
                .addVariant("gilded_blackstone_pillar_large_ionic_triple", props, CTMV)
                .addVariant("gilded_blackstone_pillar_meander", props, CTMV)
                .addVariant("gilded_blackstone_pillar_meander_dent", props, CTMV)
                .addVariant("gilded_blackstone_pillar_meander_plain", props, CTMV)
                .addVariant("gilded_blackstone_pillar_meander_round", props, CTMV)
                .addVariant("gilded_blackstone_pillar_meander_spiral", props, CTMV)
                .addVariant("gilded_blackstone_plate", props, CONNECTED)
                .addVariant("gilded_blackstone_polished", props)
                .addVariant("gilded_blackstone_prism", props)
                .addVariant("gilded_blackstone_raw", props)
                .addVariant("gilded_blackstone_road", props)
                .addVariant("gilded_blackstone_slanted", props, MULTIBLOCK_2X2)
                .addVariant("gilded_blackstone_bricks_small", props)
                .addVariant("gilded_blackstone_bricks_soft", props)
                .addVariant("gilded_blackstone_bricks_solid", props)
                .addVariant("gilded_blackstone_border_square", props, CONNECTED)
                .addVariant("gilded_blackstone_tiles_large", props, CONNECTED)
                .addVariant("gilded_blackstone_tiles", props)
                .addVariant("gilded_blackstone_tiles_small", props)
                .addVariant("gilded_blackstone_bricks_triple", props)
                .addVariant("gilded_blackstone_twisted", props, TBS)
                .addVariant("gilded_blackstone_weaver", props, CONNECTED)
                .addVariant("gilded_blackstone_zag", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("gilded_blackstone_array"), "Gilded Blackstone", "Array");
        lang.addBlock(getVariant("gilded_blackstone_border_square"), "Gilded Blackstone", "Square Border");
        lang.addBlock(getVariant("gilded_blackstone_braid"), "Gilded Blackstone", "Braid");
        lang.addBlock(getVariant("gilded_blackstone_bricks_cracked"), "Gilded Blackstone", "Cracked Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_encased"), "Gilded Blackstone", "Encased Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_indent"), "Gilded Blackstone", "Indent Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_inlayed"), "Gilded Blackstone", "Inlayed Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_large"), "Gilded Blackstone", "Large Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_small"), "Gilded Blackstone", "Small Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_soft"), "Gilded Blackstone", "Soft Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_solid"), "Gilded Blackstone", "Solid Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_triple"), "Gilded Blackstone", "Triple Bricks");
        lang.addBlock(getVariant("gilded_blackstone_bricks_vertical"), "Gilded Blackstone", "Vertical Bricks");
        lang.addBlock(getVariant("gilded_blackstone_chaotic"), "Gilded Blackstone", "Chaotic");
        lang.addBlock(getVariant("gilded_blackstone_chaotic_medium"), "Gilded Blackstone", "Chaotic Medium");
        lang.addBlock(getVariant("gilded_blackstone_chaotic_small"), "Gilded Blackstone", "Chaotic Small");
        lang.addBlock(getVariant("gilded_blackstone_checker"), "Gilded Blackstone", "Checker");
        lang.addBlock(getVariant("gilded_blackstone_checker_small"), "Gilded Blackstone", "Small Checker");
        lang.addBlock(getVariant("gilded_blackstone_circular"), "Gilded Blackstone", "Circular");
        lang.addBlock(getVariant("gilded_blackstone_cobble"), "Gilded Blackstone", "Cobble");
        lang.addBlock(getVariant("gilded_blackstone_cuts"), "Gilded Blackstone", "Cuts");
        lang.addBlock(getVariant("gilded_blackstone_dent"), "Gilded Blackstone", "Dent");
        lang.addBlock(getVariant("gilded_blackstone_french_1"), "Gilded Blackstone", "French 1");
        lang.addBlock(getVariant("gilded_blackstone_french_2"), "Gilded Blackstone", "French 2");
        lang.addBlock(getVariant("gilded_blackstone_indent"), "Gilded Blackstone", "Indent");
        lang.addBlock(getVariant("gilded_blackstone_jellybean"), "Gilded Blackstone", "Jellybean");
        lang.addBlock(getVariant("gilded_blackstone_layers"), "Gilded Blackstone", "Layers");
        lang.addBlock(getVariant("gilded_blackstone_line_horizontal"), "Gilded Blackstone", "Horizontal Line");
        lang.addBlock(getVariant("gilded_blackstone_line_vertical"), "Gilded Blackstone", "Vertical Line");
        lang.addBlock(getVariant("gilded_blackstone_meander_horizontal"), "Gilded Blackstone", "Horizontal Meander");
        lang.addBlock(getVariant("gilded_blackstone_meander_vertical"), "Gilded Blackstone", "Vertical Meander");
        lang.addBlock(getVariant("gilded_blackstone_mosaic"), "Gilded Blackstone", "Mosaic");
        lang.addBlock(getVariant("gilded_blackstone_ornate_small"), "Gilded Blackstone", "Small Ornate");
        lang.addBlock(getVariant("gilded_blackstone_panel"), "Gilded Blackstone", "Panel");
        lang.addBlock(getVariant("gilded_blackstone_pillar"), "Gilded Blackstone", "Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_basic"), "Gilded Blackstone", "Basic Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_basic_dent"), "Gilded Blackstone", "Basic Dent Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_basic_plain"), "Gilded Blackstone", "Basic Plain Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_basic_round"), "Gilded Blackstone", "Basic Round Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_basic_spiral"), "Gilded Blackstone", "Basic Spiral Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_classic"), "Gilded Blackstone", "Classic Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_classic_large"), "Gilded Blackstone", "Large Classic Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_ionic"), "Gilded Blackstone", "Ionic Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_ionic_dent"), "Gilded Blackstone", "Ionic Dent Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_ionic_plain"), "Gilded Blackstone", "Ionic Plain Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_ionic_round"), "Gilded Blackstone", "Ionic Round Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_ionic_spiral"), "Gilded Blackstone", "Ionic Spiral Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_large_basic_triple"), "Gilded Blackstone", "Large Basic Triple Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_large_ionic_triple"), "Gilded Blackstone", "Large Ionic Triple Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_meander"), "Gilded Blackstone", "Meander Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_meander_dent"), "Gilded Blackstone", "Meander Dent Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_meander_plain"), "Gilded Blackstone", "Meander Plain Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_meander_round"), "Gilded Blackstone", "Meander Round Pillar");
        lang.addBlock(getVariant("gilded_blackstone_pillar_meander_spiral"), "Gilded Blackstone", "Meander Spiral Pillar");
        lang.addBlock(getVariant("gilded_blackstone_plate"), "Gilded Blackstone", "Plate");
        lang.addBlock(getVariant("gilded_blackstone_polished"), "Gilded Blackstone", "Polished");
        lang.addBlock(getVariant("gilded_blackstone_prism"), "Gilded Blackstone", "Prismatic");
        lang.addBlock(getVariant("gilded_blackstone_raw"), "Gilded Blackstone", "Raw");
        lang.addBlock(getVariant("gilded_blackstone_road"), "Gilded Blackstone", "Road");
        lang.addBlock(getVariant("gilded_blackstone_slanted"), "Gilded Blackstone", "Slanted");
        lang.addBlock(getVariant("gilded_blackstone_tiles"), "Gilded Blackstone", "Tiles");
        lang.addBlock(getVariant("gilded_blackstone_tiles_large"), "Gilded Blackstone", "Large Tiles");
        lang.addBlock(getVariant("gilded_blackstone_tiles_small"), "Gilded Blackstone", "Small Tiles");
        lang.addBlock(getVariant("gilded_blackstone_twisted"), "Gilded Blackstone", "Twisted");
        lang.addBlock(getVariant("gilded_blackstone_weaver"), "Gilded Blackstone", "Weaver");
        lang.addBlock(getVariant("gilded_blackstone_zag"), "Gilded Blackstone", "Zag");
    }
}

