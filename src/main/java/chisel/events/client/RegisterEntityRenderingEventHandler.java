package chisel.events.client;

import chisel.Chisel;
import chisel.client.entity.AutoChiselBlockEntityRenderer;
import chisel.registry.ChiselBlockEntities;
import chisel.registry.ChiselEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Chisel.MODID, value = Dist.CLIENT)
public class RegisterEntityRenderingEventHandler {

    @SubscribeEvent
    public static void register(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ChiselEntities.BALL_O_MOSS.get(), context -> new ThrownItemRenderer<>(context, 1.0F, true));
        event.registerEntityRenderer(ChiselEntities.SMASHING_ROCK.get(), context -> new ThrownItemRenderer<>(context, 1.0F, true));
        event.registerEntityRenderer(ChiselEntities.CLOUD_IN_A_BOTTLE.get(), context -> new ThrownItemRenderer<>(context, 1.0F, true));

        event.registerBlockEntityRenderer(ChiselBlockEntities.AUTO_CHISEL.get(), AutoChiselBlockEntityRenderer::new);
    }
}
