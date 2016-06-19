package com.cricketcraft.chisel.block.other;

import com.cricketcraft.chisel.block.BlockCarvablePane;
import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IChiselBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChiselBlockIronBars extends BlockCarvablePane implements IChiselBlock {
    public ChiselBlockIronBars() {
        super(Material.IRON);
        setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
        //TODO: getActualState()
        setDefaultState(this.getBlockState().getBaseState().withProperty(ChiselProperties.IRON_BARS_VARIANTS, ChiselProperties.IRON_BARS_VARIANTS.fromMeta(0)));
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (BlockVariant variant : ChiselProperties.IRON_BARS_VARIANTS.getAllowedValues()) {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(ChiselProperties.IRON_BARS_VARIANTS, ChiselProperties.IRON_BARS_VARIANTS.fromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockVariant) state.getValue(ChiselProperties.IRON_BARS_VARIANTS)).getMeta();
    }

    @Override
    public String getSubtypeUnlocalizedName(ItemStack stack) {
        return ChiselProperties.IRON_BARS_VARIANTS.fromMeta(stack.getMetadata()).getName();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ChiselProperties.IRON_BARS_VARIANTS, NORTH, SOUTH, EAST, WEST);
    }
}
