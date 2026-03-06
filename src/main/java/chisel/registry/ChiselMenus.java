package chisel.registry;

import chisel.Chisel;
import chisel.menu.ChiselMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselMenus {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, Chisel.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<ChiselMenu>> CHISEL;

    static {
        CHISEL = MENU_TYPES.register("chisel", () -> IMenuTypeExtension.create(ChiselMenu::new));
    }
}
