package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jspecify.annotations.NonNull;

import java.util.Optional;
import java.util.UUID;

public record PaletteSaveResultPacket(UUID requestId, Optional<UUID> paletteId,
                                      String error) implements CustomPacketPayload {
    public static final Type<PaletteSaveResultPacket> TYPE = new Type<>(Chisel.prefix("palette_save_result"));
    public static final StreamCodec<RegistryFriendlyByteBuf, PaletteSaveResultPacket> STREAM_CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, PaletteSaveResultPacket::requestId,
            UUIDUtil.STREAM_CODEC.apply(ByteBufCodecs::optional), PaletteSaveResultPacket::paletteId,
            ByteBufCodecs.STRING_UTF8, PaletteSaveResultPacket::error, PaletteSaveResultPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
