package io.github.chiselteam.chisel.client.gui.palette;

import io.github.chiselteam.chisel.palette.PaletteDefinition;
import io.github.chiselteam.chisel.palette.PlayerPalette;
import io.github.chiselteam.chisel.palette.WeightedBlock;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class PaletteDraft {
    private Optional<UUID> id;
    private PaletteDefinition original;
    private PaletteDefinition value;

    public PaletteDraft(Optional<PlayerPalette> palette) {
        id = palette.map(PlayerPalette::id);
        value = palette.map(PlayerPalette::definition).orElseGet(() -> new PaletteDefinition("", "",
                Identifier.withDefaultNamespace("bricks"), List.of()));
        original = value;
    }

    public Optional<UUID> id() {
        return id;
    }

    public PaletteDefinition value() {
        return value;
    }

    public boolean dirty() {
        return !value.equals(original);
    }

    public void name(String name) {
        value = new PaletteDefinition(name, value.description(), value.icon(), value.entries());
    }

    public void icon(Identifier icon) {
        value = new PaletteDefinition(value.name(), value.description(), icon, value.entries());
    }

    public boolean add(Identifier block, Identifier item) {
        if (value.entries().size() >= PaletteDefinition.MAX_ENTRIES || value.entries().stream().anyMatch(e -> e.block().equals(block)))
            return false;
        var entries = new ArrayList<>(value.entries());
        entries.add(new WeightedBlock(block, 1, true));
        if (id.isEmpty() && value.entries().isEmpty()) icon(item);
        value = value.withEntries(entries);
        return true;
    }

    public void weight(int index, int weight) {
        var old = value.entries().get(index);
        replace(index, new WeightedBlock(old.block(), Math.clamp(weight, 1, 100), old.enabled()));
    }

    public void toggle(int index) {
        var old = value.entries().get(index);
        replace(index, new WeightedBlock(old.block(), old.weight(), !old.enabled()));
    }

    private void replace(int index, WeightedBlock entry) {
        var entries = new ArrayList<>(value.entries());
        entries.set(index, entry);
        value = value.withEntries(entries);
    }

    public void remove(int index) {
        var entries = new ArrayList<>(value.entries());
        entries.remove(index);
        value = value.withEntries(entries);
    }

    public void saved(UUID assignedId) {
        id = Optional.of(assignedId);
        original = value;
    }
}
