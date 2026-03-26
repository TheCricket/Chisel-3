package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LaboratoryBlock extends ChiselBlock {
    public LaboratoryBlock(BlockBehaviour.Properties props) {
        

        family = builder("laboratory")
                .addVariant("laboratory_boiler", props)
                .addVariant("laboratory_bricks", props)
                .addVariant("laboratory_bubble", props)
                .addVariant("laboratory_cell", props)
                .addVariant("laboratory_circles", props)
                .addVariant("laboratory_conwall", props)
                .addVariant("laboratory_dotted", props)
                .addVariant("laboratory_faded", props)
                .addVariant("laboratory_floor", props)
                .addVariant("laboratory_infusion", props)
                .addVariant("laboratory_metal", props)
                .addVariant("laboratory_panel", props)
                .addVariant("laboratory_panel_broken", props)
                .addVariant("laboratory_panel_cracked", props)
                .addVariant("laboratory_plating", props)
                .addVariant("laboratory_shale", props)
                .addVariant("laboratory_tile", props)
                .addVariant("laboratory_wall", props)
                .addVariant("laboratory_checkerboard", props)
                .addVariant("laboratory_clearscreen", props)
                .addVariant("laboratory_console_informatio", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("laboratory_panel_clear", props)
                .addVariant("laboratory_panel_dotted", props)
                .addVariant("laboratory_panel_fuzzy", props)
                .addVariant("laboratory_panel_wall", props)
                .addVariant("laboratory_tiles_enamelled_la", props)
                .addVariant("laboratory_tiles_enamelled_sm", props)
                .addVariant("laboratory_tiles_large", props)
                .addVariant("laboratory_tiles_small", props)
                .addVariant("laboratory_tiles_steel_large", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("laboratory_tiles_steel_small", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("laboratory_wall_rounded", props)
                .addVariant("laboratory_wall_vent", props, VariantModelType.TOP_BOTTOM_SIDE)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("laboratory_boiler"), "Laboratory Block", "Boiler");
        lang.addBlock(getVariant("laboratory_bricks"), "Laboratory Block", "Bricks");
        lang.addBlock(getVariant("laboratory_bubble"), "Laboratory Block", "Bubble");
        lang.addBlock(getVariant("laboratory_cell"), "Laboratory Block", "Cell");
        lang.addBlock(getVariant("laboratory_circles"), "Laboratory Block", "Circles");
        lang.addBlock(getVariant("laboratory_conwall"), "Laboratory Block", "Conwall");
        lang.addBlock(getVariant("laboratory_dotted"), "Laboratory Block", "Dotted");
        lang.addBlock(getVariant("laboratory_faded"), "Laboratory Block", "Faded");
        lang.addBlock(getVariant("laboratory_floor"), "Laboratory Block", "Floor");
        lang.addBlock(getVariant("laboratory_infusion"), "Laboratory Block", "Infusion");
        lang.addBlock(getVariant("laboratory_metal"), "Laboratory Block", "Metal");
        lang.addBlock(getVariant("laboratory_panel"), "Laboratory Block", "Panel");
        lang.addBlock(getVariant("laboratory_panel_broken"), "Laboratory Block", "Broken Panel");
        lang.addBlock(getVariant("laboratory_panel_cracked"), "Laboratory Block", "Cracked Panel");
        lang.addBlock(getVariant("laboratory_plating"), "Laboratory Block", "Plating");
        lang.addBlock(getVariant("laboratory_shale"), "Laboratory Block", "Shale");
        lang.addBlock(getVariant("laboratory_tile"), "Laboratory Block", "Tile");
        lang.addBlock(getVariant("laboratory_wall"), "Laboratory Block", "Wall");
        lang.addBlock(getVariant("laboratory_checkerboard"), "Laboratory Block", "Checkerboard");
        lang.addBlock(getVariant("laboratory_clearscreen"), "Laboratory Block", "Clearscreen");
        lang.addBlock(getVariant("laboratory_console_informatio"), "Laboratory Block", "Console Information");
        lang.addBlock(getVariant("laboratory_panel_clear"), "Laboratory Block", "Clear Panel");
        lang.addBlock(getVariant("laboratory_panel_dotted"), "Laboratory Block", "Dotted Panel");
        lang.addBlock(getVariant("laboratory_panel_fuzzy"), "Laboratory Block", "Fuzzy Panel");
        lang.addBlock(getVariant("laboratory_panel_wall"), "Laboratory Block", "Wall Panel");
        lang.addBlock(getVariant("laboratory_tiles_enamelled_la"), "Laboratory Block", "Enamelled Large Tiles");
        lang.addBlock(getVariant("laboratory_tiles_enamelled_sm"), "Laboratory Block", "Enamelled Small Tiles");
        lang.addBlock(getVariant("laboratory_tiles_large"), "Laboratory Block", "Large Tiles");
        lang.addBlock(getVariant("laboratory_tiles_small"), "Laboratory Block", "Small Tiles");
        lang.addBlock(getVariant("laboratory_tiles_steel_large"), "Laboratory Block", "Large Steel Tiles");
        lang.addBlock(getVariant("laboratory_tiles_steel_small"), "Laboratory Block", "Small Steel Tiles");
        lang.addBlock(getVariant("laboratory_wall_rounded"), "Laboratory Block", "Rounded Wall");
        lang.addBlock(getVariant("laboratory_wall_vent"), "Laboratory Block", "Wall Vent");
    }
}

