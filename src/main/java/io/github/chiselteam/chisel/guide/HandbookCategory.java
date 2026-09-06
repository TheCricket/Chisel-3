package io.github.chiselteam.chisel.guide;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.Identifier;

public record HandbookCategory(Component title, Component description, Identifier icon, int sortOrder) {
    public static final Codec<HandbookCategory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ComponentSerialization.CODEC.fieldOf("title").forGetter(HandbookCategory::title),
            ComponentSerialization.CODEC.fieldOf("description").forGetter(HandbookCategory::description),
            Identifier.CODEC.fieldOf("icon").forGetter(HandbookCategory::icon),
            Codec.INT.optionalFieldOf("sort_order", 0).forGetter(HandbookCategory::sortOrder)
    ).apply(instance, HandbookCategory::new));
}
