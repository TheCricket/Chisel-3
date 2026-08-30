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
 * Wireframe cuboid: only the 12 edges of the axis-aligned box are populated.
 */
public class CuboidMode extends ChiselBuildingMode {

    public CuboidMode() {
        super(Chisel.prefix("cuboid"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        Set<BlockPos> set = new HashSet<>();
        int lMax = length - 1;
        int wMax = width - 1;
        int hMax = height - 1;

        for (int x = 0; x < width; x++) {
            set.add(local(origin, x, 0,    0));
            set.add(local(origin, x, 0,    lMax));
            set.add(local(origin, x, hMax, 0));
            set.add(local(origin, x, hMax, lMax));
        }
        for (int y = 0; y < height; y++) {
            set.add(local(origin, 0,    y, 0));
            set.add(local(origin, wMax, y, 0));
            set.add(local(origin, 0,    y, lMax));
            set.add(local(origin, wMax, y, lMax));
        }
        for (int z = 0; z < length; z++) {
            set.add(local(origin, 0,    0,    z));
            set.add(local(origin, wMax, 0,    z));
            set.add(local(origin, 0,    hMax, z));
            set.add(local(origin, wMax, hMax, z));
        }
        return new ArrayList<>(set);
    }
}
