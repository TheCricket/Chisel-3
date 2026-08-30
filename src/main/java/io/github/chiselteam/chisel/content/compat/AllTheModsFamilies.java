package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.content.ChiselFamily;

import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class AllTheModsFamilies {
    private static final List<ChiselFamily> FAMILIES;

    static {
        /* ATM_ALLTHEMODIUM = ChiselFamily.build("atm_allthemodium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        ATM_UNOBTAINIUM_ALLTHEMODIUM = ChiselFamily.build("atm_unobtainium_allthemodium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        ATM_UNOBTAINIUM = ChiselFamily.build("atm_unobtainium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        ATM_UNOBTAINIUM_VIBRANIUM = ChiselFamily.build("atm_unobtainium_vibranium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        ATM_VIBRANIUM_ALLTHEMODIUM = ChiselFamily.build("atm_vibranium_allthemodium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        ATM_VIBRANIUM = ChiselFamily.build("atm_vibranium", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
                .build());

        */
        FAMILIES = List.of();
    }

    private AllTheModsFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
