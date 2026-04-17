package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.StringUtils;

public class StainedGlassFamily extends ChiselBlock {

    private final String color;

    public StainedGlassFamily(BlockBehaviour.Properties props, String color, Block vanilla) {
        this.color = color;

        family = builder("stained_glass_" + color)
                .addVariant(vanilla)
                .addVariant("stained_glass_%s_borderless".formatted(color), props)
                .addVariant("stained_glass_%s_bubble".formatted(color), props)
                .addVariant("stained_glass_%s_panel".formatted(color), props)
                .addVariant("stained_glass_%s_panel_fancy".formatted(color), props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        String colorName = StringUtils.capitalize(color.replace("_", " "));
        lang.addBlock(getVariant("stained_glass_%s_borderless".formatted(color)), colorName + " Stained Glass", colorName + " Borderless Glass");
        lang.addBlock(getVariant("stained_glass_%s_bubble".formatted(color)), colorName + " Stained Glass", colorName + " Bubble Glass");
        lang.addBlock(getVariant("stained_glass_%s_panel".formatted(color)), colorName + " Stained Glass", colorName + " Glass Panel");
        lang.addBlock(getVariant("stained_glass_%s_panel_fancy".formatted(color)), colorName + " Stained Glass", colorName + " Fancy Glass Panel");
    }
}
