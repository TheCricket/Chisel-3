package chisel.block.stone;

import chisel.block.ChiselBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;

public class DioriteBlock extends ChiselBlock {
    public DioriteBlock(BlockBehaviour.Properties props) {
        

        family = builder("diorite")
                .addVariant(Blocks.DIORITE)
                .addVariant("diorite_array", props)
                .addVariant("diorite_braid", props)
                .addVariant("diorite_chaotic", props)
                .addVariant("diorite_chaotic_medium", props)
                .addVariant("diorite_chaotic_small", props)
                .addVariant("diorite_circular", props)
                .addVariant("diorite_cracked", props)
                .addVariant("diorite_cracked_bricks", props)
                .addVariant("diorite_cuts", props)
                .addVariant("diorite_dent", props)
                .addVariant("diorite_encased", props)
                .addVariant("diorite_french", props)
                .addVariant("diorite_french_2", props)
                .addVariant("diorite_jellybean", props)
                .addVariant("diorite_layers", props)
                .addVariant("diorite_mosaic", props)
                .addVariant("diorite_ornate", props)
                .addVariant("diorite_panel", props)
                .addVariant("diorite_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("diorite_prism", props)
                .addVariant("diorite_raw", props)
                .addVariant("diorite_road", props)
                .addVariant("diorite_slanted", props)
                .addVariant("diorite_small", props)
                .addVariant("diorite_soft", props)
                .addVariant("diorite_solid", props)
                .addVariant("diorite_tiles_large", props)
                .addVariant("diorite_tiles_medium", props)
                .addVariant("diorite_tiles_small", props)
                .addVariant("diorite_triple", props)
                .addVariant("diorite_twisted", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("diorite_weaver", props)
                .addVariant("diorite_zag", props)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("diorite_array"), "Diorite", "Array");
        lang.addBlock(getVariant("diorite_braid"), "Diorite", "Braid");
        lang.addBlock(getVariant("diorite_chaotic"), "Diorite", "Chaotic");
        lang.addBlock(getVariant("diorite_chaotic_medium"), "Diorite", "Medium Chaotic");
        lang.addBlock(getVariant("diorite_chaotic_small"), "Diorite", "Small Chaotic");
        lang.addBlock(getVariant("diorite_circular"), "Diorite", "Circular");
        lang.addBlock(getVariant("diorite_cracked"), "Diorite", "Cracked");
        lang.addBlock(getVariant("diorite_cracked_bricks"), "Diorite", "Cracked Bricks");
        lang.addBlock(getVariant("diorite_cuts"), "Diorite", "Cuts");
        lang.addBlock(getVariant("diorite_dent"), "Diorite", "Dent");
        lang.addBlock(getVariant("diorite_encased"), "Diorite", "Encased");
        lang.addBlock(getVariant("diorite_french"), "Diorite", "French");
        lang.addBlock(getVariant("diorite_french_2"), "Diorite", "French 2");
        lang.addBlock(getVariant("diorite_jellybean"), "Diorite", "Jellybean");
        lang.addBlock(getVariant("diorite_layers"), "Diorite", "Layers");
        lang.addBlock(getVariant("diorite_mosaic"), "Diorite", "Mosaic");
        lang.addBlock(getVariant("diorite_ornate"), "Diorite", "Ornate");
        lang.addBlock(getVariant("diorite_panel"), "Diorite", "Panel");
        lang.addBlock(getVariant("diorite_pillar"), "Diorite", "Pillar");
        lang.addBlock(getVariant("diorite_prism"), "Diorite", "Prism");
        lang.addBlock(getVariant("diorite_raw"), "Diorite", "Raw");
        lang.addBlock(getVariant("diorite_road"), "Diorite", "Road");
        lang.addBlock(getVariant("diorite_slanted"), "Diorite", "Slanted");
        lang.addBlock(getVariant("diorite_small"), "Diorite", "Small");
        lang.addBlock(getVariant("diorite_soft"), "Diorite", "Soft");
        lang.addBlock(getVariant("diorite_solid"), "Diorite", "Solid");
        lang.addBlock(getVariant("diorite_tiles_large"), "Diorite", "Large Tiles");
        lang.addBlock(getVariant("diorite_tiles_medium"), "Diorite", "Medium Tiles");
        lang.addBlock(getVariant("diorite_tiles_small"), "Diorite", "Small Tiles");
        lang.addBlock(getVariant("diorite_triple"), "Diorite", "Triple");
        lang.addBlock(getVariant("diorite_twisted"), "Diorite", "Twisted");
        lang.addBlock(getVariant("diorite_weaver"), "Diorite", "Weaver");
        lang.addBlock(getVariant("diorite_zag"), "Diorite", "Zag");
    }
}

