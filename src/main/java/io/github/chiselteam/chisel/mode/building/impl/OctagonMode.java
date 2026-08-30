package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import io.github.chiselteam.chisel.util.BuildingShapes;
import net.minecraft.core.BlockPos;

import java.util.List;

/** Hollow octagonal prism (vertical walls only). Sides are aligned with the cardinal axes. */
public class OctagonMode extends ChiselBuildingMode {

    public OctagonMode() {
        super(Chisel.prefix("octagon"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        // Offset by 1/2 side so that four of the sides are axis-aligned.
        return BuildingShapes.polygonPrism(origin, length, width, height, 8, Math.PI / 8.0);
    }
}
