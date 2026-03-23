package chisel.block.modded;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;

public class UraniumBlock extends ChiselBlock {
    public UraniumBlock(BlockBehaviour.Properties props) {
        

        family = builder("uranium")
                .addVariant("uranium_bad_greggy", props)
                .addVariant("uranium_bolted", props)
                .addVariant("uranium_caution", props)
                .addVariant("uranium_crate", props)
                .addVariant("uranium_machine", props)
                .addVariant("uranium_scaffold", props)
                .addVariant("uranium_thermal", props, VariantModelType.TOP_BOTTOM_SIDE)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("uranium_bad_greggy"), "Uranium", "Bad Greggy");
        lang.addBlock(getVariant("uranium_bolted"), "Uranium", "Bolted");
        lang.addBlock(getVariant("uranium_caution"), "Uranium", "Caution");
        lang.addBlock(getVariant("uranium_crate"), "Uranium", "Crate");
        lang.addBlock(getVariant("uranium_machine"), "Uranium", "Machine");
        lang.addBlock(getVariant("uranium_scaffold"), "Uranium", "Scaffold");
        lang.addBlock(getVariant("uranium_thermal"), "Uranium", "Thermal");
    }
}

