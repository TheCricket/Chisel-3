package io.github.chiselteam.chisel.guide.section;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.chiselteam.chisel.Chisel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.Identifier;

public record TipSection(Component text) implements HandbookGuideSection {
    public static final MapCodec<TipSection> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            ComponentSerialization.CODEC.fieldOf("text").forGetter(TipSection::text)
    ).apply(i, TipSection::new));

    @Override
    public Identifier type() {
        return Chisel.prefix("tip");
    }
}
