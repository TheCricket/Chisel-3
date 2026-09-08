package io.github.chiselteam.chisel.api;

import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.api.family.registration.ChiselFamilyBuilder;
import io.github.chiselteam.chisel.api.family.registration.ChiselFamilyRegistration;
import io.github.chiselteam.chisel.family.AddonFamilyRegistry;
import io.github.chiselteam.chisel.family.VariantFamilyLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Public entry point for querying and registering Chisel variant families.
 */
public final class ChiselAPI {

    private ChiselAPI() {
    }

    public static Optional<VariantFamily> getFamily(Block block, RegistryAccess registryAccess) {
        return VariantFamilyLookup.getFamily(block, registryAccess);
    }

    public static Collection<VariantFamily> getFamilies(RegistryAccess registryAccess) {
        return VariantFamilyLookup.getFamilies(registryAccess);
    }

    /**
     * Queues a family around addon-owned blocks; Chisel does not register those blocks or generate their resources.
     */
    @ApiStatus.Experimental
    public static ChiselFamilyRegistration registerFamily(Identifier familyId, Consumer<ChiselFamilyBuilder> definition) {
        if (definition == null) throw new IllegalArgumentException("Family builder callback cannot be null");
        ChiselFamilyBuilder builder = new ChiselFamilyBuilder(familyId);
        definition.accept(builder);
        return AddonFamilyRegistry.register(builder.build());
    }
}
