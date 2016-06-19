package com.cricketcraft.chisel.api;

import net.minecraft.item.ItemStack;

public class ChiselRecipe implements ICarvingRecipe {
    public final ItemStack[] group;

    /**
     * The output will also be used as the input;
     *
     * @param group
     */
    public ChiselRecipe(ItemStack[] group) {
        this.group = group;
    }

    @Override
    public ItemStack[] getChiselResults() {
        return group;
    }
}
