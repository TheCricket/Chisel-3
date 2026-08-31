package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.content.ChiselFamilies;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public class ChiselFluidInteractions {

    public static void init() {
        addBlockInteraction(ChiselFamilies.MARBLE.getVariant("marble_raw"));
        addBlockInteraction(ChiselFamilies.LIMESTONE.getVariant("limestone_raw"));
    }

    private static void addBlockInteraction(Supplier<Block> block) {
        FluidInteractionRegistry.addInteraction(
                Fluids.LAVA.getFluidType(),
                new FluidInteractionRegistry.InteractionInformation(
                        (level, _, pos, _) -> {
                            var check = LiquidBlock.POSSIBLE_FLOW_DIRECTIONS.stream().iterator();
                            AtomicBoolean waterCheck = new AtomicBoolean(false);
                            check.forEachRemaining(direction -> waterCheck.set(waterCheck.get() || level.getFluidState(pos.relative(direction)).is(FluidTags.WATER)));
                            return waterCheck.get() && level.getBlockState(pos.below()).is(block.get());
                        },
                        (level, _, relativePos, _) -> {
                            level.setBlockAndUpdate(relativePos, block.get().defaultBlockState());
                            level.levelEvent(LevelEvent.LAVA_FIZZ, relativePos, 0);
                        }
                )
        );
    }
}
