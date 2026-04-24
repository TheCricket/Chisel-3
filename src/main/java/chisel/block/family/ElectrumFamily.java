package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ElectrumFamily extends ChiselFamily {
    public ElectrumFamily(BlockBehaviour.Properties props) {
        family = builder("electrum")
                .addVariant("electrum_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("electrum_bolted", props)
                .addVariant("electrum_caution", props, VariantModelType.CONNECTED)
                .addVariant("electrum_crate", props, VariantModelType.CONNECTED)
                .addVariant("electrum_machine", props)
                .addVariant("electrum_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("electrum_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("electrum_bad_greggy"), "Electrum", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("electrum_bolted"), "Electrum", "Fancy Bolted Plating");
        lang.addBlock(getVariant("electrum_caution"), "Electrum", "Caution Stripes");
        lang.addBlock(getVariant("electrum_crate"), "Electrum", "Shipping Crate");
        lang.addBlock(getVariant("electrum_machine"), "Electrum", "Machine");
        lang.addBlock(getVariant("electrum_scaffold"), "Electrum", "Scaffold");
        lang.addBlock(getVariant("electrum_thermal"), "Electrum", "Thermal");
    }
}

