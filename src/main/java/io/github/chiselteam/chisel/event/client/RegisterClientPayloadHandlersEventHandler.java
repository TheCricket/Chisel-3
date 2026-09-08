package io.github.chiselteam.chisel.event.client;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.gui.palette.PaletteEditorScreen;
import io.github.chiselteam.chisel.client.gui.palette.PaletteLibraryScreen;
import io.github.chiselteam.chisel.network.HandbookGuidesPacket;
import io.github.chiselteam.chisel.network.OpenPaletteBuilderPacket;
import io.github.chiselteam.chisel.network.PaletteSaveResultPacket;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.network.event.RegisterClientPayloadHandlersEvent;

@EventBusSubscriber(modid = Chisel.MODID, value = Dist.CLIENT)
public class RegisterClientPayloadHandlersEventHandler {

    @SubscribeEvent
    public static void registerClientPayloadHandlers(RegisterClientPayloadHandlersEvent event) {
        event.register(HandbookGuidesPacket.TYPE, HandbookGuidesPacket::handle);
        event.register(OpenPaletteBuilderPacket.TYPE, (packet, context) -> context.enqueueWork(() ->
                Minecraft.getInstance().setScreen(new PaletteLibraryScreen())));
        event.register(PaletteSaveResultPacket.TYPE, (packet, context) -> context.enqueueWork(() -> {
            if (Minecraft.getInstance().screen instanceof PaletteEditorScreen editor) editor.acceptSaveResult(packet);
        }));
    }
}
