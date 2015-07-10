package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.item.Item;

public class BCCItemBase extends Item {
	public BCCItemBase()
	{
		//TODO 物品数据
	}
	
	protected void setItem(String str,boolean hasCreativeTab)
	{
		this.setUnlocalizedName(str);
		this.setTextureName(BiochemistryCraft.MODID+":"+str);
		if(hasCreativeTab)
			this.setCreativeTab(BiochemistryCraft.biocreativetab);
	}
}
