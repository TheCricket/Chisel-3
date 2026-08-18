package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class LeadFamily extends ChiselFamily {
    public LeadFamily(BlockBehaviour.Properties props) {
        family = builder("lead")
                .addVariant("lead_bad_greggy", props, CONNECTED)
                .addVariant("lead_bolted", props)
                .addVariant("lead_caution", props, CONNECTED)
                .addVariant("lead_crate", props, CONNECTED)
                .addVariant("lead_machine", props)
                .addVariant("lead_scaffold", props, CONNECTED)
                .addVariant("lead_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("lead_bad_greggy"), "Lead", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("lead_bolted"), "Lead", "Fancy Bolted Plating");
        lang.addBlock(getVariant("lead_caution"), "Lead", "Caution Stripes");
        lang.addBlock(getVariant("lead_crate"), "Lead", "Shipping Crate");
        lang.addBlock(getVariant("lead_machine"), "Lead", "Machine");
        lang.addBlock(getVariant("lead_scaffold"), "Lead", "Scaffold");
        lang.addBlock(getVariant("lead_thermal"), "Lead", "Thermal");
    }
}

