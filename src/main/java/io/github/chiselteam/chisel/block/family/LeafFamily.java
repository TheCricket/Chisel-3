package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class LeafFamily extends ChiselFamily {
    public LeafFamily(BlockBehaviour.Properties props) {
        family = builder("leaf")
                .addVariant(Blocks.OAK_LEAVES)
                .addVariant("leaf_christmas_balls", props)
                .addVariant("leaf_christmas_lights", props)
                .addVariant("leaf_dead", props)
                .addVariant("leaf_fancy", props)
                .addVariant("leaf_pink", props)
                .addVariant("leaf_red", props)
                .addVariant("leaf_white", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("leaf_christmas_balls"), "Leaf Block", "Christmas Balls");
        lang.addBlock(getVariant("leaf_christmas_lights"), "Leaf Block", "Christmas Lights");
        lang.addBlock(getVariant("leaf_dead"), "Leaf Block", "Dead Leaves");
        lang.addBlock(getVariant("leaf_fancy"), "Leaf Block", "Fancy Leaves");
        lang.addBlock(getVariant("leaf_pink"), "Leaf Block", "Pink Petals");
        lang.addBlock(getVariant("leaf_red"), "Leaf Block", "Red Rose");
        lang.addBlock(getVariant("leaf_white"), "Leaf Block", "White Rose");
    }
}