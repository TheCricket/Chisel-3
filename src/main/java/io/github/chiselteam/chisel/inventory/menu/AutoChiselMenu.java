package io.github.chiselteam.chisel.inventory.menu;

import io.github.chiselteam.chisel.block.entity.AutoChiselBlockEntity;
import io.github.chiselteam.chisel.inventory.slot.AutoChiselInputSlot;
import io.github.chiselteam.chisel.inventory.slot.UpgradeSlot;
import io.github.chiselteam.chisel.registry.ChiselItemAbilities;
import io.github.chiselteam.chisel.registry.ChiselItems;
import io.github.chiselteam.chisel.registry.ChiselMenus;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class AutoChiselMenu extends AbstractContainerMenu {

    private final ContainerData data;

    private static final int INPUT_SLOT_START = 0;
    private static final int INPUT_SLOT_END = 12;
    private static final int TEMPLATE_SLOT = 12;
    private static final int CHISEL_SLOT = 13;
    private static final int OUTPUT_SLOT_START = 14;
    private static final int OUTPUT_SLOT_END = 26;
    private static final int UPGRADE_SLOT_START = 26;
    private static final int UPGRADE_SLOT_END = 30;
    private static final int UPGRADE_STACK_SLOT = 26;
    private static final int UPGRADE_AUTOMATION_SLOT = 27;
    private static final int UPGRADE_REVERSION_SLOT = 28;
    private static final int UPGRADE_SPEED_SLOT = 29;
    private static final int INV_SLOT_START = 30;
    private static final int INV_SLOT_END = 57;
    private static final int HOTBAR_SLOT_START = 57;
    private static final int HOTBAR_SLOT_END = 66;

    public AutoChiselMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, (Container) inventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(4));
    }

    public AutoChiselMenu(int containerId, Inventory inventory, Container container, ContainerData data) {
        super(ChiselMenus.AUTO_CHISEL.get(), containerId);
        this.data = data;

        addInputSlots(container, inventory.player.level().registryAccess());
        addTemplateAndChiselSlots(container);
        addOutputSlots(container);
        addUpgradeSlots(container);
        addInventorySlots(inventory);

        addDataSlots(data);
    }

    private void addInputSlots(Container container, RegistryAccess registryAccess) {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                addSlot(new AutoChiselInputSlot(container, registryAccess, INPUT_SLOT_START + c + r * 3, 8 + c * 18, 19 + r * 18));
            }
        }
    }

    private void addTemplateAndChiselSlots(Container container) {
        addSlot(new Slot(container, TEMPLATE_SLOT, 80, 28) {
            @Override
            public int getMaxStackSize() {
                return 1;
            }
        });
        addSlot(new Slot(container, CHISEL_SLOT, 80, 64) {
            @Override
            public int getMaxStackSize() {
                return 1;
            }
        });
    }

    private void addUpgradeSlots(Container container) {
        addSlot(new UpgradeSlot(container, UPGRADE_STACK_SLOT, 98, 95, 1, ChiselItems.UPGRADE_STACK));
        addSlot(new UpgradeSlot(container, UPGRADE_AUTOMATION_SLOT, 116, 95, 1, ChiselItems.UPGRADE_AUTOMATION));
        addSlot(new UpgradeSlot(container, UPGRADE_REVERSION_SLOT, 134, 95, 1, ChiselItems.UPGRADE_REVERSION));
        addSlot(new UpgradeSlot(container, UPGRADE_SPEED_SLOT, 152, 95, 64, ChiselItems.UPGRADE_SPEED));
    }

    private void addOutputSlots(Container container) {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                addSlot(new Slot(container, OUTPUT_SLOT_START + c + r * 3, 116 + c * 18, 19 + r * 18) {
                    @Override
                    public boolean mayPlace(@NonNull ItemStack stack) {
                        return false;
                    }
                });
            }
        }
    }

    private void addInventorySlots(Inventory inventory) {
        int top = 118;
        int left = 8;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 9; c++) {
                addSlot(new Slot(inventory, c + r * 9 + 9, left + c * 18, top + r * 18));
            }
        }

        for (int c = 0; c < 9; c++) {
            addSlot(new Slot(inventory, c, left + c * 18, top + 58));
        }
    }

    @Override
    public @NonNull ItemStack quickMoveStack(@NonNull Player player, int index) {
        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack sourceStack = slot.getItem();
            originalStack = sourceStack.copy();

            // Move from machine to player inventory
            if (index < INV_SLOT_START) {
                if (!moveItemStackTo(sourceStack, INV_SLOT_START, HOTBAR_SLOT_END, true)) {
                    return ItemStack.EMPTY;
                }
            }
            // Move from player inventory to machine
            else {
                // Try and move upgrades
                if (sourceStack.is(ChiselItems.UPGRADE_STACK)) {
                    if (!moveItemStackTo(sourceStack, UPGRADE_STACK_SLOT, UPGRADE_STACK_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (sourceStack.is(ChiselItems.UPGRADE_AUTOMATION)) {
                    if (!moveItemStackTo(sourceStack, UPGRADE_AUTOMATION_SLOT, UPGRADE_AUTOMATION_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (sourceStack.is(ChiselItems.UPGRADE_REVERSION)) {
                    if (!moveItemStackTo(sourceStack, UPGRADE_REVERSION_SLOT, UPGRADE_REVERSION_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (sourceStack.is(ChiselItems.UPGRADE_SPEED)) {
                    if (!moveItemStackTo(sourceStack, UPGRADE_SPEED_SLOT, UPGRADE_SPEED_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                // Try and move a chisel
                else if (sourceStack.canPerformAction(ChiselItemAbilities.CHISEL)) {
                    if (!moveItemStackTo(sourceStack, CHISEL_SLOT, CHISEL_SLOT + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                // Try and move to input slots or template slot
                else {
                    if (!moveItemStackTo(sourceStack, INPUT_SLOT_START, INPUT_SLOT_END, false)) {
                        if (!moveItemStackTo(sourceStack, TEMPLATE_SLOT, TEMPLATE_SLOT + 1, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                }
            }

            if (sourceStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (sourceStack.getCount() == originalStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, sourceStack);
        }

        return originalStack;
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return true;
    }

    public int getProgress() {
        return data.get(0);
    }

    public boolean isTemplateInvalid() {
        if (isReversionActive()) return false;
        return data.get(1) == 1;
    }

    public boolean isChiselInvalid() {
        return data.get(2) == 1;
    }

    public boolean isReversionActive() {
        return data.get(3) == 1;
    }

    public boolean isInputInvalid(int slot) {
        if (slots.get(slot).container instanceof AutoChiselBlockEntity be) {
            return be.isInputInvalid(slot);
        }
        return false;
    }
}
