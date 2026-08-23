package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselCarvedPumpkinBlock;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.PUMPKIN;

public class PumpkinFamily extends ChiselFamily {
    public PumpkinFamily(BlockBehaviour.Properties props) {
        family = builder("pumpkin")
                .addVariant(Blocks.CARVED_PUMPKIN)
                .addVariant("pumpkin_0", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_1", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_2", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_3", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_4", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_5", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_6", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_7", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_8", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_9", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_10", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_11", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_12", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_13", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_14", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_15", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("pumpkin_16", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
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

