package io.github.chiselteam.chisel.guide.manager;

import io.github.chiselteam.chisel.guide.*;
import net.minecraft.resources.Identifier;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ClientHandbookManager {
    private static volatile Snapshot snapshot = Snapshot.EMPTY;

    private ClientHandbookManager() {
    }

    public static void replace(Map<Identifier, HandbookGuide> newGuides, Map<Identifier, HandbookCategory> newCategories) {
        var orderedGuides = new LinkedHashMap<Identifier, HandbookGuide>();
        newGuides.entrySet().stream().sorted(Comparator
                        .comparingInt((Map.Entry<Identifier, HandbookGuide> entry) -> entry.getValue().sortOrder())
                        .thenComparing(entry -> entry.getKey().toString()))
                .forEach(entry -> orderedGuides.put(entry.getKey(), entry.getValue()));
        var entries = orderedGuides.entrySet().stream().map(entry -> new HandbookEntry(entry.getKey(), entry.getValue())).toList();
        var index = HandbookCategoryIndex.buildCategories(orderedGuides);
        var categories = newCategories.entrySet().stream()
                .map(entry -> new HandbookCategoryEntry(entry.getKey(), entry.getValue()))
                .filter(entry -> !index.getOrDefault(entry.id(), List.of()).isEmpty())
                .sorted(Comparator.comparingInt((HandbookCategoryEntry entry) -> entry.category().sortOrder())
                        .thenComparing(entry -> entry.id().toString())).toList();
        snapshot = new Snapshot(entries, newCategories, categories, index, snapshot.revision() + 1);
    }

    public static void clear() {
        snapshot = new Snapshot(List.of(), Map.of(), List.of(), Map.of(), snapshot.revision() + 1);
    }

    public static Snapshot getSnapshot() {
        return snapshot;
    }

    public static List<HandbookEntry> getEntries() {
        return snapshot.entries();
    }

    public static Map<Identifier, HandbookCategory> getCategories() {
        return snapshot.categories();
    }

    public static Map<Identifier, List<HandbookEntry>> getCategoryIndex() {
        return snapshot.categoryIndex();
    }

    public static long getRevision() {
        return snapshot.revision();
    }
}
