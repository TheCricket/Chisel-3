package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class AluminumFamily extends ChiselBlock {
    public AluminumFamily(BlockBehaviour.Properties props) {
        family = builder("aluminum")
                .addVariant("aluminum_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("aluminum_bolted", props)
                .addVariant("aluminum_caution", props, VariantModelType.CONNECTED)
                .addVariant("aluminum_crate", props, VariantModelType.CONNECTED)
                .addVariant("aluminum_machine", props)
                .addVariant("aluminum_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("aluminum_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("aluminum_bad_greggy"), "Aluminum", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("aluminum_bolted"), "Aluminum", "Fancy Bolted Plating");
        lang.addBlock(getVariant("aluminum_caution"), "Aluminum", "Caution Stripes");
        lang.addBlock(getVariant("aluminum_crate"), "Aluminum", "Shipping Crate");
        lang.addBlock(getVariant("aluminum_machine"), "Aluminum", "Machine");
        lang.addBlock(getVariant("aluminum_scaffold"), "Aluminum", "Scaffold");
        lang.addBlock(getVariant("aluminum_thermal"), "Aluminum", "Thermal");
    }
}

