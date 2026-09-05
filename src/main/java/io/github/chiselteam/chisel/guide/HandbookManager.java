package io.github.chiselteam.chisel.guide;

import io.github.chiselteam.chisel.registry.ChiselHandbookGuides;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class HandbookManager {

    public HandbookManager() {
    }

    public static List<HandbookEntry> getGuides(RegistryAccess registryAccess) {
        var registry = registryAccess.lookup(ChiselHandbookGuides.KEY).orElse(null);
        if (registry == null) return List.of();

        List<HandbookEntry> guides = new ArrayList<>();

        for (Map.Entry<ResourceKey<HandbookGuide>, HandbookGuide> entry : registry.entrySet()) {
            guides.add(new HandbookEntry(entry.getKey(), entry.getValue()));
        }

        guides.sort(Comparator.comparing(entry -> entry.guide().title().getString()));

        return List.copyOf(guides);
    }
}
