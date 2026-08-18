package io.github.chiselteam.chisel.inventory.screen;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.client.gui.PreviewPIPState;
import io.github.chiselteam.chisel.client.gui.modes.*;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.inventory.menu.ChiselMenu;
import io.github.chiselteam.chisel.inventory.slot.SelectionSlot;
import io.github.chiselteam.chisel.item.ChiselItem;
import io.github.chiselteam.chisel.network.ChiselSearchPacket;
import io.github.chiselteam.chisel.network.ChiselSelectionPacket;
import io.github.chiselteam.chisel.util.VariantFinder;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.lwjgl.glfw.GLFW;

import java.util.List;
import java.util.Objects;

public class ChiselScreen extends AbstractContainerScreen<ChiselMenu> {

    private final Inventory inventory;
    private final Identifier TEXTURE = Chisel.prefix("textures/gui/chisel.png");
    private static final Identifier SCROLLER_SPRITE = Identifier.withDefaultNamespace("container/creative_inventory/scroller");
    private static final Identifier SCROLLER_DISABLED_SPRITE = Identifier.withDefaultNamespace("container/creative_inventory/scroller_disabled");
    private EditBox searchBox;
    private Button previewModeButton;
    private static final List<PreviewMode> PREVIEW_MODES = List.of(new SinglePreview(), new PanelPreview(), new DonutPreview(), new PlusPreview(), new ColumnPreview(), new RowPreview());
    private int previewModeIndex = 0;
    private float scrollOffs = 0.0f;
    private boolean isScrolling;
    private float previewRotX = 0.0F;
    private float previewRotY = 0.0F;
    private float previewZoom = 1.0F;
    private boolean isDraggingPreview;
    private static final int BULK_HIGHLIGHT_COLOR = 0x80FF842B;

    public ChiselScreen(ChiselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 252, 222);
        this.inventory = inventory;
    }

    @Override
    protected void init() {
        super.init();
        searchBox = new EditBox(font, leftPos + 134, topPos + 9, 88, 10, Component.empty());
        searchBox.setMaxLength(50);
        searchBox.setResponder(this::onSearchTextChange);
        searchBox.setBordered(false);
        addRenderableWidget(searchBox);

        previewModeButton = Button.builder(PREVIEW_MODES.get(previewModeIndex).getDescription(), _ -> cyclePreviewMode())
                .bounds(leftPos + 7, topPos + 3, 48, 20)
                .build();
        addRenderableWidget(previewModeButton);

    }

    private void cyclePreviewMode() {
        previewModeIndex = (previewModeIndex + 1) % PREVIEW_MODES.size();
        previewModeButton.setMessage(PREVIEW_MODES.get(previewModeIndex).getDescription());
    }

    @Override
    public boolean keyPressed(@NonNull KeyEvent event) {
        if (searchBox.keyPressed(event)) {
            return true;
        }
        if (searchBox.isFocused() && searchBox.isVisible() && event.key() != GLFW.GLFW_KEY_ESCAPE) {
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
        if (isHoveringPreview(mouseX, mouseY)) {
            previewZoom = Mth.clamp(previewZoom + (float) scrollY * 0.1F, 0.25F, 4.0F);
            return true;
        }
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
        if (event.button() == 0 && isHoveringPreview(event.x(), event.y())) {
            isDraggingPreview = true;
            return true;
        }
        return super.mouseClicked(event, doubleClick);
    }

    @Override
    protected void slotClicked(@NonNull Slot slot, int slotId, int buttonNum, @NonNull ContainerInput containerInput) {
        if (slot instanceof SelectionSlot) {
            if (buttonNum == 0 && !slot.getItem().isEmpty()) {
                boolean bulk = containerInput == ContainerInput.QUICK_MOVE;
                if (!bulk) getMenu().selectVariant(getMinecraft().player, slot.getContainerSlot(), false);
                Objects.requireNonNull(getMinecraft().getConnection()).send(new ChiselSelectionPacket(slot.getContainerSlot(), bulk));
            }
            return;
        }
        super.slotClicked(slot, slotId, buttonNum, containerInput);
    }

    private void extractBulkHighlights(GuiGraphicsExtractor graphics) {
        if (!getMinecraft().hasShiftDown() || !(hoveredSlot instanceof SelectionSlot)) return;

        ItemStack target = hoveredSlot.getItem();
        ItemStack input = getMenu().inputSlot.getItem();
        if (!(target.getItem() instanceof BlockItem targetItem) || !(input.getItem() instanceof BlockItem inputItem)) return;
        VariantFamily family = VariantFinder.getFamilyForBlock(inputItem.getBlock(), inventory.player.level().registryAccess());
        if (family == null || !family.isBlockInFamily(targetItem.getBlock())) return;

        highlightSlot(graphics, getMenu().inputSlot);
        int uses = ChiselItem.getAvailableUses(getMenu().getChisel(), inventory.player) - input.getCount();
        for (int inventoryIndex = 0; inventoryIndex < inventory.getContainerSize() && uses > 0; inventoryIndex++) {
            ItemStack stack = inventory.getItem(inventoryIndex);
            if (!(stack.getItem() instanceof BlockItem blockItem)) continue;
            if (!family.isBlockInFamily(blockItem.getBlock()) || stack.getItem() == target.getItem()) continue;

            Slot menuSlot = getPlayerSlot(inventoryIndex);
            if (menuSlot != null) highlightSlot(graphics, menuSlot);
            uses -= Math.min(uses, stack.getCount());
        }
    }

    private Slot getPlayerSlot(int inventoryIndex) {
        for (Slot slot : getMenu().slots)
            if (slot.container == inventory && slot.getContainerSlot() == inventoryIndex) return slot;
        return null;
    }

    private void highlightSlot(GuiGraphicsExtractor graphics, Slot slot) {
        graphics.fill(leftPos + slot.x, topPos + slot.y, leftPos + slot.x + 16, topPos + slot.y + 16, BULK_HIGHLIGHT_COLOR);
    }

    private boolean isHoveringScroller(double mouseX, double mouseY) {
        int x = leftPos + 229;
        int y = topPos + 6;
        return mouseX >= (double)x && mouseX < (double)(x + 12) && mouseY >= (double)y && mouseY < (double)(y + 90);
    }

    private boolean isHoveringPreview(double mouseX, double mouseY) {
        int x = leftPos + 8;
        int y = topPos + 26;
        return mouseX >= (double)x && mouseX < (double)(x + 48) && mouseY >= (double)y && mouseY < (double)(y + 48);
    }

    @Override
    public boolean mouseReleased(MouseButtonEvent event) {
        if (event.button() == 0) {
            isScrolling = false;
            isDraggingPreview = false;
        }
        return super.mouseReleased(event);
    }

    @Override
    public boolean mouseDragged(@NonNull MouseButtonEvent event, double dx, double dy) {
        if (isDraggingPreview) {
            float sensitivity = 0.15F;
            previewRotY += (float) Math.toRadians(dx * sensitivity);
            previewRotX += (float) Math.toRadians(dy * sensitivity);
            return true;
        }
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
        extractBulkHighlights(graphics);

        Slot main = getMenu().inputSlot;

        if (main.getItem().getItem() instanceof BlockItem blockItem) {
            PreviewMode previewMode = PREVIEW_MODES.get(previewModeIndex);
            int x0 = leftPos + 8;
            int y0 = topPos + 26;
            int x1 = x0 + 48;
            int y1 = y0 + 48;
            graphics.submitPictureInPictureRenderState(new PreviewPIPState(
                    blockItem.getBlock().defaultBlockState(),
                    previewMode.positions(),
                    previewRotX, previewRotY,
                    previewZoom,
                    previewMode.scale(),
                    previewMode.centerX(),
                    previewMode.centerY(),
                    x0, y0, x1, y1,
                    graphics.peekScissorStack()
            ));
        }

        int k = (int)(75.0F * scrollOffs);
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, canScroll() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE, leftPos + 229, topPos + 6 + k, 12, 15);

    }

    @Override
    public void extractLabels(@NonNull GuiGraphicsExtractor graphics, int xm, int ym) {
        graphics.text(font, Component.translatable("chisel.gui.search"), 90, 10, -12566464, false);
    }
}
