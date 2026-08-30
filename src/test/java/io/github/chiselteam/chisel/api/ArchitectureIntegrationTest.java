package io.github.chiselteam.chisel.api;

import io.github.chiselteam.chisel.api.family.registration.ChiselFamilyBuilder;
import io.github.chiselteam.chisel.content.ChiselFamilies;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchitectureIntegrationTest {
    @Test
    void builtInLookupAndEnumerationIncludeCopperAndWaxedCopperOnce() {
        var copper = ChiselFamilies.COPPER.getFamily();
        var waxedCopper = copper.getWaxedFamily();
        var copperVariant = copper.getVariant("copper_caution");
        var waxedVariant = copper.getVariant("waxed_copper_caution");
        var families = ChiselAPI.getFamilies(null);

        assertSame(copper, ChiselAPI.getFamily(copperVariant.getBlock(), null).orElseThrow());
        assertSame(waxedCopper, ChiselAPI.getFamily(waxedVariant.getBlock(), null).orElseThrow());
        assertEquals(1, families.stream().filter(copper::equals).count());
        assertEquals(1, families.stream().filter(waxedCopper::equals).count());
        assertThrows(UnsupportedOperationException.class, families::clear);
    }

    @Test
    void unknownBlockHasNoFamily() {
        assertTrue(ChiselAPI.getFamily(Blocks.COMMAND_BLOCK, null).isEmpty());
    }

    @Test
    void addonBuilderRejectsInvalidDefinitions() {
        var id = Identifier.fromNamespaceAndPath("test", "invalid");
        assertThrows(IllegalArgumentException.class, () -> new ChiselFamilyBuilder(id).build());
        assertThrows(NullPointerException.class, () -> new ChiselFamilyBuilder(id).variant(null));
        assertThrows(IllegalArgumentException.class, () -> new ChiselFamilyBuilder(id)
                .variant("same", () -> Blocks.STONE, io.github.chiselteam.chisel.api.model.ChiselModelHandlers.CUBE_ALL)
                .variant("same", () -> Blocks.COBBLESTONE, io.github.chiselteam.chisel.api.model.ChiselModelHandlers.CUBE_ALL));
    }

    @Test
    void addonRegistrationIsClosedAfterLoadComplete() {
        var exception = assertThrows(IllegalStateException.class, () -> ChiselAPI.registerFamily(
                Identifier.fromNamespaceAndPath("test", "late"),
                family -> family.variant(() -> Blocks.STONE)
        ));
        assertTrue(exception.getMessage().contains("test:late"));
        assertTrue(exception.getMessage().contains("already closed"));
    }
}
