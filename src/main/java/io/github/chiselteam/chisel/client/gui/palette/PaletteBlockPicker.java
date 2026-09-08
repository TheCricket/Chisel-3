package io.github.chiselteam.chisel.client.gui.palette;

import io.github.chiselteam.chisel.palette.PaletteDefinition;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.EmptyBlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public final class PaletteBlockPicker {
    private final PaletteDraft draft;
    private final Consumer<Block> select;
    private final Consumer<AbstractWidget> addWidget, removeWidget;
    private final BooleanSupplier locked;
    private final List<Block> catalog = BuiltInRegistries.BLOCK.stream()
            .filter(block -> block.asItem() != Items.AIR && block.defaultBlockState().getRenderShape() == RenderShape.MODEL)
            .filter(block -> Block.isShapeFullBlock(block.defaultBlockState().getShape(EmptyBlockGetter.INSTANCE, BlockPos.ZERO)))
            .sorted(Comparator.comparing(block -> BuiltInRegistries.BLOCK.getKey(block).toString())).toList();
    private final PaletteColorIndex colors = new PaletteColorIndex();
    private final List<AbstractWidget> gridWidgets = new ArrayList<>();
    private String search = "";
    private PaletteColor color;
    private int page, x, gridY, width, bottom, matchCount;
    private boolean indexing;

    public PaletteBlockPicker(PaletteDraft draft, Consumer<Block> select, Consumer<AbstractWidget> addWidget, Consumer<AbstractWidget> removeWidget, BooleanSupplier locked) {
        this.draft = draft;
        this.select = select;
        this.addWidget = addWidget;
        this.removeWidget = removeWidget;
        this.locked = locked;
    }

    public void init(Font font, int x, int y, int width, int bottom) {
        this.x = x;
        this.width = width;
        this.bottom = bottom;
        gridWidgets.clear();
        var query = new EditBox(font, x, y, width, 18, Component.translatable("chisel.palette.search"));
        query.setMaxLength(256);
        query.setHint(Component.translatable("chisel.palette.search"));
        query.setValue(search);
        query.setResponder(value -> {
            search = value;
            page = 0;
            rebuild();
        });
        addWidget.accept(query);
        int columns = Math.max(1, width / 18);
        int count = PaletteColor.values().length + 1;
        for (int i = 0; i < count; i++) {
            PaletteColor choice = i == 0 ? null : PaletteColor.values()[i - 1];
            addWidget.accept(new PaletteColorButton(x + i % columns * 18, y + 22 + i / columns * 18,
                    choice, () -> color == choice, () -> {
                color = choice;
                page = 0;
                rebuild();
            }));
        }
        gridY = y + 24 + ((count + columns - 1) / columns) * 18;
        colors.update(catalog, false);
        rebuild();
    }

    public void tick() {
        if (locked.getAsBoolean()) return;
        if (colors.update(catalog, color != null) && (!indexing || colors.complete(catalog))) rebuild();
    }

    public void rebuild() {
        gridWidgets.forEach(removeWidget);
        gridWidgets.clear();
        indexing = color != null && !colors.complete(catalog);
        var filtered = getFiltered();
        matchCount = filtered.size();
        int columns = Math.max(1, width / 20), rows = Math.max(1, (bottom - gridY - 2) / 20);
        int count = columns * rows;
        page = Math.clamp(page, 0, Math.max(0, (matchCount - 1) / count));
        for (int i = page * count; i < Math.min(matchCount, (page + 1) * count); i++) {
            Block block = filtered.get(i);
            var id = BuiltInRegistries.BLOCK.getKey(block);
            int cell = i - page * count;
            var button = new PaletteBlockButton(x + cell % columns * 20, gridY + cell / columns * 20, 20,
                    new ItemStack(block), Component.translatable("chisel.palette.add", block.getName(), id.toString()), () -> select.accept(block));
            button.active = !locked.getAsBoolean() && draft.value().entries().size() < PaletteDefinition.MAX_ENTRIES
                    && draft.value().entries().stream().noneMatch(entry -> entry.block().equals(id));
            addGridWidget(button);
        }
        addGridWidget(pageButton(x, "<", page > 0, () -> {
            page--;
            rebuild();
        }));
        addGridWidget(pageButton(x + width - 24, ">", (page + 1) * count < matchCount, () -> {
            page++;
            rebuild();
        }));
    }

    private @NonNull List<Block> getFiltered() {
        String needle = search.toLowerCase(Locale.ROOT).strip();
        var matches = catalog.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block).toString().contains(needle) || block.getName().getString().toLowerCase(Locale.ROOT).contains(needle));
        if (indexing) matches = matches.filter(_ -> false);
        if (color != null) matches = matches.filter(block -> colors.score(block, color) >= 0.15)
                .sorted(Comparator.comparingDouble((Block block) -> colors.score(block, color)).reversed());
        return matches.toList();
    }

    private void addGridWidget(AbstractWidget widget) {
        gridWidgets.add(widget);
        addWidget.accept(widget);
    }

    private Button pageButton(int x, String label, boolean active, Runnable action) {
        var button = Button.builder(Component.literal(label), _ -> action.run()).bounds(x, bottom, 24, 18).build();
        button.active = active && !locked.getAsBoolean();
        button.setTooltip(Tooltip.create(Component.translatable(label.equals("<") ? "chisel.palette.previous" : "chisel.palette.next")));
        return button;
    }

    public void extractRenderState(GuiGraphicsExtractor graphics, Font font, int mouseX, int mouseY) {
        if (matchCount == 0) {
            var message = Component.translatable(indexing ? "chisel.palette.color.indexing" : "chisel.palette.no_matches");
            int y = gridY + 2;
            for (var line : font.split(message, width)) {
                if (y + 9 > bottom) break;
                graphics.text(font, line, x, y, 0xFFBBBBBB, false);
                y += 10;
            }
        }
        if (indexing) {
            graphics.text(font, "...", x + width / 2 - 5, bottom + 5, 0xFFBBBBBB, false);
            if (mouseX >= x + 24 && mouseX < x + width - 24 && mouseY >= bottom && mouseY < bottom + 18)
                graphics.setTooltipForNextFrame(font, List.of(Component.translatable("chisel.palette.color.indexing").getVisualOrderText()), mouseX, mouseY);
        }
    }
}
