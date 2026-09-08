package io.github.chiselteam.chisel.client.gui.palette;

public final class PaletteColorProfile {
    private final double[] amounts = new double[PaletteColor.values().length];
    private double total;
    private double samples;

    public void addPixel(int argb, int tint) {
        samples++;
        int alpha = argb >>> 24;
        if (alpha == 0) return;
        int r = (argb >> 16 & 255) * (tint >> 16 & 255) / 255;
        int g = (argb >> 8 & 255) * (tint >> 8 & 255) / 255;
        int b = (argb & 255) * (tint & 255) / 255;
        amounts[PaletteColor.classify(r << 16 | g << 8 | b).ordinal()] += alpha / 255.0;
        total += alpha / 255.0;
    }

    public void add(PaletteColorProfile profile, double area) {
        if (profile.samples == 0 || area <= 0) return;
        for (int i = 0; i < amounts.length; i++) amounts[i] += profile.amounts[i] / profile.samples * area;
        total += profile.total / profile.samples * area;
        samples += area;
    }

    public double share(PaletteColor color) {
        return total == 0 ? 0 : amounts[color.ordinal()] / total;
    }

    public boolean isEmpty() {
        return total == 0;
    }
}
