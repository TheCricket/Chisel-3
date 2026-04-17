package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
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
                .addVariant("bronze_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("bronze_bad_greggy"), "Bronze", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("bronze_bolted"), "Bronze", "Fancy Bolted Plating");
        lang.addBlock(getVariant("bronze_caution"), "Bronze", "Caution Stripes");
        lang.addBlock(getVariant("bronze_crate"), "Bronze", "Shipping Crate");
        lang.addBlock(getVariant("bronze_machine"), "Bronze", "Machine");
        lang.addBlock(getVariant("bronze_scaffold"), "Bronze", "Scaffold");
        lang.addBlock(getVariant("bronze_thermal"), "Bronze", "Thermal");
    }
}

