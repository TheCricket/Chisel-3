package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PlatinumBlock extends ChiselBlock {
    public PlatinumBlock(BlockBehaviour.Properties props) {
        family = builder("platinum")
                .addVariant("platinum_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("platinum_bolted", props)
                .addVariant("platinum_caution", props, VariantModelType.CONNECTED)
                .addVariant("platinum_crate", props, VariantModelType.CONNECTED)
                .addVariant("platinum_machine", props)
                .addVariant("platinum_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("platinum_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("platinum_bad_greggy"), "Platinum", "Bad Greggy");
        lang.addBlock(getVariant("platinum_bolted"), "Platinum", "Bolted");
        lang.addBlock(getVariant("platinum_caution"), "Platinum", "Caution");
        lang.addBlock(getVariant("platinum_crate"), "Platinum", "Crate");
        lang.addBlock(getVariant("platinum_machine"), "Platinum", "Machine");
        lang.addBlock(getVariant("platinum_scaffold"), "Platinum", "Scaffold");
        lang.addBlock(getVariant("platinum_thermal"), "Platinum", "Thermal");
    }
}

