package chisel.events;

import chisel.Chisel;
import chisel.menu.ChiselScreen;
import chisel.registry.ChiselMenus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterMenuScreensEventHandler {

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ChiselMenus.CHISEL.get(), ChiselScreen::new);
    }
}
