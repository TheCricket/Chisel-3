package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BricksFamily extends ChiselBlock {
    public BricksFamily(BlockBehaviour.Properties props) {
        family = builder("bricks")
                .addVariant(Blocks.BRICKS)
                .addVariant("bricks_array", props)
                .addVariant("bricks_braid", props)
                .addVariant("bricks_chaotic", props)
                .addVariant("bricks_chaotic_medium", props)
                .addVariant("bricks_chaotic_small", props)
                .addVariant("bricks_circular", props)
                .addVariant("bricks_cracked", props)
                .addVariant("bricks_cracked_bricks", props)
                .addVariant("bricks_cuts", props)
                .addVariant("bricks_dent", props)
                .addVariant("bricks_encased", props)
                .addVariant("bricks_french", props)
                .addVariant("bricks_french_2", props)
                .addVariant("bricks_jellybean", props)
                .addVariant("bricks_layers", props)
                .addVariant("bricks_mosaic", props)
                .addVariant("bricks_ornate", props)
                .addVariant("bricks_panel", props)
                .addVariant("bricks_pillar", props, VariantModelType.TBS)
                .addVariant("bricks_prism", props)
                .addVariant("bricks_raw", props)
                .addVariant("bricks_road", props)
                .addVariant("bricks_slanted", props)
                .addVariant("bricks_small", props)
                .addVariant("bricks_soft", props)
                .addVariant("bricks_solid", props)
                .addVariant("bricks_tiles_large", props)
                .addVariant("bricks_tiles_medium", props)
                .addVariant("bricks_tiles_small", props)
                .addVariant("bricks_triple", props)
                .addVariant("bricks_twisted", props, VariantModelType.TBS)
                .addVariant("bricks_weaver", props)
                .addVariant("bricks_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("bricks_array"), "Bricks", "Array");
        lang.addBlock(getVariant("bricks_braid"), "Bricks", "Braid");
        lang.addBlock(getVariant("bricks_chaotic"), "Bricks", "Chaotic");
        lang.addBlock(getVariant("bricks_chaotic_medium"), "Bricks", "Medium Chaotic");
        lang.addBlock(getVariant("bricks_chaotic_small"), "Bricks", "Small Chaotic");
        lang.addBlock(getVariant("bricks_circular"), "Bricks", "Circular");
        lang.addBlock(getVariant("bricks_cracked"), "Bricks", "Cracked");
        lang.addBlock(getVariant("bricks_cracked_bricks"), "Bricks", "Cracked Bricks");
        lang.addBlock(getVariant("bricks_cuts"), "Bricks", "Cuts");
        lang.addBlock(getVariant("bricks_dent"), "Bricks", "Dent");
        lang.addBlock(getVariant("bricks_encased"), "Bricks", "Encased");
        lang.addBlock(getVariant("bricks_french"), "Bricks", "French");
        lang.addBlock(getVariant("bricks_french_2"), "Bricks", "French 2");
        lang.addBlock(getVariant("bricks_jellybean"), "Bricks", "Jellybean");
        lang.addBlock(getVariant("bricks_layers"), "Bricks", "Layers");
        lang.addBlock(getVariant("bricks_mosaic"), "Bricks", "Mosaic");
        lang.addBlock(getVariant("bricks_ornate"), "Bricks", "Ornate");
        lang.addBlock(getVariant("bricks_panel"), "Bricks", "Panel");
        lang.addBlock(getVariant("bricks_pillar"), "Bricks", "Pillar");
        lang.addBlock(getVariant("bricks_prism"), "Bricks", "Prism");
        lang.addBlock(getVariant("bricks_raw"), "Bricks", "Raw");
        lang.addBlock(getVariant("bricks_road"), "Bricks", "Road");
        lang.addBlock(getVariant("bricks_slanted"), "Bricks", "Slanted");
        lang.addBlock(getVariant("bricks_small"), "Bricks", "Small");
        lang.addBlock(getVariant("bricks_soft"), "Bricks", "Soft");
        lang.addBlock(getVariant("bricks_solid"), "Bricks", "Solid");
        lang.addBlock(getVariant("bricks_tiles_large"), "Bricks", "Large Tiles");
        lang.addBlock(getVariant("bricks_tiles_medium"), "Bricks", "Medium Tiles");
        lang.addBlock(getVariant("bricks_tiles_small"), "Bricks", "Small Tiles");
        lang.addBlock(getVariant("bricks_triple"), "Bricks", "Triple");
        lang.addBlock(getVariant("bricks_twisted"), "Bricks", "Twisted");
        lang.addBlock(getVariant("bricks_weaver"), "Bricks", "Weaver");
        lang.addBlock(getVariant("bricks_zag"), "Bricks", "Zag");
    }
}

