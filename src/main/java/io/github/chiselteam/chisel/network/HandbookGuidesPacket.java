package io.github.chiselteam.chisel.network;

import com.mojang.serialization.Codec;
import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.guide.HandbookCategory;
import io.github.chiselteam.chisel.guide.HandbookGuide;
import io.github.chiselteam.chisel.guide.manager.ClientHandbookManager;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;

import java.util.Map;

public record HandbookGuidesPacket(Map<Identifier, HandbookGuide> guides,
                                   Map<Identifier, HandbookCategory> categories) implements CustomPacketPayload {
    public static final Type<HandbookGuidesPacket> TYPE = new Type<>(Chisel.prefix("handbook_guides"));

    private static final Codec<Map<Identifier, HandbookGuide>> GUIDE_MAP_CODEC = Codec.unboundedMap(Identifier.CODEC, HandbookGuide.CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Map<Identifier, HandbookGuide>> GUIDES_STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistries(GUIDE_MAP_CODEC);
    private static final Codec<Map<Identifier, HandbookCategory>> CATEGORY_MAP_CODEC = Codec.unboundedMap(Identifier.CODEC, HandbookCategory.CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Map<Identifier, HandbookCategory>> CATEGORIES_STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistries(CATEGORY_MAP_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, HandbookGuidesPacket> STREAM_CODEC = StreamCodec.composite(GUIDES_STREAM_CODEC, HandbookGuidesPacket::guides, CATEGORIES_STREAM_CODEC, HandbookGuidesPacket::categories, HandbookGuidesPacket::new);

    public HandbookGuidesPacket {
        guides = Map.copyOf(guides);
        categories = Map.copyOf(categories);
    }

    public static void handle(HandbookGuidesPacket packet, IPayloadContext context) {
        ClientHandbookManager.replace(packet.guides(), packet.categories());
    }

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
