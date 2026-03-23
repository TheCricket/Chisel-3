package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

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
                .getFamily();
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
    }
}

