package io.github.chiselteam.chisel.mode.chisel.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.chisel.ChiselMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class PanelChiselMode extends ChiselMode {
    public PanelChiselMode() {
        super(Chisel.prefix("panel"));
    }

    @Override
    public List<BlockPos> getAffectedBlocks(Level level, Player player, BlockPos pos, Direction side, BlockState state) {
        List<BlockPos> affected = new ArrayList<>(9);
        Direction up = side.getAxis().isVertical() ? Direction.NORTH : Direction.UP;
        Direction right = side.getAxis().isVertical() ? Direction.EAST : side.getClockWise();

        for (int vertical = -1; vertical <= 1; vertical++) {
            for (int horizontal = -1; horizontal <= 1; horizontal++) {
                BlockPos testPos = pos
                        .relative(up, vertical)
                        .relative(right, horizontal);

                if (isSameBlock(level, state, level.getBlockState(testPos))) affected.add(testPos);
            }
        }

        return affected;
    }
}
