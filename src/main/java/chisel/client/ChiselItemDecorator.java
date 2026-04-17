package chisel.client;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.client.IItemDecorator;
import org.jspecify.annotations.NonNull;

public class ChiselItemDecorator implements IItemDecorator {
    @Override
    public boolean render(@NonNull GuiGraphicsExtractor gui, @NonNull Font font, @NonNull ItemStack stack, int xOffset, int yOffset) {
        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData != null) {
            ItemStack innerStack = customData.copyTag().contains("chiselItem")
                    ? ItemStack.CODEC.parse(NbtOps.INSTANCE, customData.copyTag().get("chiselItem")).result().orElse(ItemStack.EMPTY)
                    : ItemStack.EMPTY;

            if (!innerStack.isEmpty()) {
                gui.pose().scale(0.5F, 0.5F);
                gui.item(innerStack, (xOffset + 8) * 2, (yOffset + 8) * 2);
                gui.pose().scale(2.0F, 2.0F);
            }
        }
        return true;
    }
}
