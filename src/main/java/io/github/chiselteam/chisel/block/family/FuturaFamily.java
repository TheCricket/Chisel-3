package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.MULTI_LAYER;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.MULTI_LAYER_CONNECTED_GLOW;

public class FuturaFamily extends ChiselFamily {
    public FuturaFamily(BlockBehaviour.Properties props) {
        family = builder("futura")
                .addVariant("futura_controller", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("futura_controller_purple", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("futura_rainbow", props, MULTI_LAYER)
                .addVariant("futura_rainbow_orange", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("futura_screen_cyan", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("futura_screen_gray", props, MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("futura_matrix", props)
                .addVariant("futura_matrix_purple", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("futura_controller"), "Futura Block", "Applied Labyrinthic Neon Lines");
        lang.addBlock(getVariant("futura_controller_purple"), "Futura Block", "Applied Labyrinthic Neon Lines");
        lang.addBlock(getVariant("futura_rainbow"), "Futura Block", "Poptart Rainbow Screen");
        lang.addBlock(getVariant("futura_rainbow_orange"), "Futura Block", "Poptart Rainbow Screen");
        lang.addBlock(getVariant("futura_screen_cyan"), "Futura Block", "Glowing Screen with Cyan Borders");
        lang.addBlock(getVariant("futura_screen_gray"), "Futura Block", "Glowing Screen with Metallic Borders");
        lang.addBlock(getVariant("futura_matrix"), "Futura Block", "Matrix");
        lang.addBlock(getVariant("futura_matrix_purple"), "Futura Block", "Matrix");
    }
}