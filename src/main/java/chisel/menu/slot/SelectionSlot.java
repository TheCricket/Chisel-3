package chisel.menu.slot;

import chisel.menu.ChiselContainer;
import chisel.menu.ChiselSelectionInventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class SelectionSlot extends Slot {
    private final ChiselContainer container;

    public SelectionSlot(ChiselContainer container, ChiselSelectionInventory selectionInventory, int slot, int x, int y) {
        super(selectionInventory, slot, x, y);
        this.container = container;
    }

    @Override
    public boolean mayPlace(@NonNull ItemStack stack) {
        return false;
    }

    @Override
    public void onQuickCraft(ItemStack picked, ItemStack original) {
        super.onQuickCraft(picked, original);
    }

    @Override
    protected void onSwapCraft(int count) {
        super.onSwapCraft(count);
    }

    @Override
    protected void onQuickCraft(@NonNull ItemStack picked, int count) {
        container.chisel.hurtAndBreak(picked.count(), container.inventory.player, container.hand);
        clearContent();
    }

    @Override
    public void onTake(@NonNull Player player, @NonNull ItemStack carried) {
        super.onTake(player, carried);
        container.chisel.hurtAndBreak(carried.count(), container.inventory.player, container.hand);
        clearContent();
    }

    private void clearContent() {
        container.selectionInventory.clearContent();
        container.inputSlot.set(ItemStack.EMPTY);
    }
}
