package chisel.block.other;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class GlowstoneBlock extends ChiselBlock {
    public GlowstoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("glowstone")
                .addVariant(Blocks.GLOWSTONE)
                .addVariant("glowstone_array", props)
                .addVariant("glowstone_braid", props)
                .addVariant("glowstone_chaotic", props)
                .addVariant("glowstone_circular", props)
                .addVariant("glowstone_cuts", props)
                .addVariant("glowstone_dent", props)
                .addVariant("glowstone_french", props)
                .addVariant("glowstone_french_2", props)
                .addVariant("glowstone_layers", props)
                .addVariant("glowstone_ornate", props)
                .addVariant("glowstone_panel", props)
                .addVariant("glowstone_road", props)
                .addVariant("glowstone_tiles", props)
                .addVariant("glowstone_weaver", props)
                .addVariant("glowstone_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("glowstone_array"), "Glowstone", "Array");
        lang.addBlock(getVariant("glowstone_braid"), "Glowstone", "Braid");
        lang.addBlock(getVariant("glowstone_chaotic"), "Glowstone", "Chaotic");
        lang.addBlock(getVariant("glowstone_circular"), "Glowstone", "Circular");
        lang.addBlock(getVariant("glowstone_cuts"), "Glowstone", "Cuts");
        lang.addBlock(getVariant("glowstone_dent"), "Glowstone", "Dent");
        lang.addBlock(getVariant("glowstone_french"), "Glowstone", "French");
        lang.addBlock(getVariant("glowstone_french_2"), "Glowstone", "French 2");
        lang.addBlock(getVariant("glowstone_layers"), "Glowstone", "Layers");
        lang.addBlock(getVariant("glowstone_ornate"), "Glowstone", "Ornate");
        lang.addBlock(getVariant("glowstone_panel"), "Glowstone", "Panel");
        lang.addBlock(getVariant("glowstone_road"), "Glowstone", "Road");
        lang.addBlock(getVariant("glowstone_tiles"), "Glowstone", "Tiles");
        lang.addBlock(getVariant("glowstone_weaver"), "Glowstone", "Weaver");
        lang.addBlock(getVariant("glowstone_zag"), "Glowstone", "Zag");
    }
}

