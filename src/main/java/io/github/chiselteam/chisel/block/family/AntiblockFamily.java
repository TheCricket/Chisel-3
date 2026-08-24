package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.ANTIBLOCK;

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

