package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import io.github.chiselteam.chisel.util.BuildingShapes;
import net.minecraft.core.BlockPos;

import java.util.List;

/** Hollow pentagonal prism (vertical walls only). */
public class PentagonMode extends ChiselBuildingMode {

    public PentagonMode() {
        super(Chisel.prefix("pentagon"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        return BuildingShapes.polygonPrism(origin, length, width, height, 5, -Math.PI / 2.0);
    }
}
