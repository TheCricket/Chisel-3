package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class AE2SkyStoneFamily extends ChiselFamily {
    public AE2SkyStoneFamily(BlockBehaviour.Properties props) {
        family = builder("ae2_sky_stone")
                .addVariant("sky_stone_array", props, MULTIBLOCK_2X2)
                .addVariant("sky_stone_braid", props)
                .addVariant("sky_stone_bricks_indent", props)
                .addVariant("sky_stone_bricks_inlayed", props)
                .addVariant("sky_stone_bricks_large", props, MULTIBLOCK_2X2)
                .addVariant("sky_stone_bricks_vertical", props)
                .addVariant("sky_stone_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("sky_stone_chaotic_medium", props)
                .addVariant("sky_stone_chaotic_small", props)
                .addVariant("sky_stone_checker", props)
                .addVariant("sky_stone_checker_small", props)
                .addVariant("sky_stone_circular", props, CONNECTED)
                .addVariant("sky_stone_cobble", props)
                .addVariant("sky_stone_bricks_cracked", props)
                .addVariant("sky_stone_cuts", props, MULTIBLOCK_4X4)
                .addVariant("sky_stone_dent", props, CONNECTED)
                .addVariant("sky_stone_bricks_encased", props, CONNECTED)
                .addVariant("sky_stone_french_1", props)
                .addVariant("sky_stone_french_2", props)
                .addVariant("sky_stone_indent", props, CONNECTED)
                .addVariant("sky_stone_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("sky_stone_layers", props)
                .addVariant("sky_stone_line_horizontal", props)
                .addVariant("sky_stone_line_vertical", props)
                .addVariant("sky_stone_meander_horizontal", props, CTMH)
                .addVariant("sky_stone_meander_vertical", props, CTMV)
                .addVariant("sky_stone_mosaic", props, CONNECTED)
                .addVariant("sky_stone_ornate_small", props)
                .addVariant("sky_stone_panel", props)
                .addVariant("sky_stone_pillar", props, TBS)
                .addVariant("sky_stone_pillar_basic", props, CTMV)
                .addVariant("sky_stone_pillar_basic_dent", props, CTMV)
                .addVariant("sky_stone_pillar_basic_plain", props, CTMV)
                .addVariant("sky_stone_pillar_basic_round", props, CTMV)
                .addVariant("sky_stone_pillar_basic_spiral", props, CTMV)
                .addVariant("sky_stone_pillar_classic", props, TBS)
                .addVariant("sky_stone_pillar_classic_large", props, TBS)
                .addVariant("sky_stone_pillar_ionic", props, CTMV)
                .addVariant("sky_stone_pillar_ionic_dent", props, CTMV)
                .addVariant("sky_stone_pillar_ionic_plain", props, CTMV)
                .addVariant("sky_stone_pillar_ionic_round", props, CTMV)
                .addVariant("sky_stone_pillar_ionic_spiral", props, CTMV)
                .addVariant("sky_stone_pillar_large_basic_triple", props, CTMV)
                .addVariant("sky_stone_pillar_large_ionic_triple", props, CTMV)
                .addVariant("sky_stone_pillar_meander", props, CTMV)
                .addVariant("sky_stone_pillar_meander_dent", props, CTMV)
                .addVariant("sky_stone_pillar_meander_plain", props, CTMV)
                .addVariant("sky_stone_pillar_meander_round", props, CTMV)
                .addVariant("sky_stone_pillar_meander_spiral", props, CTMV)
                .addVariant("sky_stone_plate", props, CONNECTED)
                .addVariant("sky_stone_polished", props)
                .addVariant("sky_stone_prism", props)
                .addVariant("sky_stone_raw", props)
                .addVariant("sky_stone_road", props)
                .addVariant("sky_stone_slanted", props, MULTIBLOCK_2X2)
                .addVariant("sky_stone_bricks_small", props)
                .addVariant("sky_stone_bricks_soft", props)
                .addVariant("sky_stone_bricks_solid", props)
                .addVariant("sky_stone_border_square", props, CONNECTED)
                .addVariant("sky_stone_tiles_large", props, CONNECTED)
                .addVariant("sky_stone_tiles", props)
                .addVariant("sky_stone_tiles_small", props)
                .addVariant("sky_stone_bricks_triple", props)
                .addVariant("sky_stone_twisted", props, TBS)
                .addVariant("sky_stone_weaver", props, CONNECTED)
                .addVariant("sky_stone_zag", props, MULTIBLOCK_2X2)
                .addVariant("sky_stone_crate", props, CONNECTED)
                .addVariant("sky_stone_herringbone", props)
                .addVariant("sky_stone_herringbone_encased", props, CONNECTED)
                .addVariant("sky_stone_medallion", props)
                .addVariant("sky_stone_medallion_encased", props, CONNECTED)
                .addVariant("sky_stone_dots", props)
                .addVariant("sky_stone_dots_encased", props, CONNECTED)
                .addVariant("sky_stone_heart", props)
                .addVariant("sky_stone_star", props)
                .addVariant("sky_stone_plating", props)
                .addVariant("sky_stone_lodestone", props)
                .addVariant("sky_stone_plank", props)
                .addVariant("sky_stone_plank_connected", props, CONNECTED)
                .addVariant("sky_stone_frame", props)
                .addVariant("sky_stone_panel_1", props)
                .addVariant("sky_stone_panel_2", props)
                .addVariant("sky_stone_panel_3", props)
                .addVariant("sky_stone_skull_creeper", props)
                .addVariant("sky_stone_skull_skeleton", props)
                .addVariant("sky_stone_stripes", props)
                .addVariant("sky_stone_stripes_encased", props, CONNECTED)
                .addVariant("sky_stone_chisel_1", props)
                .addVariant("sky_stone_chisel_2", props)
                .addVariant("sky_stone_chisel_3", props)
                .addVariant("sky_stone_chisel_4", props)
                .addVariant("sky_stone_chisel_5", props)
                .addVariant("sky_stone_chisel_6", props)
                .addVariant("sky_stone_facet", props)
                .addVariant("sky_stone_facet_small", props)
                .addVariant("sky_stone_facet_small_encased", props, CONNECTED)
                .addVariant("sky_stone_shiny", props)
                .addVariant("sky_stone_gem", props)
                .addVariant("sky_stone_gem_1", props)
                .addVariant("sky_stone_gem_2", props)
                .addVariant("sky_stone_gem_3", props)
                .addVariant("sky_stone_bricks_square", props)
                .addVariant("sky_stone_slab", props)
                .addVariant("sky_stone_scaffold", props)
                .addVariant("sky_stone_scaffold_encased", props, CONNECTED)
                .addVariant("sky_stone_tiles_inlayed", props)
                .addVariant("sky_stone_waves", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("sky_stone_array"), "Sky Stone", "Array");
        lang.addBlock(getVariant("sky_stone_border_square"), "Sky Stone", "Square Border");
        lang.addBlock(getVariant("sky_stone_braid"), "Sky Stone", "Braid");
        lang.addBlock(getVariant("sky_stone_bricks_cracked"), "Sky Stone", "Cracked Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_encased"), "Sky Stone", "Encased Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_indent"), "Sky Stone", "Indent Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_inlayed"), "Sky Stone", "Inlayed Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_large"), "Sky Stone", "Large Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_small"), "Sky Stone", "Small Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_soft"), "Sky Stone", "Soft Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_solid"), "Sky Stone", "Solid Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_triple"), "Sky Stone", "Triple Bricks");
        lang.addBlock(getVariant("sky_stone_bricks_vertical"), "Sky Stone", "Vertical Bricks");
        lang.addBlock(getVariant("sky_stone_chaotic"), "Sky Stone", "Chaotic");
        lang.addBlock(getVariant("sky_stone_chaotic_medium"), "Sky Stone", "Chaotic Medium");
        lang.addBlock(getVariant("sky_stone_chaotic_small"), "Sky Stone", "Chaotic Small");
        lang.addBlock(getVariant("sky_stone_checker"), "Sky Stone", "Checker");
        lang.addBlock(getVariant("sky_stone_checker_small"), "Sky Stone", "Small Checker");
        lang.addBlock(getVariant("sky_stone_circular"), "Sky Stone", "Circular");
        lang.addBlock(getVariant("sky_stone_cobble"), "Sky Stone", "Cobble");
        lang.addBlock(getVariant("sky_stone_cuts"), "Sky Stone", "Cuts");
        lang.addBlock(getVariant("sky_stone_dent"), "Sky Stone", "Dent");
        lang.addBlock(getVariant("sky_stone_french_1"), "Sky Stone", "French 1");
        lang.addBlock(getVariant("sky_stone_french_2"), "Sky Stone", "French 2");
        lang.addBlock(getVariant("sky_stone_indent"), "Sky Stone", "Indent");
        lang.addBlock(getVariant("sky_stone_jellybean"), "Sky Stone", "Jellybean");
        lang.addBlock(getVariant("sky_stone_layers"), "Sky Stone", "Layers");
        lang.addBlock(getVariant("sky_stone_line_horizontal"), "Sky Stone", "Horizontal Line");
        lang.addBlock(getVariant("sky_stone_line_vertical"), "Sky Stone", "Vertical Line");
        lang.addBlock(getVariant("sky_stone_meander_horizontal"), "Sky Stone", "Horizontal Meander");
        lang.addBlock(getVariant("sky_stone_meander_vertical"), "Sky Stone", "Vertical Meander");
        lang.addBlock(getVariant("sky_stone_mosaic"), "Sky Stone", "Mosaic");
        lang.addBlock(getVariant("sky_stone_ornate_small"), "Sky Stone", "Small Ornate");
        lang.addBlock(getVariant("sky_stone_panel"), "Sky Stone", "Panel");
        lang.addBlock(getVariant("sky_stone_pillar"), "Sky Stone", "Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_basic"), "Sky Stone", "Basic Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_basic_dent"), "Sky Stone", "Basic Dent Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_basic_plain"), "Sky Stone", "Basic Plain Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_basic_round"), "Sky Stone", "Basic Round Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_basic_spiral"), "Sky Stone", "Basic Spiral Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_classic"), "Sky Stone", "Classic Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_classic_large"), "Sky Stone", "Large Classic Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_ionic"), "Sky Stone", "Ionic Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_ionic_dent"), "Sky Stone", "Ionic Dent Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_ionic_plain"), "Sky Stone", "Ionic Plain Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_ionic_round"), "Sky Stone", "Ionic Round Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_ionic_spiral"), "Sky Stone", "Ionic Spiral Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_large_basic_triple"), "Sky Stone", "Large Basic Triple Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_large_ionic_triple"), "Sky Stone", "Large Ionic Triple Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_meander"), "Sky Stone", "Meander Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_meander_dent"), "Sky Stone", "Meander Dent Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_meander_plain"), "Sky Stone", "Meander Plain Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_meander_round"), "Sky Stone", "Meander Round Pillar");
        lang.addBlock(getVariant("sky_stone_pillar_meander_spiral"), "Sky Stone", "Meander Spiral Pillar");
        lang.addBlock(getVariant("sky_stone_plate"), "Sky Stone", "Plate");
        lang.addBlock(getVariant("sky_stone_polished"), "Sky Stone", "Polished");
        lang.addBlock(getVariant("sky_stone_prism"), "Sky Stone", "Prismatic");
        lang.addBlock(getVariant("sky_stone_raw"), "Sky Stone", "Raw");
        lang.addBlock(getVariant("sky_stone_road"), "Sky Stone", "Road");
        lang.addBlock(getVariant("sky_stone_slanted"), "Sky Stone", "Slanted");
        lang.addBlock(getVariant("sky_stone_tiles"), "Sky Stone", "Tiles");
        lang.addBlock(getVariant("sky_stone_tiles_large"), "Sky Stone", "Large Tiles");
        lang.addBlock(getVariant("sky_stone_tiles_small"), "Sky Stone", "Small Tiles");
        lang.addBlock(getVariant("sky_stone_twisted"), "Sky Stone", "Twisted");
        lang.addBlock(getVariant("sky_stone_weaver"), "Sky Stone", "Weaver");
        lang.addBlock(getVariant("sky_stone_zag"), "Sky Stone", "Zag");
        lang.addBlock(getVariant("sky_stone_crate"), "Sky Stone", "Crate");
        lang.addBlock(getVariant("sky_stone_herringbone"), "Sky Stone", "Herringbone");
        lang.addBlock(getVariant("sky_stone_herringbone_encased"), "Sky Stone", "Encased Herringbone");
        lang.addBlock(getVariant("sky_stone_medallion"), "Sky Stone", "Medallion");
        lang.addBlock(getVariant("sky_stone_medallion_encased"), "Sky Stone", "Encased Medallion");
        lang.addBlock(getVariant("sky_stone_dots"), "Sky Stone", "Dots");
        lang.addBlock(getVariant("sky_stone_dots_encased"), "Sky Stone", "Encased Dots");
        lang.addBlock(getVariant("sky_stone_heart"), "Sky Stone", "Heart");
        lang.addBlock(getVariant("sky_stone_star"), "Sky Stone", "Star");
        lang.addBlock(getVariant("sky_stone_plating"), "Sky Stone", "Plating");
        lang.addBlock(getVariant("sky_stone_lodestone"), "Sky Stone", "Lodestone");
        lang.addBlock(getVariant("sky_stone_plank"), "Sky Stone", "Plank");
        lang.addBlock(getVariant("sky_stone_plank_connected"), "Sky Stone", "Plank Connected");
        lang.addBlock(getVariant("sky_stone_frame"), "Sky Stone", "Frame");
        lang.addBlock(getVariant("sky_stone_panel_1"), "Sky Stone", "Panel 1");
        lang.addBlock(getVariant("sky_stone_panel_2"), "Sky Stone", "Panel 2");
        lang.addBlock(getVariant("sky_stone_panel_3"), "Sky Stone", "Panel 3");
        lang.addBlock(getVariant("sky_stone_skull_creeper"), "Sky Stone", "Creeper Skull");
        lang.addBlock(getVariant("sky_stone_skull_skeleton"), "Sky Stone", "Skeleton Skull");
        lang.addBlock(getVariant("sky_stone_stripes"), "Sky Stone", "Stripes");
        lang.addBlock(getVariant("sky_stone_stripes_encased"), "Sky Stone", "Encased Stripes");
        lang.addBlock(getVariant("sky_stone_chisel_1"), "Sky Stone", "Chisel 1");
        lang.addBlock(getVariant("sky_stone_chisel_2"), "Sky Stone", "Chisel 2");
        lang.addBlock(getVariant("sky_stone_chisel_3"), "Sky Stone", "Chisel 3");
        lang.addBlock(getVariant("sky_stone_chisel_4"), "Sky Stone", "Chisel 4");
        lang.addBlock(getVariant("sky_stone_chisel_5"), "Sky Stone", "Chisel 5");
        lang.addBlock(getVariant("sky_stone_chisel_6"), "Sky Stone", "Chisel 6");
        lang.addBlock(getVariant("sky_stone_facet"), "Sky Stone", "Facet");
        lang.addBlock(getVariant("sky_stone_facet_small"), "Sky Stone", "Small Facet");
        lang.addBlock(getVariant("sky_stone_facet_small_encased"), "Sky Stone", "Encased Small Facet");
        lang.addBlock(getVariant("sky_stone_shiny"), "Sky Stone", "Shiny");
        lang.addBlock(getVariant("sky_stone_gem"), "Sky Stone", "Gem");
        lang.addBlock(getVariant("sky_stone_gem_1"), "Sky Stone", "Gem 1");
        lang.addBlock(getVariant("sky_stone_gem_2"), "Sky Stone", "Gem 2");
        lang.addBlock(getVariant("sky_stone_gem_3"), "Sky Stone", "Gem 3");
        lang.addBlock(getVariant("sky_stone_bricks_square"), "Sky Stone", "Square Bricks");
        lang.addBlock(getVariant("sky_stone_slab"), "Sky Stone", "Slab");
        lang.addBlock(getVariant("sky_stone_scaffold"), "Sky Stone", "Scaffold");
        lang.addBlock(getVariant("sky_stone_scaffold_encased"), "Sky Stone", "Encased Scaffold");
        lang.addBlock(getVariant("sky_stone_tiles_inlayed"), "Sky Stone", "Inlayed Tiles");
        lang.addBlock(getVariant("sky_stone_waves"), "Sky Stone", "Waves");
    }
}

