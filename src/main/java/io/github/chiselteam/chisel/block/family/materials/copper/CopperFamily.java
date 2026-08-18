package io.github.chiselteam.chisel.block.family.materials.copper;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CopperFamily extends ChiselFamily {
    public CopperFamily(BlockBehaviour.Properties props) {
        family = builder("copper")
                .addVariant(Blocks.COPPER_BLOCK)
                .addVariant(Blocks.CHISELED_COPPER)
                .addVariant(Blocks.CUT_COPPER)
                .addVariant(Blocks.COPPER_GRATE)
                .addWeatheringVariant("copper_bad_greggy", props, CONNECTED)
                .addWeatheringVariant("copper_bolted", props, CUBE_ALL)
                .addWeatheringVariant("copper_caution", props, CONNECTED)
                .addWeatheringVariant("copper_crate", props, CONNECTED)
                .addWeatheringVariant("copper_machine", props, CUBE_ALL)
                .addWeatheringVariant("copper_scaffold", props, CONNECTED)
                .addWeatheringVariant("copper_thermal", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        addWaxedTranslation(lang, "copper_bad_greggy", "Block of Copper", "An Old Relic from the land of Oneteufyv");
        addWaxedTranslation(lang, "copper_bolted", "Block of Copper", "Fancy Bolted Plating");
        addWaxedTranslation(lang, "copper_caution", "Block of Copper", "Caution Stripes");
        addWaxedTranslation(lang, "copper_crate", "Block of Copper", "Shipping Crate");
        addWaxedTranslation(lang, "copper_machine", "Block of Copper", "Machine");
        addWaxedTranslation(lang, "copper_scaffold", "Block of Copper", "Scaffold");
        addWaxedTranslation(lang, "copper_thermal", "Block of Copper", "Thermal");
    }
}

