package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.Chisel;
import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.block.util.ChiselStainedGlassPaneBlock;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.StringUtils;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.GLASS_PANE;

public class StainedGlassPaneFamily extends ChiselFamily {

    private final DyeColor color;

    public DyeColor getColor() {
        return color;
    }

    public StainedGlassPaneFamily(BlockBehaviour.Properties props, DyeColor color, Block vanilla) {
        this.color = color;

        family = builder("stained_glass_pane_%s".formatted(color))
                .addVariant(vanilla)
                .addVariant("stained_glass_pane_%s_borderless".formatted(color), (p) -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_borderless".formatted(color))))), () -> props, GLASS_PANE)
                .addVariant("stained_glass_pane_%s_bubble".formatted(color), (p) -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_bubble".formatted(color))))), () -> props, GLASS_PANE)
                .addVariant("stained_glass_pane_%s_panel".formatted(color), (p) -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_panel".formatted(color))))), () -> props, GLASS_PANE)
                .addVariant("stained_glass_pane_%s_quad".formatted(color), (p) -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_quad".formatted(color))))), () -> props, GLASS_PANE)
                .addVariant("stained_glass_pane_%s_fancy".formatted(color), (p) -> new ChiselStainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_fancy".formatted(color))))), () -> props, GLASS_PANE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        String colorName = StringUtils.capitalize(color.getName().replace("_", " "));
        lang.addBlock(getVariant("stained_glass_pane_%s_borderless".formatted(color)), "%s Stained Glass Pane".formatted(colorName), "%s Borderless Glass Pane".formatted(colorName));
        lang.addBlock(getVariant("stained_glass_pane_%s_bubble".formatted(color)), "%s Stained Glass Pane".formatted(colorName), "%s Bubble Glass Pane".formatted(colorName));
        lang.addBlock(getVariant("stained_glass_pane_%s_panel".formatted(color)), "%s Stained Glass Pane".formatted(colorName), "%s Glass Panel Pane".formatted(colorName));
        lang.addBlock(getVariant("stained_glass_pane_%s_quad".formatted(color)), "%s Stained Glass Pane".formatted(colorName), "%s Glass Quad Pane".formatted(colorName));
        lang.addBlock(getVariant("stained_glass_pane_%s_fancy".formatted(color)), "%s Stained Glass Pane".formatted(colorName), "%s Fancy Glass Panel Pane".formatted(colorName));
    }
}