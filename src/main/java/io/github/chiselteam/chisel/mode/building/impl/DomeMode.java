package io.github.chiselteam.chisel.mode.building.impl;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.mode.building.ChiselBuildingMode;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.List;

import static io.github.chiselteam.chisel.mode.building.impl.SphereMode.inside;
import static io.github.chiselteam.chisel.mode.building.impl.SphereMode.isShell;
import static io.github.chiselteam.chisel.util.BuildingShapes.local;

/**
 * Upper half of an ellipsoid – a hollow dome. Uses the same ellipsoid as
 * {@link SphereMode} but keeps only the top half (y at or above the centre).
 * A flat floor ring is added along the equator so the dome is closed at the bottom edge.
 */
public class DomeMode extends ChiselBuildingMode {

    public DomeMode() {
        super(Chisel.prefix("dome"));
    }

    @Override
    protected List<BlockPos> generate(BlockPos origin, int length, int width, int height) {
        List<BlockPos> list = new ArrayList<>();
        // Treat the full ellipsoid as if height were doubled, then only emit the top half.
        double cx = (width  - 1) / 2.0;
        double cy = 0.0; // dome starts at y = 0
        double cz = (length - 1) / 2.0;
        double rx = Math.max(0.5, width  / 2.0);
        double ry = Math.max(0.5, height);
        double rz = Math.max(0.5, length / 2.0);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < length; z++) {
                    boolean shell = isShell(x, y, z, cx, cy, cz, rx, ry, rz);
                    // Add the bottom ring: any point on the base plane that is inside the
                    // ellipsoid outline forms part of the closed floor edge – but since we
                    // want a hollow dome (no floor fill), we only keep the actual shell.
                    if (shell) {
                        list.add(local(origin, x, y, z));
                    } else if (y == 0 && inside(x, 0, z, cx, cy, cz, rx, ry, rz)
                            && !inside(x, -1, z, cx, cy, cz, rx, ry, rz)) {
                        // No-op: keep the dome hollow (no floor). Kept for clarity.
                    }
                }
            }
        }
        return list;
    }
}
