package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TyrianBlock extends ChiselBlock {
    public TyrianBlock(BlockBehaviour.Properties props) {
        family = builder("tyrian")
                .addVariant("tyrian_black", props)
                .addVariant("tyrian_black_tiles", props)
                .addVariant("tyrian_bleak", props)
                .addVariant("tyrian_blue", props)
                .addVariant("tyrian_dent", props)
                .addVariant("tyrian_diagonal", props)
                .addVariant("tyrian_elaborate", props)
                .addVariant("tyrian_normal", props)
                .addVariant("tyrian_opening", props)
                .addVariant("tyrian_platform", props)
                .addVariant("tyrian_purple", props)
                .addVariant("tyrian_purple_faded", props)
                .addVariant("tyrian_rusted", props)
                .addVariant("tyrian_seams", props)
                .addVariant("tyrian_shiny", props, VariantModelType.CONNECTED)
                .addVariant("tyrian_shiny_raw", props)
                .addVariant("tyrian_tiles", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("tyrian_black"), "Tyrian", "Black");
        lang.addBlock(getVariant("tyrian_black_tiles"), "Tyrian", "Black Tiles");
        lang.addBlock(getVariant("tyrian_bleak"), "Tyrian", "Bleak");
        lang.addBlock(getVariant("tyrian_blue"), "Tyrian", "Blue");
        lang.addBlock(getVariant("tyrian_dent"), "Tyrian", "Dent");
        lang.addBlock(getVariant("tyrian_diagonal"), "Tyrian", "Diagonal");
        lang.addBlock(getVariant("tyrian_elaborate"), "Tyrian", "Elaborate");
        lang.addBlock(getVariant("tyrian_normal"), "Tyrian", "Normal");
        lang.addBlock(getVariant("tyrian_opening"), "Tyrian", "Opening");
        lang.addBlock(getVariant("tyrian_platform"), "Tyrian", "Platform");
        lang.addBlock(getVariant("tyrian_purple"), "Tyrian", "Purple");
        lang.addBlock(getVariant("tyrian_purple_faded"), "Tyrian", "Faded Purple");
        lang.addBlock(getVariant("tyrian_rusted"), "Tyrian", "Rusted");
        lang.addBlock(getVariant("tyrian_seams"), "Tyrian", "Seams");
        lang.addBlock(getVariant("tyrian_shiny"), "Tyrian", "Shiny");
        lang.addBlock(getVariant("tyrian_shiny_raw"), "Tyrian", "Shiny Raw");
        lang.addBlock(getVariant("tyrian_tiles"), "Tyrian", "Tiles");
    }
}

