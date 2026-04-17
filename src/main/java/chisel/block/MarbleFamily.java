package chisel.block;

import chisel.block.util.CTMVBlock;
import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MarbleFamily extends ChiselBlock {
    public MarbleFamily(BlockBehaviour.Properties props) {
        family = builder("marble")
                .addVariant("marble_raw", props)
                .addVariant("marble_array", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("marble_braid", props)
                .addVariant("marble_chaotic_bricks", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("marble_chaotic_medium", props)
                .addVariant("marble_chaotic_small", props)
                .addVariant("marble_circular", props, VariantModelType.CONNECTED)
                .addVariant("marble_cracked", props)
                .addVariant("marble_cracked_bricks", props)
                .addVariant("marble_cuts", props, VariantModelType.MULTIBLOCK_4X4)
                .addVariant("marble_dent", props, VariantModelType.CONNECTED)
                .addVariant("marble_encased_bricks", props, VariantModelType.CONNECTED)
                .addVariant("marble_french_1", props)
                .addVariant("marble_french_2", props)
                .addVariant("marble_jellybean", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("marble_layers", props)
                .addVariant("marble_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("marble_ornate", props)
                .addVariant("marble_panel", props)
                .addVariant("marble_pillar", props, VariantModelType.TBS)
                .addVariant("marble_pillar_carved", props, VariantModelType.TBS)
                .addVariant("marble_pillar_convex", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_greek_decor", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_greek_greek", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_greek_plain", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_normal", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_normal2", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_ornamental", props, VariantModelType.TBS)
                .addVariant("marble_pillar_plain_decor", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_plain_greek", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_plain_plain", CTMVBlock::new, () -> props, VariantModelType.CTMV)
                .addVariant("marble_pillar_rough", CTMVBlock::new, () ->props, VariantModelType.CTMV)
                .addVariant("marble_pillar_simple", CTMVBlock::new, () ->props, VariantModelType.CTMV)
                .addVariant("marble_pillar_wide_decor", CTMVBlock::new, () ->props, VariantModelType.CTMV)
                .addVariant("marble_pillar_wide_greek", CTMVBlock::new, () ->props, VariantModelType.CTMV)
                .addVariant("marble_pillar_wide_plain", CTMVBlock::new, () ->props, VariantModelType.CTMV)
                .addVariant("marble_prism", props)
                .addVariant("marble_road", props)
                .addVariant("marble_slanted", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("marble_small_bricks", props)
                .addVariant("marble_soft_bricks", props)
                .addVariant("marble_solid_bricks", props)
                .addVariant("marble_tiles_large", props, VariantModelType.CONNECTED)
                .addVariant("marble_tiles_medium", props)
                .addVariant("marble_tiles_small", props)
                .addVariant("marble_triple_bricks", props)
                .addVariant("marble_twisted", props, VariantModelType.TBS)
                .addVariant("marble_weaver", props, VariantModelType.CONNECTED)
                .addVariant("marble_zag", props, VariantModelType.CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("marble_raw"), "Marble", "Raw Marble");
        lang.addBlock(getVariant("marble_array"), "Marble", "Marble Blocks");
        lang.addBlock(getVariant("marble_braid"), "Marble", "Braid");
        lang.addBlock(getVariant("marble_chaotic_bricks"), "Marble", "Arranged Marble Tiles");
        lang.addBlock(getVariant("marble_chaotic_medium"), "Marble", "Marble Brick");
        lang.addBlock(getVariant("marble_chaotic_small"), "Marble", "Marble Tiles");
        lang.addBlock(getVariant("marble_circular"), "Marble", "Circular");
        lang.addBlock(getVariant("marble_cracked"), "Marble", "Cracked");
        lang.addBlock(getVariant("marble_cracked_bricks"), "Marble", "Cracked Bricks");
        lang.addBlock(getVariant("marble_cuts"), "Marble", "Cuts");
        lang.addBlock(getVariant("marble_dent"), "Marble", "Marble with Dent");
        lang.addBlock(getVariant("marble_encased_bricks"), "Marble", "Encased Bricks");
        lang.addBlock(getVariant("marble_french_1"), "Marble", "French 1");
        lang.addBlock(getVariant("marble_french_2"), "Marble", "French 2");
        lang.addBlock(getVariant("marble_jellybean"), "Marble", "Jellybean");
        lang.addBlock(getVariant("marble_layers"), "Marble", "Layers");
        lang.addBlock(getVariant("marble_mosaic"), "Marble", "Fancy Marble Tiles");
        lang.addBlock(getVariant("marble_ornate"), "Marble", "Ornate Marble Panel");
        lang.addBlock(getVariant("marble_panel"), "Marble", "Marble Panel");
        lang.addBlock(getVariant("marble_pillar"), "Marble", "Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_carved"), "Marble", "Carved Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_convex"), "Marble", "Convex Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_greek_decor"), "Marble", "Greek Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_greek_greek"), "Marble", "Greek Marble Pillar with Greek Capstone");
        lang.addBlock(getVariant("marble_pillar_greek_plain"), "Marble", "Greek Marble Pillar with Plain Capstone");
        lang.addBlock(getVariant("marble_pillar_normal"), "Marble", "Original Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_normal2"), "Marble", "Greek Marble Pillar with Ornate Capstone");
        lang.addBlock(getVariant("marble_pillar_ornamental"), "Marble", "Ornamental Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_plain_decor"), "Marble", "Plain Marble Pillar with Greek Capstone");
        lang.addBlock(getVariant("marble_pillar_plain_greek"), "Marble", "Plain Marble Pillar with Greek Capstone");
        lang.addBlock(getVariant("marble_pillar_plain_plain"), "Marble", "Plain Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_rough"), "Marble", "Rough Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_simple"), "Marble", "Simplistic Marble Pillar");
        lang.addBlock(getVariant("marble_pillar_wide_decor"), "Marble", "Wide Marble Pillar with Greek Capstone");
        lang.addBlock(getVariant("marble_pillar_wide_greek"), "Marble", "Wide Marble Pillar with Greek Capstone");
        lang.addBlock(getVariant("marble_pillar_wide_plain"), "Marble", "Wide Marble Pillar with Plain Capstone");
        lang.addBlock(getVariant("marble_prism"), "Marble", "Prism");
        lang.addBlock(getVariant("marble_road"), "Marble", "Road");
        lang.addBlock(getVariant("marble_slanted"), "Marble", "Slanted");
        lang.addBlock(getVariant("marble_small_bricks"), "Marble", "Small Bricks");
        lang.addBlock(getVariant("marble_soft_bricks"), "Marble", "Soft Bricks");
        lang.addBlock(getVariant("marble_solid_bricks"), "Marble", "Solid Bricks");
        lang.addBlock(getVariant("marble_tiles_large"), "Marble", "Large Tiles");
        lang.addBlock(getVariant("marble_tiles_medium"), "Marble", "Medium Tiles");
        lang.addBlock(getVariant("marble_tiles_small"), "Marble", "Small Tiles");
        lang.addBlock(getVariant("marble_triple_bricks"), "Marble", "Triple Bricks");
        lang.addBlock(getVariant("marble_twisted"), "Marble", "Twisted");
        lang.addBlock(getVariant("marble_weaver"), "Marble", "Weaver");
        lang.addBlock(getVariant("marble_zag"), "Marble", "Zag");
    }
}

