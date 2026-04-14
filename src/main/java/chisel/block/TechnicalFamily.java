package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TechnicalFamily extends ChiselBlock {
    public TechnicalFamily(BlockBehaviour.Properties props) {
        family = builder("technical")
                .addVariant("technical_125", props)
                .addVariant("technical_cables", props, VariantModelType.CONNECTED)
                .addVariant("technical_fan_fast", props, VariantModelType.TBS)
                .addVariant("technical_fan_fast_transparent", props, VariantModelType.TBS)
                .addVariant("technical_fan_malfunction", props, VariantModelType.TBS)
                .addVariant("technical_fan_malfunction_slow", props, VariantModelType.TBS)
                .addVariant("technical_fan_still", props, VariantModelType.TBS)
                .addVariant("technical_fan_still_transparent", props, VariantModelType.TBS)
                .addVariant("technical_gears", props)
                .addVariant("technical_grate", props, VariantModelType.CONNECTED)
                .addVariant("technical_grate_rusty", props, VariantModelType.CONNECTED)
                .addVariant("technical_insulation", props, VariantModelType.CONNECTED)
                .addVariant("technical_old", props)
                .addVariant("technical_panel_caution", props)
                .addVariant("technical_scaffold", props, VariantModelType.CONNECTED)
                .addVariant("technical_scaffold_transparent", props, VariantModelType.CONNECTED)
                .addVariant("technical_spinning_stuff", props, VariantModelType.CONNECTED)
                .addVariant("technical_under_large", props, VariantModelType.CONNECTED)
                .addVariant("technical_under_small", props, VariantModelType.CONNECTED)
                .addVariant("technical_vents", props, VariantModelType.CONNECTED)
                .addVariant("technical_vents_glowing", props, VariantModelType.CONNECTED)
                .addVariant("technical_wall_pads", props, VariantModelType.CONNECTED)
                .addVariant("technical_wires", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("technical_125"), "Technical Block", "125");
        lang.addBlock(getVariant("technical_cables"), "Technical Block", "Cables");
        lang.addBlock(getVariant("technical_fan_fast"), "Technical Block", "Fast Fan");
        lang.addBlock(getVariant("technical_fan_fast_transparent"), "Technical Block", "Transparent Fast Fan");
        lang.addBlock(getVariant("technical_fan_malfunction"), "Technical Block", "Malfunctioning Fan");
        lang.addBlock(getVariant("technical_fan_malfunction_slow"), "Technical Block", "Slow Malfunctioning Fan");
        lang.addBlock(getVariant("technical_fan_still"), "Technical Block", "Still Fan");
        lang.addBlock(getVariant("technical_fan_still_transparent"), "Technical Block", "Transparent Still Fan");
        lang.addBlock(getVariant("technical_gears"), "Technical Block", "Gears");
        lang.addBlock(getVariant("technical_grate"), "Technical Block", "Grate");
        lang.addBlock(getVariant("technical_grate_rusty"), "Technical Block", "Rusty Grate");
        lang.addBlock(getVariant("technical_insulation"), "Technical Block", "Insulation");
        lang.addBlock(getVariant("technical_old"), "Technical Block", "Old");
        lang.addBlock(getVariant("technical_panel_caution"), "Technical Block", "Caution Panel");
        lang.addBlock(getVariant("technical_scaffold"), "Technical Block", "Scaffold");
        lang.addBlock(getVariant("technical_scaffold_transparent"), "Technical Block", "Transparent Scaffold");
        lang.addBlock(getVariant("technical_spinning_stuff"), "Technical Block", "Spinning Stuff");
        lang.addBlock(getVariant("technical_under_large"), "Technical Block", "Large Under-layer");
        lang.addBlock(getVariant("technical_under_small"), "Technical Block", "Small Under-layer");
        lang.addBlock(getVariant("technical_vents"), "Technical Block", "Vents");
        lang.addBlock(getVariant("technical_vents_glowing"), "Technical Block", "Glowing Vents");
        lang.addBlock(getVariant("technical_wall_pads"), "Technical Block", "Wall Pads");
        lang.addBlock(getVariant("technical_wires"), "Technical Block", "Wires");
    }
}

