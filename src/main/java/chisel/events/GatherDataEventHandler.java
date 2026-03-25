package chisel.events;

import chisel.Chisel;
import chisel.datagen.*;
import chisel.datagen.lang.ChiselLang;
import chisel.datagen.model.ChiselModelProvider;
import chisel.registry.ChiselVariants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;

@EventBusSubscriber(modid = Chisel.MODID)
public class GatherDataEventHandler {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.getGenerator().addProvider(true, new DatapackBuiltinEntriesProvider(event.getGenerator().getPackOutput(), event.getLookupProvider(), ChiselVariants.BUILDER, Set.of(Chisel.MODID)));
        event.createProvider(ChiselModelProvider::new);
        event.createProvider(ChiselLootTableProvider::new);
        event.createProvider(ChiselLang::new);
        event.createProvider(ChiselSoundDefinitionProvider::new);
        event.createProvider(ChiselRecipes.Runner::new);
        event.createProvider(ChiselBlockTags::new);
    }
}
