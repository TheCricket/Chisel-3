package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class AndesiteFamily extends ChiselFamily {
    public AndesiteFamily(BlockBehaviour.Properties props) {
        family = builder("andesite")
                .addVariant(Blocks.ANDESITE)
                .addVariant("andesite_array", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("andesite_braid", props)
                .addVariant("andesite_chaotic_bricks", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("andesite_chaotic_medium", props)
                .addVariant("andesite_chaotic_small", props)
                .addVariant("andesite_circular", props, VariantModelType.CONNECTED)
                .addVariant("andesite_cracked", props)
                .addVariant("andesite_cracked_bricks", props)
                .addVariant("andesite_cuts", props, VariantModelType.MULTIBLOCK_4X4)
                .addVariant("andesite_dent", props, VariantModelType.CONNECTED)
                .addVariant("andesite_encased_bricks", props, VariantModelType.CONNECTED)
                .addVariant("andesite_french_1", props)
                .addVariant("andesite_french_2", props)
                .addVariant("andesite_jellybean", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("andesite_layers", props)
                .addVariant("andesite_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("andesite_ornate", props)
                .addVariant("andesite_panel", props)
                .addVariant("andesite_pillar", props, VariantModelType.TBS)
                .addVariant("andesite_prism", props)
                .addVariant("andesite_road", props)
                .addVariant("andesite_slanted", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("andesite_small_bricks", props)
                .addVariant("andesite_soft_bricks", props)
                .addVariant("andesite_solid_bricks", props)
                .addVariant("andesite_tiles_large", props, VariantModelType.CONNECTED)
                .addVariant("andesite_tiles_medium", props)
                .addVariant("andesite_tiles_small", props)
                .addVariant("andesite_triple_bricks", props)
                .addVariant("andesite_twisted", props, VariantModelType.TBS)
                .addVariant("andesite_weaver", props, VariantModelType.CONNECTED)
                .addVariant("andesite_zag", props, VariantModelType.AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("andesite_array"), "Andesite", "Andesite Pillar");
        lang.addBlock(getVariant("andesite_braid"), "Andesite", "Braid");
        lang.addBlock(getVariant("andesite_chaotic_bricks"), "Andesite", "Chaotic Bricks");
        lang.addBlock(getVariant("andesite_chaotic_medium"), "Andesite", "Andesite Bricks");
        lang.addBlock(getVariant("andesite_chaotic_small"), "Andesite", "Andesite Small Tiles");
        lang.addBlock(getVariant("andesite_circular"), "Andesite", "Circular");
        lang.addBlock(getVariant("andesite_cracked"), "Andesite", "Cracked");
        lang.addBlock(getVariant("andesite_cracked_bricks"), "Andesite", "Cracked Bricks");
        lang.addBlock(getVariant("andesite_cuts"), "Andesite", "Cuts");
        lang.addBlock(getVariant("andesite_dent"), "Andesite", "Dent");
        lang.addBlock(getVariant("andesite_encased_bricks"), "Andesite", "Encased Bricks");
        lang.addBlock(getVariant("andesite_french_1"), "Andesite", "French 1");
        lang.addBlock(getVariant("andesite_french_2"), "Andesite", "French 2");
        lang.addBlock(getVariant("andesite_jellybean"), "Andesite", "Jellybean");
        lang.addBlock(getVariant("andesite_layers"), "Andesite", "Layers");
        lang.addBlock(getVariant("andesite_mosaic"), "Andesite", "Mosaic");
        lang.addBlock(getVariant("andesite_ornate"), "Andesite", "Ornate Andesite");
        lang.addBlock(getVariant("andesite_panel"), "Andesite", "Panel");
        lang.addBlock(getVariant("andesite_pillar"), "Andesite", "Pillar");
        lang.addBlock(getVariant("andesite_prism"), "Andesite", "Prismatic Andesite");
        lang.addBlock(getVariant("andesite_road"), "Andesite", "Road");
        lang.addBlock(getVariant("andesite_slanted"), "Andesite", "Slanted");
        lang.addBlock(getVariant("andesite_small_bricks"), "Andesite", "Small Bricks");
        lang.addBlock(getVariant("andesite_soft_bricks"), "Andesite", "Soft Bricks");
        lang.addBlock(getVariant("andesite_solid_bricks"), "Andesite", "Solid Bricks");
        lang.addBlock(getVariant("andesite_tiles_large"), "Andesite", "Large Tiles");
        lang.addBlock(getVariant("andesite_tiles_medium"), "Andesite", "Medium Tiles");
        lang.addBlock(getVariant("andesite_tiles_small"), "Andesite", "Small Tiles");
        lang.addBlock(getVariant("andesite_triple_bricks"), "Andesite", "Triple Bricks");
        lang.addBlock(getVariant("andesite_twisted"), "Andesite", "Twisted");
        lang.addBlock(getVariant("andesite_weaver"), "Andesite", "Weaver");
        lang.addBlock(getVariant("andesite_zag"), "Andesite", "Zag");
    }
}

