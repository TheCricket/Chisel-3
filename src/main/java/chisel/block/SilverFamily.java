package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SilverFamily extends ChiselBlock {
    public SilverFamily(BlockBehaviour.Properties props) {
        family = builder("silver")
                .addVariant("silver_125", props)
                .addVariant("silver_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("silver_bolted", props)
                .addVariant("silver_caution", props, VariantModelType.CONNECTED)
                .addVariant("silver_crate", props, VariantModelType.CONNECTED)
                .addVariant("silver_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("silver_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("silver_125"), "Silver", "125");
        lang.addBlock(getVariant("silver_bad_greggy"), "Silver", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("silver_bolted"), "Silver", "Fancy Bolted Plating");
        lang.addBlock(getVariant("silver_caution"), "Silver", "Caution Stripes");
        lang.addBlock(getVariant("silver_crate"), "Silver", "Shipping Crate");
        lang.addBlock(getVariant("silver_scaffold"), "Silver", "Scaffold");
        lang.addBlock(getVariant("silver_thermal"), "Silver", "Thermal");
    }
}

