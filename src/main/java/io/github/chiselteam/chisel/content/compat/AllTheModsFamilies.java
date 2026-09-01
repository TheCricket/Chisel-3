package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.Internal
public class AllTheModsFamilies {
    public static final ChiselFamily ATM_ANCIENT_STONE = ChiselFamily.build("atm_ancient_stone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                /* .addVariant("ancient_stone_array", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_array", "Ancient Stone", "Array")
                .addVariant("ancient_stone_braid").translation("ancient_stone_braid", "Ancient Stone", "Braid")
                .addVariant("ancient_stone_chaotic", ChiselModelHandlers.MULTIBLOCK_3X3).translation("ancient_stone_chaotic", "Ancient Stone", "Varied Bricks")
                .addVariant("ancient_stone_chaotic_medium").translation("ancient_stone_chaotic_medium", "Ancient Stone", "Detailed Bricks")
                .addVariant("ancient_stone_chaotic_small").translation("ancient_stone_chaotic_small", "Ancient Stone", "Small Bricks")
                .addVariant("ancient_stone_circular", ChiselModelHandlers.CONNECTED).translation("ancient_stone_circular", "Ancient Stone", "Circular")
                .addVariant("ancient_stone_cracked").translation("ancient_stone_cracked", "Ancient Stone", "Damaged Bricks")
                .addVariant("ancient_stone_cracked_bricks").translation("ancient_stone_cracked_bricks", "Ancient Stone", "Cracked Bricks")
                .addVariant("ancient_stone_cuts", ChiselModelHandlers.MULTIBLOCK_4X4).translation("ancient_stone_cuts", "Ancient Stone", "Cuts")
                .addVariant("ancient_stone_dent", ChiselModelHandlers.CONNECTED).translation("ancient_stone_dent", "Ancient Stone", "Bricks with Dent")
                .addVariant("ancient_stone_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_encased", "Ancient Stone", "Encased")
                .addVariant("ancient_stone_french").translation("ancient_stone_french", "Ancient Stone", "Mortarless Bricks")
                .addVariant("ancient_stone_french_2").translation("ancient_stone_french_2", "Ancient Stone", "Aged Bricks")
                .addVariant("ancient_stone_jellybean", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_jellybean", "Ancient Stone", "Jellybean")
                .addVariant("ancient_stone_layers").translation("ancient_stone_layers", "Ancient Stone", "Layers")
                .addVariant("ancient_stone_mosaic", ChiselModelHandlers.CONNECTED).translation("ancient_stone_mosaic", "Ancient Stone", "Mosaic")
                .addVariant("ancient_stone_ornate").translation("ancient_stone_ornate", "Ancient Stone", "Ornate")
                .addVariant("ancient_stone_panel").translation("ancient_stone_panel", "Ancient Stone", "Panel")
                .addVariant("ancient_stone_pillar", ChiselModelHandlers.TBS).translation("ancient_stone_pillar", "Ancient Stone", "Pillar")
                .addVariant("ancient_stone_prism").translation("ancient_stone_prism", "Ancient Stone", "Prism")
                .addVariant("ancient_stone_raw").translation("ancient_stone_raw", "Ancient Stone", "Raw")
                .addVariant("ancient_stone_road").translation("ancient_stone_road", "Ancient Stone", "Road")
                .addVariant("ancient_stone_slanted", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_slanted", "Ancient Stone", "Slanted")
                .addVariant("ancient_stone_small").translation("ancient_stone_small", "Ancient Stone", "Small Tiles")
                .addVariant("ancient_stone_soft").translation("ancient_stone_soft", "Ancient Stone", "Yellow Bricks")
                .addVariant("ancient_stone_solid").translation("ancient_stone_solid", "Ancient Stone", "Solid")
                .addVariant("ancient_stone_tiles_large", ChiselModelHandlers.CONNECTED).translation("ancient_stone_tiles_large", "Ancient Stone", "Large Tiles")
                .addVariant("ancient_stone_tiles_medium").translation("ancient_stone_tiles_medium", "Ancient Stone", "Medium Tiles")
                .addVariant("ancient_stone_tiles_small").translation("ancient_stone_tiles_small", "Ancient Stone", "Small Tiles")
                .addVariant("ancient_stone_triple").translation("ancient_stone_triple", "Ancient Stone", "Triple")
                .addVariant("ancient_stone_twisted", ChiselModelHandlers.TBS).translation("ancient_stone_twisted", "Ancient Stone", "Twisted")
                .addVariant("ancient_stone_weaver", ChiselModelHandlers.CONNECTED).translation("ancient_stone_weaver", "Ancient Stone", "Weaver")
                .addVariant("ancient_stone_zag", ChiselModelHandlers.AR).translation("ancient_stone_zag", "Ancient Stone", "Zag") */
                .addVariant("ancient_stone_array", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_array", "Ancient Stone", "Array")
                .addVariant("ancient_stone_border_square", ChiselModelHandlers.CONNECTED).translation("ancient_stone_border_square", "Ancient Stone", "Square Border")
                .addVariant("ancient_stone_braid").translation("ancient_stone_braid", "Ancient Stone", "Braid")
                .addVariant("ancient_stone_braid_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_braid_encased", "Ancient Stone", "Encased Braid")
                .addVariant("ancient_stone_bricks_cracked").translation("ancient_stone_bricks_cracked", "Ancient Stone", "Cracked Bricks")
                .addVariant("ancient_stone_bricks_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_bricks_encased", "Ancient Stone", "Encased Bricks")
                .addVariant("ancient_stone_bricks_indent").translation("ancient_stone_bricks_indent", "Ancient Stone", "Indent Bricks")
                .addVariant("ancient_stone_bricks_inlayed").translation("ancient_stone_bricks_inlayed", "Ancient Stone", "Inlayed Bricks")
                .addVariant("ancient_stone_bricks_large", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_bricks_large", "Ancient Stone", "Large Bricks")
                .addVariant("ancient_stone_bricks_small").translation("ancient_stone_bricks_small", "Ancient Stone", "Small Bricks")
                .addVariant("ancient_stone_bricks_soft").translation("ancient_stone_bricks_soft", "Ancient Stone", "Soft Bricks")
                .addVariant("ancient_stone_bricks_solid").translation("ancient_stone_bricks_solid", "Ancient Stone", "Solid Bricks")
                .addVariant("ancient_stone_bricks_triple").translation("ancient_stone_bricks_triple", "Ancient Stone", "Triple Bricks")
                .addVariant("ancient_stone_bricks_vertical").translation("ancient_stone_bricks_vertical", "Ancient Stone", "Vertical Bricks")
                .addVariant("ancient_stone_chaotic", ChiselModelHandlers.MULTIBLOCK_3X3).translation("ancient_stone_chaotic", "Ancient Stone", "Chaotic")
                .addVariant("ancient_stone_chaotic_medium").translation("ancient_stone_chaotic_medium", "Ancient Stone", "Chaotic Medium")
                .addVariant("ancient_stone_chaotic_small").translation("ancient_stone_chaotic_small", "Ancient Stone", "Chaotic Small")
                .addVariant("ancient_stone_checker").translation("ancient_stone_checker", "Ancient Stone", "Checker")
                .addVariant("ancient_stone_checker_small").translation("ancient_stone_checker_small", "Ancient Stone", "Small Checker")
                .addVariant("ancient_stone_circular", ChiselModelHandlers.CONNECTED).translation("ancient_stone_circular", "Ancient Stone", "Circular")
                .addVariant("ancient_stone_cobble").translation("ancient_stone_cobble", "Ancient Stone", "Cobble")
                .addVariant("ancient_stone_cuts", ChiselModelHandlers.MULTIBLOCK_4X4).translation("ancient_stone_cuts", "Ancient Stone", "Cuts")
                .addVariant("ancient_stone_dent", ChiselModelHandlers.CONNECTED).translation("ancient_stone_dent", "Ancient Stone", "Dent")
                .addVariant("ancient_stone_french_1").translation("ancient_stone_french_1", "Ancient Stone", "French 1")
                .addVariant("ancient_stone_french_2").translation("ancient_stone_french_2", "Ancient Stone", "French 2")
                .addVariant("ancient_stone_indent", ChiselModelHandlers.CONNECTED).translation("ancient_stone_indent", "Ancient Stone", "Indent")
                .addVariant("ancient_stone_jellybean", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_jellybean", "Ancient Stone", "Jellybean")
                .addVariant("ancient_stone_layers").translation("ancient_stone_layers", "Ancient Stone", "Layers")
                .addVariant("ancient_stone_layers_connected", ChiselModelHandlers.CONNECTED).translation("ancient_stone_layers_connected", "Ancient Stone", "Layers Connected")
                .addVariant("ancient_stone_line_horizontal").translation("ancient_stone_line_horizontal", "Ancient Stone", "Horizontal Line")
                .addVariant("ancient_stone_line_vertical").translation("ancient_stone_line_vertical", "Ancient Stone", "Vertical Line")
                .addVariant("ancient_stone_meander_horizontal", ChiselModelHandlers.CTMH).translation("ancient_stone_meander_horizontal", "Ancient Stone", "Horizontal Meander")
                .addVariant("ancient_stone_meander_vertical", ChiselModelHandlers.CTMV).translation("ancient_stone_meander_vertical", "Ancient Stone", "Vertical Meander")
                .addVariant("ancient_stone_mosaic", ChiselModelHandlers.CONNECTED).translation("ancient_stone_mosaic", "Ancient Stone", "Mosaic")
                .addVariant("ancient_stone_ornate_small").translation("ancient_stone_ornate_small", "Ancient Stone", "Small Ornate")
                .addVariant("ancient_stone_panel").translation("ancient_stone_panel", "Ancient Stone", "Panel")
                .addVariant("ancient_stone_pillar", ChiselModelHandlers.TBS).translation("ancient_stone_pillar", "Ancient Stone", "Pillar")
                .addVariant("ancient_stone_pillar_basic", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_basic", "Ancient Stone", "Basic Pillar")
                .addVariant("ancient_stone_pillar_basic_dent", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_basic_dent", "Ancient Stone", "Basic Dent Pillar")
                .addVariant("ancient_stone_pillar_basic_plain", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_basic_plain", "Ancient Stone", "Basic Plain Pillar")
                .addVariant("ancient_stone_pillar_basic_round", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_basic_round", "Ancient Stone", "Basic Round Pillar")
                .addVariant("ancient_stone_pillar_basic_spiral", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_basic_spiral", "Ancient Stone", "Basic Spiral Pillar")
                .addVariant("ancient_stone_pillar_classic", ChiselModelHandlers.TBS).translation("ancient_stone_pillar_classic", "Ancient Stone", "Classic Pillar")
                .addVariant("ancient_stone_pillar_classic_large", ChiselModelHandlers.TBS).translation("ancient_stone_pillar_classic_large", "Ancient Stone", "Large Classic Pillar")
                .addVariant("ancient_stone_pillar_ionic", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_ionic", "Ancient Stone", "Ionic Pillar")
                .addVariant("ancient_stone_pillar_ionic_dent", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_ionic_dent", "Ancient Stone", "Ionic Dent Pillar")
                .addVariant("ancient_stone_pillar_ionic_plain", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_ionic_plain", "Ancient Stone", "Ionic Plain Pillar")
                .addVariant("ancient_stone_pillar_ionic_round", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_ionic_round", "Ancient Stone", "Ionic Round Pillar")
                .addVariant("ancient_stone_pillar_ionic_spiral", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_ionic_spiral", "Ancient Stone", "Ionic Spiral Pillar")
                .addVariant("ancient_stone_pillar_large_basic_triple", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_large_basic_triple", "Ancient Stone", "Large Basic Triple Pillar")
                .addVariant("ancient_stone_pillar_large_ionic_triple", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_large_ionic_triple", "Ancient Stone", "Large Ionic Triple Pillar")
                .addVariant("ancient_stone_pillar_meander", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_meander", "Ancient Stone", "Meander Pillar")
                .addVariant("ancient_stone_pillar_meander_dent", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_meander_dent", "Ancient Stone", "Meander Dent Pillar")
                .addVariant("ancient_stone_pillar_meander_plain", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_meander_plain", "Ancient Stone", "Meander Plain Pillar")
                .addVariant("ancient_stone_pillar_meander_round", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_meander_round", "Ancient Stone", "Meander Round Pillar")
                .addVariant("ancient_stone_pillar_meander_spiral", ChiselModelHandlers.CTMV).translation("ancient_stone_pillar_meander_spiral", "Ancient Stone", "Meander Spiral Pillar")
                .addVariant("ancient_stone_plate").translation("ancient_stone_plate", "Ancient Stone", "Plate")
                .addVariant("ancient_stone_plate_connected", ChiselModelHandlers.CONNECTED).translation("ancient_stone_plate_connected", "Ancient Stone", "Plate Connected")
                .addVariant("ancient_stone_polished").translation("ancient_stone_polished", "Ancient Stone", "Polished")
                .addVariant("ancient_stone_polished_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_polished_encased", "Ancient Stone", "Polished Encased")
                .addVariant("ancient_stone_prism").translation("ancient_stone_prism", "Ancient Stone", "Prismatic")
                .addVariant("ancient_stone_raw").translation("ancient_stone_raw", "Ancient Stone", "Raw")
                .addVariant("ancient_stone_road").translation("ancient_stone_road", "Ancient Stone", "Road")
                .addVariant("ancient_stone_slanted", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_slanted", "Ancient Stone", "Slanted")
                .addVariant("ancient_stone_tiles").translation("ancient_stone_tiles", "Ancient Stone", "Tiles")
                .addVariant("ancient_stone_tiles_large", ChiselModelHandlers.CONNECTED).translation("ancient_stone_tiles_large", "Ancient Stone", "Large Tiles")
                .addVariant("ancient_stone_tiles_small").translation("ancient_stone_tiles_small", "Ancient Stone", "Small Tiles")
                .addVariant("ancient_stone_twisted", ChiselModelHandlers.TBS).translation("ancient_stone_twisted", "Ancient Stone", "Twisted")
                .addVariant("ancient_stone_weaver", ChiselModelHandlers.CONNECTED).translation("ancient_stone_weaver", "Ancient Stone", "Weaver")
                .addVariant("ancient_stone_zag", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_zag", "Ancient Stone", "Zag")
                .addVariant("ancient_stone_crate", ChiselModelHandlers.CONNECTED).translation("ancient_stone_crate", "Ancient Stone", "Crate")
                .addVariant("ancient_stone_herringbone").translation("ancient_stone_herringbone", "Ancient Stone", "Herringbone")
                .addVariant("ancient_stone_herringbone_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_herringbone_encased", "Ancient Stone", "Encased Herringbone")
                .addVariant("ancient_stone_medallion").translation("ancient_stone_medallion", "Ancient Stone", "Medallion")
                .addVariant("ancient_stone_medallion_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_medallion_encased", "Ancient Stone", "Encased Medallion")
                .addVariant("ancient_stone_dots").translation("ancient_stone_dots", "Ancient Stone", "Dots")
                .addVariant("ancient_stone_dots_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_dots_encased", "Ancient Stone", "Encased Dots")
                .addVariant("ancient_stone_heart").translation("ancient_stone_heart", "Ancient Stone", "Heart")
                .addVariant("ancient_stone_star").translation("ancient_stone_star", "Ancient Stone", "Star")
                .addVariant("ancient_stone_plating").translation("ancient_stone_plating", "Ancient Stone", "Plating")
                .addVariant("ancient_stone_lodestone").translation("ancient_stone_lodestone", "Ancient Stone", "Lodestone")
                .addVariant("ancient_stone_lodestone_connected", ChiselModelHandlers.CONNECTED).translation("ancient_stone_lodestone_connected", "Ancient Stone", "Lodestone Connected")
                .addVariant("ancient_stone_plank").translation("ancient_stone_plank", "Ancient Stone", "Plank")
                .addVariant("ancient_stone_plank_connected", ChiselModelHandlers.CONNECTED).translation("ancient_stone_plank_connected", "Ancient Stone", "Plank Connected")
                .addVariant("ancient_stone_frame").translation("ancient_stone_frame", "Ancient Stone", "Frame")
                .addVariant("ancient_stone_panel_1").translation("ancient_stone_panel_1", "Ancient Stone", "Panel 1")
                .addVariant("ancient_stone_panel_2").translation("ancient_stone_panel_2", "Ancient Stone", "Panel 2")
                .addVariant("ancient_stone_panel_3").translation("ancient_stone_panel_3", "Ancient Stone", "Panel 3")
                .addVariant("ancient_stone_skull_creeper").translation("ancient_stone_skull_creeper", "Ancient Stone", "Creeper Skull")
                .addVariant("ancient_stone_skull_skeleton").translation("ancient_stone_skull_skeleton", "Ancient Stone", "Skeleton Skull")
                .addVariant("ancient_stone_stripes").translation("ancient_stone_stripes", "Ancient Stone", "Stripes")
                .addVariant("ancient_stone_stripes_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_stripes_encased", "Ancient Stone", "Encased Stripes")
                .addVariant("ancient_stone_chisel_1").translation("ancient_stone_chisel_1", "Ancient Stone", "Chisel 1")
                .addVariant("ancient_stone_chisel_2").translation("ancient_stone_chisel_2", "Ancient Stone", "Chisel 2")
                .addVariant("ancient_stone_chisel_3").translation("ancient_stone_chisel_3", "Ancient Stone", "Chisel 3")
                .addVariant("ancient_stone_chisel_4").translation("ancient_stone_chisel_4", "Ancient Stone", "Chisel 4")
                .addVariant("ancient_stone_chisel_5").translation("ancient_stone_chisel_5", "Ancient Stone", "Chisel 5")
                .addVariant("ancient_stone_chisel_6").translation("ancient_stone_chisel_6", "Ancient Stone", "Chisel 6")
                .addVariant("ancient_stone_facet").translation("ancient_stone_facet", "Ancient Stone", "Facet")
                .addVariant("ancient_stone_facet_small").translation("ancient_stone_facet_small", "Ancient Stone", "Small Facet")
                .addVariant("ancient_stone_facet_small_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_facet_small_encased", "Ancient Stone", "Encased Small Facet")
                .addVariant("ancient_stone_shiny").translation("ancient_stone_shiny", "Ancient Stone", "Shiny")
                .addVariant("ancient_stone_shiny_connected", ChiselModelHandlers.CONNECTED).translation("ancient_stone_shiny_connected", "Ancient Stone", "Shiny Connected")
                .addVariant("ancient_stone_gem").translation("ancient_stone_gem", "Ancient Stone", "Gem")
                .addVariant("ancient_stone_gem_1").translation("ancient_stone_gem_1", "Ancient Stone", "Gem 1")
                .addVariant("ancient_stone_gem_1_connected", ChiselModelHandlers.CONNECTED).translation("ancient_stone_gem_1_connected", "Ancient Stone", "Gem 1 Connected")
                .addVariant("ancient_stone_gem_2").translation("ancient_stone_gem_2", "Ancient Stone", "Gem 2")
                .addVariant("ancient_stone_gem_2_connected", ChiselModelHandlers.CONNECTED).translation("ancient_stone_gem_2_connected", "Ancient Stone", "Gem 2 Connected")
                .addVariant("ancient_stone_gem_3").translation("ancient_stone_gem_3", "Ancient Stone", "Gem 3")
                .addVariant("ancient_stone_gem_3_connected", ChiselModelHandlers.CONNECTED).translation("ancient_stone_gem_3_connected", "Ancient Stone", "Gem 3 Connected")
                .addVariant("ancient_stone_bricks_square").translation("ancient_stone_bricks_square", "Ancient Stone", "Square Bricks")
                .addVariant("ancient_stone_slab").translation("ancient_stone_slab", "Ancient Stone", "Slab")
                .addVariant("ancient_stone_scaffold").translation("ancient_stone_scaffold", "Ancient Stone", "Scaffold")
                .addVariant("ancient_stone_scaffold_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_scaffold_encased", "Ancient Stone", "Encased Scaffold")
                .addVariant("ancient_stone_tiles_inlayed").translation("ancient_stone_tiles_inlayed", "Ancient Stone", "Inlayed Tiles")
                .addVariant("ancient_stone_waves", ChiselModelHandlers.MULTIBLOCK_2X2).translation("ancient_stone_waves", "Ancient Stone", "Waves")
                .addVariant("ancient_stone_parquet").translation("ancient_stone_parquet", "Ancient Stone", "Parquet")
                .addVariant("ancient_stone_parquet_encased", ChiselModelHandlers.CONNECTED).translation("ancient_stone_parquet_encased", "Ancient Stone", "Encased Parquet")
                .build());
        
        /* public static final ChiselFamily ATM_ALLTHEMODIUM = ChiselFamily.build("atm_allthemodium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        public static final ChiselFamily ATM_UNOBTAINIUM_ALLTHEMODIUM = ChiselFamily.build("atm_unobtainium_allthemodium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        public static final ChiselFamily ATM_UNOBTAINIUM = ChiselFamily.build("atm_unobtainium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        public static final ChiselFamily ATM_UNOBTAINIUM_VIBRANIUM = ChiselFamily.build("atm_unobtainium_vibranium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        public static final ChiselFamily ATM_VIBRANIUM_ALLTHEMODIUM = ChiselFamily.build("atm_vibranium_allthemodium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        public static final ChiselFamily ATM_VIBRANIUM = ChiselFamily.build("atm_vibranium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        */
  private static final List<ChiselFamily> FAMILIES = List.of(ATM_ANCIENT_STONE);

    private AllTheModsFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
