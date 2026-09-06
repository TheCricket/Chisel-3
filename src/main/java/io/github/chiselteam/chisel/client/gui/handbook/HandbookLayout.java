package io.github.chiselteam.chisel.client.gui.handbook;

import io.github.chiselteam.chisel.guide.manager.HandbookPaginator;

public record HandbookLayout(int width, int height) {
    public static final int COVER_WIDTH = 160;
    public static final int COVER_HEIGHT = 188;
    public static final int PAGE_HORIZONTAL_PADDING = 4;
    public static final int BOOK_WIDTH = 320;
    public static final int BOOK_HEIGHT = 192;
    public static final int ARROW_WIDTH = 30;
    public static final int ARROW_HEIGHT = 20;
    public static final int LEFT_PAGE_X = 18;
    public static final int RIGHT_PAGE_X = 179;
    public static final int PAGE_Y = 18;
    public static final int PAGE_WIDTH = 122;
    public static final int PAGE_HEIGHT = 142;
    public static final int LIST_ROW_HEIGHT = 24;
    public static final int ENTRIES_PER_LIST_PAGE = 5;

    private static boolean contains(double x, double y, int left, int top, int width, int height) {
        return x >= left && x < left + width && y >= top && y < top + height;
    }

    public int bookLeft() {
        return (width - BOOK_WIDTH) / 2;
    }

    public int bookTop() {
        return (height - BOOK_HEIGHT) / 2;
    }

    public int coverX() {
        return (width - COVER_WIDTH) / 2;
    }

    public int coverY() {
        return (height - COVER_HEIGHT) / 2;
    }

    public int listX() {
        return bookLeft() + RIGHT_PAGE_X + PAGE_HORIZONTAL_PADDING;
    }

    public int rowY(int row) {
        return bookTop() + PAGE_Y + 18 + row * LIST_ROW_HEIGHT;
    }

    public int previousArrowX() {
        return bookLeft() + 12;
    }

    public int nextArrowX() {
        return bookLeft() + BOOK_WIDTH - ARROW_WIDTH - 12;
    }

    public int arrowY() {
        return bookTop() + BOOK_HEIGHT - ARROW_HEIGHT - 8;
    }

    public boolean onCover(double x, double y) {
        return contains(x, y, coverX(), coverY(), COVER_WIDTH, COVER_HEIGHT);
    }

    public boolean onPrevious(double x, double y) {
        return contains(x, y, previousArrowX(), arrowY(), ARROW_WIDTH, ARROW_HEIGHT);
    }

    public boolean onNext(double x, double y) {
        return contains(x, y, nextArrowX(), arrowY(), ARROW_WIDTH, ARROW_HEIGHT);
    }

    public int hoveredRow(double x, double y, int visibleCount) {
        for (int row = 0; row < visibleCount; row++) {
            if (contains(x, y, listX() - 2, rowY(row), HandbookPaginator.PAGE_CONTENT_WIDTH + 2, LIST_ROW_HEIGHT))
                return row;
        }
        return -1;
    }
}
