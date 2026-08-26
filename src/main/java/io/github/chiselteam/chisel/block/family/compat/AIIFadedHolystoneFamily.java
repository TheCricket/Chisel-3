package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class AIIFadedHolystoneFamily extends ChiselFamily {
    public AIIFadedHolystoneFamily(BlockBehaviour.Properties props) {
        family = builder("aii_faded_holystone")

                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        
    }
}

