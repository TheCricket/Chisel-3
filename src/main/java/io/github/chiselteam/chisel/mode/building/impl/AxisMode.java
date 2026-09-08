package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.github.chiselteam.chisel.util.BuildingShapes.local;

/**
 * Three orthogonal lines meeting at the origin corner: one along +X for {@code width},
 * one along +Y for {@code height}, and one along +Z (local, i.e. world -Z) for {@code length}.
 * Useful as a 3D axis reference / measuring guide.
 */
public class AxisMode extends ChiselBuildingMode {

    public AxisMode() {
        super(Chisel.prefix("axes"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        Set<BlockPos> set = new HashSet<>();
        for (int x = 0; x < width;  x++) set.add(local(origin, x, 0, 0));
        for (int y = 0; y < height; y++) set.add(local(origin, 0, y, 0));
        for (int z = 0; z < length; z++) set.add(local(origin, 0, 0, z));
        return new ArrayList<>(set);
    }
}
