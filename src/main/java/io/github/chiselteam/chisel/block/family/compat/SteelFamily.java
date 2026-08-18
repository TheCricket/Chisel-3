package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class SteelFamily extends ChiselFamily {
    public SteelFamily(BlockBehaviour.Properties props) {
        family = builder("steel")
                .addVariant("steel_125", props)
                .addVariant("steel_bad_greggy", props, CONNECTED)
                .addVariant("steel_bolted", props)
                .addVariant("steel_caution", props, CONNECTED)
                .addVariant("steel_crate", props, CONNECTED)
                .addVariant("steel_egregious", props, CONNECTED)
                .addVariant("steel_scaffold", props, CONNECTED)
                .addVariant("steel_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("steel_125"), "Steel", "125");
        lang.addBlock(getVariant("steel_bad_greggy"), "Steel", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("steel_bolted"), "Steel", "Fancy Bolted Plating");
        lang.addBlock(getVariant("steel_caution"), "Steel", "Caution Stripes");
        lang.addBlock(getVariant("steel_crate"), "Steel", "Shipping Crate");
        lang.addBlock(getVariant("steel_egregious"), "Steel", "Egregiously Bordered Block");
        lang.addBlock(getVariant("steel_scaffold"), "Steel", "Scaffold");
        lang.addBlock(getVariant("steel_thermal"), "Steel", "Thermal");
    }
}

