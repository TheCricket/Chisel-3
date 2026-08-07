package io.github.chiselteam.chisel.events;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.network.ChiselConfirmPacket;
import io.github.chiselteam.chisel.network.ChiselModeChangePacket;
import io.github.chiselteam.chisel.network.ChiselModePacket;
import io.github.chiselteam.chisel.network.ChiselSearchPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterPayloadHandlersEventHandler {

    @SubscribeEvent
    public static void registerPayloads(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(Chisel.MODID).versioned("1");
        registrar.playToServer(ChiselSearchPacket.TYPE, ChiselSearchPacket.STREAM_CODEC, ChiselSearchPacket::handle);
        registrar.playToServer(ChiselModePacket.TYPE, ChiselModePacket.STREAM_CODEC, ChiselModePacket::handle);
        registrar.playToServer(ChiselModeChangePacket.TYPE, ChiselModeChangePacket.STREAM_CODEC, ChiselModeChangePacket::handle);
        registrar.playToServer(ChiselConfirmPacket.TYPE, ChiselConfirmPacket.STREAM_CODEC, ChiselConfirmPacket::handle);
    }
}
