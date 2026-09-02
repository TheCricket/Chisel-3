package io.github.chiselteam.chisel.guide.section.palette;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum PaletteRole implements StringRepresentable {
    PRIMARY("primary"), SECONDARY("secondary"), ACCENT("accent"), RARE("rare");

    public static final Codec<PaletteRole> CODEC = StringRepresentable.fromEnum(PaletteRole::values);
    private final String SERIALIZED_NAME;

    PaletteRole(String serializedName) {
        this.SERIALIZED_NAME = serializedName;
    }

    @Override
    public @NonNull String getSerializedName() {
        return SERIALIZED_NAME;
    }
}
