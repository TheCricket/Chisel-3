package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class MudFamily extends ChiselFamily {
    public MudFamily(BlockBehaviour.Properties props) {
        family = builder("mud")
                .addVariant(Blocks.PACKED_MUD)
                .addVariant(Blocks.MUD_BRICKS)
                // .addVariant("blackstone_array", props, MULTIBLOCK_2X2)
                // .addVariant("blackstone_braid", props)
                // .addVariant("blackstone_bricks_indent", props)
                // .addVariant("blackstone_bricks_inlayed", props)
                // .addVariant("blackstone_bricks_large", props, MULTIBLOCK_2X2)
                // .addVariant("blackstone_bricks_vertical", props)
                // .addVariant("blackstone_chaotic", props, MULTIBLOCK_3X3)
                // .addVariant("blackstone_chaotic_medium", props)
                // .addVariant("blackstone_chaotic_small", props)
                // .addVariant("blackstone_checker", props)
                // .addVariant("blackstone_checker_small", props)
                // .addVariant("blackstone_circular", props, CONNECTED)
                // .addVariant("blackstone_cobble", props)
                // .addVariant("blackstone_bricks_cracked", props)
                // .addVariant("blackstone_cuts", props, MULTIBLOCK_4X4)
                // .addVariant("blackstone_dent", props, CONNECTED)
                // .addVariant("blackstone_bricks_encased", props, CONNECTED)
                // .addVariant("blackstone_french_1", props)
                // .addVariant("blackstone_french_2", props)
                // .addVariant("blackstone_indent", props, CONNECTED)
                // .addVariant("blackstone_jellybean", props, MULTIBLOCK_2X2)
                // .addVariant("blackstone_layers", props)
                // .addVariant("blackstone_line_horizontal", props)
                // .addVariant("blackstone_line_vertical", props)
                // .addVariant("blackstone_meander_horizontal", props, CTMH)
                // .addVariant("blackstone_meander_vertical", props, CTMV)
                // .addVariant("blackstone_mosaic", props, CONNECTED)
                // .addVariant("blackstone_ornate_small", props)
                // .addVariant("blackstone_panel", props)
                // .addVariant("blackstone_pillar", props, TBS)
                // .addVariant("blackstone_pillar_basic", props, CTMV)
                // .addVariant("blackstone_pillar_basic_dent", props, CTMV)
                // .addVariant("blackstone_pillar_basic_plain", props, CTMV)
                // .addVariant("blackstone_pillar_basic_round", props, CTMV)
                // .addVariant("blackstone_pillar_basic_spiral", props, CTMV)
                // .addVariant("blackstone_pillar_classic", props, TBS)
                // .addVariant("blackstone_pillar_classic_large", props, TBS)
                // .addVariant("blackstone_pillar_ionic", props, CTMV)
                // .addVariant("blackstone_pillar_ionic_dent", props, CTMV)
                // .addVariant("blackstone_pillar_ionic_plain", props, CTMV)
                // .addVariant("blackstone_pillar_ionic_round", props, CTMV)
                // .addVariant("blackstone_pillar_ionic_spiral", props, CTMV)
                // .addVariant("blackstone_pillar_large_basic_triple", props, CTMV)
                // .addVariant("blackstone_pillar_large_ionic_triple", props, CTMV)
                // .addVariant("blackstone_pillar_meander", props, CTMV)
                // .addVariant("blackstone_pillar_meander_dent", props, CTMV)
                // .addVariant("blackstone_pillar_meander_plain", props, CTMV)
                // .addVariant("blackstone_pillar_meander_round", props, CTMV)
                // .addVariant("blackstone_pillar_meander_spiral", props, CTMV)
                // .addVariant("blackstone_plate", props, CONNECTED)
                // .addVariant("blackstone_polished", props)
                // .addVariant("blackstone_prism", props)
                // .addVariant("blackstone_raw", props)
                // .addVariant("blackstone_road", props)
                // .addVariant("blackstone_slanted", props, MULTIBLOCK_2X2)
                // .addVariant("blackstone_bricks_small", props)
                // .addVariant("blackstone_bricks_soft", props)
                // .addVariant("blackstone_bricks_solid", props)
                // .addVariant("blackstone_border_square", props, CONNECTED)
                // .addVariant("blackstone_tiles_large", props, CONNECTED)
                // .addVariant("blackstone_tiles", props)
                // .addVariant("blackstone_tiles_small", props)
                // .addVariant("blackstone_bricks_triple", props)
                // .addVariant("blackstone_twisted", props, TBS)
                // .addVariant("blackstone_weaver", props, CONNECTED)
                // .addVariant("blackstone_zag", props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        // lang.addBlock(getVariant("blackstone_array"), "Blackstone", "Array");
        // lang.addBlock(getVariant("blackstone_border_square"), "Blackstone", "Square Border");
        // lang.addBlock(getVariant("blackstone_braid"), "Blackstone", "Braid");
        // lang.addBlock(getVariant("blackstone_bricks_cracked"), "Blackstone", "Cracked Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_encased"), "Blackstone", "Encased Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_indent"), "Blackstone", "Indent Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_inlayed"), "Blackstone", "Inlayed Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_large"), "Blackstone", "Large Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_small"), "Blackstone", "Small Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_soft"), "Blackstone", "Soft Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_solid"), "Blackstone", "Solid Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_triple"), "Blackstone", "Triple Bricks");
        // lang.addBlock(getVariant("blackstone_bricks_vertical"), "Blackstone", "Vertical Bricks");
        // lang.addBlock(getVariant("blackstone_chaotic"), "Blackstone", "Chaotic");
        // lang.addBlock(getVariant("blackstone_chaotic_medium"), "Blackstone", "Chaotic Medium");
        // lang.addBlock(getVariant("blackstone_chaotic_small"), "Blackstone", "Chaotic Small");
        // lang.addBlock(getVariant("blackstone_checker"), "Blackstone", "Checker");
        // lang.addBlock(getVariant("blackstone_checker_small"), "Blackstone", "Small Checker");
        // lang.addBlock(getVariant("blackstone_circular"), "Blackstone", "Circular");
        // lang.addBlock(getVariant("blackstone_cobble"), "Blackstone", "Cobble");
        // lang.addBlock(getVariant("blackstone_cuts"), "Blackstone", "Cuts");
        // lang.addBlock(getVariant("blackstone_dent"), "Blackstone", "Dent");
        // lang.addBlock(getVariant("blackstone_french_1"), "Blackstone", "French 1");
        // lang.addBlock(getVariant("blackstone_french_2"), "Blackstone", "French 2");
        // lang.addBlock(getVariant("blackstone_indent"), "Blackstone", "Indent");
        // lang.addBlock(getVariant("blackstone_jellybean"), "Blackstone", "Jellybean");
        // lang.addBlock(getVariant("blackstone_layers"), "Blackstone", "Layers");
        // lang.addBlock(getVariant("blackstone_line_horizontal"), "Blackstone", "Horizontal Line");
        // lang.addBlock(getVariant("blackstone_line_vertical"), "Blackstone", "Vertical Line");
        // lang.addBlock(getVariant("blackstone_meander_horizontal"), "Blackstone", "Horizontal Meander");
        // lang.addBlock(getVariant("blackstone_meander_vertical"), "Blackstone", "Vertical Meander");
        // lang.addBlock(getVariant("blackstone_mosaic"), "Blackstone", "Mosaic");
        // lang.addBlock(getVariant("blackstone_ornate_small"), "Blackstone", "Small Ornate");
        // lang.addBlock(getVariant("blackstone_panel"), "Blackstone", "Panel");
        // lang.addBlock(getVariant("blackstone_pillar"), "Blackstone", "Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_basic"), "Blackstone", "Basic Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_basic_dent"), "Blackstone", "Basic Dent Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_basic_plain"), "Blackstone", "Basic Plain Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_basic_round"), "Blackstone", "Basic Round Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_basic_spiral"), "Blackstone", "Basic Spiral Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_classic"), "Blackstone", "Classic Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_classic_large"), "Blackstone", "Large Classic Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_ionic"), "Blackstone", "Ionic Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_ionic_dent"), "Blackstone", "Ionic Dent Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_ionic_plain"), "Blackstone", "Ionic Plain Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_ionic_round"), "Blackstone", "Ionic Round Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_ionic_spiral"), "Blackstone", "Ionic Spiral Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_large_basic_triple"), "Blackstone", "Large Basic Triple Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_large_ionic_triple"), "Blackstone", "Large Ionic Triple Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_meander"), "Blackstone", "Meander Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_meander_dent"), "Blackstone", "Meander Dent Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_meander_plain"), "Blackstone", "Meander Plain Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_meander_round"), "Blackstone", "Meander Round Pillar");
        // lang.addBlock(getVariant("blackstone_pillar_meander_spiral"), "Blackstone", "Meander Spiral Pillar");
        // lang.addBlock(getVariant("blackstone_plate"), "Blackstone", "Plate");
        // lang.addBlock(getVariant("blackstone_polished"), "Blackstone", "Polished");
        // lang.addBlock(getVariant("blackstone_prism"), "Blackstone", "Prismatic");
        // lang.addBlock(getVariant("blackstone_raw"), "Blackstone", "Raw");
        // lang.addBlock(getVariant("blackstone_road"), "Blackstone", "Road");
        // lang.addBlock(getVariant("blackstone_slanted"), "Blackstone", "Slanted");
        // lang.addBlock(getVariant("blackstone_tiles"), "Blackstone", "Tiles");
        // lang.addBlock(getVariant("blackstone_tiles_large"), "Blackstone", "Large Tiles");
        // lang.addBlock(getVariant("blackstone_tiles_small"), "Blackstone", "Small Tiles");
        // lang.addBlock(getVariant("blackstone_twisted"), "Blackstone", "Twisted");
        // lang.addBlock(getVariant("blackstone_weaver"), "Blackstone", "Weaver");
        // lang.addBlock(getVariant("blackstone_zag"), "Blackstone", "Zag");
    }
}

