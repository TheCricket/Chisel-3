package chisel.registry;

import chisel.Chisel;
import chisel.menu.AutoChiselMenu;
import chisel.menu.ChiselMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChiselMenus {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, Chisel.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<ChiselMenu>> CHISEL;
    public static final DeferredHolder<MenuType<?>, MenuType<AutoChiselMenu>> AUTO_CHISEL;

    static {
        CHISEL = MENU_TYPES.register("chisel", () -> IMenuTypeExtension.create(ChiselMenu::new));
        AUTO_CHISEL = MENU_TYPES.register("auto_chisel", () -> IMenuTypeExtension.create(AutoChiselMenu::new));
    }
}
