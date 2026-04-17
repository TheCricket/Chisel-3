package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WoolenClayFamily extends ChiselBlock {
    public WoolenClayFamily(BlockBehaviour.Properties props) {
        family = builder("woolen_clay")
                .addVariant(Blocks.CLAY)
                .addVariant("woolen_clay_0", props)
                .addVariant("woolen_clay_1", props)
                .addVariant("woolen_clay_2", props)
                .addVariant("woolen_clay_3", props)
                .addVariant("woolen_clay_4", props)
                .addVariant("woolen_clay_5", props)
                .addVariant("woolen_clay_6", props)
                .addVariant("woolen_clay_7", props)
                .addVariant("woolen_clay_8", props)
                .addVariant("woolen_clay_9", props)
                .addVariant("woolen_clay_10", props)
                .addVariant("woolen_clay_11", props)
                .addVariant("woolen_clay_12", props)
                .addVariant("woolen_clay_13", props)
                .addVariant("woolen_clay_14", props)
                .addVariant("woolen_clay_15", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("woolen_clay_0"), "Woolen Clay", "White Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_1"), "Woolen Clay", "Orange Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_2"), "Woolen Clay", "Magenta Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_3"), "Woolen Clay", "Light Blue Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_4"), "Woolen Clay", "Yellow Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_5"), "Woolen Clay", "Lime Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_6"), "Woolen Clay", "Pink Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_7"), "Woolen Clay", "Grey Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_8"), "Woolen Clay", "Light Grey Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_9"), "Woolen Clay", "Cyan Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_10"), "Woolen Clay", "Purple Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_11"), "Woolen Clay", "Blue Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_12"), "Woolen Clay", "Brown Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_13"), "Woolen Clay", "Green Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_14"), "Woolen Clay", "Red Woolen Clay");
        lang.addBlock(getVariant("woolen_clay_15"), "Woolen Clay", "Black Woolen Clay");
    }
}

