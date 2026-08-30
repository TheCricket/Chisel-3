package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class ChiselTags {
    public static final TagKey<Block> WOOD = TagKey.create(Registries.BLOCK, Chisel.prefix("wood"));

    private ChiselTags() {
    }
}
