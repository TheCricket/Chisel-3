package io.github.chiselteam.chisel.datagen.lang;

import io.github.chiselteam.chisel.util.LangHelper;

public final class PaletteLang {
    private PaletteLang() {
    }

    public static void addTranslations(LangHelper lang) {
        lang.add("chisel.palette.builder", "Palette Builder");
        lang.add("chisel.palette.new", "New palette");
        lang.add("chisel.palette.edit_hint", "Edit %s (%s blocks)");
        lang.add("chisel.palette.library_count", "%s / %s palettes");
        lang.add("chisel.palette.library_empty", "Create a palette to get started.");
        lang.add("chisel.palette.weight", "%s (%s%%)");
        lang.add("chisel.palette.title", "Palette title");
        lang.add("chisel.palette.search", "Search blocks");
        lang.add("chisel.palette.shuffle", "Shuffle");
        lang.add("chisel.palette.save", "Save");
        lang.add("chisel.palette.add", "Add %s (%s)");
        lang.add("chisel.palette.previous", "Previous page");
        lang.add("chisel.palette.next", "Next page");
        lang.add("chisel.palette.use_icon", "Use %s as the palette icon");
        lang.add("chisel.palette.remove", "Remove %s");
        lang.add("chisel.palette.enabled", "On");
        lang.add("chisel.palette.disabled", "Off");
        lang.add("chisel.palette.saving", "Saving...");
        lang.add("chisel.palette.saved", "Palette saved");
        lang.add("chisel.palette.discard_title", "Discard changes?");
        lang.add("chisel.palette.discard_body", "Your unsaved palette changes will be lost.");
        lang.add("chisel.palette.discard", "Discard");
        lang.add("chisel.palette.keep_editing", "Keep editing");
        lang.add("chisel.palette.preview", "Wall preview");
        lang.add("chisel.palette.preview_empty", "No enabled blocks");
        lang.add("chisel.palette.entries", "%s / %s blocks");
        lang.add("chisel.palette.color.all", "All colors");
        lang.add("chisel.palette.color.red", "Red");
        lang.add("chisel.palette.color.orange", "Orange");
        lang.add("chisel.palette.color.yellow", "Yellow");
        lang.add("chisel.palette.color.green", "Green");
        lang.add("chisel.palette.color.blue", "Blue");
        lang.add("chisel.palette.color.purple", "Purple");
        lang.add("chisel.palette.color.brown", "Brown");
        lang.add("chisel.palette.color.white", "White");
        lang.add("chisel.palette.color.gray", "Gray");
        lang.add("chisel.palette.color.black", "Black");
        lang.add("chisel.palette.color.indexing", "Finding block colors...");
        lang.add("chisel.palette.no_matches", "No matching blocks");
        lang.add("chisel.palette.entry_list", "Palette blocks");
        lang.add("chisel.palette.preview_controls", "Drag to rotate. Shift-drag to move. Scroll to zoom. Double-click to reset.");
    }
}
