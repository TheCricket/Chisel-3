package chisel.events;

import chisel.Chisel;
import chisel.registry.ChiselBlocks;
import net.minecraft.client.color.block.BlockTintSources;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterColorsEventHandler {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.BlockTintSources event) {
        ChiselBlocks.WATERSTONE.getFamily().getVariants().forEach(variant -> event.register(List.of(BlockTintSources.water(), BlockTintSources.waterParticles()), variant.getBlock()));
    }
}
