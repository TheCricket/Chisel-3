package io.github.chiselteam.chisel.network;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.chisel.ChiselMode;
import io.github.chiselteam.chisel.registry.ChiselDataComponents;
import io.github.chiselteam.chisel.registry.ChiselItemAbilities;
import io.github.chiselteam.chisel.registry.ChiselModes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

public record ChiselModeChangePacket(InteractionHand hand, ChiselMode mode) implements CustomPacketPayload {

    public static final Type<ChiselModeChangePacket> TYPE = new Type<>(Chisel.prefix("mode_change"));

    public static final StreamCodec<FriendlyByteBuf, ChiselModeChangePacket> STREAM_CODEC = StreamCodec.of(
            (buffer, packet) -> {
                buffer.writeBoolean(packet.hand == InteractionHand.MAIN_HAND);
                ChiselMode.STREAM_CODEC.encode(buffer, packet.mode);
            },
            buffer -> new ChiselModeChangePacket(
                    buffer.readBoolean() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND,
                    ChiselMode.STREAM_CODEC.decode(buffer)
            )
    );

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(ChiselModeChangePacket payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if(ChiselModes.REGISTRY.getOptional(payload.mode.registryName()).isEmpty()) return;
            ItemStack stack = context.player().getItemInHand(payload.hand);

            if(stack.isEmpty()) return;
            if(!stack.canPerformAction(ChiselItemAbilities.CHISEL)) return;

            stack.set(ChiselDataComponents.CHISEL_MODE, payload.mode);
        });
    }
}
