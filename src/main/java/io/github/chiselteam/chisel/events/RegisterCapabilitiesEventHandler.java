package io.github.chiselteam.chisel.events;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.inventory.AutoChiselContainerWrapper;
import io.github.chiselteam.chisel.registry.ChiselBlockEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterCapabilitiesEventHandler {

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.Item.BLOCK, ChiselBlockEntities.AUTO_CHISEL.get(), AutoChiselContainerWrapper::new);
    }
}
