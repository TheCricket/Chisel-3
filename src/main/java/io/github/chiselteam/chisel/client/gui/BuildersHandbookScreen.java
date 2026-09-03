package io.github.chiselteam.chisel.client.gui;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.guide.HandbookGuide;
import io.github.chiselteam.chisel.guide.HandbookManager;
import io.github.chiselteam.chisel.guide.HandbookPaginator;
import io.github.chiselteam.chisel.guide.page.*;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class BuildersHandbookScreen extends Screen {
    private static final Identifier COVER_TEXTURE = Chisel.prefix("textures/gui/handbook_cover.png");
    private static final Identifier PAGES_TEXTURE = Chisel.prefix("textures/gui/handbook_pages.png");
    private static final Identifier LEFT_ARROW_TEXTURE = Chisel.prefix("textures/gui/arrow_left.png");
    private static final Identifier RIGHT_ARROW_TEXTURE = Chisel.prefix("textures/gui/arrow_right.png");

    private static final int COVER_TEXTURE_WIDTH = 80;
    private static final int COVER_TEXTURE_HEIGHT = 94;
    private static final int COVER_WIDTH = 160;
    private static final int COVER_HEIGHT = 188;

    private static final int PAGE_HORIZONTAL_PADDING = 4;
    private static final int PAGES_TEXTURE_WIDTH = 160;
    private static final int PAGES_TEXTURE_HEIGHT = 96;
    private static final int BOOK_WIDTH = 320;
    private static final int BOOK_HEIGHT = 192;

    private static final int ARROW_TEXTURE_WIDTH = 15;
    private static final int ARROW_TEXTURE_HEIGHT = 10;
    private static final int ARROW_WIDTH = 30;
    private static final int ARROW_HEIGHT = 20;

    private static final int LEFT_PAGE_X = 18;
    private static final int RIGHT_PAGE_X = 179;
    private static final int PAGE_Y = 18;
    private static final int PAGE_WIDTH = 122;
    private static final int PAGE_HEIGHT = 142;

    private static final int TEXT_COLOR = 0xFF3D3333;
    private static final int MUTED_TEXT_COLOR = 0xFF6F5A48;
    private static final int TIP_BACKGROUND_COLOR = 0x30B55945;
    private static final int BAR_BACKGROUND_COLOR = 0x406F5A48;
    private static final int BAR_FILL_COLOR = 0xFF9B7155;

    private List<HandbookSpread> spreads = List.of();
    private boolean open;
    private int spreadIndex, bookLeft, bookTop;

    public BuildersHandbookScreen() {
        super(Component.translatable("chisel.builders_handbook.title"));
    }

    private static boolean isInside(double mouseX, double mouseY, int x, int y, int width, int height) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    @Override
    protected void init() {
        bookLeft = (width - BOOK_WIDTH) / 2;
        bookTop = (height - BOOK_HEIGHT) / 2;
        spreadIndex = 0;

        List<HandbookGuide> guides = minecraft.level == null ? List.of() : HandbookManager.getGuides(minecraft.level.registryAccess());
        spreads = guides.isEmpty() ? HandbookPaginator.empty(Component.translatable("chisel.builders_handbook.empty"), font) : HandbookPaginator.paginate(guides.getFirst(), font);
    }

    @Override
    public void extractRenderState(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractRenderState(graphics, mouseX, mouseY, a);
        if (open) extractOpenBook(graphics);
        else extractCover(graphics);
    }

    private void extractCover(GuiGraphicsExtractor graphics) {
        int x = (width - COVER_WIDTH) / 2;
        int y = (height - COVER_HEIGHT) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, COVER_TEXTURE, x, y, 0F, 0F, COVER_WIDTH, COVER_HEIGHT, COVER_TEXTURE_WIDTH, COVER_TEXTURE_HEIGHT, COVER_TEXTURE_WIDTH, COVER_TEXTURE_HEIGHT);
        graphics.nextStratum();
        extractCenteredText(graphics, Component.translatable("chisel.builders_handbook.title"), width / 2, y + 60, TEXT_COLOR);
    }

    private void extractOpenBook(GuiGraphicsExtractor graphics) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, PAGES_TEXTURE, bookLeft, bookTop, 0, 0, BOOK_WIDTH, BOOK_HEIGHT, PAGES_TEXTURE_WIDTH, PAGES_TEXTURE_HEIGHT, PAGES_TEXTURE_WIDTH, PAGES_TEXTURE_HEIGHT);
        graphics.nextStratum();
        var spread = spreads.get(spreadIndex);
        extractPage(graphics, spread.leftPage(), bookLeft + LEFT_PAGE_X, bookTop + PAGE_Y);
        extractPage(graphics, spread.rightPage(), bookLeft + RIGHT_PAGE_X, bookTop + PAGE_Y);
        extractPageNumbers(graphics);
        extractArrows(graphics);
    }

    private void extractPage(GuiGraphicsExtractor graphics, HandbookPage page, int x, int y) {
        int contentX = x + PAGE_HORIZONTAL_PADDING;
        int elementY = y;

        graphics.enableScissor(x, y, x + PAGE_WIDTH, y + PAGE_HEIGHT);

        for (var element : page.elements()) {
            extractElement(graphics, element, contentX, elementY, HandbookPaginator.PAGE_CONTENT_WIDTH);
            elementY += element.height();
        }

        graphics.disableScissor();
    }

    private void extractElement(GuiGraphicsExtractor graphics, HandbookPageElement element, int x, int y, int contentWidth) {
        switch (element) {
            case TitlePageElement titlePage ->
                    extractCenteredLines(graphics, titlePage.lines(), x + contentWidth / 2, y, TEXT_COLOR);
            case TextPageElement text -> extractLines(graphics, text.lines(), x, y, TEXT_COLOR);
            case TipPageElement tip -> extractTip(graphics, tip, x, y, contentWidth);
            case PaletteTitlePageElement paletteTitle ->
                    extractCenteredLines(graphics, paletteTitle.lines(), x + contentWidth / 2, y, TEXT_COLOR);
            case PaletteEntryPageElement paletteEntry -> extractPaletteEntry(graphics, paletteEntry, x, y);
        }
    }

    private void extractLines(GuiGraphicsExtractor graphics, List<FormattedCharSequence> lines, int x, int y, int color) {
        for (var line : lines) {
            graphics.text(font, line, x, y, color, false);
            y += HandbookPaginator.LINE_HEIGHT;
        }
    }

    private void extractCenteredLines(GuiGraphicsExtractor graphics, List<FormattedCharSequence> lines, int centerX, int y, int color) {
        for (var line : lines) {
            graphics.text(font, line, centerX - font.width(line) / 2, y, color, false);
            y += HandbookPaginator.LINE_HEIGHT;
        }
    }

    private void extractTip(GuiGraphicsExtractor graphics, TipPageElement tip, int x, int y, int contentWidth) {
        graphics.fill(x, y, x + contentWidth, y + tip.height() - 2, TIP_BACKGROUND_COLOR);
        extractLines(graphics, tip.lines(), x + 4, y + 4, MUTED_TEXT_COLOR);
    }

    private void extractPaletteEntry(GuiGraphicsExtractor graphics, PaletteEntryPageElement element, int x, int y) {
        var block = BuiltInRegistries.BLOCK.getOptional(element.entry().block()).orElse(null);
        var name = block == null ? Component.literal(element.entry().block().toString()) : block.getName();

        if (block != null) graphics.item(new ItemStack(block), x, y);

        var nameLines = font.split(name, 66);
        if (!nameLines.isEmpty()) graphics.text(font, nameLines.getFirst(), x + 18, y + 1, TEXT_COLOR, false);

        int barX = x + 19;
        int barY = y + 12;
        int barWidth = 72;
        int filledWidth = Math.round(barWidth * element.percentage() / 100F);

        graphics.fill(barX, barY, barX + barWidth, barY + 5, BAR_BACKGROUND_COLOR);
        graphics.fill(barX, barY, barX + filledWidth, barY + 5, BAR_FILL_COLOR);
        graphics.text(font, Component.literal("%d%%".formatted(element.percentage())), x + 96, y + 7, MUTED_TEXT_COLOR, false);
    }

    private void extractPageNumbers(GuiGraphicsExtractor graphics) {
        int left = spreadIndex * 2 + 1;
        int right = left + 1;
        int y = bookTop + PAGE_Y + PAGE_HEIGHT + 5;

        extractCenteredText(graphics, Integer.toString(left), bookLeft + LEFT_PAGE_X + PAGE_WIDTH / 2, y, MUTED_TEXT_COLOR);
        extractCenteredText(graphics, Integer.toString(right), bookLeft + RIGHT_PAGE_X + PAGE_WIDTH / 2, y, MUTED_TEXT_COLOR);
    }

    private void extractArrows(GuiGraphicsExtractor graphics) {
        if (spreadIndex > 0) extractArrow(graphics, LEFT_ARROW_TEXTURE, getPreviousArrowX(), getArrowY());
        if (spreadIndex < spreads.size() - 1) extractArrow(graphics, RIGHT_ARROW_TEXTURE, getNextArrowX(), getArrowY());
    }

    private void extractArrow(GuiGraphicsExtractor graphics, Identifier texture, int x, int y) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, texture, x, y, 0, 0, ARROW_WIDTH, ARROW_HEIGHT, ARROW_TEXTURE_WIDTH, ARROW_TEXTURE_HEIGHT, ARROW_TEXTURE_WIDTH, ARROW_TEXTURE_HEIGHT);
    }

    private void extractCenteredText(GuiGraphicsExtractor graphics, String text, int centerX, int y, int color) {
        extractCenteredText(graphics, Component.literal(text), centerX, y, color);
    }

    private void extractCenteredText(GuiGraphicsExtractor graphics, Component text, int centerX, int y, int color) {
        graphics.text(font, text, centerX - font.width(text) / 2, y, color, false);
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
        if (event.button() != 0) return super.mouseClicked(event, doubleClick);

        if (!open && isInside(event.x(), event.y(), (width - COVER_WIDTH) / 2, (height - COVER_HEIGHT) / 2, COVER_WIDTH, COVER_HEIGHT)) {
            open = true;
            return true;
        }

        if (!open) return super.mouseClicked(event, doubleClick);

        if (spreadIndex > 0 && isInside(event.x(), event.y(), getPreviousArrowX(), getArrowY(), ARROW_WIDTH, ARROW_HEIGHT)) {
            spreadIndex--;
            return true;
        }

        if (spreadIndex < spreads.size() - 1 && isInside(event.x(), event.y(), getNextArrowX(), getArrowY(), ARROW_WIDTH, ARROW_HEIGHT)) {
            spreadIndex++;
            return true;
        }

        return super.mouseClicked(event, doubleClick);
    }

    private int getPreviousArrowX() {
        return bookLeft + 12;
    }

    private int getNextArrowX() {
        return bookLeft + BOOK_WIDTH - ARROW_WIDTH - 12;
    }

    private int getArrowY() {
        return bookTop + BOOK_HEIGHT - ARROW_HEIGHT - 8;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
