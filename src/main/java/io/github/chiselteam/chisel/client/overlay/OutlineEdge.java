package io.github.chiselteam.chisel.client.overlay;

import net.minecraft.util.Mth;

public record OutlineEdge(float x1, float y1, float z1, float x2, float y2, float z2, float normalX, float normalY,
                          float normalZ) {

    public static OutlineEdge create(double x1, double y1, double z1, double x2, double y2, double z2) {
        float deltaX = (float) (x2 - x1);
        float deltaY = (float) (y2 - y1);
        float deltaZ = (float) (z2 - z1);
        float length = Mth.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

        if (length > 0.0F) {
            deltaX /= length;
            deltaY /= length;
            deltaZ /= length;
        }

        return new OutlineEdge((float) x1, (float) y1, (float) z1, (float) x2, (float) y2, (float) z2, deltaX, deltaY, deltaZ);
    }
}