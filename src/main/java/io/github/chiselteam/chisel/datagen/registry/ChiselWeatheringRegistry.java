package io.github.chiselteam.chisel.datagen.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.core.weathering.WeatheringChainData;
import io.github.chiselteam.chisel.core.weathering.WeatheringChains;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Datapack registry for weathering chains. Entries are defined by `WeatheringChainData`.
 * Data files should be placed under `data/<namespace>/chisel/weathering_chains/*.json` when using datagen.
 * Runtime datapacks can register entries under this registry key.
 */
public class ChiselWeatheringRegistry {

    public static final ResourceKey<Registry<WeatheringChainData>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("weathering_chains"));

    public static void bootstrap(BootstrapContext<WeatheringChainData> context) {
        Stream.of("bad_greggy", "bolted", "caution", "crate", "machine", "scaffold", "thermal").forEach(variant -> {
            Block copper = ChiselBlocks.COPPER.getVariant("copper_%s".formatted(variant)).get();
            Block exposed = ChiselBlocks.EXPOSED_COPPER.getVariant("exposed_copper_%s".formatted(variant)).get();
            Block weathered = ChiselBlocks.WEATHERED_COPPER.getVariant("weathered_copper_%s".formatted(variant)).get();
            Block oxidized = ChiselBlocks.OXIDIZED_COPPER.getVariant("oxidized_copper_%s".formatted(variant)).get();

            Map<Identifier, Identifier> waxedMap = new HashMap<>();
            addWaxed(waxedMap, copper, "waxed_copper_%s".formatted(variant), ChiselBlocks.COPPER);
            addWaxed(waxedMap, exposed, "waxed_exposed_copper_%s".formatted(variant), ChiselBlocks.EXPOSED_COPPER);
            addWaxed(waxedMap, weathered, "waxed_weathered_copper_%s".formatted(variant), ChiselBlocks.WEATHERED_COPPER);
            addWaxed(waxedMap, oxidized, "waxed_oxidized_copper_%s".formatted(variant), ChiselBlocks.OXIDIZED_COPPER);

            context.register(create("copper_%s".formatted(variant)), new WeatheringChainData(
                    List.of(
                            BuiltInRegistries.BLOCK.getKey(copper),
                            BuiltInRegistries.BLOCK.getKey(exposed),
                            BuiltInRegistries.BLOCK.getKey(weathered),
                            BuiltInRegistries.BLOCK.getKey(oxidized)
                    ),
                    0.25f,
                    waxedMap
            ));
        });
    }

    private static void addWaxed(Map<Identifier, Identifier> map, Block unwaxed, String waxedName, io.github.chiselteam.chisel.block.util.ChiselFamily family) {
        Block waxed = family.getVariant(waxedName).get();
        map.put(BuiltInRegistries.BLOCK.getKey(unwaxed), BuiltInRegistries.BLOCK.getKey(waxed));
        WeatheringChains.registerWaxable(unwaxed, waxed);
    }

    private static ResourceKey<WeatheringChainData> create(String name) {
        return ResourceKey.create(KEY, Chisel.prefix(name));
    }
}
