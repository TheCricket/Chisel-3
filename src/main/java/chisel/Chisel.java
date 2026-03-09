package chisel;

import chisel.registry.*;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Chisel.MODID)
public class Chisel {

    public static final String MODID = "chisel";

    public Chisel(IEventBus bus, ModContainer container, Dist dist) {
        ChiselBlocks.registerBlocks(bus);
        ChiselItems.ITEMS.register(bus);
        ChiselTabs.CREATIVE_MODE_TABS.register(bus);
        ChiselMenus.MENU_TYPES.register(bus);
        ChiselDataComponents.DATA_COMPONENTS.register(bus);
    }

    public static Identifier prefix(String resource) {
        return Identifier.fromNamespaceAndPath(MODID, resource);
    }
}
