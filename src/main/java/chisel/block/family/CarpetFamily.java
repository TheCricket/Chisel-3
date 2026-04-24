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
        lang.addBlock(getVariant("carpet_black"), "Floor Carpet", "Black Carpet");
        lang.addBlock(getVariant("carpet_brown"), "Floor Carpet", "Brown Carpet");
        lang.addBlock(getVariant("carpet_dark_blue"), "Floor Carpet", "Dark Blue Carpet");
        lang.addBlock(getVariant("carpet_dark_grey"), "Floor Carpet", "Dark Grey Carpet");
        lang.addBlock(getVariant("carpet_green"), "Floor Carpet", "Green Carpet");
        lang.addBlock(getVariant("carpet_grey"), "Floor Carpet", "Grey Carpet");
        lang.addBlock(getVariant("carpet_light_blue"), "Floor Carpet", "Light Blue Carpet");
        lang.addBlock(getVariant("carpet_light_green"), "Floor Carpet", "Light Green Carpet");
        lang.addBlock(getVariant("carpet_magenta"), "Floor Carpet", "Magenta Carpet");
        lang.addBlock(getVariant("carpet_orange"), "Floor Carpet", "Orange Carpet");
        lang.addBlock(getVariant("carpet_pink"), "Floor Carpet", "Pink Carpet");
        lang.addBlock(getVariant("carpet_purple"), "Floor Carpet", "Purple Carpet");
        lang.addBlock(getVariant("carpet_red"), "Floor Carpet", "Red Carpet");
        lang.addBlock(getVariant("carpet_cyan"), "Floor Carpet", "Teal Carpet");
        lang.addBlock(getVariant("carpet_white"), "Floor Carpet", "White Carpet");
        lang.addBlock(getVariant("carpet_yellow"), "Floor Carpet", "Yellow Carpet");
    }
}

