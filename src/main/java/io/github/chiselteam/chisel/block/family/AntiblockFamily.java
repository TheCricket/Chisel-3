package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class AntiblockFamily extends ChiselFamily {
    public AntiblockFamily(BlockBehaviour.Properties props) {
        family = builder("antiblock")
                .addVariant("antiblock_black", props, ANTIBLOCK)
                .addVariant("antiblock_blue", props, ANTIBLOCK)
                .addVariant("antiblock_brown", props, ANTIBLOCK)
                .addVariant("antiblock_cyan", props, ANTIBLOCK)
                .addVariant("antiblock_gray", props, ANTIBLOCK)
                .addVariant("antiblock_green", props, ANTIBLOCK)
                .addVariant("antiblock_light_blue", props, ANTIBLOCK)
                .addVariant("antiblock_light_gray", props, ANTIBLOCK)
                .addVariant("antiblock_lime", props, ANTIBLOCK)
                .addVariant("antiblock_magenta", props, ANTIBLOCK)
                .addVariant("antiblock_orange", props, ANTIBLOCK)
                .addVariant("antiblock_pink", props, ANTIBLOCK)
                .addVariant("antiblock_purple", props, ANTIBLOCK)
                .addVariant("antiblock_red", props, ANTIBLOCK)
                .addVariant("antiblock_white", props, ANTIBLOCK)
                .addVariant("antiblock_yellow", props, ANTIBLOCK)
                // .addVariant("antiblock_black_borderless", props, SHADELESS)
                // .addVariant("antiblock_blue_borderless", props, SHADELESS)
                // .addVariant("antiblock_brown_borderless", props, SHADELESS)
                // .addVariant("antiblock_cyan_borderless", props, SHADELESS)
                // .addVariant("antiblock_gray_borderless", props, SHADELESS)
                // .addVariant("antiblock_green_borderless", props, SHADELESS)
                // .addVariant("antiblock_light_blue_borderless", props, SHADELESS)
                // .addVariant("antiblock_light_gray_borderless", props, SHADELESS)
                // .addVariant("antiblock_lime_borderless", props, SHADELESS)
                // .addVariant("antiblock_magenta_borderless", props, SHADELESS)
                // .addVariant("antiblock_orange_borderless", props, SHADELESS)
                // .addVariant("antiblock_pink_borderless", props, SHADELESS)
                // .addVariant("antiblock_purple_borderless", props, SHADELESS)
                // .addVariant("antiblock_red_borderless", props, SHADELESS)
                // .addVariant("antiblock_white_borderless", props, SHADELESS)
                // .addVariant("antiblock_yellow_borderless", props, SHADELESS)
                .addVariant("antiblock_black_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_blue_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_brown_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_cyan_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_gray_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_green_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_light_blue_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_light_gray_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_lime_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_magenta_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_orange_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_pink_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_purple_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_red_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_white_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_yellow_dull", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_black_dull_borderless", props)
                .addVariant("antiblock_blue_dull_borderless", props)
                .addVariant("antiblock_brown_dull_borderless", props)
                .addVariant("antiblock_cyan_dull_borderless", props)
                .addVariant("antiblock_gray_dull_borderless", props)
                .addVariant("antiblock_green_dull_borderless", props)
                .addVariant("antiblock_light_blue_dull_borderless", props)
                .addVariant("antiblock_light_gray_dull_borderless", props)
                .addVariant("antiblock_lime_dull_borderless", props)
                .addVariant("antiblock_magenta_dull_borderless", props)
                .addVariant("antiblock_orange_dull_borderless", props)
                .addVariant("antiblock_pink_dull_borderless", props)
                .addVariant("antiblock_purple_dull_borderless", props)
                .addVariant("antiblock_red_dull_borderless", props)
                .addVariant("antiblock_white_dull_borderless", props)
                .addVariant("antiblock_yellow_dull_borderless", props)
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
        // lang.addBlock(getVariant("antiblock_black_borderless"), "Antiblock", "Black Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_blue_borderless"), "Antiblock", "Blue Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_brown_borderless"), "Antiblock", "Brown Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_cyan_borderless"), "Antiblock", "Cyan Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_gray_borderless"), "Antiblock", "Gray Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_green_borderless"), "Antiblock", "Green Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_light_blue_borderless"), "Antiblock", "Light Blue Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_light_gray_borderless"), "Antiblock", "Light Gray Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_lime_borderless"), "Antiblock", "Lime Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_magenta_borderless"), "Antiblock", "Magenta Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_orange_borderless"), "Antiblock", "Orange Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_pink_borderless"), "Antiblock", "Pink Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_purple_borderless"), "Antiblock", "Purple Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_red_borderless"), "Antiblock", "Red Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_white_borderless"), "Antiblock", "White Borderless Anti Block");
        // lang.addBlock(getVariant("antiblock_yellow_borderless"), "Antiblock", "Yellow Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_black_dull"), "Antiblock", "Black Dull Anti Block");
        lang.addBlock(getVariant("antiblock_blue_dull"), "Antiblock", "Blue Dull Anti Block");
        lang.addBlock(getVariant("antiblock_brown_dull"), "Antiblock", "Brown Dull Anti Block");
        lang.addBlock(getVariant("antiblock_cyan_dull"), "Antiblock", "Cyan Dull Anti Block");
        lang.addBlock(getVariant("antiblock_gray_dull"), "Antiblock", "Gray Dull Anti Block");
        lang.addBlock(getVariant("antiblock_green_dull"), "Antiblock", "Green Dull Anti Block");
        lang.addBlock(getVariant("antiblock_light_blue_dull"), "Antiblock", "Light Blue Dull Anti Block");
        lang.addBlock(getVariant("antiblock_light_gray_dull"), "Antiblock", "Light Gray Dull Anti Block");
        lang.addBlock(getVariant("antiblock_lime_dull"), "Antiblock", "Lime Dull Anti Block");
        lang.addBlock(getVariant("antiblock_magenta_dull"), "Antiblock", "Magenta Dull Anti Block");
        lang.addBlock(getVariant("antiblock_orange_dull"), "Antiblock", "Orange Dull Anti Block");
        lang.addBlock(getVariant("antiblock_pink_dull"), "Antiblock", "Pink Dull Anti Block");
        lang.addBlock(getVariant("antiblock_purple_dull"), "Antiblock", "Purple Dull Anti Block");
        lang.addBlock(getVariant("antiblock_red_dull"), "Antiblock", "Red Dull Anti Block");
        lang.addBlock(getVariant("antiblock_white_dull"), "Antiblock", "White Dull Anti Block"); 
        lang.addBlock(getVariant("antiblock_yellow_dull"), "Antiblock", "Yellow Dull Anti Block");
        lang.addBlock(getVariant("antiblock_black_dull_borderless"), "Antiblock", "Black Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_blue_dull_borderless"), "Antiblock", "Blue Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_brown_dull_borderless"), "Antiblock", "Brown Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_cyan_dull_borderless"), "Antiblock", "Cyan Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_gray_dull_borderless"), "Antiblock", "Gray Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_green_dull_borderless"), "Antiblock", "Green Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_light_blue_dull_borderless"), "Antiblock", "Light Blue Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_light_gray_dull_borderless"), "Antiblock", "Light Gray Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_lime_dull_borderless"), "Antiblock", "Lime Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_magenta_dull_borderless"), "Antiblock", "Magenta Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_orange_dull_borderless"), "Antiblock", "Orange Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_pink_dull_borderless"), "Antiblock", "Pink Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_purple_dull_borderless"), "Antiblock", "Purple Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_red_dull_borderless"), "Antiblock", "Red Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_white_dull_borderless"), "Antiblock", "White Dull Borderless Anti Block");
        lang.addBlock(getVariant("antiblock_yellow_dull_borderless"), "Antiblock", "Yellow Dull Borderless Anti Block");
    }
}

