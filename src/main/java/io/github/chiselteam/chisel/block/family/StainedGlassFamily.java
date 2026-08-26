package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.StringUtils;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class StainedGlassFamily extends ChiselFamily {

    private final String color;

    public String getColor() {
        return color;
    }

    public StainedGlassFamily(BlockBehaviour.Properties props, String color, Block vanilla) {
        this.color = color;

        family = builder("stained_glass_%s".formatted(color))
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
        String baseName = "%s Stained Glass".formatted(colorName);
        lang.addBlock(getVariant("stained_glass_%s_borderless".formatted(color)), baseName, "%s Borderless Glass".formatted(colorName));
        lang.addBlock(getVariant("stained_glass_%s_bubble".formatted(color)), baseName, "%s Bubble Glass".formatted(colorName));
        lang.addBlock(getVariant("stained_glass_%s_panel".formatted(color)), baseName, "%s Glass Panel".formatted(colorName));
        lang.addBlock(getVariant("stained_glass_%s_panel_fancy".formatted(color)), baseName, "%s Fancy Glass Panel".formatted(colorName));
    }
}
