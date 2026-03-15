package chisel.datagen;

import chisel.Chisel;
import chisel.registry.ChiselItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ChiselRecipes extends RecipeProvider {

    public ChiselRecipes(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.MISC, ChiselItems.CLOUD_IN_A_BOTTLE)
                .pattern("G G")
                .pattern("GQG")
                .pattern(" G ")
                .define('G', Blocks.GLASS)
                .define('Q', Tags.Items.GEMS_QUARTZ)
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .save(output);

        shaped(RecipeCategory.MISC, ChiselItems.BALL_O_MOSS)
                .pattern("VSV")
                .pattern("SVS")
                .pattern("VSV")
                .define('V', Blocks.VINE)
                .define('S', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_vine", has(Blocks.VINE))
                .save(output);

        upgradeRecipe("has_sugar", Items.SUGAR, ChiselItems.UPGRADE_SPEED);
        upgradeRecipe("has_hopper", Blocks.HOPPER, ChiselItems.UPGRADE_AUTOMATION);
        upgradeRecipe("has_chest", Blocks.CHEST, ChiselItems.UPGRADE_STACK);
        upgradeRecipe("has_anvil", Blocks.ANVIL, ChiselItems.UPGRADE_REVERSION);

        chiselRecipe("has_iron", Tags.Items.INGOTS_IRON, ChiselItems.CHISEL_IRON);
        chiselRecipe("has_diamond", Tags.Items.GEMS_DIAMOND, ChiselItems.CHISEL_DIAMOND);
        chiselRecipe("has_obsidian", Tags.Items.OBSIDIANS, ChiselItems.CHISEL_OBSIDIAN);

        shapeless(RecipeCategory.MISC, new ItemStackTemplate(ChiselItems.SMASHING_ROCK.get(), 16))
                .requires(Items.STONE_PICKAXE)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.STONE_SHOVEL)
                .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE));
    }

    private void upgradeRecipe(String unlockedBy, ItemLike recipeItem, ItemLike upgradeItem) {
        shaped(RecipeCategory.MISC, upgradeItem)
                .pattern("IEI")
                .pattern("EUE")
                .pattern("RRR")
                .define('I', Tags.Items.INGOTS_IRON)
                .define('E', Tags.Items.GEMS_EMERALD)
                .define('R', Tags.Items.DUSTS_REDSTONE)
                .define('U', recipeItem)
                .unlockedBy(unlockedBy, has(recipeItem))
                .save(output);
    }

    private void chiselRecipe(String unlockedBy, TagKey<Item> recipeItem, ItemLike upgradeItem) {
        shaped(RecipeCategory.MISC, upgradeItem)
                .pattern(" Y")
                .pattern("X ")
                .define('X', Tags.Items.RODS_WOODEN)
                .define('Y', recipeItem)
                .unlockedBy(unlockedBy, has(recipeItem))
                .save(output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider provider, @NonNull RecipeOutput recipeOutput) {
            return new ChiselRecipes(provider, recipeOutput);
        }

        @Override
        public @NonNull String getName() {
            return Chisel.MODID;
        }
    }
}
