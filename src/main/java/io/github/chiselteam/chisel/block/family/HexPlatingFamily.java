package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class HexPlatingFamily extends ChiselFamily {
    public HexPlatingFamily(BlockBehaviour.Properties props) {
        family = builder("hex_plating")
                .addVariant("hex_plating_0", props, MULTI_LAYER)
                .addVariant("hex_plating_1", props, MULTI_LAYER)
                .addVariant("hex_plating_2", props, MULTI_LAYER)
                .addVariant("hex_plating_3", props, MULTI_LAYER)
                .addVariant("hex_plating_4", props, MULTI_LAYER)
                .addVariant("hex_plating_5", props, MULTI_LAYER)
                .addVariant("hex_plating_6", props, MULTI_LAYER)
                .addVariant("hex_plating_7", props, MULTI_LAYER)
                .addVariant("hex_plating_8", props, MULTI_LAYER)
                .addVariant("hex_plating_9", props, MULTI_LAYER)
                .addVariant("hex_plating_10", props, MULTI_LAYER)
                .addVariant("hex_plating_11", props, MULTI_LAYER)
                .addVariant("hex_plating_12", props, MULTI_LAYER)
                .addVariant("hex_plating_13", props, MULTI_LAYER)
                .addVariant("hex_plating_14", props, MULTI_LAYER)
                .addVariant("hex_plating_15", props, MULTI_LAYER)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("hex_plating_0"), "Hex Plating", "White");
        lang.addBlock(getVariant("hex_plating_1"), "Hex Plating", "Orange");
        lang.addBlock(getVariant("hex_plating_2"), "Hex Plating", "Magenta");
        lang.addBlock(getVariant("hex_plating_3"), "Hex Plating", "Light Blue");
        lang.addBlock(getVariant("hex_plating_4"), "Hex Plating", "Yellow");
        lang.addBlock(getVariant("hex_plating_5"), "Hex Plating", "Lime");
        lang.addBlock(getVariant("hex_plating_6"), "Hex Plating", "Pink");
        lang.addBlock(getVariant("hex_plating_7"), "Hex Plating", "Gray");
        lang.addBlock(getVariant("hex_plating_8"), "Hex Plating", "Light Gray");
        lang.addBlock(getVariant("hex_plating_9"), "Hex Plating", "Cyan");
        lang.addBlock(getVariant("hex_plating_10"), "Hex Plating", "Purple");
        lang.addBlock(getVariant("hex_plating_11"), "Hex Plating", "Blue");
        lang.addBlock(getVariant("hex_plating_12"), "Hex Plating", "Brown");
        lang.addBlock(getVariant("hex_plating_13"), "Hex Plating", "Green");
        lang.addBlock(getVariant("hex_plating_14"), "Hex Plating", "Red");
        lang.addBlock(getVariant("hex_plating_15"), "Hex Plating", "Black");
    }
}

