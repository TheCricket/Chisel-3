package com.cricketcraft.chisel.block.metal;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockCarvableMetal extends BlockCarvable {

    public BlockCarvableMetal() {
        super(Material.IRON);
        //setSoundType(ChiselSound.soundTypeChiselMetal);
        setCreativeTab(ChiselTabs.tabMetalChiselBlocks);
    }

    @Override
    public boolean isToolEffective(String type, IBlockState state) {
        return type.equals("pickaxe");
    }
}
