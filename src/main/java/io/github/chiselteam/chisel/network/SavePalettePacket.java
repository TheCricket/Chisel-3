package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.palette.PaletteDefinition;
import io.github.chiselteam.chisel.palette.PlayerPaletteManager;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

import java.util.Optional;
import java.util.UUID;

public record SavePalettePacket(UUID requestId, Optional<UUID> id,
                                PaletteDefinition definition) implements CustomPacketPayload {
    public static final Type<SavePalettePacket> TYPE = new Type<>(Chisel.prefix("save_palette"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SavePalettePacket> STREAM_CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, SavePalettePacket::requestId,
            UUIDUtil.STREAM_CODEC.apply(ByteBufCodecs::optional), SavePalettePacket::id,
            ByteBufCodecs.fromCodecWithRegistries(PaletteDefinition.CODEC), SavePalettePacket::definition,
            SavePalettePacket::new);

    public SavePalettePacket(Optional<UUID> id, PaletteDefinition definition) {
        this(UUID.randomUUID(), id, definition);
    }

    public static void handle(SavePalettePacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (!(context.player() instanceof ServerPlayer player)) return;
            try {
                var id = PlayerPaletteManager.save(player, packet.id(), packet.definition());
                PacketDistributor.sendToPlayer(player, new PaletteSaveResultPacket(packet.requestId(), Optional.of(id), ""));
            } catch (IllegalArgumentException error) {
                PacketDistributor.sendToPlayer(player, new PaletteSaveResultPacket(packet.requestId(), Optional.empty(), error.getMessage()));
            }
        });
    }

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
