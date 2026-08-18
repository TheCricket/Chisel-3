package io.github.chiselteam.chisel.integration.jei;

import io.github.chiselteam.chisel.core.variant.VariantFamily;
import net.minecraft.core.HolderLookup;

public record ChiselRecipe(VariantFamily family, HolderLookup.Provider registries) {
}
