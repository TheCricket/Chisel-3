package io.github.chiselteam.chisel.item;

import io.github.chiselteam.chisel.network.OpenHandbookPacket;
import io.github.chiselteam.chisel.registry.ChiselStats;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class BuildersHandbookItem extends Item {
    public BuildersHandbookItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, OpenHandbookPacket.INSTANCE);

        player.awardStat(ChiselStats.CHISEL_GUIDE_USED.get());
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(@NonNull ItemStack itemStack, @NonNull TooltipContext context, @NonNull TooltipDisplay display, Consumer<Component> builder, @NonNull TooltipFlag tooltipFlag) {
        builder.accept(Component.literal("[WIP]").withStyle(ChatFormatting.RED));
    }
}
