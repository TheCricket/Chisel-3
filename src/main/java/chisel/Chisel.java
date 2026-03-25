package chisel;

import chisel.registry.*;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import java.util.logging.Logger;

@Mod(Chisel.MODID)
public class Chisel {

    public static final String MODID = "chisel";
    public static final Logger LOGGER = Logger.getLogger(Chisel.MODID);

    public Chisel(IEventBus bus) {
        ChiselSounds.SOUNDS.register(bus);
        ChiselBlocks.registerBlocks(bus);
        ChiselBlockEntities.register(bus);
        ChiselItems.ITEMS.register(bus);
        ChiselTabs.CREATIVE_MODE_TABS.register(bus);
        ChiselMenus.MENU_TYPES.register(bus);
    }

    public static Identifier prefix(String resource) {
        return Identifier.fromNamespaceAndPath(MODID, resource);
    }
}
