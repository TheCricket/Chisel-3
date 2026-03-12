package chisel.events;

import chisel.Chisel;
import chisel.datagen.ChiselLootTableProvider;
import chisel.datagen.ChiselModelProvider;
import chisel.datagen.ChiselSoundDefinitionProvider;
import chisel.datagen.lang.ChiselLang;
import chisel.registry.ChiselVariants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Chisel.MODID)
public class GatherDataEventHandler {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.getGenerator().addProvider(true, new DatapackBuiltinEntriesProvider(event.getGenerator().getPackOutput(), event.getLookupProvider(), ChiselVariants.BUILDER, Set.of(Chisel.MODID)));
        event.createProvider(ChiselModelProvider::new);
        event.createProvider(ChiselLootTableProvider::new);
        event.createProvider(ChiselLang::new);
        event.createProvider(ChiselSoundDefinitionProvider::new);
    }
}
