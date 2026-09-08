package io.github.chiselteam.chisel.palette;

import io.github.chiselteam.chisel.registry.ChiselAttachments;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

import java.util.Optional;
import java.util.UUID;

public final class PlayerPaletteManager {
    private PlayerPaletteManager() {
    }

    public static PlayerPalettes get(Player player) {
        return player.getData(ChiselAttachments.PALETTES);
    }

    public static UUID save(ServerPlayer player, Optional<UUID> id, PaletteDefinition definition) {
        var current = get(player);
        var previous = id.map(current::require);
        PaletteDefinition.validate(definition).getOrThrow(IllegalArgumentException::new);
        if ((!BuiltInRegistries.ITEM.containsKey(definition.icon()) || BuiltInRegistries.ITEM.getValue(definition.icon()) == Items.AIR)
                && previous.map(p -> !p.definition().icon().equals(definition.icon())).orElse(true))
            throw new IllegalArgumentException("Choose an existing item for the palette icon");
        for (var entry : definition.entries()) {
            var block = BuiltInRegistries.BLOCK.getOptional(entry.block());
            boolean wasSaved = previous.map(p -> p.definition().entries().stream().anyMatch(e -> e.block().equals(entry.block()))).orElse(false);
            if (!wasSaved && (block.isEmpty() || block.get().defaultBlockState().isAir() || block.get().asItem() == Items.AIR))
                throw new IllegalArgumentException("Palette entries must reference placeable blocks: " + entry.block());
        }
        var palette = new PlayerPalette(id.orElseGet(UUID::randomUUID), definition);
        var updated = id.isPresent() ? current.replace(palette) : current.add(palette);
        if (!current.equals(updated)) player.setData(ChiselAttachments.PALETTES, updated);
        return palette.id();
    }

    public static void delete(ServerPlayer player, UUID id) {
        player.setData(ChiselAttachments.PALETTES, get(player).delete(id));
    }

    public static void select(ServerPlayer player, Optional<UUID> id) {
        var current = get(player);
        var updated = current.select(id);
        if (!current.equals(updated)) player.setData(ChiselAttachments.PALETTES, updated);
    }
}
