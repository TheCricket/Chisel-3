package chisel.events;

import chisel.Chisel;
import chisel.registry.ChiselVariants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import chisel.core.VariantFamily;

@EventBusSubscriber(modid = Chisel.MODID)
public class DatapackRegistryEventHandler {

    @SubscribeEvent
    public static void registerRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(ChiselVariants.VARIANT_FAMILY_REGISTRY_KEY, VariantFamily.CODEC, VariantFamily.CODEC);
    }
}
