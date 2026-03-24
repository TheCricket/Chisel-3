package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class LitPumpkinBlock extends ChiselBlock {
    public LitPumpkinBlock(BlockBehaviour.Properties props) {
        

        family = builder("lit_pumpkin")
                .addVariant(Blocks.JACK_O_LANTERN)
                .addVariant("lit_pumpkin_0", props)
                .addVariant("lit_pumpkin_1", props)
                .addVariant("lit_pumpkin_2", props)
                .addVariant("lit_pumpkin_3", props)
                .addVariant("lit_pumpkin_4", props)
                .addVariant("lit_pumpkin_5", props)
                .addVariant("lit_pumpkin_6", props)
                .addVariant("lit_pumpkin_7", props)
                .addVariant("lit_pumpkin_8", props)
                .addVariant("lit_pumpkin_9", props)
                .addVariant("lit_pumpkin_10", props)
                .addVariant("lit_pumpkin_11", props)
                .addVariant("lit_pumpkin_12", props)
                .addVariant("lit_pumpkin_13", props)
                .addVariant("lit_pumpkin_14", props)
                .addVariant("lit_pumpkin_15", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        for (int i = 0; i <= 15; i++) {
            lang.addBlock(getVariant("lit_pumpkin_" + i), "Jack o'Lantern", "Type " + i);
        }
    }
}

