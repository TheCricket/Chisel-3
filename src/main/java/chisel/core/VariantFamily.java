package chisel.core;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Supplier;

public class VariantFamily {

    private final Block base;
    private final List<Variant> variants = Lists.newArrayList();
    private boolean generateModel = true;
    private boolean generateCraftingRecipe = true;
    private boolean generateChiselRecipe = true;
    private final String prefix;
    private String recipeUnlockedBy;

    private VariantFamily(String prefix, Block base) {
        this.prefix = prefix;
        this.base = base;
    }

    public Block getBase() {
        return base;
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

    public static class Builder {
        private final VariantFamily family;

        public Builder(String prefix, Block base) {
            this.family = new VariantFamily(prefix, base);
        }

        public VariantFamily getFamily() {
            return family;
        }

        public Builder addBTSVariant(String name, Supplier<Block> variant) {
            Variant v = new Variant(name, variant, family);
            v.isBTS = true;
            family.variants.add(v);
            return this;
        }

        public Builder addBookshelfVariant(String name, Supplier<Block> variant) {
            Variant v = new Variant(name, variant, family);
            v.isBookshelf = true;
            family.variants.add(v);
            return this;
        }

        public Builder addConnectedVariant(String name, Supplier<Block> variant) {
            Variant v = new Variant(name, variant, family);
            v.isConnected = true;
            family.variants.add(v);
            return this;
        }

        public Builder addPillarVariant(String name, Supplier<Block> variant) {
            Variant v = new Variant(name, variant, family);
            v.isPillar = true;
            family.variants.add(v);
            return this;
        }

        public Builder addVariant(String name, Supplier<Block> variant) {
            family.variants.add(new Variant(name, variant, family));
            return this;
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
