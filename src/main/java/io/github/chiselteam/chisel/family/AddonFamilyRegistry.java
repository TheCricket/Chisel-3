package io.github.chiselteam.chisel.family;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.api.family.registration.ChiselFamilyBuilder.AddonFamilyDefinition;
import io.github.chiselteam.chisel.api.family.registration.ChiselFamilyRegistration;
import io.github.chiselteam.chisel.registry.ChiselVariantFamilies;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.*;

@ApiStatus.Internal
public final class AddonFamilyRegistry {
    private static final Map<Identifier, AddonFamilyDefinition> DEFINITIONS = new LinkedHashMap<>();
    private static List<VariantFamily> families = List.of();
    private static boolean closed;

    private AddonFamilyRegistry() {
    }

    public static synchronized ChiselFamilyRegistration register(AddonFamilyDefinition definition) {
        Objects.requireNonNull(definition, "Addon family definition cannot be null");
        Identifier id = definition.id();
        Objects.requireNonNull(id, "Addon family ID cannot be null");
        if (closed)
            throw new IllegalStateException("Cannot register Chisel family '" + id + "': addon family registration has already closed");
        if (DEFINITIONS.putIfAbsent(id, definition) != null)
            throw new IllegalArgumentException("Duplicate Chisel family ID '" + id + "'");
        return new ChiselFamilyRegistration(id);
    }

    public static synchronized void freeze() {
        if (closed) return;
        closed = true;
        Map<Block, Identifier> memberships = new IdentityHashMap<>();
        for (VariantFamily family : ChiselVariantFamilies.getVariantFamilies()) {
            for (Variant variant : family.getAllVariants()) {
                memberships.put(variant.getBlock(), Identifier.fromNamespaceAndPath("chisel", family.getFamilyName()));
            }
        }

        List<VariantFamily> resolved = new ArrayList<>();
        for (AddonFamilyDefinition definition : DEFINITIONS.values()) {
            VariantFamily family = new VariantFamily(definition.id().toString());
            family.setTag(definition.tag());
            Map<Block, String> ownBlocks = new IdentityHashMap<>();
            Set<String> names = new HashSet<>();
            for (var entry : definition.variants()) {
                Block block;
                try {
                    block = entry.block().get();
                } catch (RuntimeException exception) {
                    throw new IllegalStateException("Block supplier failed for family " + definition.id(), exception);
                }
                if (block == null)
                    throw new IllegalStateException("Block supplier returned null for family " + definition.id());
                Identifier blockId = BuiltInRegistries.BLOCK.getKey(block);
                String name = entry.logicalName() != null ? entry.logicalName() : blockId.getPath();
                if (!names.add(name))
                    throw new IllegalArgumentException("Duplicate variant name '" + name + "' in family " + definition.id());
                if (ownBlocks.put(block, name) != null) {
                    throw new IllegalArgumentException("Block " + blockId + " appears more than once in family " + definition.id());
                }
                Identifier priorFamily = memberships.putIfAbsent(block, definition.id());
                if (priorFamily != null) {
                    throw new IllegalArgumentException("Block " + blockId + " in family " + definition.id() + " already belongs to family " + priorFamily);
                }
                Variant variant = new Variant(name, () -> block, family, entry.modelType(), false);
                if (entry.hidden()) family.addHiddenVariant(variant);
                else family.addVariant(variant);
            }
            resolved.add(family);
        }
        families = List.copyOf(resolved);
    }

    public static Collection<VariantFamily> getFamilies() {
        return families;
    }
}
