package chisel.events;

import chisel.Chisel;
import chisel.client.particle.GrimstoneParticle;
import chisel.client.particle.HolystoneParticle;
import chisel.registry.ChiselParticles;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterParticleProvidersEventHandler {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ChiselParticles.HOLYSTONE.get(), HolystoneParticle.Provider::new);
        event.registerSpriteSet(ChiselParticles.GRIMSTONE.get(), GrimstoneParticle.Provider::new);
    }
}
