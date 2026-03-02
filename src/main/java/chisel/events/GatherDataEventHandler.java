package chisel.events;

import chisel.Chisel;
import chisel.datagen.ChiselLootTableProvider;
import chisel.datagen.ChiselModelProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class GatherDataEventHandler {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ChiselModelProvider::new);
        event.createProvider(ChiselLootTableProvider::new);
    }
}
