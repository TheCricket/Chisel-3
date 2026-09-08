package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.palette.PlayerPaletteManager;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

public record DeletePalettePacket(UUID id) implements CustomPacketPayload {
    public static final Type<DeletePalettePacket> TYPE = new Type<>(Chisel.prefix("delete_palette"));
    public static final StreamCodec<RegistryFriendlyByteBuf, DeletePalettePacket> STREAM_CODEC = UUIDUtil.STREAM_CODEC.map(DeletePalettePacket::new, DeletePalettePacket::id).cast();

    public static void handle(DeletePalettePacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (!(context.player() instanceof ServerPlayer player)) return;
            try {
                PlayerPaletteManager.delete(player, packet.id());
            } catch (IllegalArgumentException error) {
                player.sendSystemMessage(Component.literal(error.getMessage()));
            }
        });
    }

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
