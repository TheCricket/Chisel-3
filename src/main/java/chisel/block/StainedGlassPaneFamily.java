package chisel.block;

import chisel.Chisel;
import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.StringUtils;

public class StainedGlassPaneFamily extends ChiselBlock {

    private final DyeColor color;

    public StainedGlassPaneFamily(BlockBehaviour.Properties props, DyeColor color, Block vanilla) {
        this.color = color;

        family = builder("stained_glass_pane_" + color)
                .addVariant(vanilla)
                .addVariant("stained_glass_pane_%s_borderless".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_borderless".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("stained_glass_pane_%s_bubble".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_bubble".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("stained_glass_pane_%s_panel".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_panel".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("stained_glass_pane_%s_quad".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_quad".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("stained_glass_pane_%s_fancy".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_fancy".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
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