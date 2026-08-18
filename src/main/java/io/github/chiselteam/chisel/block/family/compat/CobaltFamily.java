package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class CobaltFamily extends ChiselFamily {
    public CobaltFamily(BlockBehaviour.Properties props) {
        family = builder("cobalt")
                .addVariant("cobalt_bad_greggy", props, CONNECTED)
                .addVariant("cobalt_bolted", props)
                .addVariant("cobalt_caution", props, CONNECTED)
                .addVariant("cobalt_crate", props, CONNECTED)
                .addVariant("cobalt_machine", props)
                .addVariant("cobalt_scaffold", props, CONNECTED)
                .addVariant("cobalt_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("cobalt_bad_greggy"), "Cobalt", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("cobalt_bolted"), "Cobalt", "Fancy Bolted Plating");
        lang.addBlock(getVariant("cobalt_caution"), "Cobalt", "Caution Stripes");
        lang.addBlock(getVariant("cobalt_crate"), "Cobalt", "Shipping Crate");
        lang.addBlock(getVariant("cobalt_machine"), "Cobalt", "Machine");
        lang.addBlock(getVariant("cobalt_scaffold"), "Cobalt", "Scaffold");
        lang.addBlock(getVariant("cobalt_thermal"), "Cobalt", "Thermal");
    }
}

