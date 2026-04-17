package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class NetherBrickFamily extends ChiselBlock {
    public NetherBrickFamily(BlockBehaviour.Properties props) {
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
        lang.addBlock(getVariant("nether_brick_blue"), "Nether Brick", "Blue Nether Brick");
        lang.addBlock(getVariant("nether_brick_blue_lava"), "Nether Brick", "Blue Nether Brick with Lava");
        lang.addBlock(getVariant("nether_brick_brown"), "Nether Brick", "Brown Nether Brick");
        lang.addBlock(getVariant("nether_brick_guts"), "Nether Brick", "Nether Brick made of Guts");
        lang.addBlock(getVariant("nether_brick_guts_dark"), "Nether Brick", "Dark Nether Brick made of Guts");
        lang.addBlock(getVariant("nether_brick_guts_small"), "Nether Brick", "Small Nether Brick made of Guts");
        lang.addBlock(getVariant("nether_brick_meat"), "Nether Brick", "Nether Brick made of Meat");
        lang.addBlock(getVariant("nether_brick_meat_red"), "Nether Brick", "Red Nether Brick made of Meat");
        lang.addBlock(getVariant("nether_brick_meat_small"), "Nether Brick", "Small Nether Brick made of Meat");
        lang.addBlock(getVariant("nether_brick_meat_small_red"), "Nether Brick", "Small Red Nether Brick made of Meat");
        lang.addBlock(getVariant("nether_brick_obsidian"), "Nether Brick", "Obsidian Nether Brick");
        lang.addBlock(getVariant("nether_brick_red"), "Nether Brick", "Red Nether Brick");
        lang.addBlock(getVariant("nether_brick_red_small"), "Nether Brick", "Small Red Nether Brick");
        lang.addBlock(getVariant("nether_brick_spattered"), "Nether Brick", "Spattered Nether Brick");
        lang.addBlock(getVariant("nether_brick_stone"), "Nether Brick", "Stone Nether Brick");
    }
}

