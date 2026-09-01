package io.github.chiselteam.chisel.projectile;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MossData {
    public static final MapCodec<MossData> CODEC = MossEntry.CODEC.listOf().fieldOf("entries").xmap(MossData::new, MossData::serializedEntries);

    private final Map<Long, Integer> entries;

    public MossData() {
        this.entries = new HashMap<>();
    }

    private MossData(List<MossEntry> entries) {
        this.entries = new HashMap<>();
        entries.forEach(entry -> this.entries.put(entry.pos().asLong(), entry.texture()));
    }

    public boolean add(BlockPos pos, int texture) {
        if (texture < 1 || texture > 10) throw new IllegalArgumentException("Moss texture must be between 1 and 10");
        return entries.putIfAbsent(pos.asLong(), texture) == null;
    }

    public boolean remove(BlockPos pos) {
        return entries.remove(pos.asLong()) != null;
    }

    public boolean contains(BlockPos pos) {
        return entries.containsKey(pos.asLong());
    }

    public List<MossEntry> inChunk(ChunkPos chunk) {
        return serializedEntries().stream().filter(entry -> {
            BlockPos pos = entry.pos();
            return new ChunkPos(pos.getX() >> 4, pos.getZ() >> 4).equals(chunk);
        }).toList();
    }

    private List<MossEntry> serializedEntries() {
        return entries.entrySet().stream().map(entry -> new MossEntry(BlockPos.of(entry.getKey()), entry.getValue())).toList();
    }
}
