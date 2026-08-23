package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SeaLanternFamily extends ChiselFamily {
    public SeaLanternFamily(BlockBehaviour.Properties props) {
        family = builder("sea_lantern")
                .addVariant(Blocks.SEA_LANTERN)
                .addVariant("sea_lantern_connected", props, MULTI_LAYER_CONNECTED) 
                .addVariant("sea_lantern_dent", props, MULTI_LAYER_CONNECTED)
                .addVariant("sea_lantern_braid", props)
                .addVariant("sea_lantern_braid_invert", props)
                .addVariant("sea_lantern_layer", props)
                .addVariant("sea_lantern_layer_invert", props)
                .addVariant("sea_lantern_road", props)
                .addVariant("sea_lantern_road_invert", props)
                .addVariant("sea_lantern_checker_small", props)
                .addVariant("sea_lantern_checker", props)
                .addVariant("sea_lantern_bricks", props)
                .addVariant("sea_lantern_bricks_invert", props)
                .addVariant("sea_lantern_frame1", props)
                .addVariant("sea_lantern_raw", props)
                .addVariant("sea_lantern_pillar_dent", props, CTMV)
                .addVariant("sea_lantern_pillar_dent_invert", props, CTMV)
                .addVariant("sea_lantern_frame2", props, MULTI_LAYER_CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("sea_lantern_connected"), "Sea Lantern", "Connected");
        lang.addBlock(getVariant("sea_lantern_dent"), "Sea Lantern", "Dented");
        lang.addBlock(getVariant("sea_lantern_braid"), "Sea Lantern", "Braid");
        lang.addBlock(getVariant("sea_lantern_braid_invert"), "Sea Lantern", "Inverted Braid");
        lang.addBlock(getVariant("sea_lantern_layer"), "Sea Lantern", "Layered");
        lang.addBlock(getVariant("sea_lantern_layer_invert"), "Sea Lantern", "Inverted Layered");
        lang.addBlock(getVariant("sea_lantern_road"), "Sea Lantern", "Road");
        lang.addBlock(getVariant("sea_lantern_road_invert"), "Sea Lantern", "Inverted Road");
        lang.addBlock(getVariant("sea_lantern_checker_small"), "Sea Lantern", "Small Checker");
        lang.addBlock(getVariant("sea_lantern_checker"), "Sea Lantern", "Checker");
        lang.addBlock(getVariant("sea_lantern_bricks"), "Sea Lantern", "Bricks");
        lang.addBlock(getVariant("sea_lantern_bricks_invert"), "Sea Lantern", "Inverted Bricks");
        lang.addBlock(getVariant("sea_lantern_frame1"), "Sea Lantern", "Frame 1");
        lang.addBlock(getVariant("sea_lantern_raw"), "Sea Lantern", "Raw");
        lang.addBlock(getVariant("sea_lantern_pillar_dent"), "Sea Lantern", "Pillar Dented");
        lang.addBlock(getVariant("sea_lantern_pillar_dent_invert"), "Sea Lantern", "Inverted Pillar Dented");
        lang.addBlock(getVariant("sea_lantern_frame2"), "Sea Lantern", "Frame 2");
    }
}