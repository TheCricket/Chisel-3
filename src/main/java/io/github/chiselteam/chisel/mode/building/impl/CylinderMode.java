package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.List;

import static io.github.chiselteam.chisel.util.BuildingShapes.local;

/**
 * Vertical hollow cylinder (elliptical cross-section) inscribed in the bounding box.
 * The cross-section is an ellipse with horizontal semi-axes {@code width/2} and
 * {@code length/2}; the cylinder is extruded along the Y axis for {@code height} blocks.
 * Only the tube walls are populated – top and bottom caps are left open.
 */
public class CylinderMode extends ChiselBuildingMode {

    public CylinderMode() {
        super(Chisel.prefix("cylinder"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        List<BlockPos> list = new ArrayList<>();
        double cx = (width  - 1) / 2.0;
        double cz = (length - 1) / 2.0;
        double rx = Math.max(0.5, width  / 2.0);
        double rz = Math.max(0.5, length / 2.0);

        for (int x = 0; x < width; x++) {
            for (int z = 0; z < length; z++) {
                if (isRingCell(x, z, cx, cz, rx, rz)) {
                    for (int y = 0; y < height; y++) {
                        list.add(local(origin, x, y, z));
                    }
                }
            }
        }
        return list;
    }

    private static boolean insideEllipse(double x, double z, double cx, double cz, double rx, double rz) {
        double dx = (x - cx) / rx;
        double dz = (z - cz) / rz;
        return dx * dx + dz * dz <= 1.0;
    }

    private static boolean isRingCell(int x, int z, double cx, double cz, double rx, double rz) {
        if (!insideEllipse(x, z, cx, cz, rx, rz)) return false;
        return !insideEllipse(x + 1, z, cx, cz, rx, rz)
                || !insideEllipse(x - 1, z, cx, cz, rx, rz)
                || !insideEllipse(x, z + 1, cx, cz, rx, rz)
                || !insideEllipse(x, z - 1, cx, cz, rx, rz);
    }
}
