package io.github.chiselteam.chisel.datagen;

import io.github.chiselteam.chisel.core.variant.Variant;
import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.Set;

public class ChiselBlockLootTables extends BlockLootSubProvider {

    public ChiselBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        ChiselVariants.getVariantFamilies().forEach(this::generateFamilyLoot);

        dropSelf(ChiselBlocks.AUTO_CHISEL.get());
        dropSelf(ChiselBlocks.BUILDERS_GUIDE.get());
    }

    private void generateFamilyLoot(VariantFamily f) {
        f.getVariants().forEach(v -> generateLoot(f, v));
        f.getHiddenVariants().forEach(v -> generateLoot(f, v));
        if (f.getWaxedFamily() != null) {
            generateFamilyLoot(f.getWaxedFamily());
        }
    }

    private void generateLoot(VariantFamily f, Variant v) {
        if (v.shouldGenerateModel()) {
            if (v.getModelHandler().isWallTorch()) {
                String torchName = v.getName().replace("wall_torch", "torch");
                f.getVariants().stream()
                        .filter(t -> t.getName().equals(torchName))
                        .findFirst()
                        .ifPresentOrElse(
                                t -> add(v.getBlock(), createSingleItemTable(t.getBlock())),
                                () -> dropSelf(v.getBlock())
                        );
            } else {
                dropSelf(v.getBlock());
            }
        }
    }

    @Override
    protected @NonNull Iterable<Block> getKnownBlocks() {
        return ChiselBlocks.BLOCKS.getEntries().stream().map(e -> (Block) e.value()).toList();
    }
}