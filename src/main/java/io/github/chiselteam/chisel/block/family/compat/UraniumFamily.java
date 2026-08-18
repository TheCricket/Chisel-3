package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class UraniumFamily extends ChiselFamily {
    public UraniumFamily(BlockBehaviour.Properties props) {
        family = builder("uranium")
                .addVariant("uranium_125", props)
                .addVariant("uranium_bad_greggy", props, CONNECTED)
                .addVariant("uranium_bolted", props)
                .addVariant("uranium_caution", props, CONNECTED)
                .addVariant("uranium_crate", props, CONNECTED)
                .addVariant("uranium_machine", props)
                .addVariant("uranium_scaffold", props, CONNECTED)
                .addVariant("uranium_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("uranium_125"), "Uranium", "125");
        lang.addBlock(getVariant("uranium_bad_greggy"), "Uranium", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("uranium_bolted"), "Uranium", "Fancy Bolted Plating");
        lang.addBlock(getVariant("uranium_caution"), "Uranium", "Caution Stripes");
        lang.addBlock(getVariant("uranium_crate"), "Uranium", "Shipping Crate");
        lang.addBlock(getVariant("uranium_machine"), "Uranium", "Machine");
        lang.addBlock(getVariant("uranium_scaffold"), "Uranium", "Scaffold");
        lang.addBlock(getVariant("uranium_thermal"), "Uranium", "Thermal");
    }
}


