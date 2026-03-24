package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class TechnicalBlock extends ChiselBlock {
    public TechnicalBlock(BlockBehaviour.Properties props) {
        

        family = builder("technical")
                .addVariant("technical_fan", props)
                .addVariant("technical_grate", props)
                .addVariant("technical_hazard", props)
                .addVariant("technical_insulation", props)
                .addVariant("technical_panel", props)
                .addVariant("technical_pipe", props)
                .addVariant("technical_plate", props)
                .addVariant("technical_plating", props)
                .addVariant("technical_rust", props)
                .addVariant("technical_scaffold", props)
                .addVariant("technical_vent", props)
                .addVariant("technical_wall", props)
                .addVariant("technical_wire", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("technical_fan"), "Technical Block", "Fan");
        lang.addBlock(getVariant("technical_grate"), "Technical Block", "Grate");
        lang.addBlock(getVariant("technical_hazard"), "Technical Block", "Hazard");
        lang.addBlock(getVariant("technical_insulation"), "Technical Block", "Insulation");
        lang.addBlock(getVariant("technical_panel"), "Technical Block", "Panel");
        lang.addBlock(getVariant("technical_pipe"), "Technical Block", "Pipe");
        lang.addBlock(getVariant("technical_plate"), "Technical Block", "Plate");
        lang.addBlock(getVariant("technical_plating"), "Technical Block", "Plating");
        lang.addBlock(getVariant("technical_rust"), "Technical Block", "Rust");
        lang.addBlock(getVariant("technical_scaffold"), "Technical Block", "Scaffold");
        lang.addBlock(getVariant("technical_vent"), "Technical Block", "Vent");
        lang.addBlock(getVariant("technical_wall"), "Technical Block", "Wall");
        lang.addBlock(getVariant("technical_wire"), "Technical Block", "Wire");
    }
}

