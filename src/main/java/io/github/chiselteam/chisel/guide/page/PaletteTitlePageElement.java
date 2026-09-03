package io.github.chiselteam.chisel.guide.page;

import io.github.chiselteam.chisel.guide.HandbookPaginator;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public record PaletteTitlePageElement(List<FormattedCharSequence> lines) implements HandbookPageElement {
    @Override
    public int height() {
        return lines.size() * HandbookPaginator.LINE_HEIGHT + 5;
    }
}
