package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import io.github.chiselteam.chisel.util.BuildingShapes;
import net.minecraft.core.BlockPos;

import java.util.List;

/**
 * Hollow triangular prism: an equilateral (up to width/length stretch) triangle footprint
 * inscribed in the bounding box, extruded vertically for {@code height} blocks.
 * Only the three vertical walls are populated (no top/bottom caps).
 */
public class TriangleMode extends ChiselBuildingMode {

    public TriangleMode() {
        super(Chisel.prefix("triangle"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        // -Math.PI / 2 puts one vertex at the "north" edge (min Z direction, i.e. +z local).
        return BuildingShapes.polygonPrism(origin, length, width, height, 3, -Math.PI / 2.0);
    }
}
