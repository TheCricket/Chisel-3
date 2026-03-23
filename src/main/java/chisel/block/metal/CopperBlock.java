package chisel.block.metal;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class CopperBlock extends ChiselBlock {
    public CopperBlock(BlockBehaviour.Properties props) {
        

        family = builder("copper")
                .addVariant(Blocks.COPPER_BLOCK)
                .addVariant("copper_bad_greggy", props)
                .addVariant("copper_bolted", props)
                .addVariant("copper_caution", props)
                .addVariant("copper_crate", props)
                .addVariant("copper_machine", props)
                .addVariant("copper_scaffold", props)
                .addVariant("copper_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("copper_bad_greggy"), "Copper", "Bad Greggy");
        lang.addBlock(getVariant("copper_bolted"), "Copper", "Bolted");
        lang.addBlock(getVariant("copper_caution"), "Copper", "Caution");
        lang.addBlock(getVariant("copper_crate"), "Copper", "Crate");
        lang.addBlock(getVariant("copper_machine"), "Copper", "Machine");
        lang.addBlock(getVariant("copper_scaffold"), "Copper", "Scaffold");
        lang.addBlock(getVariant("copper_thermal"), "Copper", "Thermal");
    }
}

