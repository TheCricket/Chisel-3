package io.github.chiselteam.chisel.block.family;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class QuartzFamily extends ChiselFamily {
    public QuartzFamily(BlockBehaviour.Properties props) {
        family = builder("quartz")
                .addVariant(Blocks.QUARTZ_BLOCK)
                .addVariant("quartz_array", props, MULTIBLOCK_2X2)
                .addVariant("quartz_braid", props)
                .addVariant("quartz_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("quartz_chaotic_medium", props)
                .addVariant("quartz_chaotic_small", props)
                .addVariant("quartz_circular", props, CONNECTED)
                .addVariant("quartz_cracked", props)
                .addVariant("quartz_cracked_bricks", props)
                .addVariant("quartz_cuts", props, MULTIBLOCK_4X4)
                .addVariant("quartz_dent", props, CONNECTED)
                .addVariant("quartz_encased", props, CONNECTED)
                .addVariant("quartz_french", props)
                .addVariant("quartz_french_2", props)
                .addVariant("quartz_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("quartz_layers", props)
                .addVariant("quartz_mosaic", props, CONNECTED)
                .addVariant("quartz_ornate", props)
                .addVariant("quartz_panel", props)
                .addVariant("quartz_pillar", props, TBS)
                .addVariant("quartz_prism", props)
                .addVariant("quartz_raw", props)
                .addVariant("quartz_road", props)
                .addVariant("quartz_slanted", props, MULTIBLOCK_2X2)
                .addVariant("quartz_small", props)
                .addVariant("quartz_soft", props)
                .addVariant("quartz_solid", props)
                .addVariant("quartz_tiles_large", props, CONNECTED)
                .addVariant("quartz_tiles_medium", props)
                .addVariant("quartz_tiles_small", props)
                .addVariant("quartz_triple", props)
                .addVariant("quartz_twisted", props, TBS)
                .addVariant("quartz_weaver", props, CONNECTED)
                .addVariant("quartz_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("quartz_array"), "Quartz", "Quartz Pillar");
        lang.addBlock(getVariant("quartz_braid"), "Quartz", "Braid");
        lang.addBlock(getVariant("quartz_chaotic"), "Quartz", "Chaotic");
        lang.addBlock(getVariant("quartz_chaotic_medium"), "Quartz", "Quartz Bricks");
        lang.addBlock(getVariant("quartz_chaotic_small"), "Quartz", "Quartz Small Tiles");
        lang.addBlock(getVariant("quartz_circular"), "Quartz", "Circular");
        lang.addBlock(getVariant("quartz_cracked"), "Quartz", "Cracked");
        lang.addBlock(getVariant("quartz_cracked_bricks"), "Quartz", "Cracked Bricks");
        lang.addBlock(getVariant("quartz_cuts"), "Quartz", "Cuts");
        lang.addBlock(getVariant("quartz_dent"), "Quartz", "Dent");
        lang.addBlock(getVariant("quartz_encased"), "Quartz", "Encased");
        lang.addBlock(getVariant("quartz_french"), "Quartz", "French");
        lang.addBlock(getVariant("quartz_french_2"), "Quartz", "French 2");
        lang.addBlock(getVariant("quartz_jellybean"), "Quartz", "Jellybean");
        lang.addBlock(getVariant("quartz_layers"), "Quartz", "Layers");
        lang.addBlock(getVariant("quartz_mosaic"), "Quartz", "Mosaic");
        lang.addBlock(getVariant("quartz_ornate"), "Quartz", "Ornate Quartz");
        lang.addBlock(getVariant("quartz_panel"), "Quartz", "Panel");
        lang.addBlock(getVariant("quartz_pillar"), "Quartz", "Pillar");
        lang.addBlock(getVariant("quartz_prism"), "Quartz", "Prismatic Quartz");
        lang.addBlock(getVariant("quartz_raw"), "Quartz", "Raw");
        lang.addBlock(getVariant("quartz_road"), "Quartz", "Road");
        lang.addBlock(getVariant("quartz_slanted"), "Quartz", "Slanted");
        lang.addBlock(getVariant("quartz_small"), "Quartz", "Small");
        lang.addBlock(getVariant("quartz_soft"), "Quartz", "Soft");
        lang.addBlock(getVariant("quartz_solid"), "Quartz", "Solid");
        lang.addBlock(getVariant("quartz_tiles_large"), "Quartz", "Large Tiles");
        lang.addBlock(getVariant("quartz_tiles_medium"), "Quartz", "Medium Tiles");
        lang.addBlock(getVariant("quartz_tiles_small"), "Quartz", "Small Tiles");
        lang.addBlock(getVariant("quartz_triple"), "Quartz", "Triple");
        lang.addBlock(getVariant("quartz_twisted"), "Quartz", "Twisted");
        lang.addBlock(getVariant("quartz_weaver"), "Quartz", "Weaver");
        lang.addBlock(getVariant("quartz_zag"), "Quartz", "Zag");
    }
}

