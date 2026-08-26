package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class AIIGreatrootFamily extends ChiselFamily {
    public AIIGreatrootFamily(BlockBehaviour.Properties props) {
        family = builder("aii_greatroot")

                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        
    }
}

