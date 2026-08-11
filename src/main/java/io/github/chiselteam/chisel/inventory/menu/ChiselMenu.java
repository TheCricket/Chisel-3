package io.github.chiselteam.chisel.inventory.menu;

import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.inventory.ChiselSelectionInventory;
import io.github.chiselteam.chisel.inventory.container.ChiselContainer;
import io.github.chiselteam.chisel.inventory.slot.ChiselInputSlot;
import io.github.chiselteam.chisel.inventory.slot.SelectionSlot;
import io.github.chiselteam.chisel.item.ChiselItem;
import io.github.chiselteam.chisel.registry.ChiselMenus;
import io.github.chiselteam.chisel.registry.ChiselStats;
import io.github.chiselteam.chisel.util.VariantFinder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import org.jspecify.annotations.NonNull;

public class ChiselMenu extends AbstractContainerMenu {

    public final ChiselSelectionInventory variants = new ChiselSelectionInventory();
    protected final ChiselContainer container;
    public Slot inputSlot;

    public ChiselMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        super(ChiselMenus.CHISEL.get(), containerId);

        InteractionHand hand = readHand(buf);
        ItemStack chisel = inventory.player.getItemInHand(hand);

        container = new ChiselContainer(
                inventory,
                variants,
                hand,
                0, // chiselSlot not strictly used if we have the stack
                chisel
        );

        addVariantSlots();
        addInventorySlots(inventory);

        if (!inventory.player.level().isClientSide()) {
            loadPersistence();
        }
    }

    private void loadPersistence() {
        CustomData customData = container.chisel.get(DataComponents.CUSTOM_DATA);
        if (customData != null) {
            CompoundTag tag = customData.copyTag();
            if (tag.contains("chiselItem")) {
                ItemStack saved = ItemStack.CODEC.parse(NbtOps.INSTANCE, tag.get("chiselItem")).result().orElse(ItemStack.EMPTY);
                inputSlot.set(saved);
            }
        }
    }

    @Override
    public void removed(@NonNull Player player) {
        super.removed(player);
        if (player.level().isClientSide()) return;
        rollbackWorkingStack();
        if (container.chisel.isEmpty()) clearContainer(player, container);
        else savePersistence();
    }

    private void savePersistence() {
        savePersistence(inputSlot.getItem());
    }

    private void savePersistence(ItemStack stack) {
        if (container.inventory.player.level().isClientSide() || container.chisel.isEmpty()) return;
        if (stack.isEmpty()) {
            container.chisel.update(DataComponents.CUSTOM_DATA, CustomData.EMPTY, data -> {
                CompoundTag tag = data.copyTag();
                tag.remove("chiselItem");
                return CustomData.of(tag);
            });
        } else {
            container.chisel.update(DataComponents.CUSTOM_DATA, CustomData.EMPTY, data -> {
                CompoundTag tag = data.copyTag();
                tag.put("chiselItem", ItemStack.CODEC.encodeStart(NbtOps.INSTANCE, stack).getOrThrow());
                return CustomData.of(tag);
            });
        }
    }

    private static InteractionHand readHand(FriendlyByteBuf buf) {
        if (buf == null || buf.readableBytes() <= 0) {
            return InteractionHand.MAIN_HAND;
        }
        try {
            return buf.readBoolean() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        } catch (Exception e) {
            return InteractionHand.MAIN_HAND;
        }
    }

    private void addVariantSlots() {
        int top = 26, left = 62;
        for (int c = 0; c < ChiselSelectionInventory.VISIBLE_SIZE; c++) {
            addSlot(new SelectionSlot(variants, c, left + ((c % 9) * 18), top + ((c / 9) * 18)));
        }

        addSlot(inputSlot = new ChiselInputSlot(container, ChiselSelectionInventory.VISIBLE_SIZE, 24, top + 52));
        container.inputSlot = inputSlot;
    }

    private void addInventorySlots(Inventory inventory) {
        int top = 120;
        int left = 71;

        for (int c = 0; c < 27; c++) {
            addSlot(new Slot(inventory, c + 9, left + ((c % 9) * 18), top + (c / 9) * 18));
        }

        top += 58;
        for (int c = 0; c < 9; c++) {
            addSlot(new Slot(inventory, c, left + ((c % 9) * 18), top));
        }
    }

    @Override
    public @NonNull ItemStack quickMoveStack(@NonNull Player player, int slotIndex) {
        if (slotIndex < ChiselSelectionInventory.VISIBLE_SIZE) return ItemStack.EMPTY;
        Slot slot = slots.get(slotIndex);
        if (!slot.hasItem()) return ItemStack.EMPTY;
        ItemStack original = slot.getItem().copy();

        if (slotIndex == ChiselSelectionInventory.VISIBLE_SIZE) {
            int limit = getAffordableRemoval(original.getCount());
            if (limit <= 0) return ItemStack.EMPTY;
            ItemStack moving = original.copyWithCount(limit);
            int before = moving.getCount();
            if (!moveItemStackTo(moving, ChiselSelectionInventory.VISIBLE_SIZE + 1, slots.size(), true)) return ItemStack.EMPTY;
            int moved = before - moving.getCount();
            ItemStack removed = inputSlot.remove(moved);
            inputSlot.onTake(player, removed);
        } else {
            ItemStack moving = slot.getItem();
            if (!moveItemStackTo(moving, ChiselSelectionInventory.VISIBLE_SIZE, ChiselSelectionInventory.VISIBLE_SIZE + 1, false)) return ItemStack.EMPTY;
            if (moving.isEmpty()) slot.set(ItemStack.EMPTY);
            else slot.setChanged();
        }

        return original;
    }

    @Override
    public void clicked(int slotIndex, int buttonNum, @NonNull ContainerInput containerInput, @NonNull Player player) {
        if (slotIndex == ChiselSelectionInventory.VISIBLE_SIZE && isWholeStackReplacement(containerInput)) {
            ItemStack working = inputSlot.getItem();
            if (!working.isEmpty() && getAffordableRemoval(working.getCount()) < working.getCount()) return;
        }
        super.clicked(slotIndex, buttonNum, containerInput, player);
    }

    private boolean isWholeStackReplacement(ContainerInput input) {
        if (input == ContainerInput.SWAP) return true;
        return input == ContainerInput.PICKUP && !getCarried().isEmpty()
                && !ItemStack.isSameItemSameComponents(inputSlot.getItem(), getCarried());
    }

    public void selectVariant(Player player, int selectionIndex, boolean bulk) {
        if (selectionIndex < 0 || selectionIndex >= ChiselSelectionInventory.VISIBLE_SIZE) return;
        ItemStack selected = variants.getItem(selectionIndex);
        if (selected.isEmpty()) return;
        ItemStack input = inputSlot.getItem();
        if (input.isEmpty()) return;
        if (!(input.getItem() instanceof BlockItem inputItem) || !(selected.getItem() instanceof BlockItem selectedItem)) return;
        VariantFamily family = VariantFinder.getFamilyForBlock(inputItem.getBlock(), player.level().registryAccess());
        if (family == null || !family.isBlockInFamily(selectedItem.getBlock())) return;

        ItemStack result = input.transmuteCopy(selected.getItem(), input.getCount());
        ((ChiselInputSlot) inputSlot).setWorking(result);
        if (bulk) bulkConvert(player, family, selected, input.getCount());
        broadcastChanges();
    }

    private void bulkConvert(Player player, VariantFamily family, ItemStack selected, int reservedUses) {
        int uses = ChiselItem.getAvailableUses(container.chisel, player) - reservedUses;
        if (uses <= 0) return;
        int converted = 0;
        Inventory inventory = player.getInventory();

        for (int slot = 0; slot < inventory.getContainerSize() && converted < uses; slot++) {
            ItemStack stack = inventory.getItem(slot);
            if (!(stack.getItem() instanceof BlockItem blockItem)) continue;
            if (!family.isBlockInFamily(blockItem.getBlock()) || stack.getItem() == selected.getItem()) continue;

            int amount = Math.min(stack.getCount(), uses - converted);
            if (amount == stack.getCount()) {
                inventory.setItem(slot, stack.transmuteCopy(selected.getItem(), stack.getCount()));
            } else {
                ItemStack result = stack.transmuteCopy(selected.getItem(), amount);
                int before = result.getCount();
                inventory.add(result);
                amount = before - result.getCount();
                if (amount <= 0) continue;
                stack.shrink(amount);
            }
            converted += amount;
        }

        if (converted <= 0) return;
        savePersistence(safeWorkingStack());
        ChiselItem.hurtAndBreak(container.chisel, converted, player, container.hand);
        player.awardStat(ChiselStats.BLOCKS_CHISELED.get());
        if (container.chisel.isEmpty()) inputSlot.set(ItemStack.EMPTY);
        broadcastChanges();
    }

    public int takeWorking(int requested) {
        ItemStack working = inputSlot.getItem();
        int amount = Math.min(requested, getAffordableRemoval(requested));
        if (amount <= 0) return 0;

        boolean converted = container.isConverted();
        container.shrinkCommitted(amount);
        savePersistence(safeWorkingStack(working.getCount() - amount));
        if (converted) {
            ChiselItem.hurtAndBreak(container.chisel, amount, container.inventory.player, container.hand);
            container.inventory.player.awardStat(ChiselStats.BLOCKS_CHISELED.get());
        }
        return amount;
    }

    private int getAffordableRemoval(int requested) {
        if (!container.isConverted()) return requested;
        return Math.min(requested, ChiselItem.getAvailableUses(container.chisel, container.inventory.player));
    }

    private ItemStack safeWorkingStack() {
        return safeWorkingStack(inputSlot.getItem().getCount());
    }

    private ItemStack safeWorkingStack(int count) {
        ItemStack committed = container.getCommittedStack();
        return committed.isEmpty() || count <= 0 ? ItemStack.EMPTY : committed.copyWithCount(count);
    }

    private void rollbackWorkingStack() {
        if (!container.isConverted()) return;
        ((ChiselInputSlot) inputSlot).setWorking(safeWorkingStack());
    }

    public void setSearchState(String filter, float scrollOffset) {
        variants.setFilter(filter);
        variants.setScrollOffset(scrollOffset);
    }

    public ItemStack getChisel() {
        return container.chisel;
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return player.getItemInHand(container.hand) == container.chisel;
    }
}
