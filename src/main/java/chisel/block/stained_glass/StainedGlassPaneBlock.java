package chisel.block.stained_glass;

import chisel.Chisel;
import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.StringUtils;

public class StainedGlassPaneBlock extends ChiselBlock {

    private final DyeColor color;
    private final Block vanilla;

    public StainedGlassPaneBlock(BlockBehaviour.Properties props, DyeColor color, Block vanilla) {
        this.color = color;
        this.vanilla = vanilla;

        family = builder("stained_glass_pane_" + color)
                .addVariant(vanilla)
                .addVariant("stained_glass_pane_%s_borderless".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_borderless".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("stained_glass_pane_%s_bubble".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_bubble".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("stained_glass_pane_%s_panel".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_panel".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
                .addVariant("stained_glass_pane_%s_fancy".formatted(color), (p) -> new net.minecraft.world.level.block.StainedGlassPaneBlock(color, p.setId(ResourceKey.create(Registries.BLOCK, Chisel.prefix("stained_glass_pane_%s_fancy".formatted(color))))), () -> props, VariantModelType.GLASS_PANE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        String colorName = StringUtils.capitalize(color.getName().replace("_", " "));
        lang.addBlock(getVariant("stained_glass_pane_%s_borderless".formatted(color)), colorName + " Stained Glass Pane", "Borderless");
        lang.addBlock(getVariant("stained_glass_pane_%s_bubble".formatted(color)), colorName + " Stained Glass Pane", "Bubble");
        lang.addBlock(getVariant("stained_glass_pane_%s_panel".formatted(color)), colorName + " Stained Glass Pane", "Panel");
        lang.addBlock(getVariant("stained_glass_pane_%s_fancy".formatted(color)), colorName + " Stained Glass Pane", "Fancy");
    }
}

