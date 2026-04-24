package chisel.util;

import chisel.core.variant.VariantFamily;
import chisel.datagen.ChiselVariants;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VariantFinder {

    public static VariantFamily getFamilyForBlock(Block block, RegistryAccess registryAccess) {
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

        // Fallback for client-side or if registry lookup failed
        int fallbackCount = ChiselVariants.getVariantFamilies().size();
        for (VariantFamily family : ChiselVariants.getVariantFamilies()) {
            if (family.isBlockInFamily(block)) {
                return family;
            }
        }

        return null;
    }
}
