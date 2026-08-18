package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class TinFamily extends ChiselFamily {
    public TinFamily(BlockBehaviour.Properties props) {
        family = builder("tin")
                .addVariant("tin_125", props)
                .addVariant("tin_bad_greggy", props, CONNECTED)
                .addVariant("tin_bolted", props)
                .addVariant("tin_caution", props, CONNECTED)
                .addVariant("tin_crate", props)
                .addVariant("tin_egregious", props, CONNECTED)
                .addVariant("tin_scaffold", props, CONNECTED)
                .addVariant("tin_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("tin_125"), "Tin", "125");
        lang.addBlock(getVariant("tin_bad_greggy"), "Tin", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("tin_bolted"), "Tin", "Fancy Bolted Plating");
        lang.addBlock(getVariant("tin_caution"), "Tin", "Caution Stripes");
        lang.addBlock(getVariant("tin_crate"), "Tin", "Shipping Crate");
        lang.addBlock(getVariant("tin_egregious"), "Tin", "Egregiously Bordered Block");
        lang.addBlock(getVariant("tin_scaffold"), "Tin", "Scaffold");
        lang.addBlock(getVariant("tin_thermal"), "Tin", "Thermal");
    }
}

