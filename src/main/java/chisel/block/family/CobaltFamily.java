package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CobaltFamily extends ChiselFamily {
    public CobaltFamily(BlockBehaviour.Properties props) {
        family = builder("cobalt")
                .addVariant("cobalt_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("cobalt_bolted", props)
                .addVariant("cobalt_caution", props, VariantModelType.CONNECTED)
                .addVariant("cobalt_crate", props, VariantModelType.CONNECTED)
                .addVariant("cobalt_machine", props)
                .addVariant("cobalt_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("cobalt_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("cobalt_bad_greggy"), "Cobalt", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("cobalt_bolted"), "Cobalt", "Fancy Bolted Plating");
        lang.addBlock(getVariant("cobalt_caution"), "Cobalt", "Caution Stripes");
        lang.addBlock(getVariant("cobalt_crate"), "Cobalt", "Shipping Crate");
        lang.addBlock(getVariant("cobalt_machine"), "Cobalt", "Machine");
        lang.addBlock(getVariant("cobalt_scaffold"), "Cobalt", "Scaffold");
        lang.addBlock(getVariant("cobalt_thermal"), "Cobalt", "Thermal");
    }
}

