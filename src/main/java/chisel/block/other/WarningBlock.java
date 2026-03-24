package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class WarningBlock extends ChiselBlock {
    public WarningBlock(BlockBehaviour.Properties props) {
        

        family = builder("warning")
                .addVariant("warning_caution", props)
                .addVariant("warning_caution_black", props)
                .addVariant("warning_hazard", props)
                .addVariant("warning_hazard_black", props)
                .addVariant("warning_hazard_orange", props)
                .addVariant("warning_hazard_yellow", props)
                .addVariant("warning_stripes", props)
                .addVariant("warning_stripes_black", props)
                .addVariant("warning_stripes_red", props)
                .addVariant("warning_stripes_yellow", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("warning_caution"), "Warning Block", "Caution");
        lang.addBlock(getVariant("warning_caution_black"), "Warning Block", "Black Caution");
        lang.addBlock(getVariant("warning_hazard"), "Warning Block", "Hazard");
        lang.addBlock(getVariant("warning_hazard_black"), "Warning Block", "Black Hazard");
        lang.addBlock(getVariant("warning_hazard_orange"), "Warning Block", "Orange Hazard");
        lang.addBlock(getVariant("warning_hazard_yellow"), "Warning Block", "Yellow Hazard");
        lang.addBlock(getVariant("warning_stripes"), "Warning Block", "Stripes");
        lang.addBlock(getVariant("warning_stripes_black"), "Warning Block", "Black Stripes");
        lang.addBlock(getVariant("warning_stripes_red"), "Warning Block", "Red Stripes");
        lang.addBlock(getVariant("warning_stripes_yellow"), "Warning Block", "Yellow Stripes");
    }
}

