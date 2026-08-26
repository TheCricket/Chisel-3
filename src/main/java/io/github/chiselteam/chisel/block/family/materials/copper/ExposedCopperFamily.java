package io.github.chiselteam.chisel.block.family.materials.copper;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class ExposedCopperFamily extends ChiselFamily {
    public ExposedCopperFamily(BlockBehaviour.Properties props) {
        family = builder("exposed_copper")
                .addVariant(Blocks.EXPOSED_COPPER)
                // .addVariant(Blocks.EXPOSED_CHISELED_COPPER)
                // .addVariant(Blocks.EXPOSED_CUT_COPPER)
                // .addVariant(Blocks.EXPOSED_COPPER_GRATE)
                .addWeatheringVariant("exposed_copper_bad_greggy", props, CONNECTED)
                .addWeatheringVariant("exposed_copper_bolted", props, CUBE_ALL)
                .addWeatheringVariant("exposed_copper_caution", props, CONNECTED)
                .addWeatheringVariant("exposed_copper_crate", props, CONNECTED)
                .addWeatheringVariant("exposed_copper_machine", props, CUBE_ALL)
                .addWeatheringVariant("exposed_copper_scaffold", props, CONNECTED)
                .addWeatheringVariant("exposed_copper_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        addWaxedTranslation(lang, "exposed_copper_bad_greggy", "Exposed Copper", "An Old Relic from the land of Oneteufyv");
        addWaxedTranslation(lang, "exposed_copper_bolted", "Exposed Copper", "Fancy Bolted Plating");
        addWaxedTranslation(lang, "exposed_copper_caution", "Exposed Copper", "Caution Stripes");
        addWaxedTranslation(lang, "exposed_copper_crate", "Exposed Copper", "Shipping Crate");
        addWaxedTranslation(lang, "exposed_copper_machine", "Exposed Copper", "Machine");
        addWaxedTranslation(lang, "exposed_copper_scaffold", "Exposed Copper", "Scaffold");
        addWaxedTranslation(lang, "exposed_copper_thermal", "Exposed Copper", "Thermal");
    }
}

