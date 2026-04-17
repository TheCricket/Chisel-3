package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LeafFamily extends ChiselBlock {
    public LeafFamily(BlockBehaviour.Properties props) {
        family = builder("leaf")
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