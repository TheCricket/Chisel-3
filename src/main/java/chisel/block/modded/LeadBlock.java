package chisel.block.modded;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;

public class LeadBlock extends ChiselBlock {
    public LeadBlock(BlockBehaviour.Properties props) {
        

        family = builder("lead")
                .addVariant("lead_bad_greggy", props)
                .addVariant("lead_bolted", props)
                .addVariant("lead_caution", props)
                .addVariant("lead_crate", props)
                .addVariant("lead_machine", props)
                .addVariant("lead_scaffold", props)
                .addVariant("lead_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .getFamily();
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

