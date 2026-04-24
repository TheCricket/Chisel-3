package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ConcreteFamily extends ChiselFamily {
    public ConcreteFamily(BlockBehaviour.Properties props) {
        family = builder("concrete")
                .addVariant("concrete_raw", props)
                .addVariant("concrete_asphalt", props)
                .addVariant("concrete_block", props, VariantModelType.CONNECTED)
                .addVariant("concrete_block_weathered", props)
                .addVariant("concrete_blocks", props)
                .addVariant("concrete_blocks_weathered", props)
                .addVariant("concrete_raw_weathered", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("concrete_raw"), "Concrete", "Concrete");
        lang.addBlock(getVariant("concrete_asphalt"), "Concrete", "Asphalt");
        lang.addBlock(getVariant("concrete_block"), "Concrete", "Concrete Block");
        lang.addBlock(getVariant("concrete_block_weathered"), "Concrete", "Weathered Concrete Block");
        lang.addBlock(getVariant("concrete_blocks"), "Concrete", "Small Concrete Blocks");
        lang.addBlock(getVariant("concrete_blocks_weathered"), "Concrete", "Small Weathered Blocks");
        lang.addBlock(getVariant("concrete_raw_weathered"), "Concrete", "Weathered Concrete");
    }
}

