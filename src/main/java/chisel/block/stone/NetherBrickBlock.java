package chisel.block.stone;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class NetherBrickBlock extends ChiselBlock {
    public NetherBrickBlock(BlockBehaviour.Properties props) {
        

        family = builder("netherbrick")
                .addVariant(Blocks.NETHER_BRICKS)
                .addVariant("netherbrick_braid", props)
                .addVariant("netherbrick_chaotic", props)
                .addVariant("netherbrick_cracked", props)
                .addVariant("netherbrick_cuts", props)
                .addVariant("netherbrick_dent", props)
                .addVariant("netherbrick_french", props)
                .addVariant("netherbrick_french_2", props)
                .addVariant("netherbrick_layers", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("netherbrick_braid"), "Nether Bricks", "Braid");
        lang.addBlock(getVariant("netherbrick_chaotic"), "Nether Bricks", "Chaotic");
        lang.addBlock(getVariant("netherbrick_cracked"), "Nether Bricks", "Cracked");
        lang.addBlock(getVariant("netherbrick_cuts"), "Nether Bricks", "Cuts");
        lang.addBlock(getVariant("netherbrick_dent"), "Nether Bricks", "Dent");
        lang.addBlock(getVariant("netherbrick_french"), "Nether Bricks", "French");
        lang.addBlock(getVariant("netherbrick_french_2"), "Nether Bricks", "French 2");
        lang.addBlock(getVariant("netherbrick_layers"), "Nether Bricks", "Layers");
    }
}

