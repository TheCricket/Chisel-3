package io.github.chiselteam.chisel.events.client;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.overlay.ChiselModeOverlay;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterGuiLayersEventHandler {

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
        event.registerAboveAll(Chisel.prefix("mode_selector"), (graphics, _) -> ChiselModeOverlay.render(graphics));
    }
}
