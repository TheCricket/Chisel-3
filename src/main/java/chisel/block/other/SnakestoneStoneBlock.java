package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SnakestoneStoneBlock extends ChiselBlock {
    public SnakestoneStoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("snakestone_stone")
                .addVariant(Blocks.STONE)
                .addVariant("snakestone_stone_head", props)
                .addVariant("snakestone_stone_body", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("snakestone_stone_head"), "Snakestone (Stone)", "Head");
        lang.addBlock(getVariant("snakestone_stone_body"), "Snakestone (Stone)", "Body");
    }
}

