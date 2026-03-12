package chisel.menu;

import chisel.Chisel;
import net.minecraft.client.gui.GuiGraphics;
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
    private final int theoreticalImageWidth = 252;
    private final int theoreticalImageHeight = 202;

    public ChiselScreen(ChiselMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 256, 256);
    }

    @Override
    protected void renderBg(@NonNull GuiGraphics gui, float partialTick, int mouseX, int mouseY) {
        leftPos = (width - theoreticalImageWidth) >> 1;
        topPos = (height - theoreticalImageHeight) >> 1;

        gui.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, leftPos, topPos, 0, 0, theoreticalImageWidth, theoreticalImageHeight, imageWidth, imageHeight);

        int x = (width - theoreticalImageWidth) / 2;
        int y = (height - theoreticalImageHeight) / 2;

        Slot main = getMenu().inputSlot;

        if(!main.hasItem()) {
            gui.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 8, y + 8, 0, theoreticalImageHeight, 48, 48, imageWidth, imageHeight);
        }
    }

    @Override
    protected void renderLabels(@NonNull GuiGraphics gui, int mouseX, int mouseY) {
        gui.drawString(font, title, 8, 6, 16777215, true);
        gui.drawString(font, Component.translatable("container.inventory"), 8, this.imageHeight - 94, 16777215, true);
    }

    @Override
    protected void renderSlotContents(@NonNull GuiGraphics gui, @NonNull ItemStack stack, @NonNull Slot slot, @Nullable String itemCount) {
        if(slot == getMenu().inputSlot) {
            gui.pose().scale(2.0F);
            gui.renderItem(stack, slot.x - 16, slot.y - 16);

            var font = IClientItemExtensions.of(stack).getFont(stack, IClientItemExtensions.FontContext.ITEM_COUNT);
            gui.renderItemDecorations(font != null ? font : this.font, stack, slot.x - 16, slot.y - 16, itemCount);
            gui.pose().scale(0.5F);
        } else {
            super.renderSlotContents(gui, stack, slot, itemCount);
        }
    }
}
