package chisel.block.other;

import chisel.block.ChiselBlock;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RedstoneBlock extends ChiselBlock {
    public RedstoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("redstone")
                .addVariant(Blocks.REDSTONE_BLOCK)
                .addVariant("redstone_array", props)
                .addVariant("redstone_braid", props)
                .addVariant("redstone_chaotic", props)
                .addVariant("redstone_circular", props)
                .addVariant("redstone_cuts", props)
                .addVariant("redstone_dent", props)
                .addVariant("redstone_french", props)
                .addVariant("redstone_french_2", props)
                .addVariant("redstone_layers", props)
                .addVariant("redstone_ornate", props)
                .addVariant("redstone_panel", props)
                .addVariant("redstone_road", props)
                .addVariant("redstone_tiles", props)
                .addVariant("redstone_weaver", props)
                .addVariant("redstone_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("redstone_array"), "Redstone Block", "Array");
        lang.addBlock(getVariant("redstone_braid"), "Redstone Block", "Braid");
        lang.addBlock(getVariant("redstone_chaotic"), "Redstone Block", "Chaotic");
        lang.addBlock(getVariant("redstone_circular"), "Redstone Block", "Circular");
        lang.addBlock(getVariant("redstone_cuts"), "Redstone Block", "Cuts");
        lang.addBlock(getVariant("redstone_dent"), "Redstone Block", "Dent");
        lang.addBlock(getVariant("redstone_french"), "Redstone Block", "French");
        lang.addBlock(getVariant("redstone_french_2"), "Redstone Block", "French 2");
        lang.addBlock(getVariant("redstone_layers"), "Redstone Block", "Layers");
        lang.addBlock(getVariant("redstone_ornate"), "Redstone Block", "Ornate");
        lang.addBlock(getVariant("redstone_panel"), "Redstone Block", "Panel");
        lang.addBlock(getVariant("redstone_road"), "Redstone Block", "Road");
        lang.addBlock(getVariant("redstone_tiles"), "Redstone Block", "Tiles");
        lang.addBlock(getVariant("redstone_weaver"), "Redstone Block", "Weaver");
        lang.addBlock(getVariant("redstone_zag"), "Redstone Block", "Zag");
    }
}

