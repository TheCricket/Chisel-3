package chisel.menu.slot;

import chisel.menu.ChiselContainer;
import net.minecraft.world.inventory.Slot;

public class InputSlot extends Slot {

    private final ChiselContainer container;

    public InputSlot(ChiselContainer container, int slot, int x, int y) {
        super(container, slot, x, y);
        this.container = container;
    }

    @Override
    public void setChanged() {
        super.setChanged();
        container.setChanged();
        container.selectionInventory.setChanged();
    }
}
