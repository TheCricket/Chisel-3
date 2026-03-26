package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DiamondBlock extends ChiselBlock {
    public DiamondBlock(BlockBehaviour.Properties props) {
        

        family = builder("diamond")
                .addVariant(Blocks.DIAMOND_BLOCK)
                .addVariant("diamond_array", props)
                .addVariant("diamond_braid", props)
                .addVariant("diamond_chaotic", props)
                .addVariant("diamond_circular", props)
                .addVariant("diamond_cuts", props)
                .addVariant("diamond_dent", props)
                .addVariant("diamond_french", props)
                .addVariant("diamond_french_2", props)
                .addVariant("diamond_layers", props)
                .addVariant("diamond_ornate", props)
                .addVariant("diamond_panel", props)
                .addVariant("diamond_road", props)
                .addVariant("diamond_tiles", props)
                .addVariant("diamond_weaver", props)
                .addVariant("diamond_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("diamond_array"), "Diamond Block", "Array");
        lang.addBlock(getVariant("diamond_braid"), "Diamond Block", "Braid");
        lang.addBlock(getVariant("diamond_chaotic"), "Diamond Block", "Chaotic");
        lang.addBlock(getVariant("diamond_circular"), "Diamond Block", "Circular");
        lang.addBlock(getVariant("diamond_cuts"), "Diamond Block", "Cuts");
        lang.addBlock(getVariant("diamond_dent"), "Diamond Block", "Dent");
        lang.addBlock(getVariant("diamond_french"), "Diamond Block", "French");
        lang.addBlock(getVariant("diamond_french_2"), "Diamond Block", "French 2");
        lang.addBlock(getVariant("diamond_layers"), "Diamond Block", "Layers");
        lang.addBlock(getVariant("diamond_ornate"), "Diamond Block", "Ornate");
        lang.addBlock(getVariant("diamond_panel"), "Diamond Block", "Panel");
        lang.addBlock(getVariant("diamond_road"), "Diamond Block", "Road");
        lang.addBlock(getVariant("diamond_tiles"), "Diamond Block", "Tiles");
        lang.addBlock(getVariant("diamond_weaver"), "Diamond Block", "Weaver");
        lang.addBlock(getVariant("diamond_zag"), "Diamond Block", "Zag");
    }
}

