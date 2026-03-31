package chisel.registry;

import chisel.Chisel;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ChiselPlacedFeatures {

    public static final ResourceKey<PlacedFeature> MARBLE_UPPER = create("marble_upper");
    public static final ResourceKey<PlacedFeature> MARBLE_LOWER = create("marble_lower");
    public static final ResourceKey<PlacedFeature> LIMESTONE_UPPER = create("limestone_upper");
    public static final ResourceKey<PlacedFeature> LIMESTONE_LOWER = create("limestone_lower");

    private static ResourceKey<PlacedFeature> create(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Chisel.prefix(name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> marble = configuredFeatures.getOrThrow(ChiselConfiguredFeatures.MARBLE);
        Holder<ConfiguredFeature<?, ?>> limestone = configuredFeatures.getOrThrow(ChiselConfiguredFeatures.LIMESTONE);

        PlacementUtils.register(context, MARBLE_UPPER, marble, rareOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        PlacementUtils.register(context, MARBLE_LOWER, marble, commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        PlacementUtils.register(context, LIMESTONE_UPPER, limestone, rareOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        PlacementUtils.register(context, LIMESTONE_LOWER, limestone, commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier frequencyModifier, PlacementModifier heightRange) {
        return List.of(frequencyModifier, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), heightRange);
    }
}
