package chisel.block.item;

import chisel.core.variant.Variant;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class ChiselBlockItem extends BlockItem {

    private final Variant variant;

    public ChiselBlockItem(Variant variant, Properties properties) {
        super(variant.getBlock(), properties);
        this.variant = variant;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(@NonNull ItemStack stack, @NonNull TooltipContext context, @NonNull TooltipDisplay display, @NonNull Consumer<Component> builder, @NonNull TooltipFlag flag) {
        builder.accept(Component.translatable(variant.getTranslationKey()).withStyle(ChatFormatting.GRAY));
    }
}
