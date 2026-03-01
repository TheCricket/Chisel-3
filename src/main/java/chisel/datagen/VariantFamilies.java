package chisel.datagen;

import chisel.api.VariantFamily;
import com.google.common.collect.Maps;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.stream.Stream;

public class VariantFamilies {

    private static final Map<Block, VariantFamily> families = Maps.newHashMap();

    public static final VariantFamily ACACIA = builder("acacia", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily ALUMINUM = builder("aluminum", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily ANDESITE = builder("andesite", Blocks.ANDESITE)
            .getFamily();
    public static final VariantFamily ANTIBLOCK = builder("antiblock", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily BIRCH = builder("birch", Blocks.BIRCH_PLANKS)
            .getFamily();
    public static final VariantFamily BOOKSHELF = builder("bookshelf", Blocks.BOOKSHELF)
            .getFamily();
    public static final VariantFamily BRONZE = builder("bronze", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily CARPET = builder("carpet", Blocks.BLACK_CARPET)
            .getFamily();
    public static final VariantFamily CARPET_FLOOR = builder("carpet_floor", Blocks.BLACK_CARPET)
            .getFamily();
    public static final VariantFamily CLOUD = builder("cloud", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily COBBLESTONE = builder("cobblestone", Blocks.COBBLESTONE)
            .getFamily();
    public static final VariantFamily CONCRETE = builder("concrete", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily COPPER = builder("copper", Blocks.COPPER_BLOCK)
            .getFamily();
    public static final VariantFamily DARK_OAK = builder("dark_oak", Blocks.DARK_OAK_PLANKS)
            .getFamily();
    public static final VariantFamily DIAMOND = builder("diamond", Blocks.DIAMOND_BLOCK)
            .getFamily();
    public static final VariantFamily DIORITE = builder("diorite", Blocks.DIORITE)
            .getFamily();
    public static final VariantFamily DIRT = builder("dirt", Blocks.DIRT)
            .getFamily();
    public static final VariantFamily EMERALD = builder("emerald", Blocks.EMERALD_BLOCK)
            .getFamily();
    public static final VariantFamily ENERGIZED_VOIDSTONE = builder("energized_voidstone", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily ENERGIZED_VOIDSTONE_PILLAR = builder("energized_voidstone_pillar", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily FACTORY = builder("factory", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily FANTASY = builder("fantasy", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily FUTURA = builder("futura", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily GLASS = builder("glass", Blocks.GLASS)
            .getFamily();
    public static final VariantFamily GLASS_PANE = builder("glass_pane", Blocks.GLASS_PANE)
            .getFamily();
    public static final VariantFamily GLOWSTONE = builder("glowstone", Blocks.GLOWSTONE)
            .getFamily();
    public static final VariantFamily GOLD = builder("gold", Blocks.GOLD_BLOCK)
            .getFamily();
    public static final VariantFamily GRANITE = builder("granite", Blocks.GRANITE)
            .getFamily();
    public static final VariantFamily GRIMSTONE = builder("grimstone", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily HEX_PLATING = builder("hex_plating", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily HOLYSTONE = builder("holystone", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily ICE = builder("ice", Blocks.ICE)
            .getFamily();
    public static final VariantFamily ICE_PILLAR = builder("ice_pillar", Blocks.ICE)
            .getFamily();
    public static final VariantFamily IRON = builder("iron", Blocks.IRON_BLOCK)
            .getFamily();
    public static final VariantFamily IRON_BARS = builder("iron_bars", Blocks.IRON_BARS)
            .getFamily();
    public static final VariantFamily JUNGLE = builder("jungle", Blocks.JUNGLE_PLANKS)
            .getFamily();
    public static final VariantFamily LABORATORY = builder("laboratory", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily LAPIS = builder("lapis", Blocks.LAPIS_BLOCK)
            .getFamily();
    public static final VariantFamily LARGE_HEX_PLATING = builder("large_hex_plating", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily LAVASTONE = builder("lavastone", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily LEAD = builder("lead", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily LEAF = builder("leaf", Blocks.OAK_LEAVES)
            .getFamily();
    public static final VariantFamily LIMESTONE = builder("limestone", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily LIT_PUMPKIN = builder("lit_pumpkin", Blocks.JACK_O_LANTERN)
            .getFamily();
    public static final VariantFamily MARBLE = builder("marble", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily MOSSY_COBBLESTONE = builder("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE)
            .getFamily();
    public static final VariantFamily MOSSY_TEMPLE = builder("mossy_temple", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily NETHERBRICK = builder("netherbrick", Blocks.NETHER_BRICKS)
            .getFamily();
    public static final VariantFamily NETHERRACK = builder("netherrack", Blocks.NETHERRACK)
            .getFamily();
    public static final VariantFamily OAK = builder("oak", Blocks.OAK_PLANKS)
            .getFamily();
    public static final VariantFamily OBSIDIAN = builder("obsidian", Blocks.OBSIDIAN)
            .getFamily();
    public static final VariantFamily PACKED_ICE = builder("packed_ice", Blocks.PACKED_ICE)
            .getFamily();
    public static final VariantFamily PACKED_ICE_PILLAR = builder("packed_ice_pillar", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily PAPERWALL = builder("paperwall", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily PAPERWALL_BLOCK = builder("paperwall_block", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily PUMPKIN = builder("pumpkin", Blocks.CARVED_PUMPKIN)
            .getFamily();
    public static final VariantFamily PURPLED_FANTASY = builder("purpled_fantasy", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily REDSTONE = builder("redstone", Blocks.REDSTONE_BLOCK)
            .getFamily();
    public static final VariantFamily ROAD_LINE = builder("road_line", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily RUNIC_VOIDSTONE = builder("runic_voidstone", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily SANDSTONE = builder("sandstone", Blocks.SANDSTONE)
            .getFamily();
    public static final VariantFamily SPRUCE = builder("spruce", Blocks.SPRUCE_PLANKS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_BLACK = builder("stained_glass_black", Blocks.BLACK_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_BLUE = builder("stained_glass_blue", Blocks.BLUE_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_BROWN = builder("stained_glass_brown", Blocks.BROWN_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_CYAN = builder("stained_glass_cyan", Blocks.CYAN_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_GRAY = builder("stained_glass_gray", Blocks.GRAY_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_GREEN = builder("stained_glass_green", Blocks.GREEN_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_LIGHT_BLUE = builder("stained_glass_light_blue", Blocks.LIGHT_BLUE_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_LIGHT_GRAY = builder("stained_glass_light_gray", Blocks.LIGHT_GRAY_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_LIME = builder("stained_glass_lime", Blocks.LIME_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_MAGENTA = builder("stained_glass_magenta", Blocks.MAGENTA_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_ORANGE = builder("stained_glass_orange", Blocks.ORANGE_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PINK = builder("stained_glass_pink", Blocks.PINK_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PURPLE = builder("stained_glass_purple", Blocks.PURPLE_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_RED = builder("stained_glass_red", Blocks.RED_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_WHITE = builder("stained_glass_white", Blocks.WHITE_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_YELLOW = builder("stained_glass_yellow", Blocks.YELLOW_STAINED_GLASS)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_BLACK = builder("stained_glass_pane_black", Blocks.BLACK_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_BLUE = builder("stained_glass_pane_blue", Blocks.BLUE_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_BROWN = builder("stained_glass_pane_brown", Blocks.BROWN_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_CYAN = builder("stained_glass_pane_cyan", Blocks.CYAN_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_GRAY = builder("stained_glass_pane_gray", Blocks.GRAY_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_GREEN = builder("stained_glass_pane_green", Blocks.GREEN_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_LIGHT_BLUE = builder("stained_glass_pane_light_blue", Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_LIGHT_GRAY = builder("stained_glass_pane_light_gray", Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_LIME = builder("stained_glass_pane_lime", Blocks.LIME_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_MAGENTA = builder("stained_glass_pane_magenta", Blocks.MAGENTA_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_ORANGE = builder("stained_glass_pane_orange", Blocks.ORANGE_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_PINK = builder("stained_glass_pane_pink", Blocks.PINK_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_PURPLE = builder("stained_glass_pane_purple", Blocks.PURPLE_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_RED = builder("stained_glass_pane_red", Blocks.RED_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_WHITE = builder("stained_glass_pane_white", Blocks.WHITE_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STAINED_GLASS_PANE_YELLOW = builder("stained_glass_pane_yellow", Blocks.YELLOW_STAINED_GLASS_PANE)
            .getFamily();
    public static final VariantFamily STEEL = builder("steel", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily STONE_BRICKS = builder("stone_bricks", Blocks.STONE_BRICKS)
            .getFamily();
    public static final VariantFamily TECHNICAL = builder("technical", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily TEMPLE = builder("temple", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily TIN = builder("tin", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily TORCH = builder("torch", Blocks.TORCH)
            .getFamily();
    public static final VariantFamily TYRIAN = builder("tyrian", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily URANIUM = builder("uranium", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily VALENTINES = builder("valentines", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily VOIDSTONE = builder("voidstone", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily WARNING = builder("warning", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily WATERSTONE = builder("waterstone", Blocks.ACACIA_PLANKS)
            .getFamily();
    public static final VariantFamily WOOLEN_CLAY = builder("woolen_clay", Blocks.ACACIA_PLANKS)
            .getFamily();

    private static VariantFamily.Builder builder(String name, Block base) {
        VariantFamily.Builder builder = new VariantFamily.Builder(name, base);
        VariantFamily family = families.put(base, builder.getFamily());

        if (family != null) {
            throw new IllegalStateException("Duplicate family: " + name);
        } else {
            return builder;
        }
    }

    public static Stream<VariantFamily> getAllFamilies() {
        return families.values().stream();
    }

    @Nullable
    public static VariantFamily getFamily(Block block) {
        return families.get(block);
    }
}
