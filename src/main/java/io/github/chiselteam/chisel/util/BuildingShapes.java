package io.github.chiselteam.chisel.util;

import io.github.chiselteam.chisel.block.BuildersGuideBlock;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/// Small utility helpers shared by the built-in [ChiselBuildingMode]
/// implementations. All shapes work in a local bounding box
/// `[0, width) x [0, height) x [0, length)` and are translated to world space via
/// [#local(BlockPos, int, int, int)].
///
/// Coordinate convention (mirrors [BuildersGuideBlock]):
///
///   - Local +x -> world +X (width extends east)
///   - Local +y -> world +Y (height extends up)
///   - Local +z -> world -Z (length extends north)
public final class BuildingShapes {

    private BuildingShapes() {}

    /// Translates a local (x, y, z) offset into a world [BlockPos].
    public static BlockPos local(BlockPos origin, int x, int y, int z) {
        return new BlockPos(origin.getX() + x, origin.getY() + y, origin.getZ() - z);
    }

    /// Generates a hollow regular-polygon prism inscribed in the `width x height x length`
    /// bounding box: an `sides`-gon footprint (in the X/Z plane), centred in the box,
    /// with horizontal "radii" `width/2` and `length/2`, extruded vertically for
    /// `height` blocks. Only the vertical walls are emitted (no top/bottom caps).
    ///
    /// @param sides         number of polygon sides (>= 3)
    /// @param rotationRad   rotation applied around the vertical axis, in radians
    public static List<BlockPos> polygonPrism(BlockPos origin, int length, int width, int height,
                                              int sides, double rotationRad) {
        Set<BlockPos> set = new LinkedHashSet<>();
        double cx = (width  - 1) / 2.0;
        double cz = (length - 1) / 2.0;
        double rx = Math.max(0.5, width  / 2.0);
        double rz = Math.max(0.5, length / 2.0);

        double[] vx = new double[sides];
        double[] vz = new double[sides];
        for (int i = 0; i < sides; i++) {
            double a = rotationRad + (2.0 * Math.PI * i) / sides;
            vx[i] = cx + rx * Math.cos(a);
            vz[i] = cz + rz * Math.sin(a);
        }

        for (int i = 0; i < sides; i++) {
            double x0 = vx[i], z0 = vz[i];
            double x1 = vx[(i + 1) % sides], z1 = vz[(i + 1) % sides];
            plotLineXZ(set, origin, x0, z0, x1, z1, height);
        }
        return new ArrayList<>(set);
    }

    /// Rasterizes a line segment in the X/Z plane using a simple DDA algorithm and extrudes each
    /// covered cell vertically for `height` blocks. Cells are added to `out`.
    private static void plotLineXZ(Set<BlockPos> out, BlockPos origin,
                                   double x0, double z0, double x1, double z1, int height) {
        double dx = x1 - x0;
        double dz = z1 - z0;
        int steps = (int) Math.ceil(Math.max(Math.abs(dx), Math.abs(dz))) * 2 + 1;
        for (int s = 0; s <= steps; s++) {
            double t = (double) s / steps;
            int x = (int) Math.round(x0 + dx * t);
            int z = (int) Math.round(z0 + dz * t);
            for (int y = 0; y < height; y++) {
                out.add(local(origin, x, y, z));
            }
        }
    }
}
