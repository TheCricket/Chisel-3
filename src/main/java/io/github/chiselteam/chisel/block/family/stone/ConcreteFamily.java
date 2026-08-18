package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;

public class ConcreteFamily extends ChiselFamily {
    public ConcreteFamily(BlockBehaviour.Properties props) {
        family = builder("concrete")
                .addVariant("concrete_raw", props)
                .addVariant("concrete_asphalt", props)
                .addVariant("concrete_block", props, CONNECTED)
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

