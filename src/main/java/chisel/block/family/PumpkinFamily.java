package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PumpkinFamily extends ChiselFamily {
    public PumpkinFamily(BlockBehaviour.Properties props) {
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
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("pumpkin_0"), "Pumpkin", "Surprised");
        lang.addBlock(getVariant("pumpkin_1"), "Pumpkin", "Smiling open");
        lang.addBlock(getVariant("pumpkin_2"), "Pumpkin", "Cheeky");
        lang.addBlock(getVariant("pumpkin_3"), "Pumpkin", "Pensive");
        lang.addBlock(getVariant("pumpkin_4"), "Pumpkin", "Disappointed");
        lang.addBlock(getVariant("pumpkin_5"), "Pumpkin", "Smirking");
        lang.addBlock(getVariant("pumpkin_6"), "Pumpkin", "Curious");
        lang.addBlock(getVariant("pumpkin_7"), "Pumpkin", "Bored");
        lang.addBlock(getVariant("pumpkin_8"), "Pumpkin", "Sad");
        lang.addBlock(getVariant("pumpkin_9"), "Pumpkin", "Evil");
        lang.addBlock(getVariant("pumpkin_10"), "Pumpkin", "Exited");
        lang.addBlock(getVariant("pumpkin_11"), "Pumpkin", "Sleeping");
        lang.addBlock(getVariant("pumpkin_12"), "Pumpkin", "Astonished");
        lang.addBlock(getVariant("pumpkin_13"), "Pumpkin", "Neutral");
        lang.addBlock(getVariant("pumpkin_14"), "Pumpkin", "Laughing out loud");
        lang.addBlock(getVariant("pumpkin_15"), "Pumpkin", "Smiling Closed");
        lang.addBlock(getVariant("pumpkin_16"), "Pumpkin", "Scary");
    }
}

