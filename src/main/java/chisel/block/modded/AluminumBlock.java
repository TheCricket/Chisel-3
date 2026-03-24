package chisel.block.modded;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;

public class AluminumBlock extends ChiselBlock {
    public AluminumBlock(BlockBehaviour.Properties props) {
        

        family = builder("aluminum")
                .addVariant("aluminum_bad_greggy", props)
                .addVariant("aluminum_bolted", props)
                .addVariant("aluminum_caution", props)
                .addVariant("aluminum_crate", props)
                .addVariant("aluminum_machine", props)
                .addVariant("aluminum_scaffold", props)
                .addVariant("aluminum_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("aluminum_bad_greggy"), "Aluminum", "Bad Greggy");
        lang.addBlock(getVariant("aluminum_bolted"), "Aluminum", "Bolted");
        lang.addBlock(getVariant("aluminum_caution"), "Aluminum", "Caution");
        lang.addBlock(getVariant("aluminum_crate"), "Aluminum", "Crate");
        lang.addBlock(getVariant("aluminum_machine"), "Aluminum", "Machine");
        lang.addBlock(getVariant("aluminum_scaffold"), "Aluminum", "Scaffold");
        lang.addBlock(getVariant("aluminum_thermal"), "Aluminum", "Thermal");
    }
}

