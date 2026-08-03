package io.github.chiselteam.chisel.datagen;

import com.google.common.collect.Maps;
import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;

import java.util.Collection;
import java.util.Map;

public class ChiselVariants {

    public static final Map<String, VariantFamily> VARIANT_FAMILIES = Maps.newHashMap();
    public static final ResourceKey<Registry<VariantFamily>> KEY = ResourceKey.createRegistryKey(Chisel.prefix("variant_families"));

    private static void register(ChiselFamily block, BootstrapContext<VariantFamily> context) {
        context.register(block.getKey(), block.getFamily());
        VARIANT_FAMILIES.putIfAbsent(block.getFamily().getFamilyName(), block.getFamily());
        if (block.getFamily().getWaxedFamily() != null) {
            VariantFamily waxed = block.getFamily().getWaxedFamily();
            ResourceKey<VariantFamily> waxedKey = ResourceKey.create(KEY, Chisel.prefix(waxed.getFamilyName()));
            context.register(waxedKey, waxed);
            VARIANT_FAMILIES.putIfAbsent(waxed.getFamilyName(), waxed);
        }
    }

    public static Collection<VariantFamily> getVariantFamilies() {
        return VARIANT_FAMILIES.values();
    }

    public static void bootstrap(BootstrapContext<VariantFamily> context) {
        ChiselBlocks.getBlocks().forEach(block -> register(block, context));
    }
}
