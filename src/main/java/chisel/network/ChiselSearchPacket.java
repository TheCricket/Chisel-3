package chisel.network;

import chisel.Chisel;
import chisel.menu.ChiselMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ChiselSearchPacket(String filter, float scrollOffset) implements CustomPacketPayload {

    public static final Type<ChiselSearchPacket> TYPE = new Type<>(Chisel.prefix("search"));

    public static final StreamCodec<FriendlyByteBuf, ChiselSearchPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, ChiselSearchPacket::filter,
            ByteBufCodecs.FLOAT, ChiselSearchPacket::scrollOffset,
            ChiselSearchPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(final ChiselSearchPacket payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof ChiselMenu menu) {
                menu.setSearchState(payload.filter(), payload.scrollOffset());
            }
        });
    }
}
