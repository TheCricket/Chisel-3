package chisel.block.metal;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class HexPlatingBlock extends ChiselBlock {
    public HexPlatingBlock(BlockBehaviour.Properties props) {
        

        family = builder("hex_plating")
                .addVariant("hex_plating_0", props)
                .addVariant("hex_plating_1", props)
                .addVariant("hex_plating_2", props)
                .addVariant("hex_plating_3", props)
                .addVariant("hex_plating_4", props)
                .addVariant("hex_plating_5", props)
                .addVariant("hex_plating_6", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("hex_plating_0"), "Hex Plating", "Type 0");
        lang.addBlock(getVariant("hex_plating_1"), "Hex Plating", "Type 1");
        lang.addBlock(getVariant("hex_plating_2"), "Hex Plating", "Type 2");
        lang.addBlock(getVariant("hex_plating_3"), "Hex Plating", "Type 3");
        lang.addBlock(getVariant("hex_plating_4"), "Hex Plating", "Type 4");
        lang.addBlock(getVariant("hex_plating_5"), "Hex Plating", "Type 5");
        lang.addBlock(getVariant("hex_plating_6"), "Hex Plating", "Type 6");
    }
}

