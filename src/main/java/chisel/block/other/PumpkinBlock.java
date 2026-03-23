package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class PumpkinBlock extends ChiselBlock {
    public PumpkinBlock(BlockBehaviour.Properties props) {
        

        family = builder("pumpkin")
                .addVariant(Blocks.PUMPKIN)
                .addVariant("pumpkin_0", props)
                .addVariant("pumpkin_1", props)
                .addVariant("pumpkin_2", props)
                .addVariant("pumpkin_3", props)
                .addVariant("pumpkin_4", props)
                .addVariant("pumpkin_5", props)
                .addVariant("pumpkin_6", props)
                .addVariant("pumpkin_7", props)
                .addVariant("pumpkin_8", props)
                .addVariant("pumpkin_9", props)
                .addVariant("pumpkin_10", props)
                .addVariant("pumpkin_11", props)
                .addVariant("pumpkin_12", props)
                .addVariant("pumpkin_13", props)
                .addVariant("pumpkin_14", props)
                .addVariant("pumpkin_15", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        for (int i = 0; i <= 15; i++) {
            lang.addBlock(getVariant("pumpkin_" + i), "Pumpkin", "Type " + i);
        }
    }
}

