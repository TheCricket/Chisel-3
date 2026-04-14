package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SteelFamily extends ChiselBlock {
    public SteelFamily(BlockBehaviour.Properties props) {
        family = builder("steel")
                .addVariant("steel_125", props)
                .addVariant("steel_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("steel_bolted", props)
                .addVariant("steel_caution", props, VariantModelType.CONNECTED)
                .addVariant("steel_crate", props, VariantModelType.CONNECTED)
                .addVariant("steel_egregious", props, VariantModelType.CONNECTED)
                .addVariant("steel_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("steel_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("steel_125"), "Steel", "125");
        lang.addBlock(getVariant("steel_bad_greggy"), "Steel", "Bad Greggy");
        lang.addBlock(getVariant("steel_bolted"), "Steel", "Bolted");
        lang.addBlock(getVariant("steel_caution"), "Steel", "Caution");
        lang.addBlock(getVariant("steel_crate"), "Steel", "Crate");
        lang.addBlock(getVariant("steel_egregious"), "Steel", "Egregious");
        lang.addBlock(getVariant("steel_scaffold"), "Steel", "Scaffold");
        lang.addBlock(getVariant("steel_thermal"), "Steel", "Thermal");
    }
}

