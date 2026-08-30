package io.github.chiselteam.chisel.block.family.compat.materials;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class AE2Certus2Family extends ChiselFamily {
    public AE2Certus2Family(BlockBehaviour.Properties props) {
        family = builder("ae2_certus2")
                .addVariant("certus2_array", props, MULTIBLOCK_2X2)
                .addVariant("certus2_braid", props)
                .addVariant("certus2_bricks_indent", props)
                .addVariant("certus2_bricks_inlayed", props)
                .addVariant("certus2_bricks_large", props, MULTIBLOCK_2X2)
                .addVariant("certus2_bricks_vertical", props)
                .addVariant("certus2_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("certus2_chaotic_medium", props)
                .addVariant("certus2_chaotic_small", props)
                .addVariant("certus2_checker", props)
                .addVariant("certus2_checker_small", props)
                .addVariant("certus2_circular", props, CONNECTED)
                .addVariant("certus2_cobble", props)
                .addVariant("certus2_bricks_cracked", props)
                .addVariant("certus2_cuts", props, MULTIBLOCK_4X4)
                .addVariant("certus2_dent", props, CONNECTED)
                .addVariant("certus2_bricks_encased", props, CONNECTED)
                .addVariant("certus2_french_1", props)
                .addVariant("certus2_french_2", props)
                .addVariant("certus2_indent", props, CONNECTED)
                .addVariant("certus2_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("certus2_layers", props)
                .addVariant("certus2_line_horizontal", props)
                .addVariant("certus2_line_vertical", props)
                .addVariant("certus2_meander_horizontal", props, CTMH)
                .addVariant("certus2_meander_vertical", props, CTMV)
                .addVariant("certus2_mosaic", props, CONNECTED)
                .addVariant("certus2_ornate_small", props)
                .addVariant("certus2_panel", props)
                .addVariant("certus2_pillar", props, TBS)
                .addVariant("certus2_pillar_basic", props, CTMV)
                .addVariant("certus2_pillar_basic_dent", props, CTMV)
                .addVariant("certus2_pillar_basic_plain", props, CTMV)
                .addVariant("certus2_pillar_basic_round", props, CTMV)
                .addVariant("certus2_pillar_basic_spiral", props, CTMV)
                .addVariant("certus2_pillar_classic", props, TBS)
                .addVariant("certus2_pillar_classic_large", props, TBS)
                .addVariant("certus2_pillar_ionic", props, CTMV)
                .addVariant("certus2_pillar_ionic_dent", props, CTMV)
                .addVariant("certus2_pillar_ionic_plain", props, CTMV)
                .addVariant("certus2_pillar_ionic_round", props, CTMV)
                .addVariant("certus2_pillar_ionic_spiral", props, CTMV)
                .addVariant("certus2_pillar_large_basic_triple", props, CTMV)
                .addVariant("certus2_pillar_large_ionic_triple", props, CTMV)
                .addVariant("certus2_pillar_meander", props, CTMV)
                .addVariant("certus2_pillar_meander_dent", props, CTMV)
                .addVariant("certus2_pillar_meander_plain", props, CTMV)
                .addVariant("certus2_pillar_meander_round", props, CTMV)
                .addVariant("certus2_pillar_meander_spiral", props, CTMV)
                .addVariant("certus2_plate", props, CONNECTED)
                .addVariant("certus2_polished", props)
                .addVariant("certus2_prism", props)
                .addVariant("certus2_raw", props)
                .addVariant("certus2_road", props)
                .addVariant("certus2_slanted", props, MULTIBLOCK_2X2)
                .addVariant("certus2_bricks_small", props)
                .addVariant("certus2_bricks_soft", props)
                .addVariant("certus2_bricks_solid", props)
                .addVariant("certus2_border_square", props, CONNECTED)
                .addVariant("certus2_tiles_large", props, CONNECTED)
                .addVariant("certus2_tiles", props)
                .addVariant("certus2_tiles_small", props)
                .addVariant("certus2_bricks_triple", props)
                .addVariant("certus2_twisted", props, TBS)
                .addVariant("certus2_weaver", props, CONNECTED)
                .addVariant("certus2_zag", props, MULTIBLOCK_2X2)
                .addVariant("certus2_crate", props, CONNECTED)
                .addVariant("certus2_herringbone", props)
                .addVariant("certus2_medallion", props)
                .addVariant("certus2_dots", props)
                .addVariant("certus2_heart", props)
                .addVariant("certus2_star", props)
                .addVariant("certus2_plating", props)
                .addVariant("certus2_lodestone", props)
                .addVariant("certus2_plank", props)
                .addVariant("certus2_plank_connected", props, CONNECTED)
                .addVariant("certus2_frame", props)
                .addVariant("certus2_panel_1", props)
                .addVariant("certus2_panel_2", props)
                .addVariant("certus2_panel_3", props)
                .addVariant("certus2_skull_creeper", props)
                .addVariant("certus2_skull_skeleton", props)
                .addVariant("certus2_stripes", props)
                .addVariant("certus2_chisel_1", props)
                .addVariant("certus2_chisel_2", props)
                .addVariant("certus2_chisel_3", props)
                .addVariant("certus2_chisel_4", props)
                .addVariant("certus2_chisel_5", props)
                .addVariant("certus2_chisel_6", props)
                .addVariant("certus2_facet", props)
                .addVariant("certus2_facet_small", props)
                .addVariant("certus2_shiny", props)
                .addVariant("certus2_gem", props)
                .addVariant("certus2_gem_1", props)
                .addVariant("certus2_gem_2", props)
                .addVariant("certus2_gem_3", props)
                .addVariant("certus2_bricks_square", props)
                .addVariant("certus2_slab", props)
                .addVariant("certus2_scaffold", props)
                .addVariant("certus2_tiles_inlayed", props)
                .addVariant("certus2_waves", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("certus2_array"), "Certus Quartz", "Array");
        lang.addBlock(getVariant("certus2_border_square"), "Certus Quartz", "Square Border");
        lang.addBlock(getVariant("certus2_braid"), "Certus Quartz", "Braid");
        lang.addBlock(getVariant("certus2_bricks_cracked"), "Certus Quartz", "Cracked Bricks");
        lang.addBlock(getVariant("certus2_bricks_encased"), "Certus Quartz", "Encased Bricks");
        lang.addBlock(getVariant("certus2_bricks_indent"), "Certus Quartz", "Indent Bricks");
        lang.addBlock(getVariant("certus2_bricks_inlayed"), "Certus Quartz", "Inlayed Bricks");
        lang.addBlock(getVariant("certus2_bricks_large"), "Certus Quartz", "Large Bricks");
        lang.addBlock(getVariant("certus2_bricks_small"), "Certus Quartz", "Small Bricks");
        lang.addBlock(getVariant("certus2_bricks_soft"), "Certus Quartz", "Soft Bricks");
        lang.addBlock(getVariant("certus2_bricks_solid"), "Certus Quartz", "Solid Bricks");
        lang.addBlock(getVariant("certus2_bricks_triple"), "Certus Quartz", "Triple Bricks");
        lang.addBlock(getVariant("certus2_bricks_vertical"), "Certus Quartz", "Vertical Bricks");
        lang.addBlock(getVariant("certus2_chaotic"), "Certus Quartz", "Chaotic");
        lang.addBlock(getVariant("certus2_chaotic_medium"), "Certus Quartz", "Chaotic Medium");
        lang.addBlock(getVariant("certus2_chaotic_small"), "Certus Quartz", "Chaotic Small");
        lang.addBlock(getVariant("certus2_checker"), "Certus Quartz", "Checker");
        lang.addBlock(getVariant("certus2_checker_small"), "Certus Quartz", "Small Checker");
        lang.addBlock(getVariant("certus2_circular"), "Certus Quartz", "Circular");
        lang.addBlock(getVariant("certus2_cobble"), "Certus Quartz", "Cobble");
        lang.addBlock(getVariant("certus2_cuts"), "Certus Quartz", "Cuts");
        lang.addBlock(getVariant("certus2_dent"), "Certus Quartz", "Dent");
        lang.addBlock(getVariant("certus2_french_1"), "Certus Quartz", "French 1");
        lang.addBlock(getVariant("certus2_french_2"), "Certus Quartz", "French 2");
        lang.addBlock(getVariant("certus2_indent"), "Certus Quartz", "Indent");
        lang.addBlock(getVariant("certus2_jellybean"), "Certus Quartz", "Jellybean");
        lang.addBlock(getVariant("certus2_layers"), "Certus Quartz", "Layers");
        lang.addBlock(getVariant("certus2_line_horizontal"), "Certus Quartz", "Horizontal Line");
        lang.addBlock(getVariant("certus2_line_vertical"), "Certus Quartz", "Vertical Line");
        lang.addBlock(getVariant("certus2_meander_horizontal"), "Certus Quartz", "Horizontal Meander");
        lang.addBlock(getVariant("certus2_meander_vertical"), "Certus Quartz", "Vertical Meander");
        lang.addBlock(getVariant("certus2_mosaic"), "Certus Quartz", "Mosaic");
        lang.addBlock(getVariant("certus2_ornate_small"), "Certus Quartz", "Small Ornate");
        lang.addBlock(getVariant("certus2_panel"), "Certus Quartz", "Panel");
        lang.addBlock(getVariant("certus2_pillar"), "Certus Quartz", "Pillar");
        lang.addBlock(getVariant("certus2_pillar_basic"), "Certus Quartz", "Basic Pillar");
        lang.addBlock(getVariant("certus2_pillar_basic_dent"), "Certus Quartz", "Basic Dent Pillar");
        lang.addBlock(getVariant("certus2_pillar_basic_plain"), "Certus Quartz", "Basic Plain Pillar");
        lang.addBlock(getVariant("certus2_pillar_basic_round"), "Certus Quartz", "Basic Round Pillar");
        lang.addBlock(getVariant("certus2_pillar_basic_spiral"), "Certus Quartz", "Basic Spiral Pillar");
        lang.addBlock(getVariant("certus2_pillar_classic"), "Certus Quartz", "Classic Pillar");
        lang.addBlock(getVariant("certus2_pillar_classic_large"), "Certus Quartz", "Large Classic Pillar");
        lang.addBlock(getVariant("certus2_pillar_ionic"), "Certus Quartz", "Ionic Pillar");
        lang.addBlock(getVariant("certus2_pillar_ionic_dent"), "Certus Quartz", "Ionic Dent Pillar");
        lang.addBlock(getVariant("certus2_pillar_ionic_plain"), "Certus Quartz", "Ionic Plain Pillar");
        lang.addBlock(getVariant("certus2_pillar_ionic_round"), "Certus Quartz", "Ionic Round Pillar");
        lang.addBlock(getVariant("certus2_pillar_ionic_spiral"), "Certus Quartz", "Ionic Spiral Pillar");
        lang.addBlock(getVariant("certus2_pillar_large_basic_triple"), "Certus Quartz", "Large Basic Triple Pillar");
        lang.addBlock(getVariant("certus2_pillar_large_ionic_triple"), "Certus Quartz", "Large Ionic Triple Pillar");
        lang.addBlock(getVariant("certus2_pillar_meander"), "Certus Quartz", "Meander Pillar");
        lang.addBlock(getVariant("certus2_pillar_meander_dent"), "Certus Quartz", "Meander Dent Pillar");
        lang.addBlock(getVariant("certus2_pillar_meander_plain"), "Certus Quartz", "Meander Plain Pillar");
        lang.addBlock(getVariant("certus2_pillar_meander_round"), "Certus Quartz", "Meander Round Pillar");
        lang.addBlock(getVariant("certus2_pillar_meander_spiral"), "Certus Quartz", "Meander Spiral Pillar");
        lang.addBlock(getVariant("certus2_plate"), "Certus Quartz", "Plate");
        lang.addBlock(getVariant("certus2_polished"), "Certus Quartz", "Polished");
        lang.addBlock(getVariant("certus2_prism"), "Certus Quartz", "Prismatic");
        lang.addBlock(getVariant("certus2_raw"), "Certus Quartz", "Raw");
        lang.addBlock(getVariant("certus2_road"), "Certus Quartz", "Road");
        lang.addBlock(getVariant("certus2_slanted"), "Certus Quartz", "Slanted");
        lang.addBlock(getVariant("certus2_tiles"), "Certus Quartz", "Tiles");
        lang.addBlock(getVariant("certus2_tiles_large"), "Certus Quartz", "Large Tiles");
        lang.addBlock(getVariant("certus2_tiles_small"), "Certus Quartz", "Small Tiles");
        lang.addBlock(getVariant("certus2_twisted"), "Certus Quartz", "Twisted");
        lang.addBlock(getVariant("certus2_weaver"), "Certus Quartz", "Weaver");
        lang.addBlock(getVariant("certus2_zag"), "Certus Quartz", "Zag");
        lang.addBlock(getVariant("certus2_crate"), "Certus Quartz", "Crate");
        lang.addBlock(getVariant("certus2_herringbone"), "Certus Quartz", "Herringbone");
        lang.addBlock(getVariant("certus2_medallion"), "Certus Quartz", "Medallion");
        lang.addBlock(getVariant("certus2_dots"), "Certus Quartz", "Dots");
        lang.addBlock(getVariant("certus2_heart"), "Certus Quartz", "Heart");
        lang.addBlock(getVariant("certus2_star"), "Certus Quartz", "Star");
        lang.addBlock(getVariant("certus2_plating"), "Certus Quartz", "Plating");
        lang.addBlock(getVariant("certus2_lodestone"), "Certus Quartz", "Lodestone");
        lang.addBlock(getVariant("certus2_plank"), "Certus Quartz", "Plank");
        lang.addBlock(getVariant("certus2_plank_connected"), "Certus Quartz", "Plank Connected");
        lang.addBlock(getVariant("certus2_frame"), "Certus Quartz", "Frame");
        lang.addBlock(getVariant("certus2_panel_1"), "Certus Quartz", "Panel 1");
        lang.addBlock(getVariant("certus2_panel_2"), "Certus Quartz", "Panel 2");
        lang.addBlock(getVariant("certus2_panel_3"), "Certus Quartz", "Panel 3");
        lang.addBlock(getVariant("certus2_skull_creeper"), "Certus Quartz", "Creeper Skull");
        lang.addBlock(getVariant("certus2_skull_skeleton"), "Certus Quartz", "Skeleton Skull");
        lang.addBlock(getVariant("certus2_stripes"), "Certus Quartz", "Stripes");
        lang.addBlock(getVariant("certus2_chisel_1"), "Certus Quartz", "Chisel 1");
        lang.addBlock(getVariant("certus2_chisel_2"), "Certus Quartz", "Chisel 2");
        lang.addBlock(getVariant("certus2_chisel_3"), "Certus Quartz", "Chisel 3");
        lang.addBlock(getVariant("certus2_chisel_4"), "Certus Quartz", "Chisel 4");
        lang.addBlock(getVariant("certus2_chisel_5"), "Certus Quartz", "Chisel 5");
        lang.addBlock(getVariant("certus2_chisel_6"), "Certus Quartz", "Chisel 6");
        lang.addBlock(getVariant("certus2_facet"), "Certus Quartz", "Facet");
        lang.addBlock(getVariant("certus2_facet_small"), "Certus Quartz", "Small Facet");
        lang.addBlock(getVariant("certus2_shiny"), "Certus Quartz", "Shiny");
        lang.addBlock(getVariant("certus2_gem"), "Certus Quartz", "Gem");
        lang.addBlock(getVariant("certus2_gem_1"), "Certus Quartz", "Gem 1");
        lang.addBlock(getVariant("certus2_gem_2"), "Certus Quartz", "Gem 2");
        lang.addBlock(getVariant("certus2_gem_3"), "Certus Quartz", "Gem 3");
        lang.addBlock(getVariant("certus2_bricks_square"), "Certus Quartz", "Square Bricks");
        lang.addBlock(getVariant("certus2_slab"), "Certus Quartz", "Slab");
        lang.addBlock(getVariant("certus2_scaffold"), "Certus Quartz", "Scaffold");
        lang.addBlock(getVariant("certus2_tiles_inlayed"), "Certus Quartz", "Inlayed Tiles");
        lang.addBlock(getVariant("certus2_waves"), "Certus Quartz", "Waves");
    }
}

