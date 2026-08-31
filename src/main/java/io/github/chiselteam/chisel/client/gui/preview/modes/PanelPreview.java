package io.github.chiselteam.chisel.client.gui.preview.modes;

public record PanelPreview() implements PreviewMode {
    @Override
    public float scale() {
        return 0.5F;
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
                {0, 1, 0}, {1, 1, 0}, {2, 1, 0},
                {0, 2, 0}, {1, 2, 0}, {2, 2, 0},
                {0, 3, 0}, {1, 3, 0}, {2, 3, 0}
        };
    }
}
