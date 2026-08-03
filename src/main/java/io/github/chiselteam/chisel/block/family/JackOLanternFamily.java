package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselCarvedPumpkinBlock;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.PUMPKIN;

public class JackOLanternFamily extends ChiselFamily {
    public JackOLanternFamily(BlockBehaviour.Properties props) {
        family = builder("jack_o_lantern")
                .addVariant("jack_o_lantern_0", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_1", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_2", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_3", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_4", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_5", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_6", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_7", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_8", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_9", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_10", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_11", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_12", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_13", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_14", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_15", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
                .addVariant("jack_o_lantern_16", ChiselCarvedPumpkinBlock::new, () -> props, PUMPKIN)
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

