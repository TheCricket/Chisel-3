package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LeadFamily extends ChiselBlock {
    public LeadFamily(BlockBehaviour.Properties props) {
        family = builder("lead")
                .addVariant("lead_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("lead_bolted", props)
                .addVariant("lead_caution", props, VariantModelType.CONNECTED)
                .addVariant("lead_crate", props, VariantModelType.CONNECTED)
                .addVariant("lead_machine", props)
                .addVariant("lead_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("lead_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("lead_bad_greggy"), "Lead", "Bad Greggy");
        lang.addBlock(getVariant("lead_bolted"), "Lead", "Bolted");
        lang.addBlock(getVariant("lead_caution"), "Lead", "Caution");
        lang.addBlock(getVariant("lead_crate"), "Lead", "Crate");
        lang.addBlock(getVariant("lead_machine"), "Lead", "Machine");
        lang.addBlock(getVariant("lead_scaffold"), "Lead", "Scaffold");
        lang.addBlock(getVariant("lead_thermal"), "Lead", "Thermal");
    }
}

