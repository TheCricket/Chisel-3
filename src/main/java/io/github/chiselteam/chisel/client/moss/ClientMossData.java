package io.github.chiselteam.chisel.client.moss;

import io.github.chiselteam.chisel.projectile.MossEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ClientMossData {
    private static final Map<Long, Integer> ENTRIES = new HashMap<>();

    private ClientMossData() {
    }

    public static boolean contains(BlockPos pos) {
        return ENTRIES.containsKey(pos.asLong());
    }

    public static void set(BlockPos pos, boolean mossy, int texture) {
        if (mossy) ENTRIES.put(pos.asLong(), texture);
        else ENTRIES.remove(pos.asLong());
    }

    public static void replaceChunk(ChunkPos chunk, List<MossEntry> entries) {
        ENTRIES.keySet().removeIf(value -> {
            BlockPos pos = BlockPos.of(value);
            return new ChunkPos(pos.getX() >> 4, pos.getZ() >> 4).equals(chunk);
        });
        entries.forEach(entry -> ENTRIES.put(entry.pos().asLong(), entry.texture()));
    }

    public static void clear() {
        ENTRIES.clear();
    }

    public static List<MossEntry> entries() {
        return ENTRIES.entrySet().stream().map(entry -> new MossEntry(BlockPos.of(entry.getKey()), entry.getValue())).toList();
    }
}
