package io.github.chiselteam.chisel.events;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.network.*;
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
        registrar.playToServer(ChiselModeChangePacket.TYPE, ChiselModeChangePacket.STREAM_CODEC, ChiselModeChangePacket::handle);
        registrar.playToServer(ChiselSelectionPacket.TYPE, ChiselSelectionPacket.STREAM_CODEC, ChiselSelectionPacket::handle);
        registrar.playToServer(AutoChiselTemplatePacket.TYPE, AutoChiselTemplatePacket.STREAM_CODEC, AutoChiselTemplatePacket::handle);
        registrar.playToClient(MossChunkPacket.TYPE, MossChunkPacket.STREAM_CODEC, MossChunkPacket::handle);
        registrar.playToClient(MossDeltaPacket.TYPE, MossDeltaPacket.STREAM_CODEC, MossDeltaPacket::handle);
    }
}
