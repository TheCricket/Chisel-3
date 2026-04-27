package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CarpetFamily extends ChiselFamily {
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
        lang.addBlock(getVariant("carpet_black"), "Carpet", "Black Carpet");
        lang.addBlock(getVariant("carpet_brown"), "Carpet", "Brown Carpet");
        lang.addBlock(getVariant("carpet_dark_blue"), "Carpet", "Dark Blue Carpet");
        lang.addBlock(getVariant("carpet_dark_grey"), "Carpet", "Dark Grey Carpet");
        lang.addBlock(getVariant("carpet_green"), "Carpet", "Green Carpet");
        lang.addBlock(getVariant("carpet_grey"), "Carpet", "Grey Carpet");
        lang.addBlock(getVariant("carpet_light_blue"), "Carpet", "Light Blue Carpet");
        lang.addBlock(getVariant("carpet_light_green"), "Carpet", "Light Green Carpet");
        lang.addBlock(getVariant("carpet_magenta"), "Carpet", "Magenta Carpet");
        lang.addBlock(getVariant("carpet_orange"), "Carpet", "Orange Carpet");
        lang.addBlock(getVariant("carpet_pink"), "Carpet", "Pink Carpet");
        lang.addBlock(getVariant("carpet_purple"), "Carpet", "Purple Carpet");
        lang.addBlock(getVariant("carpet_red"), "Carpet", "Red Carpet");
        lang.addBlock(getVariant("carpet_cyan"), "Carpet", "Teal Carpet");
        lang.addBlock(getVariant("carpet_white"), "Carpet", "White Carpet");
        lang.addBlock(getVariant("carpet_yellow"), "Carpet", "Yellow Carpet");
    }
}

