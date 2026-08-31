package io.github.chiselteam.chisel.datagen;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import io.github.chiselteam.chisel.registry.ChiselVariantFamilies;
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
        ChiselVariantFamilies.getRootFamilies().forEach(this::generateFamilyLoot);

        dropSelf(ChiselBlocks.AUTO_CHISEL.get());
        dropSelf(ChiselBlocks.BUILDERS_GUIDE.get());
    }

    private void generateFamilyLoot(VariantFamily f) {
        f.getVariants().forEach(this::generateLoot);
        f.getHiddenVariants().forEach(this::generateLoot);
        if (f.getWaxedFamily() != null) generateFamilyLoot(f.getWaxedFamily());
    }

    private void generateLoot(Variant v) {
        if (!v.shouldGenerateModel()) return;
        Variant dropsAs = v.getDropsAs();

        if (dropsAs != null) {
            add(v.getBlock(), createSingleItemTable(dropsAs.getBlock()));
            return;
        }

        dropSelf(v.getBlock());
    }

    @Override
    protected @NonNull Iterable<Block> getKnownBlocks() {
        return ChiselBlocks.BLOCKS.getEntries().stream().map(e -> (Block) e.value()).toList();
    }
}