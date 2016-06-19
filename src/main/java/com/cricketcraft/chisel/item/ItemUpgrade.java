package com.cricketcraft.chisel.item;

import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.IItemWithVariants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

import java.util.List;

public class ItemUpgrade extends BaseItem implements IItemWithVariants {
	public static String[] variantNames = new String[]{"speed", "automation", "stack", "reversion"};

	public ItemUpgrade() {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setCreativeTab(ChiselTabs.tabChisel);
	}

	@Override
	public String[] getVariantNames() {
		return variantNames;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, variantNames.length);
		return getUnlocalizedName() + "_" + variantNames[arr];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item id, CreativeTabs tab, List list) {
		for (int i = 0; i < variantNames.length; i++)
			list.add(new ItemStack(id, 1, i));
	}

}
