package chisel.menu.slot;

import chisel.core.VariantFamily;
import chisel.menu.ChiselContainer;
import chisel.util.VariantFinder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class InputSlot extends Slot {

    private final ChiselContainer container;

    public InputSlot(ChiselContainer container, int slot, int x, int y) {
        super(container, slot, x, y);
        this.container = container;
    }

    @Override
    public void setChanged() {
        container.setChanged();
        container.selectionInventory.setChanged();
    }

    @Override
    public void set(@NonNull ItemStack stack) {
        super.set(stack);
        if(getItem().getItem() instanceof BlockItem blockItem) {
            VariantFamily family = VariantFinder.getFamilyForBlock(blockItem.getBlock(), container.families);
            if(family != null) {
                container.selectionInventory.updateSlots(family, stack.getCount());
            }
        }
    }

    @Override
    public void onTake(@NonNull Player player, @NonNull ItemStack carried) {
        super.onTake(player, carried);
        container.selectionInventory.clearContent();
    }
}
