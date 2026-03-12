package chisel.menu;

import chisel.menu.slot.InputSlot;
import chisel.menu.slot.SelectionSlot;
import chisel.registry.ChiselMenus;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class ChiselMenu extends AbstractContainerMenu {

    protected final ChiselSelectionInventory variants = new ChiselSelectionInventory();
    protected final ChiselContainer container;
    private final int numRows = 3;
    public Slot inputSlot;

    public ChiselMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        super(ChiselMenus.CHISEL.get(), containerId);

        InteractionHand hand = readHand(buf);

        container = new ChiselContainer(
                inventory,
                variants,
                hand,
                0,
                ItemStack.EMPTY
        );

        addVariantSlots();
        addInventorySlots(inventory);
    }

    private static InteractionHand readHand(FriendlyByteBuf buf) {
        if (buf == null || buf.readableBytes() <= 0) {
            return InteractionHand.MAIN_HAND;
        }
        return buf.readBoolean() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
    }

    private void addVariantSlots() {
        int top = 8, left = 62;
        for (int c = 0; c < variants.size; c++) {
            addSlot(new SelectionSlot(container, variants, c, left + ((c % 10) * 18), top + ((c / 10) * 18)));
        }

        addSlot(inputSlot = new InputSlot(container, variants.size, 24, 24));
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

            if (slotIndex < numRows * 9) {
                if (!moveItemStackTo(copyFrom, numRows * 9, slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(copyFrom, 0, numRows * 9, false))
                return ItemStack.EMPTY;

            if (copyFrom.getCount() == 0)
                slot.set(ItemStack.EMPTY);
            else
                slot.setChanged();
        }

        return stack;
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return true;
    }
}