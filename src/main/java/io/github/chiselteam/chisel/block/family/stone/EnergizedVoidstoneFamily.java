package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.MULTI_LAYER;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW;

public class EnergizedVoidstoneFamily extends ChiselFamily {
    public EnergizedVoidstoneFamily(BlockBehaviour.Properties props) {
        family = builder("energized_voidstone")
                .addVariant("energized_voidstone_bevel", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("energized_voidstone_eye", props, MULTI_LAYER)
                .addVariant("energized_voidstone_metal", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("energized_voidstone_raw", props, MULTI_LAYER)
                .addVariant("energized_voidstone_runic", props, MULTI_LAYER)
                .addVariant("energized_voidstone_skull", props, MULTI_LAYER)
                .addVariant("energized_voidstone_smooth", props, MULTI_LAYER)
                .addVariant("energized_voidstone_tiles", props, MULTI_LAYER)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("energized_voidstone_bevel"), "Energized Voidstone", "Beveled Voidstone");
        lang.addBlock(getVariant("energized_voidstone_eye"), "Energized Voidstone", "Eye Energized Voidstone");
        lang.addBlock(getVariant("energized_voidstone_metal"), "Energized Voidstone", "Metal-Bordered Energized Voidstone");
        lang.addBlock(getVariant("energized_voidstone_raw"), "Energized Voidstone", "Raw Energized Voidstone");
        lang.addBlock(getVariant("energized_voidstone_runic"), "Energized Voidstone", "Runic Energized Voidstone");
        lang.addBlock(getVariant("energized_voidstone_skull"), "Energized Voidstone", "Skull Energized Voidstone");
        lang.addBlock(getVariant("energized_voidstone_smooth"), "Energized Voidstone", "Smooth Energized Voidstone");
        lang.addBlock(getVariant("energized_voidstone_tiles"), "Energized Voidstone", "Large Energized Voidstone Tiles");
    }
}