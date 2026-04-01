package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PaperwallBlockBlock extends ChiselBlock {
    public PaperwallBlockBlock(BlockBehaviour.Properties props) {
        family = builder("paperwall_block")
                .addVariant("paperwall_block_boxed", props)
                .addVariant("paperwall_block_crossed", props)
                .addVariant("paperwall_block_door", props)
                .addVariant("paperwall_block_floral", props)
                .addVariant("paperwall_block_plain", props)
                .addVariant("paperwall_block_six", props)
                .addVariant("paperwall_block_strike_horizontal", props)
                .addVariant("paperwall_block_strike_middle", props)
                .addVariant("paperwall_block_strike_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("paperwall_block_boxed"), "Paperwall Block", "Boxed");
        lang.addBlock(getVariant("paperwall_block_crossed"), "Paperwall Block", "Crossed");
        lang.addBlock(getVariant("paperwall_block_door"), "Paperwall Block", "Door");
        lang.addBlock(getVariant("paperwall_block_floral"), "Paperwall Block", "Floral");
        lang.addBlock(getVariant("paperwall_block_plain"), "Paperwall Block", "Plain");
        lang.addBlock(getVariant("paperwall_block_six"), "Paperwall Block", "Six");
        lang.addBlock(getVariant("paperwall_block_strike_horizontal"), "Paperwall Block", "Horizontal Strike");
        lang.addBlock(getVariant("paperwall_block_strike_middle"), "Paperwall Block", "Middle Strike");
        lang.addBlock(getVariant("paperwall_block_strike_vertical"), "Paperwall Block", "Vertical Strike");
    }
}

