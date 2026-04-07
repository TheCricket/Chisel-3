package chisel.datagen;

import chisel.Chisel;
import chisel.core.projectile.BallOMossData;
import chisel.registry.ChiselBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ChiselBallOMossRegistry {
    public static final ResourceKey<Registry<BallOMossData>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("ball_o_moss"));

    public static void bootstrap(BootstrapContext<BallOMossData> context) {
        add("cobblestone", Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE, context);
        add("cobblestone_slab", Blocks.COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, context);
        add("cobblestone_wall", Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL, context);
        add("cobblestone_stairs", Blocks.COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS, context);
        add("stone_bricks", Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS, context);
        add("stone_brick_slab", Blocks.STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, context);
        add("stone_brick_wall", Blocks.STONE_BRICK_WALL, Blocks.MOSSY_STONE_BRICK_WALL, context);
        add("stone_brick_stairs", Blocks.STONE_BRICK_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS, context);

        ChiselBlocks.TEMPLE.getFamily().getVariants().forEach(variant -> {
            if(variant.shouldGenerateModel())
                add(variant.getName(), variant.getBlock(), ChiselBlocks.MOSSY_TEMPLE.getVariant("mossy_%s".formatted(variant.getName())).get(), context);
        });
        ChiselBlocks.COBBLESTONE.getFamily().getVariants().forEach(variant -> {
            if(variant.shouldGenerateModel())
                add(variant.getName(), variant.getBlock(), ChiselBlocks.MOSSY_COBBLESTONE.getVariant("mossy_%s".formatted(variant.getName())).get(), context);
        });
    }

    private static void add(String name, TagKey<Block> input, Block output, BootstrapContext<BallOMossData> context) {
        context.register(create(name), new BallOMossData(input.location(), BuiltInRegistries.BLOCK.getKey(output)));
    }

    private static void add(String name, Block input, Block output, BootstrapContext<BallOMossData> context) {
        context.register(create(name), new BallOMossData(BuiltInRegistries.BLOCK.getKey(input), BuiltInRegistries.BLOCK.getKey(output)));
    }

    private static ResourceKey<BallOMossData> create(String name) {
        return ResourceKey.create(KEY, Chisel.prefix(name));
    }
}
