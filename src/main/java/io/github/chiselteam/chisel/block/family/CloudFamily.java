package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CloudFamily extends ChiselFamily {
    public CloudFamily(BlockBehaviour.Properties props) {
        family = builder("cloud")
                .addVariant("cloud_grid", props)
                .addVariant("cloud_large", props)
                .addVariant("cloud_normal", props)
                .addVariant("cloud_small", props)
                .addVariant("cloud_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("cloud_grid"), "Cloud", "Gridded Cloud Bricks");
        lang.addBlock(getVariant("cloud_large"), "Cloud", "Large Cloud Bricks");
        lang.addBlock(getVariant("cloud_normal"), "Cloud", "Cloud Block");
        lang.addBlock(getVariant("cloud_small"), "Cloud", "Small Cloud Bricks");
        lang.addBlock(getVariant("cloud_vertical"), "Cloud", "Small Vertical Cloud Bricks");
    }
}

