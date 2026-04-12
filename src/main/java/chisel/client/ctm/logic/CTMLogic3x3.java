package chisel.client.ctm.logic;

import net.minecraft.client.resources.model.cuboid.CuboidFace;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public enum CTMLogic3x3 {
    TOP_LEFT(0, 0), TOP_CENTER(16, 0), TOP_RIGHT(32, 0),
    MID_LEFT(0, 16), MID_CENTER(16, 16), MID_RIGHT(32, 16),
    BOTTOM_LEFT(0, 32), BOTTOM_CENTER(16, 32), BOTTOM_RIGHT(32, 32);

    private final int u, v;

    CTMLogic3x3(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public CuboidFace.UVs remapUVs(CuboidFace.UVs uvs) {
        float minU = (u + uvs.minU()) / 3.0f;
        float minV = (v + uvs.minV()) / 3.0f;
        float maxU = (u + uvs.maxU()) / 3.0f;
        float maxV = (v + uvs.maxV()) / 3.0f;
        return new CuboidFace.UVs(minU, minV, maxU, maxV);
    }

    public static CTMLogic3x3 get(BlockPos pos, Direction face) {
        int x = pos.getX() % 3;
        int y = pos.getY() % 3;
        int z = pos.getZ() % 3;

        if (x < 0) x += 3;
        if (y < 0) y += 3;
        if (z < 0) z += 3;

        int col, row;
        switch (face) {
            case UP, DOWN -> {
                col = x;
                row = z;
            }
            case NORTH, SOUTH -> {
                col = x;
                row = 2 - y;
            }
            case EAST, WEST -> {
                col = z;
                row = 2 - y;
            }
            default -> {
                col = 0;
                row = 0;
            }
        }
        return values()[row * 3 + col];
    }
}