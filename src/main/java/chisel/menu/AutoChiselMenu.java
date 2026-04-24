package chisel.menu;

import chisel.registry.ChiselMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class AutoChiselMenu extends AbstractContainerMenu {

    public AutoChiselMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        super(ChiselMenus.AUTO_CHISEL.get(), containerId);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
