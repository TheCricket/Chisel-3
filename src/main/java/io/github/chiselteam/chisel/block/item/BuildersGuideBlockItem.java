package io.github.chiselteam.chisel.block.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class BuildersGuideBlockItem extends BlockItem {
    public BuildersGuideBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(@NonNull ItemStack stack, @NonNull TooltipContext context, @NonNull TooltipDisplay display, Consumer<Component> builder, @NonNull TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("tooltip.chisel.builders_guide.mode_desc").withStyle(ChatFormatting.GRAY));
        builder.accept(Component.translatable("tooltip.chisel.builders_guide.length_desc").withStyle(ChatFormatting.GRAY));
        builder.accept(Component.translatable("tooltip.chisel.builders_guide.width_desc").withStyle(ChatFormatting.GRAY));
        builder.accept(Component.translatable("tooltip.chisel.builders_guide.height_desc").withStyle(ChatFormatting.GRAY));
        builder.accept(Component.translatable("tooltip.chisel.builders_guide.place_desc").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, context, display, builder, tooltipFlag);
    }
}
