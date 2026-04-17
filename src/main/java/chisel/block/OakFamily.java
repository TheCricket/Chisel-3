package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OakFamily extends ChiselBlock {
    public OakFamily(BlockBehaviour.Properties props) {
        family = builder("oak_planks")
                .addVariant(Blocks.OAK_PLANKS)
                .addVariant("oak_planks_braced", props, VariantModelType.CONNECTED_TBS)
                .addVariant("oak_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_crude_horizontal", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("oak_planks_crude_paneling", props)
                .addVariant("oak_planks_crude_vertical", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("oak_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_large", props)
                .addVariant("oak_planks_log_bordered", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_log_cabin_ns", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_log_cabin_ew", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_paneling", props)
                .addVariant("oak_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_stacked", props)
                .addVariant("oak_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("oak_planks_braced"), "Oak Wood Planks", "Oak Wood Panel");
        lang.addBlock(getVariant("oak_planks_braid"), "Oak Wood Planks", "Oak Wood Braid");
        lang.addBlock(getVariant("oak_planks_crude_horizontal"), "Oak Wood Planks", "Vertical Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("oak_planks_crude_paneling"), "Oak Wood Planks", "Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("oak_planks_crude_vertical"), "Oak Wood Planks", "Vertical Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("oak_planks_encased"), "Oak Wood Planks", "Encased Oak Wood Panel");
        lang.addBlock(getVariant("oak_planks_encased_large"), "Oak Wood Planks", "Large Long Oak Wood Planks");
        lang.addBlock(getVariant("oak_planks_encased_smooth"), "Oak Wood Planks", "Smooth Oak Wood Planks");
        lang.addBlock(getVariant("oak_planks_large"), "Oak Wood Planks", "Large Long Oak Wood Planks");
        lang.addBlock(getVariant("oak_planks_log_bordered"), "Oak Wood Planks", "Log Bordered Oak Wood Panel");
        lang.addBlock(getVariant("oak_planks_log_cabin_ns"), "Oak Wood Planks", "Oak Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("oak_planks_log_cabin_ew"), "Oak Wood Planks", "Oak Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("oak_planks_paneling"), "Oak Wood Planks", "Oak Wood Panel");
        lang.addBlock(getVariant("oak_planks_shipping"), "Oak Wood Planks", "Oak Wood Crate");
        lang.addBlock(getVariant("oak_planks_smooth"), "Oak Wood Planks", "Smooth Oak Wood Planks");
        lang.addBlock(getVariant("oak_planks_stacked"), "Oak Wood Planks", "Stacked Oak Wood Tiles");
        lang.addBlock(getVariant("oak_planks_vertical"), "Oak Wood Planks", "Vertical Oak Wood Planks");
    }
}

