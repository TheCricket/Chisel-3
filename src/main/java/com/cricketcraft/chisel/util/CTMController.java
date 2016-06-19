package com.cricketcraft.chisel.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * This class controls connected textures for Chisel 3 by Cricket
 * This is only to be used in Cricket's mods
 * Please read the license if you have not yet. This is your warning
 */
public class CTMController {

    public CTMController() {

    }

    private boolean canBlocksConnect(World world, BlockVariant variant, BlockPos mainPos, BlockPos connectingPos) {
        if(world.getBlockState(mainPos).getProperties().containsValue(variant) && world.getBlockState(connectingPos).getProperties().containsValue(variant)) {
            return variant.hasConnectedTextures();
        } else {
            return false;
        }
    }
}
