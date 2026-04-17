package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UraniumFamily extends ChiselBlock {
    public UraniumFamily(BlockBehaviour.Properties props) {
        family = builder("uranium")
                .addVariant("uranium_125", props)
                .addVariant("uranium_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("uranium_bolted", props)
                .addVariant("uranium_caution", props, VariantModelType.CONNECTED)
                .addVariant("uranium_crate", props, VariantModelType.CONNECTED)
                .addVariant("uranium_machine", props)
                .addVariant("uranium_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("uranium_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("uranium_125"), "Uranium", "125");
        lang.addBlock(getVariant("uranium_bad_greggy"), "Uranium", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("uranium_bolted"), "Uranium", "Fancy Bolted Plating");
        lang.addBlock(getVariant("uranium_caution"), "Uranium", "Caution Stripes");
        lang.addBlock(getVariant("uranium_crate"), "Uranium", "Shipping Crate");
        lang.addBlock(getVariant("uranium_machine"), "Uranium", "Machine");
        lang.addBlock(getVariant("uranium_scaffold"), "Uranium", "Scaffold");
        lang.addBlock(getVariant("uranium_thermal"), "Uranium", "Thermal");
    }
}


