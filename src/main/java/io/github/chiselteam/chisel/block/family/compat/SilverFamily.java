package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class SilverFamily extends ChiselFamily {
    public SilverFamily(BlockBehaviour.Properties props) {
        family = builder("silver")
                .addVariant("silver_125", props)
                .addVariant("silver_bad_greggy", props, CONNECTED)
                .addVariant("silver_bolted", props)
                .addVariant("silver_caution", props, CONNECTED)
                .addVariant("silver_crate", props, CONNECTED)
                .addVariant("silver_scaffold", props, CONNECTED)
                .addVariant("silver_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("silver_125"), "Silver", "125");
        lang.addBlock(getVariant("silver_bad_greggy"), "Silver", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("silver_bolted"), "Silver", "Fancy Bolted Plating");
        lang.addBlock(getVariant("silver_caution"), "Silver", "Caution Stripes");
        lang.addBlock(getVariant("silver_crate"), "Silver", "Shipping Crate");
        lang.addBlock(getVariant("silver_scaffold"), "Silver", "Scaffold");
        lang.addBlock(getVariant("silver_thermal"), "Silver", "Thermal");
    }
}

