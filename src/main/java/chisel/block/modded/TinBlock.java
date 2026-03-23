package chisel.block.modded;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;

public class TinBlock extends ChiselBlock {
    public TinBlock(BlockBehaviour.Properties props) {
        

        family = builder("tin")
                .addVariant("tin_bad_greggy", props)
                .addVariant("tin_bolted", props)
                .addVariant("tin_caution", props)
                .addVariant("tin_crate", props)
                .addVariant("tin_machine", props)
                .addVariant("tin_scaffold", props)
                .addVariant("tin_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("tin_bad_greggy"), "Tin", "Bad Greggy");
        lang.addBlock(getVariant("tin_bolted"), "Tin", "Bolted");
        lang.addBlock(getVariant("tin_caution"), "Tin", "Caution");
        lang.addBlock(getVariant("tin_crate"), "Tin", "Crate");
        lang.addBlock(getVariant("tin_machine"), "Tin", "Machine");
        lang.addBlock(getVariant("tin_scaffold"), "Tin", "Scaffold");
        lang.addBlock(getVariant("tin_thermal"), "Tin", "Thermal");
    }
}

