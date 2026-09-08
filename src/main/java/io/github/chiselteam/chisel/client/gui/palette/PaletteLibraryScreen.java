package io.github.chiselteam.chisel.client.gui.palette;

import io.github.chiselteam.chisel.palette.PlayerPaletteManager;
import io.github.chiselteam.chisel.palette.PlayerPalettes;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.NonNull;

import java.util.Optional;

public final class PaletteLibraryScreen extends Screen {
    private PlayerPalettes library = PlayerPalettes.EMPTY;
    private int page;
    private int pageSize;

    public PaletteLibraryScreen() {
        super(Component.translatable("chisel.palette.builder"));
    }

    @Override
    protected void init() {
        library = minecraft.player == null ? PlayerPalettes.EMPTY : PlayerPaletteManager.get(minecraft.player);
        pageSize = Math.max(1, (height - 110) / 26);
        page = Math.clamp(page, 0, Math.max(0, (library.palettes().size() - 1) / pageSize));
        int w = Math.min(300, width - 24), x = (width - w) / 2;
        for (int i = page * pageSize; i < Math.min(library.palettes().size(), (page + 1) * pageSize); i++) {
            var palette = library.palettes().get(i);
            var button = Button.builder(Component.literal(palette.definition().name()), _ -> minecraft.setScreen(new PaletteEditorScreen(this, Optional.of(palette))))
                    .bounds(x, 48 + (i - page * pageSize) * 26, w, 22)
                    .tooltip(Tooltip.create(Component.translatable("chisel.palette.edit_hint", palette.definition().name(), palette.definition().entries().size()))).build();
            addRenderableWidget(button);
        }
        var previous = addRenderableWidget(Button.builder(Component.literal("<"), _ -> {
            page--;
            rebuildWidgets();
        }).bounds(x, height - 54, 24, 20).build());
        previous.active = page > 0;
        var next = addRenderableWidget(Button.builder(Component.literal(">"), _ -> {
            page++;
            rebuildWidgets();
        }).bounds(x + w - 24, height - 54, 24, 20).build());
        next.active = (page + 1) * pageSize < library.palettes().size();
        var create = addRenderableWidget(Button.builder(Component.translatable("chisel.palette.new"), _ -> minecraft.setScreen(new PaletteEditorScreen(this, Optional.empty())))
                .bounds(x + 28, height - 54, w - 56, 20).build());
        create.active = library.palettes().size() < PlayerPalettes.MAX_PALETTES;
        addRenderableWidget(Button.builder(Component.translatable("gui.done"), _ -> onClose()).bounds(x, height - 28, w, 20).build());
    }

    @Override
    public void tick() {
        if (minecraft.player == null) {
            minecraft.setScreen(null);
            return;
        }
        if (!library.equals(PlayerPaletteManager.get(minecraft.player))) rebuildWidgets();
    }

    @Override
    public void extractRenderState(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        super.extractRenderState(graphics, mouseX, mouseY, partialTick);
        graphics.text(font, title, width / 2 - font.width(title) / 2, 14, 0xFFFFFFFF, false);
        var summary = Component.translatable("chisel.palette.library_count", library.palettes().size(), PlayerPalettes.MAX_PALETTES);
        graphics.text(font, summary, width / 2 - font.width(summary) / 2, 30, 0xFFBBBBBB, false);
        if (library.palettes().isEmpty()) {
            var empty = Component.translatable("chisel.palette.library_empty");
            graphics.text(font, empty, width / 2 - font.width(empty) / 2, 65, 0xFFBBBBBB, false);
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
