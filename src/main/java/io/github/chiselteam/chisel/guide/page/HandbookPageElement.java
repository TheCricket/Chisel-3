package io.github.chiselteam.chisel.guide.page;

public sealed interface HandbookPageElement permits TitlePageElement, TextPageElement, TipPageElement, PaletteTitlePageElement, PaletteEntryPageElement {
    int height();
}
