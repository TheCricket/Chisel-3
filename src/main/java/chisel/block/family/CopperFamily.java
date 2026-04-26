package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CopperFamily extends ChiselFamily {
    public CopperFamily(BlockBehaviour.Properties props) {
        family = builder("copper")
                .addVariant(Blocks.COPPER_BLOCK)
                .addVariant("copper_bad_greggy", props, VariantModelType.CONNECTED)
                .addVariant("copper_bolted", props)
                .addVariant("copper_caution", props, VariantModelType.CONNECTED)
                .addVariant("copper_crate", props, VariantModelType.CONNECTED)
                .addVariant("copper_machine", props)
                .addVariant("copper_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("copper_thermal", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("copper_bad_greggy"), "Copper", "An Old Relic from the land of Oneteufyv");
        lang.addBlock(getVariant("copper_bolted"), "Copper", "Fancy Bolted Plating");
        lang.addBlock(getVariant("copper_caution"), "Copper", "Caution Stripes");
        lang.addBlock(getVariant("copper_crate"), "Copper", "Shipping Crate");
        lang.addBlock(getVariant("copper_machine"), "Copper", "Machine");
        lang.addBlock(getVariant("copper_scaffold"), "Copper", "Scaffold");
        lang.addBlock(getVariant("copper_thermal"), "Copper", "Thermal");
    }
}

