package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

// import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class ATMVibraniumAllthemodiumFamily extends ChiselFamily {
    public ATMVibraniumAllthemodiumFamily(BlockBehaviour.Properties props) {
        family = builder("atm_vibranium_allthemodium")

                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        
    }
}

