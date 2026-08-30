package io.github.chiselteam.chisel.event;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.gui.AutoChiselScreen;
import io.github.chiselteam.chisel.client.gui.ChiselScreen;
import io.github.chiselteam.chisel.registry.ChiselMenus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterMenuScreensEventHandler {

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ChiselMenus.CHISEL.get(), ChiselScreen::new);
        event.register(ChiselMenus.AUTO_CHISEL.get(), AutoChiselScreen::new);
    }
}
