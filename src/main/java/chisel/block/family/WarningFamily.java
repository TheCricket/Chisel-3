package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WarningFamily extends ChiselFamily {
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
        lang.addBlock(getVariant("warning_biohazard"), "Warning Sign", "Biohazard");
        lang.addBlock(getVariant("warning_chem"), "Warning Sign", "Dangerous Chemicals");
        lang.addBlock(getVariant("warning_construction"), "Warning Sign", "Under Construction");
        lang.addBlock(getVariant("warning_cryogenic"), "Warning Sign", "Cryogenic Freezing in progress");
        lang.addBlock(getVariant("warning_death"), "Warning Sign", "Death");
        lang.addBlock(getVariant("warning_explosion"), "Warning Sign", "Explosion");
        lang.addBlock(getVariant("warning_falling"), "Warning Sign", "Danger of Falling");
        lang.addBlock(getVariant("warning_falling_objects"), "Warning Sign", "Falling Objects");
        lang.addBlock(getVariant("warning_fire"), "Warning Sign", "Fire");
        lang.addBlock(getVariant("warning_generic"), "Warning Sign", "Generic Warning");
        lang.addBlock(getVariant("warning_illuminati"), "Warning Sign", "Illuminati");
        lang.addBlock(getVariant("warning_loud"), "Warning Sign", "Loud Sounds");
        lang.addBlock(getVariant("warning_no_entry"), "Warning Sign", "No Entry");
        lang.addBlock(getVariant("warning_oxygen"), "Warning Sign", "Oxygen Required");
        lang.addBlock(getVariant("warning_radiation"), "Warning Sign", "Radiation");
        lang.addBlock(getVariant("warning_voltage"), "Warning Sign", "High Voltage");
    }
}

