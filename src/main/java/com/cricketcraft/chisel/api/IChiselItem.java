package com.cricketcraft.chisel.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Implement this on items which can be used to chisel blocks
 */
public interface IChiselItem {

	/**
	 * Checks whether the chisel can have its GUI opened
	 *
	 * @param world
	 * 			{@link World} object
	 * @param player
	 * 			{@link EntityPlayer} The player holding the chisel. it can always be assumed that the player's current item will be this.
	 * @param chisel
	 * 			The {@link ItemStack} representing the chisel
	 * @return True if the GUI should open, False otherwises
	 */
	boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel);

	/**
	 * Allows you to control the mode if your item has chiseling modes.
	 *
	 * @param chisel
	 *            The {@link ItemStack} representing the chisel.
	 * @return True if the chisel supports modes. False otherwise.
	 */
	boolean hasModes(ItemStack chisel);

	/**
	 * Gets the current mode
	 * @param chisel
	 * @param name
     * @return
     */
	IChiselMode getMode(EntityPlayer player, String name);
}
