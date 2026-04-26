package chisel.block.item;

import chisel.core.variant.Variant;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class TorchBlockItem extends StandingAndWallBlockItem {

    private final Variant variant;

    public TorchBlockItem(Variant variant, Block block, Block wallBlock, Properties properties) {
        super(block, wallBlock, Direction.DOWN, properties);
        this.variant = variant;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(@NonNull ItemStack stack, @NonNull TooltipContext context, @NonNull TooltipDisplay display, @NonNull Consumer<Component> builder, @NonNull TooltipFlag flag) {
        builder.accept(Component.translatable(variant.getTranslationKey()).withStyle(ChatFormatting.GRAY));
    }
}
