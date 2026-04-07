package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SpruceFamily extends ChiselBlock {
    public SpruceFamily(BlockBehaviour.Properties props) {
        family = builder("spruce_planks")
                .addVariant(Blocks.SPRUCE_PLANKS)
                .addVariant("spruce_planks_braced", props)
                .addVariant("spruce_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_crude_horizontal", props)
                .addVariant("spruce_planks_crude_paneling", props)
                .addVariant("spruce_planks_crude_vertical", props)
                .addVariant("spruce_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_large", props)
                .addVariant("spruce_planks_log_bordered", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_log_cabin_ew", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_log_cabin_ns", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_paneling", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("spruce_planks_stacked", props)
                .addVariant("spruce_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("spruce_planks_braced"), "Spruce Wood Planks", "Braced Planks");
        lang.addBlock(getVariant("spruce_planks_braid"), "Spruce Wood Planks", "Braid");
        lang.addBlock(getVariant("spruce_planks_crude_horizontal"), "Spruce Wood Planks", "Crude Horizontal Planks");
        lang.addBlock(getVariant("spruce_planks_crude_paneling"), "Spruce Wood Planks", "Crude Paneling");
        lang.addBlock(getVariant("spruce_planks_crude_vertical"), "Spruce Wood Planks", "Crude Vertical Planks");
        lang.addBlock(getVariant("spruce_planks_encased"), "Spruce Wood Planks", "Encased Planks");
        lang.addBlock(getVariant("spruce_planks_encased_large"), "Spruce Wood Planks", "Encased Large Planks");
        lang.addBlock(getVariant("spruce_planks_encased_smooth"), "Spruce Wood Planks", "Encased Smooth");
        lang.addBlock(getVariant("spruce_planks_large"), "Spruce Wood Planks", "Large Planks");
        lang.addBlock(getVariant("spruce_planks_log_bordered"), "Spruce Wood Planks", "Log Bordered");
        lang.addBlock(getVariant("spruce_planks_log_cabin_ew"), "Spruce Wood Planks", "Log Cabin EW");
        lang.addBlock(getVariant("spruce_planks_log_cabin_ns"), "Spruce Wood Planks", "Log Cabin NS");
        lang.addBlock(getVariant("spruce_planks_paneling"), "Spruce Wood Planks", "Paneling");
        lang.addBlock(getVariant("spruce_planks_shipping"), "Spruce Wood Planks", "Shipping Crate");
        lang.addBlock(getVariant("spruce_planks_smooth"), "Spruce Wood Planks", "Smooth");
        lang.addBlock(getVariant("spruce_planks_stacked"), "Spruce Wood Planks", "Stacked");
        lang.addBlock(getVariant("spruce_planks_vertical"), "Spruce Wood Planks", "Vertical Planks");
    }
}

