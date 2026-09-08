package io.github.chiselteam.chisel.content.definition;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.Map;

@ApiStatus.Internal
public record VariantFamilyDefinition(String name, List<VariantDefinition> variants,
                                      List<TorchVariantDefinition> torchVariants,
                                      Map<String, VariantTranslation> translations, TagKey<Block> tag) {
    public VariantFamilyDefinition {
        variants = List.copyOf(variants);
        torchVariants = List.copyOf(torchVariants);
        translations = Map.copyOf(translations);
    }
}
