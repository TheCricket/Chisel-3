package chisel.core.variant;

import chisel.block.item.ChiselBlockItem;
import chisel.block.item.TorchBlockItem;
import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselItems;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

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
    private final String familyName;
    private String recipeUnlockedBy;
    private TagKey<Block> tag;

    public VariantFamily(String familyName) {
        this.familyName = familyName;
    }

    public List<Variant> getVariants() {
        return variants;
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

        public Builder addVariant(String name, BlockBehaviour.Properties props, VariantModelType modelType) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, props);
            registerAndAdd(new Variant(name, block, family, modelType));
            return this;
        }

        public Builder addVariant(String name, Function<BlockBehaviour.Properties, ? extends Block> func, Supplier<BlockBehaviour.Properties> properties, VariantModelType modelType) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, func, properties);
            registerAndAdd(new Variant(name, block, family, modelType));
            return this;
        }

        public Builder addTorchVariant(String name, Function<BlockBehaviour.Properties, ? extends Block> func, Supplier<BlockBehaviour.Properties> properties, VariantModelType modelType) {
            DeferredBlock<Block> block = ChiselBlocks.register(name, func, properties);
            Variant v = new Variant(name, block, family, modelType);
            v.isInTab = false;

            if (modelType == VariantModelType.TORCH) {
                ChiselItems.ITEMS.registerItem(v.getName(), p -> new TorchBlockItem(v, block.get(), ChiselBlocks.TORCH.getVariant("wall_torch_%s".formatted(name.substring(6))).get(), p), () -> new Item.Properties().useBlockDescriptionPrefix());
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
    }
}
