package com.cricketcraft.chisel.api;

import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.PropertyVariant;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.cricketcraft.chisel.init.ChiselBlocks.*;
import static com.cricketcraft.chisel.init.ChiselProperties.*;

public class CarvingRegistry {

    private static final CarvingRegistry instance = new CarvingRegistry();
    private static final List<ICarvingRecipe> recipes = Lists.<ICarvingRecipe>newArrayList();

    public static CarvingRegistry getInstance() {
        return instance;
    }

    private CarvingRegistry() {

    }

    public static void preInit() {
        //Load the class
    }

    /**
     * For internal use only
     */
    public static void init() {
        addRecipeForPropVariant(acacia, ACACIA_VARIANTS, new ItemStack(Blocks.PLANKS, 1, 4));
        addRecipeForPropVariant(aluminum, ALUMINUM_VARIANTS);
        addRecipeForPropVariant(andesite, ANDESITE_VARIANTS, new ItemStack(Blocks.STONE, 1, 5), new ItemStack(Blocks.STONE, 1, 6));
        addRecipeForPropVariant(antiblock, ANTIBLOCK_VARIANTS);
        addRecipeForPropVariant(birch, BIRCH_VARIANTS, new ItemStack(Blocks.PLANKS, 1, 2));
        addRecipeForPropVariant(bronze, BRONZE_VARIANTS, OreDictionary.getOres("blockBronze"));
        addRecipeForPropVariant(bricks, BRICKS_VARIANTS, new ItemStack(Blocks.BRICK_BLOCK, 1));
        addRecipeForPropVariant(bookshelf, BOOKSHELF_VARIANTS, new ItemStack(Blocks.BOOKSHELF));
        addRecipeForPropVariant(carpet, CARPET_VARIANTS);
        addRecipeForPropVariant(carpet_floor, CARPET_FLOOR_VARIANTS);
        addRecipeForPropVariant(cobblestone, COBBLESTONE_VARIANTS, OreDictionary.getOres("cobblestone"));
        addRecipeForPropVariant(concrete, CONCRETE_VARIANTS);
        addRecipeForPropVariant(copper, COPPER_VARIANTS, OreDictionary.getOres("blockCopper"));
        addRecipeForPropVariant(cloud, CLOUD_VARIANTS);
        addRecipeForPropVariant(dark_oak, DARK_OAK_VARIANTS, new ItemStack(Blocks.PLANKS, 1, 5));
        addRecipeForPropVariant(diamond, DIAMOND_VARIANTS , OreDictionary.getOres("blockDiamond"));
        addRecipeForPropVariant(diorite, DIORITE_VARIANTS, new ItemStack(Blocks.STONE, 1, 3), new ItemStack(Blocks.STONE, 1, 4));
        addRecipeForPropVariant(dirt, DIRT_VARIANTS);
        addRecipeForPropVariant(emerald, EMERALD_VARIANTS, OreDictionary.getOres("blockEmerald"));
        addRecipeForPropVariant(energised_voidstone, ENERGISED_VOIDSTONE_VARIANTS);
        addRecipeForPropVariant(energised_voidstone_pillar, ENERGISED_VOIDSTONE_PILLAR_VARIANTS);
        addRecipeForPropVariant(factory, FACTORY_VARIANTS);
        addRecipeForPropVariant(fantasy, FANTASY_VARIANTS);
        addRecipeForPropVariant(futura, FUTURA_VARIANTS);
        addRecipeForPropVariant(glass, GLASS_VARIANTS, OreDictionary.getOres("blockGlassColorless"));
        addRecipeForPropVariant(glass_pane, GLASS_PANE_VARIANTS, OreDictionary.getOres("paneGlassColorless"));
        addRecipeForPropVariant(glowstone, GLOWSTONE_VARIANTS, OreDictionary.getOres("glowstone"));
        addRecipeForPropVariant(gold, GOLD_VARIANTS, OreDictionary.getOres("blockGold"));
        addRecipeForPropVariant(gold, GOLD2_VARIANTS);
        addRecipeForPropVariant(granite, GRANITE_VARIANTS, new ItemStack(Blocks.STONE, 1, 1), new ItemStack(Blocks.STONE, 1, 2));
        addRecipeForPropVariant(grimstone, GRIMSTONE_VARIANTS);
        addRecipeForPropVariant(hex_plating, HEX_PLATING_VARIANTS);
        addRecipeForPropVariant(holystone, HOLYSTONE_VARIANTS);
        addRecipeForPropVariant(ice, ICE_VARIANTS);
        addRecipeForPropVariant(ice_pillar, ICE_PILLAR_VARIANTS);
        addRecipeForPropVariant(iron, IRON_VARIANTS, OreDictionary.getOres("blockIron"));
        addRecipeForPropVariant(iron_bars, IRON_BARS_VARIANTS, new ItemStack(Blocks.IRON_BARS, 1));
        addRecipeForPropVariant(jungle, JUNGLE_VARIANTS, new ItemStack(Blocks.PLANKS, 1, 3));
        addRecipeForPropVariant(laboratory, LABORATORY_VARIANTS);
        addRecipeForPropVariant(lapis, LAPIS_VARIANTS, OreDictionary.getOres("blockLapis"));
        addRecipeForPropVariant(large_hex_plating, LARGE_HEX_PLATING_VARIANTS);
        addRecipeForPropVariant(lavastone, LAVASTONE_VARIANTS);
        addRecipeForPropVariant(lead, LEAD_VARIANTS, OreDictionary.getOres("blockLead"));
        addRecipeForPropVariant(leaf, LEAF_VARIANTS, OreDictionary.getOres("treeLeaves"));
        addRecipeForPropVariant(limestone, LIMESTONE_VARIANTS);
        addRecipeForPropVariant(litpumpkin, LITPUMPKIN_VARIANTS, new ItemStack(Blocks.LIT_PUMPKIN, 1));
        addRecipeForPropVariant(marble, MARBLE_VARIANTS);
        addRecipeForPropVariant(mossy_cobblestone, MOSSY_COBBLESTONE_VARIANTS, new ItemStack(Blocks.MOSSY_COBBLESTONE, 1));
        addRecipeForPropVariant(mossy_temple, MOSSY_TEMPLE_VARIANTS);
        addRecipeForPropVariant(netherbrick, NETHERBRICK_VARIANTS);
        addRecipeForPropVariant(netherrack, NETHERRACK_VARIANTS);
        addRecipeForPropVariant(oak, OAK_VARIANTS, new ItemStack(Blocks.PLANKS, 1));
        addRecipeForPropVariant(obsidian, OBSIDIAN_VARIANTS, new ItemStack(Blocks.OBSIDIAN, 1));
        addRecipeForPropVariant(packed_ice, PACKED_ICE_VARIANTS, new ItemStack(Blocks.PACKED_ICE, 1));
        addRecipeForPropVariant(packed_ice_pillar, PACKED_ICE_PILLAR_VARIANTS);
        addRecipeForPropVariant(paperwall, PAPERWALL_VARIANTS);
        addRecipeForPropVariant(paperwall_block, PAPERWALL_BLOCK_VARIANTS);
        addRecipeForPropVariant(pumpkin, PUMPKIN_VARIANTS, new ItemStack(Blocks.PUMPKIN, 1));
        addRecipeForPropVariant(purpled_fantasy, PURPLED_FANTASY_VARIANTS);
        addRecipeForPropVariant(redstone, REDSTONE_VARIANTS, new ItemStack(Blocks.REDSTONE_BLOCK, 1));
        addRecipeForPropVariant(road_line, ROAD_LINE_VARIANTS);
        addRecipeForPropVariant(runic_voidstone, RUNIC_VOIDSTONE_VARIANTS);
        addRecipeForPropVariant(sandstone, SANDSTONE_VARIANTS, new ItemStack(Blocks.SANDSTONE));
        addRecipeForPropVariant(sandstone, SANDSTONE_SCRIBBLES_VARIANTS);
        addRecipeForPropVariant(silver, SILVER_VARIANTS, OreDictionary.getOres("blockSilver"));
        addRecipeForPropVariant(snakestone_sand, SNAKESTONE_SAND_VARIANTS);
        addRecipeForPropVariant(snakestone_stone, SNAKESTONE_STONE_VARIANTS);
        addRecipeForPropVariant(spruce, SPRUCE_VARIANTS, new ItemStack(Blocks.PLANKS, 1, 1));
        addRecipeForPropVariant(stained_glass_black, STAINED_GLASS_BLACK_VARIANTS);
        addRecipeForPropVariant(stained_glass_red, STAINED_GLASS_RED_VARIANTS);
        addRecipeForPropVariant(stained_glass_green, STAINED_GLASS_GREEN_VARIANTS);
        addRecipeForPropVariant(stained_glass_brown, STAINED_GLASS_BROWN_VARIANTS);
        addRecipeForPropVariant(stained_glass_blue, STAINED_GLASS_BLUE_VARIANTS);
        addRecipeForPropVariant(stained_glass_purple, STAINED_GLASS_PURPLE_VARIANTS);
        addRecipeForPropVariant(stained_glass_cyan, STAINED_GLASS_CYAN_VARIANTS);
        addRecipeForPropVariant(stained_glass_light_gray, STAINED_GLASS_LIGHT_GRAY_VARIANTS);
        addRecipeForPropVariant(stained_glass_gray, STAINED_GLASS_GRAY_VARIANTS);
        addRecipeForPropVariant(stained_glass_pink, STAINED_GLASS_PINK_VARIANTS);
        addRecipeForPropVariant(stained_glass_lime, STAINED_GLASS_LIME_VARIANTS);
        addRecipeForPropVariant(stained_glass_yellow, STAINED_GLASS_YELLOW_VARIANTS);
        addRecipeForPropVariant(stained_glass_light_blue, STAINED_GLASS_LIGHT_BLUE_VARIANTS);
        addRecipeForPropVariant(stained_glass_magenta, STAINED_GLASS_MAGENTA_VARIANTS);
        addRecipeForPropVariant(stained_glass_orange, STAINED_GLASS_ORANGE_VARIANTS);
        addRecipeForPropVariant(stained_glass_white, STAINED_GLASS_WHITE_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_black, STAINED_GLASS_PANE_BLACK_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_red, STAINED_GLASS_PANE_RED_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_green, STAINED_GLASS_PANE_GREEN_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_brown, STAINED_GLASS_PANE_BROWN_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_blue, STAINED_GLASS_PANE_BLUE_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_purple, STAINED_GLASS_PANE_PURPLE_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_cyan, STAINED_GLASS_PANE_CYAN_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_light_gray, STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_gray, STAINED_GLASS_PANE_GRAY_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_pink, STAINED_GLASS_PANE_PINK_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_lime, STAINED_GLASS_PANE_LIME_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_yellow, STAINED_GLASS_PANE_YELLOW_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_light_blue, STAINED_GLASS_PANE_LIGHT_BLUE_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_magenta, STAINED_GLASS_PANE_MAGENTA_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_orange, STAINED_GLASS_PANE_ORANGE_VARIANTS);
        addRecipeForPropVariant(stained_glass_pane_white, STAINED_GLASS_PANE_WHITE_VARIANTS);
        addRecipeForPropVariant(steel, STEEL_VARIANTS, OreDictionary.getOres("blockSteel"));
        addRecipeForPropVariant(stone_bricks, STONE_BRICKS_VARIANTS, OreDictionary.getOres("stone"));
        addRecipeForPropVariant(technical, TECHNICAL_VARIANTS);
        addRecipeForPropVariant(temple, TEMPLE_VARIANTS);
        addRecipeForPropVariant(tin, TIN_VARIANTS, OreDictionary.getOres("blockTin"));
        addRecipeForPropVariant(torch, TORCH_VARIANTS);
        addRecipeForPropVariant(transparent_technical, TRANSPARENT_TECHNICAL_VARIANSTS);
        addRecipeForPropVariant(tyrian, TYRIAN_VARIANTS);
        addRecipeForPropVariant(uranium, URANIUM_VARIANTS, OreDictionary.getOres("blockUranium"));
        addRecipeForPropVariant(valentines, VALENTINES_VARIANTS);
        addRecipeForPropVariant(voidstone, VOIDSTONE_VARIANTS);
        addRecipeForPropVariant(warning, WARNING_VARIANTS);
        addRecipeForPropVariant(waterstone, WATERSTONE_VARIANTS);
        addRecipeForPropVariant(woolen_clay, WOOLEN_CLAY_VARIANTS);
    }

    public static void addRecipe(ItemStack... group) {
        ChiselRecipe recipe = new ChiselRecipe(group);
        recipes.add(recipe);
    }

    private static void addRecipeForPropVariant(Block block, PropertyVariant variants, ItemStack... stacks) {
        List<ItemStack> list = new ArrayList<ItemStack>();
        for (BlockVariant variant : variants.getAllowedValues()) {
            list.add(new ItemStack(block, 1, variant.getMeta()));
        }

        Collections.addAll(list, stacks);

        ItemStack[] recipe = new ItemStack[list.size()];
        list.toArray(recipe);
        addRecipe(recipe);
    }

    private static void addRecipeForPropVariant(Block block, PropertyVariant variants, List<ItemStack> oreDict) {
        ItemStack[] ret = new ItemStack[oreDict.size()];
        for(int c = 0; c < oreDict.size(); c++) {
            ret[c] = oreDict.get(c);
        }

        addRecipeForPropVariant(block, variants, ret);
    }

    public static ChiselRecipe getRecipeFromItemStack(ItemStack stack) {
        ItemStack stack1 = new ItemStack(stack.getItem(), 1, stack.getItemDamage());
        for (int c = 0; c < recipes.size(); c++) {
            ItemStack[] results = recipes.get(c).getChiselResults();
            for (int d = 0; d < results.length; d++) {
                if (stack1.isItemEqual(results[d])) {
                    return (ChiselRecipe) recipes.get(c);
                }
            }
        }

        return null;
    }
}
