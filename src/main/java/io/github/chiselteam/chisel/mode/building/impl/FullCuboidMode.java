package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.List;

import static io.github.chiselteam.chisel.util.BuildingShapes.local;

/**
 * Hollow full cuboid: all six faces of the axis-aligned box are populated
 * (the interior is left empty).
 */
public class FullCuboidMode extends ChiselBuildingMode {

    public FullCuboidMode() {
        super(Chisel.prefix("full_cuboid"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        List<BlockPos> list = new ArrayList<>();
        int lMax = length - 1;
        int wMax = width - 1;
        int hMax = height - 1;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < length; z++) {
                    if (x == 0 || x == wMax || y == 0 || y == hMax || z == 0 || z == lMax) {
                        list.add(local(origin, x, y, z));
                    }
                }
            }
        }
        return list;
    }
}
