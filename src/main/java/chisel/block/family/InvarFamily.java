package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class InvarFamily extends ChiselFamily {
    public InvarFamily(BlockBehaviour.Properties props) {
        family = builder("invar")
                .addVariant("invar_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("invar_bolted", props)
                .addVariant("invar_caution", props, VariantModelType.CONNECTED)
                .addVariant("invar_crate", props, VariantModelType.CONNECTED)
                .addVariant("invar_machine", props)
                .addVariant("invar_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("invar_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("invar_bad_greggy"), "Invar", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("invar_bolted"), "Invar", "Fancy Bolted Plating");
        lang.addBlock(getVariant("invar_caution"), "Invar", "Caution Stripes");
        lang.addBlock(getVariant("invar_crate"), "Invar", "Shipping Crate");
        lang.addBlock(getVariant("invar_machine"), "Invar", "Machine");
        lang.addBlock(getVariant("invar_scaffold"), "Invar", "Scaffold");
        lang.addBlock(getVariant("invar_thermal"), "Invar", "Thermal");
    }
}

