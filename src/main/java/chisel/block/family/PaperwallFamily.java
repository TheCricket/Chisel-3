package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PaperwallFamily extends ChiselFamily {
    public PaperwallFamily(BlockBehaviour.Properties props) {
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
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("paperwall_boxed"), "Paperwall", "Boxed Paperwall");
        lang.addBlock(getVariant("paperwall_crossed"), "Paperwall", "Crossed Paperwall");
        lang.addBlock(getVariant("paperwall_door"), "Paperwall", "Door Shaped Paperwall");
        lang.addBlock(getVariant("paperwall_floral"), "Paperwall", "Floral Adorned Paperwall");
        lang.addBlock(getVariant("paperwall_plain"), "Paperwall", "Plain Paperwall");
        lang.addBlock(getVariant("paperwall_six"), "Paperwall", "Six Sectioned Paperwall");
        lang.addBlock(getVariant("paperwall_strike_horizontal"), "Paperwall", "Horizontally Striked Paperwall");
        lang.addBlock(getVariant("paperwall_strike_middle"), "Paperwall", "Middle Striked Paperwall");
        lang.addBlock(getVariant("paperwall_strike_vertical"), "Paperwall", "Vertically Striked Paperwall");
    }
}

