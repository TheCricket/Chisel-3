package chisel.events;

import chisel.Chisel;
import chisel.client.ctm.UnbakedConnectedTextureBlockStateModel;
import chisel.datagen.model.ConnectedTextureBlockModelDefinition;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterBlockStateModels;

@EventBusSubscriber(modid = Chisel.MODID)
public class RegisterModelLoadersEventHandler {

    @SubscribeEvent
    public static void registerModelLoaders(RegisterBlockStateModels event) {
        event.registerModel(UnbakedConnectedTextureBlockStateModel.ID, UnbakedConnectedTextureBlockStateModel.CODEC);
        event.registerDefinition(ConnectedTextureBlockModelDefinition.ID, ConnectedTextureBlockModelDefinition.CODEC);
    }
}
