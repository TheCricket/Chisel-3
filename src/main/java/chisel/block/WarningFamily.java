package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WarningFamily extends ChiselBlock {
    public WarningFamily(BlockBehaviour.Properties props) {
        family = builder("warning")
                .addVariant("warning_biohazard", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_chem", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_construction", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_cryogenic", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_death", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_explosion", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_falling", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_falling_objects", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_fire", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_generic", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_illuminati", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_loud", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_no_entry", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_oxygen", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_radiation", props, VariantModelType.MULTI_LAYER)
                .addVariant("warning_voltage", props, VariantModelType.MULTI_LAYER)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("warning_biohazard"), "Warning Block", "Biohazard");
        lang.addBlock(getVariant("warning_chem"), "Warning Block", "Chem");
        lang.addBlock(getVariant("warning_construction"), "Warning Block", "Construction");
        lang.addBlock(getVariant("warning_cryogenic"), "Warning Block", "Cryogenic");
        lang.addBlock(getVariant("warning_death"), "Warning Block", "Death");
        lang.addBlock(getVariant("warning_explosion"), "Warning Block", "Explosion");
        lang.addBlock(getVariant("warning_falling"), "Warning Block", "Falling");
        lang.addBlock(getVariant("warning_falling_objects"), "Warning Block", "Falling Objects");
        lang.addBlock(getVariant("warning_fire"), "Warning Block", "Fire");
        lang.addBlock(getVariant("warning_generic"), "Warning Block", "Generic");
        lang.addBlock(getVariant("warning_illuminati"), "Warning Block", "Illuminati");
        lang.addBlock(getVariant("warning_loud"), "Warning Block", "Loud");
        lang.addBlock(getVariant("warning_no_entry"), "Warning Block", "No Entry");
        lang.addBlock(getVariant("warning_oxygen"), "Warning Block", "Oxygen");
        lang.addBlock(getVariant("warning_radiation"), "Warning Block", "Radiation");
        lang.addBlock(getVariant("warning_voltage"), "Warning Block", "Voltage");
    }
}

