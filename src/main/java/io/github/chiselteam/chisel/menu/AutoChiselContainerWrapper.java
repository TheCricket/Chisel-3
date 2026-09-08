package io.github.chiselteam.chisel.menu;

import io.github.chiselteam.chisel.block.entity.AutoChiselBlockEntity;
import io.github.chiselteam.chisel.registry.ChiselItems;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.TransferPreconditions;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.transaction.SnapshotJournal;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AutoChiselContainerWrapper extends SnapshotJournal<List<ItemStack>> implements ResourceHandler<ItemResource> {

    private final AutoChiselBlockEntity blockEntity;
    private final Direction side;
    private final Direction effectiveSide;

    public AutoChiselContainerWrapper(AutoChiselBlockEntity blockEntity, @Nullable Direction side) {
        this.blockEntity = blockEntity;
        this.side = side;
        this.effectiveSide = side == null ? Direction.UP : side;
    }

    @Override
    protected List<ItemStack> createSnapshot() {
        List<ItemStack> snapshot = new ArrayList<>();
        for (int i = 0; i < blockEntity.getContainerSize(); i++) {
            ItemStack stack = blockEntity.getItem(i);
            snapshot.add(stack.isEmpty() ? ItemStack.EMPTY : stack.copy());
        }
        return snapshot;
    }

    @Override
    protected void revertToSnapshot(List<ItemStack> snapshot) {
        for (int i = 0; i < snapshot.size(); i++) {
            blockEntity.getItems().set(i, snapshot.get(i));
        }
        blockEntity.setChanged();
    }

    @Override
    public int size() {
        return blockEntity.getSlotsForFace(effectiveSide).length;
    }

    @Override
    public boolean isValid(int slot, @NonNull ItemResource resource) {
        int[] slots = blockEntity.getSlotsForFace(effectiveSide);
        if (slot < 0 || slot >= slots.length) return false;
        return blockEntity.canPlaceItemThroughFace(slots[slot], resource.toStack(), side);
    }

    @Override
    public long getCapacityAsLong(int slot, @NonNull ItemResource resource) {
        int[] slots = blockEntity.getSlotsForFace(effectiveSide);
        if (slot < 0 || slot >= slots.length) return 0;
        return resource.isEmpty() ? blockEntity.getMaxStackSize() : blockEntity.getMaxStackSize(resource.toStack());
    }

    @Override
    public @NonNull ItemResource getResource(int slot) {
        int[] slots = blockEntity.getSlotsForFace(effectiveSide);
        if (slot < 0 || slot >= slots.length) return ItemResource.EMPTY;
        ItemStack stack = blockEntity.getItem(slots[slot]);
        return ItemResource.of(stack);
    }

    @Override
    public long getAmountAsLong(int slot) {
        int[] slots = blockEntity.getSlotsForFace(effectiveSide);
        if (slot < 0 || slot >= slots.length) return 0;
        return blockEntity.getItem(slots[slot]).getCount();
    }

    @Override
    public int insert(int slot, @NonNull ItemResource resource, int maxAmount, @NonNull TransactionContext transaction) {
        if (noAutomationUpgrade()) return 0;
        int[] slots = blockEntity.getSlotsForFace(effectiveSide);
        Objects.checkIndex(slot, slots.length);
        TransferPreconditions.checkNonEmptyNonNegative(resource, maxAmount);

        int realSlot = slots[slot];
        ItemStack resourceStack = resource.toStack();
        int stackLimit = blockEntity.getMaxStackSize(resourceStack);
        if (blockEntity.canPlaceItemThroughFace(realSlot, resourceStack, side)) {
            ItemStack existing = blockEntity.getItem(realSlot);
            if (existing.isEmpty() || (ItemStack.isSameItemSameComponents(existing, resourceStack) && existing.getCount() < stackLimit)) {
                int toInsert = Math.min(maxAmount, stackLimit - existing.getCount());
                if (toInsert > 0) {
                    this.updateSnapshots(transaction);
                    if (existing.isEmpty()) {
                        blockEntity.getItems().set(realSlot, resource.toStack(toInsert));
                    } else {
                        ItemStack newStack = existing.copy();
                        newStack.grow(toInsert);
                        blockEntity.getItems().set(realSlot, newStack);
                    }
                    blockEntity.setChanged();
                    return toInsert;
                }
            }
        }
        return 0;
    }

    @Override
    public int insert(@NonNull ItemResource resource, int maxAmount, @NonNull TransactionContext transaction) {
        if (noAutomationUpgrade()) return 0;

        int totalInserted = 0;
        int[] slots = blockEntity.getSlotsForFace(effectiveSide);
        for (int i = 0; i < slots.length; i++) {
            if (maxAmount <= 0) break;
            int inserted = insert(i, resource, maxAmount, transaction);
            totalInserted += inserted;
            maxAmount -= inserted;
        }
        return totalInserted;
    }

    @Override
    public int extract(int slot, @NonNull ItemResource resource, int maxAmount, @NonNull TransactionContext transaction) {
        if (noAutomationUpgrade()) return 0;
        int[] slots = blockEntity.getSlotsForFace(effectiveSide);
        Objects.checkIndex(slot, slots.length);
        TransferPreconditions.checkNonEmptyNonNegative(resource, maxAmount);

        int realSlot = slots[slot];
        ItemStack stack = blockEntity.getItem(realSlot);
        if (!stack.isEmpty() && ItemResource.of(stack).equals(resource) && blockEntity.canTakeItemThroughFace(realSlot, stack, side)) {
            int toExtract = Math.min(maxAmount, stack.getCount());
            if (toExtract > 0) {
                this.updateSnapshots(transaction);
                if (stack.getCount() == toExtract) {
                    blockEntity.getItems().set(realSlot, ItemStack.EMPTY);
                } else {
                    ItemStack newStack = stack.copy();
                    newStack.shrink(toExtract);
                    blockEntity.getItems().set(realSlot, newStack);
                }
                blockEntity.setChanged();
                return toExtract;
            }
        }
        return 0;
    }

    @Override
    public int extract(@NonNull ItemResource resource, int maxAmount, @NonNull TransactionContext transaction) {
        if (noAutomationUpgrade()) return 0;

        int totalExtracted = 0;
        int[] slots = blockEntity.getSlotsForFace(effectiveSide);
        for (int i = 0; i < slots.length; i++) {
            if (maxAmount <= 0) break;
            int extracted = extract(i, resource, maxAmount, transaction);
            totalExtracted += extracted;
            maxAmount -= extracted;
        }
        return totalExtracted;
    }

    private boolean noAutomationUpgrade() {
        return !blockEntity.getItem(AutoChiselBlockEntity.AUTOMATION_UPGRADE_SLOT).is(ChiselItems.UPGRADE_AUTOMATION.get());
    }
}
