package io.github.chiselteam.chisel.content.compat;

import io.github.chiselteam.chisel.content.ChiselFamily;

import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class MysticalAgricultureFamilies {
    private static final List<ChiselFamily> FAMILIES;

    static {
        /* MA_SOULSTONE = ChiselFamily.build("ma_soulstone", builder -> builder
                .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
                .build());
        */

        FAMILIES = List.of();
    }

    private MysticalAgricultureFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
