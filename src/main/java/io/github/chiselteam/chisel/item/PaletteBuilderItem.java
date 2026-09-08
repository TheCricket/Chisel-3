package io.github.chiselteam.chisel.item;

import io.github.chiselteam.chisel.network.OpenPaletteBuilderPacket;
import io.github.chiselteam.chisel.palette.PlayerPaletteManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jspecify.annotations.NonNull;

public final class PaletteBuilderItem extends Item {
    public PaletteBuilderItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if (player instanceof ServerPlayer owner) {
            PlayerPaletteManager.get(owner);
            PacketDistributor.sendToPlayer(owner, OpenPaletteBuilderPacket.INSTANCE);
        }
        return InteractionResult.SUCCESS;
    }
}
