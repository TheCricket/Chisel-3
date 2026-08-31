package io.github.chiselteam.chisel.content.definition;

import io.github.chiselteam.chisel.block.NoParticleTorchBlock;
import io.github.chiselteam.chisel.block.NoParticleWallTorchBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VariantFamilyDefinitionBuilderTest {
    private static VariantFamilyDefinitionBuilder builder() {
        return new VariantFamilyDefinitionBuilder("test")
                .properties(() -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    }

    @Test
    void rejectsEmptyFamily() {
        assertThrows(IllegalStateException.class, () -> new VariantFamilyDefinitionBuilder("empty").build());
    }

    @Test
    void rejectsDuplicateVariantName() {
        var builder = builder().addVariant("duplicate").addVariant("duplicate");
        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void rejectsTorchWallNameCollision() {
        var builder = builder()
                .addVariant("wall_torch_1")
                .addTorchVariant("torch_1", NoParticleTorchBlock::new, NoParticleWallTorchBlock::new);
        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void rejectsDuplicateTranslation() {
        var builder = builder().addVariant("variant").translation("variant", "Block", "First");
        assertThrows(IllegalArgumentException.class, () -> builder.translation("variant", "Block", "Second"));
    }

    @Test
    void rejectsTranslationForUnknownVariant() {
        var builder = builder().addVariant("variant").translation("missing", "Block", "Missing");
        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void rejectsWaxedTranslationForNonWeatheringVariant() {
        var builder = builder().addVariant("variant").waxedTranslation("variant", "Block", "Waxed");
        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void definitionCollectionsAreImmutable() {
        var definition = builder().addVariant(Blocks.STONE).build();
        assertThrows(UnsupportedOperationException.class, () -> definition.variants().clear());
        assertThrows(UnsupportedOperationException.class, () -> definition.translations().clear());
    }
}
