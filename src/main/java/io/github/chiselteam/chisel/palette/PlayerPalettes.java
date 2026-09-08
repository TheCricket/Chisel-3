package io.github.chiselteam.chisel.palette;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.*;

public record PlayerPalettes(List<PlayerPalette> palettes, Optional<UUID> activeId) {
    public static final int MAX_PALETTES = 32;
    public static final PlayerPalettes EMPTY = new PlayerPalettes(List.of(), Optional.empty());
    public static final MapCodec<PlayerPalettes> CODEC = RecordCodecBuilder.<PlayerPalettes>mapCodec(i -> i.group(
            PlayerPalette.CODEC.listOf(0, MAX_PALETTES).optionalFieldOf("palettes", List.of()).forGetter(PlayerPalettes::palettes),
            UUIDUtil.STRING_CODEC.optionalFieldOf("active").forGetter(PlayerPalettes::activeId)
    ).apply(i, PlayerPalettes::new)).flatXmap(PlayerPalettes::validate, PlayerPalettes::validate);
    public static final StreamCodec<RegistryFriendlyByteBuf, PlayerPalettes> STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistries(CODEC.codec());

    public PlayerPalettes {
        palettes = List.copyOf(palettes);
    }

    private static DataResult<PlayerPalettes> validate(PlayerPalettes value) {
        var ids = new HashSet<UUID>();
        if (value.palettes.size() > MAX_PALETTES) return DataResult.error(() -> "Too many palettes");
        for (var palette : value.palettes) {
            if (!ids.add(palette.id())) return DataResult.error(() -> "Duplicate palette ID");
        }
        if (value.activeId.isPresent() && !ids.contains(value.activeId.get()))
            return DataResult.error(() -> "Active palette does not exist");
        return DataResult.success(value);
    }

    public Optional<PlayerPalette> find(UUID id) {
        return palettes.stream().filter(p -> p.id().equals(id)).findFirst();
    }

    public Optional<PlayerPalette> active() {
        return activeId.flatMap(this::find);
    }

    public PlayerPalettes add(PlayerPalette palette) {
        if (palettes.size() >= MAX_PALETTES) throw new IllegalArgumentException("You may save at most 32 palettes");
        if (find(palette.id()).isPresent()) throw new IllegalArgumentException("Palette ID already exists");
        var updated = new ArrayList<>(palettes);
        updated.add(palette);
        return new PlayerPalettes(updated, activeId);
    }

    public PlayerPalettes replace(PlayerPalette palette) {
        require(palette.id());
        return new PlayerPalettes(palettes.stream().map(p -> p.id().equals(palette.id()) ? palette : p).toList(), activeId);
    }

    public PlayerPalettes delete(UUID id) {
        require(id);
        return new PlayerPalettes(palettes.stream().filter(p -> !p.id().equals(id)).toList(), activeId.filter(active -> !active.equals(id)));
    }

    public PlayerPalettes select(Optional<UUID> id) {
        id.ifPresent(this::require);
        return new PlayerPalettes(palettes, id);
    }

    public PlayerPalette require(UUID id) {
        return find(id).orElseThrow(() -> new IllegalArgumentException("You do not own that palette"));
    }
}
