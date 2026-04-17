package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CrimsonFamily extends ChiselBlock {

    public CrimsonFamily(BlockBehaviour.Properties props) {
        family = builder("crimson_planks")
                .addVariant(Blocks.CRIMSON_PLANKS)
                .addVariant("crimson_planks_braced", props, VariantModelType.CONNECTED_TBS)
                .addVariant("crimson_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_crude_horizontal", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("crimson_planks_crude_paneling", props)
                .addVariant("crimson_planks_crude_vertical", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("crimson_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_large", props)
                .addVariant("crimson_planks_log_bordered", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_log_cabin_ew", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_log_cabin_ns", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_paneling", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("crimson_planks_stacked", props)
                .addVariant("crimson_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("crimson_planks_braced"), "Crimson Wood Planks", "Crimson Wood Panel");
        lang.addBlock(getVariant("crimson_planks_braid"), "Crimson Wood Planks", "Crimson Wood Braid");
        lang.addBlock(getVariant("crimson_planks_crude_horizontal"), "Crimson Wood Planks", "Vertical Crimson Wood Planks in Disarray");
        lang.addBlock(getVariant("crimson_planks_crude_paneling"), "Crimson Wood Planks", "Crimson Wood Planks in Disarray");
        lang.addBlock(getVariant("crimson_planks_crude_vertical"), "Crimson Wood Planks", "Vertical Crimson Wood Planks in Disarray");
        lang.addBlock(getVariant("crimson_planks_encased"), "Crimson Wood Planks", "Encased Crimson Wood Panel");
        lang.addBlock(getVariant("crimson_planks_encased_large"), "Crimson Wood Planks", "Large Long Crimson Wood Planks");
        lang.addBlock(getVariant("crimson_planks_encased_smooth"), "Crimson Wood Planks", "Smooth Crimson Wood Planks");
        lang.addBlock(getVariant("crimson_planks_large"), "Crimson Wood Planks", "Large Long Crimson Wood Planks");
        lang.addBlock(getVariant("crimson_planks_log_bordered"), "Crimson Wood Planks", "Log Bordered Crimson Wood Panel");
        lang.addBlock(getVariant("crimson_planks_log_cabin_ns"), "Crimson Wood Planks", "Crimson Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("crimson_planks_log_cabin_ew"), "Crimson Wood Planks", "Crimson Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("crimson_planks_paneling"), "Crimson Wood Planks", "Crimson Wood Panel");
        lang.addBlock(getVariant("crimson_planks_shipping"), "Crimson Wood Planks", "Crimson Wood Crate");
        lang.addBlock(getVariant("crimson_planks_smooth"), "Crimson Wood Planks", "Smooth Crimson Wood Planks");
        lang.addBlock(getVariant("crimson_planks_stacked"), "Crimson Wood Planks", "Stacked Crimson Wood Tiles");
        lang.addBlock(getVariant("crimson_planks_vertical"), "Crimson Wood Planks", "Vertical Crimson Wood Planks");
    }
}

