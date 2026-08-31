package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.List;

import static io.github.chiselteam.chisel.util.BuildingShapes.local;

/**
 * Hollow ellipsoid ("sphere") shell inscribed in the {@code width x height x length}
 * bounding box. The three semi-axes are {@code width/2}, {@code height/2} and
 * {@code length/2}, so non-uniform dimensions produce a stretched sphere.
 * <p>
 * A position is part of the shell when it is inside the ellipsoid but has at least one
 * neighbour on the six-connected grid that is outside it – this produces a one-block-thick
 * shell for any axis dimension.
 */
public class SphereMode extends ChiselBuildingMode {

    public SphereMode() {
        super(Chisel.prefix("sphere"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        List<BlockPos> list = new ArrayList<>();
        double cx = (width  - 1) / 2.0;
        double cy = (height - 1) / 2.0;
        double cz = (length - 1) / 2.0;
        double rx = Math.max(0.5, width  / 2.0);
        double ry = Math.max(0.5, height / 2.0);
        double rz = Math.max(0.5, length / 2.0);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < length; z++) {
                    if (isShell(x, y, z, cx, cy, cz, rx, ry, rz)) {
                        list.add(local(origin, x, y, z));
                    }
                }
            }
        }
        return list;
    }

    static boolean inside(double x, double y, double z,
                          double cx, double cy, double cz,
                          double rx, double ry, double rz) {
        double dx = (x - cx) / rx;
        double dy = (y - cy) / ry;
        double dz = (z - cz) / rz;
        return dx * dx + dy * dy + dz * dz <= 1.0;
    }

    static boolean isShell(int x, int y, int z,
                           double cx, double cy, double cz,
                           double rx, double ry, double rz) {
        if (!inside(x, y, z, cx, cy, cz, rx, ry, rz)) return false;
        return !inside(x + 1, y, z, cx, cy, cz, rx, ry, rz)
                || !inside(x - 1, y, z, cx, cy, cz, rx, ry, rz)
                || !inside(x, y + 1, z, cx, cy, cz, rx, ry, rz)
                || !inside(x, y - 1, z, cx, cy, cz, rx, ry, rz)
                || !inside(x, y, z + 1, cx, cy, cz, rx, ry, rz)
                || !inside(x, y, z - 1, cx, cy, cz, rx, ry, rz);
    }
}
