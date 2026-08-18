package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class ElectrumFamily extends ChiselFamily {
    public ElectrumFamily(BlockBehaviour.Properties props) {
        family = builder("electrum")
                .addVariant("electrum_bad_greggy", props, CONNECTED)
                .addVariant("electrum_bolted", props)
                .addVariant("electrum_caution", props, CONNECTED)
                .addVariant("electrum_crate", props, CONNECTED)
                .addVariant("electrum_machine", props)
                .addVariant("electrum_scaffold", props, CONNECTED)
                .addVariant("electrum_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("electrum_bad_greggy"), "Electrum", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("electrum_bolted"), "Electrum", "Fancy Bolted Plating");
        lang.addBlock(getVariant("electrum_caution"), "Electrum", "Caution Stripes");
        lang.addBlock(getVariant("electrum_crate"), "Electrum", "Shipping Crate");
        lang.addBlock(getVariant("electrum_machine"), "Electrum", "Machine");
        lang.addBlock(getVariant("electrum_scaffold"), "Electrum", "Scaffold");
        lang.addBlock(getVariant("electrum_thermal"), "Electrum", "Thermal");
    }
}

