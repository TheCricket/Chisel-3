package chisel.datagen;

import chisel.Chisel;
import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantFamily;
import chisel.registry.ChiselBlocks;
import com.google.common.collect.Maps;
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
    }

    public static Collection<VariantFamily> getVariantFamilies() {
        return VARIANT_FAMILIES.values();
    }

    public static void bootstrap(BootstrapContext<VariantFamily> context) {
        ChiselBlocks.getBlocks().forEach(block -> register(block, context));
    }
}
