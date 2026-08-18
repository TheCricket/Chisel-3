package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class OakFamily extends ChiselFamily {
    public OakFamily(BlockBehaviour.Properties props) {
        family = builder("oak_planks")
                .addVariant(Blocks.OAK_PLANKS)
                .addVariant("oak_planks_braced", props, CONNECTED_TBS)
                .addVariant("oak_planks_braid", props, CONNECTED)
                .addVariant("oak_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("oak_planks_crude_paneling", props)
                .addVariant("oak_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("oak_planks_encased", props, CONNECTED)
                .addVariant("oak_planks_encased_large", props, CONNECTED)
                .addVariant("oak_planks_encased_smooth", props, CONNECTED)
                .addVariant("oak_planks_large", props)
                .addVariant("oak_planks_log_bordered", props, CONNECTED)
                .addVariant("oak_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("oak_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("oak_planks_paneling", props, CONNECTED)
                .addVariant("oak_planks_shipping", props, CONNECTED)
                .addVariant("oak_planks_smooth", props, CONNECTED)
                .addVariant("oak_planks_stacked", props)
                .addVariant("oak_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("oak_planks_braced"), "Oak Planks", "Oak Wood Panel");
        lang.addBlock(getVariant("oak_planks_braid"), "Oak Planks", "Oak Wood Braid");
        lang.addBlock(getVariant("oak_planks_crude_horizontal"), "Oak Planks", "Vertical Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("oak_planks_crude_paneling"), "Oak Planks", "Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("oak_planks_crude_vertical"), "Oak Planks", "Vertical Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("oak_planks_encased"), "Oak Planks", "Encased Oak Wood Panel");
        lang.addBlock(getVariant("oak_planks_encased_large"), "Oak Planks", "Large Long Oak Wood Planks");
        lang.addBlock(getVariant("oak_planks_encased_smooth"), "Oak Planks", "Smooth Oak Wood Planks");
        lang.addBlock(getVariant("oak_planks_large"), "Oak Planks", "Large Long Oak Wood Planks");
        lang.addBlock(getVariant("oak_planks_log_bordered"), "Oak Planks", "Log Bordered Oak Wood Panel");
        lang.addBlock(getVariant("oak_planks_log_cabin_ns"), "Oak Planks", "Oak Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("oak_planks_log_cabin_ew"), "Oak Planks", "Oak Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("oak_planks_paneling"), "Oak Planks", "Oak Wood Panel");
        lang.addBlock(getVariant("oak_planks_shipping"), "Oak Planks", "Oak Wood Crate");
        lang.addBlock(getVariant("oak_planks_smooth"), "Oak Planks", "Smooth Oak Wood Planks");
        lang.addBlock(getVariant("oak_planks_stacked"), "Oak Planks", "Stacked Oak Wood Tiles");
        lang.addBlock(getVariant("oak_planks_vertical"), "Oak Planks", "Vertical Oak Wood Planks");
    }
}

