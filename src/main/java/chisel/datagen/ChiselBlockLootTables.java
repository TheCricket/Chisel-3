package chisel.datagen;

import chisel.core.VariantModelType;
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
            if(v.shouldGenerateModel()) {
                if (v.getModelType() == VariantModelType.WALL_TORCH) {
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
        }));
    }

    @Override
    protected @NonNull Iterable<Block> getKnownBlocks() {
        return ChiselBlocks.BLOCKS.getEntries().stream().map(e -> (Block) e.value()).toList();
    }
}