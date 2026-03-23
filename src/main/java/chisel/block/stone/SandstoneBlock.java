package chisel.block.stone;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class SandstoneBlock extends ChiselBlock {
    public SandstoneBlock(BlockBehaviour.Properties props) {
        

        family = builder("sandstone")
                .addVariant(Blocks.SANDSTONE)
                .addVariant("sandstone_array", props)
                .addVariant("sandstone_braid", props)
                .addVariant("sandstone_chaotic_bricks", props)
                .addVariant("sandstone_chaotic_medium", props)
                .addVariant("sandstone_chaotic_small", props)
                .addVariant("sandstone_circular", props)
                .addVariant("sandstone_cracked", props)
                .addVariant("sandstone_cracked_bricks", props)
                .addVariant("sandstone_cuts", props)
                .addVariant("sandstone_dent", props)
                .addVariant("sandstone_emboss", props)
                .addVariant("sandstone_encased_bricks", props)
                .addVariant("sandstone_french", props)
                .addVariant("sandstone_french_2", props)
                .addVariant("sandstone_indent", props)
                .addVariant("sandstone_jellybean", props)
                .addVariant("sandstone_layers", props)
                .addVariant("sandstone_mosaic", props)
                .addVariant("sandstone_ornate", props)
                .addVariant("sandstone_panel", props)
                .addVariant("sandstone_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_prism", props)
                .addVariant("sandstone_road", props)
                .addVariant("sandstone_scribbles_0", props)
                .addVariant("sandstone_scribbles_1", props)
                .addVariant("sandstone_scribbles_2", props)
                .addVariant("sandstone_scribbles_3", props)
                .addVariant("sandstone_scribbles_4", props)
                .addVariant("sandstone_scribbles_5", props)
                .addVariant("sandstone_scribbles_6", props)
                .addVariant("sandstone_scribbles_7", props)
                .addVariant("sandstone_scribbles_8", props)
                .addVariant("sandstone_scribbles_9", props)
                .addVariant("sandstone_slanted", props)
                .addVariant("sandstone_small_bricks", props)
                .addVariant("sandstone_smooth_flat", props)
                .addVariant("sandstone_soft_bricks", props)
                .addVariant("sandstone_solid_bricks", props)
                .addVariant("sandstone_stacked", props)
                .addVariant("sandstone_tiles_large", props)
                .addVariant("sandstone_tiles_medium", props)
                .addVariant("sandstone_tiles_small", props)
                .addVariant("sandstone_triple_bricks", props)
                .addVariant("sandstone_twisted", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("sandstone_weaver", props)
                .addVariant("sandstone_zag", props)
                .getFamily();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("sandstone_array"), "Sandstone", "Array");
        lang.addBlock(getVariant("sandstone_braid"), "Sandstone", "Braid");
        lang.addBlock(getVariant("sandstone_chaotic_bricks"), "Sandstone", "Chaotic Bricks");
        lang.addBlock(getVariant("sandstone_chaotic_medium"), "Sandstone", "Medium Chaotic");
        lang.addBlock(getVariant("sandstone_chaotic_small"), "Sandstone", "Small Chaotic");
        lang.addBlock(getVariant("sandstone_circular"), "Sandstone", "Circular");
        lang.addBlock(getVariant("sandstone_cracked"), "Sandstone", "Cracked");
        lang.addBlock(getVariant("sandstone_cracked_bricks"), "Sandstone", "Cracked Bricks");
        lang.addBlock(getVariant("sandstone_cuts"), "Sandstone", "Cuts");
        lang.addBlock(getVariant("sandstone_dent"), "Sandstone", "Dent");
        lang.addBlock(getVariant("sandstone_emboss"), "Sandstone", "Emboss");
        lang.addBlock(getVariant("sandstone_encased_bricks"), "Sandstone", "Encased Bricks");
        lang.addBlock(getVariant("sandstone_french"), "Sandstone", "French");
        lang.addBlock(getVariant("sandstone_french_2"), "Sandstone", "French 2");
        lang.addBlock(getVariant("sandstone_indent"), "Sandstone", "Indent");
        lang.addBlock(getVariant("sandstone_jellybean"), "Sandstone", "Jellybean");
        lang.addBlock(getVariant("sandstone_layers"), "Sandstone", "Layers");
        lang.addBlock(getVariant("sandstone_mosaic"), "Sandstone", "Mosaic");
        lang.addBlock(getVariant("sandstone_ornate"), "Sandstone", "Ornate");
        lang.addBlock(getVariant("sandstone_panel"), "Sandstone", "Panel");
        lang.addBlock(getVariant("sandstone_pillar"), "Sandstone", "Pillar");
        lang.addBlock(getVariant("sandstone_prism"), "Sandstone", "Prism");
        lang.addBlock(getVariant("sandstone_road"), "Sandstone", "Road");
        lang.addBlock(getVariant("sandstone_scribbles_0"), "Sandstone", "Scribbles 0");
        lang.addBlock(getVariant("sandstone_scribbles_1"), "Sandstone", "Scribbles 1");
        lang.addBlock(getVariant("sandstone_scribbles_2"), "Sandstone", "Scribbles 2");
        lang.addBlock(getVariant("sandstone_scribbles_3"), "Sandstone", "Scribbles 3");
        lang.addBlock(getVariant("sandstone_scribbles_4"), "Sandstone", "Scribbles 4");
        lang.addBlock(getVariant("sandstone_scribbles_5"), "Sandstone", "Scribbles 5");
        lang.addBlock(getVariant("sandstone_scribbles_6"), "Sandstone", "Scribbles 6");
        lang.addBlock(getVariant("sandstone_scribbles_7"), "Sandstone", "Scribbles 7");
        lang.addBlock(getVariant("sandstone_scribbles_8"), "Sandstone", "Scribbles 8");
        lang.addBlock(getVariant("sandstone_scribbles_9"), "Sandstone", "Scribbles 9");
        lang.addBlock(getVariant("sandstone_slanted"), "Sandstone", "Slanted");
        lang.addBlock(getVariant("sandstone_small_bricks"), "Sandstone", "Small Bricks");
        lang.addBlock(getVariant("sandstone_smooth_flat"), "Sandstone", "Smooth Flat");
        lang.addBlock(getVariant("sandstone_soft_bricks"), "Sandstone", "Soft Bricks");
        lang.addBlock(getVariant("sandstone_solid_bricks"), "Sandstone", "Solid Bricks");
        lang.addBlock(getVariant("sandstone_stacked"), "Sandstone", "Stacked");
        lang.addBlock(getVariant("sandstone_tiles_large"), "Sandstone", "Large Tiles");
        lang.addBlock(getVariant("sandstone_tiles_medium"), "Sandstone", "Medium Tiles");
        lang.addBlock(getVariant("sandstone_tiles_small"), "Sandstone", "Small Tiles");
        lang.addBlock(getVariant("sandstone_triple_bricks"), "Sandstone", "Triple Bricks");
        lang.addBlock(getVariant("sandstone_twisted"), "Sandstone", "Twisted");
        lang.addBlock(getVariant("sandstone_weaver"), "Sandstone", "Weaver");
        lang.addBlock(getVariant("sandstone_zag"), "Sandstone", "Zag");
    }
}

