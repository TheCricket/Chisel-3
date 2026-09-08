package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.palette.PlayerPaletteManager;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

import java.util.Optional;
import java.util.UUID;

public record SelectPalettePacket(Optional<UUID> id) implements CustomPacketPayload {
    public static final Type<SelectPalettePacket> TYPE = new Type<>(Chisel.prefix("select_palette"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SelectPalettePacket> STREAM_CODEC = UUIDUtil.STREAM_CODEC.apply(ByteBufCodecs::optional).map(SelectPalettePacket::new, SelectPalettePacket::id).cast();

    public static void handle(SelectPalettePacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (!(context.player() instanceof ServerPlayer player)) return;
            try {
                PlayerPaletteManager.select(player, packet.id());
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
