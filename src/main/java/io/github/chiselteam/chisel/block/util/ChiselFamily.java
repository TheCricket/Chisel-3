package io.github.chiselteam.chisel.block.util;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.core.variant.Variant;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.datagen.ChiselVariants;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ChiselFamily {

    protected ResourceKey<VariantFamily> KEY;
    protected VariantFamily family;

    public VariantFamily getFamily() {
        ChiselVariants.VARIANT_FAMILIES.putIfAbsent(family.getFamilyName(), family);
        if (family.getWaxedFamily() != null) {
            ChiselVariants.VARIANT_FAMILIES.putIfAbsent(family.getWaxedFamily().getFamilyName(), family.getWaxedFamily());
        }
        return family;
    }

    protected VariantFamily.Builder builder(String name) {
        return new VariantFamily.Builder(name);
    }

    public ResourceKey<VariantFamily> getKey() {
        if (KEY == null) {
            KEY = ResourceKey.create(ChiselVariants.KEY, Chisel.prefix(getFamily().getFamilyName()));
        }
        return KEY;
    }

    public Supplier<Block> getVariant(String name) {
        return () -> {
            Variant variant = family.getVariants().stream()
                    .filter(v -> v.getName().equals(name))
                    .findFirst()
                    .orElseGet(() -> family.getHiddenVariants().stream()
                            .filter(v -> v.getName().equals(name))
                            .findFirst()
                            .orElseGet(() -> {
                                if (family.getWaxedFamily() != null) {
                                    return family.getWaxedFamily().getVariants().stream()
                                            .filter(v -> v.getName().equals(name))
                                            .findFirst()
                                            .orElse(null);
                                }
                                return null;
                            }));

            if (variant == null) {
                throw new IllegalArgumentException("Variant not found: " + name + " in family " + family.getFamilyName());
            }
            return variant.getBlock();
        };
    }

    public void addTranslations(LangHelper lang) {
    }

    public void addWaxedTranslation(LangHelper lang, String key, String blockName, String desc) {
        lang.addBlock(getVariant(key), blockName, desc);
        lang.addBlock(getVariant("waxed_%s".formatted(key)), "Waxed %s".formatted(blockName), desc);
    }
}
