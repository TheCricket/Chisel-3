package chisel.block.modded;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;

public class ElectrumBlock extends ChiselBlock {
    public ElectrumBlock(BlockBehaviour.Properties props) {
        

        family = builder("electrum")
                .addVariant("electrum_bad_greggy", props)
                .addVariant("electrum_bolted", props)
                .addVariant("electrum_caution", props)
                .addVariant("electrum_crate", props)
                .addVariant("electrum_machine", props)
                .addVariant("electrum_scaffold", props)
                .addVariant("electrum_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("electrum_bad_greggy"), "Electrum", "Bad Greggy");
        lang.addBlock(getVariant("electrum_bolted"), "Electrum", "Bolted");
        lang.addBlock(getVariant("electrum_caution"), "Electrum", "Caution");
        lang.addBlock(getVariant("electrum_crate"), "Electrum", "Crate");
        lang.addBlock(getVariant("electrum_machine"), "Electrum", "Machine");
        lang.addBlock(getVariant("electrum_scaffold"), "Electrum", "Scaffold");
        lang.addBlock(getVariant("electrum_thermal"), "Electrum", "Thermal");
    }
}

