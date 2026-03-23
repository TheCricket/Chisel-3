package chisel.block.stone;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class NetherrackBlock extends ChiselBlock {
    public NetherrackBlock(BlockBehaviour.Properties props) {
        

        family = builder("netherrack")
                .addVariant(Blocks.NETHERRACK)
                .addVariant("netherrack_braid", props)
                .addVariant("netherrack_chaotic", props)
                .addVariant("netherrack_cracked", props)
                .addVariant("netherrack_cuts", props)
                .addVariant("netherrack_dent", props)
                .addVariant("netherrack_french", props)
                .addVariant("netherrack_french_2", props)
                .addVariant("netherrack_layers", props)
                .addVariant("netherrack_meat", props)
                .addVariant("netherrack_meat_red", props)
                .addVariant("netherrack_meat_small", props)
                .addVariant("netherrack_red", props)
                .addVariant("netherrack_spattered", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("netherrack_braid"), "Netherrack", "Braid");
        lang.addBlock(getVariant("netherrack_chaotic"), "Netherrack", "Chaotic");
        lang.addBlock(getVariant("netherrack_cracked"), "Netherrack", "Cracked");
        lang.addBlock(getVariant("netherrack_cuts"), "Netherrack", "Cuts");
        lang.addBlock(getVariant("netherrack_dent"), "Netherrack", "Dent");
        lang.addBlock(getVariant("netherrack_french"), "Netherrack", "French");
        lang.addBlock(getVariant("netherrack_french_2"), "Netherrack", "French 2");
        lang.addBlock(getVariant("netherrack_layers"), "Netherrack", "Layers");
        lang.addBlock(getVariant("netherrack_meat"), "Netherrack", "Meat");
        lang.addBlock(getVariant("netherrack_meat_red"), "Netherrack", "Red Meat");
        lang.addBlock(getVariant("netherrack_meat_small"), "Netherrack", "Small Meat");
        lang.addBlock(getVariant("netherrack_red"), "Netherrack", "Red");
        lang.addBlock(getVariant("netherrack_spattered"), "Netherrack", "Spattered");
    }
}

