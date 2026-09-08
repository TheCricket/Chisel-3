package io.github.chiselteam.chisel.datagen.tags;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.content.ChiselFamilies;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ChiselItemTags extends ItemTagsProvider {
    public ChiselItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Chisel.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addToTag(ItemTags.create(Chisel.prefix("marble")), ChiselFamilies.MARBLE.getFamily());
        addToTag(ItemTags.create(Chisel.prefix("limestone")), ChiselFamilies.LIMESTONE.getFamily());
    }

    private void addToTag(TagKey<Item> tag, VariantFamily family) {
        family.getVariants().forEach(variant -> {
            if (variant.shouldGenerateModel()) tag(tag).add(variant.getBlock().asItem());
        });
        family.getHiddenVariants().forEach(variant -> {
            if (variant.shouldGenerateModel()) tag(tag).add(variant.getBlock().asItem());
        });
    }
}
