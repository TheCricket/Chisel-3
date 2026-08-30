package io.github.chiselteam.chisel.menu.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class UpgradeSlot extends Slot {
    private final Supplier<Item> upgrade;
    private final int stackLimit;

    public UpgradeSlot(Container container, int slot, int x, int y, int stackLimit, Supplier<Item> upgrade) {
        super(container, slot, x, y);
        this.upgrade = upgrade;
        this.stackLimit = stackLimit;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(upgrade.get());
    }

    @Override
    public int getMaxStackSize() {
        return stackLimit;
    }
}
