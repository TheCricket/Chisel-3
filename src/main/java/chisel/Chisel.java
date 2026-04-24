package chisel;

import chisel.network.ChiselSearchPacket;
import chisel.registry.*;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Chisel.MODID)
public class Chisel {

    public static final String MODID = "chisel";
    public static final Logger LOGGER = LoggerFactory.getLogger(Chisel.MODID);

    public Chisel(IEventBus bus) {
        ChiselSounds.SOUNDS.register(bus);
        ChiselBlocks.registerBlocks(bus);
        ChiselBlockEntities.register(bus);
        ChiselItems.ITEMS.register(bus);
        ChiselTabs.CREATIVE_MODE_TABS.register(bus);
        ChiselMenus.MENU_TYPES.register(bus);
        ChiselEntities.ENTITY_TYPES.register(bus);
        ChiselParticles.PARTICLES.register(bus);
        bus.addListener(this::registerPayloads);
    }

    private void registerPayloads(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(MODID).versioned("1");
        registrar.playToServer(ChiselSearchPacket.TYPE, ChiselSearchPacket.STREAM_CODEC, ChiselSearchPacket::handle);
    }

    public static Identifier prefix(String resource) {
        return Identifier.fromNamespaceAndPath(MODID, resource);
    }
}
