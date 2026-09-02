package io.github.chiselteam.chisel.guide.section.palette;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;

public record PaletteEntry(Identifier block, PaletteRole role, int weight) {
    public static final Codec<PaletteEntry> CODEC = RecordCodecBuilder.create(i -> i.group(
            Identifier.CODEC.fieldOf("block").forGetter(PaletteEntry::block),
            PaletteRole.CODEC.fieldOf("role").forGetter(PaletteEntry::role),
            Codec.intRange(1, 100).fieldOf("weight").forGetter(PaletteEntry::weight)
    ).apply(i, PaletteEntry::new));
}
