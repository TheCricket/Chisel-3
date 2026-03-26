package chisel.util;

import chisel.core.VariantFamily;
import chisel.registry.ChiselVariants;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VariantFinder {

    private static final List<VariantFamily> families = new ArrayList<>();

    public static VariantFamily getFamilyForBlock(Block block, RegistryAccess registryAccess) {
        Registry<VariantFamily> registry = Objects.requireNonNull(registryAccess
                .lookup(ChiselVariants.VARIANT_FAMILY_REGISTRY_KEY)
                .orElseThrow(() -> new IllegalStateException("Variant family registry is not available on the server"))
        );

        for (Map.Entry<ResourceKey<VariantFamily>, VariantFamily> e : registry.entrySet()) {
            families.add(e.getValue());
        }

        for (VariantFamily family : families) {
            if(family.isBlockInFamily(block)) {
                return family;
            }
        }

        return null;
    }
}
