package chisel.block;

import chisel.block.util.ChiselBlock;
import chisel.core.variant.VariantModelType;
import chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CobblestoneFamily extends ChiselBlock {
    public CobblestoneFamily(BlockBehaviour.Properties props) {
        family = builder("cobblestone")
                .addVariant(Blocks.COBBLESTONE)
                .addVariant("cobblestone_array", props)
                .addVariant("cobblestone_braid", props)
                .addVariant("cobblestone_chaotic", props)
                .addVariant("cobblestone_chaotic_medium", props)
                .addVariant("cobblestone_chaotic_small", props)
                .addVariant("cobblestone_circular", props, VariantModelType.CONNECTED)
                .addVariant("cobblestone_cracked", props)
                .addVariant("cobblestone_cracked_bricks", props)
                .addVariant("cobblestone_cuts", props)
                .addVariant("cobblestone_dent", props, VariantModelType.CONNECTED)
                .addVariant("cobblestone_emboss", props, VariantModelType.CONNECTED)
                .addVariant("cobblestone_encased", props, VariantModelType.CONNECTED)
                .addVariant("cobblestone_french", props)
                .addVariant("cobblestone_french_2", props)
                .addVariant("cobblestone_indent", props, VariantModelType.CONNECTED)
                .addVariant("cobblestone_jellybean", props)
                .addVariant("cobblestone_layers", props)
                .addVariant("cobblestone_marker", props)
                .addVariant("cobblestone_mosaic", props, VariantModelType.CONNECTED)
                .addVariant("cobblestone_ornate", props)
                .addVariant("cobblestone_panel", props)
                .addVariant("cobblestone_pillar", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("cobblestone_prism", props)
                .addVariant("cobblestone_raw", props)
                .addVariant("cobblestone_road", props)
                .addVariant("cobblestone_slanted", props)
                .addVariant("cobblestone_small", props)
                .addVariant("cobblestone_soft", props)
                .addVariant("cobblestone_solid", props)
                .addVariant("cobblestone_tiles_large", props, VariantModelType.CONNECTED)
                .addVariant("cobblestone_tiles_medium", props)
                .addVariant("cobblestone_tiles_small", props)
                .addVariant("cobblestone_triple", props)
                .addVariant("cobblestone_twisted", props, VariantModelType.TOP_BOTTOM_SIDE)
                .addVariant("cobblestone_weaver", props, VariantModelType.CONNECTED)
                .addVariant("cobblestone_zag", props, VariantModelType.CONNECTED)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("cobblestone_array"), "Cobblestone", "Array");
        lang.addBlock(getVariant("cobblestone_braid"), "Cobblestone", "Braid");
        lang.addBlock(getVariant("cobblestone_chaotic"), "Cobblestone", "Chaotic");
        lang.addBlock(getVariant("cobblestone_chaotic_medium"), "Cobblestone", "Medium Chaotic");
        lang.addBlock(getVariant("cobblestone_chaotic_small"), "Cobblestone", "Small Chaotic");
        lang.addBlock(getVariant("cobblestone_circular"), "Cobblestone", "Circular");
        lang.addBlock(getVariant("cobblestone_cracked"), "Cobblestone", "Cracked");
        lang.addBlock(getVariant("cobblestone_cracked_bricks"), "Cobblestone", "Cracked Bricks");
        lang.addBlock(getVariant("cobblestone_cuts"), "Cobblestone", "Cuts");
        lang.addBlock(getVariant("cobblestone_dent"), "Cobblestone", "Dent");
        lang.addBlock(getVariant("cobblestone_emboss"), "Cobblestone", "Emboss");
        lang.addBlock(getVariant("cobblestone_encased"), "Cobblestone", "Encased");
        lang.addBlock(getVariant("cobblestone_french"), "Cobblestone", "French");
        lang.addBlock(getVariant("cobblestone_french_2"), "Cobblestone", "French 2");
        lang.addBlock(getVariant("cobblestone_indent"), "Cobblestone", "Indent");
        lang.addBlock(getVariant("cobblestone_jellybean"), "Cobblestone", "Jellybean");
        lang.addBlock(getVariant("cobblestone_layers"), "Cobblestone", "Layers");
        lang.addBlock(getVariant("cobblestone_marker"), "Cobblestone", "Marker");
        lang.addBlock(getVariant("cobblestone_mosaic"), "Cobblestone", "Mosaic");
        lang.addBlock(getVariant("cobblestone_ornate"), "Cobblestone", "Ornate");
        lang.addBlock(getVariant("cobblestone_panel"), "Cobblestone", "Panel");
        lang.addBlock(getVariant("cobblestone_pillar"), "Cobblestone", "Pillar");
        lang.addBlock(getVariant("cobblestone_prism"), "Cobblestone", "Prism");
        lang.addBlock(getVariant("cobblestone_raw"), "Cobblestone", "Raw");
        lang.addBlock(getVariant("cobblestone_road"), "Cobblestone", "Road");
        lang.addBlock(getVariant("cobblestone_slanted"), "Cobblestone", "Slanted");
        lang.addBlock(getVariant("cobblestone_small"), "Cobblestone", "Small");
        lang.addBlock(getVariant("cobblestone_soft"), "Cobblestone", "Soft");
        lang.addBlock(getVariant("cobblestone_solid"), "Cobblestone", "Solid");
        lang.addBlock(getVariant("cobblestone_tiles_large"), "Cobblestone", "Large Tiles");
        lang.addBlock(getVariant("cobblestone_tiles_medium"), "Cobblestone", "Medium Tiles");
        lang.addBlock(getVariant("cobblestone_tiles_small"), "Cobblestone", "Small Tiles");
        lang.addBlock(getVariant("cobblestone_triple"), "Cobblestone", "Triple");
        lang.addBlock(getVariant("cobblestone_twisted"), "Cobblestone", "Twisted");
        lang.addBlock(getVariant("cobblestone_weaver"), "Cobblestone", "Weaver");
        lang.addBlock(getVariant("cobblestone_zag"), "Cobblestone", "Zag");
    }
}

