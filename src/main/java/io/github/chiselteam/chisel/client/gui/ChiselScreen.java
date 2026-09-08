package io.github.chiselteam.chisel.client.gui;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.client.gui.preview.PreviewPIPState;
import io.github.chiselteam.chisel.client.gui.preview.modes.*;
import io.github.chiselteam.chisel.family.VariantFamilyLookup;
import io.github.chiselteam.chisel.item.ChiselItem;
import io.github.chiselteam.chisel.menu.ChiselMenu;
import io.github.chiselteam.chisel.menu.slot.SelectionSlot;
import io.github.chiselteam.chisel.network.ChiselSearchPacket;
import io.github.chiselteam.chisel.network.ChiselSelectionPacket;
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
    private static final float IDLE_ANGULAR_VELOCITY = 0.03F;
    private static final float INERTIA_DAMPING_PER_SECOND = 0.05F;
    private float previewZoom = 1.0F;
    private boolean isDraggingPreview;
    private static final float INERTIA_STOP_SPEED = 0.02F;
    private static final float PREVIEW_DRAG_SENSITIVITY = 0.15F;
    private static final int VARIANT_COLUMNS = 7;
    private static final int VISIBLE_VARIANT_ROWS = 6;
    private static final int SCROLLER_X = 222;
    private static final int SCROLLER_Y = 10;
    private static final int SCROLLER_WIDTH = 12;
    private static final int SCROLLER_TRACK_HEIGHT = 122;
    private static final int SCROLLER_THUMB_HEIGHT = 15;
    private float previewVelocityX = 0.0F;
    private float previewVelocityY = 0.0F;
    private long lastPreviewFrameNanos;
    private long lastPreviewDragNanos;
    private static final int BULK_HIGHLIGHT_COLOR = 0x80FF842B;

    public ChiselScreen(ChiselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 256, 256);
        this.inventory = inventory;
    }

    @Override
    protected void init() {
        super.init();
        topPos += 10;
        lastPreviewFrameNanos = System.nanoTime();

        searchBox = new EditBox(font, leftPos + 92, topPos + 10, 88, 10, Component.translatable("chisel.gui.search"));
        searchBox.setMaxLength(50);
        searchBox.setResponder(this::onSearchTextChange);
        searchBox.setBordered(false);
        addRenderableWidget(searchBox);

        previewModeButton = Button.builder(PREVIEW_MODES.get(previewModeIndex).getDescription(), _ -> cyclePreviewMode())
                .bounds(leftPos + 22, topPos + 5, 48, 20)
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
            int scrollableRows = (getMenu().variants.activeVariants + VARIANT_COLUMNS - 1) / VARIANT_COLUMNS - VISIBLE_VARIANT_ROWS;
            scrollOffs = (float) ((double) scrollOffs - scrollY / (double) scrollableRows);
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
            previewVelocityX = 0.0F;
            previewVelocityY = 0.0F;
            lastPreviewDragNanos = System.nanoTime();
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
        VariantFamily family = VariantFamilyLookup.getFamilyForBlock(inputItem.getBlock(), inventory.player.level().registryAccess());
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
        int x = leftPos + SCROLLER_X;
        int y = topPos + SCROLLER_Y;
        return mouseX >= (double) x && mouseX < (double) (x + SCROLLER_WIDTH)
                && mouseY >= (double) y && mouseY < (double) (y + SCROLLER_TRACK_HEIGHT);
    }

    private boolean isHoveringPreview(double mouseX, double mouseY) {
        int x = leftPos + 11;
        int y = topPos + 35;
        return mouseX >= (double) x && mouseX < (double) (x + 70) && mouseY >= (double) y && mouseY < (double) (y + 70);
    }

    @Override
    public boolean mouseReleased(MouseButtonEvent event) {
        if (event.button() == 0) {
            isScrolling = false;
            if (isDraggingPreview && System.nanoTime() - lastPreviewDragNanos > 100_000_000L) {
                previewVelocityX = 0.0F;
                previewVelocityY = 0.0F;
            }
            isDraggingPreview = false;
        }
        return super.mouseReleased(event);
    }

    @Override
    public boolean mouseDragged(@NonNull MouseButtonEvent event, double dx, double dy) {
        if (isDraggingPreview) {
            long now = System.nanoTime();
            float deltaTime = (now - lastPreviewDragNanos) / 1_000_000_000.0F;
            float deltaRotY = (float) Math.toRadians(dx * PREVIEW_DRAG_SENSITIVITY);
            float deltaRotX = (float) Math.toRadians(dy * PREVIEW_DRAG_SENSITIVITY);
            previewRotY += deltaRotY;
            previewRotX += deltaRotX;
            if (deltaTime > 0.0F) {
                previewVelocityY = deltaRotY / deltaTime;
                previewVelocityX = deltaRotX / deltaTime;
            }
            lastPreviewDragNanos = now;
            return true;
        }
        if (isScrolling) {
            float trackTop = topPos + SCROLLER_Y;
            float thumbTravel = SCROLLER_TRACK_HEIGHT - SCROLLER_THUMB_HEIGHT;
            scrollOffs = ((float) event.y() - trackTop - SCROLLER_THUMB_HEIGHT / 2.0F) / thumbTravel;
            scrollOffs = Mth.clamp(scrollOffs, 0.0F, 1.0F);
            getMenu().setSearchState(searchBox.getValue(), scrollOffs);
            Objects.requireNonNull(getMinecraft().getConnection()).send(new ChiselSearchPacket(searchBox.getValue(), scrollOffs));
            return true;
        } else {
            return super.mouseDragged(event, dx, dy);
        }
    }

    private boolean canScroll() {
        return getMenu().variants.activeVariants > VISIBLE_VARIANT_ROWS * VARIANT_COLUMNS;
    }

    private void updatePreviewRotation() {
        long now = System.nanoTime();
        float deltaTime = Math.min((now - lastPreviewFrameNanos) / 1_000_000_000.0F, 0.1F);
        lastPreviewFrameNanos = now;
        if (isDraggingPreview || deltaTime <= 0.0F) return;

        float speedSquared = previewVelocityX * previewVelocityX + previewVelocityY * previewVelocityY;
        if (speedSquared > INERTIA_STOP_SPEED * INERTIA_STOP_SPEED) {
            previewRotX += previewVelocityX * deltaTime;
            previewRotY += previewVelocityY * deltaTime;
            float damping = (float) Math.pow(INERTIA_DAMPING_PER_SECOND, deltaTime);
            previewVelocityX *= damping;
            previewVelocityY *= damping;
        } else {
            previewVelocityX = 0.0F;
            previewVelocityY = 0.0F;
            previewRotY += IDLE_ANGULAR_VELOCITY * deltaTime;
        }
    }

    @Override
    public void extractBackground(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        updatePreviewRotation();

        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos, topPos, 0, 0, 242, 233, 256, 256);
        extractBulkHighlights(graphics);

        Slot main = getMenu().inputSlot;

        if (main.getItem().getItem() instanceof BlockItem blockItem) {
            PreviewMode previewMode = PREVIEW_MODES.get(previewModeIndex);
            int x0 = leftPos + 11;
            int y0 = topPos + 35;
            int x1 = x0 + 70;
            int y1 = y0 + 70;

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

        int thumbOffset = (int) ((SCROLLER_TRACK_HEIGHT - SCROLLER_THUMB_HEIGHT) * scrollOffs);
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, canScroll() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE,
                leftPos + SCROLLER_X, topPos + SCROLLER_Y + thumbOffset, SCROLLER_WIDTH, SCROLLER_THUMB_HEIGHT);

    }

    @Override
    public void extractLabels(@NonNull GuiGraphicsExtractor graphics, int xm, int ym) {
        if (!searchBox.active)
            graphics.text(font, Component.translatable("chisel.gui.search"), 92, 10, -12566464, false);
    }
}
