package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class PaleOakFamily extends ChiselFamily {
    public PaleOakFamily(BlockBehaviour.Properties props) {
        family = builder("pale_oak_planks")
                .addVariant(Blocks.PALE_OAK_PLANKS)
                .addVariant("pale_oak_planks_braced", props, CONNECTED_TBS)
                .addVariant("pale_oak_planks_braid", props, CONNECTED)
                .addVariant("pale_oak_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                .addVariant("pale_oak_planks_crude_paneling", props)
                .addVariant("pale_oak_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("pale_oak_planks_encased", props, CONNECTED)
                .addVariant("pale_oak_planks_encased_large", props, CONNECTED)
                .addVariant("pale_oak_planks_encased_smooth", props, CONNECTED)
                .addVariant("pale_oak_planks_large", props)
                .addVariant("pale_oak_planks_log_bordered", props, CONNECTED)
                .addVariant("pale_oak_planks_log_cabin_ns", props, CONNECTED)
                .addVariant("pale_oak_planks_log_cabin_ew", props, CONNECTED)
                .addVariant("pale_oak_planks_paneling", props, CONNECTED)
                .addVariant("pale_oak_planks_shipping", props, CONNECTED)
                .addVariant("pale_oak_planks_smooth", props, CONNECTED)
                .addVariant("pale_oak_planks_stacked", props)
                .addVariant("pale_oak_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("pale_oak_planks_braced"), "Pale Oak Planks", "Pale Oak Wood Panel");
        lang.addBlock(getVariant("pale_oak_planks_braid"), "Pale Oak Planks", "Pale Oak Wood Braid");
        lang.addBlock(getVariant("pale_oak_planks_crude_horizontal"), "Pale Oak Planks", "Vertical Pale Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("pale_oak_planks_crude_paneling"), "Pale Oak Planks", "Pale Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("pale_oak_planks_crude_vertical"), "Pale Oak Planks", "Vertical Pale Oak Wood Planks in Disarray");
        lang.addBlock(getVariant("pale_oak_planks_encased"), "Pale Oak Planks", "Encased Pale Oak Wood Panel");
        lang.addBlock(getVariant("pale_oak_planks_encased_large"), "Pale Oak Planks", "Large Long Pale Oak Wood Planks");
        lang.addBlock(getVariant("pale_oak_planks_encased_smooth"), "Pale Oak Planks", "Smooth Pale Oak Wood Planks");
        lang.addBlock(getVariant("pale_oak_planks_large"), "Pale Oak Planks", "Large Long Pale Oak Wood Planks");
        lang.addBlock(getVariant("pale_oak_planks_log_bordered"), "Pale Oak Planks", "Log Bordered Pale Oak Wood Panel");
        lang.addBlock(getVariant("pale_oak_planks_log_cabin_ns"), "Pale Oak Planks", "Pale Oak Wood Log Cabin (North-South)");
        lang.addBlock(getVariant("pale_oak_planks_log_cabin_ew"), "Pale Oak Planks", "Pale Oak Wood Log Cabin (East-West)");
        lang.addBlock(getVariant("pale_oak_planks_paneling"), "Pale Oak Planks", "Pale Oak Wood Panel");
        lang.addBlock(getVariant("pale_oak_planks_shipping"), "Pale Oak Planks", "Pale Oak Wood Crate");
        lang.addBlock(getVariant("pale_oak_planks_smooth"), "Pale Oak Planks", "Smooth Pale Oak Wood Planks");
        lang.addBlock(getVariant("pale_oak_planks_stacked"), "Pale Oak Planks", "Stacked Pale Oak Wood Tiles");
        lang.addBlock(getVariant("pale_oak_planks_vertical"), "Pale Oak Planks", "Vertical Pale Oak Wood Planks");
    }
}
