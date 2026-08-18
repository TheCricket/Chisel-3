package io.github.chiselteam.chisel.events;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.core.weathering.WeatheringChainData;
import io.github.chiselteam.chisel.datagen.ChiselVariants;
import io.github.chiselteam.chisel.datagen.registry.ChiselBallOMossRegistry;
import io.github.chiselteam.chisel.datagen.registry.ChiselSmashingRockRegistry;
import io.github.chiselteam.chisel.datagen.registry.ChiselWeatheringRegistry;
import io.github.chiselteam.chisel.projectile.BallOMossData;
import io.github.chiselteam.chisel.projectile.SmashingRockData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class DatapackRegistryEventHandler {

    @SubscribeEvent
    public static void registerRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(ChiselVariants.KEY, VariantFamily.CODEC, VariantFamily.CODEC);
        event.dataPackRegistry(ChiselSmashingRockRegistry.KEY, SmashingRockData.CODEC, SmashingRockData.CODEC);
        event.dataPackRegistry(ChiselBallOMossRegistry.KEY, BallOMossData.CODEC, BallOMossData.CODEC);
        event.dataPackRegistry(ChiselWeatheringRegistry.KEY, WeatheringChainData.CODEC, WeatheringChainData.CODEC);
    }
}
