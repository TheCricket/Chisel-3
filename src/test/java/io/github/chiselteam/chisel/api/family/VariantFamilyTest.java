package io.github.chiselteam.chisel.api.family;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import net.minecraft.world.level.block.Blocks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariantFamilyTest {
    private static Variant variant(String name, net.minecraft.world.level.block.Block block, VariantFamily family) {
        return new Variant(name, () -> block, family, ChiselModelHandlers.CUBE_ALL, false);
    }

    @Test
    void collectionsAreImmutable() {
        var family = new VariantFamily("stone");
        family.addVariant(variant("stone", Blocks.STONE, family));
        family.addHiddenVariant(variant("hidden_stone", Blocks.COBBLESTONE, family));

        assertThrows(UnsupportedOperationException.class, () -> family.getVariants().clear());
        assertThrows(UnsupportedOperationException.class, () -> family.getHiddenVariants().clear());
        assertThrows(UnsupportedOperationException.class, () -> family.getAllVariants().clear());
        assertEquals(2, family.getAllVariants().size());
    }

    @Test
    void rootFindsOwnAndWaxedVariants() {
        var root = new VariantFamily("copper");
        var waxed = new VariantFamily("waxed_copper");
        var copper = variant("copper_caution", Blocks.COPPER_BLOCK, root);
        var waxedCopper = variant("waxed_copper_caution", Blocks.WAXED_COPPER_BLOCK, waxed);
        root.addVariant(copper);
        waxed.addVariant(waxedCopper);
        root.setWaxedFamily(waxed);

        assertSame(copper, root.getVariant("copper_caution"));
        assertSame(waxedCopper, root.getVariant("waxed_copper_caution"));
        assertTrue(root.isBlockInFamily(Blocks.COPPER_BLOCK));
    }

    @Test
    void rejectsSelfReferentialWaxedFamily() {
        var family = new VariantFamily("copper");
        assertThrows(IllegalArgumentException.class, () -> family.setWaxedFamily(family));
    }

    @Test
    void hiddenTorchDropsAsStandingTorchWithoutNameInference() {
        var family = new VariantFamily("torch");
        var standing = variant("torch_1", Blocks.TORCH, family);
        var wall = variant("wall_torch_1", Blocks.WALL_TORCH, family).setInTab(false).dropsAs(standing);
        family.addVariant(standing);
        family.addHiddenVariant(wall);

        assertSame(wall, family.getVariant("wall_torch_1"));
        assertSame(standing, wall.getDropsAs());
        assertEquals(1, family.getVariants().size());
        assertEquals(1, family.getHiddenVariants().size());
    }
}
