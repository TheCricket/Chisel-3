package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TinFamily extends ChiselBlock {
    public TinFamily(BlockBehaviour.Properties props) {
        family = builder("tin")
                .addVariant("tin_125", props)
                .addVariant("tin_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("tin_bolted", props)
                .addVariant("tin_caution", props, VariantModelType.CONNECTED)
                .addVariant("tin_crate", props)
                .addVariant("tin_egregious", props, VariantModelType.CONNECTED)
                .addVariant("tin_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("tin_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("tin_125"), "Tin", "125");
        lang.addBlock(getVariant("tin_bad_greggy"), "Tin", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("tin_bolted"), "Tin", "Fancy Bolted Plating");
        lang.addBlock(getVariant("tin_caution"), "Tin", "Caution Stripes");
        lang.addBlock(getVariant("tin_crate"), "Tin", "Shipping Crate");
        lang.addBlock(getVariant("tin_egregious"), "Tin", "Egregiously Bordered Block");
        lang.addBlock(getVariant("tin_scaffold"), "Tin", "Scaffold");
        lang.addBlock(getVariant("tin_thermal"), "Tin", "Thermal");
    }
}

