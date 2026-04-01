package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ConcreteBlock extends ChiselBlock {
    public ConcreteBlock(BlockBehaviour.Properties props) {
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
        lang.addBlock(getVariant("concrete_raw"), "Concrete", "Raw");
        lang.addBlock(getVariant("concrete_asphalt"), "Concrete", "Asphalt");
        lang.addBlock(getVariant("concrete_block"), "Concrete", "Block");
        lang.addBlock(getVariant("concrete_block_weathered"), "Concrete", "Weathered Block");
        lang.addBlock(getVariant("concrete_blocks"), "Concrete", "Blocks");
        lang.addBlock(getVariant("concrete_blocks_weathered"), "Concrete", "Weathered Blocks");
        lang.addBlock(getVariant("concrete_raw_weathered"), "Concrete", "Weathered Raw");
    }
}

