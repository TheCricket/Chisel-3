package chisel.block.wood;

import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class JungleBlock extends ChiselBlock {
    public JungleBlock(BlockBehaviour.Properties props) {
        

        family = builder("jungle_planks")
                .addVariant(Blocks.JUNGLE_PLANKS)
                .addVariant("jungle_planks_braced", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("jungle_planks_braid", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_crude_horizontal", props)
                .addVariant("jungle_planks_crude_paneling", props)
                .addVariant("jungle_planks_crude_vertical", props)
                .addVariant("jungle_planks_encased", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_encased_large", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_encased_smooth", props, VariantModelType.CONNECTED)
                .addVariant("jungle_planks_large", props)
                .addVariant("jungle_planks_log_cabin", props)
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
        lang.addBlock(getVariant("jungle_planks_log_cabin"), "Jungle Wood Planks", "Log Cabin");
        lang.addBlock(getVariant("jungle_planks_paneling"), "Jungle Wood Planks", "Paneling");
        lang.addBlock(getVariant("jungle_planks_shipping"), "Jungle Wood Planks", "Shipping Crate");
        lang.addBlock(getVariant("jungle_planks_smooth"), "Jungle Wood Planks", "Smooth");
        lang.addBlock(getVariant("jungle_planks_stacked"), "Jungle Wood Planks", "Stacked");
        lang.addBlock(getVariant("jungle_planks_vertical"), "Jungle Wood Planks", "Vertical Planks");
    }
}

