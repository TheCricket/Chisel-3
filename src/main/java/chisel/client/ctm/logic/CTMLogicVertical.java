package chisel.client.ctm.logic;

import net.minecraft.client.resources.model.cuboid.CuboidFace;

public enum CTMLogicVertical {
    NONE(0, 0), BOTH(0, 16),
    TOP(16, 0), BOTTOM(16, 16);

    private final int u, v;

    CTMLogicVertical(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public CuboidFace.UVs remapUVs(CuboidFace.UVs uvs) {
        float minU = (u + uvs.minU()) / 2.0F;
        float minV = (v + uvs.minV()) / 2.0F;
        float maxU = (u + uvs.maxU()) / 2.0F;
        float maxV = (v + uvs.maxV()) / 2.0F;
        return new CuboidFace.UVs(minU, minV, maxU, maxV);
    }

    public static CTMLogicVertical get(boolean top, boolean bottom) {
        if (top && bottom) return BOTH;
        if (top) return BOTTOM;
        if (bottom) return TOP;
        return NONE;
    }
}
