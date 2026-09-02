package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.guide.HandbookGuide;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class ChiselHandbookGuides {

    public static final ResourceKey<Registry<HandbookGuide>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("handbook_guides"));

}
