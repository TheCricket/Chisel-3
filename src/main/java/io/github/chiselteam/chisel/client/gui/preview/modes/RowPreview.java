package io.github.chiselteam.chisel.client.gui.preview.modes;

public record RowPreview() implements PreviewMode {
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
        return 1.5F;
    }

    @Override
    public int[][] positions() {
        return new int[][] {
                {0, 1, 0}, {1, 1, 0}, {2, 1, 0}
        };
    }
}
