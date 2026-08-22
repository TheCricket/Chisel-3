package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SeaLanternFamily extends ChiselFamily {
    public SeaLanternFamily(BlockBehaviour.Properties props) {
        family = builder("sealantern")
                .addVariant("sealantern_test", props, MULTI_LAYER_CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("sealantern_test"), "Sea Lantern", "Sea Lantern");
    }
}

