package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class SnakestoneSandBlock extends ChiselBlock {
    public SnakestoneSandBlock(BlockBehaviour.Properties props) {
        

        family = builder("snakestone_sand")
                .addVariant(Blocks.SANDSTONE)
                .addVariant("snakestone_sand_head", props)
                .addVariant("snakestone_sand_body", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("snakestone_sand_head"), "Snakestone (Sand)", "Head");
        lang.addBlock(getVariant("snakestone_sand_body"), "Snakestone (Sand)", "Body");
    }
}

