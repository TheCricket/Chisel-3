package chisel.integration;

import chisel.core.variant.VariantFamily;
import net.minecraft.core.HolderLookup;

public record ChiselRecipe(VariantFamily family, HolderLookup.Provider registries) {
}
