package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class VoidstoneFamily extends ChiselBlock {
    public VoidstoneFamily(BlockBehaviour.Properties props) {
        family = builder("voidstone")
                .addVariant("voidstone_bevel", props, VariantModelType.CONNECTED)
                .addVariant("voidstone_eye", props)
                .addVariant("voidstone_metal", props, VariantModelType.CONNECTED)
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

