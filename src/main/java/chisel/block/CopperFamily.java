package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CopperFamily extends ChiselBlock {
    public CopperFamily(BlockBehaviour.Properties props) {
        family = builder("copper")
                .addVariant(Blocks.COPPER_BLOCK)
                .addVariant("copper_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("copper_bolted", props)
                .addVariant("copper_caution", props, VariantModelType.CONNECTED)
                .addVariant("copper_crate", props, VariantModelType.CONNECTED)
                .addVariant("copper_machine", props)
                .addVariant("copper_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("copper_thermal", props, VariantModelType.TBS)
                .family();
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

