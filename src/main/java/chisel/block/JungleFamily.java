package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class JungleFamily extends ChiselBlock {
    public JungleFamily(BlockBehaviour.Properties props) {
        family = builder("jungle_planks")
                .addVariant(Blocks.JUNGLE_PLANKS)
                .addVariant("jungle_planks_braced", props)
                .addVariant("jungle_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_crude_horizontal", props)
                .addVariant("jungle_planks_crude_paneling", props)
                .addVariant("jungle_planks_crude_vertical", props)
                .addVariant("jungle_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_large", props)
                .addVariant("jungle_planks_log_bordered", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_log_cabin_ns", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_log_cabin_ew", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_paneling", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_stacked", props)
                .addVariant("jungle_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("jungle_planks_braced"), "Jungle Wood Planks", "Braced Planks");
        lang.addBlock(getVariant("jungle_planks_braid"), "Jungle Wood Planks", "Braid");
        lang.addBlock(getVariant("jungle_planks_crude_horizontal"), "Jungle Wood Planks", "Crude Horizontal Planks");
        lang.addBlock(getVariant("jungle_planks_crude_paneling"), "Jungle Wood Planks", "Crude Paneling");
        lang.addBlock(getVariant("jungle_planks_crude_vertical"), "Jungle Wood Planks", "Crude Vertical Planks");
        lang.addBlock(getVariant("jungle_planks_encased"), "Jungle Wood Planks", "Encased Planks");
        lang.addBlock(getVariant("jungle_planks_encased_large"), "Jungle Wood Planks", "Encased Large Planks");
        lang.addBlock(getVariant("jungle_planks_encased_smooth"), "Jungle Wood Planks", "Encased Smooth");
        lang.addBlock(getVariant("jungle_planks_large"), "Jungle Wood Planks", "Large Planks");
        lang.addBlock(getVariant("jungle_planks_log_bordered"), "Jungle Wood Planks", "Log Bordered");
        lang.addBlock(getVariant("jungle_planks_log_cabin_ns"), "Jungle Wood Planks", "Log Cabin NS");
        lang.addBlock(getVariant("jungle_planks_log_cabin_ew"), "Jungle Wood Planks", "Log Cabin EW");
        lang.addBlock(getVariant("jungle_planks_paneling"), "Jungle Wood Planks", "Paneling");
        lang.addBlock(getVariant("jungle_planks_shipping"), "Jungle Wood Planks", "Shipping Crate");
        lang.addBlock(getVariant("jungle_planks_smooth"), "Jungle Wood Planks", "Smooth");
        lang.addBlock(getVariant("jungle_planks_stacked"), "Jungle Wood Planks", "Stacked");
        lang.addBlock(getVariant("jungle_planks_vertical"), "Jungle Wood Planks", "Vertical Planks");
    }
}

