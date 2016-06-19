package com.cricketcraft.chisel.api;

import net.minecraft.item.ItemStack;

public interface ICarvingRecipe {

    /**
     * Returns a list of items that are the result of the input
     */
    ItemStack[] getChiselResults();
}
