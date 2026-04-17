package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BirchFamily extends ChiselBlock {
    public BirchFamily(BlockBehaviour.Properties props) {
        family = builder("birch_planks")
                .addVariant(Blocks.BIRCH_PLANKS)
                .addVariant("birch_planks_braced", props, VariantModelType.CONNECTED_TBS)
                .addVariant("birch_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_crude_horizontal", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("birch_planks_crude_paneling", props)
                .addVariant("birch_planks_crude_vertical", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("birch_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_large", props)
                .addVariant("birch_planks_log_bordered", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_log_cabin_ew", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_log_cabin_ns", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_paneling", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("birch_planks_stacked", props)
                .addVariant("birch_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("birch_planks_braced"), "Birch Wood Planks", "Birch Wood Panel");
        lang.addBlock(getVariant("birch_planks_braid"), "Birch Wood Planks", "Birch Wood Braid");
        lang.addBlock(getVariant("birch_planks_crude_horizontal"), "Birch Wood Planks", "Vertical Birch Wood Planks in Disarray");
        lang.addBlock(getVariant("birch_planks_crude_paneling"), "Birch Wood Planks", "Birch Wood Planks in Disarray");
        lang.addBlock(getVariant("birch_planks_crude_vertical"), "Birch Wood Planks", "Vertical Birch Wood Planks in Disarray");
        lang.addBlock(getVariant("birch_planks_encased"), "Birch Wood Planks", "Encased Birch Wood Panel");
        lang.addBlock(getVariant("birch_planks_encased_large"), "Birch Wood Planks", "Large Long Birch Wood Planks");
        lang.addBlock(getVariant("birch_planks_encased_smooth"), "Birch Wood Planks", "Smooth Birch Wood Planks");
        lang.addBlock(getVariant("birch_planks_large"), "Birch Wood Planks", "Large Long Birch Wood Planks");
        lang.addBlock(getVariant("birch_planks_log_bordered"), "Birch Wood Planks", "Log Bordered Birch Wood Panel");
        lang.addBlock(getVariant("birch_planks_log_cabin_ns"), "Birch Wood Planks", "Birch Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("birch_planks_log_cabin_ew"), "Birch Wood Planks", "Birch Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("birch_planks_paneling"), "Birch Wood Planks", "Birch Wood Panel");
        lang.addBlock(getVariant("birch_planks_shipping"), "Birch Wood Planks", "Birch Wood Crate");
        lang.addBlock(getVariant("birch_planks_smooth"), "Birch Wood Planks", "Smooth Birch Wood Planks");
        lang.addBlock(getVariant("birch_planks_stacked"), "Birch Wood Planks", "Stacked Birch Wood Tiles");
        lang.addBlock(getVariant("birch_planks_vertical"), "Birch Wood Planks", "Vertical Birch Wood Planks");
    }
}

