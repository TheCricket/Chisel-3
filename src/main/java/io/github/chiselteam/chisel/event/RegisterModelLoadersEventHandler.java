package io.github.chiselteam.chisel.event;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.datagen.model.blockstate.ConnectedTextureBlockModelDefinition;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterBlockStateModels;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterModelLoadersEventHandler {

    @SubscribeEvent
    public static void registerModelLoaders(RegisterBlockStateModels event) {
        event.registerDefinition(ConnectedTextureBlockModelDefinition.ID, ConnectedTextureBlockModelDefinition.CODEC);
    }
}

