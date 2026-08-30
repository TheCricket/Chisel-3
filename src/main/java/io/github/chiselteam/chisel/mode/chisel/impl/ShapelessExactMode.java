package io.github.chiselteam.chisel.mode.chisel.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.family.VariantFamilyLookup;
import io.github.chiselteam.chisel.mode.chisel.ChiselMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

public class ShapelessExactMode extends ChiselMode {
    private static final int SEARCH_RADIUS = 10;
    private static final int MAX_AFFECTED_BLOCKS = 512;

    public ShapelessExactMode() {
        super(Chisel.prefix("shapeless_exact"));
    }

    @Override
    public List<BlockPos> getAffectedBlocks(Level level, Player player, BlockPos pos, Direction side, BlockState state) {
        if (VariantFamilyLookup.getFamilyForBlock(state.getBlock(), level.registryAccess()) == null) return List.of();

        List<BlockPos> affected = new ArrayList<>(Math.min(MAX_AFFECTED_BLOCKS, 64));
        Queue<Long> toProcess = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        long origin = pos.asLong();
        toProcess.add(origin);
        visited.add(origin);

        int originX = pos.getX();
        int originY = pos.getY();
        int originZ = pos.getZ();
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        while (!toProcess.isEmpty() && affected.size() < MAX_AFFECTED_BLOCKS) {
            long packedPos = toProcess.remove();
            int x = BlockPos.getX(packedPos);
            int y = BlockPos.getY(packedPos);
            int z = BlockPos.getZ(packedPos);

            mutablePos.set(x, y, z);

            if (level.getBlockState(mutablePos).getBlock() != state.getBlock()) continue;

            affected.add(BlockPos.of(packedPos));

            for (Direction direction : Direction.values()) {
                int nextX = x + direction.getStepX();
                int nextY = y + direction.getStepY();
                int nextZ = z + direction.getStepZ();

                if (Math.abs(nextX - originX) > SEARCH_RADIUS) continue;
                if (Math.abs(nextY - originY) > SEARCH_RADIUS) continue;
                if (Math.abs(nextZ - originZ) > SEARCH_RADIUS) continue;

                long next = BlockPos.asLong(nextX, nextY, nextZ);
                if (visited.add(next)) toProcess.add(next);
            }
        }

        return affected;
    }
}
