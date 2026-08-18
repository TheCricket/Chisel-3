package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class NeoVitaeFamily extends ChiselFamily {
    public NeoVitaeFamily(BlockBehaviour.Properties props) {
        family = builder("neovitae")
                .addVariant("neovitae_arranged", props, CONNECTED)
                .addVariant("neovitae_bricks", props, TBS)
                .addVariant("neovitae_carved", props)
                .addVariant("neovitae_carved_radial", props)
                .addVariant("neovitae_classic", props)
                .addVariant("neovitae_classic_panel", props)
                .addVariant("neovitae_diagonal_bricks", props)
                .addVariant("neovitae_diagonal_bricks_0", props, CONNECTED)
                .addVariant("neovitae_diagonal_bricks_1", props, CONNECTED)
                .addVariant("neovitae_diagonal_bricks_2", props, CONNECTED)
                .addVariant("neovitae_diagonal_bricks_3", props, CONNECTED)
                .addVariant("neovitae_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("neovitae_arranged"), "Blank Rune", "Arranged");
        lang.addBlock(getVariant("neovitae_bricks"), "Blank Rune", "Blank Rune Bricks");
        lang.addBlock(getVariant("neovitae_carved"), "Blank Rune", "Carved Blank Rune");
        lang.addBlock(getVariant("neovitae_carved_radial"), "Blank Rune", "Radial Carved Rune");
        lang.addBlock(getVariant("neovitae_classic"), "Blank Rune", "Classic");
        lang.addBlock(getVariant("neovitae_classic_panel"), "Blank Rune", "Classic Panel");
        lang.addBlock(getVariant("neovitae_diagonal_bricks"), "Blank Rune", "Diagonal Rune Bricks");
        lang.addBlock(getVariant("neovitae_diagonal_bricks_0"), "Blank Rune", "Diagonal Rune Bricks");
        lang.addBlock(getVariant("neovitae_diagonal_bricks_1"), "Blank Rune", "Diagonal Rune Bricks");
        lang.addBlock(getVariant("neovitae_diagonal_bricks_2"), "Blank Rune", "Diagonal Rune Bricks");
        lang.addBlock(getVariant("neovitae_diagonal_bricks_3"), "Blank Rune", "Diagonal Rune Bricks");
        lang.addBlock(getVariant("neovitae_tiles"), "Blank Rune", "Tiles");
    }
}