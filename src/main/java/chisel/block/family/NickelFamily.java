package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class NickelFamily extends ChiselFamily {
    public NickelFamily(BlockBehaviour.Properties props) {
        family = builder("nickel")
                .addVariant("nickel_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("nickel_bolted", props)
                .addVariant("nickel_caution", props, VariantModelType.CONNECTED)
                .addVariant("nickel_crate", props)
                .addVariant("nickel_machine", props)
                .addVariant("nickel_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("nickel_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("nickel_bad_greggy"), "Nickel", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("nickel_bolted"), "Nickel", "Fancy Bolted Plating");
        lang.addBlock(getVariant("nickel_caution"), "Nickel", "Caution Stripes");
        lang.addBlock(getVariant("nickel_crate"), "Nickel", "Shipping Crate");
        lang.addBlock(getVariant("nickel_machine"), "Nickel", "Machine");
        lang.addBlock(getVariant("nickel_scaffold"), "Nickel", "Scaffold");
        lang.addBlock(getVariant("nickel_thermal"), "Nickel", "Thermal");
    }
}

