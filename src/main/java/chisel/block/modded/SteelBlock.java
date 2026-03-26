package chisel.block.modded;

import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SteelBlock extends ChiselBlock {
    public SteelBlock(BlockBehaviour.Properties props) {
        

        family = builder("steel")
                .addVariant("steel_bad_greggy", props)
                .addVariant("steel_bolted", props)
                .addVariant("steel_caution", props)
                .addVariant("steel_crate", props)
                .addVariant("steel_machine", props)
                .addVariant("steel_scaffold", props)
                .addVariant("steel_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("steel_bad_greggy"), "Steel", "Bad Greggy");
        lang.addBlock(getVariant("steel_bolted"), "Steel", "Bolted");
        lang.addBlock(getVariant("steel_caution"), "Steel", "Caution");
        lang.addBlock(getVariant("steel_crate"), "Steel", "Crate");
        lang.addBlock(getVariant("steel_machine"), "Steel", "Machine");
        lang.addBlock(getVariant("steel_scaffold"), "Steel", "Scaffold");
        lang.addBlock(getVariant("steel_thermal"), "Steel", "Thermal");
    }
}

