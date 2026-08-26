package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class FactoryFamily extends ChiselFamily {
    public FactoryFamily(BlockBehaviour.Properties props) {
        family = builder("factory")
                .addVariant("factory_circuit", props, CONNECTED)
                .addVariant("factory_column", props, CTMV)
                .addVariant("factory_dots", props, CONNECTED)
                .addVariant("factory_frame_blue", props, CONNECTED)
                .addVariant("factory_gold_plate", props, CONNECTED)
                .addVariant("factory_gold_plating", props, CONNECTED)
                .addVariant("factory_grinder", props, CONNECTED)
                .addVariant("factory_hazard", props, CONNECTED)
                .addVariant("factory_hazard_orange", props, CONNECTED)
                .addVariant("factory_ice", props, CONNECTED)
                .addVariant("factory_metal_box", props, TBS)
                .addVariant("factory_platex", props, CONNECTED)
                .addVariant("factory_plating", props)
                .addVariant("factory_rust", props, CONNECTED)
                .addVariant("factory_rust2", props, CONNECTED)
                .addVariant("factory_rust_plates", props, CONNECTED)
                .addVariant("factory_tile_mosaic", props, CONNECTED)
                .addVariant("factory_vent", props, CTMV)
                .addVariant("factory_wireframe", props, CONNECTED)
                .addVariant("factory_wireframe_blue", props, CONNECTED)
                .addVariant("factory_wireframe_white", props, CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("factory_circuit"), "Factory Block", "Fancy Circuit Block");
        lang.addBlock(getVariant("factory_column"), "Factory Block", "Worn Metal Column");
        lang.addBlock(getVariant("factory_dots"), "Factory Block", "Rusty Metal Plate with Dotted Pattern");
        lang.addBlock(getVariant("factory_frame_blue"), "Factory Block", "Metallic Blue Circuit Plating");
        lang.addBlock(getVariant("factory_gold_plate"), "Factory Block", "Gold-Plated Fancy Circuit Block");
        lang.addBlock(getVariant("factory_gold_plating"), "Factory Block", "Gold-Plated Rusty Purple Block");
        lang.addBlock(getVariant("factory_grinder"), "Factory Block", "Grinder");
        lang.addBlock(getVariant("factory_hazard"), "Factory Block", "Yellow-Black Hazard Block");
        lang.addBlock(getVariant("factory_hazard_orange"), "Factory Block", "Orange-White Hazard Block");
        lang.addBlock(getVariant("factory_ice"), "Factory Block", "Ice");
        lang.addBlock(getVariant("factory_metal_box"), "Factory Block", "Fancy Metal Box");
        lang.addBlock(getVariant("factory_platex"), "Factory Block", "Plate");
        lang.addBlock(getVariant("factory_plating"), "Factory Block", "Rusty Metal Plate");
        lang.addBlock(getVariant("factory_rust"), "Factory Block", "Very Rusty Metal Plate");
        lang.addBlock(getVariant("factory_rust2"), "Factory Block", "A Metal Plate with Little Rust");
        lang.addBlock(getVariant("factory_rust_plates"), "Factory Block", "Rusty Metal Plates");
        lang.addBlock(getVariant("factory_tile_mosaic"), "Factory Block", "Tile Mosaic");
        lang.addBlock(getVariant("factory_vent"), "Factory Block", "Worn Metal Wall with Ventilation Openings");
        lang.addBlock(getVariant("factory_wireframe"), "Factory Block", "Wireframe");
        lang.addBlock(getVariant("factory_wireframe_blue"), "Factory Block", "Wireframe in a Shade of Purple");
        lang.addBlock(getVariant("factory_wireframe_white"), "Factory Block", "White Wireframe");
    }
}

