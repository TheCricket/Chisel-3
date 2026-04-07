package chisel.datagen;

import chisel.Chisel;
import chisel.core.projectile.SmashingRockData;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ChiselSmashingRockRegistry {
    public static final ResourceKey<Registry<SmashingRockData>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("smashing_rock"));

    public static void bootstrap(BootstrapContext<SmashingRockData> context) {
        add("stone", Blocks.STONE, Blocks.COBBLESTONE, context);
        add("stone_stairs", Blocks.STONE_STAIRS, Blocks.COBBLESTONE_STAIRS, context);
        add("stone_slab", Blocks.STONE_SLAB, Blocks.COBBLESTONE_SLAB, context);
        add("stone_bricks", Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, context);
        add("polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, context);
        add("deepslate_bricks", Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS, context);
        add("deepslate_tiles", Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES, context);
        add("nether_bricks", Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS, context);
        add("gravel", Blocks.GRAVEL, Blocks.SAND, context);
        add("cobblestone", Blocks.COBBLESTONE, Blocks.GRAVEL, context);
    }

    private static void add(String name, TagKey<Block> input, Block output, BootstrapContext<SmashingRockData> context) {
        context.register(create(name), new SmashingRockData(input.location(), BuiltInRegistries.BLOCK.getKey(output)));
    }

    private static void add(String name, Block input, Block output, BootstrapContext<SmashingRockData> context) {
        context.register(create(name), new SmashingRockData(BuiltInRegistries.BLOCK.getKey(input), BuiltInRegistries.BLOCK.getKey(output)));
    }

    private static ResourceKey<SmashingRockData> create(String name) {
        return ResourceKey.create(KEY, Chisel.prefix(name));
    }
}
