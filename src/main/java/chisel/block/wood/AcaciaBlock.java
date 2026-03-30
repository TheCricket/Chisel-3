package chisel.block.wood;

import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class AcaciaBlock extends ChiselBlock {
    public AcaciaBlock(BlockBehaviour.Properties props) {

        family = builder("acacia_planks")
                .addVariant(Blocks.ACACIA_PLANKS)
                .addVariant("acacia_planks_braced", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("acacia_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_crude_horizontal", props)
                .addVariant("acacia_planks_crude_paneling", props)
                .addVariant("acacia_planks_crude_vertical", props)
                .addVariant("acacia_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_large", props)
                .addVariant("acacia_planks_log_cabin", props)
                .addVariant("acacia_planks_paneling", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("acacia_planks_stacked", props)
                .addVariant("acacia_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("acacia_planks_braced"), "Acacia Wood Planks", "Braced Planks");
        lang.addBlock(getVariant("acacia_planks_braid"), "Acacia Wood Planks", "Braid");
        lang.addBlock(getVariant("acacia_planks_crude_horizontal"), "Acacia Wood Planks", "Crude Horizontal Planks");
        lang.addBlock(getVariant("acacia_planks_crude_paneling"), "Acacia Wood Planks", "Crude Paneling");
        lang.addBlock(getVariant("acacia_planks_crude_vertical"), "Acacia Wood Planks", "Crude Vertical Planks");
        lang.addBlock(getVariant("acacia_planks_encased"), "Acacia Wood Planks", "Encased Planks");
        lang.addBlock(getVariant("acacia_planks_encased_large"), "Acacia Wood Planks", "Encased Large Planks");
        lang.addBlock(getVariant("acacia_planks_encased_smooth"), "Acacia Wood Planks", "Encased Smooth");
        lang.addBlock(getVariant("acacia_planks_large"), "Acacia Wood Planks", "Large Planks");
        lang.addBlock(getVariant("acacia_planks_log_cabin"), "Acacia Wood Planks", "Log Cabin");
        lang.addBlock(getVariant("acacia_planks_paneling"), "Acacia Wood Planks", "Paneling");
        lang.addBlock(getVariant("acacia_planks_shipping"), "Acacia Wood Planks", "Shipping Crate");
        lang.addBlock(getVariant("acacia_planks_smooth"), "Acacia Wood Planks", "Smooth");
        lang.addBlock(getVariant("acacia_planks_stacked"), "Acacia Wood Planks", "Stacked");
        lang.addBlock(getVariant("acacia_planks_vertical"), "Acacia Wood Planks", "Vertical Planks");
    }
}
