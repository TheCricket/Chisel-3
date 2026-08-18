package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.MULTIBLOCK_3X3;

public class SpruceFamily extends ChiselFamily {
    public SpruceFamily(BlockBehaviour.Properties props) {
        family = builder("spruce_planks")
                .addVariant(Blocks.SPRUCE_PLANKS)
                .addVariant("spruce_planks_braced", props)
                .addVariant("spruce_planks_braid", props, CONNECTED)
                .addVariant("spruce_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("spruce_planks_crude_paneling", props)
                .addVariant("spruce_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("spruce_planks_encased", props, CONNECTED)
                .addVariant("spruce_planks_encased_large", props, CONNECTED)
                .addVariant("spruce_planks_encased_smooth", props, CONNECTED)
                .addVariant("spruce_planks_large", props)
                .addVariant("spruce_planks_log_bordered", props, CONNECTED)
                .addVariant("spruce_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("spruce_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("spruce_planks_paneling", props, CONNECTED)
                .addVariant("spruce_planks_shipping", props, CONNECTED)
                .addVariant("spruce_planks_smooth", props, CONNECTED)
                .addVariant("spruce_planks_stacked", props)
                .addVariant("spruce_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("spruce_planks_braced"), "Spruce Planks", "Spruce Wood Panel");
        lang.addBlock(getVariant("spruce_planks_braid"), "Spruce Planks", "Spruce Wood Braid");
        lang.addBlock(getVariant("spruce_planks_crude_horizontal"), "Spruce Planks", "Vertical Spruce Wood Planks in Disarray");
        lang.addBlock(getVariant("spruce_planks_crude_paneling"), "Spruce Planks", "Spruce Wood Planks in Disarray");
        lang.addBlock(getVariant("spruce_planks_crude_vertical"), "Spruce Planks", "Vertical Spruce Wood Planks in Disarray");
        lang.addBlock(getVariant("spruce_planks_encased"), "Spruce Planks", "Encased Spruce Wood Panel");
        lang.addBlock(getVariant("spruce_planks_encased_large"), "Spruce Planks", "Large Long Spruce Wood Planks");
        lang.addBlock(getVariant("spruce_planks_encased_smooth"), "Spruce Planks", "Smooth Spruce Wood Planks");
        lang.addBlock(getVariant("spruce_planks_large"), "Spruce Planks", "Large Long Spruce Wood Planks");
        lang.addBlock(getVariant("spruce_planks_log_bordered"), "Spruce Planks", "Log Bordered Spruce Wood Panel");
        lang.addBlock(getVariant("spruce_planks_log_cabin_ew"), "Spruce Planks", "Spruce Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("spruce_planks_log_cabin_ns"), "Spruce Planks", "Spruce Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("spruce_planks_paneling"), "Spruce Planks", "Spruce Wood Panel");
        lang.addBlock(getVariant("spruce_planks_shipping"), "Spruce Planks", "Spruce Wood Crate");
        lang.addBlock(getVariant("spruce_planks_smooth"), "Spruce Planks", "Smooth Spruce Wood Planks");
        lang.addBlock(getVariant("spruce_planks_stacked"), "Spruce Planks", "Stacked Spruce Wood Tiles");
        lang.addBlock(getVariant("spruce_planks_vertical"), "Spruce Planks", "Vertical Spruce Wood Planks");
    }
}

