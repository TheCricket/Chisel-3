package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class PlatinumFamily extends ChiselFamily {
    public PlatinumFamily(BlockBehaviour.Properties props) {
        family = builder("platinum")
                .addVariant("platinum_bad_greggy", props, CONNECTED)
                .addVariant("platinum_bolted", props)
                .addVariant("platinum_caution", props, CONNECTED)
                .addVariant("platinum_crate", props, CONNECTED)
                .addVariant("platinum_machine", props)
                .addVariant("platinum_scaffold", props, CONNECTED)
                .addVariant("platinum_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("platinum_bad_greggy"), "Platinum", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("platinum_bolted"), "Platinum", "Fancy Bolted Plating");
        lang.addBlock(getVariant("platinum_caution"), "Platinum", "Caution Stripes");
        lang.addBlock(getVariant("platinum_crate"), "Platinum", "Shipping Crate");
        lang.addBlock(getVariant("platinum_machine"), "Platinum", "Machine");
        lang.addBlock(getVariant("platinum_scaffold"), "Platinum", "Scaffold");
        lang.addBlock(getVariant("platinum_thermal"), "Platinum", "Thermal");
    }
}

