package io.github.chiselteam.chisel.content.definition;

import io.github.chiselteam.chisel.api.model.VariantModelHandler;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Function;
import java.util.function.Supplier;

@ApiStatus.Internal
public record VariantDefinition(
        String name,
        Supplier<Block> existingBlock,
        Function<BlockBehaviour.Properties, ? extends Block> blockFactory,
        Supplier<BlockBehaviour.Properties> properties,
        VariantModelHandler modelType,
        boolean generateModel,
        boolean inTab,
        boolean eldritch,
        boolean weathering
) {

    public boolean isExistingBlock() {
        return existingBlock != null;
    }
}
