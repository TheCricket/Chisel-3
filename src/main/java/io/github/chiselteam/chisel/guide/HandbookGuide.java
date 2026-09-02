package io.github.chiselteam.chisel.guide;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.Identifier;

import java.util.List;

public record HandbookGuide(Component title, Component description, Identifier icon, List<String> categories,
                            List<String> sections) {
    public static final Codec<HandbookGuide> CODEC = RecordCodecBuilder.create(i -> i.group(
            ComponentSerialization.CODEC.fieldOf("title").forGetter(HandbookGuide::title),
            ComponentSerialization.CODEC.fieldOf("description").forGetter(HandbookGuide::description),
            Identifier.CODEC.fieldOf("icon").forGetter(HandbookGuide::icon),
            Codec.STRING.listOf().fieldOf("categories").forGetter(HandbookGuide::categories),
            Codec.STRING.listOf().fieldOf("sections").forGetter(HandbookGuide::sections)
    ).apply(i, HandbookGuide::new));
}
