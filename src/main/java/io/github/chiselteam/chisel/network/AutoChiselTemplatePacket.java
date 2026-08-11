package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.inventory.menu.AutoChiselMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

public record AutoChiselTemplatePacket(Identifier blockId) implements CustomPacketPayload {

    public static final Type<AutoChiselTemplatePacket> TYPE = new Type<>(Chisel.prefix("auto_chisel_template"));
    public static final StreamCodec<FriendlyByteBuf, AutoChiselTemplatePacket> STREAM_CODEC = StreamCodec.composite(
            Identifier.STREAM_CODEC, AutoChiselTemplatePacket::blockId,
            AutoChiselTemplatePacket::new
    );

    public static void handle(AutoChiselTemplatePacket payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof AutoChiselMenu menu) {
                menu.selectTemplateVariant(context.player(), payload.blockId());
            }
        });
    }

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
