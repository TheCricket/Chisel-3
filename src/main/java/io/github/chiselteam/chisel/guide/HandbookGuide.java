package io.github.chiselteam.chisel.guide;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.chiselteam.chisel.guide.section.HandbookGuideSection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.Identifier;

import java.util.List;

public record HandbookGuide(Component title, Component description, Identifier icon, List<Identifier> categories,
                            List<HandbookGuideSection> sections, int sortOrder) {
    public static final Codec<HandbookGuide> CODEC = RecordCodecBuilder.create(i -> i.group(
            ComponentSerialization.CODEC.fieldOf("title").forGetter(HandbookGuide::title),
            ComponentSerialization.CODEC.fieldOf("description").forGetter(HandbookGuide::description),
            Identifier.CODEC.fieldOf("icon").forGetter(HandbookGuide::icon),
            Identifier.CODEC.listOf().fieldOf("categories").forGetter(HandbookGuide::categories),
            HandbookGuideSection.CODEC.listOf().fieldOf("sections").forGetter(HandbookGuide::sections),
            Codec.INT.optionalFieldOf("sort_order", 0).forGetter(HandbookGuide::sortOrder)
    ).apply(i, HandbookGuide::new));
}
