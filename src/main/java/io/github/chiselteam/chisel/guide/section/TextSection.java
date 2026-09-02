package io.github.chiselteam.chisel.guide.section;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.chiselteam.chisel.Chisel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.Identifier;

public record TextSection(Component text) implements HandbookGuideSection {
    public static final MapCodec<TextSection> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            ComponentSerialization.CODEC.fieldOf("text").forGetter(TextSection::text)
    ).apply(i, TextSection::new));

    @Override
    public Identifier type() {
        return Chisel.prefix("text");
    }
}
