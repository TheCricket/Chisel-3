package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CherryFamily extends ChiselFamily {
    public CherryFamily(BlockBehaviour.Properties props) {
        family = builder("cherry_planks")
                .addVariant(Blocks.CHERRY_PLANKS)
                .addVariant("cherry_planks_braced", props, CONNECTED_TBS)
                .addVariant("cherry_planks_braid", props, CONNECTED)
                .addVariant("cherry_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("cherry_planks_crude_paneling", props)
                .addVariant("cherry_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("cherry_planks_encased", props, CONNECTED)
                .addVariant("cherry_planks_encased_large", props, CONNECTED)
                .addVariant("cherry_planks_encased_smooth", props, CONNECTED)
                .addVariant("cherry_planks_large", props)
                .addVariant("cherry_planks_log_bordered", props, CONNECTED)
                .addVariant("cherry_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("cherry_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("cherry_planks_paneling", props, CONNECTED)
                .addVariant("cherry_planks_shipping", props, CONNECTED)
                .addVariant("cherry_planks_smooth", props, CONNECTED)
                .addVariant("cherry_planks_stacked", props)
                .addVariant("cherry_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("cherry_planks_braced"), "Cherry Planks", "Cherry Wood Panel");
        lang.addBlock(getVariant("cherry_planks_braid"), "Cherry Planks", "Cherry Wood Braid");
        lang.addBlock(getVariant("cherry_planks_crude_horizontal"), "Cherry Planks", "Vertical Cherry Wood Planks in Disarray");
        lang.addBlock(getVariant("cherry_planks_crude_paneling"), "Cherry Planks", "Cherry Wood Planks in Disarray");
        lang.addBlock(getVariant("cherry_planks_crude_vertical"), "Cherry Planks", "Vertical Cherry Wood Planks in Disarray");
        lang.addBlock(getVariant("cherry_planks_encased"), "Cherry Planks", "Encased Cherry Wood Panel");
        lang.addBlock(getVariant("cherry_planks_encased_large"), "Cherry Planks", "Large Long Cherry Wood Planks");
        lang.addBlock(getVariant("cherry_planks_encased_smooth"), "Cherry Planks", "Smooth Cherry Wood Planks");
        lang.addBlock(getVariant("cherry_planks_large"), "Cherry Planks", "Large Long Cherry Wood Planks");
        lang.addBlock(getVariant("cherry_planks_log_bordered"), "Cherry Planks", "Log Bordered Cherry Wood Panel");
        lang.addBlock(getVariant("cherry_planks_log_cabin_ns"), "Cherry Planks", "Cherry Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("cherry_planks_log_cabin_ew"), "Cherry Planks", "Cherry Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("cherry_planks_paneling"), "Cherry Planks", "Cherry Wood Panel");
        lang.addBlock(getVariant("cherry_planks_shipping"), "Cherry Planks", "Cherry Wood Crate");
        lang.addBlock(getVariant("cherry_planks_smooth"), "Cherry Planks", "Smooth Cherry Wood Planks");
        lang.addBlock(getVariant("cherry_planks_stacked"), "Cherry Planks", "Stacked Cherry Wood Tiles");
        lang.addBlock(getVariant("cherry_planks_vertical"), "Cherry Planks", "Vertical Cherry Wood Planks");
    }
}
