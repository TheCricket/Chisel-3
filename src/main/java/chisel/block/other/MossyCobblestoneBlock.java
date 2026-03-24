package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;

public class MossyCobblestoneBlock extends ChiselBlock {
    public MossyCobblestoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("mossy_cobblestone")
                .addVariant("mossy_cobblestone_array", props)
                .addVariant("mossy_cobblestone_braid", props)
                .addVariant("mossy_cobblestone_chaotic", props)
                .addVariant("mossy_cobblestone_circular", props)
                .addVariant("mossy_cobblestone_cuts", props)
                .addVariant("mossy_cobblestone_dent", props)
                .addVariant("mossy_cobblestone_french", props)
                .addVariant("mossy_cobblestone_french_2", props)
                .addVariant("mossy_cobblestone_layers", props)
                .addVariant("mossy_cobblestone_ornate", props)
                .addVariant("mossy_cobblestone_panel", props)
                .addVariant("mossy_cobblestone_road", props)
                .addVariant("mossy_cobblestone_tiles", props)
                .addVariant("mossy_cobblestone_weaver", props)
                .addVariant("mossy_cobblestone_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("mossy_cobblestone_array"), "Mossy Cobblestone", "Array");
        lang.addBlock(getVariant("mossy_cobblestone_braid"), "Mossy Cobblestone", "Braid");
        lang.addBlock(getVariant("mossy_cobblestone_chaotic"), "Mossy Cobblestone", "Chaotic");
        lang.addBlock(getVariant("mossy_cobblestone_circular"), "Mossy Cobblestone", "Circular");
        lang.addBlock(getVariant("mossy_cobblestone_cuts"), "Mossy Cobblestone", "Cuts");
        lang.addBlock(getVariant("mossy_cobblestone_dent"), "Mossy Cobblestone", "Dent");
        lang.addBlock(getVariant("mossy_cobblestone_french"), "Mossy Cobblestone", "French");
        lang.addBlock(getVariant("mossy_cobblestone_french_2"), "Mossy Cobblestone", "French 2");
        lang.addBlock(getVariant("mossy_cobblestone_layers"), "Mossy Cobblestone", "Layers");
        lang.addBlock(getVariant("mossy_cobblestone_ornate"), "Mossy Cobblestone", "Ornate");
        lang.addBlock(getVariant("mossy_cobblestone_panel"), "Mossy Cobblestone", "Panel");
        lang.addBlock(getVariant("mossy_cobblestone_road"), "Mossy Cobblestone", "Road");
        lang.addBlock(getVariant("mossy_cobblestone_tiles"), "Mossy Cobblestone", "Tiles");
        lang.addBlock(getVariant("mossy_cobblestone_weaver"), "Mossy Cobblestone", "Weaver");
        lang.addBlock(getVariant("mossy_cobblestone_zag"), "Mossy Cobblestone", "Zag");
    }
}

