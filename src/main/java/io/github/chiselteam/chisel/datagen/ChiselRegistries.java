package io.github.chiselteam.chisel.datagen;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.datagen.registry.ChiselBallOMossRegistry;
import io.github.chiselteam.chisel.datagen.registry.ChiselSmashingRockRegistry;
import io.github.chiselteam.chisel.datagen.registry.ChiselWeatheringRegistry;
import io.github.chiselteam.chisel.registry.ChiselBiomeModifiers;
import io.github.chiselteam.chisel.registry.ChiselConfiguredFeatures;
import io.github.chiselteam.chisel.registry.ChiselPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ChiselRegistries extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ChiselConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ChiselPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ChiselBiomeModifiers::bootstrap)
            .add(ChiselSmashingRockRegistry.KEY, ChiselSmashingRockRegistry::bootstrap)
            .add(ChiselBallOMossRegistry.KEY, ChiselBallOMossRegistry::bootstrap)
            .add(ChiselWeatheringRegistry.KEY, ChiselWeatheringRegistry::bootstrap)
            .add(ChiselVariants.KEY, ChiselVariants::bootstrap);

    public ChiselRegistries(PackOutput output, CompletableFuture<HolderLookup.Provider> future) {
        super(output, future, BUILDER, Set.of("minecraft", Chisel.MODID));
    }
}
