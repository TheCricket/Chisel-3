package io.github.chiselteam.chisel.inventory.slot;

import io.github.chiselteam.chisel.core.variant.VariantFamily;
import io.github.chiselteam.chisel.util.VariantFinder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

public class AutoChiselInputSlot extends Slot {
    private final RegistryAccess REGISTRY_ACCESS;

    public AutoChiselInputSlot(Container container, RegistryAccess registryAccess, int slot, int x, int y) {
        super(container, slot, x, y);
        this.REGISTRY_ACCESS = registryAccess;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if (stack.getItem() instanceof BlockItem block) {
            VariantFamily family = VariantFinder.getFamilyForBlock(block.getBlock(), REGISTRY_ACCESS);
            return family != null;
        }
        return true;
    }
}
