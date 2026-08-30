package io.github.chiselteam.chisel.menu;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class ChiselContainer extends SimpleContainer {

    public final ChiselSelectionInventory selectionInventory;
    public final Inventory inventory;

    public final InteractionHand hand;
    public final int chiselSlot;
    public final ItemStack chisel;
    public Slot inputSlot;
    private ItemStack committedStack = ItemStack.EMPTY;

    public ChiselContainer(Inventory inventory, ChiselSelectionInventory selectionInventory, InteractionHand hand, int chiselSlot, ItemStack chisel) {
        super(46);
        this.inventory = inventory;
        this.selectionInventory = selectionInventory;
        this.hand = hand;
        this.chiselSlot = chiselSlot;
        this.chisel = chisel;
    }

    @Override
    public boolean canPlaceItem(int slot, @NonNull ItemStack stack) {
        return super.canPlaceItem(slot, stack);
    }

    public void commit(ItemStack stack) {
        committedStack = stack.copy();
    }

    public ItemStack getCommittedStack() {
        return committedStack;
    }

    public boolean isConverted() {
        ItemStack working = inputSlot == null ? ItemStack.EMPTY : inputSlot.getItem();
        return !working.isEmpty() && !committedStack.isEmpty() && working.getItem() != committedStack.getItem();
    }

    public void shrinkCommitted(int amount) {
        committedStack.shrink(amount);
    }

    public void clearCommitted() {
        committedStack = ItemStack.EMPTY;
    }
}
