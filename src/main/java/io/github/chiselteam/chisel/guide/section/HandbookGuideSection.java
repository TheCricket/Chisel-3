package io.github.chiselteam.chisel.guide.section;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import io.github.chiselteam.chisel.Chisel;
import net.minecraft.resources.Identifier;

public sealed interface HandbookGuideSection permits TextSection, TipSection, PaletteSection {
    Codec<HandbookGuideSection> CODEC = Identifier.CODEC.dispatch("type", HandbookGuideSection::type, HandbookGuideSection::codecFor);

    private static MapCodec<? extends HandbookGuideSection> codecFor(Identifier type) {
        if (type.equals(Chisel.prefix("text"))) return TextSection.CODEC;
        if (type.equals(Chisel.prefix("tip"))) return TipSection.CODEC;
        if (type.equals(Chisel.prefix("palette"))) return PaletteSection.CODEC;

        throw new IllegalArgumentException("Unknown handbook section type: " + type);
    }

    Identifier type();
}
