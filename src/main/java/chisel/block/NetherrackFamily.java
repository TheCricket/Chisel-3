package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class NetherrackFamily extends ChiselBlock {
    public NetherrackFamily(BlockBehaviour.Properties props) {
        family = builder("netherrack")
                .addVariant(Blocks.NETHERRACK)
                .addVariant("netherrack_blood", props)
                .addVariant("netherrack_blood_dark", props)
                .addVariant("netherrack_blood_gravel", props)
                .addVariant("netherrack_blue", props)
                .addVariant("netherrack_blue_shale", props)
                .addVariant("netherrack_classic", props)
                .addVariant("netherrack_guts", props)
                .addVariant("netherrack_guts_dark", props)
                .addVariant("netherrack_lava", props)
                .addVariant("netherrack_meat", props)
                .addVariant("netherrack_meat_red", props)
                .addVariant("netherrack_meat_small", props)
                .addVariant("netherrack_red", props)
                .addVariant("netherrack_spattered", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("netherrack_blood"), "Netherrack", "Netherrack with Blood");
        lang.addBlock(getVariant("netherrack_blood_dark"), "Netherrack", "Darker Netherrack with Blood");
        lang.addBlock(getVariant("netherrack_blood_gravel"), "Netherrack", "Nethergravel with Blood");
        lang.addBlock(getVariant("netherrack_blue"), "Netherrack", "Blue Netherrack");
        lang.addBlock(getVariant("netherrack_blue_shale"), "Netherrack", "Shale Blue Netherrack");
        lang.addBlock(getVariant("netherrack_classic"), "Netherrack", "Classic Netherrack");
        lang.addBlock(getVariant("netherrack_guts"), "Netherrack", "Netherrack made of Guts");
        lang.addBlock(getVariant("netherrack_guts_dark"), "Netherrack", "Dark Netherrack made of Guts");
        lang.addBlock(getVariant("netherrack_lava"), "Netherrack", "Netherrack with Flowing Lava");
        lang.addBlock(getVariant("netherrack_meat"), "Netherrack", "Netherrack made of Meat");
        lang.addBlock(getVariant("netherrack_meat_red"), "Netherrack", "Red Netherrack made of Meat");
        lang.addBlock(getVariant("netherrack_meat_small"), "Netherrack", "Netherrack made of Smaller Meat Chunks");
        lang.addBlock(getVariant("netherrack_red"), "Netherrack", "Dark Red Netherrack");
        lang.addBlock(getVariant("netherrack_spattered"), "Netherrack", "Spattered Netherrack");
    }
}

