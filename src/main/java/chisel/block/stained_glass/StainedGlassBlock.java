package chisel.block.stained_glass;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.apache.commons.lang3.StringUtils;

public class StainedGlassBlock extends ChiselBlock {

    private final String color;
    private final Block vanilla;

    public StainedGlassBlock(BlockBehaviour.Properties props, String color, Block vanilla) {
        this.color = color;
        this.vanilla = vanilla;

        family = builder("stained_glass_" + color)
                .addVariant(vanilla)
                .addVariant("stained_glass_%s_borderless".formatted(color), props)
                .addVariant("stained_glass_%s_bubble".formatted(color), props)
                .addVariant("stained_glass_%s_panel".formatted(color), props)
                .addVariant("stained_glass_%s_fancy".formatted(color), props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        String colorName = StringUtils.capitalize(color.replace("_", " "));
        lang.addBlock(getVariant("stained_glass_%s_borderless".formatted(color)), colorName + " Stained Glass", "Borderless");
        lang.addBlock(getVariant("stained_glass_%s_bubble".formatted(color)), colorName + " Stained Glass", "Bubble");
        lang.addBlock(getVariant("stained_glass_%s_panel".formatted(color)), colorName + " Stained Glass", "Panel");
        lang.addBlock(getVariant("stained_glass_%s_fancy".formatted(color)), colorName + " Stained Glass", "Fancy");
    }
}
