package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class AppliedEnergisticsFamilies {
    public static final ChiselFamily AE2_CERTUS;
    private static final List<ChiselFamily> FAMILIES;

    static {
        AE2_CERTUS = ChiselFamily.build("ae2_certus", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .addVariant("certus_array", ChiselModelHandlers.MULTIBLOCK_2X2).translation("certus_array", "Certus Quartz", "Array")
                .addVariant("certus_braid").translation("certus_braid", "Certus Quartz", "Braid")
                .addVariant("certus_chaotic", ChiselModelHandlers.MULTIBLOCK_3X3).translation("certus_chaotic", "Certus Quartz", "Varied Bricks")
                .addVariant("certus_chaotic_medium").translation("certus_chaotic_medium", "Certus Quartz", "Detailed Bricks")
                .addVariant("certus_chaotic_small").translation("certus_chaotic_small", "Certus Quartz", "Small Bricks")
                .addVariant("certus_circular", ChiselModelHandlers.CONNECTED).translation("certus_circular", "Certus Quartz", "Circular")
                .addVariant("certus_cracked").translation("certus_cracked", "Certus Quartz", "Damaged Bricks")
                .addVariant("certus_cracked_bricks").translation("certus_cracked_bricks", "Certus Quartz", "Cracked Bricks")
                .addVariant("certus_cuts", ChiselModelHandlers.MULTIBLOCK_4X4).translation("certus_cuts", "Certus Quartz", "Cuts")
                .addVariant("certus_dent", ChiselModelHandlers.CONNECTED).translation("certus_dent", "Certus Quartz", "Bricks with Dent")
                .addVariant("certus_encased", ChiselModelHandlers.CONNECTED).translation("certus_encased", "Certus Quartz", "Encased")
                .addVariant("certus_french").translation("certus_french", "Certus Quartz", "Mortarless Bricks")
                .addVariant("certus_french_2").translation("certus_french_2", "Certus Quartz", "Aged Bricks")
                .addVariant("certus_jellybean", ChiselModelHandlers.MULTIBLOCK_2X2).translation("certus_jellybean", "Certus Quartz", "Jellybean")
                .addVariant("certus_layers").translation("certus_layers", "Certus Quartz", "Layers")
                .addVariant("certus_mosaic", ChiselModelHandlers.CONNECTED).translation("certus_mosaic", "Certus Quartz", "Mosaic")
                .addVariant("certus_ornate").translation("certus_ornate", "Certus Quartz", "Ornate")
                .addVariant("certus_panel").translation("certus_panel", "Certus Quartz", "Panel")
                .addVariant("certus_pillar", ChiselModelHandlers.TBS).translation("certus_pillar", "Certus Quartz", "Pillar")
                .addVariant("certus_prism").translation("certus_prism", "Certus Quartz", "Prism")
                .addVariant("certus_raw").translation("certus_raw", "Certus Quartz", "Raw")
                .addVariant("certus_road").translation("certus_road", "Certus Quartz", "Road")
                .addVariant("certus_slanted", ChiselModelHandlers.MULTIBLOCK_2X2).translation("certus_slanted", "Certus Quartz", "Slanted")
                .addVariant("certus_small").translation("certus_small", "Certus Quartz", "Small Bricks")
                .addVariant("certus_soft").translation("certus_soft", "Certus Quartz", "Soft Bricks")
                .addVariant("certus_solid").translation("certus_solid", "Certus Quartz", "Solid Bricks")
                .addVariant("certus_tiles_large", ChiselModelHandlers.CONNECTED).translation("certus_tiles_large", "Certus Quartz", "Large Tiles")
                .addVariant("certus_tiles_medium").translation("certus_tiles_medium", "Certus Quartz", "Medium Tiles")
                .addVariant("certus_tiles_small").translation("certus_tiles_small", "Certus Quartz", "Small Tiles")
                .addVariant("certus_triple").translation("certus_triple", "Certus Quartz", "Triple")
                .addVariant("certus_twisted", ChiselModelHandlers.TBS).translation("certus_twisted", "Certus Quartz", "Twisted")
                .addVariant("certus_weaver", ChiselModelHandlers.CONNECTED).translation("certus_weaver", "Certus Quartz", "Weaver")
                .addVariant("certus_zag", ChiselModelHandlers.AR).translation("certus_zag", "Certus Quartz", "Zag")
                .build());

        FAMILIES = List.of(AE2_CERTUS);
    }

    private AppliedEnergisticsFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
