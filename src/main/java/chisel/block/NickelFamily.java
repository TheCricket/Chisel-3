package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class NickelFamily extends ChiselBlock {
    public NickelFamily(BlockBehaviour.Properties props) {
        family = builder("nickel")
                .addVariant("nickel_bad_greggy", props)
                .addVariant("nickel_bolted", props)
                .addVariant("nickel_caution", props)
                .addVariant("nickel_crate", props)
                .addVariant("nickel_machine", props)
                .addVariant("nickel_scaffold", props)
                .addVariant("nickel_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("nickel_bad_greggy"), "Nickel", "Bad Greggy");
        lang.addBlock(getVariant("nickel_bolted"), "Nickel", "Bolted");
        lang.addBlock(getVariant("nickel_caution"), "Nickel", "Caution");
        lang.addBlock(getVariant("nickel_crate"), "Nickel", "Crate");
        lang.addBlock(getVariant("nickel_machine"), "Nickel", "Machine");
        lang.addBlock(getVariant("nickel_scaffold"), "Nickel", "Scaffold");
        lang.addBlock(getVariant("nickel_thermal"), "Nickel", "Thermal");
    }
}

