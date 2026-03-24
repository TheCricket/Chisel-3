package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class LeafBlock extends ChiselBlock {
    public LeafBlock(BlockBehaviour.Properties props) {
        

        family = builder("leaf")
                .addVariant("leaf_0", props)
                .addVariant("leaf_1", props)
                .addVariant("leaf_2", props)
                .addVariant("leaf_3", props)
                .addVariant("leaf_4", props)
                .addVariant("leaf_5", props)
                .addVariant("leaf_6", props)
                .addVariant("leaf_7", props)
                .addVariant("leaf_8", props)
                .addVariant("leaf_9", props)
                .addVariant("leaf_10", props)
                .addVariant("leaf_11", props)
                .addVariant("leaf_12", props)
                .addVariant("leaf_13", props)
                .addVariant("leaf_14", props)
                .addVariant("leaf_15", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        for (int i = 0; i <= 15; i++) {
            lang.addBlock(getVariant("leaf_" + i), "Leaf", "Type " + i);
        }
    }
}

