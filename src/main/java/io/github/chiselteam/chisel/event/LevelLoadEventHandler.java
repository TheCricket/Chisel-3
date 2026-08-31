package io.github.chiselteam.chisel.event;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.weathering.WeatheringChains;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.LevelEvent;

@EventBusSubscriber(modid = Chisel.MODID)
public class LevelLoadEventHandler {

    @SubscribeEvent
    public static void levelLoad(LevelEvent.Load event) {
        WeatheringChains.reloadFrom(event.getLevel().registryAccess());
    }
}
