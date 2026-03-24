package chisel.block.metal;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class FuturaBlock extends ChiselBlock {
    public FuturaBlock(BlockBehaviour.Properties props) {
        

        family = builder("futura")
                .addVariant("futura_circuit", props)
                .addVariant("futura_controller", props)
                .addVariant("futura_dots", props)
                .addVariant("futura_screen_blue", props)
                .addVariant("futura_screen_gray", props)
                .addVariant("futura_screen_green", props)
                .addVariant("futura_screen_orange", props)
                .addVariant("futura_screen_red", props)
                .addVariant("futura_wavy", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("futura_circuit"), "Futura", "Circuit");
        lang.addBlock(getVariant("futura_controller"), "Futura", "Controller");
        lang.addBlock(getVariant("futura_dots"), "Futura", "Dots");
        lang.addBlock(getVariant("futura_screen_blue"), "Futura", "Blue Screen");
        lang.addBlock(getVariant("futura_screen_gray"), "Futura", "Gray Screen");
        lang.addBlock(getVariant("futura_screen_green"), "Futura", "Green Screen");
        lang.addBlock(getVariant("futura_screen_orange"), "Futura", "Orange Screen");
        lang.addBlock(getVariant("futura_screen_red"), "Futura", "Red Screen");
        lang.addBlock(getVariant("futura_wavy"), "Futura", "Wavy");
    }
}

