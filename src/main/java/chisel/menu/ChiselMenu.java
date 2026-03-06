package chisel.menu;

import chisel.registry.ChiselMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ChiselMenu extends AbstractContainerMenu {

    public ChiselMenu(int containerId, Inventory inventory, FriendlyByteBuf extra) {
        super(ChiselMenus.CHISEL.get(), containerId);
    }

    @Override
    public @NonNull ItemStack quickMoveStack(@NonNull Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return false;
    }
}
