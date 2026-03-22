package chisel.datagen;

import chisel.Chisel;
import chisel.core.VariantFamily;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ChiselBlockTags extends BlockTagsProvider {
    public static final TagKey<Block> WOOD = TagKey.create(Registries.BLOCK, Chisel.prefix("wood"));

    public ChiselBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Chisel.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        addToWood(VariantFamilies.ACACIA);
        addToWood(VariantFamilies.BIRCH);
        addToWood(VariantFamilies.DARK_OAK);
        addToWood(VariantFamilies.JUNGLE);
        addToWood(VariantFamilies.OAK);
        addToWood(VariantFamilies.SPRUCE);
        addToWood(VariantFamilies.BOOKSHELF);
    }

    private void addToWood(VariantFamily family) {
        family.getVariants().forEach(variant -> tag(WOOD).add(variant.getBlock().get()));
    }
}
