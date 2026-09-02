package io.github.chiselteam.chisel.guide;

import io.github.chiselteam.chisel.registry.ChiselHandbookGuides;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HandbookManager {

    public HandbookManager() {

    }

    public static List<HandbookGuide> getGuides(RegistryAccess registryAccess) {
        Registry<HandbookGuide> registry = registryAccess.lookup(ChiselHandbookGuides.KEY).orElse(null);
        if (registry == null) return List.of();

        List<HandbookGuide> guides = new ArrayList<>();
        registry.forEach(guides::add);
        guides.sort(Comparator.comparing(guide -> guide.title().getString()));

        return List.copyOf(guides);
    }
}
