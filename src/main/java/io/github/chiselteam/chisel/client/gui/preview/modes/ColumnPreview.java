package io.github.chiselteam.chisel.client.gui.preview.modes;

public record ColumnPreview() implements PreviewMode {
    @Override
    public float scale() {
        return 0.5F;
    }

    @Override
    public float centerX() {
        return 0.5F;
    }

    @Override
    public float centerY() {
        return 2.5F;
    }

    @Override
    public int[][] positions() {
        return new int[][] {
                {0, 1, 0},
                {0, 2, 0},
                {0, 3, 0}
        };
    }
}
