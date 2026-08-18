package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;

public class VoidstoneFamily extends ChiselFamily {
    public VoidstoneFamily(BlockBehaviour.Properties props) {
        family = builder("voidstone")
                .addVariant("voidstone_bevel", props, CONNECTED)
                .addVariant("voidstone_eye", props)
                .addVariant("voidstone_metal", props, CONNECTED)
                .addVariant("voidstone_raw", props)
                .addVariant("voidstone_runic", props)
                .addVariant("voidstone_skull", props)
                .addVariant("voidstone_smooth", props)
                .addVariant("voidstone_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("voidstone_bevel"), "Voidstone", "Beveled Voidstone");
        lang.addBlock(getVariant("voidstone_eye"), "Voidstone", "Eye Voidstone");
        lang.addBlock(getVariant("voidstone_metal"), "Voidstone", "Metal-Bordered Voidstone");
        lang.addBlock(getVariant("voidstone_raw"), "Voidstone", "Raw Voidstone");
        lang.addBlock(getVariant("voidstone_runic"), "Voidstone", "Runic Voidstone");
        lang.addBlock(getVariant("voidstone_skull"), "Voidstone", "Skull Voidstone");
        lang.addBlock(getVariant("voidstone_smooth"), "Voidstone", "Smooth Voidstone");
        lang.addBlock(getVariant("voidstone_tiles"), "Voidstone", "Large Voidstone Tiles");
    }
}

