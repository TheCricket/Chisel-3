package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DarkOakFamily extends ChiselBlock {
    public DarkOakFamily(BlockBehaviour.Properties props) {
        family = builder("dark_oak_planks")
                .addVariant(Blocks.DARK_OAK_PLANKS)
                .addVariant("dark_oak_planks_braced", props, VariantModelType.CONNECTED_TBS)
                .addVariant("dark_oak_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_crude_horizontal", props)
                .addVariant("dark_oak_planks_crude_paneling", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("dark_oak_planks_crude_vertical", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("dark_oak_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_large", props)
                .addVariant("dark_oak_planks_log_bordered", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_log_cabin_ns", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_log_cabin_ew", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_paneling", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("dark_oak_planks_stacked", props)
                .addVariant("dark_oak_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("dark_oak_planks_braced"), "Dark Oak Wood Planks", "Braced Planks");
        lang.addBlock(getVariant("dark_oak_planks_braid"), "Dark Oak Wood Planks", "Braid");
        lang.addBlock(getVariant("dark_oak_planks_crude_horizontal"), "Dark Oak Wood Planks", "Crude Horizontal Planks");
        lang.addBlock(getVariant("dark_oak_planks_crude_paneling"), "Dark Oak Wood Planks", "Crude Paneling");
        lang.addBlock(getVariant("dark_oak_planks_crude_vertical"), "Dark Oak Wood Planks", "Crude Vertical Planks");
        lang.addBlock(getVariant("dark_oak_planks_encased"), "Dark Oak Wood Planks", "Encased Planks");
        lang.addBlock(getVariant("dark_oak_planks_encased_large"), "Dark Oak Wood Planks", "Encased Large Planks");
        lang.addBlock(getVariant("dark_oak_planks_encased_smooth"), "Dark Oak Wood Planks", "Encased Smooth");
        lang.addBlock(getVariant("dark_oak_planks_large"), "Dark Oak Wood Planks", "Large Planks");
        lang.addBlock(getVariant("dark_oak_planks_log_bordered"), "Dark Oak Wood Planks", "Bordered");
        lang.addBlock(getVariant("dark_oak_planks_log_cabin_ns"), "Dark Oak Wood Planks", "Log Cabin (NS)");
        lang.addBlock(getVariant("dark_oak_planks_log_cabin_ew"), "Dark Oak Wood Planks", "Log Cabin (EW)");
        lang.addBlock(getVariant("dark_oak_planks_paneling"), "Dark Oak Wood Planks", "Paneling");
        lang.addBlock(getVariant("dark_oak_planks_shipping"), "Dark Oak Wood Planks", "Shipping Crate");
        lang.addBlock(getVariant("dark_oak_planks_smooth"), "Dark Oak Wood Planks", "Smooth");
        lang.addBlock(getVariant("dark_oak_planks_stacked"), "Dark Oak Wood Planks", "Stacked");
        lang.addBlock(getVariant("dark_oak_planks_vertical"), "Dark Oak Wood Planks", "Vertical Planks");
    }
}

