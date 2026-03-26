package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LapisBlock extends ChiselBlock {
    public LapisBlock(BlockBehaviour.Properties props) {
        

        family = builder("lapis")
                .addVariant(Blocks.LAPIS_BLOCK)
                .addVariant("lapis_array", props)
                .addVariant("lapis_braid", props)
                .addVariant("lapis_chaotic", props)
                .addVariant("lapis_circular", props)
                .addVariant("lapis_cuts", props)
                .addVariant("lapis_dent", props)
                .addVariant("lapis_french", props)
                .addVariant("lapis_french_2", props)
                .addVariant("lapis_layers", props)
                .addVariant("lapis_ornate", props)
                .addVariant("lapis_panel", props)
                .addVariant("lapis_road", props)
                .addVariant("lapis_tiles", props)
                .addVariant("lapis_weaver", props)
                .addVariant("lapis_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("lapis_array"), "Lapis Lazuli Block", "Array");
        lang.addBlock(getVariant("lapis_braid"), "Lapis Lazuli Block", "Braid");
        lang.addBlock(getVariant("lapis_chaotic"), "Lapis Lazuli Block", "Chaotic");
        lang.addBlock(getVariant("lapis_circular"), "Lapis Lazuli Block", "Circular");
        lang.addBlock(getVariant("lapis_cuts"), "Lapis Lazuli Block", "Cuts");
        lang.addBlock(getVariant("lapis_dent"), "Lapis Lazuli Block", "Dent");
        lang.addBlock(getVariant("lapis_french"), "Lapis Lazuli Block", "French");
        lang.addBlock(getVariant("lapis_french_2"), "Lapis Lazuli Block", "French 2");
        lang.addBlock(getVariant("lapis_layers"), "Lapis Lazuli Block", "Layers");
        lang.addBlock(getVariant("lapis_ornate"), "Lapis Lazuli Block", "Ornate");
        lang.addBlock(getVariant("lapis_panel"), "Lapis Lazuli Block", "Panel");
        lang.addBlock(getVariant("lapis_road"), "Lapis Lazuli Block", "Road");
        lang.addBlock(getVariant("lapis_tiles"), "Lapis Lazuli Block", "Tiles");
        lang.addBlock(getVariant("lapis_weaver"), "Lapis Lazuli Block", "Weaver");
        lang.addBlock(getVariant("lapis_zag"), "Lapis Lazuli Block", "Zag");
    }
}

