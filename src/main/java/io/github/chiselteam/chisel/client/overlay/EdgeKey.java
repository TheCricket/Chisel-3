package io.github.chiselteam.chisel.client.overlay;

public record EdgeKey(int x1, int y1, int z1, int x2, int y2, int z2) {

    public static EdgeKey create(int x1, int y1, int z1, int x2, int y2, int z2) {
        if (comesBefore(x1, y1, z1, x2, y2, z2))
            return new EdgeKey(x1, y1, z1, x2, y2, z2);

        return new EdgeKey(x2, y2, z2, x1, y1, z1);
    }

    private static boolean comesBefore(int x1, int y1, int z1, int x2, int y2, int z2) {
        if (x1 != x2) return x1 < x2;
        if (y1 != y2) return y1 < y2;
        return z1 <= z2;
    }
}