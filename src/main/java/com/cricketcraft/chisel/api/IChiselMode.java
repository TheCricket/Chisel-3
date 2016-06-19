package com.cricketcraft.chisel.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IChiselMode {

    /**
     * Chisel the blocks in world
     * @param player Player chiseling
     * @param world World OBJ
     * @param pos Pos of the initial left click
     * @param facing Side facing you
     * @param recipe Recipe of variations
     */
    void chisel(EntityPlayer player, World world, BlockPos pos, EnumFacing facing, ICarvingRecipe recipe);

    /**
     * Name for the mode
     * @return
     */
    String name();

    IChiselMode next();
}
