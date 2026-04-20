package chisel.client.ctm.logic;

import net.minecraft.core.BlockPos;

public enum CTMLogicAR {
    T0, T1, T2, T3;

    public static CTMLogicAR get(BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        // Simple position-based hashing for seed
        long seed = (long)x * 3129871L ^ (long)z * 116129781L ^ (long)y;
        seed = seed * seed * 42317861L + seed * 11L;
        
        int num = ((seed & 1) == 0) ? 0 : 2;
        boolean type = x % 2 != 0;
        if (y % 2 == 0) type = !type;
        if (z % 2 == 0) type = !type;
        
        num += type ? 0 : 1;
        return values()[num % 4];
    }
}
