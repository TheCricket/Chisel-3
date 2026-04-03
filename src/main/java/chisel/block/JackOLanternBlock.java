package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class JackOLanternBlock extends ChiselBlock {
    public JackOLanternBlock(BlockBehaviour.Properties props) {
        family = builder("jack_o_lantern")
                .addVariant(Blocks.JACK_O_LANTERN)
                .addVariant("jack_o_lantern_0", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_1", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_2", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_3", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_4", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_5", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_6", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_7", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_8", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_9", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_10", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_11", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_12", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_13", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_14", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_15", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_16", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("jack_o_lantern_17", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        for (int i = 0; i <= 15; i++) {
            lang.addBlock(getVariant("jack_o_lantern_" + i), "Jack o'Lantern", "Type " + i);
        }
    }
}

