package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TorchBlock extends ChiselBlock {
    public TorchBlock(BlockBehaviour.Properties props) {
        family = builder("torch")
                .addVariant("torch_0", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("torch_0"), "Torch");
    }
}

