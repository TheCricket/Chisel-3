package io.github.chiselteam.chisel.client.gui;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.block.entity.AutoChiselBlockEntity;
import io.github.chiselteam.chisel.family.VariantFamilyLookup;
import io.github.chiselteam.chisel.menu.AutoChiselMenu;
import io.github.chiselteam.chisel.network.AutoChiselTemplatePacket;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class AutoChiselScreen extends AbstractContainerScreen<AutoChiselMenu> {

    private final Identifier TEXTURE = Chisel.prefix("textures/gui/auto_chisel.png");
    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;
    private static final Identifier RECIPE_BOOK_TEXTURE = Identifier.withDefaultNamespace("textures/gui/recipe_book.png");
    private static final Identifier SLOT_CRAFTABLE_SPRITE = Identifier.withDefaultNamespace("recipe_book/slot_craftable");
    private static final int PICKER_COLUMNS = 5;
    private static final int PICKER_ROWS = 4;
    private static final int PICKER_WIDTH = 147;
    private static final int PICKER_HEIGHT = 166;
    private final List<ItemStack> variants = new ArrayList<>();
    private final List<ItemStack> filteredVariants = new ArrayList<>();
    private EditBox searchBox;
    private ImageButton pickerToggleButton;
    private Button previousPageButton;
    private Button nextPageButton;
    private boolean pickerOpen;
    private boolean widthTooNarrow;
    private int page;
    private ItemStack observedTemplate = ItemStack.EMPTY;

    public AutoChiselScreen(AutoChiselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 176, 200);
        inventoryLabelY = topPos + 107;
        titleLabelY = topPos + 8;
    }

    @Override
    protected void init() {
        super.init();
        widthTooNarrow = width < 379;
        leftPos = updateScreenPosition();

        pickerToggleButton = addRenderableWidget(new ImageButton(
                leftPos + 78, topPos + 7, 20, 18, RecipeBookComponent.RECIPE_BUTTON_SPRITES, _ -> togglePicker()));

        searchBox = new EditBox(font, pickerLeft() + 25, pickerTop() + 16, 96, 14, Component.translatable("itemGroup.search"));
        searchBox.setMaxLength(50);
        searchBox.setResponder(this::filterVariants);
        searchBox.setHint(Component.translatable("gui.recipebook.search_hint").withStyle(EditBox.SEARCH_HINT_STYLE));
        searchBox.setTextColor(0xFFC6C6C6);
        searchBox.setVisible(false);
        addRenderableWidget(searchBox);

        previousPageButton = Button.builder(Component.literal("<"), _ -> changePage(-1))
                .bounds(pickerLeft() + 37, pickerTop() + 139, 20, 18).build();
        nextPageButton = Button.builder(Component.literal(">"), _ -> changePage(1))
                .bounds(pickerLeft() + 90, pickerTop() + 139, 20, 18).build();
        previousPageButton.visible = false;
        nextPageButton.visible = false;
        addRenderableWidget(previousPageButton);
        addRenderableWidget(nextPageButton);
    }

    private void togglePicker() {
        pickerOpen = !pickerOpen;
        leftPos = updateScreenPosition();
        positionPickerWidgets();
        searchBox.setVisible(pickerOpen);
        if (pickerOpen) {
            refreshVariants();
            searchBox.setFocused(true);
        } else {
            searchBox.setFocused(false);
        }
        updatePageButtons();
    }

    private void closePicker() {
        if (pickerOpen) togglePicker();
    }

    private int pickerLeft() {
        return widthTooNarrow ? (width - PICKER_WIDTH) / 2 : leftPos - PICKER_WIDTH;
    }

    private int pickerTop() {
        return (height - PICKER_HEIGHT) / 2;
    }

    public List<Rect2i> getPickerBounds() {
        return pickerOpen ? List.of(new Rect2i(pickerLeft(), pickerTop(), PICKER_WIDTH, PICKER_HEIGHT)) : List.of();
    }

    private int updateScreenPosition() {
        return pickerOpen && !widthTooNarrow
                ? 177 + (width - imageWidth - 200) / 2
                : (width - imageWidth) / 2;
    }

    private void positionPickerWidgets() {
        pickerToggleButton.setPosition(leftPos + 78, topPos + 7);
        searchBox.setPosition(pickerLeft() + 25, pickerTop() + 13);
        previousPageButton.setPosition(pickerLeft() + 37, pickerTop() + 139);
        nextPageButton.setPosition(pickerLeft() + 90, pickerTop() + 139);
    }

    private void refreshVariants() {
        variants.clear();
        Slot templateSlot = menu.slots.get(AutoChiselBlockEntity.TEMPLATE_SLOT);
        observedTemplate = templateSlot.getItem().copy();
        if (templateSlot.getItem().getItem() instanceof BlockItem blockItem) {
            VariantFamily family = VariantFamilyLookup.getFamilyForBlock(blockItem.getBlock(),
                    Objects.requireNonNull(getMinecraft().player).level().registryAccess());
            if (family != null) {
                family.getAllVariants().forEach(variant -> {
                    if (variant.getBlock() != null && variant.getBlock().asItem() != net.minecraft.world.item.Items.AIR) {
                        variants.add(new ItemStack(variant.getBlock()));
                    }
                });
            }
        }
        filterVariants(searchBox == null ? "" : searchBox.getValue());
    }

    private void filterVariants(String query) {
        String filter = query.toLowerCase(Locale.ROOT);
        filteredVariants.clear();
        for (ItemStack stack : variants) {
            if (filter.isEmpty()) filteredVariants.add(stack);
            else if (stack.getHoverName().getString().toLowerCase(Locale.ROOT).contains(filter))
                filteredVariants.add(stack);
            else if (stack.getItem() instanceof BlockItem blockItem) {
                if (Component.translatable("%s.desc".formatted(blockItem.getDescriptionId())).getString().toLowerCase(Locale.ROOT).contains(filter))
                    filteredVariants.add(stack);
            }
        }
        page = 0;
        updatePageButtons();
    }

    private void changePage(int direction) {
        page = Math.clamp(page + direction, 0, pageCount() - 1);
        updatePageButtons();
    }

    private int pageCount() {
        return Math.max(1, (filteredVariants.size() + PICKER_COLUMNS * PICKER_ROWS - 1) / (PICKER_COLUMNS * PICKER_ROWS));
    }

    private void updatePageButtons() {
        if (previousPageButton == null) return;
        previousPageButton.visible = pickerOpen && page > 0;
        nextPageButton.visible = pickerOpen && page + 1 < pageCount();
    }

    @Override
    public void containerTick() {
        super.containerTick();
        if (pickerOpen) {
            ItemStack template = menu.slots.get(AutoChiselBlockEntity.TEMPLATE_SLOT).getItem();
            if (!ItemStack.isSameItemSameComponents(template, observedTemplate)) refreshVariants();
        }
    }

    @Override
    public boolean keyPressed(@NonNull KeyEvent event) {
        if (pickerOpen && event.key() == GLFW.GLFW_KEY_ESCAPE) {
            closePicker();
            return true;
        }
        if (pickerOpen && searchBox.keyPressed(event)) return true;
        if (pickerOpen && searchBox.isFocused()) return true;
        return super.keyPressed(event);
    }

    @Override
    public boolean mouseClicked(@NonNull MouseButtonEvent event, boolean doubleClick) {
        if (!pickerOpen) return super.mouseClicked(event, doubleClick);
        if (pickerToggleButton.isMouseOver(event.x(), event.y()) || searchBox.isMouseOver(event.x(), event.y())
                || previousPageButton.isMouseOver(event.x(), event.y()) || nextPageButton.isMouseOver(event.x(), event.y())) {
            return super.mouseClicked(event, doubleClick);
        }

        int index = variantAt(event.x(), event.y());
        if (event.button() == 0 && index >= 0) {
            ItemStack selected = filteredVariants.get(index);
            Objects.requireNonNull(getMinecraft().getConnection()).send(new AutoChiselTemplatePacket(
                    BuiltInRegistries.BLOCK.getKey(((BlockItem) selected.getItem()).getBlock())));
            return true;
        }
        if (isOverPicker(event.x(), event.y())) return true;
        return super.mouseClicked(event, doubleClick);
    }

    private int variantAt(double mouseX, double mouseY) {
        int x = (int) mouseX - (pickerLeft() + 11);
        int y = (int) mouseY - (pickerTop() + 32);
        if (x < 0 || y < 0 || x >= PICKER_COLUMNS * 25 || y >= PICKER_ROWS * 25) return -1;
        int column = x / 25;
        int row = y / 25;
        int index = page * PICKER_COLUMNS * PICKER_ROWS + row * PICKER_COLUMNS + column;
        return index < filteredVariants.size() ? index : -1;
    }

    private boolean isOverPicker(double mouseX, double mouseY) {
        return mouseX >= pickerLeft() && mouseX < pickerLeft() + PICKER_WIDTH
                && mouseY >= pickerTop() && mouseY < pickerTop() + PICKER_HEIGHT;
    }

    @Override
    public void extractBackground(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos, topPos, 0, 0, 176, 200, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        // Progress arrow
        int progress = menu.getProgress();
        if (progress > 0) {
            int arrowWidth = (int) (progress * 50.0 / 100.0);
            graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos + 63, topPos + 28, 176, 17, arrowWidth, 17, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        }

        // Ghost preview

        if(!menu.isTemplateInvalid()) {
            Slot templateSlot = menu.slots.get(AutoChiselBlockEntity.TEMPLATE_SLOT);
            if (templateSlot.hasItem()) {
                ItemStack template = templateSlot.getItem();
                ItemStack preview = template.copy();
                preview.setCount(1);
                // Draw ghost item at output slots if they are empty
                for (int i = 0; i < 12; i++) {
                    Slot outputSlot = menu.slots.get(14 + i);
                    if (!outputSlot.hasItem()) {
                        graphics.item(preview, leftPos + outputSlot.x, topPos + outputSlot.y);
                        graphics.fill(leftPos + outputSlot.x, topPos + outputSlot.y, leftPos + outputSlot.x + 16, topPos + outputSlot.y + 16, 0x88FFFFFF);
                        break;
                    }
                }
            } else {
                graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos + 80, topPos + 28, 176, 34, 16, 16, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            }
        }

        Slot chiselSlot = menu.slots.get(AutoChiselBlockEntity.CHISEL_SLOT);
        if (!chiselSlot.hasItem()) {
            graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos + 80, topPos + 64, 176, 51, 16, 16, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        }

        // Invalid Highlighting
        if (menu.isTemplateInvalid()) {
            graphics.fill(leftPos + 80, topPos + 28, leftPos + 80 + 16, topPos + 28 + 16, 0x88FF0000);
        }
        if (menu.isChiselInvalid()) {
            graphics.fill(leftPos + 80, topPos + 64, leftPos + 80 + 16, topPos + 64 + 16, 0x88FF0000);
        }

        if (pickerOpen) extractVariantPicker(graphics);
    }

    private void extractVariantPicker(GuiGraphicsExtractor graphics) {
        int x = pickerLeft();
        int y = pickerTop();
        graphics.blit(RenderPipelines.GUI_TEXTURED, RECIPE_BOOK_TEXTURE, x, y, 1, 1,
                PICKER_WIDTH, PICKER_HEIGHT, 256, 256);

        for (int row = 0; row < PICKER_ROWS; row++) {
            for (int column = 0; column < PICKER_COLUMNS; column++) {
                int slotX = x + 11 + column * 25;
                int slotY = y + 32 + row * 25;
                int index = page * PICKER_COLUMNS * PICKER_ROWS + row * PICKER_COLUMNS + column;
                if (index < filteredVariants.size()) {
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SLOT_CRAFTABLE_SPRITE, slotX, slotY, 25, 25);
                    graphics.fakeItem(filteredVariants.get(index), slotX + 4, slotY + 4);
                }
            }
        }
        if (filteredVariants.isEmpty()) {
            graphics.text(font, Component.translatable("chisel.gui.no_variants"), x + 20, y + 78, 0xFFC6C6C6, false);
        } else if (pageCount() > 1) {
            Component pageText = Component.literal((page + 1) + "/" + pageCount());
            graphics.text(font, pageText, x + (PICKER_WIDTH - font.width(pageText)) / 2, y + 144, 0xFFC6C6C6, false);
        }
    }
    @Override
    public void extractLabels(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
        super.extractLabels(graphics, mouseX, mouseY);

        // Input invalid highlighting
        for (int i = 0; i < 12; i++) {
            Slot slot = menu.slots.get(i);
            if (slot.hasItem() && menu.isInputInvalid(i)) {
                graphics.fill(slot.x, slot.y, slot.x + 16, slot.y + 16, 0x88FF0000);
            }
        }
    }
}
