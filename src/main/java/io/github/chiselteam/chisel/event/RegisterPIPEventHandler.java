package io.github.chiselteam.chisel.event;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.gui.preview.PreviewPIP;
import io.github.chiselteam.chisel.client.gui.preview.PreviewPIPState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterPictureInPictureRenderersEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterPIPEventHandler {

    @SubscribeEvent
    public static void registerPIP(RegisterPictureInPictureRenderersEvent event) {
        event.register(PreviewPIPState.class, PreviewPIP::new);
    }
}
