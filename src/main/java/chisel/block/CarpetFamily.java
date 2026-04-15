package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CarpetFamily extends ChiselBlock {
    public CarpetFamily(BlockBehaviour.Properties props) {
        family = builder("carpet")
                .addVariant(Blocks.BLACK_CARPET)
                .addVariant("carpet_black", props, VariantModelType.CONNECTED)
                .addVariant("carpet_brown", props, VariantModelType.CONNECTED)
                .addVariant("carpet_dark_blue", props, VariantModelType.CONNECTED)
                .addVariant("carpet_dark_grey", props, VariantModelType.CONNECTED)
                .addVariant("carpet_green", props, VariantModelType.CONNECTED)
                .addVariant("carpet_grey", props, VariantModelType.CONNECTED)
                .addVariant("carpet_light_blue", props, VariantModelType.CONNECTED)
                .addVariant("carpet_light_green", props, VariantModelType.CONNECTED)
                .addVariant("carpet_magenta", props, VariantModelType.CONNECTED)
                .addVariant("carpet_orange", props, VariantModelType.CONNECTED)
                .addVariant("carpet_pink", props, VariantModelType.CONNECTED)
                .addVariant("carpet_purple", props, VariantModelType.CONNECTED)
                .addVariant("carpet_red", props, VariantModelType.CONNECTED)
                .addVariant("carpet_cyan", props, VariantModelType.CONNECTED)
                .addVariant("carpet_white", props, VariantModelType.CONNECTED)
                .addVariant("carpet_yellow", props, VariantModelType.CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("carpet_black"), "Carpet", "Black");
        lang.addBlock(getVariant("carpet_brown"), "Carpet", "Brown");
        lang.addBlock(getVariant("carpet_dark_blue"), "Carpet", "Dark Blue");
        lang.addBlock(getVariant("carpet_dark_grey"), "Carpet", "Dark Grey");
        lang.addBlock(getVariant("carpet_green"), "Carpet", "Green");
        lang.addBlock(getVariant("carpet_grey"), "Carpet", "Grey");
        lang.addBlock(getVariant("carpet_light_blue"), "Carpet", "Light Blue");
        lang.addBlock(getVariant("carpet_light_green"), "Carpet", "Light Green");
        lang.addBlock(getVariant("carpet_magenta"), "Carpet", "Magenta");
        lang.addBlock(getVariant("carpet_orange"), "Carpet", "Orange");
        lang.addBlock(getVariant("carpet_pink"), "Carpet", "Pink");
        lang.addBlock(getVariant("carpet_purple"), "Carpet", "Purple");
        lang.addBlock(getVariant("carpet_red"), "Carpet", "Red");
        lang.addBlock(getVariant("carpet_cyan"), "Carpet", "Cyan");
        lang.addBlock(getVariant("carpet_white"), "Carpet", "White");
        lang.addBlock(getVariant("carpet_yellow"), "Carpet", "Yellow");
    }
}

