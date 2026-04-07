package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
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
        lang.addBlock(getVariant("voidstone_bevel"), "Voidstone", "Bevel");
        lang.addBlock(getVariant("voidstone_eye"), "Voidstone", "Eye");
        lang.addBlock(getVariant("voidstone_metal"), "Voidstone", "Metal");
        lang.addBlock(getVariant("voidstone_raw"), "Voidstone", "Raw");
        lang.addBlock(getVariant("voidstone_runic"), "Voidstone", "Runic");
        lang.addBlock(getVariant("voidstone_skull"), "Voidstone", "Skull");
        lang.addBlock(getVariant("voidstone_smooth"), "Voidstone", "Smooth");
        lang.addBlock(getVariant("voidstone_tiles"), "Voidstone", "Tiles");
    }
}

