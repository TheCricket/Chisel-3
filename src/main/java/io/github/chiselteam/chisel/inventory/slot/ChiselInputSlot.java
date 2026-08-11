package io.github.chiselteam.chisel.inventory.slot;

import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.inventory.container.ChiselContainer;
import io.github.chiselteam.chisel.inventory.menu.ChiselMenu;
import io.github.chiselteam.chisel.util.VariantFinder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class ChiselInputSlot extends Slot {

    private final ChiselContainer container;

    public ChiselInputSlot(ChiselContainer container, int slot, int x, int y) {
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
        if (!stack.isEmpty()) container.commit(stack);
        else container.clearCommitted();
        updateVariants(stack);
    }

    public void setWorking(@NonNull ItemStack stack) {
        super.set(stack);
        updateVariants(stack);
    }

    @Override
    public void setByPlayer(@NonNull ItemStack stack, @NonNull ItemStack previous) {
        int committedCount = container.getCommittedStack().getCount();
        if (!previous.isEmpty() && (stack.isEmpty() || !ItemStack.isSameItemSameComponents(previous, stack))) {
            ((ChiselMenu) container.inventory.player.containerMenu).takeWorking(previous.getCount());
            if (!stack.isEmpty()) set(stack);
            return;
        }

        super.setByPlayer(stack, previous);
        if (stack.isEmpty()) {
            container.clearCommitted();
        } else if (committedCount == 0) {
            container.commit(stack);
        } else if (stack.getCount() > committedCount) {
            container.getCommittedStack().grow(stack.getCount() - committedCount);
        }
        updateVariants(stack);
    }

    @Override
    public @NonNull ItemStack remove(int amount) {
        int allowed = ((ChiselMenu) container.inventory.player.containerMenu).takeWorking(amount);
        if (allowed <= 0) return ItemStack.EMPTY;
        ItemStack removed = super.remove(allowed);
        if (container.chisel.isEmpty()) setWorking(ItemStack.EMPTY);
        return removed;
    }

    @Override
    public boolean mayPlace(@NonNull ItemStack stack) {
        if (!(stack.getItem() instanceof BlockItem blockItem)) return false;
        VariantFamily family = VariantFinder.getFamilyForBlock(blockItem.getBlock(), container.inventory.player.level().registryAccess());
        if (family == null) return false;
        ItemStack working = getItem();
        if (working.isEmpty()) return true;
        if (!ItemStack.isSameItemSameComponents(working, stack)) return true;
        return container.getCommittedStack().getItem() == stack.getItem();
    }

    @Override
    public void onTake(@NonNull Player player, @NonNull ItemStack carried) {
        super.onTake(player, carried);
        if (getItem().isEmpty()) container.selectionInventory.clearContent();
        else updateVariants(getItem());
    }

    private void updateVariants(ItemStack stack) {
        if (stack.getItem() instanceof BlockItem blockItem) {
            VariantFamily family = VariantFinder.getFamilyForBlock(blockItem.getBlock(), container.inventory.player.level().registryAccess());
            if (family != null) {
                container.selectionInventory.updateSlots(family, stack.getCount(), container.inventory.player.level().registryAccess());
                return;
            }
        }
        container.selectionInventory.clearContent();
    }
}
