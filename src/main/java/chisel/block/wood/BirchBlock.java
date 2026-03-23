package chisel.block.wood;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class BirchBlock extends ChiselBlock {
    public BirchBlock(BlockBehaviour.Properties props) {
        

        family = builder("birch_planks")
                .addVariant(Blocks.BIRCH_PLANKS)
                .addVariant("birch_planks_braced", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("birch_planks_braid", props)
                .addVariant("birch_planks_crude_horizontal", props)
                .addVariant("birch_planks_crude_paneling", props)
                .addVariant("birch_planks_crude_vertical", props)
                .addVariant("birch_planks_encased", props)
                .addVariant("birch_planks_encased_large", props)
                .addVariant("birch_planks_encased_smooth", props)
                .addVariant("birch_planks_large", props)
                .addVariant("birch_planks_log_cabin", props)
                .addVariant("birch_planks_paneling", props)
                .addVariant("birch_planks_shipping", props)
                .addVariant("birch_planks_smooth", props)
                .addVariant("birch_planks_stacked", props)
                .addVariant("birch_planks_vertical", props)
                .getFamily();
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
        lang.addBlock(getVariant("birch_planks_log_cabin"), "Birch Wood Planks", "Log Cabin");
        lang.addBlock(getVariant("birch_planks_paneling"), "Birch Wood Planks", "Paneling");
        lang.addBlock(getVariant("birch_planks_shipping"), "Birch Wood Planks", "Shipping Crate");
        lang.addBlock(getVariant("birch_planks_smooth"), "Birch Wood Planks", "Smooth");
        lang.addBlock(getVariant("birch_planks_stacked"), "Birch Wood Planks", "Stacked");
        lang.addBlock(getVariant("birch_planks_vertical"), "Birch Wood Planks", "Vertical Planks");
    }
}

