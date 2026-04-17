package chisel.client.ctm.logic;

import net.minecraft.client.resources.model.cuboid.CuboidFace;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public enum CTMLogic2x2 {
    TOP_LEFT(0, 0), TOP_RIGHT(16, 0),
    BOTTOM_LEFT(0, 16), BOTTOM_RIGHT(16, 16);

    private final int u, v;

    CTMLogic2x2(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public CuboidFace.UVs remapUVs(CuboidFace.UVs uvs) {
        float minU = (u + uvs.minU()) / 2.0f;
        float minV = (v + uvs.minV()) / 2.0f;
        float maxU = (u + uvs.maxU()) / 2.0f;
        float maxV = (v + uvs.maxV()) / 2.0f;
        return new CuboidFace.UVs(minU, minV, maxU, maxV);
    }

    public static CTMLogic2x2 get(BlockPos pos, Direction face) {
        int x = pos.getX() % 2;
        int y = pos.getY() % 2;
        int z = pos.getZ() % 2;

        if (x < 0) x += 2;
        if (y < 0) y += 2;
        if (z < 0) z += 2;

        int col, row;
        switch (face) {
            case UP, DOWN -> {
                col = x;
                row = z;
            }
            case NORTH, SOUTH -> {
                col = x;
                row = 1 - y;
            }
            case EAST, WEST -> {
                col = z;
                row = 1 - y;
            }
            default -> {
                col = 0;
                row = 0;
            }
        }
        return values()[row * 2 + col];
    }
}
