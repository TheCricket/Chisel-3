package io.github.chiselteam.chisel.projectile;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MossData {
    public static final com.mojang.serialization.MapCodec<MossData> CODEC = Codec.LONG.listOf().fieldOf("positions")
            .xmap(MossData::new, MossData::serializedPositions);

    private final Set<Long> positions;

    public MossData() {
        this.positions = new HashSet<>();
    }

    private MossData(List<Long> positions) {
        this.positions = new HashSet<>(positions);
    }

    public boolean add(BlockPos pos) {
        return positions.add(pos.asLong());
    }

    public boolean remove(BlockPos pos) {
        return positions.remove(pos.asLong());
    }

    public boolean contains(BlockPos pos) {
        return positions.contains(pos.asLong());
    }

    public List<BlockPos> inChunk(ChunkPos chunk) {
        return positions.stream().map(BlockPos::of)
                .filter(pos -> new ChunkPos(pos.getX() >> 4, pos.getZ() >> 4).equals(chunk)).toList();
    }

    private List<Long> serializedPositions() {
        return List.copyOf(positions);
    }
}
