package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.content.ChiselFamily;

import java.util.List;

public class AetherIIFamilies {
    private static final List<ChiselFamily> FAMILIES;

    static {
        /* AII_AGIOSITE = ChiselFamily.build("aii_agiosite", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_AMBEROOT = ChiselFamily.build("aii_amberoot", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_FADED_HOLYSTONE = ChiselFamily.build("aii_faded_holystone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_HOLYSTONE = ChiselFamily.build("aii_holystone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_ICESTONE = ChiselFamily.build("aii_icestone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_CHORITE = ChiselFamily.build("aii_ichorite", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_MARBLED = ChiselFamily.build("aii_marbled", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_SKYROOT = ChiselFamily.build("aii_skyroot", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_UNDERSHALE = ChiselFamily.build("aii_undershale", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_WISPROOT = ChiselFamily.build("aii_wisproot", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        AII_GREATROOT = ChiselFamily.build("aii_greatroot", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());

        */
        FAMILIES = List.of();
    }

    private AetherIIFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
