package io.github.chiselteam.chisel.registry;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.content.ChiselFamilies;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;

import java.util.List;
import java.util.stream.Stream;

@org.jetbrains.annotations.ApiStatus.Internal
public class ChiselVariantFamilies {

    public static final ResourceKey<Registry<VariantFamily>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("variant_families"));

    private ChiselVariantFamilies() {
    }

    public static List<VariantFamily> getRootFamilies() {
        return ChiselFamilies.getFamilies().stream().map(ChiselFamily::getFamily).toList();
    }

    public static List<VariantFamily> getVariantFamilies() {
        return getRootFamilies().stream().flatMap(ChiselVariantFamilies::withWaxedFamily).distinct().toList();
    }

    public static ResourceKey<VariantFamily> getKey(VariantFamily family) {
        return ResourceKey.create(KEY, Chisel.prefix(family.getFamilyName()));
    }

    public static void bootstrap(BootstrapContext<VariantFamily> context) {
        ChiselFamilies.getFamilies().forEach(family -> register(context, family.getFamily()));
    }

    public static void register(BootstrapContext<VariantFamily> context, VariantFamily family) {
        context.register(getKey(family), family);
        if (family.getWaxedFamily() != null) context.register(getKey(family.getWaxedFamily()), family.getWaxedFamily());
    }

    private static Stream<VariantFamily> withWaxedFamily(VariantFamily family) {
        return family.getWaxedFamily() == null ? Stream.of(family) : Stream.of(family, family.getWaxedFamily());
    }
}
