package chisel.menu;

import chisel.core.VariantFamily;
import chisel.registry.ChiselVariants;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ChiselContainer extends SimpleContainer {

    public final ChiselSelectionInventory selectionInventory;
    public final Inventory inventory;

    public final InteractionHand hand;
    public final int chiselSlot;
    public final ItemStack chisel;
    public List<VariantFamily> families = new ArrayList<>();

    public ChiselContainer(Inventory inventory, ChiselSelectionInventory selectionInventory, InteractionHand hand, int chiselSlot, ItemStack chisel) {
        super(61);
        this.inventory = inventory;
        this.selectionInventory = selectionInventory;
        this.hand = hand;
        this.chiselSlot = chiselSlot;
        this.chisel = chisel;

        Registry<VariantFamily> registry = Objects.requireNonNull(Minecraft.getInstance().getConnection()).registryAccess()
                .lookup(ChiselVariants.VARIANT_FAMILY_REGISTRY_KEY)
                .orElseThrow(() -> new IllegalStateException("Variant family registry is not available on the server"));

        for (Map.Entry<ResourceKey<VariantFamily>, VariantFamily> e : registry.entrySet()) {
            this.families.add(e.getValue());
        }
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack itemStack) {
        return super.canPlaceItem(slot, itemStack);
    }
}
