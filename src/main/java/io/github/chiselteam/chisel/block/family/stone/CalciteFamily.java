package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CalciteFamily extends ChiselFamily {
    public CalciteFamily(BlockBehaviour.Properties props) {
        family = builder("calcite")
                .addVariant(Blocks.CALCITE)
                .addVariant("calcite_array", props, MULTIBLOCK_2X2)
                .addVariant("calcite_braid", props)
                .addVariant("calcite_bricks_indent", props)
                .addVariant("calcite_bricks_inlayed", props)
                .addVariant("calcite_bricks_large", props, MULTIBLOCK_2X2)
                .addVariant("calcite_bricks_vertical", props)
                .addVariant("calcite_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("calcite_chaotic_medium", props)
                .addVariant("calcite_chaotic_small", props)
                .addVariant("calcite_checker", props)
                .addVariant("calcite_checker_small", props)
                .addVariant("calcite_circular", props, CONNECTED)
                .addVariant("calcite_cobble", props)
                .addVariant("calcite_bricks_cracked", props)
                .addVariant("calcite_cuts", props, MULTIBLOCK_4X4)
                .addVariant("calcite_dent", props, CONNECTED)
                .addVariant("calcite_bricks_encased", props, CONNECTED)
                .addVariant("calcite_french_1", props)
                .addVariant("calcite_french_2", props)
                .addVariant("calcite_indent", props, CONNECTED)
                .addVariant("calcite_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("calcite_layers", props)
                .addVariant("calcite_line_horizontal", props)
                .addVariant("calcite_line_vertical", props)
                .addVariant("calcite_meander_horizontal", props, CTMH)
                .addVariant("calcite_meander_vertical", props, CTMV)
                .addVariant("calcite_mosaic", props, CONNECTED)
                .addVariant("calcite_ornate_small", props)
                .addVariant("calcite_panel", props)
                .addVariant("calcite_pillar", props, TBS)
                .addVariant("calcite_pillar_basic", props, CTMV)
                .addVariant("calcite_pillar_basic_dent", props, CTMV)
                .addVariant("calcite_pillar_basic_plain", props, CTMV)
                .addVariant("calcite_pillar_basic_round", props, CTMV)
                .addVariant("calcite_pillar_basic_spiral", props, CTMV)
                .addVariant("calcite_pillar_classic", props, TBS)
                .addVariant("calcite_pillar_classic_large", props, TBS)
                .addVariant("calcite_pillar_ionic", props, CTMV)
                .addVariant("calcite_pillar_ionic_dent", props, CTMV)
                .addVariant("calcite_pillar_ionic_plain", props, CTMV)
                .addVariant("calcite_pillar_ionic_round", props, CTMV)
                .addVariant("calcite_pillar_ionic_spiral", props, CTMV)
                .addVariant("calcite_pillar_large_basic_triple", props, CTMV)
                .addVariant("calcite_pillar_large_ionic_triple", props, CTMV)
                .addVariant("calcite_pillar_meander", props, CTMV)
                .addVariant("calcite_pillar_meander_dent", props, CTMV)
                .addVariant("calcite_pillar_meander_plain", props, CTMV)
                .addVariant("calcite_pillar_meander_round", props, CTMV)
                .addVariant("calcite_pillar_meander_spiral", props, CTMV)
                .addVariant("calcite_plate", props, CONNECTED)
                .addVariant("calcite_polished", props)
                .addVariant("calcite_prism", props)
                .addVariant("calcite_raw", props)
                .addVariant("calcite_road", props)
                .addVariant("calcite_slanted", props, MULTIBLOCK_2X2)
                .addVariant("calcite_bricks_small", props)
                .addVariant("calcite_bricks_soft", props)
                .addVariant("calcite_bricks_solid", props)
                .addVariant("calcite_border_square", props, CONNECTED)
                .addVariant("calcite_tiles_large", props, CONNECTED)
                .addVariant("calcite_tiles", props)
                .addVariant("calcite_tiles_small", props)
                .addVariant("calcite_bricks_triple", props)
                .addVariant("calcite_twisted", props, TBS)
                .addVariant("calcite_weaver", props, CONNECTED)
                .addVariant("calcite_zag", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("calcite_array"), "Calcite", "Array");
        lang.addBlock(getVariant("calcite_border_square"), "Calcite", "Square Border");
        lang.addBlock(getVariant("calcite_braid"), "Calcite", "Braid");
        lang.addBlock(getVariant("calcite_bricks_cracked"), "Calcite", "Cracked Bricks");
        lang.addBlock(getVariant("calcite_bricks_encased"), "Calcite", "Encased Bricks");
        lang.addBlock(getVariant("calcite_bricks_indent"), "Calcite", "Indent Bricks");
        lang.addBlock(getVariant("calcite_bricks_inlayed"), "Calcite", "Inlayed Bricks");
        lang.addBlock(getVariant("calcite_bricks_large"), "Calcite", "Large Bricks");
        lang.addBlock(getVariant("calcite_bricks_small"), "Calcite", "Small Bricks");
        lang.addBlock(getVariant("calcite_bricks_soft"), "Calcite", "Soft Bricks");
        lang.addBlock(getVariant("calcite_bricks_solid"), "Calcite", "Solid Bricks");
        lang.addBlock(getVariant("calcite_bricks_triple"), "Calcite", "Triple Bricks");
        lang.addBlock(getVariant("calcite_bricks_vertical"), "Calcite", "Vertical Bricks");
        lang.addBlock(getVariant("calcite_chaotic"), "Calcite", "Chaotic");
        lang.addBlock(getVariant("calcite_chaotic_medium"), "Calcite", "Chaotic Medium");
        lang.addBlock(getVariant("calcite_chaotic_small"), "Calcite", "Chaotic Small");
        lang.addBlock(getVariant("calcite_checker"), "Calcite", "Checker");
        lang.addBlock(getVariant("calcite_checker_small"), "Calcite", "Small Checker");
        lang.addBlock(getVariant("calcite_circular"), "Calcite", "Circular");
        lang.addBlock(getVariant("calcite_cobble"), "Calcite", "Cobble");
        lang.addBlock(getVariant("calcite_cuts"), "Calcite", "Cuts");
        lang.addBlock(getVariant("calcite_dent"), "Calcite", "Dent");
        lang.addBlock(getVariant("calcite_french_1"), "Calcite", "French 1");
        lang.addBlock(getVariant("calcite_french_2"), "Calcite", "French 2");
        lang.addBlock(getVariant("calcite_indent"), "Calcite", "Indent");
        lang.addBlock(getVariant("calcite_jellybean"), "Calcite", "Jellybean");
        lang.addBlock(getVariant("calcite_layers"), "Calcite", "Layers");
        lang.addBlock(getVariant("calcite_line_horizontal"), "Calcite", "Horizontal Line");
        lang.addBlock(getVariant("calcite_line_vertical"), "Calcite", "Vertical Line");
        lang.addBlock(getVariant("calcite_meander_horizontal"), "Calcite", "Horizontal Meander");
        lang.addBlock(getVariant("calcite_meander_vertical"), "Calcite", "Vertical Meander");
        lang.addBlock(getVariant("calcite_mosaic"), "Calcite", "Mosaic");
        lang.addBlock(getVariant("calcite_ornate_small"), "Calcite", "Small Ornate");
        lang.addBlock(getVariant("calcite_panel"), "Calcite", "Panel");
        lang.addBlock(getVariant("calcite_pillar"), "Calcite", "Pillar");
        lang.addBlock(getVariant("calcite_pillar_basic"), "Calcite", "Basic Pillar");
        lang.addBlock(getVariant("calcite_pillar_basic_dent"), "Calcite", "Basic Dent Pillar");
        lang.addBlock(getVariant("calcite_pillar_basic_plain"), "Calcite", "Basic Plain Pillar");
        lang.addBlock(getVariant("calcite_pillar_basic_round"), "Calcite", "Basic Round Pillar");
        lang.addBlock(getVariant("calcite_pillar_basic_spiral"), "Calcite", "Basic Spiral Pillar");
        lang.addBlock(getVariant("calcite_pillar_classic"), "Calcite", "Classic Pillar");
        lang.addBlock(getVariant("calcite_pillar_classic_large"), "Calcite", "Large Classic Pillar");
        lang.addBlock(getVariant("calcite_pillar_ionic"), "Calcite", "Ionic Pillar");
        lang.addBlock(getVariant("calcite_pillar_ionic_dent"), "Calcite", "Ionic Dent Pillar");
        lang.addBlock(getVariant("calcite_pillar_ionic_plain"), "Calcite", "Ionic Plain Pillar");
        lang.addBlock(getVariant("calcite_pillar_ionic_round"), "Calcite", "Ionic Round Pillar");
        lang.addBlock(getVariant("calcite_pillar_ionic_spiral"), "Calcite", "Ionic Spiral Pillar");
        lang.addBlock(getVariant("calcite_pillar_large_basic_triple"), "Calcite", "Large Basic Triple Pillar");
        lang.addBlock(getVariant("calcite_pillar_large_ionic_triple"), "Calcite", "Large Ionic Triple Pillar");
        lang.addBlock(getVariant("calcite_pillar_meander"), "Calcite", "Meander Pillar");
        lang.addBlock(getVariant("calcite_pillar_meander_dent"), "Calcite", "Meander Dent Pillar");
        lang.addBlock(getVariant("calcite_pillar_meander_plain"), "Calcite", "Meander Plain Pillar");
        lang.addBlock(getVariant("calcite_pillar_meander_round"), "Calcite", "Meander Round Pillar");
        lang.addBlock(getVariant("calcite_pillar_meander_spiral"), "Calcite", "Meander Spiral Pillar");
        lang.addBlock(getVariant("calcite_plate"), "Calcite", "Plate");
        lang.addBlock(getVariant("calcite_polished"), "Calcite", "Polished");
        lang.addBlock(getVariant("calcite_prism"), "Calcite", "Prismatic");
        lang.addBlock(getVariant("calcite_raw"), "Calcite", "Raw");
        lang.addBlock(getVariant("calcite_road"), "Calcite", "Road");
        lang.addBlock(getVariant("calcite_slanted"), "Calcite", "Slanted");
        lang.addBlock(getVariant("calcite_tiles"), "Calcite", "Tiles");
        lang.addBlock(getVariant("calcite_tiles_large"), "Calcite", "Large Tiles");
        lang.addBlock(getVariant("calcite_tiles_small"), "Calcite", "Small Tiles");
        lang.addBlock(getVariant("calcite_twisted"), "Calcite", "Twisted");
        lang.addBlock(getVariant("calcite_weaver"), "Calcite", "Weaver");
        lang.addBlock(getVariant("calcite_zag"), "Calcite", "Zag");
    }
}
