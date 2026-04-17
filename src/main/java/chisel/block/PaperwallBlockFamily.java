package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PaperwallBlockFamily extends ChiselBlock {
    public PaperwallBlockFamily(BlockBehaviour.Properties props) {
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
        lang.addBlock(getVariant("paperwall_block_boxed"), "Paperwall Block", "Boxed Paperwall");
        lang.addBlock(getVariant("paperwall_block_crossed"), "Paperwall Block", "Crossed Paperwall");
        lang.addBlock(getVariant("paperwall_block_door"), "Paperwall Block", "Door Shaped Paperwall");
        lang.addBlock(getVariant("paperwall_block_floral"), "Paperwall Block", "Floral Adorned Paperwall");
        lang.addBlock(getVariant("paperwall_block_plain"), "Paperwall Block", "Plain Paperwall");
        lang.addBlock(getVariant("paperwall_block_six"), "Paperwall Block", "Six Sectioned Paperwall");
        lang.addBlock(getVariant("paperwall_block_strike_horizontal"), "Paperwall Block", "Horizontally Striked Paperwall");
        lang.addBlock(getVariant("paperwall_block_strike_middle"), "Paperwall Block", "Middle Striked Paperwall");
        lang.addBlock(getVariant("paperwall_block_strike_vertical"), "Paperwall Block", "Vertically Striked Paperwall");
    }
}

