package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CloudBlock extends ChiselBlock {
    public CloudBlock(BlockBehaviour.Properties props) {
        

        family = builder("cloud")
                .addVariant(Blocks.WHITE_WOOL)
                .addVariant("cloud_0", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("cloud_0"), "Cloud Block");
    }
}

