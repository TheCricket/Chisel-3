package io.github.chiselteam.chisel.content.family;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class WoodFamilies {
    public static final ChiselFamily ACACIA, BAMBOO, BIRCH, CHERRY, CRIMSON, DARK_OAK, JUNGLE, MANGROVE, OAK, PALE_OAK, SPRUCE, WARPED;
    private static final List<ChiselFamily> FAMILIES;

    static {
        ACACIA = ChiselFamily.build("acacia_planks", builder -> builder
                .addVariant(Blocks.ACACIA_PLANKS)
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS))
                .addVariant("acacia_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("acacia_planks_braced", "Acacia Planks", "Acacia Wood Panel")
                .addVariant("acacia_planks_braid", ChiselModelHandlers.CONNECTED).translation("acacia_planks_braid", "Acacia Planks", "Acacia Wood Braid")
                .addVariant("acacia_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("acacia_planks_crude_horizontal", "Acacia Planks", "Vertical Acacia Wood Planks in Disarray")
                .addVariant("acacia_planks_crude_paneling").translation("acacia_planks_crude_paneling", "Acacia Planks", "Acacia Wood Planks in Disarray")
                .addVariant("acacia_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("acacia_planks_crude_vertical", "Acacia Planks", "Vertical Acacia Wood Planks in Disarray")
                .addVariant("acacia_planks_encased", ChiselModelHandlers.CONNECTED).translation("acacia_planks_encased", "Acacia Planks", "Encased Acacia Wood Panel")
                .addVariant("acacia_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("acacia_planks_encased_large", "Acacia Planks", "Large Long Acacia Wood Planks")
                .addVariant("acacia_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("acacia_planks_encased_smooth", "Acacia Planks", "Smooth Acacia Wood Planks")
                .addVariant("acacia_planks_large").translation("acacia_planks_large", "Acacia Planks", "Large Long Acacia Wood Planks")
                .addVariant("acacia_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("acacia_planks_log_bordered", "Acacia Planks", "Log Bordered Acacia Wood Panel")
                .addVariant("acacia_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("acacia_planks_log_cabin_ns", "Acacia Planks", "Acacia Wood Log Cabin (North-South)")
                .addVariant("acacia_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("acacia_planks_log_cabin_ew", "Acacia Planks", "Acacia Wood Log Cabin (East-West)")
                .addVariant("acacia_planks_paneling", ChiselModelHandlers.CONNECTED).translation("acacia_planks_paneling", "Acacia Planks", "Acacia Wood Panel")
                .addVariant("acacia_planks_shipping", ChiselModelHandlers.CONNECTED).translation("acacia_planks_shipping", "Acacia Planks", "Acacia Wood Crate")
                .addVariant("acacia_planks_smooth", ChiselModelHandlers.CONNECTED).translation("acacia_planks_smooth", "Acacia Planks", "Smooth Acacia Wood Planks")
                .addVariant("acacia_planks_stacked").translation("acacia_planks_stacked", "Acacia Planks", "Stacked Acacia Wood Tiles")
                .addVariant("acacia_planks_vertical").translation("acacia_planks_vertical", "Acacia Planks", "Vertical Acacia Wood Planks")
                .build());
        BAMBOO = ChiselFamily.build("bamboo_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS))
                .addVariant(Blocks.BAMBOO_PLANKS)
                .addVariant("bamboo_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("bamboo_planks_braced", "Bamboo Planks", "Bamboo Panel")
                .addVariant("bamboo_planks_braid", ChiselModelHandlers.CONNECTED).translation("bamboo_planks_braid", "Bamboo Planks", "Bamboo Braid")
                //.addVariant("bamboo_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3)
                //.addVariant("bamboo_planks_crude_paneling")
                //.addVariant("bamboo_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3)
                .addVariant("bamboo_planks_encased", ChiselModelHandlers.CONNECTED).translation("bamboo_planks_encased", "Bamboo Planks", "Encased Bamboo Panel")
                .addVariant("bamboo_planks_encased_2", ChiselModelHandlers.CONNECTED).translation("bamboo_planks_encased_2", "Bamboo Planks", "Encased Bamboo Panel")
                .addVariant("bamboo_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("bamboo_planks_encased_large", "Bamboo Planks", "Large Long Bamboo Planks")
                .addVariant("bamboo_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("bamboo_planks_encased_smooth", "Bamboo Planks", "Smooth Bamboo Planks")
                .addVariant("bamboo_planks_large").translation("bamboo_planks_large", "Bamboo Planks", "Large Long Bamboo Planks")
                .addVariant("bamboo_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("bamboo_planks_log_bordered", "Bamboo Planks", "Log Bordered Bamboo Panel")
                //.addVariant("bamboo_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED)
                //.addVariant("bamboo_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED)
                //.addVariant("bamboo_planks_paneling", ChiselModelHandlers.CONNECTED)
                .addVariant("bamboo_planks_shipping", ChiselModelHandlers.CONNECTED).translation("bamboo_planks_shipping", "Bamboo Planks", "Bamboo Crate")
                .addVariant("bamboo_planks_smooth", ChiselModelHandlers.CONNECTED).translation("bamboo_planks_smooth", "Bamboo Planks", "Smooth Bamboo Planks")
                //.addVariant("bamboo_planks_stacked")
                .addVariant("bamboo_planks_vertical").translation("bamboo_planks_vertical", "Bamboo Planks", "Vertical Bamboo Planks")
                .build());

        BIRCH = ChiselFamily.build("birch_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS))
                .addVariant(Blocks.BIRCH_PLANKS)
                .addVariant("birch_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("birch_planks_braced", "Birch Planks", "Birch Wood Panel")
                .addVariant("birch_planks_braid", ChiselModelHandlers.CONNECTED).translation("birch_planks_braid", "Birch Planks", "Birch Wood Braid")
                .addVariant("birch_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("birch_planks_crude_horizontal", "Birch Planks", "Vertical Birch Wood Planks in Disarray")
                .addVariant("birch_planks_crude_paneling").translation("birch_planks_crude_paneling", "Birch Planks", "Birch Wood Planks in Disarray")
                .addVariant("birch_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("birch_planks_crude_vertical", "Birch Planks", "Vertical Birch Wood Planks in Disarray")
                .addVariant("birch_planks_encased", ChiselModelHandlers.CONNECTED).translation("birch_planks_encased", "Birch Planks", "Encased Birch Wood Panel")
                .addVariant("birch_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("birch_planks_encased_large", "Birch Planks", "Large Long Birch Wood Planks")
                .addVariant("birch_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("birch_planks_encased_smooth", "Birch Planks", "Smooth Birch Wood Planks")
                .addVariant("birch_planks_large").translation("birch_planks_large", "Birch Planks", "Large Long Birch Wood Planks")
                .addVariant("birch_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("birch_planks_log_bordered", "Birch Planks", "Log Bordered Birch Wood Panel")
                .addVariant("birch_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("birch_planks_log_cabin_ew", "Birch Planks", "Birch Wood Log Cabin (East-West)")
                .addVariant("birch_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("birch_planks_log_cabin_ns", "Birch Planks", "Birch Wood Log Cabin (North-South)")
                .addVariant("birch_planks_paneling", ChiselModelHandlers.CONNECTED).translation("birch_planks_paneling", "Birch Planks", "Birch Wood Panel")
                .addVariant("birch_planks_shipping", ChiselModelHandlers.CONNECTED).translation("birch_planks_shipping", "Birch Planks", "Birch Wood Crate")
                .addVariant("birch_planks_smooth", ChiselModelHandlers.CONNECTED).translation("birch_planks_smooth", "Birch Planks", "Smooth Birch Wood Planks")
                .addVariant("birch_planks_stacked").translation("birch_planks_stacked", "Birch Planks", "Stacked Birch Wood Tiles")
                .addVariant("birch_planks_vertical").translation("birch_planks_vertical", "Birch Planks", "Vertical Birch Wood Planks")
                .build());

        CRIMSON = ChiselFamily.build("crimson_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS))
                .addVariant(Blocks.CRIMSON_PLANKS)
                .addVariant("crimson_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("crimson_planks_braced", "Crimson Planks", "Crimson Wood Panel")
                .addVariant("crimson_planks_braid", ChiselModelHandlers.CONNECTED).translation("crimson_planks_braid", "Crimson Planks", "Crimson Wood Braid")
                .addVariant("crimson_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("crimson_planks_crude_horizontal", "Crimson Planks", "Vertical Crimson Wood Planks in Disarray")
                .addVariant("crimson_planks_crude_paneling").translation("crimson_planks_crude_paneling", "Crimson Planks", "Crimson Wood Planks in Disarray")
                .addVariant("crimson_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("crimson_planks_crude_vertical", "Crimson Planks", "Vertical Crimson Wood Planks in Disarray")
                .addVariant("crimson_planks_encased", ChiselModelHandlers.CONNECTED).translation("crimson_planks_encased", "Crimson Planks", "Encased Crimson Wood Panel")
                .addVariant("crimson_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("crimson_planks_encased_large", "Crimson Planks", "Large Long Crimson Wood Planks")
                .addVariant("crimson_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("crimson_planks_encased_smooth", "Crimson Planks", "Smooth Crimson Wood Planks")
                .addVariant("crimson_planks_large").translation("crimson_planks_large", "Crimson Planks", "Large Long Crimson Wood Planks")
                .addVariant("crimson_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("crimson_planks_log_bordered", "Crimson Planks", "Log Bordered Crimson Wood Panel")
                .addVariant("crimson_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("crimson_planks_log_cabin_ew", "Crimson Planks", "Crimson Wood Log Cabin (East-West)")
                .addVariant("crimson_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("crimson_planks_log_cabin_ns", "Crimson Planks", "Crimson Wood Log Cabin (North-South)")
                .addVariant("crimson_planks_paneling", ChiselModelHandlers.CONNECTED).translation("crimson_planks_paneling", "Crimson Planks", "Crimson Wood Panel")
                .addVariant("crimson_planks_shipping", ChiselModelHandlers.CONNECTED).translation("crimson_planks_shipping", "Crimson Planks", "Crimson Wood Crate")
                .addVariant("crimson_planks_smooth", ChiselModelHandlers.CONNECTED).translation("crimson_planks_smooth", "Crimson Planks", "Smooth Crimson Wood Planks")
                .addVariant("crimson_planks_stacked").translation("crimson_planks_stacked", "Crimson Planks", "Stacked Crimson Wood Tiles")
                .addVariant("crimson_planks_vertical").translation("crimson_planks_vertical", "Crimson Planks", "Vertical Crimson Wood Planks")
                .build());

        WARPED = ChiselFamily.build("warped_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS))
                .addVariant(Blocks.WARPED_PLANKS)
                .addVariant("warped_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("warped_planks_braced", "Warped Planks", "Warped Wood Panel")
                .addVariant("warped_planks_braid", ChiselModelHandlers.CONNECTED).translation("warped_planks_braid", "Warped Planks", "Warped Wood Braid")
                .addVariant("warped_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("warped_planks_crude_horizontal", "Warped Planks", "Vertical Warped Wood Planks in Disarray")
                .addVariant("warped_planks_crude_paneling").translation("warped_planks_crude_paneling", "Warped Planks", "Warped Wood Planks in Disarray")
                .addVariant("warped_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("warped_planks_crude_vertical", "Warped Planks", "Vertical Warped Wood Planks in Disarray")
                .addVariant("warped_planks_encased", ChiselModelHandlers.CONNECTED).translation("warped_planks_encased", "Warped Planks", "Encased Warped Wood Panel")
                .addVariant("warped_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("warped_planks_encased_large", "Warped Planks", "Large Long Warped Wood Planks")
                .addVariant("warped_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("warped_planks_encased_smooth", "Warped Planks", "Smooth Warped Wood Planks")
                .addVariant("warped_planks_large").translation("warped_planks_large", "Warped Planks", "Large Long Warped Wood Planks")
                .addVariant("warped_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("warped_planks_log_bordered", "Warped Planks", "Log Bordered Warped Wood Panel")
                .addVariant("warped_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("warped_planks_log_cabin_ns", "Warped Planks", "Warped Wood Log Cabin (North-South)")
                .addVariant("warped_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("warped_planks_log_cabin_ew", "Warped Planks", "Warped Wood Log Cabin (East-West)")
                .addVariant("warped_planks_paneling", ChiselModelHandlers.CONNECTED).translation("warped_planks_paneling", "Warped Planks", "Warped Wood Panel")
                .addVariant("warped_planks_shipping", ChiselModelHandlers.CONNECTED).translation("warped_planks_shipping", "Warped Planks", "Warped Wood Crate")
                .addVariant("warped_planks_smooth", ChiselModelHandlers.CONNECTED).translation("warped_planks_smooth", "Warped Planks", "Smooth Warped Wood Planks")
                .addVariant("warped_planks_stacked").translation("warped_planks_stacked", "Warped Planks", "Stacked Warped Wood Tiles")
                .addVariant("warped_planks_vertical").translation("warped_planks_vertical", "Warped Planks", "Vertical Warped Wood Planks")
                .build());

        DARK_OAK = ChiselFamily.build("dark_oak_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS))
                .addVariant(Blocks.DARK_OAK_PLANKS)
                .addVariant("dark_oak_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("dark_oak_planks_braced", "Dark Oak Planks", "Dark Oak Wood Panel")
                .addVariant("dark_oak_planks_braid", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_braid", "Dark Oak Planks", "Dark Oak Wood Braid")
                .addVariant("dark_oak_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("dark_oak_planks_crude_horizontal", "Dark Oak Planks", "Vertical Dark Oak Wood Planks in Disarray")
                .addVariant("dark_oak_planks_crude_paneling").translation("dark_oak_planks_crude_paneling", "Dark Oak Planks", "Dark Oak Wood Planks in Disarray")
                .addVariant("dark_oak_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("dark_oak_planks_crude_vertical", "Dark Oak Planks", "Vertical Dark Oak Wood Planks in Disarray")
                .addVariant("dark_oak_planks_encased", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_encased", "Dark Oak Planks", "Encased Dark Oak Wood Panel")
                .addVariant("dark_oak_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_encased_large", "Dark Oak Planks", "Large Long Dark Oak Wood Planks")
                .addVariant("dark_oak_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_encased_smooth", "Dark Oak Planks", "Smooth Dark Oak Wood Planks")
                .addVariant("dark_oak_planks_large").translation("dark_oak_planks_large", "Dark Oak Planks", "Large Long Dark Oak Wood Planks")
                .addVariant("dark_oak_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_log_bordered", "Dark Oak Planks", "Log Bordered Dark Oak Wood Panel")
                .addVariant("dark_oak_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_log_cabin_ns", "Dark Oak Planks", "Dark Oak Wood Log Cabin (North-South)")
                .addVariant("dark_oak_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_log_cabin_ew", "Dark Oak Planks", "Dark Oak Wood Log Cabin (East-West)")
                .addVariant("dark_oak_planks_paneling", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_paneling", "Dark Oak Planks", "Dark Oak Wood Panel")
                .addVariant("dark_oak_planks_shipping", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_shipping", "Dark Oak Planks", "Dark Oak Wood Crate")
                .addVariant("dark_oak_planks_smooth", ChiselModelHandlers.CONNECTED).translation("dark_oak_planks_smooth", "Dark Oak Planks", "Smooth Dark Oak Wood Planks")
                .addVariant("dark_oak_planks_stacked").translation("dark_oak_planks_stacked", "Dark Oak Planks", "Stacked Dark Oak Wood Tiles")
                .addVariant("dark_oak_planks_vertical").translation("dark_oak_planks_vertical", "Dark Oak Planks", "Vertical Dark Oak Wood Planks")
                .build());

        CHERRY = ChiselFamily.build("cherry_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS))
                .addVariant(Blocks.CHERRY_PLANKS)
                .addVariant("cherry_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("cherry_planks_braced", "Cherry Planks", "Cherry Wood Panel")
                .addVariant("cherry_planks_braid", ChiselModelHandlers.CONNECTED).translation("cherry_planks_braid", "Cherry Planks", "Cherry Wood Braid")
                .addVariant("cherry_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("cherry_planks_crude_horizontal", "Cherry Planks", "Vertical Cherry Wood Planks in Disarray")
                .addVariant("cherry_planks_crude_paneling").translation("cherry_planks_crude_paneling", "Cherry Planks", "Cherry Wood Planks in Disarray")
                .addVariant("cherry_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("cherry_planks_crude_vertical", "Cherry Planks", "Vertical Cherry Wood Planks in Disarray")
                .addVariant("cherry_planks_encased", ChiselModelHandlers.CONNECTED).translation("cherry_planks_encased", "Cherry Planks", "Encased Cherry Wood Panel")
                .addVariant("cherry_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("cherry_planks_encased_large", "Cherry Planks", "Large Long Cherry Wood Planks")
                .addVariant("cherry_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("cherry_planks_encased_smooth", "Cherry Planks", "Smooth Cherry Wood Planks")
                .addVariant("cherry_planks_large").translation("cherry_planks_large", "Cherry Planks", "Large Long Cherry Wood Planks")
                .addVariant("cherry_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("cherry_planks_log_bordered", "Cherry Planks", "Log Bordered Cherry Wood Panel")
                .addVariant("cherry_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("cherry_planks_log_cabin_ns", "Cherry Planks", "Cherry Wood Log Cabin (North-South)")
                .addVariant("cherry_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("cherry_planks_log_cabin_ew", "Cherry Planks", "Cherry Wood Log Cabin (East-West)")
                .addVariant("cherry_planks_paneling", ChiselModelHandlers.CONNECTED).translation("cherry_planks_paneling", "Cherry Planks", "Cherry Wood Panel")
                .addVariant("cherry_planks_shipping", ChiselModelHandlers.CONNECTED).translation("cherry_planks_shipping", "Cherry Planks", "Cherry Wood Crate")
                .addVariant("cherry_planks_smooth", ChiselModelHandlers.CONNECTED).translation("cherry_planks_smooth", "Cherry Planks", "Smooth Cherry Wood Planks")
                .addVariant("cherry_planks_stacked").translation("cherry_planks_stacked", "Cherry Planks", "Stacked Cherry Wood Tiles")
                .addVariant("cherry_planks_vertical").translation("cherry_planks_vertical", "Cherry Planks", "Vertical Cherry Wood Planks")
                .build());

        JUNGLE = ChiselFamily.build("jungle_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS))
                .addVariant(Blocks.JUNGLE_PLANKS)
                .addVariant("jungle_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("jungle_planks_braced", "Jungle Planks", "Jungle Wood Panel")
                .addVariant("jungle_planks_braid", ChiselModelHandlers.CONNECTED).translation("jungle_planks_braid", "Jungle Planks", "Jungle Wood Braid")
                .addVariant("jungle_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("jungle_planks_crude_horizontal", "Jungle Planks", "Vertical Jungle Wood Planks in Disarray")
                .addVariant("jungle_planks_crude_paneling").translation("jungle_planks_crude_paneling", "Jungle Planks", "Jungle Wood Planks in Disarray")
                .addVariant("jungle_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("jungle_planks_crude_vertical", "Jungle Planks", "Vertical Jungle Wood Planks in Disarray")
                .addVariant("jungle_planks_encased", ChiselModelHandlers.CONNECTED).translation("jungle_planks_encased", "Jungle Planks", "Encased Jungle Wood Panel")
                .addVariant("jungle_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("jungle_planks_encased_large", "Jungle Planks", "Large Long Jungle Wood Planks")
                .addVariant("jungle_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("jungle_planks_encased_smooth", "Jungle Planks", "Smooth Jungle Wood Planks")
                .addVariant("jungle_planks_large").translation("jungle_planks_large", "Jungle Planks", "Large Long Jungle Wood Planks")
                .addVariant("jungle_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("jungle_planks_log_bordered", "Jungle Planks", "Log Bordered Jungle Wood Panel")
                .addVariant("jungle_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("jungle_planks_log_cabin_ns", "Jungle Planks", "Jungle Wood Log Cabin (North-South)")
                .addVariant("jungle_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("jungle_planks_log_cabin_ew", "Jungle Planks", "Jungle Wood Log Cabin (East-West)")
                .addVariant("jungle_planks_paneling", ChiselModelHandlers.CONNECTED).translation("jungle_planks_paneling", "Jungle Planks", "Jungle Wood Panel")
                .addVariant("jungle_planks_shipping", ChiselModelHandlers.CONNECTED).translation("jungle_planks_shipping", "Jungle Planks", "Jungle Wood Crate")
                .addVariant("jungle_planks_smooth", ChiselModelHandlers.CONNECTED).translation("jungle_planks_smooth", "Jungle Planks", "Smooth Jungle Wood Planks")
                .addVariant("jungle_planks_stacked").translation("jungle_planks_stacked", "Jungle Planks", "Stacked Jungle Wood Tiles")
                .addVariant("jungle_planks_vertical").translation("jungle_planks_vertical", "Jungle Planks", "Vertical Jungle Wood Planks")
                .build());

        MANGROVE = ChiselFamily.build("mangrove_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS))
                .addVariant(Blocks.MANGROVE_PLANKS)
                .addVariant("mangrove_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("mangrove_planks_braced", "Mangrove Planks", "Mangrove Wood Panel")
                .addVariant("mangrove_planks_braid", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_braid", "Mangrove Planks", "Mangrove Wood Braid")
                .addVariant("mangrove_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("mangrove_planks_crude_horizontal", "Mangrove Planks", "Vertical Mangrove Wood Planks in Disarray")
                .addVariant("mangrove_planks_crude_paneling").translation("mangrove_planks_crude_paneling", "Mangrove Planks", "Mangrove Wood Planks in Disarray")
                .addVariant("mangrove_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("mangrove_planks_crude_vertical", "Mangrove Planks", "Vertical Mangrove Wood Planks in Disarray")
                .addVariant("mangrove_planks_encased", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_encased", "Mangrove Planks", "Encased Mangrove Wood Panel")
                .addVariant("mangrove_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_encased_large", "Mangrove Planks", "Large Long Mangrove Wood Planks")
                .addVariant("mangrove_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_encased_smooth", "Mangrove Planks", "Smooth Mangrove Wood Planks")
                .addVariant("mangrove_planks_large").translation("mangrove_planks_large", "Mangrove Planks", "Large Long Mangrove Wood Planks")
                .addVariant("mangrove_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_log_bordered", "Mangrove Planks", "Log Bordered Mangrove Wood Panel")
                .addVariant("mangrove_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_log_cabin_ns", "Mangrove Planks", "Mangrove Wood Log Cabin (North-South)")
                .addVariant("mangrove_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_log_cabin_ew", "Mangrove Planks", "Mangrove Wood Log Cabin (East-West)")
                .addVariant("mangrove_planks_paneling", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_paneling", "Mangrove Planks", "Mangrove Wood Panel")
                .addVariant("mangrove_planks_shipping", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_shipping", "Mangrove Planks", "Mangrove Wood Crate")
                .addVariant("mangrove_planks_smooth", ChiselModelHandlers.CONNECTED).translation("mangrove_planks_smooth", "Mangrove Planks", "Smooth Mangrove Wood Planks")
                .addVariant("mangrove_planks_stacked").translation("mangrove_planks_stacked", "Mangrove Planks", "Stacked Mangrove Wood Tiles")
                .addVariant("mangrove_planks_vertical").translation("mangrove_planks_vertical", "Mangrove Planks", "Vertical Mangrove Wood Planks")
                .build());

        OAK = ChiselFamily.build("oak_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))
                .addVariant(Blocks.OAK_PLANKS)
                .addVariant("oak_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("oak_planks_braced", "Oak Planks", "Oak Wood Panel")
                .addVariant("oak_planks_braid", ChiselModelHandlers.CONNECTED).translation("oak_planks_braid", "Oak Planks", "Oak Wood Braid")
                .addVariant("oak_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("oak_planks_crude_horizontal", "Oak Planks", "Vertical Oak Wood Planks in Disarray")
                .addVariant("oak_planks_crude_paneling").translation("oak_planks_crude_paneling", "Oak Planks", "Oak Wood Planks in Disarray")
                .addVariant("oak_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("oak_planks_crude_vertical", "Oak Planks", "Vertical Oak Wood Planks in Disarray")
                .addVariant("oak_planks_encased", ChiselModelHandlers.CONNECTED).translation("oak_planks_encased", "Oak Planks", "Encased Oak Wood Panel")
                .addVariant("oak_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("oak_planks_encased_large", "Oak Planks", "Large Long Oak Wood Planks")
                .addVariant("oak_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("oak_planks_encased_smooth", "Oak Planks", "Smooth Oak Wood Planks")
                .addVariant("oak_planks_large").translation("oak_planks_large", "Oak Planks", "Large Long Oak Wood Planks")
                .addVariant("oak_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("oak_planks_log_bordered", "Oak Planks", "Log Bordered Oak Wood Panel")
                .addVariant("oak_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("oak_planks_log_cabin_ns", "Oak Planks", "Oak Wood Log Cabin (North-South)")
                .addVariant("oak_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("oak_planks_log_cabin_ew", "Oak Planks", "Oak Wood Log Cabin (East-West)")
                .addVariant("oak_planks_paneling", ChiselModelHandlers.CONNECTED).translation("oak_planks_paneling", "Oak Planks", "Oak Wood Panel")
                .addVariant("oak_planks_shipping", ChiselModelHandlers.CONNECTED).translation("oak_planks_shipping", "Oak Planks", "Oak Wood Crate")
                .addVariant("oak_planks_smooth", ChiselModelHandlers.CONNECTED).translation("oak_planks_smooth", "Oak Planks", "Smooth Oak Wood Planks")
                .addVariant("oak_planks_stacked").translation("oak_planks_stacked", "Oak Planks", "Stacked Oak Wood Tiles")
                .addVariant("oak_planks_vertical").translation("oak_planks_vertical", "Oak Planks", "Vertical Oak Wood Planks")
                .build());

        PALE_OAK = ChiselFamily.build("pale_oak_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS))
                .addVariant(Blocks.PALE_OAK_PLANKS)
                .addVariant("pale_oak_planks_braced", ChiselModelHandlers.CONNECTED_TBS).translation("pale_oak_planks_braced", "Pale Oak Planks", "Pale Oak Wood Panel")
                .addVariant("pale_oak_planks_braid", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_braid", "Pale Oak Planks", "Pale Oak Wood Braid")
                .addVariant("pale_oak_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("pale_oak_planks_crude_horizontal", "Pale Oak Planks", "Vertical Pale Oak Wood Planks in Disarray")
                .addVariant("pale_oak_planks_crude_paneling").translation("pale_oak_planks_crude_paneling", "Pale Oak Planks", "Pale Oak Wood Planks in Disarray")
                .addVariant("pale_oak_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("pale_oak_planks_crude_vertical", "Pale Oak Planks", "Vertical Pale Oak Wood Planks in Disarray")
                .addVariant("pale_oak_planks_encased", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_encased", "Pale Oak Planks", "Encased Pale Oak Wood Panel")
                .addVariant("pale_oak_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_encased_large", "Pale Oak Planks", "Large Long Pale Oak Wood Planks")
                .addVariant("pale_oak_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_encased_smooth", "Pale Oak Planks", "Smooth Pale Oak Wood Planks")
                .addVariant("pale_oak_planks_large").translation("pale_oak_planks_large", "Pale Oak Planks", "Large Long Pale Oak Wood Planks")
                .addVariant("pale_oak_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_log_bordered", "Pale Oak Planks", "Log Bordered Pale Oak Wood Panel")
                .addVariant("pale_oak_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_log_cabin_ns", "Pale Oak Planks", "Pale Oak Wood Log Cabin (North-South)")
                .addVariant("pale_oak_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_log_cabin_ew", "Pale Oak Planks", "Pale Oak Wood Log Cabin (East-West)")
                .addVariant("pale_oak_planks_paneling", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_paneling", "Pale Oak Planks", "Pale Oak Wood Panel")
                .addVariant("pale_oak_planks_shipping", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_shipping", "Pale Oak Planks", "Pale Oak Wood Crate")
                .addVariant("pale_oak_planks_smooth", ChiselModelHandlers.CONNECTED).translation("pale_oak_planks_smooth", "Pale Oak Planks", "Smooth Pale Oak Wood Planks")
                .addVariant("pale_oak_planks_stacked").translation("pale_oak_planks_stacked", "Pale Oak Planks", "Stacked Pale Oak Wood Tiles")
                .addVariant("pale_oak_planks_vertical").translation("pale_oak_planks_vertical", "Pale Oak Planks", "Vertical Pale Oak Wood Planks")
                .build());

        SPRUCE = ChiselFamily.build("spruce_planks", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS))
                .addVariant(Blocks.SPRUCE_PLANKS)
                .addVariant("spruce_planks_braced").translation("spruce_planks_braced", "Spruce Planks", "Spruce Wood Panel")
                .addVariant("spruce_planks_braid", ChiselModelHandlers.CONNECTED).translation("spruce_planks_braid", "Spruce Planks", "Spruce Wood Braid")
                .addVariant("spruce_planks_crude_horizontal", ChiselModelHandlers.MULTIBLOCK_3X3).translation("spruce_planks_crude_horizontal", "Spruce Planks", "Vertical Spruce Wood Planks in Disarray")
                .addVariant("spruce_planks_crude_paneling").translation("spruce_planks_crude_paneling", "Spruce Planks", "Spruce Wood Planks in Disarray")
                .addVariant("spruce_planks_crude_vertical", ChiselModelHandlers.MULTIBLOCK_3X3).translation("spruce_planks_crude_vertical", "Spruce Planks", "Vertical Spruce Wood Planks in Disarray")
                .addVariant("spruce_planks_encased", ChiselModelHandlers.CONNECTED).translation("spruce_planks_encased", "Spruce Planks", "Encased Spruce Wood Panel")
                .addVariant("spruce_planks_encased_large", ChiselModelHandlers.CONNECTED).translation("spruce_planks_encased_large", "Spruce Planks", "Large Long Spruce Wood Planks")
                .addVariant("spruce_planks_encased_smooth", ChiselModelHandlers.CONNECTED).translation("spruce_planks_encased_smooth", "Spruce Planks", "Smooth Spruce Wood Planks")
                .addVariant("spruce_planks_large").translation("spruce_planks_large", "Spruce Planks", "Large Long Spruce Wood Planks")
                .addVariant("spruce_planks_log_bordered", ChiselModelHandlers.CONNECTED).translation("spruce_planks_log_bordered", "Spruce Planks", "Log Bordered Spruce Wood Panel")
                .addVariant("spruce_planks_log_cabin_ew", ChiselModelHandlers.CONNECTED).translation("spruce_planks_log_cabin_ew", "Spruce Planks", "Spruce Wood Log Cabin (East-West)")
                .addVariant("spruce_planks_log_cabin_ns", ChiselModelHandlers.CONNECTED).translation("spruce_planks_log_cabin_ns", "Spruce Planks", "Spruce Wood Log Cabin (North-South)")
                .addVariant("spruce_planks_paneling", ChiselModelHandlers.CONNECTED).translation("spruce_planks_paneling", "Spruce Planks", "Spruce Wood Panel")
                .addVariant("spruce_planks_shipping", ChiselModelHandlers.CONNECTED).translation("spruce_planks_shipping", "Spruce Planks", "Spruce Wood Crate")
                .addVariant("spruce_planks_smooth", ChiselModelHandlers.CONNECTED).translation("spruce_planks_smooth", "Spruce Planks", "Smooth Spruce Wood Planks")
                .addVariant("spruce_planks_stacked").translation("spruce_planks_stacked", "Spruce Planks", "Stacked Spruce Wood Tiles")
                .addVariant("spruce_planks_vertical").translation("spruce_planks_vertical", "Spruce Planks", "Vertical Spruce Wood Planks")
                .build());

        FAMILIES = List.of(ACACIA, BAMBOO, BIRCH, CHERRY, CRIMSON, DARK_OAK, JUNGLE, MANGROVE, OAK, PALE_OAK, SPRUCE, WARPED);

    }

    private WoodFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
