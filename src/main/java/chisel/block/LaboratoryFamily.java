package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LaboratoryFamily extends ChiselBlock {
    public LaboratoryFamily(BlockBehaviour.Properties props) {
        family = builder("laboratory")
                .addVariant("laboratory_checkerboard", props)
                .addVariant("laboratory_clearscreen", props, VariantModelType.CONNECTED)
                .addVariant("laboratory_console_information", props, VariantModelType.TBS)
                .addVariant("laboratory_console_left", props, VariantModelType.TBS)
                .addVariant("laboratory_console_right", props, VariantModelType.TBS)
                .addVariant("laboratory_floor", props)
                .addVariant("laboratory_panel_clear", props)
                .addVariant("laboratory_panel_dotted", props)
                .addVariant("laboratory_panel_fuzzy", props, VariantModelType.CONNECTED)
                .addVariant("laboratory_panel_wall", props)
                .addVariant("laboratory_tiles_enamelled_large", props)
                .addVariant("laboratory_tiles_enamelled_small", props)
                .addVariant("laboratory_tiles_large", props)
                .addVariant("laboratory_tiles_small", props)
                .addVariant("laboratory_tiles_steel_large", props, VariantModelType.TBS)
                .addVariant("laboratory_tiles_steel_small", props, VariantModelType.TBS)
                .addVariant("laboratory_wall", props)
                .addVariant("laboratory_wall_rounded", props, VariantModelType.CONNECTED)
                .addVariant("laboratory_wall_vent", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("laboratory_checkerboard"), "Laboratory Block", "Checkerboard");
        lang.addBlock(getVariant("laboratory_clearscreen"), "Laboratory Block", "Clear Screen");
        lang.addBlock(getVariant("laboratory_console_information"), "Laboratory Block", "Console Information");
        lang.addBlock(getVariant("laboratory_console_left"), "Laboratory Block", "Console Left");
        lang.addBlock(getVariant("laboratory_console_right"), "Laboratory Block", "Console Right");
        lang.addBlock(getVariant("laboratory_floor"), "Laboratory Block", "Floor");
        lang.addBlock(getVariant("laboratory_panel_clear"), "Laboratory Block", "Clear Panel");
        lang.addBlock(getVariant("laboratory_panel_dotted"), "Laboratory Block", "Dotted Panel");
        lang.addBlock(getVariant("laboratory_panel_fuzzy"), "Laboratory Block", "Fuzzy Panel");
        lang.addBlock(getVariant("laboratory_panel_wall"), "Laboratory Block", "Wall Panel");
        lang.addBlock(getVariant("laboratory_tiles_enamelled_large"), "Laboratory Block", "Enamelled Large Tiles");
        lang.addBlock(getVariant("laboratory_tiles_enamelled_small"), "Laboratory Block", "Enamelled Small Tiles");
        lang.addBlock(getVariant("laboratory_tiles_large"), "Laboratory Block", "Large Tiles");
        lang.addBlock(getVariant("laboratory_tiles_small"), "Laboratory Block", "Small Tiles");
        lang.addBlock(getVariant("laboratory_tiles_steel_large"), "Laboratory Block", "Large Steel Tiles");
        lang.addBlock(getVariant("laboratory_tiles_steel_small"), "Laboratory Block", "Small Steel Tiles");
        lang.addBlock(getVariant("laboratory_wall"), "Laboratory Block", "Wall");
        lang.addBlock(getVariant("laboratory_wall_rounded"), "Laboratory Block", "Rounded Wall");
        lang.addBlock(getVariant("laboratory_wall_vent"), "Laboratory Block", "Wall Vent");
    }
}

