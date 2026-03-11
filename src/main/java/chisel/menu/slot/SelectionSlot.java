package chisel.menu.slot;

import chisel.core.Variant;
import chisel.item.ChiselItem;
import chisel.menu.ChiselContainer;
import chisel.menu.ChiselSelectionInventory;
import chisel.util.VariantFinder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SelectionSlot extends Slot {
    private final ChiselSelectionInventory selectionInventory;
    private final ChiselContainer container;

    public SelectionSlot(ChiselContainer container, ChiselSelectionInventory selectionInventory, int slot, int x, int y) {
        super(selectionInventory, slot, x, y);
        this.container = container;
        this.selectionInventory = selectionInventory;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @Override
    public boolean mayPickup(Player player) {
        return player.getInventory().getSelectedItem().isEmpty();
    }

    @Override
    protected void onQuickCraft(ItemStack picked, int count) {
        super.onQuickCraft(picked, count);

        ItemStack crafted = container.selectionInventory.getStackInSpecialSlot();
        ItemStack chisel = container.chisel;
        ItemStack res = ItemStack.EMPTY;
    }

    @Override
    public void onTake(Player player, ItemStack carried) {
        super.onTake(player, carried);
        /*ItemStack chisel = container.getChisel().copy();
        ItemStack res = craft(container, player, itemstack, false);
        if (container.currentClickType != ClickType.PICKUP) {
            res.shrink(1);
        }
        if (!res.isEmpty()) {
            player.playSound(SoundEvents.GHAST_SCREAM, 1.0F, 1.0F);
            player.getInventory().setItem(res);
        }*/
    }
}
