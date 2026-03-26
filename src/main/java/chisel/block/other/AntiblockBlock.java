package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class AntiblockBlock extends ChiselBlock {
    public AntiblockBlock(BlockBehaviour.Properties props) {
        

        family = builder("antiblock")
                .addVariant("antiblock_black", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_blue", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_brown", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_cyan", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_gray", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_green", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_light_blue", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_light_gray", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_lime", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_magenta", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_orange", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_pink", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_purple", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_red", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_white", props, VariantModelType.MULTI_LAYER)
                .addVariant("antiblock_yellow", props, VariantModelType.MULTI_LAYER)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("antiblock_black"), "Antiblock", "Black");
        lang.addBlock(getVariant("antiblock_blue"), "Antiblock", "Blue");
        lang.addBlock(getVariant("antiblock_brown"), "Antiblock", "Brown");
        lang.addBlock(getVariant("antiblock_cyan"), "Antiblock", "Cyan");
        lang.addBlock(getVariant("antiblock_gray"), "Antiblock", "Gray");
        lang.addBlock(getVariant("antiblock_green"), "Antiblock", "Green");
        lang.addBlock(getVariant("antiblock_light_blue"), "Antiblock", "Light Blue");
        lang.addBlock(getVariant("antiblock_light_gray"), "Antiblock", "Light Gray");
        lang.addBlock(getVariant("antiblock_lime"), "Antiblock", "Lime");
        lang.addBlock(getVariant("antiblock_magenta"), "Antiblock", "Magenta");
        lang.addBlock(getVariant("antiblock_orange"), "Antiblock", "Orange");
        lang.addBlock(getVariant("antiblock_pink"), "Antiblock", "Pink");
        lang.addBlock(getVariant("antiblock_purple"), "Antiblock", "Purple");
        lang.addBlock(getVariant("antiblock_red"), "Antiblock", "Red");
        lang.addBlock(getVariant("antiblock_white"), "Antiblock", "White");
        lang.addBlock(getVariant("antiblock_yellow"), "Antiblock", "Yellow");
    }
}

