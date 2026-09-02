package io.github.chiselteam.chisel.event;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.datagen.registry.ChiselSmashingRockRegistry;
import io.github.chiselteam.chisel.guide.HandbookGuide;
import io.github.chiselteam.chisel.projectile.SmashingRockData;
import io.github.chiselteam.chisel.registry.ChiselHandbookGuides;
import io.github.chiselteam.chisel.registry.ChiselVariantFamilies;
import io.github.chiselteam.chisel.weathering.WeatheringChainData;
import io.github.chiselteam.chisel.weathering.WeatheringChains;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class DatapackRegistryEventHandler {

    @SubscribeEvent
    public static void registerRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(ChiselVariantFamilies.KEY, VariantFamily.CODEC, VariantFamily.CODEC);
        event.dataPackRegistry(ChiselSmashingRockRegistry.KEY, SmashingRockData.CODEC, SmashingRockData.CODEC);
        event.dataPackRegistry(WeatheringChains.KEY, WeatheringChainData.CODEC, WeatheringChainData.CODEC);
        event.dataPackRegistry(ChiselHandbookGuides.KEY, HandbookGuide.CODEC, HandbookGuide.CODEC);
    }
}
