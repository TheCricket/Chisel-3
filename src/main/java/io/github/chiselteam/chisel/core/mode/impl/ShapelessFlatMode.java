package io.github.chiselteam.chisel.core.mode.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.core.mode.ChiselMode;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

public class ShapelessFlatMode extends ChiselMode {
    private static final int SEARCH_RADIUS = 10;
    private static final int MAX_AFFECTED_BLOCKS = 256;

    public ShapelessFlatMode() {
        super(Chisel.prefix("shapeless_flat"));
    }

    @Override
    public List<BlockPos> getAffectedBlocks(Level level, Player player, BlockPos pos, Direction side, BlockState state) {
        List<BlockPos> affected = new ArrayList<>(Math.min(MAX_AFFECTED_BLOCKS, 64));
        Queue<Long> toProcess = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        Direction up = side.getAxis().isVertical() ? Direction.NORTH : Direction.UP;
        Direction right = side.getAxis().isVertical() ? Direction.EAST : side.getClockWise();
        Direction[] directions = {up, up.getOpposite(), right, right.getOpposite()};

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
            if (!isSameBlock(level, state, level.getBlockState(mutablePos))) continue;

            affected.add(BlockPos.of(packedPos));

            for (Direction direction : directions) {
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
