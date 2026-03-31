package chisel.registry;

import chisel.Chisel;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ChiselBiomeModifiers {

    public static final ResourceKey<BiomeModifier> MARBLE_UPPER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Chisel.prefix("marble_upper"));
    public static final ResourceKey<BiomeModifier> MARBLE_LOWER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Chisel.prefix("marble_lower"));
    public static final ResourceKey<BiomeModifier> LIMESTONE_UPPER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Chisel.prefix("limestone_upper"));
    public static final ResourceKey<BiomeModifier> LIMESTONE_LOWER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Chisel.prefix("limestone_lower"));

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(MARBLE_UPPER, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(ChiselPlacedFeatures.MARBLE_UPPER)), GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(MARBLE_LOWER, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(ChiselPlacedFeatures.MARBLE_LOWER)), GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(LIMESTONE_UPPER, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(ChiselPlacedFeatures.LIMESTONE_LOWER)), GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(LIMESTONE_LOWER, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(ChiselPlacedFeatures.LIMESTONE_UPPER)), GenerationStep.Decoration.UNDERGROUND_DECORATION));
    }
}
