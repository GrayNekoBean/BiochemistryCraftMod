package cn.BiochemistryCraft.GUI;

import cn.BiochemistryCraft.Item.ItemBs;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class CraftingBioExtracter {
	public static int getBioTime(ItemStack itemstack)
	{
		Item item=itemstack.getItem();
		if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
		{
			Block block=Block.getBlockFromItem(item);
			if(block==BCCRegisterBlock.biodirt)
				return 500;
		}
		return 0;
	}
	
	public static ItemStack getBioItem(ItemStack itemstack)
	{
		Item item=itemstack.getItem();
		if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
		{
			
		}
		if(item instanceof ItemBs)
		{
			for(int i=0;i<22;i++)
				if(item==BCCRegisterItem.bloodgr[i])
					return new ItemStack(BCCRegisterItem.bloodes[i]);
		}
		
		return null;
	}
}

