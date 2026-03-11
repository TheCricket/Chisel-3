package chisel.menu;

import chisel.Chisel;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import org.jspecify.annotations.NonNull;

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

        int x = (imageWidth - theoreticalImageWidth) / 2;
        int y = (imageHeight - theoreticalImageHeight) / 2;

        Slot main = getMenu().inputSlot;

        if(!main.hasItem()) {
            gui.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, 8, 8, 8, theoreticalImageHeight, 48, 48, imageWidth, imageHeight);
        }
    }

    @Override
    protected void renderLabels(@NonNull GuiGraphics gui, int mouseX, int mouseY) {
        gui.drawString(font, title, 8, 6, 16777215, true);
        gui.drawString(font, Component.translatable("container.inventory"), 8, this.imageHeight - 94, 16777215, true);
    }
}
