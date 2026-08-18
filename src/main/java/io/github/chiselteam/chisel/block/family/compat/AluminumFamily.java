package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class AluminumFamily extends ChiselFamily {
    public AluminumFamily(BlockBehaviour.Properties props) {
        family = builder("aluminum")
                .addVariant("aluminum_bad_greggy", props, CONNECTED)
                .addVariant("aluminum_bolted", props)
                .addVariant("aluminum_caution", props, CONNECTED)
                .addVariant("aluminum_crate", props, CONNECTED)
                .addVariant("aluminum_machine", props)
                .addVariant("aluminum_scaffold", props, CONNECTED)
                .addVariant("aluminum_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("aluminum_bad_greggy"), "Aluminum", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("aluminum_bolted"), "Aluminum", "Fancy Bolted Plating");
        lang.addBlock(getVariant("aluminum_caution"), "Aluminum", "Caution Stripes");
        lang.addBlock(getVariant("aluminum_crate"), "Aluminum", "Shipping Crate");
        lang.addBlock(getVariant("aluminum_machine"), "Aluminum", "Machine");
        lang.addBlock(getVariant("aluminum_scaffold"), "Aluminum", "Scaffold");
        lang.addBlock(getVariant("aluminum_thermal"), "Aluminum", "Thermal");
    }
}

