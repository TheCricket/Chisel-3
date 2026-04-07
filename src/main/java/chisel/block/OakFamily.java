package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OakFamily extends ChiselBlock {
    public OakFamily(BlockBehaviour.Properties props) {
        family = builder("oak_planks")
                .addVariant(Blocks.OAK_PLANKS)
                .addVariant("oak_planks_braced", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("oak_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_crude_horizontal", props)
                .addVariant("oak_planks_crude_paneling", props)
                .addVariant("oak_planks_crude_vertical", props)
                .addVariant("oak_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_large", props)
                .addVariant("oak_planks_log_cabin", props)
                .addVariant("oak_planks_paneling", props)
                .addVariant("oak_planks_shipping", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_smooth", props, VariantModelType.CONNECTED)
                .addVariant("oak_planks_stacked", props)
                .addVariant("oak_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("oak_planks_braced"), "Oak Wood Planks", "Braced Planks");
        lang.addBlock(getVariant("oak_planks_braid"), "Oak Wood Planks", "Braid");
        lang.addBlock(getVariant("oak_planks_crude_horizontal"), "Oak Wood Planks", "Crude Horizontal Planks");
        lang.addBlock(getVariant("oak_planks_crude_paneling"), "Oak Wood Planks", "Crude Paneling");
        lang.addBlock(getVariant("oak_planks_crude_vertical"), "Oak Wood Planks", "Crude Vertical Planks");
        lang.addBlock(getVariant("oak_planks_encased"), "Oak Wood Planks", "Encased Planks");
        lang.addBlock(getVariant("oak_planks_encased_large"), "Oak Wood Planks", "Encased Large Planks");
        lang.addBlock(getVariant("oak_planks_encased_smooth"), "Oak Wood Planks", "Encased Smooth");
        lang.addBlock(getVariant("oak_planks_large"), "Oak Wood Planks", "Large Planks");
        lang.addBlock(getVariant("oak_planks_log_cabin"), "Oak Wood Planks", "Log Cabin");
        lang.addBlock(getVariant("oak_planks_paneling"), "Oak Wood Planks", "Paneling");
        lang.addBlock(getVariant("oak_planks_shipping"), "Oak Wood Planks", "Shipping Crate");
        lang.addBlock(getVariant("oak_planks_smooth"), "Oak Wood Planks", "Smooth");
        lang.addBlock(getVariant("oak_planks_stacked"), "Oak Wood Planks", "Stacked");
        lang.addBlock(getVariant("oak_planks_vertical"), "Oak Wood Planks", "Vertical Planks");
    }
}

