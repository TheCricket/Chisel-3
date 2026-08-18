package io.github.chiselteam.chisel.block.family.stone;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class DeepslateFamily extends ChiselFamily {
    public DeepslateFamily(BlockBehaviour.Properties props) {
        family = builder("deepslate")
                .addVariant(Blocks.DEEPSLATE)
                .addVariant(Blocks.POLISHED_DEEPSLATE)
                .addVariant("deepslate_array", props, MULTIBLOCK_2X2)
                .addVariant("deepslate_braid", props)
                .addVariant("deepslate_chaotic_bricks", props, MULTIBLOCK_3X3)
                .addVariant("deepslate_chaotic_medium", props)
                .addVariant("deepslate_chaotic_small", props)
                .addVariant("deepslate_circular", props, CONNECTED)
                .addVariant("deepslate_cracked", props)
                .addVariant("deepslate_cracked_bricks", props)
                .addVariant("deepslate_cuts", props, MULTIBLOCK_4X4)
                .addVariant("deepslate_dent", props, CONNECTED)
                .addVariant("deepslate_encased_bricks", props, CONNECTED)
                .addVariant("deepslate_french_1", props)
                .addVariant("deepslate_french_2", props)
                .addVariant("deepslate_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("deepslate_layers", props)
                .addVariant("deepslate_mosaic", props, CONNECTED)
                .addVariant("deepslate_ornate", props)
                .addVariant("deepslate_panel", props)
                .addVariant("deepslate_pillar", props, TBS)
                .addVariant("deepslate_prism", props)
                .addVariant("deepslate_road", props)
                .addVariant("deepslate_slanted", props, MULTIBLOCK_2X2)
                .addVariant("deepslate_small_bricks", props)
                .addVariant("deepslate_soft_bricks", props)
                .addVariant("deepslate_solid_bricks", props)
                .addVariant("deepslate_tiles_large", props, CONNECTED)
                .addVariant("deepslate_tiles_medium", props)
                .addVariant("deepslate_tiles_small", props)
                .addVariant("deepslate_triple_bricks", props)
                .addVariant("deepslate_twisted", props, TBS)
                .addVariant("deepslate_weaver", props, CONNECTED)
                .addVariant("deepslate_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("deepslate_array"), "Deepslate", "Deepslate Pillar");
        lang.addBlock(getVariant("deepslate_braid"), "Deepslate", "Braid");
        lang.addBlock(getVariant("deepslate_chaotic_bricks"), "Deepslate", "Chaotic Bricks");
        lang.addBlock(getVariant("deepslate_chaotic_medium"), "Deepslate", "Deepslate Bricks");
        lang.addBlock(getVariant("deepslate_chaotic_small"), "Deepslate", "Deepslate Small Tiles");
        lang.addBlock(getVariant("deepslate_circular"), "Deepslate", "Circular");
        lang.addBlock(getVariant("deepslate_cracked"), "Deepslate", "Cracked");
        lang.addBlock(getVariant("deepslate_cracked_bricks"), "Deepslate", "Cracked Bricks");
        lang.addBlock(getVariant("deepslate_cuts"), "Deepslate", "Cuts");
        lang.addBlock(getVariant("deepslate_dent"), "Deepslate", "Dent");
        lang.addBlock(getVariant("deepslate_encased_bricks"), "Deepslate", "Encased Bricks");
        lang.addBlock(getVariant("deepslate_french_1"), "Deepslate", "French 1");
        lang.addBlock(getVariant("deepslate_french_2"), "Deepslate", "French 2");
        lang.addBlock(getVariant("deepslate_jellybean"), "Deepslate", "Jellybean");
        lang.addBlock(getVariant("deepslate_layers"), "Deepslate", "Layers");
        lang.addBlock(getVariant("deepslate_mosaic"), "Deepslate", "Mosaic");
        lang.addBlock(getVariant("deepslate_ornate"), "Deepslate", "Ornate Deepslate");
        lang.addBlock(getVariant("deepslate_panel"), "Deepslate", "Panel");
        lang.addBlock(getVariant("deepslate_pillar"), "Deepslate", "Pillar");
        lang.addBlock(getVariant("deepslate_prism"), "Deepslate", "Prismatic Deepslate");
        lang.addBlock(getVariant("deepslate_road"), "Deepslate", "Road");
        lang.addBlock(getVariant("deepslate_slanted"), "Deepslate", "Slanted");
        lang.addBlock(getVariant("deepslate_small_bricks"), "Deepslate", "Small Bricks");
        lang.addBlock(getVariant("deepslate_soft_bricks"), "Deepslate", "Soft Bricks");
        lang.addBlock(getVariant("deepslate_solid_bricks"), "Deepslate", "Solid Bricks");
        lang.addBlock(getVariant("deepslate_tiles_large"), "Deepslate", "Large Tiles");
        lang.addBlock(getVariant("deepslate_tiles_medium"), "Deepslate", "Medium Tiles");
        lang.addBlock(getVariant("deepslate_tiles_small"), "Deepslate", "Small Tiles");
        lang.addBlock(getVariant("deepslate_triple_bricks"), "Deepslate", "Triple Bricks");
        lang.addBlock(getVariant("deepslate_twisted"), "Deepslate", "Twisted");
        lang.addBlock(getVariant("deepslate_weaver"), "Deepslate", "Weaver");
        lang.addBlock(getVariant("deepslate_zag"), "Deepslate", "Zag");
    }
}
