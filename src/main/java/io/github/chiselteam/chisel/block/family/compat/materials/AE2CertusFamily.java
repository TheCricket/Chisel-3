package io.github.chiselteam.chisel.block.family.compat.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class AE2CertusFamily extends ChiselFamily {
    public AE2CertusFamily(BlockBehaviour.Properties props) {
        family = builder("ae2_certus")
                .addVariant("certus_array", props, MULTIBLOCK_2X2)
                .addVariant("certus_braid", props)
                .addVariant("certus_bricks_indent", props)
                .addVariant("certus_bricks_inlayed", props)
                .addVariant("certus_bricks_large", props, MULTIBLOCK_2X2)
                .addVariant("certus_bricks_vertical", props)
                .addVariant("certus_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("certus_chaotic_medium", props)
                .addVariant("certus_chaotic_small", props)
                .addVariant("certus_checker", props)
                .addVariant("certus_checker_small", props)
                .addVariant("certus_circular", props, CONNECTED)
                .addVariant("certus_cobble", props)
                .addVariant("certus_bricks_cracked", props)
                .addVariant("certus_cuts", props, MULTIBLOCK_4X4)
                .addVariant("certus_dent", props, CONNECTED)
                .addVariant("certus_bricks_encased", props, CONNECTED)
                .addVariant("certus_french_1", props)
                .addVariant("certus_french_2", props)
                .addVariant("certus_indent", props, CONNECTED)
                .addVariant("certus_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("certus_layers", props)
                .addVariant("certus_line_horizontal", props)
                .addVariant("certus_line_vertical", props)
                .addVariant("certus_meander_horizontal", props, CTMH)
                .addVariant("certus_meander_vertical", props, CTMV)
                .addVariant("certus_mosaic", props, CONNECTED)
                .addVariant("certus_ornate_small", props)
                .addVariant("certus_panel", props)
                .addVariant("certus_pillar", props, TBS)
                .addVariant("certus_pillar_basic", props, CTMV)
                .addVariant("certus_pillar_basic_dent", props, CTMV)
                .addVariant("certus_pillar_basic_plain", props, CTMV)
                .addVariant("certus_pillar_basic_round", props, CTMV)
                .addVariant("certus_pillar_basic_spiral", props, CTMV)
                .addVariant("certus_pillar_classic", props, TBS)
                .addVariant("certus_pillar_classic_large", props, TBS)
                .addVariant("certus_pillar_ionic", props, CTMV)
                .addVariant("certus_pillar_ionic_dent", props, CTMV)
                .addVariant("certus_pillar_ionic_plain", props, CTMV)
                .addVariant("certus_pillar_ionic_round", props, CTMV)
                .addVariant("certus_pillar_ionic_spiral", props, CTMV)
                .addVariant("certus_pillar_large_basic_triple", props, CTMV)
                .addVariant("certus_pillar_large_ionic_triple", props, CTMV)
                .addVariant("certus_pillar_meander", props, CTMV)
                .addVariant("certus_pillar_meander_dent", props, CTMV)
                .addVariant("certus_pillar_meander_plain", props, CTMV)
                .addVariant("certus_pillar_meander_round", props, CTMV)
                .addVariant("certus_pillar_meander_spiral", props, CTMV)
                .addVariant("certus_plate", props, CONNECTED)
                .addVariant("certus_polished", props)
                .addVariant("certus_prism", props)
                .addVariant("certus_raw", props)
                .addVariant("certus_road", props)
                .addVariant("certus_slanted", props, MULTIBLOCK_2X2)
                .addVariant("certus_bricks_small", props)
                .addVariant("certus_bricks_soft", props)
                .addVariant("certus_bricks_solid", props)
                .addVariant("certus_border_square", props, CONNECTED)
                .addVariant("certus_tiles_large", props, CONNECTED)
                .addVariant("certus_tiles", props)
                .addVariant("certus_tiles_small", props)
                .addVariant("certus_bricks_triple", props)
                .addVariant("certus_twisted", props, TBS)
                .addVariant("certus_weaver", props, CONNECTED)
                .addVariant("certus_zag", props, MULTIBLOCK_2X2)
                .addVariant("certus_crate", props, CONNECTED)
                .addVariant("certus_herringbone", props)
                .addVariant("certus_herringbone_encased", props, CONNECTED)
                .addVariant("certus_medallion", props)
                .addVariant("certus_medallion_encased", props, CONNECTED)
                .addVariant("certus_dots", props)
                .addVariant("certus_dots_encased", props, CONNECTED)
                .addVariant("certus_heart", props)
                .addVariant("certus_star", props)
                .addVariant("certus_plating", props)
                .addVariant("certus_lodestone", props)
                .addVariant("certus_plank", props)
                .addVariant("certus_plank_connected", props, CONNECTED)
                .addVariant("certus_frame", props)
                .addVariant("certus_panel_1", props)
                .addVariant("certus_panel_2", props)
                .addVariant("certus_panel_3", props)
                .addVariant("certus_skull_creeper", props)
                .addVariant("certus_skull_skeleton", props)
                .addVariant("certus_stripes", props)
                .addVariant("certus_stripes_encased", props, CONNECTED)
                .addVariant("certus_chisel_1", props)
                .addVariant("certus_chisel_2", props)
                .addVariant("certus_chisel_3", props)
                .addVariant("certus_chisel_4", props)
                .addVariant("certus_chisel_5", props)
                .addVariant("certus_chisel_6", props)
                .addVariant("certus_facet", props)
                .addVariant("certus_facet_small", props)
                .addVariant("certus_facet_small_encased", props, CONNECTED)
                .addVariant("certus_shiny", props)
                .addVariant("certus_gem", props)
                .addVariant("certus_gem_1", props)
                .addVariant("certus_gem_2", props)
                .addVariant("certus_gem_3", props)
                .addVariant("certus_bricks_square", props)
                .addVariant("certus_slab", props)
                .addVariant("certus_scaffold", props)
                .addVariant("certus_scaffold_encased", props, CONNECTED)
                .addVariant("certus_tiles_inlayed", props)
                .addVariant("certus_waves", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("certus_array"), "Certus Quartz", "Array");
        lang.addBlock(getVariant("certus_border_square"), "Certus Quartz", "Square Border");
        lang.addBlock(getVariant("certus_braid"), "Certus Quartz", "Braid");
        lang.addBlock(getVariant("certus_bricks_cracked"), "Certus Quartz", "Cracked Bricks");
        lang.addBlock(getVariant("certus_bricks_encased"), "Certus Quartz", "Encased Bricks");
        lang.addBlock(getVariant("certus_bricks_indent"), "Certus Quartz", "Indent Bricks");
        lang.addBlock(getVariant("certus_bricks_inlayed"), "Certus Quartz", "Inlayed Bricks");
        lang.addBlock(getVariant("certus_bricks_large"), "Certus Quartz", "Large Bricks");
        lang.addBlock(getVariant("certus_bricks_small"), "Certus Quartz", "Small Bricks");
        lang.addBlock(getVariant("certus_bricks_soft"), "Certus Quartz", "Soft Bricks");
        lang.addBlock(getVariant("certus_bricks_solid"), "Certus Quartz", "Solid Bricks");
        lang.addBlock(getVariant("certus_bricks_triple"), "Certus Quartz", "Triple Bricks");
        lang.addBlock(getVariant("certus_bricks_vertical"), "Certus Quartz", "Vertical Bricks");
        lang.addBlock(getVariant("certus_chaotic"), "Certus Quartz", "Chaotic");
        lang.addBlock(getVariant("certus_chaotic_medium"), "Certus Quartz", "Chaotic Medium");
        lang.addBlock(getVariant("certus_chaotic_small"), "Certus Quartz", "Chaotic Small");
        lang.addBlock(getVariant("certus_checker"), "Certus Quartz", "Checker");
        lang.addBlock(getVariant("certus_checker_small"), "Certus Quartz", "Small Checker");
        lang.addBlock(getVariant("certus_circular"), "Certus Quartz", "Circular");
        lang.addBlock(getVariant("certus_cobble"), "Certus Quartz", "Cobble");
        lang.addBlock(getVariant("certus_cuts"), "Certus Quartz", "Cuts");
        lang.addBlock(getVariant("certus_dent"), "Certus Quartz", "Dent");
        lang.addBlock(getVariant("certus_french_1"), "Certus Quartz", "French 1");
        lang.addBlock(getVariant("certus_french_2"), "Certus Quartz", "French 2");
        lang.addBlock(getVariant("certus_indent"), "Certus Quartz", "Indent");
        lang.addBlock(getVariant("certus_jellybean"), "Certus Quartz", "Jellybean");
        lang.addBlock(getVariant("certus_layers"), "Certus Quartz", "Layers");
        lang.addBlock(getVariant("certus_line_horizontal"), "Certus Quartz", "Horizontal Line");
        lang.addBlock(getVariant("certus_line_vertical"), "Certus Quartz", "Vertical Line");
        lang.addBlock(getVariant("certus_meander_horizontal"), "Certus Quartz", "Horizontal Meander");
        lang.addBlock(getVariant("certus_meander_vertical"), "Certus Quartz", "Vertical Meander");
        lang.addBlock(getVariant("certus_mosaic"), "Certus Quartz", "Mosaic");
        lang.addBlock(getVariant("certus_ornate_small"), "Certus Quartz", "Small Ornate");
        lang.addBlock(getVariant("certus_panel"), "Certus Quartz", "Panel");
        lang.addBlock(getVariant("certus_pillar"), "Certus Quartz", "Pillar");
        lang.addBlock(getVariant("certus_pillar_basic"), "Certus Quartz", "Basic Pillar");
        lang.addBlock(getVariant("certus_pillar_basic_dent"), "Certus Quartz", "Basic Dent Pillar");
        lang.addBlock(getVariant("certus_pillar_basic_plain"), "Certus Quartz", "Basic Plain Pillar");
        lang.addBlock(getVariant("certus_pillar_basic_round"), "Certus Quartz", "Basic Round Pillar");
        lang.addBlock(getVariant("certus_pillar_basic_spiral"), "Certus Quartz", "Basic Spiral Pillar");
        lang.addBlock(getVariant("certus_pillar_classic"), "Certus Quartz", "Classic Pillar");
        lang.addBlock(getVariant("certus_pillar_classic_large"), "Certus Quartz", "Large Classic Pillar");
        lang.addBlock(getVariant("certus_pillar_ionic"), "Certus Quartz", "Ionic Pillar");
        lang.addBlock(getVariant("certus_pillar_ionic_dent"), "Certus Quartz", "Ionic Dent Pillar");
        lang.addBlock(getVariant("certus_pillar_ionic_plain"), "Certus Quartz", "Ionic Plain Pillar");
        lang.addBlock(getVariant("certus_pillar_ionic_round"), "Certus Quartz", "Ionic Round Pillar");
        lang.addBlock(getVariant("certus_pillar_ionic_spiral"), "Certus Quartz", "Ionic Spiral Pillar");
        lang.addBlock(getVariant("certus_pillar_large_basic_triple"), "Certus Quartz", "Large Basic Triple Pillar");
        lang.addBlock(getVariant("certus_pillar_large_ionic_triple"), "Certus Quartz", "Large Ionic Triple Pillar");
        lang.addBlock(getVariant("certus_pillar_meander"), "Certus Quartz", "Meander Pillar");
        lang.addBlock(getVariant("certus_pillar_meander_dent"), "Certus Quartz", "Meander Dent Pillar");
        lang.addBlock(getVariant("certus_pillar_meander_plain"), "Certus Quartz", "Meander Plain Pillar");
        lang.addBlock(getVariant("certus_pillar_meander_round"), "Certus Quartz", "Meander Round Pillar");
        lang.addBlock(getVariant("certus_pillar_meander_spiral"), "Certus Quartz", "Meander Spiral Pillar");
        lang.addBlock(getVariant("certus_plate"), "Certus Quartz", "Plate");
        lang.addBlock(getVariant("certus_polished"), "Certus Quartz", "Polished");
        lang.addBlock(getVariant("certus_prism"), "Certus Quartz", "Prismatic");
        lang.addBlock(getVariant("certus_raw"), "Certus Quartz", "Raw");
        lang.addBlock(getVariant("certus_road"), "Certus Quartz", "Road");
        lang.addBlock(getVariant("certus_slanted"), "Certus Quartz", "Slanted");
        lang.addBlock(getVariant("certus_tiles"), "Certus Quartz", "Tiles");
        lang.addBlock(getVariant("certus_tiles_large"), "Certus Quartz", "Large Tiles");
        lang.addBlock(getVariant("certus_tiles_small"), "Certus Quartz", "Small Tiles");
        lang.addBlock(getVariant("certus_twisted"), "Certus Quartz", "Twisted");
        lang.addBlock(getVariant("certus_weaver"), "Certus Quartz", "Weaver");
        lang.addBlock(getVariant("certus_zag"), "Certus Quartz", "Zag");
        lang.addBlock(getVariant("certus_crate"), "Certus Quartz", "Crate");
        lang.addBlock(getVariant("certus_herringbone"), "Certus Quartz", "Herringbone");
        lang.addBlock(getVariant("certus_herringbone_encased"), "Certus Quartz", "Encased Herringbone");
        lang.addBlock(getVariant("certus_medallion"), "Certus Quartz", "Medallion");
        lang.addBlock(getVariant("certus_medallion_encased"), "Certus Quartz", "Encased Medallion");
        lang.addBlock(getVariant("certus_dots"), "Certus Quartz", "Dots");
        lang.addBlock(getVariant("certus_dots_encased"), "Certus Quartz", "Encased Dots");
        lang.addBlock(getVariant("certus_heart"), "Certus Quartz", "Heart");
        lang.addBlock(getVariant("certus_star"), "Certus Quartz", "Star");
        lang.addBlock(getVariant("certus_plating"), "Certus Quartz", "Plating");
        lang.addBlock(getVariant("certus_lodestone"), "Certus Quartz", "Lodestone");
        lang.addBlock(getVariant("certus_plank"), "Certus Quartz", "Plank");
        lang.addBlock(getVariant("certus_plank_connected"), "Certus Quartz", "Plank Connected");
        lang.addBlock(getVariant("certus_frame"), "Certus Quartz", "Frame");
        lang.addBlock(getVariant("certus_panel_1"), "Certus Quartz", "Panel 1");
        lang.addBlock(getVariant("certus_panel_2"), "Certus Quartz", "Panel 2");
        lang.addBlock(getVariant("certus_panel_3"), "Certus Quartz", "Panel 3");
        lang.addBlock(getVariant("certus_skull_creeper"), "Certus Quartz", "Creeper Skull");
        lang.addBlock(getVariant("certus_skull_skeleton"), "Certus Quartz", "Skeleton Skull");
        lang.addBlock(getVariant("certus_stripes"), "Certus Quartz", "Stripes");
        lang.addBlock(getVariant("certus_stripes_encased"), "Certus Quartz", "Encased Stripes");
        lang.addBlock(getVariant("certus_chisel_1"), "Certus Quartz", "Chisel 1");
        lang.addBlock(getVariant("certus_chisel_2"), "Certus Quartz", "Chisel 2");
        lang.addBlock(getVariant("certus_chisel_3"), "Certus Quartz", "Chisel 3");
        lang.addBlock(getVariant("certus_chisel_4"), "Certus Quartz", "Chisel 4");
        lang.addBlock(getVariant("certus_chisel_5"), "Certus Quartz", "Chisel 5");
        lang.addBlock(getVariant("certus_chisel_6"), "Certus Quartz", "Chisel 6");
        lang.addBlock(getVariant("certus_facet"), "Certus Quartz", "Facet");
        lang.addBlock(getVariant("certus_facet_small"), "Certus Quartz", "Small Facet");
        lang.addBlock(getVariant("certus_facet_small_encased"), "Certus Quartz", "Encased Small Facet");
        lang.addBlock(getVariant("certus_shiny"), "Certus Quartz", "Shiny");
        lang.addBlock(getVariant("certus_gem"), "Certus Quartz", "Gem");
        lang.addBlock(getVariant("certus_gem_1"), "Certus Quartz", "Gem 1");
        lang.addBlock(getVariant("certus_gem_2"), "Certus Quartz", "Gem 2");
        lang.addBlock(getVariant("certus_gem_3"), "Certus Quartz", "Gem 3");
        lang.addBlock(getVariant("certus_bricks_square"), "Certus Quartz", "Square Bricks");
        lang.addBlock(getVariant("certus_slab"), "Certus Quartz", "Slab");
        lang.addBlock(getVariant("certus_scaffold"), "Certus Quartz", "Scaffold");
        lang.addBlock(getVariant("certus_scaffold_encased"), "Certus Quartz", "Encased Scaffold");
        lang.addBlock(getVariant("certus_tiles_inlayed"), "Certus Quartz", "Inlayed Tiles");
        lang.addBlock(getVariant("certus_waves"), "Certus Quartz", "Waves");
    }
}

