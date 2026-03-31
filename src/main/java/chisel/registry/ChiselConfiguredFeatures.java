package chisel.registry;

import chisel.Chisel;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class ChiselConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MARBLE = create("marble_configured_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMESTONE = create("limestone_configured_feature");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, MARBLE, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new BlockMatchTest(Blocks.STONE), ChiselBlocks.MARBLE.getVariant("marble_raw").get().defaultBlockState())), 32));
        FeatureUtils.register(context, LIMESTONE, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new BlockMatchTest(Blocks.STONE), ChiselBlocks.LIMESTONE.getVariant("limestone_raw").get().defaultBlockState())), 32));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> create(final String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Chisel.prefix(name));
    }
}
