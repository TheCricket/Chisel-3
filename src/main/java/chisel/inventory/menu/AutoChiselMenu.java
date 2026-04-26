package chisel.inventory.menu;

import chisel.registry.ChiselItems;
import chisel.registry.ChiselMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import chisel.block.entity.AutoChiselBlockEntity;
import net.minecraft.world.inventory.ContainerData;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.SimpleContainerData;
import org.jspecify.annotations.NonNull;

public class AutoChiselMenu extends AbstractContainerMenu {

    private final ContainerData data;

    public AutoChiselMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, (Container) inventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(4));
    }

    public AutoChiselMenu(int containerId, Inventory inventory, Container container, ContainerData data) {
        super(ChiselMenus.AUTO_CHISEL.get(), containerId);
        this.data = data;

        addInputSlots(container);
        addTemplateAndChiselSlots(container);
        addOutputSlots(container);
        addInventorySlots(inventory);
        addUpgradeSlots(container);

        addDataSlots(data);
    }

    private void addInputSlots(Container container) {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                addSlot(new Slot(container, c + r * 3, 8 + c * 18, 19 + r * 18));
            }
        }
    }

    private void addTemplateAndChiselSlots(Container container) {
        addSlot(new Slot(container, AutoChiselBlockEntity.TEMPLATE_SLOT, 80, 28));
        addSlot(new Slot(container, AutoChiselBlockEntity.CHISEL_SLOT, 80, 64));
    }

    private void addUpgradeSlots(Container container) {
        addSlot(new Slot(container, AutoChiselBlockEntity.STACK_UPGRADE_SLOT, 98, 95) {
            @Override
            public boolean mayPlace(@NonNull ItemStack stack) {
                return stack.is(ChiselItems.UPGRADE_STACK.get());
            }
        });
        addSlot(new Slot(container, AutoChiselBlockEntity.AUTOMATION_UPGRADE_SLOT, 116, 95) {
            @Override
            public boolean mayPlace(@NonNull ItemStack stack) {
                return stack.is(ChiselItems.UPGRADE_AUTOMATION.get());
            }
        });
        addSlot(new Slot(container, AutoChiselBlockEntity.REVERSION_UPGRADE_SLOT, 134, 95) {
            @Override
            public boolean mayPlace(@NonNull ItemStack stack) {
                return stack.is(ChiselItems.UPGRADE_REVERSION.get());
            }
        });
        addSlot(new Slot(container, AutoChiselBlockEntity.SPEED_UPGRADE_SLOT, 152, 95) {
            @Override
            public boolean mayPlace(@NonNull ItemStack stack) {
                return stack.is(ChiselItems.UPGRADE_SPEED.get());
            }
        });
    }

    private void addOutputSlots(Container container) {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                addSlot(new Slot(container, 14 + c + r * 3, 116 + c * 18, 19 + r * 18) {
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
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 26) {
                if (!this.moveItemStackTo(itemstack1, 30, 66, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index < 30) {
                if (!this.moveItemStackTo(itemstack1, 30, 66, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, 12, false)) {
                if (!this.moveItemStackTo(itemstack1, 12, 14, false)) {
                    if (!this.moveItemStackTo(itemstack1, 26, 30, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
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
