package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FactoryFamily extends ChiselBlock {
    public FactoryFamily(BlockBehaviour.Properties props) {
        family = builder("factory")
                .addVariant("factory_circuit", props, VariantModelType.CONNECTED)
                .addVariant("factory_column", props, VariantModelType.CONNECTED_TBS)
                .addVariant("factory_dots", props, VariantModelType.CONNECTED)
                .addVariant("factory_frame_blue", props, VariantModelType.CONNECTED)
                .addVariant("factory_gold_plate", props, VariantModelType.CONNECTED)
                .addVariant("factory_gold_plating", props, VariantModelType.CONNECTED)
                .addVariant("factory_grinder", props, VariantModelType.CONNECTED)
                .addVariant("factory_hazard", props, VariantModelType.CONNECTED)
                .addVariant("factory_hazard_orange", props, VariantModelType.CONNECTED)
                .addVariant("factory_ice", props, VariantModelType.CONNECTED)
                .addVariant("factory_metal_box", props, VariantModelType.TBS)
                .addVariant("factory_platex", props, VariantModelType.CONNECTED)
                .addVariant("factory_plating", props)
                .addVariant("factory_rust", props, VariantModelType.CONNECTED)
                .addVariant("factory_rust2", props, VariantModelType.CONNECTED)
                .addVariant("factory_rust_plates", props, VariantModelType.CONNECTED)
                .addVariant("factory_tile_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("factory_vent", props, VariantModelType.CONNECTED_TBS)
                .addVariant("factory_wireframe", props, VariantModelType.CONNECTED)
                .addVariant("factory_wireframe_blue", props, VariantModelType.CONNECTED)
                .addVariant("factory_wireframe_white", props, VariantModelType.CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("factory_circuit"), "Factory Block", "Circuit");
        lang.addBlock(getVariant("factory_column"), "Factory Block", "Column");
        lang.addBlock(getVariant("factory_dots"), "Factory Block", "Dots");
        lang.addBlock(getVariant("factory_frame_blue"), "Factory Block", "Blue Frame");
        lang.addBlock(getVariant("factory_gold_plate"), "Factory Block", "Gold Plate");
        lang.addBlock(getVariant("factory_gold_plating"), "Factory Block", "Gold Plating");
        lang.addBlock(getVariant("factory_grinder"), "Factory Block", "Grinder");
        lang.addBlock(getVariant("factory_hazard"), "Factory Block", "Hazard");
        lang.addBlock(getVariant("factory_hazard_orange"), "Factory Block", "Orange Hazard");
        lang.addBlock(getVariant("factory_ice"), "Factory Block", "Ice");
        lang.addBlock(getVariant("factory_metal_box"), "Factory Block", "Metal Box");
        lang.addBlock(getVariant("factory_platex"), "Factory Block", "Plate");
        lang.addBlock(getVariant("factory_plating"), "Factory Block", "Plating");
        lang.addBlock(getVariant("factory_rust"), "Factory Block", "Rust");
        lang.addBlock(getVariant("factory_rust2"), "Factory Block", "Rust 2");
        lang.addBlock(getVariant("factory_rust_plates"), "Factory Block", "Rusty Plates");
        lang.addBlock(getVariant("factory_tile_mosaic"), "Factory Block", "Tile Mosaic");
        lang.addBlock(getVariant("factory_vent"), "Factory Block", "Vent");
        lang.addBlock(getVariant("factory_wireframe"), "Factory Block", "Wireframe");
        lang.addBlock(getVariant("factory_wireframe_blue"), "Factory Block", "Blue Wireframe");
        lang.addBlock(getVariant("factory_wireframe_white"), "Factory Block", "White Wireframe");
    }
}

