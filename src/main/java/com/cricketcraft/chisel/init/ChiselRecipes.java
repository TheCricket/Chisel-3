package com.cricketcraft.chisel.init;

import com.cricketcraft.chisel.config.Configurations;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ChiselRecipes {
    public static void init() {
        registerShapedRecipe(new ItemStack(ChiselItems.cloudInABottle, 1), "X X", "XYX", " X ", 'X', Blocks.GLASS, 'Y', Items.QUARTZ);
        registerShapedRecipe(new ItemStack(ChiselItems.ballOMoss, 1), "XYX", "YXY", "XYX", 'X', Blocks.VINE, 'Y', Items.STICK);

        registerShapedOreRecipe(new ItemStack(ChiselItems.upgrade, 1, 0), "IEI", "EUE", "RRR", 'I', "ingotIron", 'E', Items.EMERALD, 'R', Items.REDSTONE, 'U', Items.SUGAR);
        registerShapedOreRecipe(new ItemStack(ChiselItems.upgrade, 1, 1), "IEI", "EUE", "RRR", 'I', "ingotIron", 'E', Items.EMERALD, 'R', Items.REDSTONE, 'U', Blocks.HOPPER);
        registerShapedOreRecipe(new ItemStack(ChiselItems.upgrade, 1, 2), "IEI", "EUE", "RRR", 'I', "ingotIron", 'E', Items.EMERALD, 'R', Items.REDSTONE, 'U', Blocks.CRAFTING_TABLE);

        if (Configurations.chiselRecipe) {
            registerShapedOreRecipe(new ItemStack(ChiselItems.chisel), " YY", " YY", "X  ", 'X', "stickWood", 'Y', "ingotIron");
            registerShapedOreRecipe(new ItemStack(ChiselItems.diamondChisel), " YY", " YY", "x  ", 'x', "stickWood", 'Y', "gemDiamond");
            registerShapedOreRecipe(new ItemStack(ChiselItems.obsidianChisel), " YY", " YY", "x  ", 'x', "stickWood", 'Y', Blocks.OBSIDIAN);
        } else {
            registerShapedOreRecipe(new ItemStack(ChiselItems.chisel), " Y", "X ", 'X', "stickWood", 'Y', "ingotIron");
            registerShapedOreRecipe(new ItemStack(ChiselItems.diamondChisel), " Y", "X ", 'X', "stickWood", 'Y', "gemDiamond");
            registerShapedOreRecipe(new ItemStack(ChiselItems.obsidianChisel), " Y", "X ", 'X', "stickWood", 'Y', Blocks.OBSIDIAN);
        }

        registerShapelessRecipe(new ItemStack(ChiselItems.smashing_rock, 16), new ItemStack(Items.STONE_PICKAXE), new ItemStack(Items.GLASS_BOTTLE, 1), new ItemStack(Items.STONE_SHOVEL));
    }

    private static void registerShapelessRecipe(ItemStack output, Object... stacks) {
        GameRegistry.addShapelessRecipe(output, stacks);
    }

    private static void registerShapedRecipe(ItemStack output, Object... params) {
        GameRegistry.addShapedRecipe(output, params);
    }

    private static void registerShapedOreRecipe(ItemStack output, Object... params) {
        GameRegistry.addRecipe(new ShapedOreRecipe(output, params));
    }
}
