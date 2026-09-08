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

public class RowChiselMode extends ChiselMode {
    public RowChiselMode() {
        super(Chisel.prefix("row"));
    }

    @Override
    public List<BlockPos> getAffectedBlocks(Level level, Player player, BlockPos pos, Direction side, BlockState state) {
        List<BlockPos> affected = new ArrayList<>(3);
        Direction right = side.getAxis().isVertical() ? Direction.EAST : side.getClockWise();

        if (isSameBlock(level, state, level.getBlockState(pos))) affected.add(pos);

        BlockPos rightPos = pos.relative(right);
        if (isSameBlock(level, state, level.getBlockState(rightPos))) affected.add(rightPos);

        BlockPos leftPos = pos.relative(right.getOpposite());
        if (isSameBlock(level, state, level.getBlockState(leftPos))) affected.add(leftPos);

        return affected;
    }
}
