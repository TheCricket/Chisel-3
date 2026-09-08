package io.github.chiselteam.chisel.palette;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;

import java.util.UUID;

public record PlayerPalette(UUID id, PaletteDefinition definition) {
    public static final Codec<PlayerPalette> CODEC = RecordCodecBuilder.create(i -> i.group(
            UUIDUtil.STRING_CODEC.fieldOf("id").forGetter(PlayerPalette::id),
            PaletteDefinition.CODEC.fieldOf("definition").forGetter(PlayerPalette::definition)
    ).apply(i, PlayerPalette::new));
}
