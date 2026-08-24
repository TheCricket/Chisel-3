package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class TuffFamily extends ChiselFamily {
    public TuffFamily(BlockBehaviour.Properties props) {
        family = builder("tuff")
                .addVariant(Blocks.TUFF)
                .addVariant(Blocks.CHISELED_TUFF)
                .addVariant(Blocks.POLISHED_TUFF)
                .addVariant(Blocks.TUFF_BRICKS)
                .addVariant(Blocks.CHISELED_TUFF_BRICKS)
                .addVariant("tuff_array", props, MULTIBLOCK_2X2)
                .addVariant("tuff_braid", props)
                .addVariant("tuff_bricks_indent", props)
                .addVariant("tuff_bricks_inlayed", props)
                .addVariant("tuff_bricks_large", props, MULTIBLOCK_2X2)
                .addVariant("tuff_bricks_vertical", props)
                .addVariant("tuff_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("tuff_chaotic_medium", props)
                .addVariant("tuff_chaotic_small", props)
                .addVariant("tuff_checker", props)
                .addVariant("tuff_checker_small", props)
                .addVariant("tuff_circular", props, CONNECTED)
                .addVariant("tuff_cobble", props)
                .addVariant("tuff_bricks_cracked", props)
                .addVariant("tuff_cuts", props, MULTIBLOCK_4X4)
                .addVariant("tuff_dent", props, CONNECTED)
                .addVariant("tuff_bricks_encased", props, CONNECTED)
                .addVariant("tuff_french_1", props)
                .addVariant("tuff_french_2", props)
                .addVariant("tuff_indent", props, CONNECTED)
                .addVariant("tuff_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("tuff_layers", props)
                .addVariant("tuff_line_horizontal", props)
                .addVariant("tuff_line_vertical", props)
                .addVariant("tuff_meander_horizontal", props, CTMH)
                .addVariant("tuff_meander_vertical", props, CTMV)
                .addVariant("tuff_mosaic", props, CONNECTED)
                .addVariant("tuff_ornate_small", props)
                .addVariant("tuff_panel", props)
                .addVariant("tuff_pillar", props, TBS)
                .addVariant("tuff_pillar_basic", props, CTMV)
                .addVariant("tuff_pillar_basic_dent", props, CTMV)
                .addVariant("tuff_pillar_basic_plain", props, CTMV)
                .addVariant("tuff_pillar_basic_round", props, CTMV)
                .addVariant("tuff_pillar_basic_spiral", props, CTMV)
                .addVariant("tuff_pillar_classic", props, TBS)
                .addVariant("tuff_pillar_classic_large", props, TBS)
                .addVariant("tuff_pillar_ionic", props, CTMV)
                .addVariant("tuff_pillar_ionic_dent", props, CTMV)
                .addVariant("tuff_pillar_ionic_plain", props, CTMV)
                .addVariant("tuff_pillar_ionic_round", props, CTMV)
                .addVariant("tuff_pillar_ionic_spiral", props, CTMV)
                .addVariant("tuff_pillar_large_basic_triple", props, CTMV)
                .addVariant("tuff_pillar_large_ionic_triple", props, CTMV)
                .addVariant("tuff_pillar_meander", props, CTMV)
                .addVariant("tuff_pillar_meander_dent", props, CTMV)
                .addVariant("tuff_pillar_meander_plain", props, CTMV)
                .addVariant("tuff_pillar_meander_round", props, CTMV)
                .addVariant("tuff_pillar_meander_spiral", props, CTMV)
                .addVariant("tuff_plate", props, CONNECTED)
                .addVariant("tuff_polished", props)
                .addVariant("tuff_prism", props)
                .addVariant("tuff_raw", props)
                .addVariant("tuff_road", props)
                .addVariant("tuff_slanted", props, MULTIBLOCK_2X2)
                .addVariant("tuff_bricks_small", props)
                .addVariant("tuff_bricks_soft", props)
                .addVariant("tuff_bricks_solid", props)
                .addVariant("tuff_border_square", props, CONNECTED)
                .addVariant("tuff_tiles_large", props, CONNECTED)
                .addVariant("tuff_tiles", props)
                .addVariant("tuff_tiles_small", props)
                .addVariant("tuff_bricks_triple", props)
                .addVariant("tuff_twisted", props, TBS)
                .addVariant("tuff_weaver", props, CONNECTED)
                .addVariant("tuff_zag", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("tuff_array"), "Tuff", "Array");
        lang.addBlock(getVariant("tuff_border_square"), "Tuff", "Square Border");
        lang.addBlock(getVariant("tuff_braid"), "Tuff", "Braid");
        lang.addBlock(getVariant("tuff_bricks_cracked"), "Tuff", "Cracked Bricks");
        lang.addBlock(getVariant("tuff_bricks_encased"), "Tuff", "Encased Bricks");
        lang.addBlock(getVariant("tuff_bricks_indent"), "Tuff", "Indent Bricks");
        lang.addBlock(getVariant("tuff_bricks_inlayed"), "Tuff", "Inlayed Bricks");
        lang.addBlock(getVariant("tuff_bricks_large"), "Tuff", "Large Bricks");
        lang.addBlock(getVariant("tuff_bricks_small"), "Tuff", "Small Bricks");
        lang.addBlock(getVariant("tuff_bricks_soft"), "Tuff", "Soft Bricks");
        lang.addBlock(getVariant("tuff_bricks_solid"), "Tuff", "Solid Bricks");
        lang.addBlock(getVariant("tuff_bricks_triple"), "Tuff", "Triple Bricks");
        lang.addBlock(getVariant("tuff_bricks_vertical"), "Tuff", "Vertical Bricks");
        lang.addBlock(getVariant("tuff_chaotic"), "Tuff", "Chaotic");
        lang.addBlock(getVariant("tuff_chaotic_medium"), "Tuff", "Chaotic Medium");
        lang.addBlock(getVariant("tuff_chaotic_small"), "Tuff", "Chaotic Small");
        lang.addBlock(getVariant("tuff_checker"), "Tuff", "Checker");
        lang.addBlock(getVariant("tuff_checker_small"), "Tuff", "Small Checker");
        lang.addBlock(getVariant("tuff_circular"), "Tuff", "Circular");
        lang.addBlock(getVariant("tuff_cobble"), "Tuff", "Cobble");
        lang.addBlock(getVariant("tuff_cuts"), "Tuff", "Cuts");
        lang.addBlock(getVariant("tuff_dent"), "Tuff", "Dent");
        lang.addBlock(getVariant("tuff_french_1"), "Tuff", "French 1");
        lang.addBlock(getVariant("tuff_french_2"), "Tuff", "French 2");
        lang.addBlock(getVariant("tuff_indent"), "Tuff", "Indent");
        lang.addBlock(getVariant("tuff_jellybean"), "Tuff", "Jellybean");
        lang.addBlock(getVariant("tuff_layers"), "Tuff", "Layers");
        lang.addBlock(getVariant("tuff_line_horizontal"), "Tuff", "Horizontal Line");
        lang.addBlock(getVariant("tuff_line_vertical"), "Tuff", "Vertical Line");
        lang.addBlock(getVariant("tuff_meander_horizontal"), "Tuff", "Horizontal Meander");
        lang.addBlock(getVariant("tuff_meander_vertical"), "Tuff", "Vertical Meander");
        lang.addBlock(getVariant("tuff_mosaic"), "Tuff", "Mosaic");
        lang.addBlock(getVariant("tuff_ornate_small"), "Tuff", "Small Ornate");
        lang.addBlock(getVariant("tuff_panel"), "Tuff", "Panel");
        lang.addBlock(getVariant("tuff_pillar"), "Tuff", "Pillar");
        lang.addBlock(getVariant("tuff_pillar_basic"), "Tuff", "Basic Pillar");
        lang.addBlock(getVariant("tuff_pillar_basic_dent"), "Tuff", "Basic Dent Pillar");
        lang.addBlock(getVariant("tuff_pillar_basic_plain"), "Tuff", "Basic Plain Pillar");
        lang.addBlock(getVariant("tuff_pillar_basic_round"), "Tuff", "Basic Round Pillar");
        lang.addBlock(getVariant("tuff_pillar_basic_spiral"), "Tuff", "Basic Spiral Pillar");
        lang.addBlock(getVariant("tuff_pillar_classic"), "Tuff", "Classic Pillar");
        lang.addBlock(getVariant("tuff_pillar_classic_large"), "Tuff", "Large Classic Pillar");
        lang.addBlock(getVariant("tuff_pillar_ionic"), "Tuff", "Ionic Pillar");
        lang.addBlock(getVariant("tuff_pillar_ionic_dent"), "Tuff", "Ionic Dent Pillar");
        lang.addBlock(getVariant("tuff_pillar_ionic_plain"), "Tuff", "Ionic Plain Pillar");
        lang.addBlock(getVariant("tuff_pillar_ionic_round"), "Tuff", "Ionic Round Pillar");
        lang.addBlock(getVariant("tuff_pillar_ionic_spiral"), "Tuff", "Ionic Spiral Pillar");
        lang.addBlock(getVariant("tuff_pillar_large_basic_triple"), "Tuff", "Large Basic Triple Pillar");
        lang.addBlock(getVariant("tuff_pillar_large_ionic_triple"), "Tuff", "Large Ionic Triple Pillar");
        lang.addBlock(getVariant("tuff_pillar_meander"), "Tuff", "Meander Pillar");
        lang.addBlock(getVariant("tuff_pillar_meander_dent"), "Tuff", "Meander Dent Pillar");
        lang.addBlock(getVariant("tuff_pillar_meander_plain"), "Tuff", "Meander Plain Pillar");
        lang.addBlock(getVariant("tuff_pillar_meander_round"), "Tuff", "Meander Round Pillar");
        lang.addBlock(getVariant("tuff_pillar_meander_spiral"), "Tuff", "Meander Spiral Pillar");
        lang.addBlock(getVariant("tuff_plate"), "Tuff", "Plate");
        lang.addBlock(getVariant("tuff_polished"), "Tuff", "Polished");
        lang.addBlock(getVariant("tuff_prism"), "Tuff", "Prismatic");
        lang.addBlock(getVariant("tuff_raw"), "Tuff", "Raw");
        lang.addBlock(getVariant("tuff_road"), "Tuff", "Road");
        lang.addBlock(getVariant("tuff_slanted"), "Tuff", "Slanted");
        lang.addBlock(getVariant("tuff_tiles"), "Tuff", "Tiles");
        lang.addBlock(getVariant("tuff_tiles_large"), "Tuff", "Large Tiles");
        lang.addBlock(getVariant("tuff_tiles_small"), "Tuff", "Small Tiles");
        lang.addBlock(getVariant("tuff_twisted"), "Tuff", "Twisted");
        lang.addBlock(getVariant("tuff_weaver"), "Tuff", "Weaver");
        lang.addBlock(getVariant("tuff_zag"), "Tuff", "Zag");
    }
}
