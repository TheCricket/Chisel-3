package io.github.chiselteam.chisel.weathering;

import io.github.chiselteam.chisel.Chisel;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class WeatheringChains {

    public static final ResourceKey<Registry<WeatheringChainData>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("weathering_chains"));

    private static final Logger LOGGER = LoggerFactory.getLogger(Chisel.MODID);

    private static final Map<Block, Block> NEXT = new ConcurrentHashMap<>();
    private static final Map<Block, Block> PREV = new ConcurrentHashMap<>();
    private static final Map<Block, Float> RATE = new ConcurrentHashMap<>();
    private static final Map<Block, Integer> AGE = new ConcurrentHashMap<>();
    private static final Map<Block, Block> WAXED = new ConcurrentHashMap<>();
    private static final Map<Block, Block> UNWAXED = new ConcurrentHashMap<>();

    private WeatheringChains() {
    }

    public static void reloadFrom(RegistryAccess access) {
        NEXT.clear();
        PREV.clear();
        RATE.clear();
        AGE.clear();
        WAXED.clear();
        UNWAXED.clear();

        Registry<WeatheringChainData> registry = access.lookup(KEY).orElse(null);
        if (registry == null) {
            LOGGER.debug("Weathering registry not present; maps cleared");
            return;
        }

        int chains = 0;
        for (WeatheringChainData chain : registry) {
            List<Block> blocks = new ArrayList<>();
            for (var id : chain.blocks()) {
                Block b = BuiltInRegistries.BLOCK.getOptional(id).orElse(null);
                if (b == null) {
                    LOGGER.warn("Unknown block id in weathering chain: {}", id);
                    blocks.clear();
                    break;
                }
                blocks.add(b);
            }
            if (blocks.size() >= 2) {
                registerChain(blocks, chain.agingRate());
                chains++;
            }

            for (var entry : chain.waxedMap().entrySet()) {
                Block unwaxed = BuiltInRegistries.BLOCK.getOptional(entry.getKey()).orElse(null);
                Block waxed = BuiltInRegistries.BLOCK.getOptional(entry.getValue()).orElse(null);
                if (unwaxed != null && waxed != null) {
                    registerWaxable(unwaxed, waxed);
                } else {
                    LOGGER.warn("Unknown block id in waxed mapping: {} -> {}", entry.getKey(), entry.getValue());
                }
            }
        }
        LOGGER.info("Loaded {} weathering mappings and {} waxed mappings across {} chains", NEXT.size(), WAXED.size(), chains);
    }

    public static void registerChain(List<Block> blocks, float agingRate) {
        if (blocks == null || blocks.size() < 2) return;
        for (int i = 0; i < blocks.size(); i++) {
            Block current = blocks.get(i);
            RATE.put(current, agingRate);
            AGE.put(current, i);
            if (i < blocks.size() - 1) {
                Block next = blocks.get(i + 1);
                NEXT.put(current, next);
                PREV.put(next, current);
            }
        }
    }

    public static Optional<Block> getNext(Block b) {
        return Optional.ofNullable(NEXT.get(b));
    }

    public static Optional<Block> getPrev(Block b) {
        return Optional.ofNullable(PREV.get(b));
    }

    public static float getRate(Block b, float def) {
        return RATE.getOrDefault(b, def);
    }

    public static Optional<Integer> getAge(Block b) {
        return Optional.ofNullable(AGE.get(b));
    }

    public static Optional<Block> getWaxed(Block b) {
        return Optional.ofNullable(WAXED.get(b));
    }

    public static Optional<Block> getUnwaxed(Block b) {
        return Optional.ofNullable(UNWAXED.get(b));
    }

    public static void registerWaxable(Block unwaxed, Block waxed) {
        WAXED.put(unwaxed, waxed);
        UNWAXED.put(waxed, unwaxed);
    }

    public static boolean participates(Block b) {
        return NEXT.containsKey(b) || PREV.containsKey(b);
    }
}
