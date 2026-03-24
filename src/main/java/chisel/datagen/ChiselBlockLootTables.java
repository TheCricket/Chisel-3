package chisel.datagen;

import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselVariants;
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
        ChiselVariants.getVariantFamilies().forEach(f -> f.getVariants().forEach(v -> {
            if(v.shouldGenerateModel()) dropSelf(v.getBlock());
        }));
    }

    @Override
    protected @NonNull Iterable<Block> getKnownBlocks() {
        return ChiselBlocks.BLOCKS.getEntries().stream().map(e -> (Block) e.value()).toList();
    }
}