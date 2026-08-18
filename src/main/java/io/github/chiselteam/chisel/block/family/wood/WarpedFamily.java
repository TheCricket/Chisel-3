package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class WarpedFamily extends ChiselFamily {
    public WarpedFamily(BlockBehaviour.Properties props) {
        family = builder("warped_planks")
                .addVariant(Blocks.WARPED_PLANKS)
                .addVariant("warped_planks_braced", props, CONNECTED_TBS)
                .addVariant("warped_planks_braid", props, CONNECTED)
                .addVariant("warped_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("warped_planks_crude_paneling", props)
                .addVariant("warped_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("warped_planks_encased", props, CONNECTED)
                .addVariant("warped_planks_encased_large", props, CONNECTED)
                .addVariant("warped_planks_encased_smooth", props, CONNECTED)
                .addVariant("warped_planks_large", props)
                .addVariant("warped_planks_log_bordered", props, CONNECTED)
                .addVariant("warped_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("warped_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("warped_planks_paneling", props, CONNECTED)
                .addVariant("warped_planks_shipping", props, CONNECTED)
                .addVariant("warped_planks_smooth", props, CONNECTED)
                .addVariant("warped_planks_stacked", props)
                .addVariant("warped_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("warped_planks_braced"), "Warped Planks", "Warped Wood Panel");
        lang.addBlock(getVariant("warped_planks_braid"), "Warped Planks", "Warped Wood Braid");
        lang.addBlock(getVariant("warped_planks_crude_horizontal"), "Warped Planks", "Vertical Warped Wood Planks in Disarray");
        lang.addBlock(getVariant("warped_planks_crude_paneling"), "Warped Planks", "Warped Wood Planks in Disarray");
        lang.addBlock(getVariant("warped_planks_crude_vertical"), "Warped Planks", "Vertical Warped Wood Planks in Disarray");
        lang.addBlock(getVariant("warped_planks_encased"), "Warped Planks", "Encased Warped Wood Panel");
        lang.addBlock(getVariant("warped_planks_encased_large"), "Warped Planks", "Large Long Warped Wood Planks");
        lang.addBlock(getVariant("warped_planks_encased_smooth"), "Warped Planks", "Smooth Warped Wood Planks");
        lang.addBlock(getVariant("warped_planks_large"), "Warped Planks", "Large Long Warped Wood Planks");
        lang.addBlock(getVariant("warped_planks_log_bordered"), "Warped Planks", "Log Bordered Warped Wood Panel");
        lang.addBlock(getVariant("warped_planks_log_cabin_ns"), "Warped Planks", "Warped Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("warped_planks_log_cabin_ew"), "Warped Planks", "Warped Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("warped_planks_paneling"), "Warped Planks", "Warped Wood Panel");
        lang.addBlock(getVariant("warped_planks_shipping"), "Warped Planks", "Warped Wood Crate");
        lang.addBlock(getVariant("warped_planks_smooth"), "Warped Planks", "Smooth Warped Wood Planks");
        lang.addBlock(getVariant("warped_planks_stacked"), "Warped Planks", "Stacked Warped Wood Tiles");
        lang.addBlock(getVariant("warped_planks_vertical"), "Warped Planks", "Vertical Warped Wood Planks");
    }
}
