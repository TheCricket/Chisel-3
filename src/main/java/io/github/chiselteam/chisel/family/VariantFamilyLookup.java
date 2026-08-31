package io.github.chiselteam.chisel.family;

import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.registry.ChiselVariantFamilies;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

@ApiStatus.Internal
public final class VariantFamilyLookup {
    private VariantFamilyLookup() {
    }

    public static Optional<VariantFamily> getFamily(Block block, RegistryAccess registryAccess) {
        if (block == null) return Optional.empty();
        return getFamilies(registryAccess).stream().filter(family -> family.isBlockInFamily(block)).findFirst();
    }

    public static VariantFamily getFamilyForBlock(Block block, RegistryAccess registryAccess) {
        return getFamily(block, registryAccess).orElse(null);
    }

    public static Collection<VariantFamily> getFamilies(RegistryAccess registryAccess) {
        LinkedHashSet<VariantFamily> families = new LinkedHashSet<>();
        if (registryAccess != null)
            registryAccess.lookup(ChiselVariantFamilies.KEY).ifPresent(registry -> registry.forEach(families::add));
        families.addAll(ChiselVariantFamilies.getVariantFamilies());
        families.addAll(AddonFamilyRegistry.getFamilies());
        return List.copyOf(families);
    }
}
