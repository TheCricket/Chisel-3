package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class IceBlock extends ChiselBlock {
    public IceBlock(BlockBehaviour.Properties props) {
        

        family = builder("ice")
                .addVariant(Blocks.ICE)
                .addVariant("ice_array", props)
                .addVariant("ice_braid", props)
                .addVariant("ice_chaotic", props)
                .addVariant("ice_circular", props)
                .addVariant("ice_cuts", props)
                .addVariant("ice_dent", props)
                .addVariant("ice_french", props)
                .addVariant("ice_french_2", props)
                .addVariant("ice_layers", props)
                .addVariant("ice_ornate", props)
                .addVariant("ice_panel", props)
                .addVariant("ice_road", props)
                .addVariant("ice_tiles", props)
                .addVariant("ice_weaver", props)
                .addVariant("ice_zag", props)
                .addVariant("ice_pillar_1", props)
                .addVariant("ice_pillar_2", props)
                .addVariant("ice_pillar_3", props)
                .addVariant("ice_pillar_4", props)
                .addVariant("ice_pillar_5", props)
                .addVariant("ice_pillar_6", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("ice_array"), "Ice", "Array");
        lang.addBlock(getVariant("ice_braid"), "Ice", "Braid");
        lang.addBlock(getVariant("ice_chaotic"), "Ice", "Chaotic");
        lang.addBlock(getVariant("ice_circular"), "Ice", "Circular");
        lang.addBlock(getVariant("ice_cuts"), "Ice", "Cuts");
        lang.addBlock(getVariant("ice_dent"), "Ice", "Dent");
        lang.addBlock(getVariant("ice_french"), "Ice", "French");
        lang.addBlock(getVariant("ice_french_2"), "Ice", "French 2");
        lang.addBlock(getVariant("ice_layers"), "Ice", "Layers");
        lang.addBlock(getVariant("ice_ornate"), "Ice", "Ornate");
        lang.addBlock(getVariant("ice_panel"), "Ice", "Panel");
        lang.addBlock(getVariant("ice_road"), "Ice", "Road");
        lang.addBlock(getVariant("ice_tiles"), "Ice", "Tiles");
        lang.addBlock(getVariant("ice_weaver"), "Ice", "Weaver");
        lang.addBlock(getVariant("ice_zag"), "Ice", "Zag");
        lang.addBlock(getVariant("ice_pillar_1"), "Ice", "Pillar 1");
        lang.addBlock(getVariant("ice_pillar_2"), "Ice", "Pillar 2");
        lang.addBlock(getVariant("ice_pillar_3"), "Ice", "Pillar 3");
        lang.addBlock(getVariant("ice_pillar_4"), "Ice", "Pillar 4");
        lang.addBlock(getVariant("ice_pillar_5"), "Ice", "Pillar 5");
        lang.addBlock(getVariant("ice_pillar_6"), "Ice", "Pillar 6");
    }
}

