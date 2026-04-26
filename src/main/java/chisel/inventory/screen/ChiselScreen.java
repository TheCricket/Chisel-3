package chisel.inventory.screen;

import chisel.Chisel;
import chisel.inventory.menu.ChiselMenu;
import chisel.network.ChiselSearchPacket;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

public class ChiselScreen extends AbstractContainerScreen<ChiselMenu> {

    private final Identifier TEXTURE = Chisel.prefix("textures/gui/chisel.png");
    private static final Identifier SCROLLER_SPRITE = Identifier.withDefaultNamespace("container/creative_inventory/scroller");
    private static final Identifier SCROLLER_DISABLED_SPRITE = Identifier.withDefaultNamespace("container/creative_inventory/scroller_disabled");
    private EditBox searchBox;
    private float scrollOffs = 0.0f;
    private boolean isScrolling;

    public ChiselScreen(ChiselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 252, 222);
        inventoryLabelY = imageHeight - 91;
        titleLabelY = topPos + 10;
    }

    @Override
    protected void init() {
        super.init();
        searchBox = new EditBox(font, leftPos + 134, topPos + 9, 88, 10, Component.empty());
        searchBox.setMaxLength(50);
        searchBox.setResponder(this::onSearchTextChange);
        searchBox.setBordered(false);
        addRenderableWidget(searchBox);
    }

    @Override
    public boolean keyPressed(@NonNull KeyEvent event) {
        if (searchBox.keyPressed(event)) {
            return true;
        }
        if (searchBox.isFocused() && searchBox.isVisible() && event.key() != 256/*ESC*/) {
            return true;
        }
        return super.keyPressed(event);
    }

    private void onSearchTextChange(String text) {
        getMenu().setSearchState(text, scrollOffs);
        Objects.requireNonNull(getMinecraft().getConnection()).send(new ChiselSearchPacket(text, scrollOffs));
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (!canScroll()) {
            return false;
        } else {
            int i = (getMenu().variants.activeVariants + 9 - 1) / 9 - 5;
            scrollOffs = (float)((double)scrollOffs - scrollY / (double)i);
            scrollOffs = Mth.clamp(scrollOffs, 0.0F, 1.0F);
            getMenu().setSearchState(searchBox.getValue(), scrollOffs);
            Objects.requireNonNull(getMinecraft().getConnection()).send(new ChiselSearchPacket(searchBox.getValue(), scrollOffs));
            return true;
        }
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
        if (event.button() == 0 && isHoveringScroller(event.x(), event.y())) {
            isScrolling = canScroll();
            return true;
        }
        return super.mouseClicked(event, doubleClick);
    }

    private boolean isHoveringScroller(double mouseX, double mouseY) {
        int x = leftPos + 229;
        int y = topPos + 6;
        return mouseX >= (double)x && mouseX < (double)(x + 12) && mouseY >= (double)y && mouseY < (double)(y + 90);
    }

    @Override
    public boolean mouseReleased(MouseButtonEvent event) {
        if (event.button() == 0) {
            isScrolling = false;
        }
        return super.mouseReleased(event);
    }

    @Override
    public boolean mouseDragged(@NonNull MouseButtonEvent event, double dx, double dy) {
        if (isScrolling) {
            int i = topPos + 6;
            int j = i + 90;
            scrollOffs = ((float)event.y() - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            scrollOffs = Mth.clamp(scrollOffs, 0.0F, 1.0F);
            getMenu().setSearchState(searchBox.getValue(), scrollOffs);
            Objects.requireNonNull(getMinecraft().getConnection()).send(new ChiselSearchPacket(searchBox.getValue(), scrollOffs));
            return true;
        } else {
            return super.mouseDragged(event, dx, dy);
        }
    }

    private boolean canScroll() {
        return getMenu().variants.activeVariants > 45;
    }

    @Override
    public void extractBackground(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);

        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos, topPos, 0, 0, 252, 202, 256, 256);

        Slot main = getMenu().inputSlot;

        if(!main.hasItem()) {
            graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos + 8, topPos + 26, 0, 202, 48, 48, 256, 256);
        }

        int k = (int)(75.0F * scrollOffs);
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, canScroll() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE, leftPos + 229, topPos + 6 + k, 12, 15);
    }

    @Override
    protected void renderSlotContents(@NonNull GuiGraphicsExtractor graphics, @NonNull ItemStack stack, @NonNull Slot slot, @Nullable String itemCount) {
        if(slot == getMenu().inputSlot) {
            graphics.pose().scale(2.0F);
            graphics.item(stack, slot.x - 16, slot.y - 24);

            var font = IClientItemExtensions.of(stack).getFont(stack, IClientItemExtensions.FontContext.ITEM_COUNT);
            graphics.itemDecorations(font != null ? font : this.font, stack, slot.x - 16, slot.y - 24, itemCount);
            graphics.pose().scale(0.5F);
        } else {
            super.renderSlotContents(graphics, stack, slot, itemCount);
        }
    }
}
