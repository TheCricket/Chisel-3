package io.github.chiselteam.chisel.api.family.registration;

import io.github.chiselteam.chisel.api.model.VariantModelHandler;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Supplier;

@ApiStatus.Internal
public record VariantEntry(String logicalName, Supplier<? extends Block> block, VariantModelHandler modelType,
                           boolean hidden) {
}