package chisel.registry;

import chisel.Chisel;
import chisel.block.ChiselBlock;
import chisel.core.VariantFamily;
import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;

import java.util.Collection;
import java.util.Map;

public class ChiselVariants {

    public static final Map<String, VariantFamily> VARIANT_FAMILIES = Maps.newHashMap();
    public static final ResourceKey<Registry<VariantFamily>> VARIANT_FAMILY_REGISTRY_KEY = ResourceKey.createRegistryKey(Chisel.prefix("variant_families"));

    private static void register(ChiselBlock block, BootstrapContext<VariantFamily> context) {
        context.register(block.getKey(), block.getFamily());
        VARIANT_FAMILIES.putIfAbsent(block.getFamily().getFamilyName(), block.getFamily());
    }

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(VARIANT_FAMILY_REGISTRY_KEY, bootstrap -> ChiselBlocks.getBlocks().forEach(block -> register(block, bootstrap)));

    public static Collection<VariantFamily> getVariantFamilies() {
        return VARIANT_FAMILIES.values();
    }
}
