package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class BirchFamily extends ChiselFamily {
    public BirchFamily(BlockBehaviour.Properties props) {
        family = builder("birch_planks")
                .addVariant(Blocks.BIRCH_PLANKS)
                .addVariant("birch_planks_braced", props, CONNECTED_TBS)
                .addVariant("birch_planks_braid", props, CONNECTED)
                .addVariant("birch_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("birch_planks_crude_paneling", props)
                .addVariant("birch_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("birch_planks_encased", props, CONNECTED)
                .addVariant("birch_planks_encased_large", props, CONNECTED)
                .addVariant("birch_planks_encased_smooth", props, CONNECTED)
                .addVariant("birch_planks_large", props)
                .addVariant("birch_planks_log_bordered", props, CONNECTED)
                .addVariant("birch_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("birch_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("birch_planks_paneling", props, CONNECTED)
                .addVariant("birch_planks_shipping", props, CONNECTED)
                .addVariant("birch_planks_smooth", props, CONNECTED)
                .addVariant("birch_planks_stacked", props)
                .addVariant("birch_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("birch_planks_braced"), "Birch Planks", "Birch Wood Panel");
        lang.addBlock(getVariant("birch_planks_braid"), "Birch Planks", "Birch Wood Braid");
        lang.addBlock(getVariant("birch_planks_crude_horizontal"), "Birch Planks", "Vertical Birch Wood Planks in Disarray");
        lang.addBlock(getVariant("birch_planks_crude_paneling"), "Birch Planks", "Birch Wood Planks in Disarray");
        lang.addBlock(getVariant("birch_planks_crude_vertical"), "Birch Planks", "Vertical Birch Wood Planks in Disarray");
        lang.addBlock(getVariant("birch_planks_encased"), "Birch Planks", "Encased Birch Wood Panel");
        lang.addBlock(getVariant("birch_planks_encased_large"), "Birch Planks", "Large Long Birch Wood Planks");
        lang.addBlock(getVariant("birch_planks_encased_smooth"), "Birch Planks", "Smooth Birch Wood Planks");
        lang.addBlock(getVariant("birch_planks_large"), "Birch Planks", "Large Long Birch Wood Planks");
        lang.addBlock(getVariant("birch_planks_log_bordered"), "Birch Planks", "Log Bordered Birch Wood Panel");
        lang.addBlock(getVariant("birch_planks_log_cabin_ns"), "Birch Planks", "Birch Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("birch_planks_log_cabin_ew"), "Birch Planks", "Birch Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("birch_planks_paneling"), "Birch Planks", "Birch Wood Panel");
        lang.addBlock(getVariant("birch_planks_shipping"), "Birch Planks", "Birch Wood Crate");
        lang.addBlock(getVariant("birch_planks_smooth"), "Birch Planks", "Smooth Birch Wood Planks");
        lang.addBlock(getVariant("birch_planks_stacked"), "Birch Planks", "Stacked Birch Wood Tiles");
        lang.addBlock(getVariant("birch_planks_vertical"), "Birch Planks", "Vertical Birch Wood Planks");
    }
}

