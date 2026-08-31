package io.github.chiselteam.chisel.api.family.registration;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.Internal
public record AddonFamilyDefinition(Identifier id, List<VariantEntry> variants, TagKey<Block> tag) {
}