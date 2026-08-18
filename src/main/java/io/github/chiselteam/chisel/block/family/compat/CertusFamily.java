package io.github.chiselteam.chisel.block.family.compat;

import io.github.chiselteam.chisel.block.util.ChiselFamily;
import io.github.chiselteam.chisel.util.LangHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.github.chiselteam.chisel.registry.ChiselModelHandlers.*;

public class CertusFamily extends ChiselFamily {
    public CertusFamily(BlockBehaviour.Properties props) {
        family = builder("certus")
                .addVariant("certus_array", props, MULTIBLOCK_2X2)
                .addVariant("certus_braid", props)
                .addVariant("certus_chaotic", props, MULTIBLOCK_3X3)
                .addVariant("certus_chaotic_medium", props)
                .addVariant("certus_chaotic_small", props)
                .addVariant("certus_circular", props, CONNECTED)
                .addVariant("certus_cracked", props)
                .addVariant("certus_cracked_bricks", props)
                .addVariant("certus_cuts", props, MULTIBLOCK_4X4)
                .addVariant("certus_dent", props, CONNECTED)
                .addVariant("certus_encased", props, CONNECTED)
                .addVariant("certus_french", props)
                .addVariant("certus_french_2", props)
                .addVariant("certus_jellybean", props, MULTIBLOCK_2X2)
                .addVariant("certus_layers", props)
                .addVariant("certus_mosaic", props, CONNECTED)
                .addVariant("certus_ornate", props)
                .addVariant("certus_panel", props)
                .addVariant("certus_pillar", props, TBS)
                .addVariant("certus_prism", props)
                .addVariant("certus_raw", props)
                .addVariant("certus_road", props)
                .addVariant("certus_slanted", props, MULTIBLOCK_2X2)
                .addVariant("certus_small", props)
                .addVariant("certus_soft", props)
                .addVariant("certus_solid", props)
                .addVariant("certus_tiles_large", props, CONNECTED)
                .addVariant("certus_tiles_medium", props)
                .addVariant("certus_tiles_small", props)
                .addVariant("certus_triple", props)
                .addVariant("certus_twisted", props, TBS)
                .addVariant("certus_weaver", props, CONNECTED)
                .addVariant("certus_zag", props, AR)
                .family();
    }

    @Override
    public void addTranslations(LangHelper lang) {
        lang.addBlock(getVariant("certus_array"), "Certus Quartz", "Large Bricks");
        lang.addBlock(getVariant("certus_braid"), "Certus Quartz", "Braid");
        lang.addBlock(getVariant("certus_chaotic"), "Certus Quartz", "Varied Bricks");
        lang.addBlock(getVariant("certus_chaotic_medium"), "Certus Quartz", "Detailed Bricks");
        lang.addBlock(getVariant("certus_chaotic_small"), "Certus Quartz", "Small Bricks");
        lang.addBlock(getVariant("certus_circular"), "Certus Quartz", "Circular");
        lang.addBlock(getVariant("certus_cracked"), "Certus Quartz", "Damaged Bricks");
        lang.addBlock(getVariant("certus_cracked_bricks"), "Certus Quartz", "Cracked Bricks");
        lang.addBlock(getVariant("certus_cuts"), "Certus Quartz", "Cuts");
        lang.addBlock(getVariant("certus_dent"), "Certus Quartz", "Bricks with Dent");
        lang.addBlock(getVariant("certus_encased"), "Certus Quartz", "Encased");
        lang.addBlock(getVariant("certus_french"), "Certus Quartz", "Mortarless Bricks");
        lang.addBlock(getVariant("certus_french_2"), "Certus Quartz", "Aged Bricks");
        lang.addBlock(getVariant("certus_jellybean"), "Certus Quartz", "Jellybean");
        lang.addBlock(getVariant("certus_layers"), "Certus Quartz", "Layers");
        lang.addBlock(getVariant("certus_mosaic"), "Certus Quartz", "Mosaic");
        lang.addBlock(getVariant("certus_ornate"), "Certus Quartz", "Ornate");
        lang.addBlock(getVariant("certus_panel"), "Certus Quartz", "Panel");
        lang.addBlock(getVariant("certus_pillar"), "Certus Quartz", "Pillar");
        lang.addBlock(getVariant("certus_prism"), "Certus Quartz", "Prism");
        lang.addBlock(getVariant("certus_raw"), "Certus Quartz", "Raw");
        lang.addBlock(getVariant("certus_road"), "Certus Quartz", "Road");
        lang.addBlock(getVariant("certus_slanted"), "Certus Quartz", "Slanted");
        lang.addBlock(getVariant("certus_small"), "Certus Quartz", "Small Bricks");
        lang.addBlock(getVariant("certus_soft"), "Certus Quartz", "Soft Bricks");
        lang.addBlock(getVariant("certus_solid"), "Certus Quartz", "Solid Bricks");
        lang.addBlock(getVariant("certus_tiles_large"), "Certus Quartz", "Large Tiles");
        lang.addBlock(getVariant("certus_tiles_medium"), "Certus Quartz", "Medium Tiles");
        lang.addBlock(getVariant("certus_tiles_small"), "Certus Quartz", "Small Tiles");
        lang.addBlock(getVariant("certus_triple"), "Certus Quartz", "Triple");
        lang.addBlock(getVariant("certus_twisted"), "Certus Quartz", "Twisted");
        lang.addBlock(getVariant("certus_weaver"), "Certus Quartz", "Weaver");
        lang.addBlock(getVariant("certus_zag"), "Certus Quartz", "Zag");
    }
}

