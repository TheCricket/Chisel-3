package io.github.chiselteam.chisel.guide.section;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.guide.section.palette.PaletteEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.Identifier;

import java.util.List;

public record PaletteSection(Component title, List<PaletteEntry> entries) implements HandbookGuideSection {
    public static final MapCodec<PaletteSection> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            ComponentSerialization.CODEC.fieldOf("title").forGetter(PaletteSection::title),
            PaletteEntry.CODEC.listOf().fieldOf("entries").forGetter(PaletteSection::entries)
    ).apply(i, PaletteSection::new));

    @Override
    public Identifier type() {
        return Chisel.prefix("palette");
    }

    public int totalWeight() {
        return entries.stream().mapToInt(PaletteEntry::weight).sum();
    }

    public float percentage(PaletteEntry entry) {
        return (float) entry.weight() / totalWeight();
    }
}
