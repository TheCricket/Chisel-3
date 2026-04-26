package chisel.inventory.screen;

import chisel.Chisel;
import chisel.inventory.menu.AutoChiselMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import chisel.block.entity.AutoChiselBlockEntity;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class AutoChiselScreen extends AbstractContainerScreen<AutoChiselMenu> {

    private final Identifier TEXTURE = Chisel.prefix("textures/gui/auto_chisel.png");
    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;

    public AutoChiselScreen(AutoChiselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 176, 200);
        inventoryLabelY = topPos + 107;
        titleLabelY = topPos + 8;
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
