package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.inventory.menu.ChiselMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

public record ChiselSelectionPacket(int selectionIndex, boolean bulk) implements CustomPacketPayload {

    public static final Type<ChiselSelectionPacket> TYPE = new Type<>(Chisel.prefix("selection"));
    public static final StreamCodec<FriendlyByteBuf, ChiselSelectionPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ChiselSelectionPacket::selectionIndex,
            ByteBufCodecs.BOOL, ChiselSelectionPacket::bulk,
            ChiselSelectionPacket::new
    );

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(ChiselSelectionPacket payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof ChiselMenu menu)
                menu.selectVariant(context.player(), payload.selectionIndex(), payload.bulk());
        });
    }
}
