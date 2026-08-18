package io.github.chiselteam.chisel.client.overlay;

import io.github.chiselteam.chisel.core.mode.ChiselMode;
import io.github.chiselteam.chisel.events.client.ChiselModeSelectionHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ChiselModeOverlay {

    private static final int ROW_HEIGHT = 13;
    private static final int PADDING = 6;
    private static final int SELECTED_BACKGROUND = 0xA0000000;
    private static final int SELECTED_TEXT = 0xFFFFFFFF;
    private static final int INACTIVE_TEXT = 0xFFAAAAAA;

    public static void render(GuiGraphicsExtractor graphics) {
        if (!ChiselModeSelectionHandler.isSelecting()) return;

        List<ChiselMode> modes = ChiselModeSelectionHandler.getAvailableModes();
        if (modes.isEmpty()) return;

        int selectedIndex = ChiselModeSelectionHandler.getSelectedIndex();
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        Component previousPrevious = getName(getMode(modes, selectedIndex - 2));
        Component previous = getName(getMode(modes, selectedIndex - 1));
        Component selected = getName(getMode(modes, selectedIndex));
        Component next = getName(getMode(modes, selectedIndex + 1));
        Component nextNext = getName(getMode(modes, selectedIndex + 2));

        int width = getWidth(font, previousPrevious, previous, selected, next, nextNext);
        int x = graphics.guiWidth() / 2 + 24;
        int centerY = graphics.guiHeight() / 2;
        float progress = ChiselModeSelectionHandler.getAnimationProgress();
        int direction = ChiselModeSelectionHandler.getAnimationDirection();
        float eased = easeOutCubic(progress);
        float offset = direction * ROW_HEIGHT * (1.0F - eased);
        int selectedY = centerY - ROW_HEIGHT / 2;
        graphics.fill(x, selectedY, x + width, selectedY + ROW_HEIGHT, SELECTED_BACKGROUND);

        if (direction == 0 || progress >= 1.0F) {
            drawMode(graphics, font, previous, x, selectedY - ROW_HEIGHT, width, INACTIVE_TEXT, 1.0F);
            drawMode(graphics, font, selected, x, selectedY, width, SELECTED_TEXT, 1.0F);
            drawMode(graphics, font, next, x, selectedY + ROW_HEIGHT, width, INACTIVE_TEXT, 1.0F);
            return;
        }

        if (direction > 0) {
            drawMode(graphics, font, previous, x, selectedY - ROW_HEIGHT + offset, width, INACTIVE_TEXT, eased);
            drawMode(graphics, font, selected, x, selectedY + offset, width, SELECTED_TEXT, 1.0F);
            drawMode(graphics, font, next, x, selectedY + ROW_HEIGHT + offset, width, INACTIVE_TEXT, 1.0F);
            drawMode(graphics, font, nextNext, x, selectedY + ROW_HEIGHT * 2 + offset, width, INACTIVE_TEXT, 1.0F - eased);
        } else {
            drawMode(graphics, font, previousPrevious, x, selectedY - ROW_HEIGHT * 2 + offset, width, INACTIVE_TEXT, 1.0F - eased);
            drawMode(graphics, font, previous, x, selectedY - ROW_HEIGHT + offset, width, INACTIVE_TEXT, 1.0F);
            drawMode(graphics, font, selected, x, selectedY + offset, width, SELECTED_TEXT, 1.0F);
            drawMode(graphics, font, next, x, selectedY + ROW_HEIGHT + offset, width, INACTIVE_TEXT, eased);
        }
    }

    private static ChiselMode getMode(List<ChiselMode> modes, int index) {
        return modes.get(Math.floorMod(index, modes.size()));
    }

    private static int getWidth(Font font, Component... components) {
        int width = 0;
        for (Component component : components)
            width = Math.max(width, font.width(component));
        return width + PADDING * 2;
    }

    private static void drawMode(GuiGraphicsExtractor graphics, Font font, Component text, int x, float y, int width, int rgb, float alpha) {
        if (alpha <= 0.0F) return;
        int color = withAlpha(rgb, alpha);
        int textX = x + (width - font.width(text)) / 2;
        int textY = Math.round(y + (ROW_HEIGHT - font.lineHeight) / 2.0F);
        graphics.textWithBackdrop(font, text, textX, textY, width, color);
    }

    private static int withAlpha(int rgb, float alpha) {
        int a = Math.round(255.0F * Math.clamp(alpha, 0.0F, 1.0F));
        return a << 24 | rgb;
    }

    private static float easeOutCubic(float value) {
        float inverse = 1.0F - value;
        return 1.0F - inverse * inverse * inverse;
    }

    private static Component getName(ChiselMode mode) {
        return Component.translatable("chisel.mode.%s".formatted(mode.registryName().getPath()));
    }
}
