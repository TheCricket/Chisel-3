package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class OccultismFamilies {
    public static final ChiselFamily OC_TALLOW;
    private static final List<ChiselFamily> FAMILIES;

    static {
        OC_TALLOW = ChiselFamily.build("oc_tallow", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL))
                .addVariant("tallow_block", ChiselModelHandlers.TBS).translation("tallow_block", "Tallow", "Block")
                .addVariant("tallow_faces").translation("tallow_faces", "Tallow", "Pareidolia")
                .addVariant("tallow_smooth").translation("tallow_smooth", "Tallow", "Smooth")
                .build());

        /* OC_OTHERROCK = ChiselFamily.build("oc_otherrock", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                // .addVariant("blackstone_array", ChiselModelHandlers.MULTIBLOCK_2X2)
                // .addVariant("blackstone_braid")
                // .addVariant("blackstone_bricks_indent")
                // .addVariant("blackstone_bricks_inlayed")
                // .addVariant("blackstone_bricks_large", ChiselModelHandlers.MULTIBLOCK_2X2)
                // .addVariant("blackstone_bricks_vertical")
                // .addVariant("blackstone_chaotic", ChiselModelHandlers.MULTIBLOCK_3X3)
                // .addVariant("blackstone_chaotic_medium")
                // .addVariant("blackstone_chaotic_small")
                // .addVariant("blackstone_checker")
                // .addVariant("blackstone_checker_small")
                // .addVariant("blackstone_circular", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_cobble")
                // .addVariant("blackstone_bricks_cracked")
                // .addVariant("blackstone_cuts", ChiselModelHandlers.MULTIBLOCK_4X4)
                // .addVariant("blackstone_dent", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_bricks_encased", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_french_1")
                // .addVariant("blackstone_french_2")
                // .addVariant("blackstone_indent", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_jellybean", ChiselModelHandlers.MULTIBLOCK_2X2)
                // .addVariant("blackstone_layers")
                // .addVariant("blackstone_line_horizontal")
                // .addVariant("blackstone_line_vertical")
                // .addVariant("blackstone_meander_horizontal", ChiselModelHandlers.CTMH)
                // .addVariant("blackstone_meander_vertical", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_mosaic", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_ornate_small")
                // .addVariant("blackstone_panel")
                // .addVariant("blackstone_pillar", ChiselModelHandlers.TBS)
                // .addVariant("blackstone_pillar_basic", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_basic_dent", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_basic_plain", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_basic_round", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_basic_spiral", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_classic", ChiselModelHandlers.TBS)
                // .addVariant("blackstone_pillar_classic_large", ChiselModelHandlers.TBS)
                // .addVariant("blackstone_pillar_ionic", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_ionic_dent", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_ionic_plain", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_ionic_round", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_ionic_spiral", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_large_basic_triple", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_large_ionic_triple", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander_dent", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander_plain", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander_round", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander_spiral", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_plate", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_polished")
                // .addVariant("blackstone_prism")
                // .addVariant("blackstone_raw")
                // .addVariant("blackstone_road")
                // .addVariant("blackstone_slanted", ChiselModelHandlers.MULTIBLOCK_2X2)
                // .addVariant("blackstone_bricks_small")
                // .addVariant("blackstone_bricks_soft")
                // .addVariant("blackstone_bricks_solid")
                // .addVariant("blackstone_border_square", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_tiles_large", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_tiles")
                // .addVariant("blackstone_tiles_small")
                // .addVariant("blackstone_bricks_triple")
                // .addVariant("blackstone_twisted", ChiselModelHandlers.TBS)
                // .addVariant("blackstone_weaver", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_zag", ChiselModelHandlers.MULTIBLOCK_2X2)
                .build());

        OC_OTHERSTONE = ChiselFamily.build("oc_otherstone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                // .addVariant("blackstone_array", ChiselModelHandlers.MULTIBLOCK_2X2)
                // .addVariant("blackstone_braid")
                // .addVariant("blackstone_bricks_indent")
                // .addVariant("blackstone_bricks_inlayed")
                // .addVariant("blackstone_bricks_large", ChiselModelHandlers.MULTIBLOCK_2X2)
                // .addVariant("blackstone_bricks_vertical")
                // .addVariant("blackstone_chaotic", ChiselModelHandlers.MULTIBLOCK_3X3)
                // .addVariant("blackstone_chaotic_medium")
                // .addVariant("blackstone_chaotic_small")
                // .addVariant("blackstone_checker")
                // .addVariant("blackstone_checker_small")
                // .addVariant("blackstone_circular", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_cobble")
                // .addVariant("blackstone_bricks_cracked")
                // .addVariant("blackstone_cuts", ChiselModelHandlers.MULTIBLOCK_4X4)
                // .addVariant("blackstone_dent", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_bricks_encased", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_french_1")
                // .addVariant("blackstone_french_2")
                // .addVariant("blackstone_indent", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_jellybean", ChiselModelHandlers.MULTIBLOCK_2X2)
                // .addVariant("blackstone_layers")
                // .addVariant("blackstone_line_horizontal")
                // .addVariant("blackstone_line_vertical")
                // .addVariant("blackstone_meander_horizontal", ChiselModelHandlers.CTMH)
                // .addVariant("blackstone_meander_vertical", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_mosaic", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_ornate_small")
                // .addVariant("blackstone_panel")
                // .addVariant("blackstone_pillar", ChiselModelHandlers.TBS)
                // .addVariant("blackstone_pillar_basic", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_basic_dent", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_basic_plain", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_basic_round", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_basic_spiral", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_classic", ChiselModelHandlers.TBS)
                // .addVariant("blackstone_pillar_classic_large", ChiselModelHandlers.TBS)
                // .addVariant("blackstone_pillar_ionic", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_ionic_dent", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_ionic_plain", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_ionic_round", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_ionic_spiral", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_large_basic_triple", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_large_ionic_triple", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander_dent", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander_plain", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander_round", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_pillar_meander_spiral", ChiselModelHandlers.CTMV)
                // .addVariant("blackstone_plate", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_polished")
                // .addVariant("blackstone_prism")
                // .addVariant("blackstone_raw")
                // .addVariant("blackstone_road")
                // .addVariant("blackstone_slanted", ChiselModelHandlers.MULTIBLOCK_2X2)
                // .addVariant("blackstone_bricks_small")
                // .addVariant("blackstone_bricks_soft")
                // .addVariant("blackstone_bricks_solid")
                // .addVariant("blackstone_border_square", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_tiles_large", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_tiles")
                // .addVariant("blackstone_tiles_small")
                // .addVariant("blackstone_bricks_triple")
                // .addVariant("blackstone_twisted", ChiselModelHandlers.TBS)
                // .addVariant("blackstone_weaver", ChiselModelHandlers.CONNECTED)
                // .addVariant("blackstone_zag", ChiselModelHandlers.MULTIBLOCK_2X2)
                .build());

        */

        FAMILIES = List.of(OC_TALLOW);
    }

    private OccultismFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
