package chisel.block.family;

import chisel.block.util.ChiselFamily;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DioriteFamily extends ChiselFamily {
    public DioriteFamily(BlockBehaviour.Properties props) {
        family = builder("diorite")
                .addVariant(Blocks.DIORITE)
                .addVariant("diorite_array", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("diorite_braid", props)
                .addVariant("diorite_chaotic", props, VariantModelType.MULTIBLOCK_3X3)
                .addVariant("diorite_chaotic_medium", props)
                .addVariant("diorite_chaotic_small", props)
                .addVariant("diorite_circular", props, VariantModelType.CONNECTED)
                .addVariant("diorite_cracked", props)
                .addVariant("diorite_cracked_bricks", props)
                .addVariant("diorite_cuts", props, VariantModelType.MULTIBLOCK_4X4)
                .addVariant("diorite_dent", props, VariantModelType.CONNECTED)
                .addVariant("diorite_encased", props, VariantModelType.CONNECTED)
                .addVariant("diorite_french", props)
                .addVariant("diorite_french_2", props)
                .addVariant("diorite_jellybean", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("diorite_layers", props)
                .addVariant("diorite_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("diorite_ornate", props)
                .addVariant("diorite_panel", props)
                .addVariant("diorite_pillar", props, VariantModelType.TBS)
                .addVariant("diorite_prism", props)
                .addVariant("diorite_raw", props)
                .addVariant("diorite_road", props)
                .addVariant("diorite_slanted", props, VariantModelType.MULTIBLOCK_2X2)
                .addVariant("diorite_small", props)
                .addVariant("diorite_soft", props)
                .addVariant("diorite_solid", props)
                .addVariant("diorite_tiles_large", props, VariantModelType.CONNECTED)
                .addVariant("diorite_tiles_medium", props)
                .addVariant("diorite_tiles_small", props)
                .addVariant("diorite_triple", props)
                .addVariant("diorite_twisted", props, VariantModelType.TBS)
                .addVariant("diorite_weaver", props, VariantModelType.CONNECTED)
                .addVariant("diorite_zag", props, VariantModelType.AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("diorite_array"), "Diorite", "Diorite Pillar");
        lang.addBlock(getVariant("diorite_braid"), "Diorite", "Braid");
        lang.addBlock(getVariant("diorite_chaotic"), "Diorite", "Chaotic");
        lang.addBlock(getVariant("diorite_chaotic_medium"), "Diorite", "Diorite Bricks");
        lang.addBlock(getVariant("diorite_chaotic_small"), "Diorite", "Diorite Small Tiles");
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
        lang.addBlock(getVariant("diorite_ornate"), "Diorite", "Ornate Diorite");
        lang.addBlock(getVariant("diorite_panel"), "Diorite", "Panel");
        lang.addBlock(getVariant("diorite_pillar"), "Diorite", "Pillar");
        lang.addBlock(getVariant("diorite_prism"), "Diorite", "Prismatic Diorite");
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

