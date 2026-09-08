package io.github.chiselteam.chisel.palette;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;

import java.util.HashSet;
import java.util.List;

public record PaletteDefinition(String name, String description, Identifier icon, List<WeightedBlock> entries) {
    public static final int MAX_ENTRIES = 64;
    public static final int MAX_NAME_LENGTH = 64;
    public static final int MAX_DESCRIPTION_LENGTH = 512;
    public static final Codec<Identifier> IDENTIFIER_CODEC = WeightedBlock.IDENTIFIER_CODEC;
    public static final Codec<PaletteDefinition> CODEC = RecordCodecBuilder.<PaletteDefinition>create(i -> i.group(
            Codec.string(1, MAX_NAME_LENGTH).fieldOf("name").forGetter(PaletteDefinition::name),
            Codec.string(0, MAX_DESCRIPTION_LENGTH).optionalFieldOf("description", "").forGetter(PaletteDefinition::description),
            IDENTIFIER_CODEC.fieldOf("icon").forGetter(PaletteDefinition::icon),
            WeightedBlock.CODEC.listOf(0, MAX_ENTRIES).fieldOf("entries").forGetter(PaletteDefinition::entries)
    ).apply(i, PaletteDefinition::new)).validate(PaletteDefinition::validate);

    public PaletteDefinition {
        entries = List.copyOf(entries);
    }

    public static DataResult<PaletteDefinition> validate(PaletteDefinition value) {
        if (value.name().isBlank() || value.name().length() > MAX_NAME_LENGTH)
            return DataResult.error(() -> "Palette name must contain 1-64 characters and cannot be blank");
        if (value.description().length() > MAX_DESCRIPTION_LENGTH)
            return DataResult.error(() -> "Palette description must contain at most 512 characters");
        if (value.icon().toString().length() > 256 || value.entries().size() > MAX_ENTRIES)
            return DataResult.error(() -> "Palette exceeds icon or entry limits");
        var blocks = new HashSet<Identifier>();
        for (var entry : value.entries()) {
            if (entry.weight() < 1 || entry.weight() > 100 || entry.block().toString().length() > 256)
                return DataResult.error(() -> "Entry weights must be 1-100 and block IDs at most 256 characters");
            if (!blocks.add(entry.block())) return DataResult.error(() -> "A block may appear only once in a palette");
        }
        return DataResult.success(value);
    }

    public int enabledWeight() {
        return entries.stream().filter(WeightedBlock::enabled).mapToInt(WeightedBlock::weight).sum();
    }

    public PaletteDefinition withEntries(List<WeightedBlock> newEntries) {
        return new PaletteDefinition(name, description, icon, newEntries);
    }
}
