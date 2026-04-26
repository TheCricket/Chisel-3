package chisel.integration;

import chisel.Chisel;
import chisel.datagen.ChiselVariants;
import chisel.registry.ChiselItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

import java.util.stream.Collectors;

@JeiPlugin
public class JEICompatibility implements IModPlugin {
    @Override
    public @NonNull Identifier getPluginUid() {
        return Chisel.prefix("jei_plugin");
    }

    @Override
    public void registerCategories(@NonNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ChiselRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NonNull IRecipeRegistration registration) {
        registration.addRecipes(ChiselRecipeCategory.TYPE, ChiselVariants.getVariantFamilies().stream()
                .map(family -> new ChiselRecipe(family, Minecraft.getInstance().level.registryAccess()))
                .collect(Collectors.toList()));
    }

    @Override
    public void registerRecipeCatalysts(@NonNull IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(ChiselRecipeCategory.TYPE, new ItemStack(ChiselItems.CHISEL_IRON.get()));
        registration.addCraftingStation(ChiselRecipeCategory.TYPE, new ItemStack(ChiselItems.CHISEL_DIAMOND.get()));
        registration.addCraftingStation(ChiselRecipeCategory.TYPE, new ItemStack(ChiselItems.CHISEL_OBSIDIAN.get()));
    }
}
