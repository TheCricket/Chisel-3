package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.moss.ClientMossData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

public record MossDeltaPacket(BlockPos pos, boolean mossy) implements CustomPacketPayload {
    public static final Type<MossDeltaPacket> TYPE = new Type<>(Chisel.prefix("moss_delta"));
    public static final StreamCodec<FriendlyByteBuf, MossDeltaPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, MossDeltaPacket::pos, ByteBufCodecs.BOOL, MossDeltaPacket::mossy, MossDeltaPacket::new);

    public static void handle(MossDeltaPacket payload, IPayloadContext context) {
        context.enqueueWork(() -> ClientMossData.set(payload.pos, payload.mossy));
    }

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
