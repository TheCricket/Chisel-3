package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class MilitaryFamily extends ChiselFamily {
    public MilitaryFamily(BlockBehaviour.Properties props) {
        family = builder("military")
                .addVariant("military_imperial_camo", props, V4)
                .addVariant("military_imperial_camo_secluded", props, V4)
                .addVariant("military_imperial_caution_orange", props, CONNECTED)
                .addVariant("military_imperial_caution_white", props, CONNECTED)
                .addVariant("military_imperial_plate", props)
                .addVariant("military_rebel_camo", props, V4)
                .addVariant("military_rebel_camo_secluded", props, V4)
                .addVariant("military_rebel_caution_red", props, CONNECTED)
                .addVariant("military_rebel_caution_white", props, CONNECTED)
                .addVariant("military_rebel_plate", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("military_imperial_camo"), "Military", "Camouflaged");
        lang.addBlock(getVariant("military_imperial_camo_secluded"), "Military", "Camouflaged (Secluded)");
        lang.addBlock(getVariant("military_imperial_caution_orange"), "Military", "Teamed Caution Tape");
        lang.addBlock(getVariant("military_imperial_caution_white"), "Military", "White Caution Tape");
        lang.addBlock(getVariant("military_imperial_plate"), "Military", "Bolted Plate");
        lang.addBlock(getVariant("military_rebel_camo"), "Military", "Camouflaged");
        lang.addBlock(getVariant("military_rebel_camo_secluded"), "Military", "Camouflaged (Secluded)");
        lang.addBlock(getVariant("military_rebel_caution_red"), "Military", "Teamed Caution Tape");
        lang.addBlock(getVariant("military_rebel_caution_white"), "Military", "White Caution Tape");
        lang.addBlock(getVariant("military_rebel_plate"), "Military", "Bolted Plate");
    }
}

