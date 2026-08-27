package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.StringUtils;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class ConcreteFamily extends ChiselFamily {
    public ConcreteFamily(BlockBehaviour.Properties props, String color, Block vanilla) {
        String name = color.toLowerCase();
        family = builder("concrete_%s".formatted(name))
                .addVariant(vanilla)
                .addVariant("concrete_%s_array".formatted(name), props, MULTIBLOCK_2X2)
                .addVariant("concrete_%s_braid".formatted(name), props)
                .addVariant("concrete_%s_bricks_indent".formatted(name), props)
                .addVariant("concrete_%s_bricks_inlayed".formatted(name), props)
                .addVariant("concrete_%s_bricks_large".formatted(name), props, MULTIBLOCK_2X2)
                .addVariant("concrete_%s_bricks_vertical".formatted(name), props)
                .addVariant("concrete_%s_chaotic".formatted(name), props, MULTIBLOCK_3X3)
                .addVariant("concrete_%s_chaotic_medium".formatted(name), props)
                .addVariant("concrete_%s_chaotic_small".formatted(name), props)
                .addVariant("concrete_%s_checker".formatted(name), props)
                .addVariant("concrete_%s_checker_small".formatted(name), props)
                .addVariant("concrete_%s_circular".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_cobble".formatted(name), props)
                .addVariant("concrete_%s_bricks_cracked".formatted(name), props)
                .addVariant("concrete_%s_cuts".formatted(name), props, MULTIBLOCK_4X4)
                .addVariant("concrete_%s_dent".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_bricks_encased".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_french_1".formatted(name), props)
                .addVariant("concrete_%s_french_2".formatted(name), props)
                .addVariant("concrete_%s_indent".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_jellybean".formatted(name), props, MULTIBLOCK_2X2)
                .addVariant("concrete_%s_layers".formatted(name), props)
                .addVariant("concrete_%s_line_horizontal".formatted(name), props)
                .addVariant("concrete_%s_line_vertical".formatted(name), props)
                .addVariant("concrete_%s_meander_horizontal".formatted(name), props, CTMH)
                .addVariant("concrete_%s_meander_vertical".formatted(name), props, CTMV)
                .addVariant("concrete_%s_mosaic".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_ornate_small".formatted(name), props)
                .addVariant("concrete_%s_panel".formatted(name), props)
                .addVariant("concrete_%s_pillar".formatted(name), props, TBS)
                .addVariant("concrete_%s_pillar_basic".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_basic_dent".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_basic_plain".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_basic_round".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_basic_spiral".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_classic".formatted(name), props, TBS)
                .addVariant("concrete_%s_pillar_classic_large".formatted(name), props, TBS)
                .addVariant("concrete_%s_pillar_ionic".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_ionic_dent".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_ionic_plain".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_ionic_round".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_ionic_spiral".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_large_basic_triple".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_large_ionic_triple".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_meander".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_meander_dent".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_meander_plain".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_meander_round".formatted(name), props, CTMV)
                .addVariant("concrete_%s_pillar_meander_spiral".formatted(name), props, CTMV)
                .addVariant("concrete_%s_plate".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_polished".formatted(name), props)
                .addVariant("concrete_%s_prism".formatted(name), props)
                .addVariant("concrete_%s_raw".formatted(name), props)
                .addVariant("concrete_%s_road".formatted(name), props)
                .addVariant("concrete_%s_slanted".formatted(name), props, MULTIBLOCK_2X2)
                .addVariant("concrete_%s_bricks_small".formatted(name), props)
                .addVariant("concrete_%s_bricks_soft".formatted(name), props)
                .addVariant("concrete_%s_bricks_solid".formatted(name), props)
                .addVariant("concrete_%s_border_square".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_tiles_large".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_tiles".formatted(name), props)
                .addVariant("concrete_%s_tiles_small".formatted(name), props)
                .addVariant("concrete_%s_bricks_triple".formatted(name), props)
                .addVariant("concrete_%s_twisted".formatted(name), props, TBS)
                .addVariant("concrete_%s_weaver".formatted(name), props, CONNECTED)
                .addVariant("concrete_%s_zag".formatted(name), props, MULTIBLOCK_2X2)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        String familyName = family.getFamilyName();
        String color = StringUtils.capitalize(familyName.substring(9)); // Remove "wool_"
        String baseName = "%s Concrete".formatted(color);
        String variantPrefix = "%s_".formatted(familyName);
        lang.addBlock(getVariant("%sarray".formatted(variantPrefix)), baseName, "Array");
        lang.addBlock(getVariant("%sborder_square".formatted(variantPrefix)), baseName, "Square Border");
        lang.addBlock(getVariant("%sbraid".formatted(variantPrefix)), baseName, "Braid");
        lang.addBlock(getVariant("%sbricks_cracked".formatted(variantPrefix)), baseName, "Cracked Bricks");
        lang.addBlock(getVariant("%sbricks_encased".formatted(variantPrefix)), baseName, "Encased Bricks");
        lang.addBlock(getVariant("%sbricks_indent".formatted(variantPrefix)), baseName, "Indent Bricks");
        lang.addBlock(getVariant("%sbricks_inlayed".formatted(variantPrefix)), baseName, "Inlayed Bricks");
        lang.addBlock(getVariant("%sbricks_large".formatted(variantPrefix)), baseName, "Large Bricks");
        lang.addBlock(getVariant("%sbricks_small".formatted(variantPrefix)), baseName, "Small Bricks");
        lang.addBlock(getVariant("%sbricks_soft".formatted(variantPrefix)), baseName, "Soft Bricks");
        lang.addBlock(getVariant("%sbricks_solid".formatted(variantPrefix)), baseName, "Solid Bricks");
        lang.addBlock(getVariant("%sbricks_triple".formatted(variantPrefix)), baseName, "Triple Bricks");
        lang.addBlock(getVariant("%sbricks_vertical".formatted(variantPrefix)), baseName, "Vertical Bricks");
        lang.addBlock(getVariant("%schaotic".formatted(variantPrefix)), baseName, "Chaotic");
        lang.addBlock(getVariant("%schaotic_medium".formatted(variantPrefix)), baseName, "Chaotic Medium");
        lang.addBlock(getVariant("%schaotic_small".formatted(variantPrefix)), baseName, "Chaotic Small");
        lang.addBlock(getVariant("%schecker".formatted(variantPrefix)), baseName, "Checker");
        lang.addBlock(getVariant("%schecker_small".formatted(variantPrefix)), baseName, "Small Checker");
        lang.addBlock(getVariant("%scircular".formatted(variantPrefix)), baseName, "Circular");
        lang.addBlock(getVariant("%scobble".formatted(variantPrefix)), baseName, "Cobble");
        lang.addBlock(getVariant("%scuts".formatted(variantPrefix)), baseName, "Cuts");
        lang.addBlock(getVariant("%sdent".formatted(variantPrefix)), baseName, "Dent");
        lang.addBlock(getVariant("%sfrench_1".formatted(variantPrefix)), baseName, "French 1");
        lang.addBlock(getVariant("%sfrench_2".formatted(variantPrefix)), baseName, "French 2");
        lang.addBlock(getVariant("%sindent".formatted(variantPrefix)), baseName, "Indent");
        lang.addBlock(getVariant("%sjellybean".formatted(variantPrefix)), baseName, "Jellybean");
        lang.addBlock(getVariant("%slayers".formatted(variantPrefix)), baseName, "Layers");
        lang.addBlock(getVariant("%sline_horizontal".formatted(variantPrefix)), baseName, "Horizontal Line");
        lang.addBlock(getVariant("%sline_vertical".formatted(variantPrefix)), baseName, "Vertical Line");
        lang.addBlock(getVariant("%smeander_horizontal".formatted(variantPrefix)), baseName, "Horizontal Meander");
        lang.addBlock(getVariant("%smeander_vertical".formatted(variantPrefix)), baseName, "Vertical Meander");
        lang.addBlock(getVariant("%smosaic".formatted(variantPrefix)), baseName, "Mosaic");
        lang.addBlock(getVariant("%sornate_small".formatted(variantPrefix)), baseName, "Small Ornate");
        lang.addBlock(getVariant("%spanel".formatted(variantPrefix)), baseName, "Panel");
        lang.addBlock(getVariant("%spillar".formatted(variantPrefix)), baseName, "Pillar");
        lang.addBlock(getVariant("%spillar_basic".formatted(variantPrefix)), baseName, "Basic Pillar");
        lang.addBlock(getVariant("%spillar_basic_dent".formatted(variantPrefix)), baseName, "Basic Dent Pillar");
        lang.addBlock(getVariant("%spillar_basic_plain".formatted(variantPrefix)), baseName, "Basic Plain Pillar");
        lang.addBlock(getVariant("%spillar_basic_round".formatted(variantPrefix)), baseName, "Basic Round Pillar");
        lang.addBlock(getVariant("%spillar_basic_spiral".formatted(variantPrefix)), baseName, "Basic Spiral Pillar");
        lang.addBlock(getVariant("%spillar_classic".formatted(variantPrefix)), baseName, "Classic Pillar");
        lang.addBlock(getVariant("%spillar_classic_large".formatted(variantPrefix)), baseName, "Large Classic Pillar");
        lang.addBlock(getVariant("%spillar_ionic".formatted(variantPrefix)), baseName, "Ionic Pillar");
        lang.addBlock(getVariant("%spillar_ionic_dent".formatted(variantPrefix)), baseName, "Ionic Dent Pillar");
        lang.addBlock(getVariant("%spillar_ionic_plain".formatted(variantPrefix)), baseName, "Ionic Plain Pillar");
        lang.addBlock(getVariant("%spillar_ionic_round".formatted(variantPrefix)), baseName, "Ionic Round Pillar");
        lang.addBlock(getVariant("%spillar_ionic_spiral".formatted(variantPrefix)), baseName, "Ionic Spiral Pillar");
        lang.addBlock(getVariant("%spillar_large_basic_triple".formatted(variantPrefix)), baseName, "Large Basic Triple Pillar");
        lang.addBlock(getVariant("%spillar_large_ionic_triple".formatted(variantPrefix)), baseName, "Large Ionic Triple Pillar");
        lang.addBlock(getVariant("%spillar_meander".formatted(variantPrefix)), baseName, "Meander Pillar");
        lang.addBlock(getVariant("%spillar_meander_dent".formatted(variantPrefix)), baseName, "Meander Dent Pillar");
        lang.addBlock(getVariant("%spillar_meander_plain".formatted(variantPrefix)), baseName, "Meander Plain Pillar");
        lang.addBlock(getVariant("%spillar_meander_round".formatted(variantPrefix)), baseName, "Meander Round Pillar");
        lang.addBlock(getVariant("%spillar_meander_spiral".formatted(variantPrefix)), baseName, "Meander Spiral Pillar");
        lang.addBlock(getVariant("%splate".formatted(variantPrefix)), baseName, "Plate");
        lang.addBlock(getVariant("%spolished".formatted(variantPrefix)), baseName, "Polished");
        lang.addBlock(getVariant("%sprism".formatted(variantPrefix)), baseName, "Prismatic");
        lang.addBlock(getVariant("%sraw".formatted(variantPrefix)), baseName, "Raw");
        lang.addBlock(getVariant("%sroad".formatted(variantPrefix)), baseName, "Road");
        lang.addBlock(getVariant("%sslanted".formatted(variantPrefix)), baseName, "Slanted");
        lang.addBlock(getVariant("%stiles".formatted(variantPrefix)), baseName, "Tiles");
        lang.addBlock(getVariant("%stiles_large".formatted(variantPrefix)), baseName, "Large Tiles");
        lang.addBlock(getVariant("%stiles_small".formatted(variantPrefix)), baseName, "Small Tiles");
        lang.addBlock(getVariant("%stwisted".formatted(variantPrefix)), baseName, "Twisted");
        lang.addBlock(getVariant("%sweaver".formatted(variantPrefix)), baseName, "Weaver");
        lang.addBlock(getVariant("%szag".formatted(variantPrefix)), baseName, "Zag");
    }
}
