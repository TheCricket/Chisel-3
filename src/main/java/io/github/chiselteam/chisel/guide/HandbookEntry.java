package io.github.chiselteam.chisel.guide;

import net.minecraft.resources.ResourceKey;

public record HandbookEntry(ResourceKey<HandbookGuide> key, HandbookGuide guide) {
}
