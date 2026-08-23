package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.block.util.ChiselRedstoneLampBlock;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.REDSTONE_LAMP;

public class RedstoneLampFamily extends ChiselFamily {
    public RedstoneLampFamily(BlockBehaviour.Properties props) {
        family = builder("redstone_lamp")
                .addVariant(Blocks.REDSTONE_LAMP)
                .addVariant("redstone_lamp_square", ChiselRedstoneLampBlock::new, () -> props, REDSTONE_LAMP)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("redstone_lamp_square"), "Redstone Lamp", "Square");
    }
}
