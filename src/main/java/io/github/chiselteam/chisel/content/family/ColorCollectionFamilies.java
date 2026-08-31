package io.github.chiselteam.chisel.content.family;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.block.ChiselStainedGlassPaneBlock;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class ColorCollectionFamilies {
    public static final List<ChiselFamily> WOOLS = new ArrayList<>();
    public static final List<ChiselFamily> CONCRETE = new ArrayList<>();
    public static final List<ChiselFamily> STAINED_GLASS = new ArrayList<>();
    public static final List<ChiselFamily> STAINED_GLASS_PANE = new ArrayList<>();

    private static final List<ChiselFamily> FAMILIES = new ArrayList<>();

    static {
        for (DyeColor color : DyeColor.values()) {
            String colorName = org.apache.commons.lang3.StringUtils.capitalize(color.getName().replace("_", " "));
            String legacyColorName = org.apache.commons.lang3.StringUtils.capitalize(color.getName());
            String woolName = "wool_%s".formatted(color.getName());
            String concreteName = "concrete_%s".formatted(color.getName());
            String baseName = "%s Concrete".formatted(legacyColorName);

            WOOLS.add(add(ChiselFamily.build(woolName, builder -> builder
                    .properties(BlockBehaviour.Properties.ofFullCopy(getVanillaWool(color)))
                    .addVariant(getVanillaWool(color))
                    .addVariant("%s_legacy".formatted(woolName), ChiselModelHandlers.CONNECTED).translation("%s_legacy".formatted(woolName), "%s Wool".formatted(legacyColorName), "Legacy")
                    .addVariant("%s_llama".formatted(woolName), ChiselModelHandlers.CONNECTED).translation("%s_llama".formatted(woolName), "%s Wool".formatted(legacyColorName), "Llama")
            )));
            CONCRETE.add(add(ChiselFamily.build(concreteName, builder -> builder
                    .properties(BlockBehaviour.Properties.ofFullCopy(getVanillaConcrete(color)))
                    .addVariant(getVanillaConcrete(color))
                    .addVariant("%s_array".formatted(concreteName), ChiselModelHandlers.MULTIBLOCK_2X2).translation("%s_array".formatted(concreteName), baseName, "Array")
                    .addVariant("%s_braid".formatted(concreteName)).translation("%s_braid".formatted(concreteName), baseName, "Braid")
                    .addVariant("%s_bricks_indent".formatted(concreteName)).translation("%s_bricks_indent".formatted(concreteName), baseName, "Indent Bricks")
                    .addVariant("%s_bricks_inlayed".formatted(concreteName)).translation("%s_bricks_inlayed".formatted(concreteName), baseName, "Inlayed Bricks")
                    .addVariant("%s_bricks_large".formatted(concreteName), ChiselModelHandlers.MULTIBLOCK_2X2).translation("%s_bricks_large".formatted(concreteName), baseName, "Large Bricks")
                    .addVariant("%s_bricks_vertical".formatted(concreteName)).translation("%s_bricks_vertical".formatted(concreteName), baseName, "Vertical Bricks")
                    .addVariant("%s_chaotic".formatted(concreteName), ChiselModelHandlers.MULTIBLOCK_3X3).translation("%s_chaotic".formatted(concreteName), baseName, "Chaotic")
                    .addVariant("%s_chaotic_medium".formatted(concreteName)).translation("%s_chaotic_medium".formatted(concreteName), baseName, "Chaotic Medium")
                    .addVariant("%s_chaotic_small".formatted(concreteName)).translation("%s_chaotic_small".formatted(concreteName), baseName, "Chaotic Small")
                    .addVariant("%s_checker".formatted(concreteName)).translation("%s_checker".formatted(concreteName), baseName, "Checker")
                    .addVariant("%s_checker_small".formatted(concreteName)).translation("%s_checker_small".formatted(concreteName), baseName, "Small Checker")
                    .addVariant("%s_circular".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_circular".formatted(concreteName), baseName, "Circular")
                    .addVariant("%s_cobble".formatted(concreteName)).translation("%s_cobble".formatted(concreteName), baseName, "Cobble")
                    .addVariant("%s_bricks_cracked".formatted(concreteName)).translation("%s_bricks_cracked".formatted(concreteName), baseName, "Cracked Bricks")
                    .addVariant("%s_cuts".formatted(concreteName), ChiselModelHandlers.MULTIBLOCK_4X4).translation("%s_cuts".formatted(concreteName), baseName, "Cuts")
                    .addVariant("%s_dent".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_dent".formatted(concreteName), baseName, "Dent")
                    .addVariant("%s_bricks_encased".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_bricks_encased".formatted(concreteName), baseName, "Encased Bricks")
                    .addVariant("%s_french_1".formatted(concreteName)).translation("%s_french_1".formatted(concreteName), baseName, "French 1")
                    .addVariant("%s_french_2".formatted(concreteName)).translation("%s_french_2".formatted(concreteName), baseName, "French 2")
                    .addVariant("%s_indent".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_indent".formatted(concreteName), baseName, "Indent")
                    .addVariant("%s_jellybean".formatted(concreteName), ChiselModelHandlers.MULTIBLOCK_2X2).translation("%s_jellybean".formatted(concreteName), baseName, "Jellybean")
                    .addVariant("%s_layers".formatted(concreteName)).translation("%s_layers".formatted(concreteName), baseName, "Layers")
                    .addVariant("%s_line_horizontal".formatted(concreteName)).translation("%s_line_horizontal".formatted(concreteName), baseName, "Horizontal Line")
                    .addVariant("%s_line_vertical".formatted(concreteName)).translation("%s_line_vertical".formatted(concreteName), baseName, "Vertical Line")
                    .addVariant("%s_meander_horizontal".formatted(concreteName), ChiselModelHandlers.CTMH).translation("%s_meander_horizontal".formatted(concreteName), baseName, "Horizontal Meander")
                    .addVariant("%s_meander_vertical".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_meander_vertical".formatted(concreteName), baseName, "Vertical Meander")
                    .addVariant("%s_mosaic".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_mosaic".formatted(concreteName), baseName, "Mosaic")
                    .addVariant("%s_ornate_small".formatted(concreteName)).translation("%s_ornate_small".formatted(concreteName), baseName, "Small Ornate")
                    .addVariant("%s_panel".formatted(concreteName)).translation("%s_panel".formatted(concreteName), baseName, "Panel")
                    .addVariant("%s_pillar".formatted(concreteName), ChiselModelHandlers.TBS).translation("%s_pillar".formatted(concreteName), baseName, "Pillar")
                    .addVariant("%s_pillar_basic".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_basic".formatted(concreteName), baseName, "Basic Pillar")
                    .addVariant("%s_pillar_basic_dent".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_basic_dent".formatted(concreteName), baseName, "Basic Dent Pillar")
                    .addVariant("%s_pillar_basic_plain".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_basic_plain".formatted(concreteName), baseName, "Basic Plain Pillar")
                    .addVariant("%s_pillar_basic_round".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_basic_round".formatted(concreteName), baseName, "Basic Round Pillar")
                    .addVariant("%s_pillar_basic_spiral".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_basic_spiral".formatted(concreteName), baseName, "Basic Spiral Pillar")
                    .addVariant("%s_pillar_classic".formatted(concreteName), ChiselModelHandlers.TBS).translation("%s_pillar_classic".formatted(concreteName), baseName, "Classic Pillar")
                    .addVariant("%s_pillar_classic_large".formatted(concreteName), ChiselModelHandlers.TBS).translation("%s_pillar_classic_large".formatted(concreteName), baseName, "Large Classic Pillar")
                    .addVariant("%s_pillar_ionic".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_ionic".formatted(concreteName), baseName, "Ionic Pillar")
                    .addVariant("%s_pillar_ionic_dent".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_ionic_dent".formatted(concreteName), baseName, "Ionic Dent Pillar")
                    .addVariant("%s_pillar_ionic_plain".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_ionic_plain".formatted(concreteName), baseName, "Ionic Plain Pillar")
                    .addVariant("%s_pillar_ionic_round".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_ionic_round".formatted(concreteName), baseName, "Ionic Round Pillar")
                    .addVariant("%s_pillar_ionic_spiral".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_ionic_spiral".formatted(concreteName), baseName, "Ionic Spiral Pillar")
                    .addVariant("%s_pillar_large_basic_triple".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_large_basic_triple".formatted(concreteName), baseName, "Large Basic Triple Pillar")
                    .addVariant("%s_pillar_large_ionic_triple".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_large_ionic_triple".formatted(concreteName), baseName, "Large Ionic Triple Pillar")
                    .addVariant("%s_pillar_meander".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_meander".formatted(concreteName), baseName, "Meander Pillar")
                    .addVariant("%s_pillar_meander_dent".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_meander_dent".formatted(concreteName), baseName, "Meander Dent Pillar")
                    .addVariant("%s_pillar_meander_plain".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_meander_plain".formatted(concreteName), baseName, "Meander Plain Pillar")
                    .addVariant("%s_pillar_meander_round".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_meander_round".formatted(concreteName), baseName, "Meander Round Pillar")
                    .addVariant("%s_pillar_meander_spiral".formatted(concreteName), ChiselModelHandlers.CTMV).translation("%s_pillar_meander_spiral".formatted(concreteName), baseName, "Meander Spiral Pillar")
                    .addVariant("%s_plate".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_plate".formatted(concreteName), baseName, "Plate")
                    .addVariant("%s_polished".formatted(concreteName)).translation("%s_polished".formatted(concreteName), baseName, "Polished")
                    .addVariant("%s_prism".formatted(concreteName)).translation("%s_prism".formatted(concreteName), baseName, "Prismatic")
                    .addVariant("%s_raw".formatted(concreteName)).translation("%s_raw".formatted(concreteName), baseName, "Raw")
                    .addVariant("%s_road".formatted(concreteName)).translation("%s_road".formatted(concreteName), baseName, "Road")
                    .addVariant("%s_slanted".formatted(concreteName), ChiselModelHandlers.MULTIBLOCK_2X2).translation("%s_slanted".formatted(concreteName), baseName, "Slanted")
                    .addVariant("%s_bricks_small".formatted(concreteName)).translation("%s_bricks_small".formatted(concreteName), baseName, "Small Bricks")
                    .addVariant("%s_bricks_soft".formatted(concreteName)).translation("%s_bricks_soft".formatted(concreteName), baseName, "Soft Bricks")
                    .addVariant("%s_bricks_solid".formatted(concreteName)).translation("%s_bricks_solid".formatted(concreteName), baseName, "Solid Bricks")
                    .addVariant("%s_border_square".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_border_square".formatted(concreteName), baseName, "Square Border")
                    .addVariant("%s_tiles_large".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_tiles_large".formatted(concreteName), baseName, "Large Tiles")
                    .addVariant("%s_tiles".formatted(concreteName)).translation("%s_tiles".formatted(concreteName), baseName, "Tiles")
                    .addVariant("%s_tiles_small".formatted(concreteName)).translation("%s_tiles_small".formatted(concreteName), baseName, "Small Tiles")
                    .addVariant("%s_bricks_triple".formatted(concreteName)).translation("%s_bricks_triple".formatted(concreteName), baseName, "Triple Bricks")
                    .addVariant("%s_twisted".formatted(concreteName), ChiselModelHandlers.TBS).translation("%s_twisted".formatted(concreteName), baseName, "Twisted")
                    .addVariant("%s_weaver".formatted(concreteName), ChiselModelHandlers.CONNECTED).translation("%s_weaver".formatted(concreteName), baseName, "Weaver")
                    .addVariant("%s_zag".formatted(concreteName), ChiselModelHandlers.MULTIBLOCK_2X2).translation("%s_zag".formatted(concreteName), baseName, "Zag")
            )));
            STAINED_GLASS.add(add(ChiselFamily.build("stained_glass_%s".formatted(color.getName()), builder -> builder
                    .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
                    .addVariant(getVanillaStainedGlass(color))
                    .addVariant("stained_glass_%s_borderless".formatted(color.getName())).translation("stained_glass_%s_borderless".formatted(color.getName()), "%s Stained Glass".formatted(colorName), "%s Borderless Glass".formatted(colorName))
                    .addVariant("stained_glass_%s_bubble".formatted(color.getName())).translation("stained_glass_%s_bubble".formatted(color.getName()), "%s Stained Glass".formatted(colorName), "%s Bubble Glass".formatted(colorName))
                    .addVariant("stained_glass_%s_panel".formatted(color.getName())).translation("stained_glass_%s_panel".formatted(color.getName()), "%s Stained Glass".formatted(colorName), "%s Glass Panel".formatted(colorName))
                    .addVariant("stained_glass_%s_panel_fancy".formatted(color.getName())).translation("stained_glass_%s_panel_fancy".formatted(color.getName()), "%s Stained Glass".formatted(colorName), "%s Fancy Glass Panel".formatted(colorName))
            )));
            STAINED_GLASS_PANE.add(add(ChiselFamily.build("stained_glass_pane_%s".formatted(color), builder -> builder
                    .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE))
                    .addVariant(getVanillaStainedGlassPane(color))
                    .addVariant("stained_glass_pane_%s_borderless".formatted(color), p -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_borderless".formatted(color))))), ChiselModelHandlers.GLASS_PANE).translation("stained_glass_pane_%s_borderless".formatted(color), "%s Stained Glass Pane".formatted(colorName), "%s Borderless Glass Pane".formatted(colorName))
                    .addVariant("stained_glass_pane_%s_bubble".formatted(color), p -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_bubble".formatted(color))))), ChiselModelHandlers.GLASS_PANE).translation("stained_glass_pane_%s_bubble".formatted(color), "%s Stained Glass Pane".formatted(colorName), "%s Bubble Glass Pane".formatted(colorName))
                    .addVariant("stained_glass_pane_%s_panel".formatted(color), p -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_panel".formatted(color))))), ChiselModelHandlers.GLASS_PANE).translation("stained_glass_pane_%s_panel".formatted(color), "%s Stained Glass Pane".formatted(colorName), "%s Glass Panel Pane".formatted(colorName))
                    .addVariant("stained_glass_pane_%s_quad".formatted(color), p -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_quad".formatted(color))))), ChiselModelHandlers.GLASS_PANE).translation("stained_glass_pane_%s_quad".formatted(color), "%s Stained Glass Pane".formatted(colorName), "%s Glass Quad Pane".formatted(colorName))
                    .addVariant("stained_glass_pane_%s_fancy".formatted(color), p -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_fancy".formatted(color))))), ChiselModelHandlers.GLASS_PANE).translation("stained_glass_pane_%s_fancy".formatted(color), "%s Stained Glass Pane".formatted(colorName), "%s Fancy Glass Panel Pane".formatted(colorName))
            )));
        }
    }

    private ColorCollectionFamilies() {
    }

    public static List<ChiselFamily> families() {
        return List.copyOf(FAMILIES);
    }

    private static Block getVanillaWool(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_WOOL;
            case ORANGE -> Blocks.ORANGE_WOOL;
            case MAGENTA -> Blocks.MAGENTA_WOOL;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_WOOL;
            case YELLOW -> Blocks.YELLOW_WOOL;
            case LIME -> Blocks.LIME_WOOL;
            case PINK -> Blocks.PINK_WOOL;
            case GRAY -> Blocks.GRAY_WOOL;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_WOOL;
            case CYAN -> Blocks.CYAN_WOOL;
            case PURPLE -> Blocks.PURPLE_WOOL;
            case BLUE -> Blocks.BLUE_WOOL;
            case BROWN -> Blocks.BROWN_WOOL;
            case GREEN -> Blocks.GREEN_WOOL;
            case RED -> Blocks.RED_WOOL;
            case BLACK -> Blocks.BLACK_WOOL;
        };
    }

    private static Block getVanillaStainedGlass(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_STAINED_GLASS;
            case ORANGE -> Blocks.ORANGE_STAINED_GLASS;
            case MAGENTA -> Blocks.MAGENTA_STAINED_GLASS;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_STAINED_GLASS;
            case YELLOW -> Blocks.YELLOW_STAINED_GLASS;
            case LIME -> Blocks.LIME_STAINED_GLASS;
            case PINK -> Blocks.PINK_STAINED_GLASS;
            case GRAY -> Blocks.GRAY_STAINED_GLASS;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_STAINED_GLASS;
            case CYAN -> Blocks.CYAN_STAINED_GLASS;
            case PURPLE -> Blocks.PURPLE_STAINED_GLASS;
            case BLUE -> Blocks.BLUE_STAINED_GLASS;
            case BROWN -> Blocks.BROWN_STAINED_GLASS;
            case GREEN -> Blocks.GREEN_STAINED_GLASS;
            case RED -> Blocks.RED_STAINED_GLASS;
            case BLACK -> Blocks.BLACK_STAINED_GLASS;
        };
    }

    private static Block getVanillaStainedGlassPane(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_STAINED_GLASS_PANE;
            case ORANGE -> Blocks.ORANGE_STAINED_GLASS_PANE;
            case MAGENTA -> Blocks.MAGENTA_STAINED_GLASS_PANE;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_STAINED_GLASS_PANE;
            case YELLOW -> Blocks.YELLOW_STAINED_GLASS_PANE;
            case LIME -> Blocks.LIME_STAINED_GLASS_PANE;
            case PINK -> Blocks.PINK_STAINED_GLASS_PANE;
            case GRAY -> Blocks.GRAY_STAINED_GLASS_PANE;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_STAINED_GLASS_PANE;
            case CYAN -> Blocks.CYAN_STAINED_GLASS_PANE;
            case PURPLE -> Blocks.PURPLE_STAINED_GLASS_PANE;
            case BLUE -> Blocks.BLUE_STAINED_GLASS_PANE;
            case BROWN -> Blocks.BROWN_STAINED_GLASS_PANE;
            case GREEN -> Blocks.GREEN_STAINED_GLASS_PANE;
            case RED -> Blocks.RED_STAINED_GLASS_PANE;
            case BLACK -> Blocks.BLACK_STAINED_GLASS_PANE;
        };
    }

    private static Block getVanillaConcrete(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_CONCRETE;
            case BLUE -> Blocks.BLUE_CONCRETE;
            case BROWN -> Blocks.BROWN_CONCRETE;
            case CYAN -> Blocks.CYAN_CONCRETE;
            case GRAY -> Blocks.GRAY_CONCRETE;
            case GREEN -> Blocks.GREEN_CONCRETE;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_CONCRETE;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_CONCRETE;
            case LIME -> Blocks.LIME_CONCRETE;
            case MAGENTA -> Blocks.MAGENTA_CONCRETE;
            case ORANGE -> Blocks.ORANGE_CONCRETE;
            case PINK -> Blocks.PINK_CONCRETE;
            case PURPLE -> Blocks.PURPLE_CONCRETE;
            case RED -> Blocks.RED_CONCRETE;
            case WHITE -> Blocks.WHITE_CONCRETE;
            case YELLOW -> Blocks.YELLOW_CONCRETE;
        };
    }

    private static ChiselFamily add(ChiselFamily family) {
        FAMILIES.add(family);
        return family;
    }
}
