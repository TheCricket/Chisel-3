package io.github.chiselteam.chisel.client.gui.palette;

import net.minecraft.network.chat.Component;

import java.util.Locale;

public enum PaletteColor {
    RED(0xFFC94B49), ORANGE(0xFFE79235), YELLOW(0xFFE5D34D), GREEN(0xFF65A34C),
    BLUE(0xFF4C86C6), PURPLE(0xFF9D63B8), BROWN(0xFF825432),
    WHITE(0xFFF1F0E8), GRAY(0xFF888888), BLACK(0xFF242424);

    private final int swatch;

    PaletteColor(int swatch) {
        this.swatch = swatch;
    }

    public static PaletteColor classify(int rgb) {
        float r = (rgb >> 16 & 255) / 255F, g = (rgb >> 8 & 255) / 255F, b = (rgb & 255) / 255F;
        float max = Math.max(r, Math.max(g, b)), min = Math.min(r, Math.min(g, b));
        float delta = max - min, saturation = max == 0 ? 0 : delta / max;
        if (max < 0.19F) return BLACK;
        if (saturation < 0.16F) return max >= 0.78F ? WHITE : GRAY;
        float hue = delta == 0 ? 0 : max == r ? ((g - b) / delta) % 6 : max == g ? (b - r) / delta + 2 : (r - g) / delta + 4;
        hue = (hue * 60 + 360) % 360;
        // Browns are dark or muted orange/yellow, rather than an average of unrelated colors.
        if (hue >= 12 && hue < 65 && (max < 0.67F || (max < 0.82F && saturation < 0.5F))) return BROWN;
        if (hue < 16 || hue >= 335) return RED;
        if (hue < 43) return ORANGE;
        if (hue < 70) return YELLOW;
        if (hue < 170) return GREEN;
        if (hue < 260) return BLUE;
        return PURPLE;
    }

    public int swatch() {
        return swatch;
    }

    public Component label() {
        return Component.translatable("chisel.palette.color." + name().toLowerCase(Locale.ROOT));
    }
}
