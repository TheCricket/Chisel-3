package io.github.chiselteam.chisel.client.gui.palette;

import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.network.chat.Component;

public final class PaletteWeightSlider extends AbstractSliderButton {
    private final PaletteDraft draft;
    private final int index;
    private final Runnable changed;

    public PaletteWeightSlider(int x, int y, int width, PaletteDraft draft, int index, Runnable changed) {
        super(x, y, width, 18, Component.empty(), (draft.value().entries().get(index).weight() - 1) / 99.0);
        this.draft = draft;
        this.index = index;
        this.changed = changed;
        updateMessage();
    }

    @Override
    protected void applyValue() {
        draft.weight(index, 1 + (int) Math.round(value * 99));
        changed.run();
    }

    @Override
    protected void updateMessage() {
        refreshMessage();
    }

    public void refreshMessage() {
        var entry = draft.value().entries().get(index);
        int total = draft.value().enabledWeight();
        int percent = !entry.enabled() || total == 0 ? 0 : Math.round(entry.weight() * 100F / total);
        setMessage(Component.translatable("chisel.palette.weight", entry.weight(), percent));
    }
}
