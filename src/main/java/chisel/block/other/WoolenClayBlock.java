package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class WoolenClayBlock extends ChiselBlock {
    public WoolenClayBlock(BlockBehaviour.Properties props) {
        

        family = builder("woolen_clay")
                .addVariant(Blocks.CLAY)
                .addVariant("woolen_clay_braid", props)
                .addVariant("woolen_clay_chaotic", props)
                .addVariant("woolen_clay_cuts", props)
                .addVariant("woolen_clay_dent", props)
                .addVariant("woolen_clay_french", props)
                .addVariant("woolen_clay_french_2", props)
                .addVariant("woolen_clay_layers", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("woolen_clay_braid"), "Woolen Clay", "Braid");
        lang.addBlock(getVariant("woolen_clay_chaotic"), "Woolen Clay", "Chaotic");
        lang.addBlock(getVariant("woolen_clay_cuts"), "Woolen Clay", "Cuts");
        lang.addBlock(getVariant("woolen_clay_dent"), "Woolen Clay", "Dent");
        lang.addBlock(getVariant("woolen_clay_french"), "Woolen Clay", "French");
        lang.addBlock(getVariant("woolen_clay_french_2"), "Woolen Clay", "French 2");
        lang.addBlock(getVariant("woolen_clay_layers"), "Woolen Clay", "Layers");
    }
}

