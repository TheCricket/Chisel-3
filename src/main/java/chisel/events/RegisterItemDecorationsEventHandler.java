package chisel.events;

import chisel.Chisel;
import chisel.client.ChiselItemDecorator;
import chisel.registry.ChiselItems;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterItemDecorationsEventHandler {

    @SubscribeEvent
    public static void registerItemDecorations(RegisterItemDecorationsEvent event) {
        event.register(ChiselItems.CHISEL_IRON, new ChiselItemDecorator());
        event.register(ChiselItems.CHISEL_DIAMOND, new ChiselItemDecorator());
        event.register(ChiselItems.CHISEL_OBSIDIAN, new ChiselItemDecorator());
    }
}
