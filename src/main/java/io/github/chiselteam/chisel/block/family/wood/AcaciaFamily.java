package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class AcaciaFamily extends ChiselFamily {
    public AcaciaFamily(BlockBehaviour.Properties props) {
        family = builder("acacia_planks")
                .addVariant(Blocks.ACACIA_PLANKS)
                .addVariant("acacia_planks_braced", props, CONNECTED_TBS)
                .addVariant("acacia_planks_braid", props, CONNECTED)
                .addVariant("acacia_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("acacia_planks_crude_paneling", props)
                .addVariant("acacia_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("acacia_planks_encased", props, CONNECTED)
                .addVariant("acacia_planks_encased_large", props, CONNECTED)
                .addVariant("acacia_planks_encased_smooth", props, CONNECTED)
                .addVariant("acacia_planks_large", props)
                .addVariant("acacia_planks_log_bordered", props, CONNECTED)
                .addVariant("acacia_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("acacia_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("acacia_planks_paneling", props, CONNECTED)
                .addVariant("acacia_planks_shipping", props, CONNECTED)
                .addVariant("acacia_planks_smooth", props, CONNECTED)
                .addVariant("acacia_planks_stacked", props)
                .addVariant("acacia_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("acacia_planks_braced"), "Acacia Planks", "Acacia Wood Panel");
        lang.addBlock(getVariant("acacia_planks_braid"), "Acacia Planks", "Acacia Wood Braid");
        lang.addBlock(getVariant("acacia_planks_crude_horizontal"), "Acacia Planks", "Vertical Acacia Wood Planks in Disarray");
        lang.addBlock(getVariant("acacia_planks_crude_paneling"), "Acacia Planks", "Acacia Wood Planks in Disarray");
        lang.addBlock(getVariant("acacia_planks_crude_vertical"), "Acacia Planks", "Vertical Acacia Wood Planks in Disarray");
        lang.addBlock(getVariant("acacia_planks_encased"), "Acacia Planks", "Encased Acacia Wood Panel");
        lang.addBlock(getVariant("acacia_planks_encased_large"), "Acacia Planks", "Large Long Acacia Wood Planks");
        lang.addBlock(getVariant("acacia_planks_encased_smooth"), "Acacia Planks", "Smooth Acacia Wood Planks");
        lang.addBlock(getVariant("acacia_planks_large"), "Acacia Planks", "Large Long Acacia Wood Planks");
        lang.addBlock(getVariant("acacia_planks_log_bordered"), "Acacia Planks", "Log Bordered Acacia Wood Panel");
        lang.addBlock(getVariant("acacia_planks_log_cabin_ns"), "Acacia Planks", "Acacia Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("acacia_planks_log_cabin_ew"), "Acacia Planks", "Acacia Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("acacia_planks_paneling"), "Acacia Planks", "Acacia Wood Panel");
        lang.addBlock(getVariant("acacia_planks_shipping"), "Acacia Planks", "Acacia Wood Crate");
        lang.addBlock(getVariant("acacia_planks_smooth"), "Acacia Planks", "Smooth Acacia Wood Planks");
        lang.addBlock(getVariant("acacia_planks_stacked"), "Acacia Planks", "Stacked Acacia Wood Tiles");
        lang.addBlock(getVariant("acacia_planks_vertical"), "Acacia Planks", "Vertical Acacia Wood Planks");
    }
}
