package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CobaltFamily extends ChiselBlock {
    public CobaltFamily(BlockBehaviour.Properties props) {
        family = builder("cobalt")
                .addVariant("cobalt_bad_greggy", props)
                .addVariant("cobalt_bolted", props)
                .addVariant("cobalt_caution", props)
                .addVariant("cobalt_crate", props)
                .addVariant("cobalt_machine", props)
                .addVariant("cobalt_scaffold", props)
                .addVariant("cobalt_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("cobalt_bad_greggy"), "Cobalt", "Bad Greggy");
        lang.addBlock(getVariant("cobalt_bolted"), "Cobalt", "Bolted");
        lang.addBlock(getVariant("cobalt_caution"), "Cobalt", "Caution");
        lang.addBlock(getVariant("cobalt_crate"), "Cobalt", "Crate");
        lang.addBlock(getVariant("cobalt_machine"), "Cobalt", "Machine");
        lang.addBlock(getVariant("cobalt_scaffold"), "Cobalt", "Scaffold");
        lang.addBlock(getVariant("cobalt_thermal"), "Cobalt", "Thermal");
    }
}

