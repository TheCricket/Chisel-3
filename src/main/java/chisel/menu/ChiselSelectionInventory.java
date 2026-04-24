package chisel.menu;

import chisel.core.variant.VariantFamily;
import chisel.item.ChiselItem;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.ContainerUser;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ChiselSelectionInventory implements Container {

    public static final int VISIBLE_SIZE = 45;
    public VariantFamily family;
    public int size = VISIBLE_SIZE;
    public int stackSize;
    public int activeVariants = 0;
    public ChiselContainer container;
    public NonNullList<ItemStack> items;

    private final List<ItemStack> allItems = new ArrayList<>();
    private final List<ItemStack> filteredItems = new ArrayList<>();
    private String filter = "";
    private float scrollOffset = 0.0f;

    public ChiselSelectionInventory() {
        this.family = null;
        this.stackSize = 1;
        items = NonNullList.withSize(VISIBLE_SIZE, ItemStack.EMPTY);
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
        return VISIBLE_SIZE;
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
    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        items.clear();
        allItems.clear();
        filteredItems.clear();
        family = null;
        stackSize = 1;
        activeVariants = 0;
        filter = "";
        scrollOffset = 0;
    }

    public void updateSlots(VariantFamily family, int stackSize) {
        this.family = family;
        this.stackSize = stackSize;
        allItems.clear();
        if(family != null) {
            family.getVariants().forEach(variant -> {
                if (variant != null && variant.getBlock() != null) {
                    ItemStack stack = new ItemStack(variant.getBlock());
                    stack.setCount(stackSize);
                    allItems.add(stack);
                }
            });
        }
        updateFilteredItems();
        setChanged();
    }

    public void setFilter(String filter) {
        this.filter = filter.toLowerCase(Locale.ROOT);
        updateFilteredItems();
    }

    public void setScrollOffset(float offset) {
        this.scrollOffset = offset;
        updateVisibleItems();
    }

    public void updateFilteredItems() {
        filteredItems.clear();
        for (ItemStack stack : allItems) {
            if (filter.isEmpty() || stack.getHoverName().getString().toLowerCase(Locale.ROOT).contains(filter)) {
                filteredItems.add(stack);
            }
        }
        activeVariants = filteredItems.size();
        updateVisibleItems();
    }

    public void updateVisibleItems() {
        int totalRows = (filteredItems.size() + 8) / 9;
        int scrollRows = totalRows - 5;
        if (scrollRows < 0) scrollRows = 0;
        int rowOffset = Math.round(scrollOffset * (float) scrollRows);
        int itemOffset = rowOffset * 9;

        for (int i = 0; i < VISIBLE_SIZE; i++) {
            int index = itemOffset + i;
            if (index < filteredItems.size()) {
                items.set(i, filteredItems.get(index).copy());
            } else {
                items.set(i, ItemStack.EMPTY);
            }
        }
    }

    public void setFamily(VariantFamily family) {
        this.family = family;
        updateSlots(family, stackSize);
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }
}
