package io.github.chiselteam.chisel.block.family.materials.copper;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class OxidizedCopperFamily extends ChiselFamily {
    public OxidizedCopperFamily(BlockBehaviour.Properties props) {
        family = builder("oxidized_copper")
                .addVariant(Blocks.OXIDIZED_COPPER)
                // .addVariant(Blocks.OXIDIZED_CHISELED_COPPER)
                // .addVariant(Blocks.OXIDIZED_CUT_COPPER)
                // .addVariant(Blocks.OXIDIZED_COPPER_GRATE)
                .addWeatheringVariant("oxidized_copper_bad_greggy", props, CONNECTED)
                .addWeatheringVariant("oxidized_copper_bolted", props, CUBE_ALL)
                .addWeatheringVariant("oxidized_copper_caution", props, CONNECTED)
                .addWeatheringVariant("oxidized_copper_crate", props, CONNECTED)
                .addWeatheringVariant("oxidized_copper_machine", props, CUBE_ALL)
                .addWeatheringVariant("oxidized_copper_scaffold", props, CONNECTED)
                .addWeatheringVariant("oxidized_copper_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        addWaxedTranslation(lang, "oxidized_copper_bad_greggy", "Oxidized Copper", "An Old Relic from the land of Oneteufyv");
        addWaxedTranslation(lang, "oxidized_copper_bolted", "Oxidized Copper", "Fancy Bolted Plating");
        addWaxedTranslation(lang, "oxidized_copper_caution", "Oxidized Copper", "Caution Stripes");
        addWaxedTranslation(lang, "oxidized_copper_crate", "Oxidized Copper", "Shipping Crate");
        addWaxedTranslation(lang, "oxidized_copper_machine", "Oxidized Copper", "Machine");
        addWaxedTranslation(lang, "oxidized_copper_scaffold", "Oxidized Copper", "Scaffold");
        addWaxedTranslation(lang, "oxidized_copper_thermal", "Oxidized Copper", "Thermal");
    }
}

