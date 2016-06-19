package com.cricketcraft.chisel.block.other.stained.panes;

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
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChiselBlockStainedGlassPaneLightGray extends BlockCarvablePane implements IChiselBlock {
    public ChiselBlockStainedGlassPaneLightGray() {
        super(Material.GLASS);
        setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
        setDefaultState(this.getBlockState().getBaseState().withProperty(ChiselProperties.STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS, ChiselProperties.STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS.fromMeta(0)));
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (BlockVariant variant : ChiselProperties.STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS.getAllowedValues()) {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(ChiselProperties.STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS, ChiselProperties.STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS.fromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockVariant) state.getValue(ChiselProperties.STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS)).getMeta();
    }

    @Override
    public String getSubtypeUnlocalizedName(ItemStack stack) {
        return ChiselProperties.STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS.fromMeta(stack.getMetadata()).getName();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ChiselProperties.STAINED_GLASS_PANE_LIGHT_GRAY_VARIANTS, NORTH, SOUTH, EAST, WEST);
    }
}
