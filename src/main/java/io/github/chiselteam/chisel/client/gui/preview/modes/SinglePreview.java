package io.github.chiselteam.chisel.client.gui.preview.modes;

public record SinglePreview() implements PreviewMode {
    @Override
    public float scale() {
        return 1.0F;
    }

    @Override
    public float centerX() {
        return 0.5F;
    }

    @Override
    public float centerY() {
        return 0.5F;
    }

    @Override
    public int[][] positions() {
        return new int[][] {
                {0, 0, 0}
        };
    }
}
