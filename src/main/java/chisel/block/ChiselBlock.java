package chisel.block;

import chisel.Chisel;
import chisel.core.VariantFamily;
import chisel.registry.ChiselVariants;
import chisel.util.LangHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class ChiselBlock {

    protected ResourceKey<VariantFamily> KEY;
    protected VariantFamily family;

    public VariantFamily getFamily() {
        ChiselVariants.VARIANT_FAMILIES.putIfAbsent(family.getFamilyName(), family);
        return family;
    }

    protected VariantFamily.Builder builder(String name) {
        return new VariantFamily.Builder(name);
    }

    public ResourceKey<VariantFamily> getKey() {
        if (KEY == null) {
            KEY = ResourceKey.create(ChiselVariants.VARIANT_FAMILY_REGISTRY_KEY, Chisel.prefix(getFamily().getFamilyName()));
        }
        return KEY;
    }

    public java.util.function.Supplier<Block> getVariant(String name) {
        return () -> family.getVariants().stream()
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .map(chisel.core.Variant::getBlock)
                .orElseThrow(() -> new IllegalArgumentException("Variant not found: " + name));
    }

    public void addTranslations(LangHelper lang) {
    }
}
