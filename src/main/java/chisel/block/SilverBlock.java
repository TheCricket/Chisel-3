package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SilverBlock extends ChiselBlock {
    public SilverBlock(BlockBehaviour.Properties props) {
        family = builder("silver")
                .addVariant("silver_bad_greggy", props)
                .addVariant("silver_bolted", props)
                .addVariant("silver_caution", props)
                .addVariant("silver_crate", props)
                .addVariant("silver_machine", props)
                .addVariant("silver_scaffold", props)
                .addVariant("silver_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("silver_bad_greggy"), "Silver", "Bad Greggy");
        lang.addBlock(getVariant("silver_bolted"), "Silver", "Bolted");
        lang.addBlock(getVariant("silver_caution"), "Silver", "Caution");
        lang.addBlock(getVariant("silver_crate"), "Silver", "Crate");
        lang.addBlock(getVariant("silver_machine"), "Silver", "Machine");
        lang.addBlock(getVariant("silver_scaffold"), "Silver", "Scaffold");
        lang.addBlock(getVariant("silver_thermal"), "Silver", "Thermal");
    }
}

