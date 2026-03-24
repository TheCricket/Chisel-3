package chisel.block.metal;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FactoryBlock extends ChiselBlock {
    public FactoryBlock(BlockBehaviour.Properties props) {
        family = builder("factory")
                .addVariant("factory_circuit", props)
                .addVariant("factory_column", props)
                .addVariant("factory_column_rusty", props)
                .addVariant("factory_dots", props)
                .addVariant("factory_floor", props)
                .addVariant("factory_grate", props)
                .addVariant("factory_hazard", props)
                .addVariant("factory_hazard_orange", props)
                .addVariant("factory_hazard_yellow", props)
                .addVariant("factory_insulation", props)
                .addVariant("factory_metal", props)
                .addVariant("factory_metal_plate", props)
                .addVariant("factory_pipe", props)
                .addVariant("factory_plate", props)
                .addVariant("factory_plate_rusty", props)
                .addVariant("factory_plating", props)
                .addVariant("factory_rust", props)
                .addVariant("factory_tile", props)
                .addVariant("factory_vent", props)
                .addVariant("factory_wall", props)
                .addVariant("factory_wall_rusty", props)
                .addVariant("factory_wire", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("factory_circuit"), "Factory Block", "Circuit");
        lang.addBlock(getVariant("factory_column"), "Factory Block", "Column");
        lang.addBlock(getVariant("factory_column_rusty"), "Factory Block", "Rusty Column");
        lang.addBlock(getVariant("factory_dots"), "Factory Block", "Dots");
        lang.addBlock(getVariant("factory_floor"), "Factory Block", "Floor");
        lang.addBlock(getVariant("factory_grate"), "Factory Block", "Grate");
        lang.addBlock(getVariant("factory_hazard"), "Factory Block", "Hazard");
        lang.addBlock(getVariant("factory_hazard_orange"), "Factory Block", "Orange Hazard");
        lang.addBlock(getVariant("factory_hazard_yellow"), "Factory Block", "Yellow Hazard");
        lang.addBlock(getVariant("factory_insulation"), "Factory Block", "Insulation");
        lang.addBlock(getVariant("factory_metal"), "Factory Block", "Metal");
        lang.addBlock(getVariant("factory_metal_plate"), "Factory Block", "Metal Plate");
        lang.addBlock(getVariant("factory_pipe"), "Factory Block", "Pipe");
        lang.addBlock(getVariant("factory_plate"), "Factory Block", "Plate");
        lang.addBlock(getVariant("factory_plate_rusty"), "Factory Block", "Rusty Plate");
        lang.addBlock(getVariant("factory_plating"), "Factory Block", "Plating");
        lang.addBlock(getVariant("factory_rust"), "Factory Block", "Rust");
        lang.addBlock(getVariant("factory_tile"), "Factory Block", "Tile");
        lang.addBlock(getVariant("factory_vent"), "Factory Block", "Vent");
        lang.addBlock(getVariant("factory_wall"), "Factory Block", "Wall");
        lang.addBlock(getVariant("factory_wall_rusty"), "Factory Block", "Rusty Wall");
        lang.addBlock(getVariant("factory_wire"), "Factory Block", "Wire");
    }
}

