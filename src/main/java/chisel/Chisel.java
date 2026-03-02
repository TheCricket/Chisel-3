package chisel;

import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselItems;
import chisel.registry.ChiselTabs;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Chisel.MODID)
public class Chisel {

    public static final String MODID = "chisel";

    public Chisel(IEventBus bus, ModContainer container, Dist dist) {
        ChiselBlocks.BLOCKS.register(bus);
        ChiselItems.ITEMS.register(bus);
        ChiselTabs.CREATIVE_MODE_TABS.register(bus);
    }

    public static Identifier prefix(String resource) {
        return Identifier.fromNamespaceAndPath(MODID, resource);
    }
}
