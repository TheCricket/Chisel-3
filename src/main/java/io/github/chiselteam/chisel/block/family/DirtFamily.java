package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class DirtFamily extends ChiselFamily {
    public DirtFamily(BlockBehaviour.Properties props) {
        family = builder("dirt")
                .addVariant(Blocks.DIRT)
                .addVariant("dirt_bricks", props, CTMV)
                .addVariant("dirt_bricks_arranged", props)
                .addVariant("dirt_bricks_disarray", props)
                .addVariant("dirt_bricks_large", props)
                .addVariant("dirt_chunky", props)
                .addVariant("dirt_cobble", props)
                .addVariant("dirt_happy", props)
                .addVariant("dirt_horizontal", props, CTMH)
                .addVariant("dirt_layers", props)
                .addVariant("dirt_netherbricks", props)
                .addVariant("dirt_plate", props)
                .addVariant("dirt_reinforced", props, CONNECTED)
                .addVariant("dirt_reinforced_cobble", props, CONNECTED)
                .addVariant("dirt_vert", props, CTMV)
                .addVariant("dirt_vertical", props, CTMV)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("dirt_bricks"), "Dirt", "Dirt Bricks");
        lang.addBlock(getVariant("dirt_bricks_arranged"), "Dirt", "Dirt Bricks");
        lang.addBlock(getVariant("dirt_bricks_disarray"), "Dirt", "Dirt Bricks in Disarray");
        lang.addBlock(getVariant("dirt_bricks_large"), "Dirt", "Large Dirt Bricks");
        lang.addBlock(getVariant("dirt_chunky"), "Dirt", "Crumbling Dirt");
        lang.addBlock(getVariant("dirt_cobble"), "Dirt", "Cobble-Dirt");
        lang.addBlock(getVariant("dirt_happy"), "Dirt", "Happy Dirt");
        lang.addBlock(getVariant("dirt_horizontal"), "Dirt", "Horizontal Dirt");
        lang.addBlock(getVariant("dirt_layers"), "Dirt", "Dirt Layers");
        lang.addBlock(getVariant("dirt_netherbricks"), "Dirt", "Dirt Bricks Imitating Nether Brick Design");
        lang.addBlock(getVariant("dirt_plate"), "Dirt", "Farmland");
        lang.addBlock(getVariant("dirt_reinforced"), "Dirt", "Reinforced Dirt");
        lang.addBlock(getVariant("dirt_reinforced_cobble"), "Dirt", "Reinforced Cobble-Dirt");
        lang.addBlock(getVariant("dirt_vert"), "Dirt", "Vertical Dirt");
        lang.addBlock(getVariant("dirt_vertical"), "Dirt", "Vertical Dirt");
    }
}

