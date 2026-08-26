package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class LaboratoryFamily extends ChiselFamily {
    public LaboratoryFamily(BlockBehaviour.Properties props) {
        family = builder("laboratory")
                .addVariant("laboratory_checkerboard", props)
                .addVariant("laboratory_clearscreen", props, CONNECTED)
                .addVariant("laboratory_console_information", props, CTMH)
                .addVariant("laboratory_console_left", props, CTMH)
                .addVariant("laboratory_console_right", props, CTMH)
                .addVariant("laboratory_floor", props)
                .addVariant("laboratory_panel_clear", props)
                .addVariant("laboratory_panel_dotted", props)
                .addVariant("laboratory_panel_fuzzy", props, CONNECTED)
                .addVariant("laboratory_panel_wall", props)
                .addVariant("laboratory_tiles_enamelled_large", props)
                .addVariant("laboratory_tiles_enamelled_small", props)
                .addVariant("laboratory_tiles_large", props)
                .addVariant("laboratory_tiles_small", props)
                .addVariant("laboratory_tiles_steel_large", props, TBS)
                .addVariant("laboratory_tiles_steel_small", props, TBS)
                .addVariant("laboratory_wall", props)
                .addVariant("laboratory_wall_rounded", props, CONNECTED)
                .addVariant("laboratory_wall_vent", props, TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("laboratory_checkerboard"), "Laboratory Block", "Checkerboard Floor");
        lang.addBlock(getVariant("laboratory_clearscreen"), "Laboratory Block", "Clear Panel");
        lang.addBlock(getVariant("laboratory_console_information"), "Laboratory Block", "Information Console");
        lang.addBlock(getVariant("laboratory_console_left"), "Laboratory Block", "Direction Console (Left)");
        lang.addBlock(getVariant("laboratory_console_right"), "Laboratory Block", "Direction Console (Right)");
        lang.addBlock(getVariant("laboratory_floor"), "Laboratory Block", "Laboratory Floor");
        lang.addBlock(getVariant("laboratory_panel_clear"), "Laboratory Block", "Clear Panel");
        lang.addBlock(getVariant("laboratory_panel_dotted"), "Laboratory Block", "Dotted Panel");
        lang.addBlock(getVariant("laboratory_panel_fuzzy"), "Laboratory Block", "Fuzzy Panel");
        lang.addBlock(getVariant("laboratory_panel_wall"), "Laboratory Block", "Wall Panel");
        lang.addBlock(getVariant("laboratory_tiles_enamelled_large"), "Laboratory Block", "Large Enamelled Tile");
        lang.addBlock(getVariant("laboratory_tiles_enamelled_small"), "Laboratory Block", "Small Enamelled Tiles");
        lang.addBlock(getVariant("laboratory_tiles_large"), "Laboratory Block", "Large Tiles");
        lang.addBlock(getVariant("laboratory_tiles_small"), "Laboratory Block", "Small Tiles");
        lang.addBlock(getVariant("laboratory_tiles_steel_large"), "Laboratory Block", "Large Steel Tile");
        lang.addBlock(getVariant("laboratory_tiles_steel_small"), "Laboratory Block", "Small Steel Tiles");
        lang.addBlock(getVariant("laboratory_wall"), "Laboratory Block", "Enamelled Wall");
        lang.addBlock(getVariant("laboratory_wall_rounded"), "Laboratory Block", "Enamelled Roundel Wall");
        lang.addBlock(getVariant("laboratory_wall_vent"), "Laboratory Block", "Enamelled Wall Vents");
    }
}