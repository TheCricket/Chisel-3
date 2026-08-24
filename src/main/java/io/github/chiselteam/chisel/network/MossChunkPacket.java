package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.moss.ClientMossData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.level.ChunkPos;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

import java.util.List;

public record MossChunkPacket(ChunkPos chunk, List<BlockPos> positions) implements CustomPacketPayload {
    public static final Type<MossChunkPacket> TYPE = new Type<>(Chisel.prefix("moss_chunk"));
    public static final StreamCodec<FriendlyByteBuf, MossChunkPacket> STREAM_CODEC = StreamCodec.composite(
            ChunkPos.STREAM_CODEC, MossChunkPacket::chunk,
            BlockPos.STREAM_CODEC.apply(ByteBufCodecs.list()), MossChunkPacket::positions,
            MossChunkPacket::new);

    public static void handle(MossChunkPacket payload, IPayloadContext context) {
        context.enqueueWork(() -> ClientMossData.replaceChunk(payload.chunk, payload.positions));
    }

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
