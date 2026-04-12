package chisel.client.ctm.logic;

import net.minecraft.client.resources.model.cuboid.CuboidFace;

public enum CTMLogicHorizontal {
    NONE(0, 0), BOTH(16, 0),
    RIGHT(0, 16), LEFT(16, 16);

    private final int u, v;

    CTMLogicHorizontal(int u, int v) {
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

    public static CTMLogicHorizontal get(boolean left, boolean right) {
        if (left && right) return BOTH;
        if (left) return RIGHT;
        if (right) return LEFT;
        return NONE;
    }
}
