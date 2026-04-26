package chisel.util;

import chisel.core.variant.VariantFamily;
import chisel.datagen.ChiselVariants;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.block.Block;

public class VariantFinder {

    public static VariantFamily getFamilyForBlock(Block block, RegistryAccess registryAccess) {
        if (block == null) return null;
        Registry<VariantFamily> registry = registryAccess
                .lookup(ChiselVariants.KEY)
                .orElse(null);

        if (registry != null) {
            for (VariantFamily family : registry) {
                if (family.isBlockInFamily(block)) {
                    return family;
                }
            }
        }

        for (VariantFamily family : ChiselVariants.getVariantFamilies()) {
            if (family.isBlockInFamily(block)) {
                return family;
            }
        }

        return null;
    }
}
