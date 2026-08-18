package io.github.chiselteam.chisel.core.variant;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.chiselteam.chisel.block.item.ChiselBlockItem;
import io.github.chiselteam.chisel.block.item.TorchBlockItem;
import io.github.chiselteam.chisel.block.util.WaxedWeatheringBlock;
import io.github.chiselteam.chisel.block.util.WeatheringBlock;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import io.github.chiselteam.chisel.registry.ChiselItems;
import io.github.chiselteam.chisel.registry.ChiselModelHandlers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jspecify.annotations.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.TORCH;

public class VariantFamily {

    public static final Codec<VariantFamily> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("family_name").forGetter(f -> f.familyName),
            Variant.CODEC.listOf().fieldOf("variants").forGetter(f -> f.variants),
            Codec.STRING.optionalFieldOf("recipe_unlocked_by").forGetter(f -> Optional.ofNullable(f.recipeUnlockedBy)),
            TagKey.codec(Registries.BLOCK).optionalFieldOf("tag").forGetter(f -> Optional.ofNullable(f.tag))
    ).apply(instance, (familyName, variants, unlockedBy, tag) -> {
        VariantFamily family = new VariantFamily(familyName);
        unlockedBy.ifPresent(u -> family.recipeUnlockedBy = u);
        tag.ifPresent(t -> family.tag = t);
        for (Variant v : variants) {
            if (v != null) {
                v.setFamily(family);
                family.variants.add(v);
            }
        }
        return family;
    }));

    private final List<Variant> variants = Lists.newArrayList();
    private final List<Variant> hiddenVariants = Lists.newArrayList();
    private VariantFamily waxedFamily;
    private final String familyName;
    private String recipeUnlockedBy;
    private TagKey<Block> tag;

    public VariantFamily(String familyName) {
        this.familyName = familyName;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public List<Variant> getHiddenVariants() {
        return hiddenVariants;
    }

    public @Nullable VariantFamily getWaxedFamily() {
        return waxedFamily;
    }

    public void setWaxedFamily(VariantFamily waxedFamily) {
        this.waxedFamily = waxedFamily;
    }

    public List<Variant> getAllVariants(HolderLookup.Provider registries) {
        Set<Block> blocks = new LinkedHashSet<>();
        List<Variant> allVariants = new ArrayList<>();

        for (Variant v : variants) {
            Block b = v.getBlock();
            if (b != null && blocks.add(b)) {
                allVariants.add(v);
            }
        }

        if (tag != null) {
            Optional<HolderSet.Named<Block>> blockTag = registries.lookupOrThrow(Registries.BLOCK).get(tag);
            if(blockTag.isPresent()) {
                Stream<Holder<Block>> blocksInTag = blockTag.get().stream();
                blocksInTag.forEach(b -> {
                    if(blocks.add(b.value())) {
                        allVariants.add(new Variant(b.value(), this));
                    }
                });
            }
        }

        return allVariants;
    }

    public TagKey<Block> getTag() {
        return tag;
    }

    public String getFamilyName() {
        return familyName;
    }

    public boolean isBlockInFamily(Block block) {
        if (tag != null && block.defaultBlockState().is(tag)) {
            return true;
        }
        for (Variant v : variants) {
            if (v != null && v.getBlock() != null) {
                if (v.getBlock() == block) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariantFamily that = (VariantFamily) o;
        return familyName.equals(that.familyName);
    }

    @Override
    public int hashCode() {
        return familyName.hashCode();
    }

    public record Builder(VariantFamily family) {
        public Builder(String family) {
            this(new VariantFamily(family));
            setTag(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "chisel/%s".formatted(family))));
        }

        public Builder addVariant(Block block) {
            family.getVariants().add(new Variant(block, family));
            return this;
        }

        public void setTag(TagKey<Block> tag) {
            family.tag = tag;
        }

        public Builder addVariant(String name, BlockBehaviour.Properties props) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, props);
            registerAndAdd(new Variant(name, block, family));
            return this;
        }

        public Builder addVariant(String name, Function<BlockBehaviour.Properties, ? extends Block> func, Supplier<BlockBehaviour.Properties> properties) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, func, properties);
            registerAndAdd(new Variant(name, block, family));
            return this;
        }

        public Builder addVariant(String name, BlockBehaviour.Properties props, VariantModelHandler modelType) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, props);
            registerAndAdd(new Variant(name, block, family, modelType));
            return this;
        }

        public Builder addWeatheringVariant(String name, BlockBehaviour.Properties props, VariantModelHandler modelType) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, WeatheringBlock::new, () -> props);
            Variant v = new Variant(name, block, family, modelType);
            registerAndAdd(v);

            if (family.getWaxedFamily() == null) {
                VariantFamily waxed = new VariantFamily("waxed_" + family.getFamilyName());
                if (family.getTag() != null) {
                    waxed.tag = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "chisel/%s".formatted(waxed.getFamilyName())));
                }
                family.setWaxedFamily(waxed);
            }

            String waxedName = "waxed_" + name;
            DeferredBlock<Block> waxedBlock = ChiselBlocks.register(waxedName, WaxedWeatheringBlock::new, () -> props);
            Variant waxedVariant = new Variant(waxedName, waxedBlock, family.getWaxedFamily(), modelType);
            ChiselItems.ITEMS.registerItem(waxedVariant.getName(), p -> new ChiselBlockItem(waxedVariant, p), () -> new Item.Properties().useBlockDescriptionPrefix());
            family.getWaxedFamily().getVariants().add(waxedVariant);

            return this;
        }

        /**
         * Adds a variant whose generated model carries the eldritch UV-perturbation effect
         * on top of the given model handler.
         */
        public Builder addEldritchVariant(String name, BlockBehaviour.Properties props) {
            return addEldritchVariant(name, props, ChiselModelHandlers.CUBE_ALL);
        }

        public Builder addEldritchVariant(String name, BlockBehaviour.Properties props, VariantModelHandler modelType) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, props);
            Variant v = new Variant(name, block, family, modelType);
            v.withEldritch();
            registerAndAdd(v);
            return this;
        }

        public Builder addVariant(String name, Function<BlockBehaviour.Properties, ? extends Block> func, Supplier<BlockBehaviour.Properties> properties, VariantModelHandler modelType) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, func, properties);
            registerAndAdd(new Variant(name, block, family, modelType));
            return this;
        }

        public Builder addTorchVariant(String name, Function<BlockBehaviour.Properties, ? extends Block> func, Supplier<BlockBehaviour.Properties> properties, VariantModelHandler modelType) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, func, properties);
            Variant v = new Variant(name, block, family, modelType);

            if (modelType == TORCH) {
                ChiselItems.ITEMS.registerItem(v.getName(), p -> new TorchBlockItem(v, block.get(), ChiselBlocks.TORCH.getVariant("wall_torch_%s".formatted(name.substring(6))).get(), p), () -> new Item.Properties().useBlockDescriptionPrefix());
            } else {
                v.isInTab = false;
            }

            family.getVariants().add(v);

            return this;
        }

        public VariantFamily family() {
            return family;
        }

        private void registerAndAdd(Variant variant) {
            ChiselItems.ITEMS.registerItem(variant.getName(), p -> new ChiselBlockItem(variant, p), () -> new Item.Properties().useBlockDescriptionPrefix());
            family.getVariants().add(variant);
        }

        private void registerAndAddHidden(Variant variant) {
            ChiselItems.ITEMS.registerItem(variant.getName(), p -> new ChiselBlockItem(variant, p), () -> new Item.Properties().useBlockDescriptionPrefix());
            family.getHiddenVariants().add(variant);
        }
    }
}
