package io.github.chiselteam.chisel.content;

import io.github.chiselteam.chisel.content.compat.*;
import io.github.chiselteam.chisel.content.family.*;
import io.github.chiselteam.chisel.family.VariantFamilyRegistrar;

import java.util.ArrayList;
import java.util.List;


public class ChiselFamilies {
    public static final ChiselFamily ACACIA = WoodFamilies.ACACIA;
    public static final ChiselFamily ALUMINUM = MetalFamilies.ALUMINUM;
    public static final ChiselFamily ANCIENT_STONE = StoneFamilies.ANCIENT_STONE;
    public static final ChiselFamily ANDESITE = StoneFamilies.ANDESITE;
    public static final ChiselFamily ANTIBLOCK = SpecialFamilies.ANTIBLOCK;
    public static final ChiselFamily FA_ARCANE_DARKSTONE = ForbiddenArcanusFamilies.FA_ARCANE_DARKSTONE;
    public static final ChiselFamily BAMBOO = WoodFamilies.BAMBOO;
    public static final ChiselFamily BIRCH = WoodFamilies.BIRCH;
    public static final ChiselFamily BLACKSTONE = StoneFamilies.BLACKSTONE;
    public static final ChiselFamily GILDED_BLACKSTONE = StoneFamilies.GILDED_BLACKSTONE;
    public static final ChiselFamily SEA_LANTERN = DecorativeFamilies.SEA_LANTERN;
    public static final ChiselFamily BOOKSHELF = SpecialFamilies.BOOKSHELF;
    public static final ChiselFamily BRICKS = StoneFamilies.BRICKS;
    public static final ChiselFamily BRONZE = MetalFamilies.BRONZE;
    public static final ChiselFamily AE2_CERTUS = AppliedEnergisticsFamilies.AE2_CERTUS;
    public static final ChiselFamily AE2_SKY_STONE = AppliedEnergisticsFamilies.AE2_SKY_STONE;
    public static final ChiselFamily CHARCOAL = DecorativeFamilies.CHARCOAL;
    public static final ChiselFamily CLOUD = DecorativeFamilies.CLOUD;
    public static final ChiselFamily COAL = DecorativeFamilies.COAL;
    public static final ChiselFamily COAL_COKE = DecorativeFamilies.COAL_COKE;
    public static final ChiselFamily COBALT = MetalFamilies.COBALT;
    public static final ChiselFamily COBBLESTONE = StoneFamilies.COBBLESTONE;
    public static final ChiselFamily C_CONCRETE = DecorativeFamilies.C_CONCRETE;
    public static final ChiselFamily COPPER = MetalFamilies.COPPER;
    public static final ChiselFamily EXPOSED_COPPER = MetalFamilies.EXPOSED_COPPER;
    public static final ChiselFamily WEATHERED_COPPER = MetalFamilies.WEATHERED_COPPER;
    public static final ChiselFamily OXIDIZED_COPPER = MetalFamilies.OXIDIZED_COPPER;
    public static final ChiselFamily CRIMSON = WoodFamilies.CRIMSON;
    public static final ChiselFamily WARPED = WoodFamilies.WARPED;
    public static final ChiselFamily DARK_OAK = WoodFamilies.DARK_OAK;
    public static final ChiselFamily CHERRY = WoodFamilies.CHERRY;
    public static final ChiselFamily BASALT = StoneFamilies.BASALT;
    public static final ChiselFamily DIAMOND = MetalFamilies.DIAMOND;
    public static final ChiselFamily DIORITE = StoneFamilies.DIORITE;
    public static final ChiselFamily DEEPSLATE = StoneFamilies.DEEPSLATE;
    public static final ChiselFamily DIRT = DecorativeFamilies.DIRT;
    public static final ChiselFamily ELECTRUM = MetalFamilies.ELECTRUM;
    public static final ChiselFamily EMERALD = MetalFamilies.EMERALD;
    public static final ChiselFamily END_STONE = StoneFamilies.END_STONE;
    public static final ChiselFamily ENERGIZED_VOIDSTONE = DecorativeFamilies.ENERGIZED_VOIDSTONE;
    public static final ChiselFamily FACTORY = DecorativeFamilies.FACTORY;
    public static final ChiselFamily FUTURA = DecorativeFamilies.FUTURA;
    public static final ChiselFamily GLASS = SpecialFamilies.GLASS;
    public static final ChiselFamily GLASS_PANE = SpecialFamilies.GLASS_PANE;
    public static final ChiselFamily GLOWSTONE = DecorativeFamilies.GLOWSTONE;
    public static final ChiselFamily GOLD = MetalFamilies.GOLD;
    public static final ChiselFamily GRANITE = StoneFamilies.GRANITE;
    public static final ChiselFamily GRIMSTONE = DecorativeFamilies.GRIMSTONE;
    public static final ChiselFamily HEX_PLATING = DecorativeFamilies.HEX_PLATING;
    public static final ChiselFamily HOLYSTONE = DecorativeFamilies.HOLYSTONE;
    public static final ChiselFamily ICE = DecorativeFamilies.ICE;
    public static final ChiselFamily INVAR = MetalFamilies.INVAR;
    public static final ChiselFamily IRON = MetalFamilies.IRON;
    public static final ChiselFamily IRON_BARS = SpecialFamilies.IRON_BARS;
    public static final ChiselFamily JACK_O_LANTERN = SpecialFamilies.JACK_O_LANTERN;
    public static final ChiselFamily JUNGLE = WoodFamilies.JUNGLE;
    public static final ChiselFamily MANGROVE = WoodFamilies.MANGROVE;
    public static final ChiselFamily LABORATORY = DecorativeFamilies.LABORATORY;
    public static final ChiselFamily LAPIS = MetalFamilies.LAPIS;
    public static final ChiselFamily LAVASTONE = DecorativeFamilies.LAVASTONE;
    public static final ChiselFamily LEAD = MetalFamilies.LEAD;
    public static final ChiselFamily LEAF = DecorativeFamilies.LEAF;
    public static final ChiselFamily LIMESTONE = StoneFamilies.LIMESTONE;
    public static final ChiselFamily MAGMA = DecorativeFamilies.MAGMA;
    public static final ChiselFamily MARBLE = StoneFamilies.MARBLE;
    public static final ChiselFamily MILITARY = DecorativeFamilies.MILITARY;
    public static final ChiselFamily MOSSY_COBBLESTONE = StoneFamilies.MOSSY_COBBLESTONE;
    public static final ChiselFamily MOSSY_BLACKSTONE = DecorativeFamilies.MOSSY_BLACKSTONE;
    public static final ChiselFamily MOSSY_TEMPLE = DecorativeFamilies.MOSSY_TEMPLE;
    public static final ChiselFamily NV_RUNE = NeoVitaeFamilies.NV_RUNE;
    public static final ChiselFamily NETHERBRICK = StoneFamilies.NETHERBRICK;
    public static final ChiselFamily NETHERRACK = StoneFamilies.NETHERRACK;
    public static final ChiselFamily NICKEL = MetalFamilies.NICKEL;
    public static final ChiselFamily OAK = WoodFamilies.OAK;
    public static final ChiselFamily PALE_OAK = WoodFamilies.PALE_OAK;
    public static final ChiselFamily OBSIDIAN = StoneFamilies.OBSIDIAN;
    public static final ChiselFamily PAPERWALL = DecorativeFamilies.PAPERWALL;
    public static final ChiselFamily PLATINUM = MetalFamilies.PLATINUM;
    public static final ChiselFamily QUARTZ = StoneFamilies.QUARTZ;
    public static final ChiselFamily PRISMARINE = StoneFamilies.PRISMARINE;
    public static final ChiselFamily PUMPKIN = SpecialFamilies.PUMPKIN;
    public static final ChiselFamily PURPUR = StoneFamilies.PURPUR;
    public static final ChiselFamily RED_SANDSTONE = StoneFamilies.RED_SANDSTONE;
    public static final ChiselFamily REDSTONE = DecorativeFamilies.REDSTONE;
    public static final ChiselFamily REDSTONE_LAMP = SpecialFamilies.REDSTONE_LAMP;
    public static final ChiselFamily ROAD_LINE = SpecialFamilies.ROAD_LINE;
    public static final ChiselFamily SANDSTONE = StoneFamilies.SANDSTONE;
    public static final ChiselFamily SHINGLE = DecorativeFamilies.SHINGLE;
    public static final ChiselFamily SILVER = MetalFamilies.SILVER;
    public static final ChiselFamily SPRUCE = WoodFamilies.SPRUCE;
    public static final ChiselFamily STEEL = MetalFamilies.STEEL;
    public static final ChiselFamily STONE_BRICKS = StoneFamilies.STONE_BRICKS;
    public static final ChiselFamily OC_TALLOW = OccultismFamilies.OC_TALLOW;
    public static final ChiselFamily TECHNICAL = DecorativeFamilies.TECHNICAL;
    public static final ChiselFamily TEMPLE = DecorativeFamilies.TEMPLE;
    public static final ChiselFamily TERRACOTTA = DecorativeFamilies.TERRACOTTA;
    public static final ChiselFamily THAUMIUM = MetalFamilies.THAUMIUM;
    public static final ChiselFamily TIN = MetalFamilies.TIN;
    public static final ChiselFamily TORCH = SpecialFamilies.TORCH;
    public static final ChiselFamily TYRIAN = DecorativeFamilies.TYRIAN;
    public static final ChiselFamily URANIUM = MetalFamilies.URANIUM;
    public static final ChiselFamily VALENTINES = DecorativeFamilies.VALENTINES;
    public static final ChiselFamily VOIDSTONE = DecorativeFamilies.VOIDSTONE;
    public static final ChiselFamily WARNING = DecorativeFamilies.WARNING;
    public static final ChiselFamily WATERSTONE = DecorativeFamilies.WATERSTONE;
    public static final ChiselFamily WOOLEN_CLAY = DecorativeFamilies.WOOLEN_CLAY;
    public static final ChiselFamily TUFF = StoneFamilies.TUFF;
    public static final ChiselFamily CALCITE = StoneFamilies.CALCITE;
    public static final ChiselFamily NETHERITE = MetalFamilies.NETHERITE;
    public static final ChiselFamily DRIPSTONE = StoneFamilies.DRIPSTONE;
    public static final ChiselFamily MUD = StoneFamilies.MUD;
    public static final ChiselFamily RESIN = DecorativeFamilies.RESIN;

    public static final List<ChiselFamily> WOOLS = ColorCollectionFamilies.WOOLS;
    public static final List<ChiselFamily> CONCRETE = ColorCollectionFamilies.CONCRETE;
    public static final List<ChiselFamily> STAINED_GLASS = ColorCollectionFamilies.STAINED_GLASS;
    public static final List<ChiselFamily> STAINED_GLASS_PANE = ColorCollectionFamilies.STAINED_GLASS_PANE;

    private ChiselFamilies() {
    }

    public static void register() {
        WoodFamilies.families().forEach(VariantFamilyRegistrar::register);
        StoneFamilies.families().forEach(VariantFamilyRegistrar::register);
        MetalFamilies.families().forEach(VariantFamilyRegistrar::register);
        SpecialFamilies.families().forEach(VariantFamilyRegistrar::register);
        DecorativeFamilies.families().forEach(VariantFamilyRegistrar::register);
        ColorCollectionFamilies.families().forEach(VariantFamilyRegistrar::register);
        CompatFamilies.families().forEach(VariantFamilyRegistrar::register);
    }

    public static List<ChiselFamily> getFamilies() {
        var families = new ArrayList<>(WoodFamilies.families());
        families.addAll(StoneFamilies.families());
        families.addAll(MetalFamilies.families());
        families.addAll(SpecialFamilies.families());
        families.addAll(DecorativeFamilies.families());
        families.addAll(ColorCollectionFamilies.families());
        families.addAll(CompatFamilies.families());
        return List.copyOf(families);
    }

}
