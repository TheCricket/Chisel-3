package io.github.chiselteam.chisel.events;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.network.MossChunkPacket;
import io.github.chiselteam.chisel.network.MossDeltaPacket;
import io.github.chiselteam.chisel.registry.ChiselAttachments;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.ChunkWatchEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = Chisel.MODID)
public final class MossEventHandler {
    private MossEventHandler() {
    }

    @SubscribeEvent
    public static void onChunkSent(ChunkWatchEvent.Sent event) {
        var data = event.getLevel().getData(ChiselAttachments.MOSS);
        PacketDistributor.sendToPlayer(event.getPlayer(), new MossChunkPacket(event.getPos(), data.inChunk(event.getPos())));
    }

    @SubscribeEvent
    public static void onBreak(BreakBlockEvent event) {
        if (!event.isCanceled()) remove(event.getLevel(), event.getPos());
    }

    @SubscribeEvent
    public static void onPlace(BlockEvent.EntityPlaceEvent event) {
        remove(event.getLevel(), event.getPos());
    }

    private static void remove(LevelAccessor accessor, net.minecraft.core.BlockPos pos) {
        if (!(accessor instanceof ServerLevel level)) return;
        var moss = level.getData(ChiselAttachments.MOSS);
        if (moss.remove(pos)) {
            level.setData(ChiselAttachments.MOSS, moss);
            PacketDistributor.sendToPlayersTrackingChunk(level, level.getChunkAt(pos).getPos(), new MossDeltaPacket(pos, false));
        }
    }
}
