package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class JungleFamily extends ChiselFamily {
    public JungleFamily(BlockBehaviour.Properties props) {
        family = builder("jungle_planks")
                .addVariant(Blocks.JUNGLE_PLANKS)
                .addVariant("jungle_planks_braced", props, VariantModelType.CONNECTED_TBS)
                .addVariant("jungle_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_crude_horizontal", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("jungle_planks_crude_paneling", props)
                .addVariant("jungle_planks_crude_vertical", props, VariantModelType.MULTIBLOCK_3X3)
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
        lang.addBlock(getVariant("jungle_planks_braced"), "Jungle Wood Planks", "Jungle Wood Panel");
        lang.addBlock(getVariant("jungle_planks_braid"), "Jungle Wood Planks", "Jungle Wood Braid");
        lang.addBlock(getVariant("jungle_planks_crude_horizontal"), "Jungle Wood Planks", "Vertical Jungle Wood Planks in Disarray");
        lang.addBlock(getVariant("jungle_planks_crude_paneling"), "Jungle Wood Planks", "Jungle Wood Planks in Disarray");
        lang.addBlock(getVariant("jungle_planks_crude_vertical"), "Jungle Wood Planks", "Vertical Jungle Wood Planks in Disarray");
        lang.addBlock(getVariant("jungle_planks_encased"), "Jungle Wood Planks", "Encased Jungle Wood Panel");
        lang.addBlock(getVariant("jungle_planks_encased_large"), "Jungle Wood Planks", "Large Long Jungle Wood Planks");
        lang.addBlock(getVariant("jungle_planks_encased_smooth"), "Jungle Wood Planks", "Smooth Jungle Wood Planks");
        lang.addBlock(getVariant("jungle_planks_large"), "Jungle Wood Planks", "Large Long Jungle Wood Planks");
        lang.addBlock(getVariant("jungle_planks_log_bordered"), "Jungle Wood Planks", "Log Bordered Jungle Wood Panel");
        lang.addBlock(getVariant("jungle_planks_log_cabin_ns"), "Jungle Wood Planks", "Jungle Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("jungle_planks_log_cabin_ew"), "Jungle Wood Planks", "Jungle Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("jungle_planks_paneling"), "Jungle Wood Planks", "Jungle Wood Panel");
        lang.addBlock(getVariant("jungle_planks_shipping"), "Jungle Wood Planks", "Jungle Wood Crate");
        lang.addBlock(getVariant("jungle_planks_smooth"), "Jungle Wood Planks", "Smooth Jungle Wood Planks");
        lang.addBlock(getVariant("jungle_planks_stacked"), "Jungle Wood Planks", "Stacked Jungle Wood Tiles");
        lang.addBlock(getVariant("jungle_planks_vertical"), "Jungle Wood Planks", "Vertical Jungle Wood Planks");
    }
}

