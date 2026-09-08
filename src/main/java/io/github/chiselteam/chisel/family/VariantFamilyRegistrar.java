package io.github.chiselteam.chisel.family;

import io.github.chiselteam.chisel.api.family.Variant;
import io.github.chiselteam.chisel.api.family.VariantFamily;
import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.block.WaxedWeatheringBlock;
import io.github.chiselteam.chisel.block.WeatheringBlock;
import io.github.chiselteam.chisel.block.item.ChiselBlockItem;
import io.github.chiselteam.chisel.block.item.TorchBlockItem;
import io.github.chiselteam.chisel.content.ChiselFamily;
import io.github.chiselteam.chisel.content.definition.TorchVariantDefinition;
import io.github.chiselteam.chisel.content.definition.VariantDefinition;
import io.github.chiselteam.chisel.registry.ChiselBlocks;
import io.github.chiselteam.chisel.registry.ChiselItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class VariantFamilyRegistrar {

    private VariantFamilyRegistrar() {
    }

    public static VariantFamily register(ChiselFamily chiselFamily) {
        var definition = chiselFamily.getDefinition();
        var family = new VariantFamily(definition.name());
        family.setTag(definition.tag());

        definition.variants().forEach(variant -> registerVariant(family, variant));
        definition.torchVariants().forEach(torch -> registerTorchVariant(family, torch));

        chiselFamily.setFamily(family);

        return family;
    }

    private static void registerVariant(VariantFamily family, VariantDefinition definition) {
        if (definition.isExistingBlock()) {
            family.addVariant(new Variant(definition.existingBlock().get(), family));
            return;
        }

        if (definition.weathering()) {
            registerWeatheringVariant(family, definition);
            return;
        }

        var block = ChiselBlocks.register(definition.name(), definition.blockFactory(), definition.properties());
        var variant = new Variant(definition.name(), block, family, definition.modelType());

        if (definition.eldritch()) variant.withEldritch();
        variant.setInTab(definition.inTab());

        registerChiselItem(variant);

        if (definition.inTab()) family.addVariant(variant);
        else family.addHiddenVariant(variant);
    }

    private static void registerWeatheringVariant(VariantFamily family, VariantDefinition definition) {
        var block = ChiselBlocks.register(definition.name(), WeatheringBlock::new, definition.properties());
        var variant = new Variant(definition.name(), block, family, definition.modelType());

        if (definition.eldritch()) variant.withEldritch();
        variant.setInTab(definition.inTab());

        registerChiselItem(variant);

        if (definition.inTab()) family.addVariant(variant);
        else family.addHiddenVariant(variant);

        var waxedFamily = getOrCreateWaxedFamily(family);
        var waxedName = "waxed_" + definition.name();

        var waxedBlock = ChiselBlocks.register(waxedName, WaxedWeatheringBlock::new, definition.properties());
        var waxedVariant = new Variant(waxedName, waxedBlock, waxedFamily, definition.modelType());

        if (definition.eldritch()) waxedVariant.withEldritch();
        waxedVariant.setInTab(definition.inTab());

        registerChiselItem(waxedVariant);

        if (definition.inTab()) waxedFamily.addVariant(waxedVariant);
        else waxedFamily.addHiddenVariant(waxedVariant);
    }

    private static VariantFamily getOrCreateWaxedFamily(VariantFamily family) {
        var waxedFamily = family.getWaxedFamily();
        if (waxedFamily != null) return waxedFamily;

        waxedFamily = new VariantFamily("waxed_" + family.getFamilyName());

        if (family.getTag() != null) {
            waxedFamily.setTag(TagKey.create(
                    Registries.BLOCK,
                    Identifier.fromNamespaceAndPath("c", "chisel/%s".formatted(waxedFamily.getFamilyName()))
            ));
        }

        family.setWaxedFamily(waxedFamily);

        return waxedFamily;
    }

    private static void registerTorchVariant(VariantFamily family, TorchVariantDefinition definition) {
        var standingBlock = ChiselBlocks.register(definition.name(), definition.standingFactory(), definition.standingProperties());
        var standingVariant = new Variant(definition.name(), standingBlock, family, ChiselModelHandlers.TORCH);

        var wallBlock = ChiselBlocks.register(definition.wallName(), definition.wallFactory(), () -> createWallTorchProperties(standingBlock.get()));
        var wallVariant = new Variant(definition.wallName(), wallBlock, family, ChiselModelHandlers.WALL_TORCH);

        wallVariant.setInTab(false);
        wallVariant.dropsAs(standingVariant);

        ChiselItems.ITEMS.registerItem(definition.name(), properties -> new TorchBlockItem(standingVariant, standingBlock.get(), wallBlock.get(), properties), () -> new Item.Properties().useBlockDescriptionPrefix());

        family.addVariant(standingVariant);
        family.addHiddenVariant(wallVariant);
    }

    private static Properties createWallTorchProperties(Block standingBlock) {
        return Properties.of()
                .overrideLootTable(standingBlock.getLootTable())
                .overrideDescription(standingBlock.getDescriptionId())
                .noCollision()
                .instabreak()
                .lightLevel(_ -> 14)
                .sound(SoundType.WOOD)
                .pushReaction(PushReaction.DESTROY);
    }

    private static void registerChiselItem(Variant variant) {
        ChiselItems.ITEMS.registerItem(variant.getName(), properties -> new ChiselBlockItem(variant, properties), () -> new Item.Properties().useBlockDescriptionPrefix());
    }
}
