package io.github.chiselteam.chisel.projectile;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record MossEntry(BlockPos pos, int texture) {
    public static final Codec<MossEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockPos.CODEC.fieldOf("pos").forGetter(MossEntry::pos),
            Codec.intRange(1, 10).fieldOf("texture").forGetter(MossEntry::texture)
    ).apply(instance, MossEntry::new));

    public static final StreamCodec<FriendlyByteBuf, MossEntry> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, MossEntry::pos,
            ByteBufCodecs.VAR_INT, MossEntry::texture,
            MossEntry::new);
}
