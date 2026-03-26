package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EmeraldBlock extends ChiselBlock {
    public EmeraldBlock(BlockBehaviour.Properties props) {
        

        family = builder("emerald")
                .addVariant(Blocks.EMERALD_BLOCK)
                .addVariant("emerald_array", props)
                .addVariant("emerald_braid", props)
                .addVariant("emerald_chaotic", props)
                .addVariant("emerald_circular", props)
                .addVariant("emerald_cuts", props)
                .addVariant("emerald_dent", props)
                .addVariant("emerald_french", props)
                .addVariant("emerald_french_2", props)
                .addVariant("emerald_layers", props)
                .addVariant("emerald_ornate", props)
                .addVariant("emerald_panel", props)
                .addVariant("emerald_road", props)
                .addVariant("emerald_tiles", props)
                .addVariant("emerald_weaver", props)
                .addVariant("emerald_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("emerald_array"), "Emerald Block", "Array");
        lang.addBlock(getVariant("emerald_braid"), "Emerald Block", "Braid");
        lang.addBlock(getVariant("emerald_chaotic"), "Emerald Block", "Chaotic");
        lang.addBlock(getVariant("emerald_circular"), "Emerald Block", "Circular");
        lang.addBlock(getVariant("emerald_cuts"), "Emerald Block", "Cuts");
        lang.addBlock(getVariant("emerald_dent"), "Emerald Block", "Dent");
        lang.addBlock(getVariant("emerald_french"), "Emerald Block", "French");
        lang.addBlock(getVariant("emerald_french_2"), "Emerald Block", "French 2");
        lang.addBlock(getVariant("emerald_layers"), "Emerald Block", "Layers");
        lang.addBlock(getVariant("emerald_ornate"), "Emerald Block", "Ornate");
        lang.addBlock(getVariant("emerald_panel"), "Emerald Block", "Panel");
        lang.addBlock(getVariant("emerald_road"), "Emerald Block", "Road");
        lang.addBlock(getVariant("emerald_tiles"), "Emerald Block", "Tiles");
        lang.addBlock(getVariant("emerald_weaver"), "Emerald Block", "Weaver");
        lang.addBlock(getVariant("emerald_zag"), "Emerald Block", "Zag");
    }
}

