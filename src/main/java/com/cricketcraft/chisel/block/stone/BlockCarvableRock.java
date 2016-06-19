package com.cricketcraft.chisel.block.stone;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockCarvableRock extends BlockCarvable {

    public BlockCarvableRock() {
        super(Material.ROCK);
        setCreativeTab(ChiselTabs.tabStoneChiselBlocks);
    }

    @Override
    public boolean isToolEffective(String type, IBlockState state) {
        return type.equals("pickaxe");
    }
}
