package chisel.menu;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;

public class SelectionSlot extends Slot {
    public SelectionSlot(Container container, int slot, int x, int y) {
        super(container, slot, x, y);
    }
}
