package io.github.chiselteam.chisel.client.gui;

import io.github.chiselteam.chisel.client.gui.handbook.HandbookLayout;
import io.github.chiselteam.chisel.client.gui.handbook.HandbookNavigation;
import io.github.chiselteam.chisel.client.gui.handbook.HandbookRenderer;
import io.github.chiselteam.chisel.guide.HandbookGuide;
import io.github.chiselteam.chisel.guide.HandbookView;
import io.github.chiselteam.chisel.guide.manager.ClientHandbookManager;
import io.github.chiselteam.chisel.guide.manager.HandbookPaginator;
import io.github.chiselteam.chisel.guide.page.HandbookSpread;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.NonNull;
import java.util.List;

public class BuildersHandbookScreen extends Screen {
    private final HandbookNavigation navigation = new HandbookNavigation();
    private HandbookLayout layout;
    private HandbookRenderer renderer;

    public BuildersHandbookScreen() {
        super(Component.translatable("chisel.builders_handbook.title"));
    }

    @Override
    protected void init() {
        super.init();
        layout = new HandbookLayout(width, height);
        renderer = new HandbookRenderer(font, layout, navigation);
        navigation.refresh(ClientHandbookManager.getSnapshot(), this::paginate);
    }

    @Override
    public void tick() {
        super.tick();
        if (navigation.revision() != ClientHandbookManager.getRevision()) {
            navigation.refresh(ClientHandbookManager.getSnapshot(), this::paginate);
        }
    }

    private List<HandbookSpread> paginate(HandbookGuide guide) {
        return HandbookPaginator.paginate(guide, font);
    }

    @Override
    public void extractRenderState(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        super.extractRenderState(graphics, mouseX, mouseY, partialTick);
        renderer.render(graphics, mouseX, mouseY, getMinecraft().hasShiftDown());
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
        if (event.button() != 0) return super.mouseClicked(event, doubleClick);
        if (navigation.view() == HandbookView.COVER && layout.onCover(event.x(), event.y())) {
            navigation.open();
            return true;
        }
        if (navigation.canPrevious() && layout.onPrevious(event.x(), event.y())) {
            navigation.previous();
            return true;
        }
        if (navigation.canNext() && layout.onNext(event.x(), event.y())) {
            navigation.next();
            return true;
        }
        int row = layout.hoveredRow(event.x(), event.y(), navigation.visibleCount());
        if (row >= 0) {
            navigation.selectRow(row, this::paginate);
            return true;
        }
        return super.mouseClicked(event, doubleClick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
