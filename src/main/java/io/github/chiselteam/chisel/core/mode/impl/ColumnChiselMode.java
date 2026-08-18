package io.github.chiselteam.chisel.core.mode.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.core.mode.ChiselMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class ColumnChiselMode extends ChiselMode {
    public ColumnChiselMode() {
        super(Chisel.prefix("column"));
    }

    @Override
    public List<BlockPos> getAffectedBlocks(Level level, Player player, BlockPos pos, Direction side, BlockState state) {
        List<BlockPos> affected = new ArrayList<>(3);
        Direction up = side.getAxis().isVertical() ? Direction.NORTH : Direction.UP;

        if (isSameBlock(level, state, level.getBlockState(pos))) affected.add(pos);

        BlockPos upPos = pos.relative(up);
        if (isSameBlock(level, state, level.getBlockState(upPos))) affected.add(upPos);

        BlockPos downPos = pos.relative(up.getOpposite());
        if (isSameBlock(level, state, level.getBlockState(downPos))) affected.add(downPos);

        return affected;
    }
}
