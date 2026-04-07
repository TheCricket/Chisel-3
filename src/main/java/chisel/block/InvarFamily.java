package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class InvarFamily extends ChiselBlock {
    public InvarFamily(BlockBehaviour.Properties props) {
        family = builder("invar")
                .addVariant("invar_bad_greggy", props)
                .addVariant("invar_bolted", props)
                .addVariant("invar_caution", props)
                .addVariant("invar_crate", props)
                .addVariant("invar_machine", props)
                .addVariant("invar_scaffold", props)
                .addVariant("invar_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("invar_bad_greggy"), "Invar", "Bad Greggy");
        lang.addBlock(getVariant("invar_bolted"), "Invar", "Bolted");
        lang.addBlock(getVariant("invar_caution"), "Invar", "Caution");
        lang.addBlock(getVariant("invar_crate"), "Invar", "Crate");
        lang.addBlock(getVariant("invar_machine"), "Invar", "Machine");
        lang.addBlock(getVariant("invar_scaffold"), "Invar", "Scaffold");
        lang.addBlock(getVariant("invar_thermal"), "Invar", "Thermal");
    }
}

