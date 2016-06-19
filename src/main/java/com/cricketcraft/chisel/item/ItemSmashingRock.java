package com.cricketcraft.chisel.item;

import com.cricketcraft.chisel.entity.EntitySmashingRock;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemSmashingRock extends BaseItem {
	public ItemSmashingRock() {
		super();
		setCreativeTab(ChiselTabs.tabChisel);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}

		if (world.isRemote)
			world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntitySmashingRock(world, player));
		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
