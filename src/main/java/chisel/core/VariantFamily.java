package chisel.core;

import chisel.block.util.ConnectedTextureBlockItem;
import chisel.registry.ChiselBlocks;
import chisel.registry.ChiselItems;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class VariantFamily {

    public static final Codec<VariantFamily> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("familyName").forGetter(f -> f.familyName),
            Variant.CODEC.listOf().fieldOf("variants").forGetter(f -> f.variants),
            Codec.STRING.optionalFieldOf("recipe_unlocked_by").forGetter(f -> java.util.Optional.ofNullable(f.recipeUnlockedBy))
    ).apply(instance, (prefix, variants, unlockedBy) -> {
        VariantFamily family = new VariantFamily(prefix);
        unlockedBy.ifPresent(u -> family.recipeUnlockedBy = u);
        for (Variant v : variants) {
            v.setFamily(family);
            family.variants.add(v);
        }
        return family;
    }));

    private final List<Variant> variants = Lists.newArrayList();
    private final String familyName;
    private String recipeUnlockedBy;

    public VariantFamily(String familyName) {
        this.familyName = familyName;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public String getFamilyName() {
        return familyName;
    }

    public boolean isBlockInFamily(Block block) {
        return variants.stream().anyMatch(v -> v.getBlock() == block);
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
            }

        public Builder addVariant(Block block) {
                family.getVariants().add(new Variant(block, family));
                return this;
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

            private void registerAndAdd(Variant variant) {
                ChiselItems.ITEMS.registerItem(variant.getName(), p -> new ConnectedTextureBlockItem(variant, p), () -> new Item.Properties().useBlockDescriptionPrefix());
                family.getVariants().add(variant);
            }
        }
}
