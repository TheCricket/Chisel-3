package io.github.chiselteam.chisel.guide.manager;

import io.github.chiselteam.chisel.guide.HandbookCategory;
import io.github.chiselteam.chisel.guide.HandbookGuide;
import net.minecraft.resources.Identifier;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ServerHandbookManager {
    private static Map<Identifier, HandbookGuide> guides = Map.of();
    private static Map<Identifier, HandbookCategory> categories = Map.of();

    private ServerHandbookManager() {
    }

    public static void replaceGuides(Map<Identifier, HandbookGuide> newGuides) {
        guides = Collections.unmodifiableMap(new LinkedHashMap<>(newGuides));
    }

    public static void replaceCategories(Map<Identifier, HandbookCategory> newCategories) {
        categories = Collections.unmodifiableMap(new LinkedHashMap<>(newCategories));
    }

    public static Map<Identifier, HandbookGuide> getGuides() {
        return guides;
    }

    public static Map<Identifier, HandbookCategory> getCategories() {
        return categories;
    }
}
