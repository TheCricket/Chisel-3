package chisel.menu;

import chisel.menu.slot.InputSlot;
import chisel.menu.slot.SelectionSlot;
import chisel.registry.ChiselMenus;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import org.jspecify.annotations.NonNull;

public class ChiselMenu extends AbstractContainerMenu {

    protected final ChiselSelectionInventory variants = new ChiselSelectionInventory();
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
        if (!player.level().isClientSide()) {
            savePersistence();
        }
    }

    private void savePersistence() {
        ItemStack stack = inputSlot.getItem();
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
            addSlot(new SelectionSlot(container, variants, c, left + ((c % 9) * 18), top + ((c / 9) * 18)));
        }

        addSlot(inputSlot = new InputSlot(container, ChiselSelectionInventory.VISIBLE_SIZE, 24, top + 16));
        container.inputSlot = inputSlot;
    }

    private void addInventorySlots(Inventory inventory) {
        int top = 120;
        int left = 71;
        // main inv
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
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = slots.get(slotIndex);

        if (slot.hasItem()) {
            ItemStack copyFrom = slot.getItem();
            stack = copyFrom.copy();

            if (slotIndex < 45) { // If it's a SelectionSlot (0-44)
                if (!moveItemStackTo(copyFrom, 46, slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
                // Trigger side effects manually since moveItemStackTo doesn't call onTake
                container.chisel.hurtAndBreak(stack.getCount(), player, container.hand);
                variants.clearContent();
                inputSlot.set(ItemStack.EMPTY);
            } else if (slotIndex < 46) { // If it's the InputSlot (45)
                if (!moveItemStackTo(copyFrom, 46, slots.size(), true))
                    return ItemStack.EMPTY;

                variants.clearContent();
            } else { // From Player Inventory to InputSlot
                if (!moveItemStackTo(copyFrom, 45, 46, false))
                    return ItemStack.EMPTY;
            }

            if (copyFrom.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return stack;
    }

    public void setSearchState(String filter, float scrollOffset) {
        variants.setFilter(filter);
        variants.setScrollOffset(scrollOffset);
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return player.getItemInHand(container.hand) == container.chisel;
    }
}