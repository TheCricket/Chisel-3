package io.github.chiselteam.chisel.block.family.wood;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.CONNECTED_TBS;

public class BambooFamily extends ChiselFamily {
    public BambooFamily(BlockBehaviour.Properties props) {
        family = builder("bamboo_planks")
                .addVariant(Blocks.BAMBOO_PLANKS)
                .addVariant("bamboo_planks_braced", props, CONNECTED_TBS)
                .addVariant("bamboo_planks_braid", props, CONNECTED)
                //.addVariant("bamboo_planks_crude_horizontal", props, MULTIBLOCK_3X3)
                //.addVariant("bamboo_planks_crude_paneling", props)
                //.addVariant("bamboo_planks_crude_vertical", props, MULTIBLOCK_3X3)
                .addVariant("bamboo_planks_encased", props, CONNECTED)
                .addVariant("bamboo_planks_encased_2", props, CONNECTED)
                .addVariant("bamboo_planks_encased_large", props, CONNECTED)
                .addVariant("bamboo_planks_encased_smooth", props, CONNECTED)
                .addVariant("bamboo_planks_large", props)
                .addVariant("bamboo_planks_log_bordered", props, CONNECTED)
                //.addVariant("bamboo_planks_log_cabin_ew", props, CONNECTED)
                //.addVariant("bamboo_planks_log_cabin_ns", props, CONNECTED)
                //.addVariant("bamboo_planks_paneling", props, CONNECTED)
                .addVariant("bamboo_planks_shipping", props, CONNECTED)
                .addVariant("bamboo_planks_smooth", props, CONNECTED)
                //.addVariant("bamboo_planks_stacked", props)
                .addVariant("bamboo_planks_vertical", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("bamboo_planks_braced"), "Bamboo Planks", "Bamboo Panel");
        lang.addBlock(getVariant("bamboo_planks_braid"), "Bamboo Planks", "Bamboo Braid");
        //lang.addBlock(getVariant("bamboo_planks_crude_horizontal"), "Bamboo Planks", "Vertical Bamboo Planks in Disarray");
        //lang.addBlock(getVariant("bamboo_planks_crude_paneling"), "Bamboo Planks", "Bamboo Planks in Disarray");
        //lang.addBlock(getVariant("bamboo_planks_crude_vertical"), "Bamboo Planks", "Vertical Bamboo Planks in Disarray");
        lang.addBlock(getVariant("bamboo_planks_encased"), "Bamboo Planks", "Encased Bamboo Panel");
        lang.addBlock(getVariant("bamboo_planks_encased_2"), "Bamboo Planks", "Encased Bamboo Panel");
        lang.addBlock(getVariant("bamboo_planks_encased_large"), "Bamboo Planks", "Large Long Bamboo Planks");
        lang.addBlock(getVariant("bamboo_planks_encased_smooth"), "Bamboo Planks", "Smooth Bamboo Planks");
        lang.addBlock(getVariant("bamboo_planks_large"), "Bamboo Planks", "Large Long Bamboo Planks");
        lang.addBlock(getVariant("bamboo_planks_log_bordered"), "Bamboo Planks", "Log Bordered Bamboo Panel");
        //lang.addBlock(getVariant("bamboo_planks_log_cabin_ns"), "Bamboo Planks", "Bamboo Log Cabin (North-South)");
        //lang.addBlock(getVariant("bamboo_planks_log_cabin_ew"), "Bamboo Planks", "Bamboo Log Cabin (East-West)");
        //lang.addBlock(getVariant("bamboo_planks_paneling"), "Bamboo Planks", "Bamboo Panel");
        lang.addBlock(getVariant("bamboo_planks_shipping"), "Bamboo Planks", "Bamboo Crate");
        lang.addBlock(getVariant("bamboo_planks_smooth"), "Bamboo Planks", "Smooth Bamboo Planks");
        //lang.addBlock(getVariant("bamboo_planks_stacked"), "Bamboo Planks", "Stacked Bamboo Tiles");
        lang.addBlock(getVariant("bamboo_planks_vertical"), "Bamboo Planks", "Vertical Bamboo Planks");
    }
}

