package chisel.util;

import chisel.core.VariantFamily;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class VariantFinder {

    public static VariantFamily getFamilyForBlock(Block block, List<VariantFamily> families) {
        for (VariantFamily family : families) {
            if(family.isBlockInFamily(block)) {
                return family;
            }
        }

        return null;
    }
}
