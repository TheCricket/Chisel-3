package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BronzeFamily extends ChiselBlock {
    public BronzeFamily(BlockBehaviour.Properties props) {
        family = builder("bronze")
                .addVariant("bronze_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("bronze_bolted", props)
                .addVariant("bronze_caution", props, VariantModelType.CONNECTED)
                .addVariant("bronze_crate", props, VariantModelType.CONNECTED)
                .addVariant("bronze_machine", props)
                .addVariant("bronze_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("bronze_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("bronze_bad_greggy"), "Bronze", "Bad Greggy");
        lang.addBlock(getVariant("bronze_bolted"), "Bronze", "Bolted");
        lang.addBlock(getVariant("bronze_caution"), "Bronze", "Caution");
        lang.addBlock(getVariant("bronze_crate"), "Bronze", "Crate");
        lang.addBlock(getVariant("bronze_machine"), "Bronze", "Machine");
        lang.addBlock(getVariant("bronze_scaffold"), "Bronze", "Scaffold");
        lang.addBlock(getVariant("bronze_thermal"), "Bronze", "Thermal");
    }
}

