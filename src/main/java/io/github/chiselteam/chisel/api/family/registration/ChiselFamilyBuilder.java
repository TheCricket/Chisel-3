package io.github.chiselteam.chisel.api.family.registration;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.api.model.VariantModelHandler;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.*;
import java.util.function.Supplier;

/**
 * Describes a family around blocks registered and owned by an addon mod.
 */
@ApiStatus.Experimental
public final class ChiselFamilyBuilder {
    private final Identifier familyId;
    private final List<VariantEntry> variants = new ArrayList<>();
    private final Set<String> logicalNames = new HashSet<>();
    private TagKey<Block> tag;

    @ApiStatus.Internal
    public ChiselFamilyBuilder(Identifier familyId) {
        this.familyId = Objects.requireNonNull(familyId, "Family ID cannot be null");
    }

    public ChiselFamilyBuilder variant(Supplier<? extends Block> block) {
        return variant(null, block, ChiselModelHandlers.CUBE_ALL);
    }

    public ChiselFamilyBuilder variant(Supplier<? extends Block> block, VariantModelHandler modelType) {
        return variant(null, block, modelType);
    }

    public ChiselFamilyBuilder variant(String logicalName, Supplier<? extends Block> block, VariantModelHandler modelType) {
        return add(logicalName, block, modelType, false);
    }

    public ChiselFamilyBuilder hiddenVariant(Supplier<? extends Block> block, VariantModelHandler modelType) {
        return add(null, block, modelType, true);
    }

    public ChiselFamilyBuilder hiddenVariant(String logicalName, Supplier<? extends Block> block, VariantModelHandler modelType) {
        return add(logicalName, block, modelType, true);
    }

    public ChiselFamilyBuilder tag(TagKey<Block> tag) {
        this.tag = Objects.requireNonNull(tag, () -> "Tag cannot be null for family " + familyId);
        return this;
    }

    private ChiselFamilyBuilder add(String logicalName, Supplier<? extends Block> block, VariantModelHandler modelType, boolean hidden) {
        Objects.requireNonNull(block, () -> "Block supplier cannot be null for family " + familyId);
        Objects.requireNonNull(modelType, () -> "Model type cannot be null for family " + familyId);
        if (logicalName != null && (logicalName.isBlank() || !logicalNames.add(logicalName))) {
            throw new IllegalArgumentException("Invalid or duplicate variant name '" + logicalName + "' in family " + familyId);
        }
        variants.add(new VariantEntry(logicalName, block, modelType, hidden));
        return this;
    }

    @ApiStatus.Internal
    public AddonFamilyDefinition build() {
        if (variants.isEmpty())
            throw new IllegalArgumentException("Family " + familyId + " must contain at least one variant");
        return new AddonFamilyDefinition(familyId, List.copyOf(variants), tag);
    }
}
