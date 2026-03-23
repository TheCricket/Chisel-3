package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class TorchBlock extends ChiselBlock {
    public TorchBlock(BlockBehaviour.Properties props) {
        

        family = builder("torch")
                .addVariant("torch_0", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("torch_0"), "Torch");
    }
}

