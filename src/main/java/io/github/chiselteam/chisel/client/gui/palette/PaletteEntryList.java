package io.github.chiselteam.chisel.client.gui.palette;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractContainerWidget;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

public final class PaletteEntryList extends AbstractContainerWidget {
    private static final int ROW_HEIGHT = 42;
    private final Font font;
    private final PaletteDraft draft;
    private final Runnable changed, removed;
    private final List<AbstractWidget> widgets = new ArrayList<>();
    private final List<PaletteWeightSlider> sliders = new ArrayList<>();
    private final List<Integer> offsets = new ArrayList<>();

    public PaletteEntryList(Font font, PaletteDraft draft, int x, int y, int width, int height, Runnable changed, Runnable removed) {
        super(x, y, width, height, Component.translatable("chisel.palette.entry_list"), defaultSettings(21));
        this.font = font;
        this.draft = draft;
        this.changed = changed;
        this.removed = removed;
        rebuild();
    }

    public void rebuild() {
        setFocused(null);
        setDragging(false);
        widgets.clear();
        sliders.clear();
        offsets.clear();
        int x = getX() + 3, w = width - scrollbarWidth() - 8;
        for (int i = 0; i < draft.value().entries().size(); i++) {
            int index = i, offset = 2 + i * ROW_HEIGHT;
            var entry = draft.value().entries().get(i);
            var block = BuiltInRegistries.BLOCK.getOptional(entry.block()).orElse(null);
            boolean available = block != null && !block.defaultBlockState().isAir() && block.asItem() != Items.AIR;
            var icon = new PaletteBlockButton(x, 0, 18, new ItemStack(available ? block.asItem() : Items.BARRIER), Component.translatable("chisel.palette.use_icon", name(entry.block())), () -> {
                draft.icon(BuiltInRegistries.ITEM.getKey(block.asItem()));
                changed.run();
            });
            icon.active = available;
            add(icon, offset);
            add(Button.builder(Component.literal("x"), unused -> {
                draft.remove(index);
                rebuild();
                changed.run();
                removed.run();
            }).bounds(x + w - 18, 0, 18, 18).tooltip(Tooltip.create(Component.translatable("chisel.palette.remove", name(entry.block())))).build(), offset);
            var slider = new PaletteWeightSlider(x, 0, w - 50, draft, index, changed);
            sliders.add(slider);
            add(slider, offset + 20);
            add(Button.builder(Component.translatable(entry.enabled() ? "chisel.palette.enabled" : "chisel.palette.disabled"), unused -> {
                draft.toggle(index);
                rebuild();
                changed.run();
            }).bounds(x + w - 48, 0, 48, 18).build(), offset + 20);
        }
        refreshScrollAmount();
    }

    private void add(AbstractWidget widget, int offset) {
        widgets.add(widget);
        offsets.add(offset);
    }

    public void refreshWeights() {
        sliders.forEach(PaletteWeightSlider::refreshMessage);
    }

    public void scrollToEnd() {
        setScrollAmount(maxScrollAmount());
    }

    private Component name(Identifier id) {
        return BuiltInRegistries.BLOCK.getOptional(id).map(Block::getName).orElse(Component.literal(id.toString()));
    }

    @Override
    public @NonNull List<? extends GuiEventListener> children() {
        return widgets;
    }

    @Override
    protected int contentHeight() {
        return draft.value().entries().size() * ROW_HEIGHT + 4;
    }

    @Override
    public void setScrollAmount(double amount) {
        super.setScrollAmount(amount);
        for (int i = 0; i < widgets.size(); i++)
            widgets.get(i).setY(getY() + offsets.get(i) - (int) scrollAmount());
    }

    @Override
    public void setFocused(GuiEventListener listener) {
        if (listener != null && !widgets.contains(listener)) return;
        super.setFocused(listener);
        if (listener instanceof AbstractWidget widget) {
            if (widget.getY() < getY()) setScrollAmount(scrollAmount() + widget.getY() - getY());
            else if (widget.getBottom() > getBottom())
                setScrollAmount(scrollAmount() + widget.getBottom() - getBottom());
        }
    }

    @Override
    public boolean mouseClicked(@NonNull MouseButtonEvent event, boolean doubleClick) {
        if (!active || !isMouseOver(event.x(), event.y())) return false;
        if (isOverScrollbar(event.x(), event.y())) setFocused(null);
        return super.mouseClicked(event, doubleClick);
    }

    @Override
    public boolean mouseScrolled(double x, double y, double dx, double dy) {
        return active && isMouseOver(x, y) && super.mouseScrolled(x, y, dx, dy);
    }

    @Override
    public boolean mouseDragged(@NonNull MouseButtonEvent event, double dx, double dy) {
        if (!active) return false;
        super.mouseDragged(event, dx, dy);
        return true;
    }

    @Override
    protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        graphics.fill(getX(), getY(), getRight(), getBottom(), 0xFF13171C);
        graphics.enableScissor(getX(), getY(), getRight() - scrollbarWidth() - 1, getBottom());
        boolean hovered = active && isMouseOver(mouseX, mouseY) && !isOverScrollbar(mouseX, mouseY);
        for (var widget : widgets)
            if (widget.getBottom() > getY() && widget.getY() < getBottom())
                widget.extractRenderState(graphics, hovered ? mouseX : -1, hovered ? mouseY : -1, partialTick);
        for (int i = 0; i < draft.value().entries().size(); i++) {
            int y = getY() + 2 + i * ROW_HEIGHT - (int) scrollAmount();
            if (y + 18 <= getY() || y >= getBottom()) continue;
            var label = name(draft.value().entries().get(i).block());
            graphics.text(font, font.plainSubstrByWidth(label.getString(), width - scrollbarWidth() - 50), getX() + 24, y + 5, 0xFFFFFFFF, false);
            if (hovered && mouseX >= getX() + 24 && mouseX < getRight() - scrollbarWidth() - 24 && mouseY >= y && mouseY < y + 18)
                graphics.setTooltipForNextFrame(font, List.of(label.getVisualOrderText()), mouseX, mouseY);
        }
        graphics.disableScissor();
        extractScrollbar(graphics, mouseX, mouseY);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput output) {
        output.add(NarratedElementType.TITLE, getMessage());
        if (getFocused() instanceof AbstractWidget widget) widget.updateNarration(output.nest());
    }
}
