package io.github.chiselteam.chisel.guide;

import net.minecraft.resources.Identifier;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public record Snapshot(List<HandbookEntry> entries, Map<Identifier, HandbookCategory> categories,
                       List<HandbookCategoryEntry> categoryEntries,
                       Map<Identifier, List<HandbookEntry>> categoryIndex, long revision) {
    public static final Snapshot EMPTY = new Snapshot(List.of(), Map.of(), List.of(), Map.of(), 0);

    public Snapshot {
        entries = List.copyOf(entries);
        categories = Collections.unmodifiableMap(new LinkedHashMap<>(categories));
        categoryEntries = List.copyOf(categoryEntries);
        var index = new LinkedHashMap<Identifier, List<HandbookEntry>>();
        categoryIndex.forEach((id, guides) -> index.put(id, List.copyOf(guides)));
        categoryIndex = Collections.unmodifiableMap(index);
    }
}
