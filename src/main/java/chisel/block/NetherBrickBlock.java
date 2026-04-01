package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class NetherBrickBlock extends ChiselBlock {
    public NetherBrickBlock(BlockBehaviour.Properties props) {
        family = builder("nether_brick")
                .addVariant(Blocks.NETHER_BRICKS)
                .addVariant("nether_brick_blue", props)
                .addVariant("nether_brick_blue_lava", props)
                .addVariant("nether_brick_brown", props)
                .addVariant("nether_brick_guts", props)
                .addVariant("nether_brick_guts_dark", props)
                .addVariant("nether_brick_guts_small", props)
                .addVariant("nether_brick_meat", props)
                .addVariant("nether_brick_meat_red", props)
                .addVariant("nether_brick_meat_small", props)
                .addVariant("nether_brick_meat_small_red", props)
                .addVariant("nether_brick_obsidian", props)
                .addVariant("nether_brick_red", props)
                .addVariant("nether_brick_red_small", props)
                .addVariant("nether_brick_spattered", props)
                .addVariant("nether_brick_stone", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("nether_brick_blue"), "Nether Bricks", "Blue");
        lang.addBlock(getVariant("nether_brick_blue_lava"), "Nether Bricks", "Blue Lava");
        lang.addBlock(getVariant("nether_brick_brown"), "Nether Bricks", "Brown");
        lang.addBlock(getVariant("nether_brick_guts"), "Nether Bricks", "Guts");
        lang.addBlock(getVariant("nether_brick_guts_dark"), "Nether Bricks", "Dark Guts");
        lang.addBlock(getVariant("nether_brick_guts_small"), "Nether Bricks", "Small Guts");
        lang.addBlock(getVariant("nether_brick_meat"), "Nether Bricks", "Meat");
        lang.addBlock(getVariant("nether_brick_meat_red"), "Nether Bricks", "Red Meat");
        lang.addBlock(getVariant("nether_brick_meat_small"), "Nether Bricks", "Small Meat");
        lang.addBlock(getVariant("nether_brick_meat_small_red"), "Nether Bricks", "Small Red Meat");
        lang.addBlock(getVariant("nether_brick_obsidian"), "Nether Bricks", "Obsidian");
        lang.addBlock(getVariant("nether_brick_red"), "Nether Bricks", "Red");
        lang.addBlock(getVariant("nether_brick_red_small"), "Nether Bricks", "Small Red");
        lang.addBlock(getVariant("nether_brick_spattered"), "Nether Bricks", "Spattered");
        lang.addBlock(getVariant("nether_brick_stone"), "Nether Bricks", "Stone");
    }
}

