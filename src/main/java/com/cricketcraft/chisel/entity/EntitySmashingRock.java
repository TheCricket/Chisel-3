package com.cricketcraft.chisel.entity;

import com.cricketcraft.chisel.init.ChiselSound;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class EntitySmashingRock extends EntityThrowable {
	public EntitySmashingRock(World par1World) {
		super(par1World);
	}

	public EntitySmashingRock(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntitySmashingRock(World par1World, double x, double y, double z) {
		super(par1World, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult mop) {
		BlockPos pos = mop.getBlockPos();
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		switch (mop.sideHit.getIndex()) {
		case 0:
			y--;
			break;
		case 1:
			y++;
			break;
		case 2:
			z--;
			break;
		case 3:
			z++;
			break;
		case 4:
			x--;
			break;
		case 5:
			x++;
			break;
		}

		setDead();

		if (worldObj.isRemote) {
			worldObj.playSound((EntityPlayer) null, x, y, z, ChiselSound.ballomoss, SoundCategory.NEUTRAL, 1.0f, 1.0f);

			return;
		}

		int radius = 5;
		int falloff = 3;

		for (int xx = -radius; xx < radius; xx++) {
			for (int yy = -radius; yy < radius; yy++) {
				for (int zz = -radius; zz < radius; zz++) {
					double dist = (xx < 0 ? -xx : xx) + (yy < 0 ? -yy : yy) + (zz < 0 ? -zz : zz);

					if (!(dist < falloff || new Random().nextInt(radius * 3 - falloff) >= dist * 2))
						continue;

					if (!worldObj.isRemote)
						smash(worldObj, x + xx, y + yy, z + zz);
				}
			}
		}

	}

	public static void smash(World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		int meta = block.getMetaFromState(state);
		Block resBlock = block;
		int resMeta = meta;

		if (block.equals(Blocks.STONE)) {
			resBlock = Blocks.COBBLESTONE;
		} else if (block.equals(Blocks.STONEBRICK) && meta == 0) {
			resMeta = 2;
		} else if (block.equals(Blocks.COBBLESTONE)) {
			resBlock = Blocks.GRAVEL;
		} else if (block.equals(Blocks.GRAVEL)) {
			resBlock = Blocks.SAND;
		}

		if (resBlock.equals(block) && resMeta == meta)
			return;
		world.setBlockState(pos, resBlock.getStateFromMeta(resMeta), 3);
	}

}
