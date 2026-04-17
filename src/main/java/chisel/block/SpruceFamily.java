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
                .addVariant("spruce_planks_crude_horizontal", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("spruce_planks_crude_paneling", props)
                .addVariant("spruce_planks_crude_vertical", props, VariantModelType.MULTIBLOCK_3X3)
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
        lang.addBlock(getVariant("spruce_planks_braced"), "Spruce Wood Planks", "Spruce Wood Panel");
        lang.addBlock(getVariant("spruce_planks_braid"), "Spruce Wood Planks", "Spruce Wood Braid");
        lang.addBlock(getVariant("spruce_planks_crude_horizontal"), "Spruce Wood Planks", "Vertical Spruce Wood Planks in Disarray");
        lang.addBlock(getVariant("spruce_planks_crude_paneling"), "Spruce Wood Planks", "Spruce Wood Planks in Disarray");
        lang.addBlock(getVariant("spruce_planks_crude_vertical"), "Spruce Wood Planks", "Vertical Spruce Wood Planks in Disarray");
        lang.addBlock(getVariant("spruce_planks_encased"), "Spruce Wood Planks", "Encased Spruce Wood Panel");
        lang.addBlock(getVariant("spruce_planks_encased_large"), "Spruce Wood Planks", "Large Long Spruce Wood Planks");
        lang.addBlock(getVariant("spruce_planks_encased_smooth"), " Spruce Wood Planks", "Smooth Spruce Wood Planks");
        lang.addBlock(getVariant("spruce_planks_large"), "Spruce Wood Planks", "Large Long Spruce Wood Planks");
        lang.addBlock(getVariant("spruce_planks_log_bordered"), "Spruce Wood Planks", "Log Bordered Spruce Wood Panel");
        lang.addBlock(getVariant("spruce_planks_log_cabin_ew"), "Spruce Wood Planks", "Spruce Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("spruce_planks_log_cabin_ns"), "Spruce Wood Planks", "Spruce Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("spruce_planks_paneling"), "Spruce Wood Planks", "Spruce Wood Panel");
        lang.addBlock(getVariant("spruce_planks_shipping"), "Spruce Wood Planks", "Spruce Wood Crate");
        lang.addBlock(getVariant("spruce_planks_smooth"), "Spruce Wood Planks", "Smooth Spruce Wood Planks");
        lang.addBlock(getVariant("spruce_planks_stacked"), "Spruce Wood Planks", "Stacked Spruce Wood Tiles");
        lang.addBlock(getVariant("spruce_planks_vertical"), "Spruce Wood Planks", "Vertical Spruce Wood Planks");
    }
}

