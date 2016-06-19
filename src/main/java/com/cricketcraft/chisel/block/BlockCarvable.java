package com.cricketcraft.chisel.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCarvable extends Block {

//    public static final PropertyBool CONNECTS_NORTH = PropertyBool.create("north");
//    public static final PropertyBool CONNECTS_EAST = PropertyBool.create("east");
//    public static final PropertyBool CONNECTS_SOUTH = PropertyBool.create("south");
//    public static final PropertyBool CONNECTS_WEST = PropertyBool.create("west");
//    public static final PropertyBool CONNECTS_UP = PropertyBool.create("up");
//    public static final PropertyBool CONNECTS_DOWN = PropertyBool.create("down");

    public BlockCarvable(Material material, MapColor mapColor) {
        super(material, mapColor);
        setHardness(2.0F);
        setResistance(5.0F);
    }

    public BlockCarvable(Material material) {
        super(material);
        setHardness(2.0F);
        setResistance(5.0F);
    }

    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }
}
