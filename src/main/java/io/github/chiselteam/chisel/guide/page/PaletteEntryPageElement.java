package io.github.chiselteam.chisel.guide.page;

import io.github.chiselteam.chisel.guide.section.palette.PaletteEntry;

public record PaletteEntryPageElement(PaletteEntry entry, int totalWeight) implements HandbookPageElement {
    @Override
    public int height() {
        return 20;
    }

    public int percentage() {
        if (totalWeight <= 0) return 0;
        return Math.round(entry.weight() * 100F / totalWeight);
    }
}
