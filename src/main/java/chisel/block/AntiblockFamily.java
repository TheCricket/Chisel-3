package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class AntiblockFamily extends ChiselBlock {
    public AntiblockFamily(BlockBehaviour.Properties props) {
        family = builder("antiblock")
                .addVariant("antiblock_black", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_blue", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_brown", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_cyan", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_gray", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_green", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_light_blue", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_light_gray", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_lime", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_magenta", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_orange", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_pink", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_purple", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_red", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_white", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("antiblock_yellow", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
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
    }
}

