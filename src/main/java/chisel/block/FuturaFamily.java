package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FuturaFamily extends ChiselBlock {
    public FuturaFamily(BlockBehaviour.Properties props) {
        family = builder("futura")
                .addVariant("futura_controller", props, VariantModelType.MULTI_LAYER)
                .addVariant("futura_controller_purple", props, VariantModelType.MULTI_LAYER)
                .addVariant("futura_rainbow", props, VariantModelType.MULTI_LAYER)
                .addVariant("futura_screen_cyan", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("futura_screen_gray", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("futura_controller"), "Futura Block", "Applied Labyrinthic Neon Lines");
        lang.addBlock(getVariant("futura_controller_purple"), "Futura Block", "Applied Labyrinthic Neon Lines");
        lang.addBlock(getVariant("futura_rainbow"), "Futura Block", "Poptart Rainbow Screen");
        lang.addBlock(getVariant("futura_screen_cyan"), "Futura Block", "Glowing Screen with Cyan Borders");
        lang.addBlock(getVariant("futura_screen_gray"), "Futura Block", "Glowing Screen with Metallic Borders");
    }
}