package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class ArcaneFamily extends ChiselFamily {
    public ArcaneFamily(BlockBehaviour.Properties props) {
        family = builder("arcane")
                .addVariant("arcane_border", props, CONNECTED)
                .addVariant("arcane_crack", props, V9)
                .addVariant("arcane_matrix", props, V9)
                .addVariant("arcane_tile", props, CONNECTED)
                .addVariant("arcane_big_brick", props, CONNECTED)
                .addVariant("arcane_border_brain", props, CONNECTED)
                .addVariant("arcane_conduit", props, CONNECTED)
                .addVariant("arcane_moon_engrave", props)
                .addVariant("arcane_moon_glow", props)
                .addVariant("arcane_runes", props, V16)
                .addVariant("arcane_runes_glow", props, V16)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("arcane_border"), "Arcane", "Border");
        lang.addBlock(getVariant("arcane_crack"), "Arcane", "Damaged");
        lang.addBlock(getVariant("arcane_matrix"), "Arcane", "Matrix");
        lang.addBlock(getVariant("arcane_tile"), "Arcane", "Tile");
        lang.addBlock(getVariant("arcane_big_brick"), "Arcane", "Big Brick");
        lang.addBlock(getVariant("arcane_border_brain"), "Arcane", "Border Brain");
        lang.addBlock(getVariant("arcane_conduit"), "Arcane", "Conduit");
        lang.addBlock(getVariant("arcane_moon_engrave"), "Arcane", "Moon Engraved");
        lang.addBlock(getVariant("arcane_moon_glow"), "Arcane", "Moon Glow");
        lang.addBlock(getVariant("arcane_runes"), "Arcane", "Runes");
        lang.addBlock(getVariant("arcane_runes_glow"), "Arcane", "Runes Glow");
    }
}

