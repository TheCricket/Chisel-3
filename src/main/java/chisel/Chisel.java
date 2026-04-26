package chisel;

import chisel.registry.*;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Chisel.MODID)
public class Chisel {

    public static final String MODID = "chisel";

    public Chisel(IEventBus bus) {
        ChiselSounds.SOUNDS.register(bus);
        ChiselBlocks.registerBlocks(bus);
        ChiselBlockEntities.BLOCK_ENTITIES.register(bus);
        ChiselItems.ITEMS.register(bus);
        ChiselTabs.CREATIVE_MODE_TABS.register(bus);
        ChiselMenus.MENU_TYPES.register(bus);
        ChiselEntities.ENTITY_TYPES.register(bus);
        ChiselParticles.PARTICLES.register(bus);
        ChiselStats.STATS.register(bus);
    }

    public static Identifier prefix(String resource) {
        return Identifier.fromNamespaceAndPath(MODID, resource);
    }
}
