package com.cricketcraft.chisel.inventory.slots;

import com.cricketcraft.chisel.inventory.InventoryChiselSelection;
import net.minecraft.inventory.Slot;

public class SlotChiselInput extends Slot {

    private int id;
    private InventoryChiselSelection selection;

    public SlotChiselInput(InventoryChiselSelection inv, int slotID, int xPos, int yPos) {
        super(inv, slotID, xPos, yPos);
        selection = inv;
        id = slotID;
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();
        selection.updateItems(selection.getStackInSlot(id));
    }
}
