package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MossyCobblestoneFamily extends ChiselBlock {
    public MossyCobblestoneFamily(BlockBehaviour.Properties props) {
        family = builder("mossy_cobblestone")
                .addVariant("mossy_cobblestone_array", props)
                .addVariant("mossy_cobblestone_braid", props)
                .addVariant("mossy_cobblestone_chaotic", props)
                .addVariant("mossy_cobblestone_chaotic_medium", props)
                .addVariant("mossy_cobblestone_chaotic_small", props)
                .addVariant("mossy_cobblestone_circular", props, VariantModelType.CONNECTED)
                .addVariant("mossy_cobblestone_cracked", props)
                .addVariant("mossy_cobblestone_cracked_bricks", props)
                .addVariant("mossy_cobblestone_cuts", props)
                .addVariant("mossy_cobblestone_dent", props, VariantModelType.CONNECTED)
                .addVariant("mossy_cobblestone_emboss", props, VariantModelType.CONNECTED)
                .addVariant("mossy_cobblestone_encased", props, VariantModelType.CONNECTED)
                .addVariant("mossy_cobblestone_french", props)
                .addVariant("mossy_cobblestone_french_2", props)
                .addVariant("mossy_cobblestone_indent", props, VariantModelType.CONNECTED)
                .addVariant("mossy_cobblestone_jellybean", props)
                .addVariant("mossy_cobblestone_layers", props)
                .addVariant("mossy_cobblestone_marker", props)
                .addVariant("mossy_cobblestone_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("mossy_cobblestone_ornate", props)
                .addVariant("mossy_cobblestone_panel", props)
                .addVariant("mossy_cobblestone_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("mossy_cobblestone_prism", props)
                .addVariant("mossy_cobblestone_raw", props)
                .addVariant("mossy_cobblestone_road", props)
                .addVariant("mossy_cobblestone_slanted", props)
                .addVariant("mossy_cobblestone_small", props)
                .addVariant("mossy_cobblestone_soft", props)
                .addVariant("mossy_cobblestone_solid", props)
                .addVariant("mossy_cobblestone_tiles_large", props, VariantModelType.CONNECTED)
                .addVariant("mossy_cobblestone_tiles_medium", props)
                .addVariant("mossy_cobblestone_tiles_small", props)
                .addVariant("mossy_cobblestone_triple", props)
                .addVariant("mossy_cobblestone_twisted", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("mossy_cobblestone_weaver", props, VariantModelType.CONNECTED)
                .addVariant("mossy_cobblestone_zag", props, VariantModelType.CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("mossy_cobblestone_array"), "Mossy Cobblestone", "Array");
        lang.addBlock(getVariant("mossy_cobblestone_braid"), "Mossy Cobblestone", "Braid");
        lang.addBlock(getVariant("mossy_cobblestone_chaotic"), "Mossy Cobblestone", "Chaotic");
        lang.addBlock(getVariant("mossy_cobblestone_chaotic_medium"), "Mossy Cobblestone", "Medium Chaotic");
        lang.addBlock(getVariant("mossy_cobblestone_chaotic_small"), "Mossy Cobblestone", "Small Chaotic");
        lang.addBlock(getVariant("mossy_cobblestone_circular"), "Mossy Cobblestone", "Circular");
        lang.addBlock(getVariant("mossy_cobblestone_cracked"), "Mossy Cobblestone", "Cracked");
        lang.addBlock(getVariant("mossy_cobblestone_cracked_bricks"), "Mossy Cobblestone", "Cracked Bricks");
        lang.addBlock(getVariant("mossy_cobblestone_cuts"), "Mossy Cobblestone", "Cuts");
        lang.addBlock(getVariant("mossy_cobblestone_dent"), "Mossy Cobblestone", "Dent");
        lang.addBlock(getVariant("mossy_cobblestone_emboss"), "Mossy Cobblestone", "Emboss");
        lang.addBlock(getVariant("mossy_cobblestone_encased"), "Mossy Cobblestone", "Encased");
        lang.addBlock(getVariant("mossy_cobblestone_french"), "Mossy Cobblestone", "French");
        lang.addBlock(getVariant("mossy_cobblestone_french_2"), "Mossy Cobblestone", "French 2");
        lang.addBlock(getVariant("mossy_cobblestone_indent"), "Mossy Cobblestone", "Indent");
        lang.addBlock(getVariant("mossy_cobblestone_jellybean"), "Mossy Cobblestone", "Jellybean");
        lang.addBlock(getVariant("mossy_cobblestone_layers"), "Mossy Cobblestone", "Layers");
        lang.addBlock(getVariant("mossy_cobblestone_marker"), "Mossy Cobblestone", "Marker");
        lang.addBlock(getVariant("mossy_cobblestone_mosaic"), "Mossy Cobblestone", "Mosaic");
        lang.addBlock(getVariant("mossy_cobblestone_ornate"), "Mossy Cobblestone", "Ornate");
        lang.addBlock(getVariant("mossy_cobblestone_panel"), "Mossy Cobblestone", "Panel");
        lang.addBlock(getVariant("mossy_cobblestone_pillar"), "Mossy Cobblestone", "Pillar");
        lang.addBlock(getVariant("mossy_cobblestone_prism"), "Mossy Cobblestone", "Prism");
        lang.addBlock(getVariant("mossy_cobblestone_raw"), "Mossy Cobblestone", "Raw");
        lang.addBlock(getVariant("mossy_cobblestone_road"), "Mossy Cobblestone", "Road");
        lang.addBlock(getVariant("mossy_cobblestone_slanted"), "Mossy Cobblestone", "Slanted");
        lang.addBlock(getVariant("mossy_cobblestone_small"), "Mossy Cobblestone", "Small");
        lang.addBlock(getVariant("mossy_cobblestone_soft"), "Mossy Cobblestone", "Soft");
        lang.addBlock(getVariant("mossy_cobblestone_solid"), "Mossy Cobblestone", "Solid");
        lang.addBlock(getVariant("mossy_cobblestone_tiles_large"), "Mossy Cobblestone", "Large Tiles");
        lang.addBlock(getVariant("mossy_cobblestone_tiles_medium"), "Mossy Cobblestone", "Medium Tiles");
        lang.addBlock(getVariant("mossy_cobblestone_tiles_small"), "Mossy Cobblestone", "Small Tiles");
        lang.addBlock(getVariant("mossy_cobblestone_triple"), "Mossy Cobblestone", "Triple");
        lang.addBlock(getVariant("mossy_cobblestone_twisted"), "Mossy Cobblestone", "Twisted");
        lang.addBlock(getVariant("mossy_cobblestone_weaver"), "Mossy Cobblestone", "Weaver");
        lang.addBlock(getVariant("mossy_cobblestone_zag"), "Mossy Cobblestone", "Zag");
    }
}
