package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.content.ChiselFamily;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class NeoVitaeFamilies {
    public static final ChiselFamily NV_RUNE;
    private static final List<ChiselFamily> FAMILIES;

    static {
        /* NV_DUNGEON_STONE = ChiselFamily.build("nv_dungeon_stone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                // .addVariant("neovitae_arranged", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_bricks", ChiselModelHandlers.TBS)
                // .addVariant("neovitae_carved")
                // .addVariant("neovitae_carved_radial")
                // .addVariant("neovitae_classic")
                // .addVariant("neovitae_classic_panel")
                // .addVariant("neovitae_diagonal_bricks")
                // .addVariant("neovitae_diagonal_bricks_0", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_1", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_2", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_3", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_tiles")
                .build());

        NV_DUNGEON_STONE_INVICTUS = ChiselFamily.build("nv_dungeon_stone_invictus", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                // .addVariant("neovitae_arranged", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_bricks", ChiselModelHandlers.TBS)
                // .addVariant("neovitae_carved")
                // .addVariant("neovitae_carved_radial")
                // .addVariant("neovitae_classic")
                // .addVariant("neovitae_classic_panel")
                // .addVariant("neovitae_diagonal_bricks")
                // .addVariant("neovitae_diagonal_bricks_0", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_1", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_2", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_3", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_tiles")
                .build());

        NV_DUNGEON_STONE_NIHILUM = ChiselFamily.build("nv_dungeon_stone_nihilum", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                // .addVariant("neovitae_arranged", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_bricks", ChiselModelHandlers.TBS)
                // .addVariant("neovitae_carved")
                // .addVariant("neovitae_carved_radial")
                // .addVariant("neovitae_classic")
                // .addVariant("neovitae_classic_panel")
                // .addVariant("neovitae_diagonal_bricks")
                // .addVariant("neovitae_diagonal_bricks_0", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_1", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_2", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_3", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_tiles")
                .build());

        NV_DUNGEON_STONE_RUINA = ChiselFamily.build("nv_dungeon_stone_ruina", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                // .addVariant("neovitae_arranged", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_bricks", ChiselModelHandlers.TBS)
                // .addVariant("neovitae_carved")
                // .addVariant("neovitae_carved_radial")
                // .addVariant("neovitae_classic")
                // .addVariant("neovitae_classic_panel")
                // .addVariant("neovitae_diagonal_bricks")
                // .addVariant("neovitae_diagonal_bricks_0", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_1", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_2", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_3", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_tiles")
                .build());

        NV_DUNGEON_STONE_VINDICTA = ChiselFamily.build("nv_dungeon_stone_vindicta", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                // .addVariant("neovitae_arranged", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_bricks", ChiselModelHandlers.TBS)
                // .addVariant("neovitae_carved")
                // .addVariant("neovitae_carved_radial")
                // .addVariant("neovitae_classic")
                // .addVariant("neovitae_classic_panel")
                // .addVariant("neovitae_diagonal_bricks")
                // .addVariant("neovitae_diagonal_bricks_0", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_1", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_2", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_3", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_tiles")
                .build());

        NV_RITUAL_STONE = ChiselFamily.build("nv_ritual_stone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                // .addVariant("neovitae_arranged", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_bricks", ChiselModelHandlers.TBS)
                // .addVariant("neovitae_carved")
                // .addVariant("neovitae_carved_radial")
                // .addVariant("neovitae_classic")
                // .addVariant("neovitae_classic_panel")
                // .addVariant("neovitae_diagonal_bricks")
                // .addVariant("neovitae_diagonal_bricks_0", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_1", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_2", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_diagonal_bricks_3", ChiselModelHandlers.CONNECTED)
                // .addVariant("neovitae_tiles")
                .build());

        */

        NV_RUNE = ChiselFamily.build("nv_rune", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .addVariant("neovitae_arranged", ChiselModelHandlers.CONNECTED).translation("neovitae_arranged", "Blank Rune", "Arranged")
                .addVariant("neovitae_bricks", ChiselModelHandlers.TBS).translation("neovitae_bricks", "Blank Rune", "Blank Rune Bricks")
                .addVariant("neovitae_carved").translation("neovitae_carved", "Blank Rune", "Carved Blank Rune")
                .addVariant("neovitae_carved_radial").translation("neovitae_carved_radial", "Blank Rune", "Radial Carved Rune")
                .addVariant("neovitae_classic").translation("neovitae_classic", "Blank Rune", "Classic")
                .addVariant("neovitae_classic_panel").translation("neovitae_classic_panel", "Blank Rune", "Classic Panel")
                .addVariant("neovitae_diagonal_bricks").translation("neovitae_diagonal_bricks", "Blank Rune", "Diagonal Rune Bricks")
                .addVariant("neovitae_diagonal_bricks_0", ChiselModelHandlers.CONNECTED).translation("neovitae_diagonal_bricks_0", "Blank Rune", "Diagonal Rune Bricks")
                .addVariant("neovitae_diagonal_bricks_1", ChiselModelHandlers.CONNECTED).translation("neovitae_diagonal_bricks_1", "Blank Rune", "Diagonal Rune Bricks")
                .addVariant("neovitae_diagonal_bricks_2", ChiselModelHandlers.CONNECTED).translation("neovitae_diagonal_bricks_2", "Blank Rune", "Diagonal Rune Bricks")
                .addVariant("neovitae_diagonal_bricks_3", ChiselModelHandlers.CONNECTED).translation("neovitae_diagonal_bricks_3", "Blank Rune", "Diagonal Rune Bricks")
                .addVariant("neovitae_tiles").translation("neovitae_tiles", "Blank Rune", "Tiles")
                .build());

        FAMILIES = List.of(NV_RUNE);
    }

    private NeoVitaeFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
