package chisel.menu;

import chisel.Chisel;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ChiselScreen extends AbstractContainerScreen<ChiselMenu> {

    private final Identifier TEXTURE = Chisel.prefix("textures/gui/chisel.png");

    public ChiselScreen(ChiselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 256, 256);
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public void extractBackground(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);

        int theoreticalImageWidth = 252;
        leftPos = (width - theoreticalImageWidth) >> 1;

        int theoreticalImageHeight = 202;
        topPos = (height - theoreticalImageHeight) >> 1;

        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos, topPos, 0, 0, theoreticalImageWidth, theoreticalImageHeight, imageWidth, imageHeight);

        int x = (width - theoreticalImageWidth) / 2;
        int y = (height - theoreticalImageHeight) / 2;

        Slot main = getMenu().inputSlot;

        if(!main.hasItem()) {
            graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 8, y + 8, 0, theoreticalImageHeight, 48, 48, imageWidth, imageHeight);
        }
    }

    @Override
    protected void renderSlotContents(@NonNull GuiGraphicsExtractor graphics, @NonNull ItemStack stack, @NonNull Slot slot, @Nullable String itemCount) {
        if(slot == getMenu().inputSlot) {
            graphics.pose().scale(2.0F);
            graphics.item(stack, slot.x - 16, slot.y - 16);

            var font = IClientItemExtensions.of(stack).getFont(stack, IClientItemExtensions.FontContext.ITEM_COUNT);
            graphics.itemDecorations(font != null ? font : this.font, stack, slot.x - 16, slot.y - 16, itemCount);
            graphics.pose().scale(0.5F);
        } else {
            super.renderSlotContents(graphics, stack, slot, itemCount);
        }
    }
}
