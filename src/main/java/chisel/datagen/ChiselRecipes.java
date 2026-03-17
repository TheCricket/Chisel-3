package chisel.datagen;

import chisel.Chisel;
import chisel.registry.ChiselItems;
import chisel.registry.blocks.ChiselMetalBlocks;
import chisel.registry.blocks.ChiselOtherBlocks;
import chisel.registry.blocks.ChiselStoneBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
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
        // MARK: Blocks
        stoneAround("has_glowstone", Tags.Items.DUSTS_GLOWSTONE, ChiselOtherBlocks.ANTIBLOCK_BLACK, 8);
        stoneAround("has_redstone", Tags.Items.DUSTS_REDSTONE, ChiselMetalBlocks.FUTURA_SCREEN_GRAY, 8);
        stoneAround("has_quartz", Tags.Items.GEMS_QUARTZ, ChiselMetalBlocks.LABORATORY_FLOOR, 8);
        stoneAround("has_iron_ingot", Tags.Items.INGOTS_IRON, ChiselMetalBlocks.TYRIAN_SHINY, 32);
        stoneAround("has_pink_dye", Tags.Items.DYES_PINK, ChiselOtherBlocks.VALENTINES_BLOCK, 4);
        stoneAround("has_coal", ItemTags.COALS, ChiselStoneBlocks.GRIMSTONE_RAW, 8);
        stoneAround("has_coal_block", Tags.Items.STORAGE_BLOCKS_COAL, ChiselMetalBlocks.HEX_PLATING_0, 8);
        stoneAround("has_feather", Tags.Items.FEATHERS, ChiselStoneBlocks.HOLYSTONE_RAW, 8);
        stoneAround("has_lava_bucket", Tags.Items.BUCKETS_LAVA, ChiselStoneBlocks.LAVASTONE_RAW, 8);
        stoneAround("has_water_bucket", Tags.Items.BUCKETS_WATER, ChiselStoneBlocks.WATERSTONE_BRICKS, 8);
        stoneAround("has_blue_dye", Tags.Items.DYES_BLUE, ChiselStoneBlocks.TEMPLE_COBBLE, 8);
        stoneAround("has_sign", ItemTags.SIGNS, ChiselMetalBlocks.WARNING_RADIATION, 4);

        shaped(RecipeCategory.MISC, new ItemStackTemplate(ChiselMetalBlocks.FACTORY_DOTS.asItem(), 32))
                .pattern("SIS")
                .pattern("I I")
                .pattern("SIS")
                .define('S', Tags.Items.STONES)
                .define('I', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_iron_ingots", has(Tags.Items.INGOTS_IRON))
                .save(output);

        shaped(RecipeCategory.MISC, new ItemStackTemplate(ChiselOtherBlocks.PAPERWALL_BOXED.asItem(), 8))
                .pattern("PPP")
                .pattern("PSP")
                .pattern("PPP")
                .define('P', Items.PAPER)
                .define('S', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output);

        shaped(RecipeCategory.MISC, new ItemStackTemplate(ChiselOtherBlocks.ROAD_LINES_WHITE.asItem(), 8))
                .pattern("WRW")
                .pattern("WRW")
                .pattern("WRW")
                .define('W', Tags.Items.DYES_WHITE)
                .define('R', Tags.Items.DUSTS_REDSTONE)
                .unlockedBy("has_white_dye", has(Tags.Items.DYES_WHITE))
                .save(output);

        shaped(RecipeCategory.MISC, new ItemStackTemplate(ChiselMetalBlocks.TECHNICAL_SCAFFOLD.asItem(), 8))
                .pattern("SIS")
                .pattern("ISI")
                .pattern("SIS")
                .define('S', Tags.Items.STONES)
                .define('I', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
                .save(output);

        shaped(RecipeCategory.MISC, new ItemStackTemplate(ChiselStoneBlocks.VOIDSTONE_RAW.asItem(), 8))
                .pattern("OSO")
                .pattern("SES")
                .pattern("OSO")
                .define('S', Tags.Items.STONES)
                .define('E', Items.ENDER_PEARL)
                .define('O', Tags.Items.OBSIDIANS)
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                .save(output);

        shaped(RecipeCategory.MISC, new ItemStackTemplate(ChiselStoneBlocks.ENERGISED_VOIDSTONE_RAW.asItem(), 8))
                .pattern("OSO")
                .pattern("SES")
                .pattern("OSO")
                .define('S', Tags.Items.STONES)
                .define('E', Items.ENDER_EYE)
                .define('O', Tags.Items.OBSIDIANS)
                .unlockedBy("has_ender_eye", has(Items.ENDER_EYE))
                .save(output);

        // MARK: Items
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

    private void stoneAround(String unlockedBy, TagKey<Item> recipeItem, ItemLike outputItem, int count) {
        shaped(RecipeCategory.MISC, new ItemStackTemplate(outputItem.asItem(), count))
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .define('S', Tags.Items.STONES)
                .define('R', recipeItem)
                .unlockedBy(unlockedBy, has(recipeItem))
                .save(output);
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
