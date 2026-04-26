package chisel.integration;

import chisel.Chisel;
import chisel.core.variant.Variant;
import chisel.core.variant.VariantFamily;
import chisel.registry.ChiselItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotDrawable;
import mezz.jei.api.gui.placement.HorizontalAlignment;
import mezz.jei.api.gui.placement.VerticalAlignment;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.gui.widgets.IScrollGridWidget;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class ChiselRecipeCategory extends AbstractRecipeCategory<ChiselRecipe> {
    public static final IRecipeType<ChiselRecipe> TYPE = IRecipeType.create(Chisel.prefix("carving"), ChiselRecipe.class);

    public ChiselRecipeCategory(IGuiHelper guiHelper) {
        ItemStack chisel = new ItemStack(ChiselItems.CHISEL_IRON.get());
        super(
                TYPE,
                ChiselItems.CHISEL_IRON.get().getName(chisel),
                guiHelper.createDrawableItemStack(chisel),
                160,
                100
        );
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, @NonNull ChiselRecipe recipe, @NonNull IFocusGroup focuses) {
        builder.addText(recipe.family().getAllVariants(recipe.registries()).getFirst().getBlock().getName(), getWidth() - 20, 20)
                .setPosition(0, -5)
                .setColor(0xFF505050)
                .setLineSpacing(0)
                .setTextAlignment(VerticalAlignment.CENTER)
                .setTextAlignment(HorizontalAlignment.CENTER);

        List<IRecipeSlotDrawable> outputSlots = builder.getRecipeSlots().getSlots(RecipeIngredientRole.OUTPUT);
        IScrollGridWidget widget = builder.addScrollGridWidget(outputSlots, 7, 5);
        widget.setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM);
    }

    @Override
    public void setRecipe(@NonNull IRecipeLayoutBuilder builder, @NonNull ChiselRecipe recipe, @NonNull IFocusGroup focuses) {
        VariantFamily family = recipe.family();
        List<Variant> variants = family.getAllVariants(recipe.registries());
        variants.forEach(variant -> builder.addOutputSlot().add(variant.getBlock()));
    }
}
