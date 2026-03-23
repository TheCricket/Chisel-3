package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class PaperwallBlock extends ChiselBlock {
    public PaperwallBlock(BlockBehaviour.Properties props) {
        

        family = builder("paperwall")
                .addVariant("paperwall_boxed", props)
                .addVariant("paperwall_crossed", props)
                .addVariant("paperwall_door", props)
                .addVariant("paperwall_floral", props)
                .addVariant("paperwall_plain", props)
                .addVariant("paperwall_six", props)
                .addVariant("paperwall_strike_horizontal", props)
                .addVariant("paperwall_strike_middle", props)
                .addVariant("paperwall_strike_vertical", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("paperwall_boxed"), "Paperwall", "Boxed");
        lang.addBlock(getVariant("paperwall_crossed"), "Paperwall", "Crossed");
        lang.addBlock(getVariant("paperwall_door"), "Paperwall", "Door");
        lang.addBlock(getVariant("paperwall_floral"), "Paperwall", "Floral");
        lang.addBlock(getVariant("paperwall_plain"), "Paperwall", "Plain");
        lang.addBlock(getVariant("paperwall_six"), "Paperwall", "Six");
        lang.addBlock(getVariant("paperwall_strike_horizontal"), "Paperwall", "Horizontal Strike");
        lang.addBlock(getVariant("paperwall_strike_middle"), "Paperwall", "Middle Strike");
        lang.addBlock(getVariant("paperwall_strike_vertical"), "Paperwall", "Vertical Strike");
    }
}

