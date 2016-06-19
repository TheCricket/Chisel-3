package com.cricketcraft.chisel.inventory.slots;

import com.cricketcraft.chisel.inventory.InventoryChiselSelection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotChiselSelection extends Slot {
    private InventoryChiselSelection inventory;

    public SlotChiselSelection(InventoryChiselSelection inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.inventory = inventory;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        super.onPickupFromSlot(player, stack);
        ItemStack baseStack = inventory.getStackInSlot(60);
        if(stack.stackSize != 0)
            stack.stackSize = baseStack.stackSize;
        inventory.setInventorySlotContents(60, null);
        inventory.updateItems(null); //Can just pass null and clear it
    }
}
