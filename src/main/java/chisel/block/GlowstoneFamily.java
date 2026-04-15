package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GlowstoneFamily extends ChiselBlock {
    public GlowstoneFamily(BlockBehaviour.Properties props) {
        family = builder("glowstone")
                .addVariant(Blocks.GLOWSTONE)
                .addVariant("glowstone_array", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("glowstone_bismuth", props)
                .addVariant("glowstone_braid", props)
                .addVariant("glowstone_chaotic_medium", props)
                .addVariant("glowstone_chaotic_small", props)
                .addVariant("glowstone_circular", props)
                .addVariant("glowstone_cracked", props)
                .addVariant("glowstone_cracked_bricks", props)
                .addVariant("glowstone_dent", props, VariantModelType.CONNECTED)
                .addVariant("glowstone_encased_bricks", props, VariantModelType.CONNECTED)
                .addVariant("glowstone_french_1", props)
                .addVariant("glowstone_french_2", props)
                .addVariant("glowstone_jellybean", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("glowstone_layers", props)
                .addVariant("glowstone_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("glowstone_neon", props)
                .addVariant("glowstone_neon_panel", props)
                .addVariant("glowstone_ornate", props)
                .addVariant("glowstone_panel", props)
                .addVariant("glowstone_pillar", props, VariantModelType.TBS)
                .addVariant("glowstone_prism", props)
                .addVariant("glowstone_road", props)
                .addVariant("glowstone_slanted", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("glowstone_small_bricks", props)
                .addVariant("glowstone_tiles_large", props, VariantModelType.CONNECTED)
                .addVariant("glowstone_tiles_large_bismuth", props)
                .addVariant("glowstone_tiles_medium", props)
                .addVariant("glowstone_tiles_medium_bismuth", props)
                .addVariant("glowstone_triple_bricks", props)
                .addVariant("glowstone_twisted", props, VariantModelType.TBS)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("glowstone_array"), "Glowstone", "Array");
        lang.addBlock(getVariant("glowstone_bismuth"), "Glowstone", "Bismuth");
        lang.addBlock(getVariant("glowstone_braid"), "Glowstone", "Braid");
        lang.addBlock(getVariant("glowstone_chaotic_medium"), "Glowstone", "Chaotic Medium");
        lang.addBlock(getVariant("glowstone_chaotic_small"), "Glowstone", "Chaotic Small");
        lang.addBlock(getVariant("glowstone_circular"), "Glowstone", "Circular");
        lang.addBlock(getVariant("glowstone_cracked"), "Glowstone", "Cracked");
        lang.addBlock(getVariant("glowstone_cracked_bricks"), "Glowstone", "Cracked Bricks");
        lang.addBlock(getVariant("glowstone_dent"), "Glowstone", "Dent");
        lang.addBlock(getVariant("glowstone_encased_bricks"), "Glowstone", "Encased Bricks");
        lang.addBlock(getVariant("glowstone_french_1"), "Glowstone", "French 1");
        lang.addBlock(getVariant("glowstone_french_2"), "Glowstone", "French 2");
        lang.addBlock(getVariant("glowstone_jellybean"), "Glowstone", "Jellybean");
        lang.addBlock(getVariant("glowstone_layers"), "Glowstone", "Layers");
        lang.addBlock(getVariant("glowstone_mosaic"), "Glowstone", "Mosaic");
        lang.addBlock(getVariant("glowstone_neon"), "Glowstone", "Neon");
        lang.addBlock(getVariant("glowstone_neon_panel"), "Glowstone", "Neon Panel");
        lang.addBlock(getVariant("glowstone_ornate"), "Glowstone", "Ornate");
        lang.addBlock(getVariant("glowstone_panel"), "Glowstone", "Panel");
        lang.addBlock(getVariant("glowstone_pillar"), "Glowstone", "Pillar");
        lang.addBlock(getVariant("glowstone_prism"), "Glowstone", "Prism");
        lang.addBlock(getVariant("glowstone_road"), "Glowstone", "Road");
        lang.addBlock(getVariant("glowstone_slanted"), "Glowstone", "Slanted");
        lang.addBlock(getVariant("glowstone_small_bricks"), "Glowstone", "Small Bricks");
        lang.addBlock(getVariant("glowstone_tiles_large"), "Glowstone", "Large Tiles");
        lang.addBlock(getVariant("glowstone_tiles_large_bismuth"), "Glowstone", "Large Bismuth Tiles");
        lang.addBlock(getVariant("glowstone_tiles_medium"), "Glowstone", "Medium Tiles");
        lang.addBlock(getVariant("glowstone_tiles_medium_bismuth"), "Glowstone", "Medium Bismuth Tiles");
        lang.addBlock(getVariant("glowstone_triple_bricks"), "Glowstone", "Triple Bricks");
        lang.addBlock(getVariant("glowstone_twisted"), "Glowstone", "Twisted");
    }
}

