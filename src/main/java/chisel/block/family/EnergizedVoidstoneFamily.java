package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EnergizedVoidstoneFamily extends ChiselFamily {
    public EnergizedVoidstoneFamily(BlockBehaviour.Properties props) {
        family = builder("energized_voidstone")
                .addVariant("energized_voidstone_bevel", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("energized_voidstone_eye", props, VariantModelType.MULTI_LAYER)
                .addVariant("energized_voidstone_metal", props, VariantModelType.MULTI_LAYER_CONNECTED_GLOW)
                .addVariant("energized_voidstone_raw", props, VariantModelType.MULTI_LAYER)
                .addVariant("energized_voidstone_runic", props, VariantModelType.MULTI_LAYER)
                .addVariant("energized_voidstone_skull", props, VariantModelType.MULTI_LAYER)
                .addVariant("energized_voidstone_smooth", props, VariantModelType.MULTI_LAYER)
                .addVariant("energized_voidstone_tiles", props, VariantModelType.MULTI_LAYER)
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