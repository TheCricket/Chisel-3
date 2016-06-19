package com.cricketcraft.chisel.block.other;

import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IChiselBlock;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChiselBlockCarvableTorch extends BlockTorch implements IChiselBlock {

    public ChiselBlockCarvableTorch() {
        super();
        setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
        setDefaultState(getBlockState().getBaseState().withProperty(ChiselProperties.TORCH_VARIANTS, ChiselProperties.TORCH_VARIANTS.fromMeta(0)).withProperty(FACING, EnumFacing.UP));
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        this.checkForDrop(worldIn, pos, state);
    }

    @Override
    protected boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state) {
        if (state.getBlock() == this && canPlaceAt(worldIn, pos, state.getValue(FACING))) {
            return true;
        } else {
            if (worldIn.getBlockState(pos).getBlock() == this) {
                this.dropBlockAsItem(worldIn, pos, state, 0);
                worldIn.setBlockToAir(pos);
            }

            return false;
        }
    }

    private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing) {
        BlockPos blockpos = pos.offset(facing.getOpposite());
        boolean flag = facing.getAxis().isHorizontal();
        return flag && worldIn.isSideSolid(blockpos, facing, true) || facing.equals(EnumFacing.UP) && canPlaceOn(worldIn, blockpos);
    }

    private boolean canPlaceOn(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.isSideSolid(world, pos, EnumFacing.UP)) {
            return true;
        } else {
            return state.getBlock().canPlaceTorchOnTop(state, world, pos);
        }
    }

    @Override
    protected boolean onNeighborChangeInternal(World worldIn, BlockPos pos, IBlockState state) {
        if (!this.checkForDrop(worldIn, pos, state)) {
            return true;
        } else {
            EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
            EnumFacing.Axis enumfacing$axis = enumfacing.getAxis();
            EnumFacing enumfacing1 = enumfacing.getOpposite();
            boolean flag = false;

            if (enumfacing$axis.isHorizontal() && !worldIn.isSideSolid(pos.offset(enumfacing1), enumfacing, true)) {
                flag = true;
            } else if (enumfacing$axis.isVertical() && !this.canPlaceOn(worldIn, pos.offset(enumfacing1))) {
                flag = true;
            }

            if (flag) {
                this.dropBlockAsItem(worldIn, pos, state, 0);
                worldIn.setBlockToAir(pos);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (BlockVariant variant : ChiselProperties.TORCH_VARIANTS.getAllowedValues()) {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        return getDefaultState().withProperty(ChiselProperties.TORCH_VARIANTS, ChiselProperties.TORCH_VARIANTS.fromMeta(0)).withProperty(FACING, EnumFacing.UP);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(ChiselProperties.TORCH_VARIANTS, ChiselProperties.TORCH_VARIANTS.fromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockVariant) state.getValue(ChiselProperties.TORCH_VARIANTS)).getMeta();
    }

    @Override
    public String getSubtypeUnlocalizedName(ItemStack stack) {
        return ChiselProperties.TORCH_VARIANTS.fromMeta(stack.getMetadata()).getName();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ChiselProperties.TORCH_VARIANTS, FACING);
    }
}
