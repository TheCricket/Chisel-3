package chisel.core;
import chisel.datagen.VariantFamilies;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Supplier;

public class VariantFamily {

    public static final Codec<VariantFamily> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("prefix").forGetter(f -> f.prefix),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("base").forGetter(f -> f.base.get()),
            Variant.CODEC.listOf().fieldOf("variants").forGetter(f -> f.variants),
            Codec.BOOL.optionalFieldOf("generate_model", true).forGetter(f -> f.generateModel),
            Codec.BOOL.optionalFieldOf("generate_crafting_recipe", true).forGetter(f -> f.generateCraftingRecipe),
            Codec.BOOL.optionalFieldOf("generate_chisel_recipe", true).forGetter(f -> f.generateChiselRecipe),
            Codec.STRING.optionalFieldOf("recipe_unlocked_by").forGetter(f -> java.util.Optional.ofNullable(f.recipeUnlockedBy))
    ).apply(instance, (prefix, base, variants, genModel, genCrafting, genChisel, unlockedBy) -> {
        VariantFamily family = new VariantFamily(prefix, () -> base);
        family.generateModel = genModel;
        family.generateCraftingRecipe = genCrafting;
        family.generateChiselRecipe = genChisel;
        unlockedBy.ifPresent(u -> family.recipeUnlockedBy = u);
        for (Variant v : variants) {
            v.setFamily(family);
            family.variants.add(v);
        }
        VariantFamilies.registerVariantFamily(family.getBaseSupplier(), family);
        return family;
    }));

    private final Supplier<Block> base;
    private final List<Variant> variants = Lists.newArrayList();
    private boolean generateModel = true;
    private boolean generateCraftingRecipe = true;
    private boolean generateChiselRecipe = true;
    private final String prefix;
    private String recipeUnlockedBy;

    public VariantFamily(String prefix, Supplier<Block> base) {
        this.prefix = prefix;
        this.base = base;
    }

    public Block getBase() {
        return base.get();
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public boolean shouldGenerateModel() {
        return generateModel;
    }

    public boolean shouldGenerateCraftingRecipe() {
        return generateCraftingRecipe;
    }

    public boolean shouldGenerateChiselRecipe() {
        return generateChiselRecipe;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getRecipeUnlockedBy() {
        return recipeUnlockedBy;
    }

    public Supplier<Block> getBaseSupplier() {
        return base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariantFamily that = (VariantFamily) o;
        return prefix.equals(that.prefix);
    }

    @Override
    public int hashCode() {
        return prefix.hashCode();
    }

    public static class Builder {
        private final VariantFamily family;

        public Builder(String prefix, Supplier<Block> base) {
            this.family = new VariantFamily(prefix, base);
        }

        public VariantFamily getFamily() {
            VariantFamilies.registerVariantFamily(family.getBaseSupplier(), family);
            return family;
        }

        public Builder addVariant(String name, Supplier<Block> variant, VariantModelType modelType) {
            Variant v = new Variant(name, variant, family, modelType);
            family.variants.add(v);
            return this;
        }

        public Builder addVariant(String name, Supplier<Block> variant) {
            return addVariant(name, variant, VariantModelType.CUBE_ALL);
        }

        public Builder dontGenerateModel() {
            family.generateModel = false;
            return this;
        }

        public Builder dontGenerateCraftingRecipe() {
            this.family.generateCraftingRecipe = false;
            return this;
        }

        public Builder generateChiselRecipe() {
            this.family.generateChiselRecipe = true;
            return this;
        }

        public Builder recipeUnlockedBy(String recipeUnlockedBy) {
            this.family.recipeUnlockedBy = recipeUnlockedBy;
            return this;
        }
    }
}
