package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.gui.BuildersHandbookScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

public class OpenHandbookPacket implements CustomPacketPayload {
    public static final OpenHandbookPacket INSTANCE = new OpenHandbookPacket();
    public static final Type<OpenHandbookPacket> TYPE = new Type<>(Chisel.prefix("open_handbook"));
    public static final StreamCodec<FriendlyByteBuf, OpenHandbookPacket> STREAM_CODEC = StreamCodec.unit(INSTANCE);

    public static void handle(OpenHandbookPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> Minecraft.getInstance().setScreen(new BuildersHandbookScreen()));
    }

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
