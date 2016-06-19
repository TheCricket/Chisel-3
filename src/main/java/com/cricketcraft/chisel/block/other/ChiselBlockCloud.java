package com.cricketcraft.chisel.block.other;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.block.variant.BlockVariants;
import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IChiselBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChiselBlockCloud extends BlockCarvable implements IChiselBlock {

    public ChiselBlockCloud() {
        super(Material.ICE);
        setHardness(0.2F);
        setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
        setLightOpacity(3);
        setSoundType(SoundType.CLOTH);
        useNeighborBrightness = true;
        setDefaultState(this.getBlockState().getBaseState().withProperty(ChiselProperties.CLOUD_VARIANTS, BlockVariants.CLOUD_NORMAL));
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        entity.fallDistance = 0.0F;

        if (entity.motionY < 0.0D) {
            entity.motionY *= 0.0050000000000000001D;
        } else if (entity.motionY > 0) {
            entity.motionY += 0.0285;
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        Block block = world.getBlockState(pos).getBlock();
        if (block == this) {
            return false;
        }

        return super.shouldSideBeRendered(state, world, pos, side);
    }

//    @SideOnly(Side.CLIENT)
//    @Override
//    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World world, BlockPos pos) {
//        return state.getBoundingBox(world, pos).offset(pos);
//    }
//
//    @Override
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
//        return new AxisAlignedBB(pos.getX() + 0.2, pos.getY(), pos.getZ() + 0.2, pos.getX() + 0.8, pos.getY() + 0.2, pos.getZ() + 0.8);
//    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (BlockVariant variant : ChiselProperties.CLOUD_VARIANTS.getAllowedValues()) {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(ChiselProperties.CLOUD_VARIANTS, ChiselProperties.CLOUD_VARIANTS.fromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockVariant) state.getValue(ChiselProperties.CLOUD_VARIANTS)).getMeta();
    }

    @Override
    public String getSubtypeUnlocalizedName(ItemStack stack) {
        return ChiselProperties.CLOUD_VARIANTS.fromMeta(stack.getMetadata()).getName();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ChiselProperties.CLOUD_VARIANTS);
    }
}
