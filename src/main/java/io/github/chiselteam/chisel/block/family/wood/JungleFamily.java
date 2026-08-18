package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class JungleFamily extends ChiselFamily {
    public JungleFamily(BlockBehaviour.Properties props) {
        family = builder("jungle_planks")
                .addVariant(Blocks.JUNGLE_PLANKS)
                .addVariant("jungle_planks_braced", props, CONNECTED_TBS)
                .addVariant("jungle_planks_braid", props, CONNECTED)
                .addVariant("jungle_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("jungle_planks_crude_paneling", props)
                .addVariant("jungle_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("jungle_planks_encased", props, CONNECTED)
                .addVariant("jungle_planks_encased_large", props, CONNECTED)
                .addVariant("jungle_planks_encased_smooth", props, CONNECTED)
                .addVariant("jungle_planks_large", props)
                .addVariant("jungle_planks_log_bordered", props, CONNECTED)
                .addVariant("jungle_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("jungle_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("jungle_planks_paneling", props, CONNECTED)
                .addVariant("jungle_planks_shipping", props, CONNECTED)
                .addVariant("jungle_planks_smooth", props, CONNECTED)
                .addVariant("jungle_planks_stacked", props)
                .addVariant("jungle_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("jungle_planks_braced"), "Jungle Planks", "Jungle Wood Panel");
        lang.addBlock(getVariant("jungle_planks_braid"), "Jungle Planks", "Jungle Wood Braid");
        lang.addBlock(getVariant("jungle_planks_crude_horizontal"), "Jungle Planks", "Vertical Jungle Wood Planks in Disarray");
        lang.addBlock(getVariant("jungle_planks_crude_paneling"), "Jungle Planks", "Jungle Wood Planks in Disarray");
        lang.addBlock(getVariant("jungle_planks_crude_vertical"), "Jungle Planks", "Vertical Jungle Wood Planks in Disarray");
        lang.addBlock(getVariant("jungle_planks_encased"), "Jungle Planks", "Encased Jungle Wood Panel");
        lang.addBlock(getVariant("jungle_planks_encased_large"), "Jungle Planks", "Large Long Jungle Wood Planks");
        lang.addBlock(getVariant("jungle_planks_encased_smooth"), "Jungle Planks", "Smooth Jungle Wood Planks");
        lang.addBlock(getVariant("jungle_planks_large"), "Jungle Planks", "Large Long Jungle Wood Planks");
        lang.addBlock(getVariant("jungle_planks_log_bordered"), "Jungle Planks", "Log Bordered Jungle Wood Panel");
        lang.addBlock(getVariant("jungle_planks_log_cabin_ns"), "Jungle Planks", "Jungle Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("jungle_planks_log_cabin_ew"), "Jungle Planks", "Jungle Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("jungle_planks_paneling"), "Jungle Planks", "Jungle Wood Panel");
        lang.addBlock(getVariant("jungle_planks_shipping"), "Jungle Planks", "Jungle Wood Crate");
        lang.addBlock(getVariant("jungle_planks_smooth"), "Jungle Planks", "Smooth Jungle Wood Planks");
        lang.addBlock(getVariant("jungle_planks_stacked"), "Jungle Planks", "Stacked Jungle Wood Tiles");
        lang.addBlock(getVariant("jungle_planks_vertical"), "Jungle Planks", "Vertical Jungle Wood Planks");
    }
}

