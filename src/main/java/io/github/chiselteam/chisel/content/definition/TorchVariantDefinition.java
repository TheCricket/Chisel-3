package io.github.chiselteam.chisel.content.definition;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Function;
import java.util.function.Supplier;

@ApiStatus.Internal
public record TorchVariantDefinition(String name, Function<Properties, ? extends Block> standingFactory,
                                     Supplier<Properties> standingProperties,
                                     Function<Properties, ? extends Block> wallFactory) {
    public String wallName() {
        return "wall_" + name;
    }
}
