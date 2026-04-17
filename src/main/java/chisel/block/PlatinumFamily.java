package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PlatinumFamily extends ChiselBlock {
    public PlatinumFamily(BlockBehaviour.Properties props) {
        family = builder("platinum")
                .addVariant("platinum_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("platinum_bolted", props)
                .addVariant("platinum_caution", props, VariantModelType.CONNECTED)
                .addVariant("platinum_crate", props, VariantModelType.CONNECTED)
                .addVariant("platinum_machine", props)
                .addVariant("platinum_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("platinum_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("platinum_bad_greggy"), "Platinum", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("platinum_bolted"), "Platinum", "Fancy Bolted Plating");
        lang.addBlock(getVariant("platinum_caution"), "Platinum", "Caution Stripes");
        lang.addBlock(getVariant("platinum_crate"), "Platinum", "Shipping Crate");
        lang.addBlock(getVariant("platinum_machine"), "Platinum", "Machine");
        lang.addBlock(getVariant("platinum_scaffold"), "Platinum", "Scaffold");
        lang.addBlock(getVariant("platinum_thermal"), "Platinum", "Thermal");
    }
}

