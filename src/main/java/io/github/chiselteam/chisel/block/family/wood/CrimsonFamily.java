package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CrimsonFamily extends ChiselFamily {

    public CrimsonFamily(BlockBehaviour.Properties props) {
        family = builder("crimson_planks")
                .addVariant(Blocks.CRIMSON_PLANKS)
                .addVariant("crimson_planks_braced", props, CONNECTED_TBS)
                .addVariant("crimson_planks_braid", props, CONNECTED)
                .addVariant("crimson_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("crimson_planks_crude_paneling", props)
                .addVariant("crimson_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("crimson_planks_encased", props, CONNECTED)
                .addVariant("crimson_planks_encased_large", props, CONNECTED)
                .addVariant("crimson_planks_encased_smooth", props, CONNECTED)
                .addVariant("crimson_planks_large", props)
                .addVariant("crimson_planks_log_bordered", props, CONNECTED)
                .addVariant("crimson_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("crimson_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("crimson_planks_paneling", props, CONNECTED)
                .addVariant("crimson_planks_shipping", props, CONNECTED)
                .addVariant("crimson_planks_smooth", props, CONNECTED)
                .addVariant("crimson_planks_stacked", props)
                .addVariant("crimson_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("crimson_planks_braced"), "Crimson Planks", "Crimson Wood Panel");
        lang.addBlock(getVariant("crimson_planks_braid"), "Crimson Planks", "Crimson Wood Braid");
        lang.addBlock(getVariant("crimson_planks_crude_horizontal"), "Crimson Planks", "Vertical Crimson Wood Planks in Disarray");
        lang.addBlock(getVariant("crimson_planks_crude_paneling"), "Crimson Planks", "Crimson Wood Planks in Disarray");
        lang.addBlock(getVariant("crimson_planks_crude_vertical"), "Crimson Planks", "Vertical Crimson Wood Planks in Disarray");
        lang.addBlock(getVariant("crimson_planks_encased"), "Crimson Planks", "Encased Crimson Wood Panel");
        lang.addBlock(getVariant("crimson_planks_encased_large"), "Crimson Planks", "Large Long Crimson Wood Planks");
        lang.addBlock(getVariant("crimson_planks_encased_smooth"), "Crimson Planks", "Smooth Crimson Wood Planks");
        lang.addBlock(getVariant("crimson_planks_large"), "Crimson Planks", "Large Long Crimson Wood Planks");
        lang.addBlock(getVariant("crimson_planks_log_bordered"), "Crimson Planks", "Log Bordered Crimson Wood Panel");
        lang.addBlock(getVariant("crimson_planks_log_cabin_ns"), "Crimson Planks", "Crimson Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("crimson_planks_log_cabin_ew"), "Crimson Planks", "Crimson Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("crimson_planks_paneling"), "Crimson Planks", "Crimson Wood Panel");
        lang.addBlock(getVariant("crimson_planks_shipping"), "Crimson Planks", "Crimson Wood Crate");
        lang.addBlock(getVariant("crimson_planks_smooth"), "Crimson Planks", "Smooth Crimson Wood Planks");
        lang.addBlock(getVariant("crimson_planks_stacked"), "Crimson Planks", "Stacked Crimson Wood Tiles");
        lang.addBlock(getVariant("crimson_planks_vertical"), "Crimson Planks", "Vertical Crimson Wood Planks");
    }
}

