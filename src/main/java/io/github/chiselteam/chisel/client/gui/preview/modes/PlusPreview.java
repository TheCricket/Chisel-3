package io.github.chiselteam.chisel.client.gui.preview.modes;

public record PlusPreview() implements PreviewMode {
    @Override
    public float scale() {
        return 0.6F;
    }

    @Override
    public float centerX() {
        return 1.5F;
    }

    @Override
    public float centerY() {
        return 2.5F;
    }

    @Override
    public int[][] positions() {
        return new int[][] {
                {1, 1, 0},
                {1, 2, 0}, {2, 2, 0}, {0, 2, 0},
                {1, 3, 0}
        };
    }
}
