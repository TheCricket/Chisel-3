package com.cricketcraft.chisel.inventory;

import com.cricketcraft.chisel.inventory.slots.SlotChiselInput;
import com.cricketcraft.chisel.inventory.slots.SlotChiselSelection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerChisel extends Container {

    public InventoryChiselSelection inventory;
    public ItemStack chisel;

    /**
     * Slot IDs:
     * 0-59: Chisel GUI
     * 60: Chisel Input
     * 61-87: Player Inventory
     * 88-96: Hotbar
     */
    public ContainerChisel(InventoryPlayer player, InventoryChiselSelection chiselSelection) {
        for(int c = 0; c < 60; c++) {
            addSlotToContainer(new SlotChiselSelection(chiselSelection, c, 62 + ((c % 10) * 18), 8 + ((c / 10) * 18)));
        }

        addSlotToContainer(new SlotChiselInput(chiselSelection, 60, 24, 24));

        bindPlayerInventory(player);

        chisel = player.getCurrentItem();
    }



    private void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        int top = 120;
        int left = 71;
        // main inv
        for (int i = 0; i < 27; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i + 9, left + ((i % 9) * 18), top + (i / 9) * 18));
        }

        top += 58;
        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, left + ((i % 9) * 18), top + (i / 9) * 18));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack previous = null;
        Slot slot = inventorySlots.get(index);

        if(slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if(index < 60) {
                //From Chisel
                if(!mergeItemStack(current, 62, 98, true))
                    return null;
            } else {
                if(!mergeItemStack(current, 0, 0, false))
                    return null;
            }

            if(current.stackSize == 0)
                slot.putStack(null);
            else
                slot.onSlotChanged();

            if(current.stackSize == previous.stackSize)
                return null;

            slot.onPickupFromSlot(player, current);
        }

        return previous;
    }
}
