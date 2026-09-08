package io.github.chiselteam.chisel.client.gui.palette;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

import java.util.Map;
import java.util.function.Supplier;

public final class PaletteWallPreview extends AbstractWidget {
    private final Supplier<Map<BlockPos, BlockState>> wall;
    private float rotationX = 0.06F, rotationY = -0.18F, zoom = 1F, panX, panY;

    public PaletteWallPreview(Supplier<Map<BlockPos, BlockState>> wall) {
        super(0, 0, 1, 1, Component.translatable("chisel.palette.preview"));
        this.wall = wall;
        setTooltip(Tooltip.create(Component.translatable("chisel.palette.preview_controls")));
    }

    @Override
    public void onClick(@NonNull MouseButtonEvent event, boolean doubleClick) {
        if (doubleClick) {
            rotationX = 0.06F;
            rotationY = -0.18F;
            zoom = 1;
            panX = 0;
            panY = 0;
        }
    }

    @Override
    protected void onDrag(@NonNull MouseButtonEvent event, double dx, double dy) {
        if (Minecraft.getInstance().hasShiftDown()) {
            panX = Math.clamp(panX + (float) dx, -width, width);
            panY = Math.clamp(panY + (float) dy, -height, height);
        } else {
            rotationY += (float) Math.toRadians(dx * 0.15);
            rotationX += (float) Math.toRadians(dy * 0.15);
        }
    }

    @Override
    public boolean mouseScrolled(double x, double y, double dx, double dy) {
        if (!active || !isMouseOver(x, y)) return false;
        zoom = Math.clamp(zoom + (float) dy * 0.1F, 0.25F, 4F);
        return true;
    }

    @Override
    protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        graphics.fill(getX(), getY(), getRight(), getBottom(), 0xFF13171C);
        if (!wall.get().isEmpty()) graphics.submitPictureInPictureRenderState(new PaletteWallState(wall.get(),
                rotationX, rotationY, zoom, panX, panY, getX(), getY(), getRight(), getBottom()));
        else
            graphics.text(Minecraft.getInstance().font, Component.translatable("chisel.palette.preview_empty"), getX() + 4, getY() + 8, 0xFFBBBBBB, false);
    }

    @Override
    protected void updateWidgetNarration(@NonNull NarrationElementOutput output) {
        defaultButtonNarrationText(output);
    }
}
