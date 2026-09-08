package io.github.chiselteam.chisel.event;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.gui.palette.PaletteWallRenderer;
import io.github.chiselteam.chisel.client.gui.palette.PaletteWallState;
import io.github.chiselteam.chisel.client.gui.preview.PreviewPIP;
import io.github.chiselteam.chisel.client.gui.preview.PreviewPIPState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterPictureInPictureRenderersEvent;

@EventBusSubscriber(modid = Chisel.MODID, value = Dist.CLIENT)
public class RegisterPIPEventHandler {

    @SubscribeEvent
    public static void registerPIP(RegisterPictureInPictureRenderersEvent event) {
        event.register(PreviewPIPState.class, PreviewPIP::new);
        event.register(PaletteWallState.class, PaletteWallRenderer::new);
    }
}
