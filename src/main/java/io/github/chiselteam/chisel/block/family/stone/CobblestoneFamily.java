package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CobblestoneFamily extends ChiselFamily {
    public CobblestoneFamily(BlockBehaviour.Properties props) {
        family = builder("cobblestone")
                .addVariant(Blocks.COBBLESTONE)
                .addVariant("cobblestone_array", props, MULTIBLOCK_2X2)
                .addVariant("cobblestone_braid", props)
                .addVariant("cobblestone_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("cobblestone_chaotic_medium", props)
                .addVariant("cobblestone_chaotic_small", props)
                .addVariant("cobblestone_circular", props, CONNECTED)
                .addVariant("cobblestone_cracked", props)
                .addVariant("cobblestone_cracked_bricks", props)
                .addVariant("cobblestone_cuts", props, MULTIBLOCK_4X4)
                .addVariant("cobblestone_dent", props, CONNECTED)
                .addVariant("cobblestone_emboss", props, CONNECTED)
                .addVariant("cobblestone_encased", props, CONNECTED)
                .addVariant("cobblestone_french", props)
                .addVariant("cobblestone_french_2", props)
                .addVariant("cobblestone_indent", props, CONNECTED)
                .addVariant("cobblestone_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("cobblestone_layers", props)
                .addVariant("cobblestone_marker", props)
                .addVariant("cobblestone_mosaic", props, CONNECTED)
                .addVariant("cobblestone_ornate", props)
                .addVariant("cobblestone_panel", props)
                .addVariant("cobblestone_pillar", props, TBS)
                .addVariant("cobblestone_prism", props)
                .addVariant("cobblestone_raw", props)
                .addVariant("cobblestone_road", props)
                .addVariant("cobblestone_slanted", props, MULTIBLOCK_2X2)
                .addVariant("cobblestone_small", props)
                .addVariant("cobblestone_soft", props)
                .addVariant("cobblestone_solid", props)
                .addVariant("cobblestone_tiles_large", props, CONNECTED)
                .addVariant("cobblestone_tiles_medium", props)
                .addVariant("cobblestone_tiles_small", props)
                .addVariant("cobblestone_triple", props)
                .addVariant("cobblestone_twisted", props, TBS)
                .addVariant("cobblestone_weaver", props, CONNECTED)
                .addVariant("cobblestone_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("cobblestone_array"), "Cobblestone", "Aligned Cobblestone Bricks");
        lang.addBlock(getVariant("cobblestone_braid"), "Cobblestone", "Braid");
        lang.addBlock(getVariant("cobblestone_chaotic"), "Cobblestone", "Huge Cobblestone Tiles");
        lang.addBlock(getVariant("cobblestone_chaotic_medium"), "Cobblestone", "Detailed Cobblestone Bricks");
        lang.addBlock(getVariant("cobblestone_chaotic_small"), "Cobblestone", "Small Cobblestone Bricks");
        lang.addBlock(getVariant("cobblestone_circular"), "Cobblestone", "Circular");
        lang.addBlock(getVariant("cobblestone_cracked"), "Cobblestone", "Damaged Cobblestone Tiles");
        lang.addBlock(getVariant("cobblestone_cracked_bricks"), "Cobblestone", "Cracked Bricks");
        lang.addBlock(getVariant("cobblestone_cuts"), "Cobblestone", "Cuts");
        lang.addBlock(getVariant("cobblestone_dent"), "Cobblestone", "Cobblestone with Dent");
        lang.addBlock(getVariant("cobblestone_emboss"), "Cobblestone", "Emboss");
        lang.addBlock(getVariant("cobblestone_encased"), "Cobblestone", "Encased");
        lang.addBlock(getVariant("cobblestone_french"), "Cobblestone", "French Cobblestone Tiles");
        lang.addBlock(getVariant("cobblestone_french_2"), "Cobblestone", "French Cobblestone Tiles");
        lang.addBlock(getVariant("cobblestone_indent"), "Cobblestone", "Indent");
        lang.addBlock(getVariant("cobblestone_jellybean"), "Cobblestone", "Jellybean");
        lang.addBlock(getVariant("cobblestone_layers"), "Cobblestone", "Layers");
        lang.addBlock(getVariant("cobblestone_marker"), "Cobblestone", "Marker");
        lang.addBlock(getVariant("cobblestone_mosaic"), "Cobblestone", "Mosaic");
        lang.addBlock(getVariant("cobblestone_ornate"), "Cobblestone", "Ornate");
        lang.addBlock(getVariant("cobblestone_panel"), "Cobblestone", "Cobblestone with Panel");
        lang.addBlock(getVariant("cobblestone_pillar"), "Cobblestone", "Pillar");
        lang.addBlock(getVariant("cobblestone_prism"), "Cobblestone", "Prism");
        lang.addBlock(getVariant("cobblestone_raw"), "Cobblestone", "Raw");
        lang.addBlock(getVariant("cobblestone_road"), "Cobblestone", "Road");
        lang.addBlock(getVariant("cobblestone_slanted"), "Cobblestone", "Slanted");
        lang.addBlock(getVariant("cobblestone_small"), "Cobblestone", "Small Cobblestone Tiles");
        lang.addBlock(getVariant("cobblestone_soft"), "Cobblestone", "Cobblestone with Light Panel");
        lang.addBlock(getVariant("cobblestone_solid"), "Cobblestone", "Cobblestone with Dark Panel");
        lang.addBlock(getVariant("cobblestone_tiles_large"), "Cobblestone", "Large Cobblestone Tiles");
        lang.addBlock(getVariant("cobblestone_tiles_medium"), "Cobblestone", "Medium Tiles");
        lang.addBlock(getVariant("cobblestone_tiles_small"), "Cobblestone", "Small Tiles");
        lang.addBlock(getVariant("cobblestone_triple"), "Cobblestone", "Triple");
        lang.addBlock(getVariant("cobblestone_twisted"), "Cobblestone", "Twisted");
        lang.addBlock(getVariant("cobblestone_weaver"), "Cobblestone", "Weaver");
        lang.addBlock(getVariant("cobblestone_zag"), "Cobblestone", "Zag");
    }
}

