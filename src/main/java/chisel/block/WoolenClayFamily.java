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
        lang.addBlock(getVariant("woolen_clay_0"), "Woolen Clay", "White");
        lang.addBlock(getVariant("woolen_clay_1"), "Woolen Clay", "Orange");
        lang.addBlock(getVariant("woolen_clay_2"), "Woolen Clay", "Magenta");
        lang.addBlock(getVariant("woolen_clay_3"), "Woolen Clay", "Light Blue");
        lang.addBlock(getVariant("woolen_clay_4"), "Woolen Clay", "Yellow");
        lang.addBlock(getVariant("woolen_clay_5"), "Woolen Clay", "Lime");
        lang.addBlock(getVariant("woolen_clay_6"), "Woolen Clay", "Pink");
        lang.addBlock(getVariant("woolen_clay_7"), "Woolen Clay", "Gray");
        lang.addBlock(getVariant("woolen_clay_8"), "Woolen Clay", "Light Gray");
        lang.addBlock(getVariant("woolen_clay_9"), "Woolen Clay", "Cyan");
        lang.addBlock(getVariant("woolen_clay_10"), "Woolen Clay", "Purple");
        lang.addBlock(getVariant("woolen_clay_11"), "Woolen Clay", "Blue");
        lang.addBlock(getVariant("woolen_clay_12"), "Woolen Clay", "Brown");
        lang.addBlock(getVariant("woolen_clay_13"), "Woolen Clay", "Green");
        lang.addBlock(getVariant("woolen_clay_14"), "Woolen Clay", "Red");
        lang.addBlock(getVariant("woolen_clay_15"), "Woolen Clay", "Black");
    }
}

