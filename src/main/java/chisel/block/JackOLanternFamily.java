package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class JackOLanternFamily extends ChiselBlock {
    public JackOLanternFamily(BlockBehaviour.Properties props) {
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
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("jack_o_lantern_0"), "Jack o'Lantern", "Suprised");
        lang.addBlock(getVariant("jack_o_lantern_1"), "Jack o'Lantern", "Smiling open");
        lang.addBlock(getVariant("jack_o_lantern_2"), "Jack o'Lantern", "Cheeky");
        lang.addBlock(getVariant("jack_o_lantern_3"), "Jack o'Lantern", "Pensive");
        lang.addBlock(getVariant("jack_o_lantern_4"), "Jack o'Lantern", "Disappointed");
        lang.addBlock(getVariant("jack_o_lantern_5"), "Jack o'Lantern", "Smirking");
        lang.addBlock(getVariant("jack_o_lantern_6"), "Jack o'Lantern", "Curious");
        lang.addBlock(getVariant("jack_o_lantern_7"), "Jack o'Lantern", "Bored");
        lang.addBlock(getVariant("jack_o_lantern_8"), "Jack o'Lantern", "Sad");
        lang.addBlock(getVariant("jack_o_lantern_9"), "Jack o'Lantern", "Evil");
        lang.addBlock(getVariant("jack_o_lantern_10"), "Jack o'Lantern", "Exited");
        lang.addBlock(getVariant("jack_o_lantern_11"), "Jack o'Lantern", "Sleeping");
        lang.addBlock(getVariant("jack_o_lantern_12"), "Jack o'Lantern", "Astonished");
        lang.addBlock(getVariant("jack_o_lantern_13"), "Jack o'Lantern", "Neutral");
        lang.addBlock(getVariant("jack_o_lantern_14"), "Jack o'Lantern", "Laughing out loud");
        lang.addBlock(getVariant("jack_o_lantern_15"), "Jack o'Lantern", "Smiling Closed");
        lang.addBlock(getVariant("jack_o_lantern_16"), "Jack o'Lantern", "Scary");
    }
}

