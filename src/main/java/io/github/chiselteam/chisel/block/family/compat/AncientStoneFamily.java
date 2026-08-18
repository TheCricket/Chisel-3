package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class AncientStoneFamily extends ChiselFamily {
    public AncientStoneFamily(BlockBehaviour.Properties props) {
        family = builder("ancient_stone")
                .addVariant("ancient_stone_array", props, MULTIBLOCK_2X2)
                .addVariant("ancient_stone_braid", props)
                .addVariant("ancient_stone_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("ancient_stone_chaotic_medium", props)
                .addVariant("ancient_stone_chaotic_small", props)
                .addVariant("ancient_stone_circular", props, CONNECTED)
                .addVariant("ancient_stone_cracked", props)
                .addVariant("ancient_stone_cracked_bricks", props)
                .addVariant("ancient_stone_cuts", props, MULTIBLOCK_4X4)
                .addVariant("ancient_stone_dent", props, CONNECTED)
                .addVariant("ancient_stone_encased", props, CONNECTED)
                .addVariant("ancient_stone_french", props)
                .addVariant("ancient_stone_french_2", props)
                .addVariant("ancient_stone_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("ancient_stone_layers", props)
                .addVariant("ancient_stone_mosaic", props, CONNECTED)
                .addVariant("ancient_stone_ornate", props)
                .addVariant("ancient_stone_panel", props)
                .addVariant("ancient_stone_pillar", props, TBS)
                .addVariant("ancient_stone_prism", props)
                .addVariant("ancient_stone_raw", props)
                .addVariant("ancient_stone_road", props)
                .addVariant("ancient_stone_slanted", props, MULTIBLOCK_2X2)
                .addVariant("ancient_stone_small", props)
                .addVariant("ancient_stone_soft", props)
                .addVariant("ancient_stone_solid", props)
                .addVariant("ancient_stone_tiles_large", props, CONNECTED)
                .addVariant("ancient_stone_tiles_medium", props)
                .addVariant("ancient_stone_tiles_small", props)
                .addVariant("ancient_stone_triple", props)
                .addVariant("ancient_stone_twisted", props, TBS)
                .addVariant("ancient_stone_weaver", props, CONNECTED)
                .addVariant("ancient_stone_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("ancient_stone_array"), "Ancient Stone", "Large Bricks");
        lang.addBlock(getVariant("ancient_stone_braid"), "Ancient Stone", "Braid");
        lang.addBlock(getVariant("ancient_stone_chaotic"), "Ancient Stone", "Varied Bricks");
        lang.addBlock(getVariant("ancient_stone_chaotic_medium"), "Ancient Stone", "Detailed Bricks");
        lang.addBlock(getVariant("ancient_stone_chaotic_small"), "Ancient Stone", "Small Bricks");
        lang.addBlock(getVariant("ancient_stone_circular"), "Ancient Stone", "Circular");
        lang.addBlock(getVariant("ancient_stone_cracked"), "Ancient Stone", "Damaged Bricks");
        lang.addBlock(getVariant("ancient_stone_cracked_bricks"), "Ancient Stone", "Cracked Bricks");
        lang.addBlock(getVariant("ancient_stone_cuts"), "Ancient Stone", "Cuts");
        lang.addBlock(getVariant("ancient_stone_dent"), "Ancient Stone", "Bricks with Dent");
        lang.addBlock(getVariant("ancient_stone_encased"), "Ancient Stone", "Encased");
        lang.addBlock(getVariant("ancient_stone_french"), "Ancient Stone", "Mortarless Bricks");
        lang.addBlock(getVariant("ancient_stone_french_2"), "Ancient Stone", "Aged Bricks");
        lang.addBlock(getVariant("ancient_stone_jellybean"), "Ancient Stone", "Jellybean");
        lang.addBlock(getVariant("ancient_stone_layers"), "Ancient Stone", "Layers");
        lang.addBlock(getVariant("ancient_stone_mosaic"), "Ancient Stone", "Mosaic");
        lang.addBlock(getVariant("ancient_stone_ornate"), "Ancient Stone", "Ornate");
        lang.addBlock(getVariant("ancient_stone_panel"), "Ancient Stone", "Panel");
        lang.addBlock(getVariant("ancient_stone_pillar"), "Ancient Stone", "Pillar");
        lang.addBlock(getVariant("ancient_stone_prism"), "Ancient Stone", "Prism");
        lang.addBlock(getVariant("ancient_stone_raw"), "Ancient Stone", "Raw");
        lang.addBlock(getVariant("ancient_stone_road"), "Ancient Stone", "Road");
        lang.addBlock(getVariant("ancient_stone_slanted"), "Ancient Stone", "Slanted");
        lang.addBlock(getVariant("ancient_stone_small"), "Ancient Stone", "Small Tiles");
        lang.addBlock(getVariant("ancient_stone_soft"), "Ancient Stone", "Yellow Bricks");
        lang.addBlock(getVariant("ancient_stone_solid"), "Ancient Stone", "Solid");
        lang.addBlock(getVariant("ancient_stone_tiles_large"), "Ancient Stone", "Large Tiles");
        lang.addBlock(getVariant("ancient_stone_tiles_medium"), "Ancient Stone", "Medium Tiles");
        lang.addBlock(getVariant("ancient_stone_tiles_small"), "Ancient Stone", "Small Tiles");
        lang.addBlock(getVariant("ancient_stone_triple"), "Ancient Stone", "Triple");
        lang.addBlock(getVariant("ancient_stone_twisted"), "Ancient Stone", "Twisted");
        lang.addBlock(getVariant("ancient_stone_weaver"), "Ancient Stone", "Weaver");
        lang.addBlock(getVariant("ancient_stone_zag"), "Ancient Stone", "Zag");
    }
}

