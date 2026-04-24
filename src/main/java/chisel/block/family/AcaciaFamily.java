package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class AcaciaFamily extends ChiselFamily {
    public AcaciaFamily(BlockBehaviour.Properties props) {
        family = builder("acacia_planks")
                .addVariant(Blocks.ACACIA_PLANKS)
                .addVariant("acacia_planks_braced", props, VariantModelType.CONNECTED_TBS)
                .addVariant("acacia_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_crude_horizontal", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("acacia_planks_crude_paneling", props)
                .addVariant("acacia_planks_crude_vertical", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("acacia_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_large", props)
                .addVariant("acacia_planks_log_bordered", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_log_cabin_ns", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_log_cabin_ew", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_paneling", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_stacked", props)
                .addVariant("acacia_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("acacia_planks_braced"), "Acacia Wood Planks", "Acacia Wood Panel");
        lang.addBlock(getVariant("acacia_planks_braid"), "Acacia Wood Planks", "Acacia Wood Braid");
        lang.addBlock(getVariant("acacia_planks_crude_horizontal"), "Acacia Wood Planks", "Vertical Acacia Wood Planks in Disarray");
        lang.addBlock(getVariant("acacia_planks_crude_paneling"), "Acacia Wood Planks", "Acacia Wood Planks in Disarray");
        lang.addBlock(getVariant("acacia_planks_crude_vertical"), "Acacia Wood Planks", "Vertical Acacia Wood Planks in Disarray");
        lang.addBlock(getVariant("acacia_planks_encased"), "Acacia Wood Planks", "Encased Acacia Wood Panel");
        lang.addBlock(getVariant("acacia_planks_encased_large"), "Acacia Wood Planks", "Large Long Acacia Wood Planks");
        lang.addBlock(getVariant("acacia_planks_encased_smooth"), "Acacia Wood Planks", "Smooth Acacia Wood Planks");
        lang.addBlock(getVariant("acacia_planks_large"), "Acacia Wood Planks", "Large Long Acacia Wood Planks");
        lang.addBlock(getVariant("acacia_planks_log_bordered"), "Acacia Wood Planks", "Log Bordered Acacia Wood Panel");
        lang.addBlock(getVariant("acacia_planks_log_cabin_ns"), "Acacia Wood Planks", "Acacia Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("acacia_planks_log_cabin_ew"), "Acacia Wood Planks", "Acacia Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("acacia_planks_paneling"), "Acacia Wood Planks", "Acacia Wood Panel");
        lang.addBlock(getVariant("acacia_planks_shipping"), "Acacia Wood Planks", "Acacia Wood Crate");
        lang.addBlock(getVariant("acacia_planks_smooth"), "Acacia Wood Planks", "Smooth Acacia Wood Planks");
        lang.addBlock(getVariant("acacia_planks_stacked"), "Acacia Wood Planks", "Stacked Acacia Wood Tiles");
        lang.addBlock(getVariant("acacia_planks_vertical"), "Acacia Wood Planks", "Vertical Acacia Wood Planks");
    }
}
