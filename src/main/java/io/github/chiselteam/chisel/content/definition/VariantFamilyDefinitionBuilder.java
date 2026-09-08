package io.github.chiselteam.chisel.content.definition;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.api.model.VariantModelHandler;
import io.github.chiselteam.chisel.block.ChiselRotatedPillarBlock;
import io.github.chiselteam.chisel.block.ConnectedTextureBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import org.jetbrains.annotations.ApiStatus;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

@ApiStatus.Internal
public final class VariantFamilyDefinitionBuilder {

    private final String name;
    private final List<VariantDefinition> variants = new ArrayList<>();
    private final List<TorchVariantDefinition> torchVariants = new ArrayList<>();
    private final Map<String, VariantTranslation> translations = new LinkedHashMap<>();
    private TagKey<Block> tag;
    private Supplier<Properties> defaultProperties;

    public VariantFamilyDefinitionBuilder(String name) {
        this.name = requireName(name, "family");
        this.tag = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "chisel/%s".formatted(name)));
    }

    private static String requireName(String value, String kind) {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Invalid " + kind + " name: '" + value + "'");
        return value;
    }

    public VariantFamilyDefinitionBuilder properties(Properties properties) {
        defaultProperties = () -> Objects.requireNonNull(properties, "Default properties cannot be null for family '" + name + "'");
        return this;
    }

    public VariantFamilyDefinitionBuilder properties(Supplier<Properties> properties) {
        defaultProperties = Objects.requireNonNull(properties, "Default properties supplier cannot be null for family '" + name + "'");
        return this;
    }

    public VariantFamilyDefinitionBuilder tag(TagKey<Block> tag) {
        this.tag = Objects.requireNonNull(tag, "Tag cannot be null for family '" + name + "'");
        return this;
    }

    public VariantFamilyDefinitionBuilder addVariant(Block block) {
        Objects.requireNonNull(block, "Existing block cannot be null for family '" + name + "'");
        variants.add(new VariantDefinition(block.getDescriptionId(), () -> block, null, null, ChiselModelHandlers.CUBE_ALL, false, true, false, false));

        return this;
    }

    private static Function<Properties, ? extends Block> defaultBlockFactory(String variantName) {
        return variantName.contains("pillar") ? ChiselRotatedPillarBlock::new : ConnectedTextureBlock::new;
    }

    public VariantFamilyDefinitionBuilder addVariant(String name) {
        return addVariant(name, defaultBlockFactory(name), requireDefaultProperties(), ChiselModelHandlers.CUBE_ALL);
    }

    public VariantFamilyDefinitionBuilder addVariant(String name, VariantModelHandler modelType) {
        return addVariant(name, defaultBlockFactory(name), requireDefaultProperties(), modelType);
    }

    public VariantFamilyDefinitionBuilder addVariant(String name, Properties properties) {
        return addVariant(name, defaultBlockFactory(name), () -> properties, ChiselModelHandlers.CUBE_ALL);
    }

    public VariantFamilyDefinitionBuilder addVariant(String name, Function<Properties, ? extends Block> blockFactory, Supplier<Properties> properties) {
        return addVariant(name, blockFactory, properties, ChiselModelHandlers.CUBE_ALL);
    }

    public VariantFamilyDefinitionBuilder addVariant(String name, Function<Properties, ? extends Block> blockFactory, VariantModelHandler modelType) {
        return addVariant(name, blockFactory, requireDefaultProperties(), modelType);
    }

    public VariantFamilyDefinitionBuilder addVariant(String name, Function<Properties, ? extends Block> blockFactory, Supplier<Properties> properties, VariantModelHandler modelType) {
        variants.add(new VariantDefinition(name, null, blockFactory, properties, modelType, true, true, false, false));
        return this;
    }

    public VariantFamilyDefinitionBuilder addEldritchVariant(String name) {
        return addEldritchVariant(name, ChiselModelHandlers.CUBE_ALL);
    }

    public VariantFamilyDefinitionBuilder addEldritchVariant(String name, VariantModelHandler modelType) {
        return addEldritchVariant(name, requireDefaultProperties(), modelType);
    }

    public VariantFamilyDefinitionBuilder addEldritchVariant(String name, Supplier<Properties> properties, VariantModelHandler modelType) {
        variants.add(new VariantDefinition(name, null, ConnectedTextureBlock::new, properties, modelType, true, true, true, false));
        return this;
    }

    public VariantFamilyDefinitionBuilder addWeatheringVariant(String name) {
        return addWeatheringVariant(name, ChiselModelHandlers.CUBE_ALL);
    }

    public VariantFamilyDefinitionBuilder addWeatheringVariant(String name, VariantModelHandler modelType) {
        return addWeatheringVariant(name, requireDefaultProperties(), modelType);
    }

    public VariantFamilyDefinitionBuilder addWeatheringVariant(String name, Supplier<Properties> properties, VariantModelHandler modelType) {
        variants.add(new VariantDefinition(name, null, null, properties, modelType, true, true, false, true));
        return this;
    }

    public VariantFamilyDefinitionBuilder addTorchVariant(String name, Function<Properties, ? extends Block> standingFactory, Function<Properties, ? extends Block> wallFactory) {
        return addTorchVariant(name, standingFactory, requireDefaultProperties(), wallFactory);
    }

    public VariantFamilyDefinitionBuilder addTorchVariant(String name, Function<Properties, ? extends Block> standingFactory, Supplier<Properties> standingProperties, Function<Properties, ? extends Block> wallFactory) {
        torchVariants.add(new TorchVariantDefinition(name, standingFactory, standingProperties, wallFactory));
        return this;
    }

    public VariantFamilyDefinitionBuilder translation(String variant, String blockName, String description) {
        return addTranslation(variant, blockName, description, false);
    }

    public VariantFamilyDefinitionBuilder waxedTranslation(String variant, String blockName, String description) {
        return addTranslation(variant, blockName, description, true);
    }

    public VariantFamilyDefinition build() {
        validateDefinitions();
        validateTranslations();
        return new VariantFamilyDefinition(name, variants, torchVariants, translations, tag);
    }

    private Supplier<Properties> requireDefaultProperties() {
        if (defaultProperties == null)
            throw new IllegalStateException("No default block properties configured for family '%s'".formatted(name));
        return defaultProperties;
    }

    public VariantFamilyDefinitionBuilder addVariant(String name, Properties properties, VariantModelHandler modelType) {
        return addVariant(name, defaultBlockFactory(name), () -> properties, modelType);
    }

    private void validateTranslations() {
        var names = new HashSet<String>();
        var weatheringNames = new HashSet<String>();

        variants.forEach(variant -> {
            names.add(variant.name());
            if (variant.weathering()) weatheringNames.add(variant.name());
        });
        torchVariants.forEach(variant -> names.add(variant.name()));

        translations.keySet().stream().filter(variant -> !names.contains(variant)).forEach(variant -> {
            throw new IllegalStateException("Translation references unknown variant '%s' in family '%s'".formatted(variant, name));
        });
        translations.forEach((variant, translation) -> {
            if (translation.waxed() && !weatheringNames.contains(variant)) {
                throw new IllegalStateException("Waxed translation references non-weathering variant '%s' in family '%s'".formatted(variant, name));
            }
        });
    }

    private VariantFamilyDefinitionBuilder addTranslation(String variant, String blockName, String description, boolean waxed) {
        variant = requireName(variant, "translation variant");
        Objects.requireNonNull(blockName, "Translation block name cannot be null for family '" + name + "'");
        Objects.requireNonNull(description, "Translation description cannot be null for family '" + name + "'");
        if (translations.putIfAbsent(variant, new VariantTranslation(blockName, description, waxed)) != null) {
            throw new IllegalArgumentException("Duplicate translation for variant '%s' in family '%s'".formatted(variant, name));
        }
        return this;
    }

    private void validateDefinitions() {
        if (variants.isEmpty() && torchVariants.isEmpty()) {
            throw new IllegalStateException("Family '%s' must contain at least one variant".formatted(name));
        }
        var names = new HashSet<String>();
        variants.forEach(variant -> {
            validateVariant(variant);
            addUniqueName(names, variant.name());
        });
        torchVariants.forEach(torch -> {
            Objects.requireNonNull(torch.standingFactory(), "Standing torch factory cannot be null in family '" + name + "'");
            Objects.requireNonNull(torch.standingProperties(), "Standing torch properties cannot be null in family '" + name + "'");
            Objects.requireNonNull(torch.wallFactory(), "Wall torch factory cannot be null in family '" + name + "'");
            addUniqueName(names, torch.name());
            addUniqueName(names, torch.wallName());
        });
    }

    private void validateVariant(VariantDefinition variant) {
        requireName(variant.name(), "variant");
        Objects.requireNonNull(variant.modelType(), "Model handler cannot be null for variant '" + variant.name() + "' in family '" + name + "'");
        if (variant.isExistingBlock()) {
            if (variant.blockFactory() != null || variant.properties() != null || variant.weathering() || variant.generateModel()) {
                throw new IllegalStateException("Existing-block variant '%s' has incompatible registration data in family '%s'".formatted(variant.name(), name));
            }
            return;
        }
        Objects.requireNonNull(variant.properties(), "Block properties cannot be null for variant '" + variant.name() + "' in family '" + name + "'");
        if (!variant.weathering())
            Objects.requireNonNull(variant.blockFactory(), "Block factory cannot be null for variant '" + variant.name() + "' in family '" + name + "'");
    }

    private void addUniqueName(HashSet<String> names, String variantName) {
        variantName = requireName(variantName, "variant");
        if (!names.add(variantName))
            throw new IllegalArgumentException("Duplicate variant name '%s' in family '%s'".formatted(variantName, name));
    }
}
