package com.cricketcraft.chisel.block.other;

import com.cricketcraft.chisel.block.variant.BlockVariants;
import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IChiselBlock;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChiselBlockPumpkin extends BlockDirectional implements IChiselBlock {

    public ChiselBlockPumpkin() {
        super(Material.GOURD);
        this.setTickRandomly(true);
        this.setSoundType(SoundType.WOOD);
        setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ChiselProperties.PUMPKIN_VARIANTS, BlockVariants.PUMPKIN_0));
    }

    @Override
    public boolean isToolEffective(String type, IBlockState state) {
        return type.equals("axe");
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {

    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (BlockVariant variant : ChiselProperties.PUMPKIN_VARIANTS.getAllowedValues()) {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(ChiselProperties.PUMPKIN_VARIANTS, ChiselProperties.PUMPKIN_VARIANTS.fromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockVariant) state.getValue(ChiselProperties.PUMPKIN_VARIANTS)).getMeta() + ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((BlockVariant) state.getValue(ChiselProperties.PUMPKIN_VARIANTS)).getMeta();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ChiselProperties.PUMPKIN_VARIANTS, FACING);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getStateFromMeta(meta).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        return new ItemStack(this, 1, ((BlockVariant) state.getValue(ChiselProperties.PUMPKIN_VARIANTS)).getMeta());
    }

    @Override
    public String getSubtypeUnlocalizedName(ItemStack stack) {
        return ChiselProperties.PUMPKIN_VARIANTS.fromMeta(stack.getMetadata()).getName();
    }
}
