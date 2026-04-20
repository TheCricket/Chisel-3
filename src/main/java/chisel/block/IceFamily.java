package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class IceFamily extends ChiselBlock {
    public IceFamily(BlockBehaviour.Properties props) {
        family = builder("ice")
                .addVariant(Blocks.ICE)
                .addVariant("ice_array", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("ice_braid", props)
                .addVariant("ice_chaotic_bricks", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("ice_chaotic_medium", props)
                .addVariant("ice_chaotic_small", props)
                .addVariant("ice_circular", props, VariantModelType.CONNECTED)
                .addVariant("ice_cracked", props)
                .addVariant("ice_cracked_bricks", props)
                .addVariant("ice_cuts", props, VariantModelType.MULTIBLOCK_4X4)
                .addVariant("ice_dent", props, VariantModelType.CONNECTED)
                .addVariant("ice_encased_bricks", props, VariantModelType.CONNECTED)
                .addVariant("ice_french_1", props)
                .addVariant("ice_french_2", props)
                .addVariant("ice_jellybean", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("ice_layers", props)
                .addVariant("ice_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("ice_ornate", props)
                .addVariant("ice_panel", props)
                .addVariant("ice_pillar", props, VariantModelType.TBS)
                .addVariant("ice_pillar_carved", props, VariantModelType.TBS)
                .addVariant("ice_pillar_convex", props, VariantModelType.TBS)
                .addVariant("ice_pillar_greek_greek", props, VariantModelType.TBS)
                .addVariant("ice_pillar_greek_plain", props, VariantModelType.TBS)
                .addVariant("ice_pillar_ornamental", props, VariantModelType.TBS)
                .addVariant("ice_pillar_plain_greek", props, VariantModelType.TBS)
                .addVariant("ice_pillar_plain_plain", props, VariantModelType.TBS)
                .addVariant("ice_prism", props)
                .addVariant("ice_raw", props)
                .addVariant("ice_road", props)
                .addVariant("ice_slanted", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("ice_small_bricks", props)
                .addVariant("ice_soft_bricks", props)
                .addVariant("ice_solid_bricks", props)
                .addVariant("ice_tiles_large", props, VariantModelType.CONNECTED)
                .addVariant("ice_tiles_medium", props)
                .addVariant("ice_tiles_small", props)
                .addVariant("ice_triple_bricks", props)
                .addVariant("ice_twisted", props, VariantModelType.TBS)
                .addVariant("ice_weaver", props, VariantModelType.CONNECTED)
                .addVariant("ice_zag", props, VariantModelType.AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("ice_array"), "Ice", "Array");
        lang.addBlock(getVariant("ice_braid"), "Ice", "Braid");
        lang.addBlock(getVariant("ice_chaotic_bricks"), "Ice", "Chaotic Bricks");
        lang.addBlock(getVariant("ice_chaotic_medium"), "Ice", "Chaotic Medium");
        lang.addBlock(getVariant("ice_chaotic_small"), "Ice", "Chaotic Small");
        lang.addBlock(getVariant("ice_circular"), "Ice", "Circular");
        lang.addBlock(getVariant("ice_cracked"), "Ice", "Cracked");
        lang.addBlock(getVariant("ice_cracked_bricks"), "Ice", "Cracked Bricks");
        lang.addBlock(getVariant("ice_cuts"), "Ice", "Cuts");
        lang.addBlock(getVariant("ice_dent"), "Ice", "Dent");
        lang.addBlock(getVariant("ice_encased_bricks"), "Ice", "Encased Bricks");
        lang.addBlock(getVariant("ice_french_1"), "Ice", "French 1");
        lang.addBlock(getVariant("ice_french_2"), "Ice", "French 2");
        lang.addBlock(getVariant("ice_jellybean"), "Ice", "Jellybean");
        lang.addBlock(getVariant("ice_layers"), "Ice", "Layers");
        lang.addBlock(getVariant("ice_mosaic"), "Ice", "Mosaic");
        lang.addBlock(getVariant("ice_ornate"), "Ice", "Ornate");
        lang.addBlock(getVariant("ice_panel"), "Ice", "Panel");
        lang.addBlock(getVariant("ice_pillar"), "Ice", "Pillar");
        lang.addBlock(getVariant("ice_pillar_carved"), "Ice", "Carved Pillar");
        lang.addBlock(getVariant("ice_pillar_convex"), "Ice", "Convex Pillar");
        lang.addBlock(getVariant("ice_pillar_greek_greek"), "Ice", "Greek-Greek Pillar");
        lang.addBlock(getVariant("ice_pillar_greek_plain"), "Ice", "Greek-Plain Pillar");
        lang.addBlock(getVariant("ice_pillar_ornamental"), "Ice", "Ornamental Pillar");
        lang.addBlock(getVariant("ice_pillar_plain_greek"), "Ice", "Plain-Greek Pillar");
        lang.addBlock(getVariant("ice_pillar_plain_plain"), "Ice", "Plain-Plain Pillar");
        lang.addBlock(getVariant("ice_prism"), "Ice", "Prism");
        lang.addBlock(getVariant("ice_raw"), "Ice", "Raw");
        lang.addBlock(getVariant("ice_road"), "Ice", "Road");
        lang.addBlock(getVariant("ice_slanted"), "Ice", "Slanted");
        lang.addBlock(getVariant("ice_small_bricks"), "Ice", "Small Bricks");
        lang.addBlock(getVariant("ice_soft_bricks"), "Ice", "Soft Bricks");
        lang.addBlock(getVariant("ice_solid_bricks"), "Ice", "Solid Bricks");
        lang.addBlock(getVariant("ice_tiles_large"), "Ice", "Large Tiles");
        lang.addBlock(getVariant("ice_tiles_medium"), "Ice", "Medium Tiles");
        lang.addBlock(getVariant("ice_tiles_small"), "Ice", "Small Tiles");
        lang.addBlock(getVariant("ice_triple_bricks"), "Ice", "Triple Bricks");
        lang.addBlock(getVariant("ice_twisted"), "Ice", "Twisted");
        lang.addBlock(getVariant("ice_weaver"), "Ice", "Weaver");
        lang.addBlock(getVariant("ice_zag"), "Ice", "Zag");
    }
}

