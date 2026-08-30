package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class ForbiddenArcanusFamilies {
    public static final ChiselFamily FA_ARCANE_DARKSTONE;
    private static final List<ChiselFamily> FAMILIES;

    static {
        FA_ARCANE_DARKSTONE = ChiselFamily.build("fa_arcane_darkstone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .addVariant("arcane_border", ChiselModelHandlers.CONNECTED).translation("arcane_border", "Arcane", "Border")
                .addVariant("arcane_crack", ChiselModelHandlers.V9).translation("arcane_crack", "Arcane", "Damaged")
                .addVariant("arcane_matrix", ChiselModelHandlers.V9).translation("arcane_matrix", "Arcane", "Matrix")
                .addVariant("arcane_tile", ChiselModelHandlers.CONNECTED).translation("arcane_tile", "Arcane", "Tile")
                .addVariant("arcane_big_brick", ChiselModelHandlers.CONNECTED).translation("arcane_big_brick", "Arcane", "Big Brick")
                .addVariant("arcane_border_brain", ChiselModelHandlers.CONNECTED).translation("arcane_border_brain", "Arcane", "Border Brain")
                .addVariant("arcane_conduit", ChiselModelHandlers.CONNECTED).translation("arcane_conduit", "Arcane", "Conduit")
                .addVariant("arcane_moon_engrave").translation("arcane_moon_engrave", "Arcane", "Moon Engraved")
                .addVariant("arcane_moon_glow").translation("arcane_moon_glow", "Arcane", "Moon Glow")
                .addVariant("arcane_runes", ChiselModelHandlers.V16).translation("arcane_runes", "Arcane", "Runes")
                .addVariant("arcane_runes_glow", ChiselModelHandlers.V16).translation("arcane_runes_glow", "Arcane", "Runes Glow")
                .build());

        FAMILIES = List.of(FA_ARCANE_DARKSTONE);
    }

    private ForbiddenArcanusFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
