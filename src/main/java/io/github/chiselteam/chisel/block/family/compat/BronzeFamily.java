package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TBS;

public class BronzeFamily extends ChiselFamily {
    public BronzeFamily(BlockBehaviour.Properties props) {
        family = builder("bronze")
                .addVariant("bronze_bad_greggy", props, CONNECTED)
                .addVariant("bronze_bolted", props)
                .addVariant("bronze_caution", props, CONNECTED)
                .addVariant("bronze_crate", props, CONNECTED)
                .addVariant("bronze_machine", props)
                .addVariant("bronze_scaffold", props, CONNECTED)
                .addVariant("bronze_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("bronze_bad_greggy"), "Bronze", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("bronze_bolted"), "Bronze", "Fancy Bolted Plating");
        lang.addBlock(getVariant("bronze_caution"), "Bronze", "Caution Stripes");
        lang.addBlock(getVariant("bronze_crate"), "Bronze", "Shipping Crate");
        lang.addBlock(getVariant("bronze_machine"), "Bronze", "Machine");
        lang.addBlock(getVariant("bronze_scaffold"), "Bronze", "Scaffold");
        lang.addBlock(getVariant("bronze_thermal"), "Bronze", "Thermal");
    }
}

