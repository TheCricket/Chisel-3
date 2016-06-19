package com.cricketcraft.chisel.block.wood;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockCarvableWood extends BlockCarvable {

    public BlockCarvableWood() {
        super(Material.WOOD);
        setCreativeTab(ChiselTabs.tabWoodChiselBlocks);
    }

    @Override
    public boolean isToolEffective(String type, IBlockState state) {
        return type.equals("axe");
    }
}
