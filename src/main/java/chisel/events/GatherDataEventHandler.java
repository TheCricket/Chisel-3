package chisel.events;

import chisel.Chisel;
import chisel.datagen.*;
import chisel.datagen.model.ChiselModelProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class GatherDataEventHandler {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ChiselModelProvider::new);
        event.createProvider(ChiselLootTableProvider::new);
        event.createProvider(ChiselLang::new);
        event.createProvider(ChiselSoundDefinitionProvider::new);
        event.createProvider(ChiselRecipes.Runner::new);
        event.createProvider(ChiselBlockTags::new);
        event.createProvider(ChiselRegistries::new);
    }
}
