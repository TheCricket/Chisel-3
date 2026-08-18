package io.github.chiselteam.chisel.block.family.materials.copper;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class WeatheredCopperFamily extends ChiselFamily {
    public WeatheredCopperFamily(BlockBehaviour.Properties props) {
        family = builder("weathered_copper")
                .addVariant(Blocks.WEATHERED_COPPER)
                .addVariant(Blocks.WEATHERED_CHISELED_COPPER)
                .addVariant(Blocks.WEATHERED_CUT_COPPER)
                .addVariant(Blocks.WEATHERED_COPPER_GRATE)
                .addWeatheringVariant("weathered_copper_bad_greggy", props, CONNECTED)
                .addWeatheringVariant("weathered_copper_bolted", props, CUBE_ALL)
                .addWeatheringVariant("weathered_copper_caution", props, CONNECTED)
                .addWeatheringVariant("weathered_copper_crate", props, CONNECTED)
                .addWeatheringVariant("weathered_copper_machine", props, CUBE_ALL)
                .addWeatheringVariant("weathered_copper_scaffold", props, CONNECTED)
                .addWeatheringVariant("weathered_copper_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        addWaxedTranslation(lang, "weathered_copper_bad_greggy", "Weathered Copper", "An Old Relic from the land of Oneteufyv");
        addWaxedTranslation(lang, "weathered_copper_bolted", "Weathered Copper", "Fancy Bolted Plating");
        addWaxedTranslation(lang, "weathered_copper_caution", "Weathered Copper", "Caution Stripes");
        addWaxedTranslation(lang, "weathered_copper_crate", "Weathered Copper", "Shipping Crate");
        addWaxedTranslation(lang, "weathered_copper_machine", "Weathered Copper", "Machine");
        addWaxedTranslation(lang, "weathered_copper_scaffold", "Weathered Copper", "Scaffold");
        addWaxedTranslation(lang, "weathered_copper_thermal", "Weathered Copper", "Thermal");
    }
}

