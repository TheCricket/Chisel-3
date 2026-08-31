package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import io.github.chiselteam.chisel.util.BuildingShapes;
import net.minecraft.core.BlockPos;

import java.util.List;

/** Hollow hexagonal prism (vertical walls only), flat-top orientation. */
public class HexagonMode extends ChiselBuildingMode {

    public HexagonMode() {
        super(Chisel.prefix("hexagon"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        return BuildingShapes.polygonPrism(origin, length, width, height, 6, 0.0);
    }
}
