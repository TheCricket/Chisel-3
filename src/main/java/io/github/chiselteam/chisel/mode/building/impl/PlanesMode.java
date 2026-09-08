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
 * Three orthogonal filled rectangles meeting at the origin corner: the XY plane
 * ({@code width x height}), the XZ (floor) plane ({@code width x length}) and the YZ plane
 * ({@code length x height}). Useful for aligning walls and floors.
 */
public class PlanesMode extends ChiselBuildingMode {

    public PlanesMode() {
        super(Chisel.prefix("planes"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        Set<BlockPos> set = new HashSet<>();
        // XY plane (z = 0)
        for (int x = 0; x < width;  x++)
            for (int y = 0; y < height; y++)
                set.add(local(origin, x, y, 0));
        // XZ plane (y = 0) – the floor
        for (int x = 0; x < width;  x++)
            for (int z = 0; z < length; z++)
                set.add(local(origin, x, 0, z));
        // YZ plane (x = 0)
        for (int y = 0; y < height; y++)
            for (int z = 0; z < length; z++)
                set.add(local(origin, 0, y, z));
        return new ArrayList<>(set);
    }
}
