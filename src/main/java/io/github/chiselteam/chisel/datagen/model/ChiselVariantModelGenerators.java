package io.github.chiselteam.chisel.datagen.model;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.api.model.VariantModelHandler;
import io.github.chiselteam.chisel.datagen.model.generator.*;
import io.github.chiselteam.chisel.datagen.model.generator.ctm.*;
import io.github.chiselteam.chisel.datagen.model.generator.special.*;
import io.github.chiselteam.chisel.datagen.model.generator.special.lavastone.LavastoneARModelGenerator;
import io.github.chiselteam.chisel.datagen.model.generator.special.lavastone.LavastoneModelGenerator;
import io.github.chiselteam.chisel.datagen.model.generator.special.lavastone.LavastoneMultiblockModelGenerator;
import io.github.chiselteam.chisel.datagen.model.generator.special.lavastone.LavastoneTBSModelGenerator;
import io.github.chiselteam.chisel.datagen.model.generator.special.waterstone.WaterstoneARModelGenerator;
import io.github.chiselteam.chisel.datagen.model.generator.special.waterstone.WaterstoneModelGenerator;
import io.github.chiselteam.chisel.datagen.model.generator.special.waterstone.WaterstoneMultiblockModelGenerator;
import net.minecraft.client.data.models.BlockModelGenerators;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static io.github.chiselteam.chisel.api.model.ChiselModelHandlers.*;

public class ChiselVariantModelGenerators {

    private static final Map<String, Supplier<? extends VariantModelGenerator>> GENERATORS = new HashMap<>();
    private static boolean initialized;

    private ChiselVariantModelGenerators() {
    }

    public static void registerAll() {
        if (initialized) return;
        initialized = true;

        registerGenerator(CUBE_ALL, CubeAllModelGenerator::new);
        registerGenerator(SHADELESS, ShadelessModelGenerator::new);
        registerGenerator(SHADELESS_MULTI_LAYER, ShadelessMultiLayerModelGenerator::new);
        registerGenerator(PILLAR, PillarModelGenerator::new);
        registerGenerator(BOOKSHELF, BookshelfModelGenerator::new);
        registerGenerator(TBS, TopBottomSideModelGenerator::new);

        registerGenerator(CONNECTED, CTMModelGenerator::new);
        registerGenerator(CONNECTED_NO_AO, () -> new CTMModelGenerator(false));
        registerGenerator(CONNECTED_TBS, CTMTBSModelGenerator::new);
        registerGenerator(CTMV, CTMVModelGenerator::new);
        registerGenerator(CTMH, CTMHModelGenerator::new);

        registerGenerator(MULTI_LAYER, MultiLayerModelGenerator::new);
        registerGenerator(MULTI_LAYER_TBS, MultiLayerTBSModelGenerator::new);
        registerGenerator(MULTI_LAYER_TBS_TINTED, MultiLayerTBSTintedModelGenerator::new);

        registerGenerator(MULTI_LAYER_LAVA, LavastoneModelGenerator::new);
        registerGenerator(MULTI_LAYER_LAVA_TOP_BOTTOM_SIDE, LavastoneTBSModelGenerator::new);
        registerGenerator(LAVA_2x2, () -> new LavastoneMultiblockModelGenerator(2));
        registerGenerator(LAVA_3x3, () -> new LavastoneMultiblockModelGenerator(3));
        registerGenerator(LAVA_4x4, () -> new LavastoneMultiblockModelGenerator(4));

        registerGenerator(MULTI_LAYER_WATER, WaterstoneModelGenerator::new);

        registerGenerator(MULTI_LAYER_CONNECTED, () -> new MultiLayerCTMModelGenerator(false));
        registerGenerator(MULTI_LAYER_CONNECTED_TINTED, MultiLayerCTMTintedModelGenerator::new);
        registerGenerator(MULTI_LAYER_CONNECTED_GLOW, () -> new MultiLayerCTMModelGenerator(true));
        registerGenerator(LAYERED_MULTI_LAYER_CONNECTED_GLOW, () -> new MultiLayerCTMModelGenerator(true, true));

        registerGenerator(ANTIBLOCK, AntiblockModelGenerator::new);

        registerGenerator(CARPET, CarpetModelGenerator::new);
        registerGenerator(IRON_BARS, IronBarsModelGenerator::new);
        registerGenerator(GLASS_PANE, GlassPaneModelGenerator::new);
        registerGenerator(GLASS, GlassModelGenerator::new);
        registerGenerator(ICE, IceModelGenerator::new);
        registerGenerator(ICE_2X2, IceModelGenerator::new);
        registerGenerator(ICE_3X3, IceModelGenerator::new);
        registerGenerator(ICE_4X4, IceModelGenerator::new);
        registerGenerator(ICE_AR, IceModelGenerator::new);

        registerGenerator(MOSSY, MossyModelGenerator::new);
        registerGenerator(MOSSY_TOP_BOTTOM_SIDE, MossyTBSModelGenerator::new);

        registerGenerator(PUMPKIN, PumpkinModelGenerator::new);

        registerGenerator(TORCH, () -> new TorchModelGenerator(false));
        registerGenerator(WALL_TORCH, () -> new TorchModelGenerator(true));

        registerGenerator(ROAD_LINES, RoadLineModelGenerator::new);
        registerGenerator(REDSTONE_LAMP, RedstoneLampModelGenerator::new);

        registerGenerator(V4, V4ModelGenerator::new);
        registerGenerator(V9, V9ModelGenerator::new);
        registerGenerator(V16, V16ModelGenerator::new);

        registerGenerator(R4, R4ModelGenerator::new);
        registerGenerator(R9, R9ModelGenerator::new);
        registerGenerator(R16, R16ModelGenerator::new);

        registerGenerator(AR, ARModelGenerator::new);

        registerGenerator(MULTI_LAYER_LAVA_AR, LavastoneARModelGenerator::new);
        registerGenerator(MULTI_LAYER_WATER_AR, WaterstoneARModelGenerator::new);

        registerGenerator(MULTIBLOCK_2X2, Multiblock2x2ModelGenerator::new);
        registerGenerator(MULTIBLOCK_3X3, Multiblock3x3ModelGenerator::new);
        registerGenerator(MULTIBLOCK_4X4, Multiblock4x4ModelGenerator::new);

        registerGenerator(MULTI_LAYER_WATER_2X2, () -> new WaterstoneMultiblockModelGenerator(2));
        registerGenerator(MULTI_LAYER_WATER_3X3, () -> new WaterstoneMultiblockModelGenerator(3));
        registerGenerator(MULTI_LAYER_WATER_4X4, () -> new WaterstoneMultiblockModelGenerator(4));
    }

    public static void registerGenerator(VariantModelHandler handler, Supplier<? extends VariantModelGenerator> generator) {
        var existing = GENERATORS.putIfAbsent(handler.getSerializedName(), generator);
        if (existing != null)
            throw new IllegalStateException("Duplicate model generator: %s".formatted(handler.getSerializedName()));
    }

    public static void generate(Variant variant, BlockModelGenerators blockModels) {
        var handler = variant.getModelHandler();
        var factory = GENERATORS.get(handler.getSerializedName());
        if (factory == null)
            throw new IllegalStateException("No model generator registered for '%s' used by variant '%s'".formatted(handler.getSerializedName(), variant.getName()));

        factory.get().generate(variant, blockModels);
    }
}
