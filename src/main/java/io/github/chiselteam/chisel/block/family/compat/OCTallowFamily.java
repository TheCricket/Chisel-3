package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class OCTallowFamily extends ChiselFamily {
    public OCTallowFamily(BlockBehaviour.Properties props) {
        family = builder("oc_tallow")
                .addVariant("tallow_block", props, TBS)
                .addVariant("tallow_faces", props)
                .addVariant("tallow_smooth", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("tallow_block"), "Tallow", "Block");
        lang.addBlock(getVariant("tallow_faces"), "Tallow", "Pareidolia");
        lang.addBlock(getVariant("tallow_smooth"), "Tallow", "Smooth");
    }
}
