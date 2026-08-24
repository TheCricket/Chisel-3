package io.github.chiselteam.chisel.client.moss;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ClientMossData {
    private static final Set<Long> POSITIONS = new HashSet<>();

    private ClientMossData() {
    }

    public static boolean contains(BlockPos pos) {
        return POSITIONS.contains(pos.asLong());
    }

    public static void set(BlockPos pos, boolean mossy) {
        if (mossy) POSITIONS.add(pos.asLong());
        else POSITIONS.remove(pos.asLong());
    }

    public static void replaceChunk(ChunkPos chunk, List<BlockPos> positions) {
        POSITIONS.removeIf(value -> {
            BlockPos pos = BlockPos.of(value);
            return new ChunkPos(pos.getX() >> 4, pos.getZ() >> 4).equals(chunk);
        });
        positions.forEach(pos -> POSITIONS.add(pos.asLong()));
    }

    public static void clear() {
        POSITIONS.clear();
    }

    public static List<BlockPos> positions() {
        return POSITIONS.stream().map(BlockPos::of).toList();
    }
}
