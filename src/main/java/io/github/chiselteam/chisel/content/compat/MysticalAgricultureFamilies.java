package io.github.chiselteam.chisel.content.compat;

// import io.github.chiselteam.chisel.api.model.ChiselModelHandlers;
import io.github.chiselteam.chisel.content.ChiselFamily;
// import net.minecraft.world.level.block.Blocks;
// import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

@org.jetbrains.annotations.ApiStatus.Internal
public class MysticalAgricultureFamilies {
    // public static final ChiselFamily MA_SOULSTONE;
    private static final List<ChiselFamily> FAMILIES;

    static {
        // MA_SOULSTONE = ChiselFamily.build("ma_soulstone", builder -> builder
        //         .properties(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
        //         .build());
       

        FAMILIES = List.of(/* MA_SOULSTONE */);
    }
    
    private MysticalAgricultureFamilies() {
    }

    public static List<ChiselFamily> families() {
        return FAMILIES;
    }
}
