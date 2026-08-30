package io.github.chiselteam.chisel.event;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.content.ChiselFamilies;
import net.minecraft.client.color.block.BlockTintSources;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterColorsEventHandler {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.BlockTintSources event) {
        ChiselFamilies.WATERSTONE.getFamily().getVariants().forEach(variant -> event.register(List.of(BlockTintSources.water(), BlockTintSources.waterParticles()), variant.getBlock()));
    }
}
