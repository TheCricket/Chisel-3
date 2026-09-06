package io.github.chiselteam.chisel.guide.manager;

import io.github.chiselteam.chisel.guide.HandbookGuide;
import io.github.chiselteam.chisel.guide.page.*;
import io.github.chiselteam.chisel.guide.section.PaletteSection;
import io.github.chiselteam.chisel.guide.section.TextSection;
import io.github.chiselteam.chisel.guide.section.TipSection;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public final class HandbookPaginator {
    public static final int PAGE_CONTENT_WIDTH = 114;
    public static final int PAGE_CONTENT_HEIGHT = 142;
    public static final int LINE_HEIGHT = 10;

    private HandbookPaginator() {
    }

    public static List<HandbookSpread> paginate(HandbookGuide guide, Font font) {
        var pages = new PageBuilder();
        pages.add(new TitlePageElement(font.split(guide.title(), PAGE_CONTENT_WIDTH)));
        pages.addText(font.split(guide.description(), PAGE_CONTENT_WIDTH), false);

        for (var section : guide.sections()) {
            switch (section) {
                case TextSection text -> pages.addText(font.split(text.text(), PAGE_CONTENT_WIDTH), false);
                case TipSection tip -> pages.addText(font.split(tip.text(), PAGE_CONTENT_WIDTH), true);
                case PaletteSection palette -> addPalette(pages, palette, font);
            }
        }

        return createSpreads(pages.finish());
    }

    public static List<HandbookSpread> empty(Component message, Font font) {
        var pages = new PageBuilder();
        pages.add(new TitlePageElement(font.split(Component.translatable("chisel.builders_handbook.title"), PAGE_CONTENT_WIDTH)));
        pages.addText(font.split(message, PAGE_CONTENT_WIDTH), false);
        return createSpreads(pages.finish());
    }

    private static void addPalette(PageBuilder pages, PaletteSection palette, Font font) {
        var title = new PaletteTitlePageElement(font.split(palette.title(), PAGE_CONTENT_WIDTH));
        if (!palette.entries().isEmpty() && pages.getRemainingHeight() < title.height() + 20) pages.createNewPage();
        pages.add(title);
        int totalWeight = palette.totalWeight();
        palette.entries().stream().map(entry -> new PaletteEntryPageElement(entry, totalWeight)).forEach(pages::add);
    }

    private static List<HandbookSpread> createSpreads(List<HandbookPage> pages) {
        var spreads = new ArrayList<HandbookSpread>();

        for (int c = 0; c < pages.size(); c += 2) {
            var left = pages.get(c);
            var right = c + 1 < pages.size() ? pages.get(c + 1) : HandbookPage.EMPTY;
            spreads.add(new HandbookSpread(left, right));
        }

        return spreads;
    }
}
