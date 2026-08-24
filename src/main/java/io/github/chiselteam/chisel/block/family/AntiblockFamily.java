package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;


public class AntiblockFamily extends ChiselFamily {
    public AntiblockFamily(BlockBehaviour.Properties props) {
        family = builder("antiblock")
                .addVariant("antiblock_black", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_blue", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_brown", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_cyan", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_gray", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_green", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_light_blue", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_light_gray", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_lime", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_magenta", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_orange", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_pink", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_purple", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_red", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_white", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_yellow", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_black_borderless", props)
                .addVariant("antiblock_blue_borderless", props)
                .addVariant("antiblock_brown_borderless", props)
                .addVariant("antiblock_cyan_borderless", props)
                .addVariant("antiblock_gray_borderless", props)
                .addVariant("antiblock_green_borderless", props)
                .addVariant("antiblock_light_blue_borderless", props)
                .addVariant("antiblock_light_gray_borderless", props)
                .addVariant("antiblock_lime_borderless", props)
                .addVariant("antiblock_magenta_borderless", props)
                .addVariant("antiblock_orange_borderless", props)
                .addVariant("antiblock_pink_borderless", props)
                .addVariant("antiblock_purple_borderless", props)
                .addVariant("antiblock_red_borderless", props)
                .addVariant("antiblock_white_borderless", props)
                .addVariant("antiblock_yellow_borderless", props)
                .addVariant("antiblock_white_bright", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_black_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_blue_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_brown_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_cyan_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_gray_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_green_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_light_blue_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_light_gray_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_lime_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_magenta_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_orange_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_pink_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_purple_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_red_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_white_bright_borderless", props, SHADELESS)
                .addVariant("antiblock_yellow_bright_borderless", props, SHADELESS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("antiblock_black"), "Antiblock", "Black Anti Block");
        lang.addBlock(getVariant("antiblock_blue"), "Antiblock", "Blue Anti Block");
        lang.addBlock(getVariant("antiblock_brown"), "Antiblock", "Brown Anti Block");
        lang.addBlock(getVariant("antiblock_cyan"), "Antiblock", "Cyan Anti Block");
        lang.addBlock(getVariant("antiblock_gray"), "Antiblock", "Gray Anti Block");
        lang.addBlock(getVariant("antiblock_green"), "Antiblock", "Green Anti Block");
        lang.addBlock(getVariant("antiblock_light_blue"), "Antiblock", "Light Blue Anti Block");
        lang.addBlock(getVariant("antiblock_light_gray"), "Antiblock", "Light Gray Anti Block");
        lang.addBlock(getVariant("antiblock_lime"), "Antiblock", "Lime Anti Block");
        lang.addBlock(getVariant("antiblock_magenta"), "Antiblock", "Magenta Anti Block");
        lang.addBlock(getVariant("antiblock_orange"), "Antiblock", "Orange Anti Block");
        lang.addBlock(getVariant("antiblock_pink"), "Antiblock", "Pink Anti Block");
        lang.addBlock(getVariant("antiblock_purple"), "Antiblock", "Purple Anti Block");
        lang.addBlock(getVariant("antiblock_red"), "Antiblock", "Red Anti Block");
        lang.addBlock(getVariant("antiblock_white"), "Antiblock", "White Anti Block");
        lang.addBlock(getVariant("antiblock_yellow"), "Antiblock", "Yellow Anti Block");
        lang.addBlock(getVariant("antiblock_black_borderless"), "Antiblock", "Black Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_blue_borderless"), "Antiblock", "Blue Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_brown_borderless"), "Antiblock", "Brown Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_cyan_borderless"), "Antiblock", "Cyan Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_gray_borderless"), "Antiblock", "Gray Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_green_borderless"), "Antiblock", "Green Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_light_blue_borderless"), "Antiblock", "Light Blue Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_light_gray_borderless"), "Antiblock", "Light Gray Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_lime_borderless"), "Antiblock", "Lime Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_magenta_borderless"), "Antiblock", "Magenta Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_orange_borderless"), "Antiblock", "Orange Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_pink_borderless"), "Antiblock", "Pink Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_purple_borderless"), "Antiblock", "Purple Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_red_borderless"), "Antiblock", "Red Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_white_borderless"), "Antiblock", "White Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_yellow_borderless"), "Antiblock", "Yellow Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_white_bright"), "Antiblock", "White Bright Anti Block");
        lang.addBlock(getVariant("antiblock_black_bright_borderless"), "Antiblock", "Black Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_blue_bright_borderless"), "Antiblock", "Blue Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_brown_bright_borderless"), "Antiblock", "Brown Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_cyan_bright_borderless"), "Antiblock", "Cyan Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_gray_bright_borderless"), "Antiblock", "Gray Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_green_bright_borderless"), "Antiblock", "Green Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_light_blue_bright_borderless"), "Antiblock", "Light Blue Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_light_gray_bright_borderless"), "Antiblock", "Light Gray Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_lime_bright_borderless"), "Antiblock", "Lime Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_magenta_bright_borderless"), "Antiblock", "Magenta Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_orange_bright_borderless"), "Antiblock", "Orange Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_pink_bright_borderless"), "Antiblock", "Pink Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_purple_bright_borderless"), "Antiblock", "Purple Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_red_bright_borderless"), "Antiblock", "Red Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_white_bright_borderless"), "Antiblock", "White Bright Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_yellow_bright_borderless"), "Antiblock", "Yellow Bright Borderless Anti Block");
    }
}

