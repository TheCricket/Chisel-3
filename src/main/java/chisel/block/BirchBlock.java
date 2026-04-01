package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BirchBlock extends ChiselBlock {
    public BirchBlock(BlockBehaviour.Properties props) {
        family = builder("birch_planks")
                .addVariant(Blocks.BIRCH_PLANKS)
                .addVariant("birch_planks_braced", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("birch_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_crude_horizontal", props)
                .addVariant("birch_planks_crude_paneling", props)
                .addVariant("birch_planks_crude_vertical", props)
                .addVariant("birch_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_large", props)
                .addVariant("birch_planks_log_cabin_ew", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_log_cabin_ns", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_paneling", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_stacked", props)
                .addVariant("birch_planks_vertical", props)
                .addVariant("birch_planks_log_bordered", props, VariantModelType.CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("birch_planks_braced"), "Birch Wood Planks", "Braced Planks");
        lang.addBlock(getVariant("birch_planks_braid"), "Birch Wood Planks", "Braid");
        lang.addBlock(getVariant("birch_planks_crude_horizontal"), "Birch Wood Planks", "Crude Horizontal Planks");
        lang.addBlock(getVariant("birch_planks_crude_paneling"), "Birch Wood Planks", "Crude Paneling");
        lang.addBlock(getVariant("birch_planks_crude_vertical"), "Birch Wood Planks", "Crude Vertical Planks");
        lang.addBlock(getVariant("birch_planks_encased"), "Birch Wood Planks", "Encased Planks");
        lang.addBlock(getVariant("birch_planks_encased_large"), "Birch Wood Planks", "Encased Large Planks");
        lang.addBlock(getVariant("birch_planks_encased_smooth"), "Birch Wood Planks", "Encased Smooth");
        lang.addBlock(getVariant("birch_planks_large"), "Birch Wood Planks", "Large Planks");
        lang.addBlock(getVariant("birch_planks_log_cabin_ew"), "Birch Wood Planks", "Log Cabin (EW)");
        lang.addBlock(getVariant("birch_planks_log_cabin_ns"), "Birch Wood Planks", "Log Cabin (NS)");
        lang.addBlock(getVariant("birch_planks_paneling"), "Birch Wood Planks", "Paneling");
        lang.addBlock(getVariant("birch_planks_shipping"), "Birch Wood Planks", "Shipping Crate");
        lang.addBlock(getVariant("birch_planks_smooth"), "Birch Wood Planks", "Smooth");
        lang.addBlock(getVariant("birch_planks_stacked"), "Birch Wood Planks", "Stacked");
        lang.addBlock(getVariant("birch_planks_vertical"), "Birch Wood Planks", "Vertical Planks");
        lang.addBlock(getVariant("birch_planks_log_bordered"), "Birch Wood Planks", "Log Bordered");
    }
}

