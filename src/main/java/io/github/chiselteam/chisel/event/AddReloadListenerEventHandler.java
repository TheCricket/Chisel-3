package io.github.chiselteam.chisel.event;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.guide.manager.HandbookCategoryReloadListener;
import io.github.chiselteam.chisel.guide.manager.HandbookReferenceReloadListener;
import io.github.chiselteam.chisel.guide.manager.HandbookReloadListener;
import io.github.chiselteam.chisel.guide.manager.ServerHandbookManager;
import io.github.chiselteam.chisel.network.HandbookGuidesPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = Chisel.MODID)
public class AddReloadListenerEventHandler {

    @SubscribeEvent
    public static void addServerReloadListeners(AddServerReloadListenersEvent event) {
        event.addListener(Chisel.prefix("handbook_guides"), new HandbookReloadListener());
        event.addListener(Chisel.prefix("handbook_categories"), new HandbookCategoryReloadListener());
        event.addListener(Chisel.prefix("handbook_references"), new HandbookReferenceReloadListener());
        event.addDependency(Chisel.prefix("handbook_guides"), Chisel.prefix("handbook_references"));
        event.addDependency(Chisel.prefix("handbook_categories"), Chisel.prefix("handbook_references"));
    }

    @SubscribeEvent
    public static void onDatapackSync(OnDatapackSyncEvent event) {
        var guidesPacket = new HandbookGuidesPacket(ServerHandbookManager.getGuides(), ServerHandbookManager.getCategories());

        event.getRelevantPlayers().forEach(player -> PacketDistributor.sendToPlayer(player, guidesPacket));
    }
}
