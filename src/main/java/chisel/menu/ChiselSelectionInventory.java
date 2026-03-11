package chisel.menu;

import chisel.core.VariantFamily;
import chisel.item.ChiselItem;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.ContainerUser;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class ChiselSelectionInventory implements Container {

    public VariantFamily family;
    public final int size;
    public int stackSize;
    public int activeVariants = 0;
    public ChiselContainer container;
    public NonNullList<ItemStack> items;

    public ChiselSelectionInventory() {
        this.family = null;
        this.size = 60;
        this.stackSize = 1;
        items = NonNullList.withSize(size + 1, ItemStack.EMPTY);
    }

    @Override
    public void startOpen(@NonNull ContainerUser user) {
        Container.super.startOpen(user);
        setChanged();
    }

    @Override
    public void stopOpen(@NonNull ContainerUser user) {
        Container.super.stopOpen(user);
        clearContent();
    }

    @Override
    public int getContainerSize() {
        return size + 1;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public @NonNull ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public @NonNull ItemStack removeItem(int slot, int amount) {
        ItemStack stack = getItem(slot);
        if (!stack.isEmpty()) {
            if(stack.getCount() <= amount) {
                setItem(slot, ItemStack.EMPTY);
                setChanged();
                return stack;
            } else {
                ItemStack split = stack.split(amount);
                if(stack.count() == 0) {
                    setItem(slot, ItemStack.EMPTY);
                } else {
                    setItem(slot, stack);
                }

                setChanged();
                return split;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public @NonNull ItemStack removeItemNoUpdate(int slot) {
        ItemStack stack = getItem(slot);
        setItem(slot, ItemStack.EMPTY);
        setChanged();
        return stack;
    }

    @Override
    public void setItem(int slot, @NonNull ItemStack stack) {
        items.set(slot, stack);
        setChanged();
    }

    @Override
    public void setChanged() {
        if(family != null) {
            family.getVariants().forEach(variant -> {
                ItemStack stack = new ItemStack(variant.getBlock().get());
                stack.setCount(stackSize);
                setItem(activeVariants, stack);
                activeVariants++;
            });
        }
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        ItemStack held = player.getUseItem();
        return !held.isEmpty() && held.getItem() instanceof ChiselItem;
    }

    @Override
    public void clearContent() {
        items.clear();
    }

    public void setFamily(VariantFamily family) {
        this.family = family;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public ItemStack getStackInSpecialSlot() {
        return getItem(size);
    }

    public void setStackInSpecialSlot(ItemStack stack) {
        setItem(size, stack);
    }
}
