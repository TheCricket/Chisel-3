package io.github.chiselteam.chisel.client.gui.palette;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;

import java.util.function.BooleanSupplier;

public final class PaletteColorButton extends Button {
    private final PaletteColor color;
    private final BooleanSupplier selected;

    public PaletteColorButton(int x, int y, PaletteColor color, BooleanSupplier selected, Runnable action) {
        super(x, y, 16, 16, color == null ? Component.translatable("chisel.palette.color.all") : color.label(), _ -> action.run(), DEFAULT_NARRATION);
        this.color = color;
        this.selected = selected;
        setTooltip(Tooltip.create(getMessage()));
    }

    @Override
    protected void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        graphics.fill(getX(), getY(), getX() + 16, getY() + 16, selected.getAsBoolean() || isHoveredOrFocused() ? 0xFFFFFFFF : 0xFF555555);
        graphics.fill(getX() + 1, getY() + 1, getX() + 15, getY() + 15, 0xFF111111);
        if (color != null) graphics.fill(getX() + 3, getY() + 3, getX() + 13, getY() + 13, color.swatch());
        else {
            graphics.fill(getX() + 3, getY() + 3, getX() + 8, getY() + 8, PaletteColor.RED.swatch());
            graphics.fill(getX() + 8, getY() + 3, getX() + 13, getY() + 8, PaletteColor.YELLOW.swatch());
            graphics.fill(getX() + 3, getY() + 8, getX() + 8, getY() + 13, PaletteColor.GREEN.swatch());
            graphics.fill(getX() + 8, getY() + 8, getX() + 13, getY() + 13, PaletteColor.BLUE.swatch());
        }
        if (selected.getAsBoolean()) graphics.fill(getX() + 5, getY() + 14, getX() + 11, getY() + 16, 0xFFFFFFFF);
    }
}
