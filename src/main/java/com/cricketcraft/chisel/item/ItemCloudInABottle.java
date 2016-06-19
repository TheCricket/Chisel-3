package com.cricketcraft.chisel.item;

import com.cricketcraft.chisel.entity.EntityCloudInABottle;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCloudInABottle extends BaseItem {
	public ItemCloudInABottle() {
		super();
		setCreativeTab(ChiselTabs.tabChisel);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}

		if (world.isRemote) {
			world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		}

		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityCloudInABottle(world, player));
		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
