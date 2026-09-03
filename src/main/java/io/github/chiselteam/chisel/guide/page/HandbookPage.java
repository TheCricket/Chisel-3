package io.github.chiselteam.chisel.guide.page;

import java.util.List;

public record HandbookPage(List<HandbookPageElement> elements) {
    public static final HandbookPage EMPTY = new HandbookPage(List.of());
}
