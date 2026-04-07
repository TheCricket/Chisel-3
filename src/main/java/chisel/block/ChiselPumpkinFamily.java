package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ChiselPumpkinFamily extends ChiselBlock {
    public ChiselPumpkinFamily(BlockBehaviour.Properties props) {
        family = builder("pumpkin")
                .addVariant(Blocks.PUMPKIN)
                .addVariant("pumpkin_0", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_1", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_2", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_3", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_4", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_5", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_6", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_7", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_8", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_9", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_10", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_11", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_12", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_13", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_14", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_15", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_16", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .addVariant("pumpkin_17", CarvedPumpkinBlock::new, () -> props, VariantModelType.PUMPKIN)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        for (int i = 0; i <= 17; i++) {
            lang.addBlock(getVariant("pumpkin_" + i), "Pumpkin", "Type " + i);
        }
    }
}

